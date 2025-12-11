package com.smart.www.rag;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.rag.DashScopeDocumentRetriever;
import com.alibaba.cloud.ai.dashscope.rag.DashScopeDocumentRetrieverOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.retrieval.search.DocumentRetriever;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 健康知识 RAG 配置
 * 支持本地向量库和云服务组合检索
 */
@Configuration
@Slf4j
public class HealthAppRagCloudAdvisorConfig {

    @Value("${spring.ai.dashscope.api-key}")
    private String dashScopeApiKey;

    @Resource
    private VectorStore healthAppVectorStore;

    /**
     * 创建健康知识云服务文档检索器
     */
    @Bean
    public DocumentRetriever healthCloudDocumentRetriever() {
        DashScopeApi dashScopeApi = DashScopeApi.builder()
                .apiKey(dashScopeApiKey)
                .build();

        final String KNOWLEDGE_INDEX = "智慧校园";
        return new DashScopeDocumentRetriever(dashScopeApi,
                DashScopeDocumentRetrieverOptions.builder()
                        .withIndexName(KNOWLEDGE_INDEX)
                        .build());
    }

    /**
     * 创建健康知识本地向量库文档检索器
     */
    @Bean
    public DocumentRetriever healthLocalDocumentRetriever() {
        return VectorStoreDocumentRetriever.builder()
                .vectorStore(healthAppVectorStore)
                .topK(3) // 本地检索返回前3条
                .build();
    }

    /**
     * 创建健康知识组合检索 Advisor
     * 先从本地检索，再从云服务检索
     */
    @Bean
    public Advisor healthAppCompositeRagAdvisor(DocumentRetriever healthLocalDocumentRetriever,
                                                DocumentRetriever healthCloudDocumentRetriever) {
        // 创建组合检索器：本地最多3条，云服务最多2条
        CompositeDocumentRetriever compositeRetriever = new CompositeDocumentRetriever(
                healthLocalDocumentRetriever,
                healthCloudDocumentRetriever,
                3,  // 本地最多返回3条
                2   // 云服务最多返回2条
        );

        return RetrievalAugmentationAdvisor.builder()
                .documentRetriever(compositeRetriever)
                .build();
    }

    /**
     * 仅使用云服务检索的 Advisor（保留原有功能）
     */
    @Bean
    public Advisor healthAppRagCloudAdvisor(DocumentRetriever healthCloudDocumentRetriever) {
        return RetrievalAugmentationAdvisor.builder()
                .documentRetriever(healthCloudDocumentRetriever)
                .build();
    }

    /**
     * 仅使用本地知识库检索的 Advisor
     */
    @Bean
    public Advisor healthAppLocalRagAdvisor(DocumentRetriever healthLocalDocumentRetriever) {
        return RetrievalAugmentationAdvisor.builder()
                .documentRetriever(healthLocalDocumentRetriever)
                .build();
    }
}
