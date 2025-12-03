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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
        Map<String, Object> variables = new HashMap<>();
        variables.put("height", userHealth.getHeight());
        variables.put("bmi", userHealth.getBmi());
        variables.put("fatPercentage", userHealth.getFatPercentage());
        variables.put("sleepTimeTotal", userHealth.getSleepTimeTotal());
        variables.put("deepSleepTotal", userHealth.getDeepSleepTotal());
        variables.put("lightSleepTotal", userHealth.getDeepSleepTotal()); // 注意：原代码bug，浅睡眠也用的deepSleepTotal
        variables.put("meanRestingHeartRate", userHealth.getMeanRestingHeartRate());
        variables.put("restingHeartRateMax", userHealth.getRestingHeartRateMax());
        variables.put("restingHeartRateMin", userHealth.getRestingHeartRateMin());
        variables.put("step", userHealth.getStep());
        variables.put("walkingTime", userHealth.getWalkingTime());
        variables.put("username", username);

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
        Map<String, Object> variables = new HashMap<>();
        variables.put("height", userHealth.getHeight());
        variables.put("bmi", userHealth.getBmi());
        variables.put("fatPercentage", userHealth.getFatPercentage());
        variables.put("sleepTimeTotal", userHealth.getSleepTimeTotal());
        variables.put("deepSleepTotal", userHealth.getDeepSleepTotal());
        variables.put("lightSleepTotal", userHealth.getDeepSleepTotal());
        variables.put("meanRestingHeartRate", userHealth.getMeanRestingHeartRate());
        variables.put("restingHeartRateMax", userHealth.getRestingHeartRateMax());
        variables.put("restingHeartRateMin", userHealth.getRestingHeartRateMin());
        variables.put("step", userHealth.getStep());
        variables.put("walkingTime", userHealth.getWalkingTime());
        variables.put("username", username);

        // 3. 渲染模板生成最终提示词
        String renderedPrompt = promptTemplate.render(variables);
        log.info("Generated prompt with RAG: {}", renderedPrompt);

        // 4. 创建对话记忆
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(20)
                .build();

        // 5. 调用 AI 生成结构化报告（使用 RAG）
        ChatResponse chatResponse = chatClient
                .prompt()
                .user(renderedPrompt)
                // 传入会话 ID
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                // 应用组合检索和对话记忆
                .advisors(
                        // 启用对话记忆 Advisor
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        // 使用组合检索 Advisor（先本地后云服务）
                        compositeRagAdvisor
                )
                .call()
                .chatResponse();

        // 6. 解析结构化输出
        String content = chatResponse.getResult().getOutput().getText();
        log.info("RAG Health Report Response: {}", content);

        // 7. 重新调用以获取结构化输出
        HealthReport healthReport = chatClient
                .prompt()
                .user(renderedPrompt)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .advisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        compositeRagAdvisor
                )
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
        Map<String, Object> variables = new HashMap<>();
        variables.put("height", userHealth.getHeight());
        variables.put("bmi", userHealth.getBmi());
        variables.put("fatPercentage", userHealth.getFatPercentage());
        variables.put("sleepTimeTotal", userHealth.getSleepTimeTotal());
        variables.put("deepSleepTotal", userHealth.getDeepSleepTotal());
        variables.put("lightSleepTotal", userHealth.getDeepSleepTotal());
        variables.put("meanRestingHeartRate", userHealth.getMeanRestingHeartRate());
        variables.put("restingHeartRateMax", userHealth.getRestingHeartRateMax());
        variables.put("restingHeartRateMin", userHealth.getRestingHeartRateMin());
        variables.put("step", userHealth.getStep());
        variables.put("walkingTime", userHealth.getWalkingTime());
        variables.put("username", username);

        // 3. 渲染模板生成最终提示词
        String renderedPrompt = promptTemplate.render(variables);
        log.info("Generated prompt with Cloud RAG: {}", renderedPrompt);

        // 4. 创建对话记忆
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(20)
                .build();

        // 5. 调用 AI 生成结构化报告（仅使用云端 RAG）
        HealthReport healthReport = chatClient
                .prompt()
                .user(renderedPrompt)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .advisors(
                        // 启用对话记忆 Advisor
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        // 仅使用云端检索 Advisor
                        cloudRagAdvisor
                )
                .call()
                .entity(HealthReport.class);

        log.info("Structured Health Report with Cloud RAG: {}", healthReport);
        return healthReport;
    }

    /**
     * 结构化输出对象：健康报告
     * Spring AI 会自动将 JSON 结果映射为该 Java Record
     */
    public record HealthReport(String title, List<String> suggestions) {
    }
}
