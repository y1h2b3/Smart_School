package com.smart.www.tools;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolRegistration {

    @Value("${search-api.api-key}")
    private String searchApiKey;

    @Bean
    public ToolCallback[] allTools() {
        // 文件操作工具：支持文件的读取、写入、删除等操作（当前禁用）
        FileOperationTool fileOperationTool = new FileOperationTool();

        // 联网搜索工具：用于在互联网上搜索信息，提供最新的网络数据（已启用）
        WebSearchTool webSearchTool = new WebSearchTool(searchApiKey);

        // 网页爬取工具：用于爬取和解析网页内容（当前禁用）
        WebScrapingTool webScrapingTool = new WebScrapingTool();

        // PDF 生成工具：用于生成健康报告等 PDF 文档（已启用）
        PDFGenerationTool pdfGenerationTool = new PDFGenerationTool();

        // 终止工具：用于终止对话和任务流程（已启用）
        TerminateTool terminateTool = new TerminateTool();
        
        return ToolCallbacks.from(
                // 启用的工具集合
//                fileOperationTool,  // 文件操作工具（禁用）
                webSearchTool,        // 联网搜索工具（启用）
//                webScrapingTool,    // 网页爬取工具（禁用）
                pdfGenerationTool,    // PDF 生成工具（启用）
                terminateTool       // 终止工具（禁用）
        );
    }
}
