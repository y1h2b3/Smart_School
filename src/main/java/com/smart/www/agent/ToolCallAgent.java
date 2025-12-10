package com.smart.www.agent;

import com.smart.www.agent.model.AgentState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.tool.ToolCallback;

/**
 * 处理工具调用的基础代理类，具体实现了 think 和 act 方法，可以用作创建实例的父类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class ToolCallAgent extends ReActAgent {

    // 可用的工具  
    private final ToolCallback[] availableTools;

    // 保存了工具调用信息的响应  
    private ChatResponse lastChatResponse;

    public ToolCallAgent(ToolCallback[] availableTools) {
        super();
        this.availableTools = availableTools;
    }


    /**
     * 处理当前状态并决定下一步行动
     * Spring AI 会自动处理工具调用，所以我们只需要调用一次
     *
     * @return 总是返回 false，因为工具执行已经在 think 中完成
     */
    @Override
    public boolean think() {
        try {
            // 添加下一步提示（如果有）
            if (getNextStepPrompt() != null && !getNextStepPrompt().isEmpty()) {
                getMessageList().add(new UserMessage(getNextStepPrompt()));
            }

            // 调用 AI，Spring AI 会自动处理工具调用
            ChatResponse chatResponse = getChatClient()
                    .prompt()
                    .system(getSystemPrompt())
                    .messages(getMessageList())
                    .toolCallbacks(availableTools)
                    .call()
                    .chatResponse();

            // 保存响应
            this.lastChatResponse = chatResponse;
            AssistantMessage assistantMessage = chatResponse.getResult().getOutput();

            // 输出日志
            String responseText = assistantMessage.getText();
            log.info("{}  AI 响应: {}", getName(), responseText);

            // 将 AI 响应添加到消息列表
            getMessageList().add(assistantMessage);

            // 检查是否需要终止
            if (responseText != null && (
                    responseText.contains("任务完成") ||
                            responseText.contains("已完成") ||
                            responseText.contains("terminate") ||
                            responseText.contains("结束")
            )) {
                setState(AgentState.FINISHED);
                log.info("{} 检测到任务完成信号", getName());
            }

            // Spring AI 已经自动执行了工具，所以不需要 act
            return false;

        } catch (Exception e) {
            String errorMsg = e.getMessage();
            log.error("{} 思考过程出错: {}", getName(), errorMsg, e);

            // 检测致命错误，立即终止
            if (isFatalError(errorMsg)) {
                log.error("{} 遇到致命错误，终止执行", getName());
                setState(AgentState.ERROR);
                getMessageList().add(new AssistantMessage("系统错误，无法继续: " + errorMsg));
                return false;
            }

            // 非致命错误，记录并继续
            getMessageList().add(new AssistantMessage("处理时遇到错误: " + errorMsg));
            return false;
        }
    }

    /**
     * 判断是否为致命错误（需要立即终止执行）
     */
    private boolean isFatalError(String errorMsg) {
        if (errorMsg == null) {
            return false;
        }

        // API 配额耗尽
        if (errorMsg.contains("AllocationQuota") ||
                errorMsg.contains("FreeTierOnly") ||
                errorMsg.contains("Quota.Exceed")) {
            return true;
        }

        // 认证失败
        if (errorMsg.contains("Unauthorized") ||
                errorMsg.contains("Invalid API Key") ||
                errorMsg.contains("403")) {
            return true;
        }

        // 网络故障（多次重试后仍然失败）
        if (errorMsg.contains("Connection refused") ||
                errorMsg.contains("Connection timeout")) {
            return true;
        }

        return false;
    }

    /**
     * 执行行动（工具已经在 think 中自动执行）
     * 这个方法不会被调用，因为 think() 总是返回 false
     *
     * @return 执行结果
     */
    @Override
    public String act() {
        return "工具已经在 think 阶段自动执行";
    }


}
