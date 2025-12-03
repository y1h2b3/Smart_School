package com.smart.www.app;

import com.smart.www.advisor.MyLoggerAdvisor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LoveApp {

    // 系统提示词：定义 AI 的人设和回复逻辑
    private static final String SYSTEM_PROMPT = "扮演深耕恋爱心理领域的专家。开场向用户表明身份，告知用户可倾诉恋爱难题。" +
            "围绕单身、恋爱、已婚三种状态提问：单身状态询问社交圈拓展及追求心仪对象的困扰；" +
            "恋爱状态询问沟通、习惯差异引发的矛盾；已婚状态询问家庭责任与亲属关系处理的问题。" +
            "引导用户详述事情经过、对方反应及自身想法，以便给出专属解决方案。";
    private final ChatClient chatClient;
    @Resource
    private VectorStore loveAppVectorStore;

    @Resource
    @Qualifier("loveAppCompositeRagAdvisor")
    private Advisor compositeRagAdvisor;

    public LoveApp(ChatModel dashscopeChatModel) {
        // 1. 初始化基于内存的对话记忆 (Window 模式)
        // MessageWindowChatMemory: 滑动窗口记忆，只保留最近 N 条消息，避免 token 超限
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository()) // 存储在内存中（重启丢失）
                .maxMessages(20) // 保留最近 20 条消息
                .build();

        // 2. 构建 ChatClient
        chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultSystem(SYSTEM_PROMPT) // 设置默认系统人设
                .defaultAdvisors(
                        // 启用对话记忆 Advisor，自动管理历史消息
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),

                        // 自定义日志 Advisor (优先级最高，记录原始请求)
                        new MyLoggerAdvisor()

                        // 自定义 Re2 Advisor (增强推理能力，重读问题)
                        // new ReReadingAdvisor()
                )
                .build();
    }

    /**
     * 普通对话接口
     * 返回纯文本字符串
     */
    public String doChat(String message, String chatId) {
        String content = chatClient
                .prompt()
                .user(message) // 用户输入
                // 传入会话 ID，用于区分不同用户的记忆
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .call() // 发起同步调用
                .content(); // 获取文本内容
        log.info("content: {}", content);
        return content;
    }

    /**
     * 生成结构化报告接口
     * 返回 LoveReport 对象
     */
    public LoveReport doChatWithReport(String message, String chatId) {
        LoveReport loveReport = chatClient
                .prompt()
                // 在系统提示词基础上，追加输出格式要求
                .system(SYSTEM_PROMPT + "每次对话后都要生成恋爱结果，标题为{用户名}的恋爱报告，内容为建议列表")
                .user(message)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .entity(LoveReport.class); // 自动将 JSON 转换为 Java 对象
        log.info("loveReport: {}", loveReport);
        return loveReport;
    }

    /**
     * 使用 RAG（检索增强生成）进行对话 - 仅本地向量库
     * 结合本地向量数据库知识库和对话记忆
     */
    public String doChatWithLocalRag(String message, String chatId) {

        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository()) // 存储在内存中（重启丢失）
                .maxMessages(20) // 保留最近 20 条消息
                .build();

        ChatResponse chatResponse = chatClient
                .prompt()
                .user(message)
                // 传入会话 ID，用于区分不同用户的记忆
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                // 开启日志，便于观察效果
                .advisors(new MyLoggerAdvisor())
                // 应用知识库问答和对话记忆
                .advisors(
                        // 启用对话记忆 Advisor，自动管理历史消息
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        // 使用 builder 模式创建 QuestionAnswerAdvisor（Spring AI 1.0.0+）
                        QuestionAnswerAdvisor.builder(loveAppVectorStore).build()
                )
                .call()
                .chatResponse();
        String content = chatResponse.getResult().getOutput().getText();
        log.info("本地RAG回答: {}", content);
        return content;
    }

    /**
     * 使用组合 RAG（检索增强生成）进行对话
     * 先从本地向量库检索，再从云服务检索，结合对话记忆
     */
    public String doChatWithRag(String message, String chatId) {

        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository()) // 存储在内存中（重启丢失）
                .maxMessages(20) // 保留最近 20 条消息
                .build();

        ChatResponse chatResponse = chatClient
                .prompt()
                .user(message)
                // 传入会话 ID，用于区分不同用户的记忆
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                // 开启日志，便于观察效果
                .advisors(new MyLoggerAdvisor())
                // 应用组合检索和对话记忆
                .advisors(
                        // 启用对话记忆 Advisor，自动管理历史消息
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        // 使用组合检索 Advisor（先本地后云服务）
                        compositeRagAdvisor
                )
                .call()
                .chatResponse();
        String content = chatResponse.getResult().getOutput().getText();
        log.info("组合RAG回答（本地+云服务）: {}", content);
        return content;
    }

    /**
     * 结构化输出对象：恋爱报告
     * Spring AI 会自动将 JSON 结果映射为该 Java Record
     */
    public record LoveReport(String title, List<String> suggestions) {
    }

}
