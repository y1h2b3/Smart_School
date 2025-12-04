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

### 2. RAG 检索增强

#### 架构说明

```
用户问题 → 向量化 → 相似度检索 → 上下文增强 → AI 生成回答
```

#### 组件说明

**文档加载器**：加载健康知识文档
**向量存储**：PGVector（PostgreSQL 扩展）
**文档检索器**：基于相似度的文档检索
**Advisor 配置**：QuestionAnswerAdvisor

### 3. Function Calling 工具

- **FileOperationTool**：文件读写操作
- **PDFGenerationTool**：PDF 文档生成
- **WebScrapingTool**：网页内容抓取
- **WebSearchTool**：网络搜索

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
