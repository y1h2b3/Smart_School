package com.smart.www.rag;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 健康知识向量库配置
 */
@Configuration
public class HealthAppVectorStoreConfig {

    private static final Logger log = LoggerFactory.getLogger(HealthAppVectorStoreConfig.class);
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 2000;

    @Resource
    private HealthAppDocumentLoader healthAppDocumentLoader;

    @Bean
    VectorStore healthAppVectorStore(EmbeddingModel embeddingModel) {
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(embeddingModel)
                .build();

        // 加载健康知识文档（带重试机制）
        List<Document> documents = healthAppDocumentLoader.loadMarkdowns();

        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                log.info("正在加载健康知识向量库（尝试 {}/{})，文档数: {}", attempt, MAX_RETRIES, documents.size());
                simpleVectorStore.add(documents);
                log.info("健康知识向量库加载成功");
                return simpleVectorStore;
            } catch (Exception e) {
                log.warn("向量库加载失败（尝试 {}/{}): {}", attempt, MAX_RETRIES, e.getMessage());
                if (attempt < MAX_RETRIES) {
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    log.error("向量库加载失败，已达到最大重试次数，将返回空向量库");
                }
            }
        }

        // 返回空向量库，确保应用能启动
        return simpleVectorStore;
    }
}
