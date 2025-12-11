package com.smart.www.app;

import com.smart.www.advisor.MyLoggerAdvisor;
import com.smart.www.pojo.UserHealth;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康建议 AI 应用
 * 基于用户健康数据生成个性化建议
 */
@Component
@Slf4j
public class HealthApp {

    // 健康建议提示词模板
    private static final String HEALTH_PROMPT_TEMPLATE = """
            我的身高是{height}，
            我的体脂是{bmi}，
            我的脂肪率是{fatPercentage}，
            我昨晚累计睡眠时间是{sleepTimeTotal}小时，
            我昨晚累计深睡眠时间是{deepSleepTotal}小时，
            我昨晚累计浅睡眠时间是{lightSleepTotal}小时，
            我昨天平均静息心率是{meanRestingHeartRate}，
            我昨天静息心率最高是{restingHeartRateMax}，
            我昨天静息心率最低是{restingHeartRateMin}，
            我今日步数是{step}，
            我今日运动时长是{walkingTime}小时。
                        
            针对我的健康数据，给我有效性建议，不要长篇大论，简短为宜。
            请生成健康报告，标题为"{username}的健康报告"，内容为建议列表。
            """;
    private final ChatClient chatClient;
    @Resource
    @Qualifier("healthAppCompositeRagAdvisor")
    private Advisor compositeRagAdvisor;
    @Resource
    @Qualifier("healthAppRagCloudAdvisor")
    private Advisor cloudRagAdvisor;
    @Resource
    @Qualifier("healthAppLocalRagAdvisor")
    private Advisor localRagAdvisor;

    @Resource
    private ToolCallback[] allTools;

    public HealthApp(ChatModel dashscopeChatModel) {
        // 初始化基于内存的对话记忆
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(20)
                .build();

        // 构建 ChatClient
        chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultAdvisors(
                        // 启用对话记忆 Advisor
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        // 自定义日志 Advisor（可选）
                        new MyLoggerAdvisor()
                        // 自定义 Re2 Advisor（可选）
                        // new ReReadingAdvisor()
                )
                .build();
    }

    @Resource
    private ToolCallbackProvider toolCallbackProvider;

