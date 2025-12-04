# 🎓 SmartCampus - 智慧校园管理系统

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![MyBatis-Plus](https://img.shields.io/badge/MyBatis--Plus-3.5.5-blue.svg)
![Spring AI](https://img.shields.io/badge/Spring%20AI-1.0.0-blue.svg)
![Redis](https://img.shields.io/badge/Redis-6.0%2B-red.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)

**一个功能完善、集成 AI 能力的现代化智慧校园综合管理平台后端系统**

融合健康监测、医疗服务、智能问答、支付集成、RAG 检索增强等多项功能

[快速开始](#-快速开始) • [功能特性](#-核心功能) • [技术架构](#-技术架构) • [API 文档](#-api-文档)

</div>

---

## 📋 目录

- [项目简介](#-项目简介)
- [核心功能](#-核心功能)
- [技术架构](#-技术架构)
- [项目结构](#-项目结构)
- [快速开始](#-快速开始)
- [AI 功能详解](#-ai-功能详解)
- [API 文档](#-api-文档)
- [配置说明](#-配置说明)
- [开发指南](#-开发指南)
- [部署指南](#-部署指南)
- [常见问题](#-常见问题)

---

## 📖 项目简介

**SmartCampus** 是一个基于 **Spring Boot 3.x + Spring AI 1.0** 的现代化智慧校园一体化后端服务系统，面向学生、教师、家长、后勤人员及校医等多角色用户，提供全方位的校园管理解决方案。

### 🎯 核心亮点

#### 🤖 AI 智能服务

- **AI 健康顾问**：集成阿里云通义千问（DashScope），基于用户健康数据生成个性化建议
- **RAG 检索增强**：基于 Spring AI 的 RAG 架构，提供精准的知识检索
- **对话记忆**：支持多轮对话上下文，基于 Kryo 序列化的对话历史持久化
- **Function Calling**：支持 AI 工具调用（文件操作、PDF 生成、网页抓取、网络搜索）
- **向量存储**：集成 PGVector 向量数据库，支持语义搜索

#### 🏥 健康管理系统

- **实时健康监测**：支持身高、体重、BMI、心率、血氧、体温、睡眠等多维度健康数据采集
- **智能健康预警**：自动检测异常健康指标，多级预警机制
- **每日健康报告**：自动生成每日健康摘要，AI 生成健康建议

#### 💊 医疗服务管理

- **药品管理**：药品信息维护、分类管理、库存预警
- **医院管理**：医院信息维护、药品-医院关联关系
- **预约系统**：在线预约挂号、预约状态管理

#### 💰 支付集成

- **支付宝沙箱支付**：PC 网站支付、同步/异步回调处理
- **书杰支付**：第三方支付集成
- **订单管理**：订单创建、状态跟踪、历史查询

### 📍 项目信息

- **应用入口**：`src/main/java/com/smart/www/SpringbootApplication.java`
- **运行端口**：`8718`
- **数据库**：`smart_campus`（MySQL 8.0+）
- **缓存**：Redis 6.0+
- **API 文档**：http://localhost:8718/doc.html

---

## 🚀 核心功能

### 1️⃣ AI 智能服务

#### AI 健康顾问（HealthApp）

```java
// 获取健康建议
GET/healthApp/advice?userId=学生ID

// 响应示例
        {
        "code":200,
        "message":"成功",
        "data":"根据您的健康数据分析：\n一、建议增加有氧运动，每天至少30分钟\n二、注意改善睡眠质量..."
        }
```

**特性**：

- 基于 Spring AI ChatClient 构建
- 集成对话记忆（MessageChatMemoryAdvisor）
- 支持 RAG 检索增强（QuestionAnswerAdvisor）
- 支持 Function Calling（文件操作、PDF 生成等）

#### AI 恋爱顾问（LoveApp）

```java
// 智能对话，支持多轮上下文
POST/love/chat
        {
        "message":"你好，我是程序员鱼皮",
        "chatId":"uuid"
        }
```

**特性**：

- 扮演恋爱心理专家
- 支持多轮对话上下文
- 集成 RAG 检索增强

### 2️⃣ 健康监测模块

#### 实时健康数据采集

- **基础指标**：身高、体重、BMI、体脂率
- **心率监测**：平均静息心率、最高/最低心率
- **血氧与体温**：血氧饱和度（SpO2）、体温
- **睡眠监测**：总睡眠时长、深睡/浅睡时长
- **运动数据**：步数、运动距离、卡路里消耗

#### 健康预警系统

```
异常检测 → 风险评估 → 预警通知 → 健康建议
```

### 3️⃣ 医疗服务模块

- **药品管理**：CRUD、库存预警、图片上传
- **医院管理**：医院信息维护、科室管理
- **预约系统**：在线预约挂号、状态管理

### 4️⃣ 订单与支付模块

- **支付宝沙箱支付**
- **书杰支付**集成
- **订单管理**：创建、跟踪、查询、统计

---

## 🛠 技术架构

### 核心技术栈

| 分类 | 技术 | 版本 | 说明 |
|-----|-----|------|------|
| **核心框架** | Spring Boot | 3.2.4 | 核心框架 |
| | Java | 17 | 开发语言 |
| **数据库** | MySQL | 8.0.28 | 关系型数据库 |
| | MyBatis-Plus | 3.5.5 | ORM 框架 |
| | Druid | 1.2.18 | 数据库连接池 |
| **缓存** | Redis | 6.0+ | 缓存、会话存储 |
| **AI 框架** | Spring AI | 1.0.0 | Spring 官方 AI 框架 |
| | Spring AI Alibaba | 1.0.0.2 | 阿里云 AI 集成 |
| | DashScope | - | 阿里云通义千问 |
| | PGVector | - | 向量存储 |
| | Kryo | 5.6.2 | 对话记忆序列化 |
| **权限认证** | Sa-Token | 1.37.0 | 权限认证框架 |
| **API 文档** | Knife4j | 4.3.0 | API 文档增强 |
| | SpringDoc | 2.0.2 | OpenAPI 3.0 |
| **支付** | Alipay SDK | 4.22.110 | 支付宝支付 |
| **工具库** | Hutool | 5.8.25 | 工具库 |
| | Jsoup | 1.19.1 | 网页抓取 |
| | iText | 9.1.0 | PDF 生成 |
| | Lombok | - | 简化代码 |

### AI 架构设计

```
┌─────────────────────────────────────────────────────────┐
│                      用户请求                            │
└─────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────┐
│                   ChatClient (Spring AI)                 │
│  ┌───────────────────────────────────────────────────┐  │
│  │  Advisor Chain (责任链模式)                        │  │
│  │  ├─ MyLoggerAdvisor (日志记录)                     │  │
│  │  ├─ MessageChatMemoryAdvisor (对话记忆)            │  │
│  │  ├─ QuestionAnswerAdvisor (RAG 检索增强)           │  │
│  │  └─ ChatModelCallAdvisor (模型调用)                │  │
│  └───────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────┘
                            ↓
┌──────────────┬──────────────┬──────────────┬────────────┐
│  ChatModel   │  ChatMemory  │ VectorStore  │   Tools    │
│  (通义千问)   │  (对话记忆)   │  (向量检索)   │ (工具调用)  │
└──────────────┴──────────────┴──────────────┴────────────┘
```

---

## 📁 项目结构

```
SmartCampus_SpringBoot/
├── src/main/java/com/smart/www/
│   ├── SpringbootApplication.java      # 应用启动类
│   ├── advisor/                        # AI Advisor (2个)
│   ├── app/                            # AI 应用 (2个)
│   │   ├── HealthApp.java              # 健康建议 AI
│   │   └── LoveApp.java                # 恋爱顾问 AI
│   ├── config/                         # 配置类 (16个)
│   ├── controller/                     # 控制器 (24个)
│   ├── service/                        # 服务层 (36个)
│   ├── mapper/                         # 数据访问层 (18个)
│   ├── pojo/                           # 实体类 (42个)
│   ├── rag/                            # RAG 检索增强 (7个)
│   ├── tools/                          # AI 工具 (5个)
│   ├── util/                           # 工具类 (10个)
│   ├── interceptor/                    # 拦截器 (1个)
│   └── exception/                      # 异常处理 (1个)
├── src/main/resources/
│   ├── application.yaml                # 主配置文件
│   └── com/smart/www/mapper/*.xml      # MyBatis XML
├── src/test/                           # 测试代码
├── docs/                               # 项目文档
├── smart_campus.sql                    # 数据库脚本
└── pom.xml                             # Maven 配置
```

---

## 🚀 快速开始

### 环境要求

| 软件 | 版本要求 |
|-----|---------|
| JDK | 17+ |
| Maven | 3.8+ |
| MySQL | 8.0+ |
| Redis | 6.0+ |
| PostgreSQL | 14+ (可选，用于 RAG) |

### 安装步骤

#### 1. 克隆项目

```bash
git clone <repository-url>
cd SmartCampus_SpringBoot
```

#### 2. 数据库初始化

```bash
# 创建数据库
mysql -u root -p
CREATE DATABASE smart_campus CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# 导入数据
mysql -u root -p smart_campus < smart_campus.sql
```

#### 3. 配置文件修改

编辑 `src/main/resources/application.yaml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/smart_campus
    username: root
    password: 你的数据库密码            # ⚠️ 修改

  data:
    redis:
      host: 127.0.0.1
      port: 6379

  ai:
    dashscope:
      api-key: 你的阿里云API_Key        # ⚠️ 从 https://dashscope.console.aliyun.com/ 获取
```

#### 4. 启动 Redis

```bash
redis-server
```

#### 5. 运行项目

```bash
# Maven 命令
mvn spring-boot:run

# 或打包运行
mvn clean package -DskipTests
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar
```

#### 6. 验证启动

访问 http://localhost:8718/doc.html 查看 API 文档

---

## 🤖 AI 功能详解

### 1. AI 健康顾问（HealthApp）

#### 功能概述

HealthApp 是基于 Spring AI 框架构建的智能健康顾问系统，能够根据用户的健康数据生成个性化的健康建议。它集成了对话记忆、RAG 检索增强和 Function Calling 等先进的 AI 能力。

#### 核心特性

1. **个性化健康分析**
    - 基于用户的身高、体重、BMI、心率、睡眠等多维度数据
    - 生成针对性的健康建议和改善方案
    - 支持健康趋势分析和预测

2. **多轮对话支持**
    - 基于 MessageChatMemoryAdvisor 实现对话上下文管理
    - 支持连续对话，AI 能记住之前的交流内容
    - 使用滑动窗口机制，避免 token 超限

3. **RAG 检索增强**
    - 从向量数据库检索相关健康知识
    - 结合检索到的专业知识生成更准确的建议
    - 支持本地向量库和云服务的组合检索

4. **Function Calling**
    - 自动调用工具生成 PDF 健康报告
    - 支持文件操作、网页抓取等功能
    - 可扩展的工具注册机制

#### 技术实现

```java

@Component
@Slf4j
public class HealthApp {

    private final ChatClient chatClient;

    public HealthApp(ChatModel dashscopeChatModel,
                     ChatMemory chatMemory,
                     QuestionAnswerAdvisor ragAdvisor,
                     List<ToolCallback> tools) {
        this.chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultSystem(SYSTEM_PROMPT)
                .defaultAdvisors(
                        new MyLoggerAdvisor(),                    // 日志记录
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),  // 对话记忆
                        ragAdvisor                                 // RAG 检索增强
                )
                .defaultTools(tools)                              // Function Calling
                .build();
    }
}
```

### 2. AI 恋爱顾问（LoveApp）

#### 功能概述

LoveApp 是一个扮演恋爱心理专家的 AI 应用，能够为用户提供恋爱咨询和建议。它支持多种对话模式和结构化输出。

#### 核心功能

1. **普通对话模式**（`doChat`）
    - 返回纯文本回复
    - 支持多轮对话上下文
    - 自动管理对话历史

2. **结构化报告模式**（`doChatWithReport`）
    - 返回 `LoveReport` 对象
    - 包含标题和建议列表
    - 自动 JSON 转 Java 对象

3. **本地 RAG 模式**（`doChatWithLocalRag`）
    - 从本地向量库检索恋爱知识
    - 结合检索结果生成回答
    - 适合离线或私有部署场景

4. **组合 RAG 模式**（`doChatWithRag`）
    - 先检索本地向量库
    - 再检索云服务知识库
    - 提供最全面的知识支持

#### 使用示例

**示例 1：普通对话**

```java
// 第一轮对话
String response1 = loveApp.doChat("你好，我是程序员鱼皮", "user-123");
// AI: 你好鱼皮！我是恋爱心理专家...

// 第二轮对话（AI 会记住用户名）
String response2 = loveApp.doChat("我想让另一半（编程导航）更爱我", "user-123");
// AI: 鱼皮，关于如何让编程导航更爱你...

// 第三轮对话（测试记忆能力）
String response3 = loveApp.doChat("我的另一半叫什么来着？", "user-123");
// AI: 你的另一半叫编程导航...
```

**示例 2：生成结构化报告**

```java
LoveReport report = loveApp.doChatWithReport(
    "我和女朋友经常因为小事吵架，怎么办？", 
    "user-123"
);

// 输出示例
// {
//   "title": "鱼皮的恋爱报告",
//   "suggestions": [
//     "学会倾听对方的真实想法",
//     "避免在情绪激动时争吵",
//     "建立有效的沟通机制",
//     "培养共同的兴趣爱好"
//   ]
// }
```

**示例 3：使用 RAG 增强回答**

```java
// 使用本地知识库
String response = loveApp.doChatWithLocalRag(
    "异地恋如何维持感情？", 
    "user-123"
);
// AI 会从本地向量库检索相关的恋爱知识，结合检索结果生成回答

// 使用组合检索（本地+云服务）
String response2 = loveApp.doChatWithRag(
    "如何处理婆媳关系？", 
    "user-123"
);
// AI 会先检索本地库，再检索云服务，提供更全面的建议
```

#### 技术实现细节

```java
@Component
@Slf4j
public class LoveApp {
    
    // 系统提示词：定义 AI 的人设
    private static final String SYSTEM_PROMPT = 
        "扮演深耕恋爱心理领域的专家...";
    
    private final ChatClient chatClient;
    
    public LoveApp(ChatModel dashscopeChatModel) {
        // 1. 初始化对话记忆（滑动窗口模式）
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(20)  // 保留最近 20 条消息
                .build();
        
        // 2. 构建 ChatClient
        this.chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultSystem(SYSTEM_PROMPT)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        new MyLoggerAdvisor()
                )
                .build();
    }
    
    // 普通对话
    public String doChat(String message, String chatId) {
        return chatClient.prompt()
                .user(message)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .content();
    }
    
    // 结构化输出
    public LoveReport doChatWithReport(String message, String chatId) {
        return chatClient.prompt()
                .system(SYSTEM_PROMPT + "生成恋爱报告...")
                .user(message)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .entity(LoveReport.class);  // 自动 JSON 转对象
    }
    
    // 结构化输出对象
    public record LoveReport(String title, List<String> suggestions) {}
}
```

### 3. RAG 检索增强生成

#### 什么是 RAG？

RAG（Retrieval-Augmented Generation，检索增强生成）是一种结合信息检索和文本生成的 AI 技术。它通过以下步骤工作：

```
┌─────────────┐
│  用户问题    │
└──────┬──────┘
       ↓
┌─────────────────────────────────────┐
│  1. 向量化（Embedding）              │
│  将问题转换为向量表示                │
└──────┬──────────────────────────────┘
       ↓
┌─────────────────────────────────────┐
│  2. 相似度检索（Similarity Search）  │
│  从向量数据库中检索相关文档          │
└──────┬──────────────────────────────┘
       ↓
┌─────────────────────────────────────┐
│  3. 上下文增强（Context Enhancement）│
│  将检索到的文档作为上下文            │
└──────┬──────────────────────────────┘
       ↓
┌─────────────────────────────────────┐
│  4. AI 生成回答（Generation）        │
│  基于上下文生成准确的回答            │
└──────┬──────────────────────────────┘
       ↓
┌─────────────┐
│  返回结果    │
└─────────────┘
```

#### 为什么需要 RAG？

1. **解决知识时效性问题**
    - AI 模型的训练数据有时间截止点
    - RAG 可以检索最新的知识库
    - 实时更新知识，无需重新训练模型

2. **提供专业领域知识**
    - 通用 AI 模型对专业领域了解有限
    - RAG 可以检索专业文档和资料
    - 生成更准确、更专业的回答

3. **减少幻觉（Hallucination）**
    - AI 可能生成不真实的内容
    - RAG 基于真实文档生成回答
    - 提高回答的可信度和准确性

4. **支持私有知识库**
    - 企业内部文档、专有知识
    - 不需要将数据用于模型训练
    - 保护数据隐私和安全

#### 组件详解

**1. 文档加载器（DocumentLoader）**

负责加载和预处理知识文档。

```java
@Component
public class HealthAppDocumentLoader {
    
    @Bean
    public List<Document> healthDocuments() {
        List<Document> documents = new ArrayList<>();
        
        // 从 Markdown 文件加载
        MarkdownDocumentReader reader = new MarkdownDocumentReader(
            new ClassPathResource("knowledge/health.md")
        );
        documents.addAll(reader.get());
        
        // 从数据库加载
        List<HealthKnowledge> knowledgeList = healthKnowledgeService.list();
        for (HealthKnowledge knowledge : knowledgeList) {
            documents.add(new Document(
                knowledge.getContent(),
                Map.of("title", knowledge.getTitle())
            ));
        }
        
        return documents;
    }
}
```

**2. 向量存储（VectorStore）**

使用 PGVector 存储文档向量，支持高效的相似度检索。

```java
@Configuration
public class HealthAppVectorStoreConfig {
    
    @Bean
    public VectorStore healthVectorStore(
            JdbcTemplate jdbcTemplate,
            EmbeddingModel embeddingModel) {
        
        return PgVectorStore.builder()
                .jdbcTemplate(jdbcTemplate)
                .embeddingModel(embeddingModel)
                .dimensions(1536)  // 向量维度（取决于 Embedding 模型）
                .distanceType(DistanceType.COSINE_DISTANCE)  // 余弦距离
                .removeExistingVectorStoreTable(false)  // 保留现有表
                .build();
    }
    
    // 初始化向量库（首次运行）
    @Bean
    public CommandLineRunner initVectorStore(
            VectorStore vectorStore,
            List<Document> healthDocuments) {
        return args -> {
            // 将文档添加到向量库
            vectorStore.add(healthDocuments);
            log.info("向量库初始化完成，共 {} 个文档", healthDocuments.size());
        };
    }
}
```

**3. 文档检索器（DocumentRetriever）**

实现复合检索策略，先检索本地库，再检索云服务。

```java
@Component
public class CompositeDocumentRetriever implements DocumentRetriever {
    
    private final VectorStore localVectorStore;
    private final CloudSearchService cloudSearchService;
    
    @Override
    public List<Document> retrieve(String query) {
        List<Document> documents = new ArrayList<>();
        
        // 1. 从本地向量库检索
        List<Document> localDocs = localVectorStore.similaritySearch(
            SearchRequest.query(query)
                .withTopK(3)  // 检索 Top 3
                .withSimilarityThreshold(0.7)  // 相似度阈值
        );
        documents.addAll(localDocs);
        
        // 2. 如果本地结果不足，从云服务检索
        if (documents.size() < 3) {
            List<Document> cloudDocs = cloudSearchService.search(query, 3);
            documents.addAll(cloudDocs);
        }
        
        return documents;
    }
}
```

**4. RAG Advisor 配置**

配置 QuestionAnswerAdvisor，实现检索增强。

```java
@Configuration
public class HealthAppRagCloudAdvisorConfig {
    
    @Bean
    public QuestionAnswerAdvisor healthRagAdvisor(
            VectorStore vectorStore,
            ChatModel chatModel) {
        
        return QuestionAnswerAdvisor.builder()
                .vectorStore(vectorStore)
                .chatModel(chatModel)
                .searchRequest(SearchRequest.defaults()
                        .withTopK(5)  // 检索 Top 5 相关文档
                        .withSimilarityThreshold(0.7))  // 相似度阈值 0.7
                .userTextAdvise("""
                    使用以下上下文信息回答问题。
                    如果上下文中没有相关信息，请明确告知用户。
                    
                    上下文：
                    {context}
                    
                    问题：{question}
                    """)
                .build();
    }
}
```

#### RAG 工作流程示例

假设用户问："如何改善睡眠质量？"

1. **向量化**
   ```
   问题 "如何改善睡眠质量？" → Embedding 模型 → [0.123, -0.456, ...] (1536维向量)
   ```

2. **相似度检索**
   ```sql
   SELECT content, 1 - (embedding <=> '[0.123,-0.456,...]') AS similarity
   FROM vector_store
   WHERE 1 - (embedding <=> '[0.123,-0.456,...]') > 0.7
   ORDER BY similarity DESC
   LIMIT 5;
   ```

   检索结果：
    - 文档1: "睡眠质量与作息规律的关系" (相似度 0.92)
    - 文档2: "改善睡眠的10个方法" (相似度 0.88)
    - 文档3: "深度睡眠的重要性" (相似度 0.85)

3. **上下文增强**
   ```
   系统提示词 + 检索到的文档 + 用户问题 → 构建完整的 Prompt
   ```

4. **AI 生成回答**
   ```
   基于检索到的专业知识，生成准确的回答：
   "改善睡眠质量的建议：
   1. 保持规律的作息时间，每天同一时间睡觉和起床
   2. 睡前避免使用电子设备，减少蓝光刺激
   3. 创造舒适的睡眠环境，保持室温在18-22°C
   ..."
   ```

### 4. Function Calling 工具调用

#### 什么是 Function Calling？

Function Calling 是 AI 模型主动调用外部工具和函数的能力。当 AI 判断需要执行某个操作时，它会生成函数调用请求，系统执行函数后将结果返回给 AI，AI 再基于结果生成最终回答。

#### 工作流程

```
用户："帮我生成一份健康报告的 PDF"
  ↓
AI 分析：需要调用 PDFGenerationTool
  ↓
AI 生成函数调用：
{
  "name": "generateHealthReport",
  "arguments": {
    "title": "张三的健康报告",
    "suggestions": ["建议1", "建议2"]
  }
}
  ↓
系统执行函数：生成 PDF 文件
  ↓
返回结果："/reports/health_report_20241204.pdf"
  ↓
AI 生成回复："已为您生成健康报告，文件路径：/reports/health_report_20241204.pdf"
```

#### 工具列表

**1. FileOperationTool - 文件操作工具**

```java
@Component
public class FileOperationTool {
    
    @Tool(description = "读取文件内容")
    public String readFile(
            @ToolParam(description = "文件路径") String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            return "文件读取失败：" + e.getMessage();
        }
    }
    
    @Tool(description = "写入文件内容")
    public String writeFile(
            @ToolParam(description = "文件路径") String filePath,
            @ToolParam(description = "文件内容") String content) {
        try {
            Files.writeString(Path.of(filePath), content);
            return "文件写入成功：" + filePath;
        } catch (IOException e) {
            return "文件写入失败：" + e.getMessage();
        }
    }
}
```

**使用示例**：

```
用户："帮我把健康建议保存到 advice.txt 文件"
AI：调用 writeFile("/data/advice.txt", "建议内容...")
结果："已将健康建议保存到 advice.txt"
```

**2. PDFGenerationTool - PDF 生成工具**

```java

@Component
public class PDFGenerationTool {

    @Tool(description = "生成 PDF 健康报告")
    public String generateHealthReport(
            @ToolParam(description = "报告标题") String title,
            @ToolParam(description = "建议列表") List<String> suggestions) {

        String outputPath = "/reports/health_" + System.currentTimeMillis() + ".pdf";

        try {
            // 使用 iText 生成 PDF
            PdfWriter writer = new PdfWriter(outputPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // 加载中文字体
            PdfFont font = PdfFontFactory.createFont(
                    "STSong-Light",
                    "UniGB-UCS2-H"
            );

            // 添加标题
            document.add(new Paragraph(title)
                    .setFont(font)
                    .setFontSize(20)
                    .setBold());

            // 添加建议列表
            for (int i = 0; i < suggestions.size(); i++) {
                document.add(new Paragraph(
                        (i + 1) + ". " + suggestions.get(i)
                ).setFont(font));
            }

            document.close();
            return outputPath;

        } catch (Exception e) {
            return "PDF 生成失败：" + e.getMessage();
        }
    }
}
```

**使用示例**：

```
用户："生成一份包含我健康建议的 PDF 报告"
AI：分析用户健康数据 → 生成建议列表 → 调用 generateHealthReport()
结果："已生成健康报告：/reports/health_1733299200000.pdf"
```

**3. WebScrapingTool - 网页抓取工具**

```java
@Component
public class WebScrapingTool {
    
    @Tool(description = "抓取网页内容")
    public String scrapeWebPage(
            @ToolParam(description = "网页 URL") String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(5000)
                    .get();
            
            // 提取正文内容
            String content = doc.select("article, .content, .main").text();
            
            if (content.isEmpty()) {
                content = doc.body().text();
            }
            
            // 限制长度，避免 token 超限
            return content.length() > 2000 
                ? content.substring(0, 2000) + "..." 
                : content;
                
        } catch (IOException e) {
            return "网页抓取失败：" + e.getMessage();
        }
    }
}
```

**使用示例**：

```
用户："帮我看看这篇文章讲了什么：https://example.com/health-tips"
AI：调用 scrapeWebPage("https://example.com/health-tips")
结果：抓取内容 → AI 总结 → "这篇文章主要介绍了..."
```

**4. WebSearchTool - 网络搜索工具**

```java
@Component
public class WebSearchTool {
    
    private final RestTemplate restTemplate;
    
    @Tool(description = "搜索健康相关信息")
    public List<SearchResult> searchHealth(
            @ToolParam(description = "搜索关键词") String query) {
        
        // 调用搜索 API（示例使用 Bing Search API）
        String apiUrl = "https://api.bing.microsoft.com/v7.0/search";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", apiKey);
        
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(apiUrl)
                .queryParam("q", query)
                .queryParam("count", 5);
        
        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        ResponseEntity<BingSearchResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                BingSearchResponse.class
        );
        
        // 解析搜索结果
        return response.getBody().getWebPages().getValue().stream()
                .map(page -> new SearchResult(
                    page.getName(),
                    page.getUrl(),
                    page.getSnippet()
                ))
                .collect(Collectors.toList());
    }
    
    public record SearchResult(String title, String url, String snippet) {}
}
```

**使用示例**：

```
用户："最新的健康饮食建议有哪些？"
AI：调用 searchHealth("健康饮食建议 2024")
结果：获取搜索结果 → AI 总结 → "根据最新的搜索结果，2024年的健康饮食建议包括..."
```

#### 工具注册

```java

@Configuration
public class ToolRegistration {

    @Bean
    public List<ToolCallback> toolCallbacks(
            FileOperationTool fileOperationTool,
            PDFGenerationTool pdfGenerationTool,
            WebScrapingTool webScrapingTool,
            WebSearchTool webSearchTool) {

        return List.of(
                // 注册文件操作工具
                ToolCallback.builder()
                        .name("readFile")
                        .description("读取文件内容")
                        .function(fileOperationTool::readFile)
                        .build(),

                ToolCallback.builder()
                        .name("writeFile")
                        .description("写入文件内容")
                        .function(fileOperationTool::writeFile)
                        .build(),

                // 注册 PDF 生成工具
                ToolCallback.builder()
                        .name("generateHealthReport")
                        .description("生成 PDF 健康报告")
                        .function(pdfGenerationTool::generateHealthReport)
                        .build(),

                // 注册网页抓取工具
                ToolCallback.builder()
                        .name("scrapeWebPage")
                        .description("抓取网页内容")
                        .function(webScrapingTool::scrapeWebPage)
                        .build(),

                // 注册网络搜索工具
                ToolCallback.builder()
                        .name("searchHealth")
                        .description("搜索健康相关信息")
                        .function(webSearchTool::searchHealth)
                        .build()
        );
    }
}
```

#### 完整使用示例

```java
// 在 HealthApp 中集成工具
@Component
public class HealthApp {

    private final ChatClient chatClient;

    public HealthApp(
            ChatModel dashscopeChatModel,
            List<ToolCallback> tools) {  // 注入工具列表

        this.chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultSystem("你是健康顾问，可以使用工具帮助用户")
                .defaultTools(tools)  // 注册工具
                .build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}

// 使用示例
public class Example {
    public static void main(String[] args) {
        HealthApp app = ...; // 从 Spring 容器获取

        // AI 会自动判断是否需要调用工具
        String response1 = app.chat("帮我生成一份健康报告的 PDF");
        // AI 调用 generateHealthReport() → 返回文件路径

        String response2 = app.chat("搜索一下最新的减肥方法");
        // AI 调用 searchHealth("最新减肥方法") → 总结搜索结果

        String response3 = app.chat("我的 BMI 是多少？");
        // AI 不需要调用工具，直接根据上下文回答
    }
}
```

---

## 📖 API 文档

### 访问方式

- **Knife4j 文档**：http://localhost:8718/doc.html
- **Swagger UI**：http://localhost:8718/swagger-ui.html
- **OpenAPI JSON**：http://localhost:8718/v3/api-docs

### 统一响应格式

```json
{
  "code": 200,
  "message": "成功",
  "data": {}
}
```

**状态码**：
- `200` - 成功
- `201` - 失败
- `208` - 未登录
- `209` - 无权限

---

## ⚙️ 配置说明

### 核心配置

```yaml
server:
  port: 8718                          # 应用端口

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/smart_campus
    username: root
    password: 123456                  # ⚠️ 修改

  data:
    redis:
      host: 127.0.0.1
      port: 6379

  ai:
    dashscope:
      api-key: sk-xxx                 # ⚠️ 修改
      chat:
        options:
          model: qwen-plus
          temperature: 0.7

mybatis-plus:
  global-config:
    db-config:
      id-type: assign_id              # 雪花算法

sa-token:
  token-name: satoken
  timeout: 2592000                    # 30天
```

---

## 💻 开发指南

### 添加新功能模块

#### 1. 创建实体类

```java
@Data
@TableName("new_table")
public class NewEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
}
```

#### 2. 创建 Mapper

```java
@Mapper
public interface NewEntityMapper extends BaseMapper<NewEntity> {
}
```

#### 3. 创建 Service

```java
@Service
public class NewEntityServiceImpl extends ServiceImpl<NewEntityMapper, NewEntity> 
    implements NewEntityService {
}
```

#### 4. 创建 Controller

```java
@RestController
@RequestMapping("/newEntity")
@Tag(name = "新模块管理")
public class NewEntityController {

    @Autowired
    private NewEntityService service;

    @GetMapping
    public Result<PageDTO<NewEntity>> list(PageQuery pageQuery) {
        Page<NewEntity> page = service.page(pageQuery.toMpPage());
        return Result.ok(PageDTO.of(page));
    }
}
```

---

## 🚢 部署指南

### 生产环境部署

#### 1. 修改配置

```yaml
knife4j:
  production: true                    # 关闭 API 文档

logging:
  level:
    root: WARN
    com.smart.www: INFO
```

#### 2. 打包

```bash
mvn clean package -DskipTests
```

#### 3. 运行

```bash
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar \
  --spring.profiles.active=prod \
  --server.port=8718
```

### Docker 部署

```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/SmartSchool-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8718
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## ❓ 常见问题

### 1. AI 功能无法使用？

**原因**：DashScope API Key 未配置或无效

**解决**：

1. 访问 https://dashscope.console.aliyun.com/
2. 获取 API Key
3. 在 `application.yaml` 中配置

### 2. 数据库连接失败？

**原因**：数据库配置错误或数据库未启动

**解决**：

1. 检查 MySQL 是否启动
2. 检查数据库名、用户名、密码是否正确
3. 检查数据库是否已创建

### 3. Redis 连接失败？

**原因**：Redis 未启动或配置错误

**解决**：

1. 启动 Redis：`redis-server`
2. 检查 Redis 配置

---

## 📄 许可证

本项目采用 Apache 2.0 许可证。详见 [LICENSE](LICENSE) 文件。

---

## 👥 贡献指南

欢迎贡献代码！请遵循以下步骤：

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

---

<div align="center">

**如果这个项目对你有帮助，请给一个 ⭐️ Star！**

Made with ❤️ by Smart Campus Team

</div>
