package com.smart.www.agent;

import com.smart.www.advisor.MyLoggerAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Component;

@Component
public class YuManus extends ToolCallAgent {

    public YuManus(ToolCallback[] allTools, ChatModel dashscopeChatModel) {
        super(allTools);
        this.setName("yuManus");
        // 简化提示词，减少 token 消耗
        String SYSTEM_PROMPT = "You are YuManus, an AI assistant with access to tools. Use them efficiently to complete tasks.";
        this.setSystemPrompt(SYSTEM_PROMPT);

        // 简化下一步提示
        String NEXT_STEP_PROMPT = "Select appropriate tools to complete the task. Call terminate when done.";
        this.setNextStepPrompt(NEXT_STEP_PROMPT);

        // 减少最大步骤数，避免过多调用
        this.setMaxSteps(10);
        // 初始化客户端  
        ChatClient chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultAdvisors(new MyLoggerAdvisor())
                .build();
        this.setChatClient(chatClient);
    }
}
