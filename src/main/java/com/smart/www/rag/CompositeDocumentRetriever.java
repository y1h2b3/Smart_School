package com.smart.www.rag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.rag.Query;
import org.springframework.ai.rag.retrieval.search.DocumentRetriever;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合文档检索器
 * 先从本地检索，再从云服务检索，合并结果
 */
@Slf4j
public class CompositeDocumentRetriever implements DocumentRetriever {

    private final DocumentRetriever localRetriever;
    private final DocumentRetriever cloudRetriever;
    private final int maxLocalResults;
    private final int maxCloudResults;

    public CompositeDocumentRetriever(DocumentRetriever localRetriever,
                                      DocumentRetriever cloudRetriever,
                                      int maxLocalResults,
                                      int maxCloudResults) {
        this.localRetriever = localRetriever;
        this.cloudRetriever = cloudRetriever;
        this.maxLocalResults = maxLocalResults;
        this.maxCloudResults = maxCloudResults;
    }

    @Override
    public List<Document> retrieve(Query query) {
        List<Document> allDocuments = new ArrayList<>();

        // 1. 先从本地检索
        try {
            log.info("开始从本地向量库检索，查询: {}", query.text());
            List<Document> localDocs = localRetriever.retrieve(query);
            if (localDocs != null && !localDocs.isEmpty()) {
                // 限制本地检索结果数量
                int localLimit = Math.min(localDocs.size(), maxLocalResults);
                allDocuments.addAll(localDocs.subList(0, localLimit));
                log.info("本地检索到 {} 条结果", localLimit);
            } else {
                log.info("本地未检索到相关文档");
            }
        } catch (Exception e) {
            log.error("本地检索失败", e);
        }

        // 2. 再从云服务检索
        try {
            log.info("开始从云服务检索，查询: {}", query.text());
            List<Document> cloudDocs = cloudRetriever.retrieve(query);
            if (cloudDocs != null && !cloudDocs.isEmpty()) {
                // 限制云服务检索结果数量
                int cloudLimit = Math.min(cloudDocs.size(), maxCloudResults);
                allDocuments.addAll(cloudDocs.subList(0, cloudLimit));
                log.info("云服务检索到 {} 条结果", cloudLimit);
            } else {
                log.info("云服务未检索到相关文档");
            }
        } catch (Exception e) {
            log.error("云服务检索失败", e);
        }

        log.info("总共检索到 {} 条文档", allDocuments.size());
        return allDocuments;
    }
}
