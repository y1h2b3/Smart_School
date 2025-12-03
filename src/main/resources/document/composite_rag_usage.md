# 组合 RAG 检索使用说明

本文档说明如何使用组合检索功能（先本地后云服务）。

## 功能说明

组合 RAG 检索会按照以下顺序执行：

1. **本地向量库检索**：首先从本地 `SimpleVectorStore` 中检索相关文档（最多3条）
2. **云服务检索**：然后从阿里云百炼的知识库中检索相关文档（最多2条）
3. **结果合并**：将两个来源的检索结果合并，提供给 AI 模型作为上下文

## 优势

- **快速响应**：本地检索速度快，优先使用
- **知识互补**：本地知识库和云服务知识库互补
- **降低成本**：优先使用本地资源，减少云服务调用
- **提高准确性**：多源检索提供更全面的上下文

## 使用方法

### 方法1：仅本地检索

```java
String answer=loveApp.doChatWithLocalRag(message,chatId);
```

### 方法2：组合检索（推荐）

```java
String answer=loveApp.doChatWithRag(message,chatId);
```

## 配置说明

在 `LoveAppRagCloudAdvisorConfig` 中可以调整检索参数：

```java
CompositeDocumentRetriever compositeRetriever=new CompositeDocumentRetriever(
        localDocumentRetriever,
        cloudDocumentRetriever,
        3,  // 本地最多返回3条
        2   // 云服务最多返回2条
        );
```

## 日志输出

运行时会输出详细的检索日志：

```
开始从本地向量库检索，查询: 我已经结婚了，但是婚后关系不太亲密，怎么办？
本地检索到 3 条结果
开始从云服务检索，查询: 我已经结婚了，但是婚后关系不太亲密，怎么办？
云服务检索到 2 条结果
总共检索到 5 条文档
```

## 测试示例

```java
@Test
void doChatWithRag(){
        String chatId=UUID.randomUUID().toString();
        String message="我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer=loveApp.doChatWithRag(message,chatId);
        Assertions.assertNotNull(answer);
        }
```
