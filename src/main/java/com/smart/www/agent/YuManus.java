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
        this.setName("ZzzzhManus-健康助手");

        // 专业健康分析智能体提示词
        String SYSTEM_PROMPT = """
                你是ZzzzhManus，智慧校园的专业健康分析助手。
                                
                核心能力：
                1. 分析学生健康数据（BMI、睡眠、心率、运动量）
                2. 提供个性化健康建议和改善方案
                3. 生成专业健康报告文档
                4. 解答健康相关问题，提供科学依据
                                
                可用工具：
                - searchWeb: 搜索最新健康知识和研究
                - PDFGenerationTool: 生成健康报告 PDF
                                
                工作原则：
                - 基于科学和专业知识提供建议
                - 建议具体、可执行，避免空洞
                - 遇到不确定情况使用 searchWeb 查找依据
                - 完成任务后明确说明“任务已完成”
                """;
        this.setSystemPrompt(SYSTEM_PROMPT);

        // 针对健康场景优化的执行提示
        String NEXT_STEP_PROMPT = """
                分析当前任务，选择合适的工具：
                - 需要最新健康信息时使用 searchWeb
                - 需要生成文档时使用 PDFGenerationTool
                - 完成分析和建议后说明“任务已完成”
                """;
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