    /**
     * 构建健康数据变量映射（避免重复代码）
     */
    private Map<String, Object> buildVariables(UserHealth userHealth, String username) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("height", userHealth.getHeight());
        variables.put("bmi", userHealth.getBmi());
        variables.put("fatPercentage", userHealth.getFatPercentage());
        variables.put("sleepTimeTotal", userHealth.getSleepTimeTotal());
        variables.put("deepSleepTotal", userHealth.getDeepSleepTotal());
        variables.put("lightSleepTotal", userHealth.getLightSleepTotal()); // 已修复：使用正确的浅睡眠数据
        variables.put("meanRestingHeartRate", userHealth.getMeanRestingHeartRate());
        variables.put("restingHeartRateMax", userHealth.getRestingHeartRateMax());
        variables.put("restingHeartRateMin", userHealth.getRestingHeartRateMin());
        variables.put("step", userHealth.getStep());
        variables.put("walkingTime", userHealth.getWalkingTime());
        variables.put("username", username);
        return variables;
    }

    /**
     * 根据用户健康数据生成健康建议报告
     *
     * @param userHealth 用户健康数据对象
     * @param username   用户名
     * @param chatId     会话ID（用于记忆管理）
     * @return 健康报告对象
     */
    public HealthReport generateHealthReport(UserHealth userHealth, String username, String chatId) {
        // 1. 创建 PromptTemplate
        PromptTemplate promptTemplate = new PromptTemplate(HEALTH_PROMPT_TEMPLATE);

        // 2. 准备变量映射
        Map<String, Object> variables = buildVariables(userHealth, username);

        // 3. 渲染模板生成最终提示词
        String renderedPrompt = promptTemplate.render(variables);
        log.info("Generated prompt: {}", renderedPrompt);

        // 4. 调用 AI 生成结构化报告
        HealthReport healthReport = chatClient
                .prompt()
                .user(renderedPrompt) // 使用渲染后的提示词
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .entity(HealthReport.class); // 自动将 JSON 转换为 Java 对象

        log.info("Health Report: {}", healthReport);
        return healthReport;
    }

    /**
     * 使用 RAG（检索增强生成）生成健康建议报告
     * 结合健康知识库和用户健康数据，生成更专业的建议
     *
     * @param userHealth 用户健康数据对象
     * @param username   用户名
     * @param chatId     会话ID（用于记忆管理）
     * @return 健康报告对象
     */
    public HealthReport generateHealthReportWithRag(UserHealth userHealth, String username, String chatId) {
        // 1. 创建 PromptTemplate
        PromptTemplate promptTemplate = new PromptTemplate(HEALTH_PROMPT_TEMPLATE);

        // 2. 准备变量映射
        Map<String, Object> variables = buildVariables(userHealth, username);

        // 3. 渲染模板生成最终提示词
        String renderedPrompt = promptTemplate.render(variables);
        log.info("Generated prompt with RAG: {}", renderedPrompt);

        // 4. 调用 AI 生成结构化报告（使用 RAG + Tools）
        // 一次调用即可：entity() 方法会自动调用 AI 并解析为结构化对象
        // 同时保留 tools 支持，允许 AI 在生成报告时调用工具（如生成PDF、写文件等）
        HealthReport healthReport = chatClient
                .prompt()
                .user(renderedPrompt)
                // 传入会话 ID（使用构造函数中配置的 defaultAdvisors 中的 ChatMemory）
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                // 应用组合检索 Advisor
                .advisors(compositeRagAdvisor)
                // 仅使用 allTools（包含 WebSearchTool, PDFGenerationTool 等）
                .toolCallbacks(allTools)
                .call()
                .entity(HealthReport.class);

        log.info("Structured Health Report with RAG: {}", healthReport);
        return healthReport;
    }

    /**
     * 使用云端 RAG（仅云服务检索）生成健康建议报告
     * 只从云端知识库检索，不使用本地向量库
     *
     * @param userHealth 用户健康数据对象
     * @param username   用户名
     * @param chatId     会话ID（用于记忆管理）
     * @return 健康报告对象
     */
    public HealthReport generateHealthReportWithCloudRag(UserHealth userHealth, String username, String chatId) {
        // 1. 创建 PromptTemplate
        PromptTemplate promptTemplate = new PromptTemplate(HEALTH_PROMPT_TEMPLATE);

        // 2. 准备变量映射
        Map<String, Object> variables = buildVariables(userHealth, username);

        // 3. 渲染模板生成最终提示词
        String renderedPrompt = promptTemplate.render(variables);
        log.info("Generated prompt with Cloud RAG: {}", renderedPrompt);

        // 4. 调用 AI 生成结构化报告（仅使用云端 RAG）
        HealthReport healthReport = chatClient
                .prompt()
                .user(renderedPrompt)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .advisors(cloudRagAdvisor)
                .call()
                .entity(HealthReport.class);

        log.info("Structured Health Report with Cloud RAG: {}", healthReport);
        return healthReport;
    }

    /**
     * 使用 MCP 工具进行对话
     * 支持调用外部工具（如地图、天气等 MCP 服务）
     *
     * @param message 用户消息
     * @param chatId  会话ID（用于记忆管理）
     * @return AI 回复内容
     */
    public String doChatWithMcp(String message, String chatId) {
        ChatResponse response = chatClient
                .prompt()
                .user(message)
                // 使用 ChatMemory.CONVERSATION_ID 传入会话ID
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                // 启用 MCP 工具调用（ToolCallbackProvider 需要使用 toolCallbacks 方法）
                .toolCallbacks(toolCallbackProvider)
                .call()
                .chatResponse();
        String content = response.getResult().getOutput().getText();
        log.info("MCP Chat content: {}", content);
        return content;
    }

    /**
     * 普通对话（不使用 MCP 工具）
     *
     * @param message 用户消息
     * @param chatId  会话ID（用于记忆管理）
     * @return AI 回复内容
     */
    public String doChat(String message, String chatId) {
        ChatResponse response = chatClient
                .prompt()
                .user(message)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .chatResponse();
        String content = response.getResult().getOutput().getText();
        log.info("Chat content: {}", content);
        return content;
    }

    /**
     * 结构化输出对象：健康报告
     * Spring AI 会自动将 JSON 结果映射为该 Java Record
     */
    public record HealthReport(String title, List<String> suggestions) {
    }


    /**
     * 流式对话（支持 SSE）
     * 默认启用本地知识库 RAG
     *
     * @param message 用户消息
     * @param chatId  会话ID（用于记忆管理）
     * @return 流式响应
     */
    public Flux<String> doChatByStream(String message, String chatId) {
        return chatClient
                .prompt()
                .user(message)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .advisors(localRagAdvisor)  // 默认启用本地知识库 RAG
                .stream()
                .content();
    }

    /**
     * 支持开关的对话（同步）
     *
     * @param message            用户消息
     * @param chatId             会话ID
     * @param enableWebSearch    是否启用联网搜索
     * @param enableDeepThinking 是否启用深度思考
     * @return AI 回复内容
     */
    public String doChatWithOptions(String message, String chatId, boolean enableWebSearch, boolean enableDeepThinking) {
        // 构建提示词
        String enhancedMessage = message;
        if (enableDeepThinking) {
            enhancedMessage = "请深入思考以下问题，分析多个角度并给出详细的推理过程：\n" + message;
        }

        var promptSpec = chatClient
                .prompt()
                .user(enhancedMessage)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId));

        // 如果启用联网搜索，添加 WebSearchTool
        if (enableWebSearch) {
            promptSpec = promptSpec.toolCallbacks(allTools);
        }

        ChatResponse response = promptSpec.call().chatResponse();
        String content = response.getResult().getOutput().getText();
        log.info("Chat with options - WebSearch: {}, DeepThinking: {}, Content: {}",
                enableWebSearch, enableDeepThinking, content);
        return content;
    }

    /**
     * 支持开关的流式对话
     * 默认启用本地知识库 RAG，可选启用联网搜索和 MCP 服务
     *
     * @param message            用户消息
     * @param chatId             会话ID
     * @param enableWebSearch    是否启用联网搜索
     * @param enableDeepThinking 是否启用深度思考/MCP服务
     * @return 流式响应
     */
    public Flux<String> doChatByStreamWithOptions(String message, String chatId,
                                                  boolean enableWebSearch, boolean enableDeepThinking) {
        // 构建提示词
        String enhancedMessage = message;
        if (enableDeepThinking) {
            enhancedMessage = "请深入思考以下问题，分析多个角度并给出详细的推理过程：\n" + message;
        }

        var promptSpec = chatClient
                .prompt()
                .user(enhancedMessage)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .advisors(localRagAdvisor);  // 默认启用本地知识库 RAG

        // 如果启用联网搜索，添加 WebSearchTool
        if (enableWebSearch) {
            promptSpec = promptSpec.toolCallbacks(allTools);
        }

        // 如果启用深度思考/MCP服务，添加 MCP 工具
        if (enableDeepThinking) {
            promptSpec = promptSpec.toolCallbacks(toolCallbackProvider);
        }

        log.info("Stream chat with options - WebSearch: {}, DeepThinking/MCP: {}",
                enableWebSearch, enableDeepThinking);

        return promptSpec.stream().content();
    }


}
