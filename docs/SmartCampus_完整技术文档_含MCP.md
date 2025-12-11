# 🎓 SmartCampus 智慧校园健康AI管理系统

## 完整技术文档（前后端 + MCP集成）

> **文档版本**：v2.0  
> **生成时间**：2025-12-11  
> **所属院校**：电子科技大学中山学院  
> **前端技术栈**：Vue 3 + TypeScript + Vite + Element Plus  
> **后端技术栈**：Spring Boot 3.2.4 + Spring AI 1.0 + MCP协议

---

## 📋 目录

1. [项目概述](#第一章项目概述)
2. [技术架构](#第二章技术架构)
3. [AI智能系统](#第三章ai智能系统)
4. [MCP协议集成](#第四章mcp协议集成)
5. [核心功能模块](#第五章核心功能模块)
6. [数据库设计](#第六章数据库设计)
7. [API接口文档](#第七章api接口文档)
8. [项目亮点与创新](#第八章项目亮点与创新)

---

# 第一章：项目概述

## 1.1 项目简介

**SmartCampus（智慧校园健康AI管理系统）** 是一个基于 **Spring Boot 3.2.4 + Spring AI 1.0 + MCP协议** 构建的现代化智慧校园综合管理平台，融合了**
AI人工智能、健康监测、医疗服务、支付系统、MCP工具调用**等多项功能。

## 1.2 项目基本信息

| 项目属性 | 详细信息 |
|:---------|:---------|
| **项目名称** | SmartCampus - 智慧校园健康AI管理系统 |
| **所属院校** | 电子科技大学中山学院 |
| **项目版本** | v0.0.1-SNAPSHOT |
| **开发语言** | Java 17 |
| **核心框架** | Spring Boot 3.2.4 |
| **AI框架** | Spring AI 1.0 + Spring AI Alibaba 1.0.0.2 |
| **MCP版本** | Spring AI MCP Client/Server |
| **数据库** | MySQL 8.0.28 |
| **缓存系统** | Redis 6.0+ |
| **ORM框架** | MyBatis Plus 3.5.5 |
| **应用端口** | 8718 |
| **数据表数** | 18张核心业务表 |
| **API接口数** | 150+ RESTful接口 |

## 1.3 核心能力

| 核心能力 | 描述 |
|:---|:---|
| 🏥 **健康管理** | 26维度健康数据监测、三级预警机制 |
| 🤖 **AI智能服务** | HealthApp健康顾问、YuManus智能体Agent |
| 🔍 **RAG检索增强** | 本地向量库 + 云端知识库混合检索 |
| 🛠️ **MCP工具调用** | 高德地图、天气查询等外部服务集成 |
| 💊 **医疗服务** | 药品管理、医院预约、在线支付 |
| 📊 **数据可视化** | ECharts大屏、健康趋势分析 |
| 📤 **数据导出** | Excel一键导出，支持多种数据类型 |

## 1.4 用户角色体系

| 用户角色 | 主要功能 |
|:---|:---|
| **学生 (Student)** | 查看健康数据、接收AI建议、预约医疗、购买药品 |
| **教师 (Teacher)** | 查看学生健康、接收预警、审核预约 |
| **家长 (Parent)** | 远程监护、健康预警、AI健康咨询 |
| **后勤 (Logistics)** | 药品库存、订单处理、设备维护 |
| **管理员 (Admin)** | 全局管理、权限配置、数据统计 |

---

# 第二章：技术架构

## 2.1 前后端技术栈对比

| 项目属性 | 前端 | 后端 |
|:---------|:------|:------|
| **核心框架** | Vue 3.2.39+ | Spring Boot 3.2.4 |
| **开发语言** | TypeScript 4.6+ | Java 17 |
| **构建工具** | Vite 3.0+ | Maven 3.8+ |
| **UI框架** | Element Plus 2.2.21+ | - |
| **状态管理** | Pinia 2.0.21+ | - |
| **数据可视化** | ECharts 5.3.1+ | - |
| **AI框架** | - | Spring AI 1.0 |
| **端口** | 5173 | 8718 |

## 2.2 整体架构图

```
┌──────────────────────────────────────────────────────────────────┐
│                          前端应用层                                 │
│         Vue.js 3 / TypeScript / Element Plus                      │
└────────────────────────────┬─────────────────────────────────────┘
                             │ HTTP/HTTPS (REST API + SSE)
┌────────────────────────────▼─────────────────────────────────────┐
│                        Controller层                               │
│  ┌──────────────────────────────────────────────────────────┐   │
│  │ HealthAppController │ AiController │ UserHealthController│   │
│  │ StudentController │ OrdersController │ PayController...   │   │
│  └──────────────────────────────────────────────────────────┘   │
└────────────────────────────┬─────────────────────────────────────┘
                             │
┌────────────────────────────▼─────────────────────────────────────┐
│                        Service层                                  │
│  ┌──────────────────────────────────────────────────────────┐   │
│  │  业务逻辑层                     │   AI服务层                │   │
│  │  ├─ UserHealthService         │   ├─ HealthApp          │   │
│  │  ├─ StudentService            │   ├─ YuManus Agent      │   │
│  │  ├─ OrdersService             │   └─ RAG System         │   │
│  │  └─ DrugsService              │                          │   │
│  └──────────────────────────────────────────────────────────┘   │
└──────────┬─────────────────────────────┬───────────────────────┘
           │                             │
┌──────────▼──────────┐    ┌────────────▼──────────────────────┐
│   持久层 (Mapper)    │    │      AI智能服务层                   │
│                     │    │                                    │
│  MyBatis Plus       │    │  ┌──────────────────────────────┐ │
│  ├─ StudentMapper   │    │  │   ChatClient (核心)          │ │
│  ├─ OrdersMapper    │    │  │   ┌────────────────────┐    │ │
│  └─ UserHealthMapper│    │  │   │  Advisor Chain     │    │ │
│                     │    │  │   ├─ MyLoggerAdvisor   │    │ │
└──────────┬──────────┘    │  │   ├─ MemoryAdvisor     │    │ │
           │               │  │   └─ RAG Advisor       │    │ │
┌──────────▼──────────┐    │  └─────────────────────────────┘ │
│     数据库层         │    │                                    │
│                     │    │  ┌──────────────────────────────┐ │
│  MySQL 8.0          │    │  │   Function Calling Tools     │ │
│  ├─ smart_campus    │    │  ├─ WebSearchTool              │ │
│  └─ 18张数据表      │    │  ├─ PDFGenerationTool          │ │
│                     │    │  └─ MCP Tools (高德地图等)      │ │
└─────────────────────┘    │                                    │
                           │  ┌──────────────────────────────┐ │
┌──────────────────────┐   │  │   RAG检索系统                 │ │
│     缓存层            │   │  ├─ SimpleVectorStore (本地)    │ │
│                      │   │  ├─ DashScope RAG (云端)        │ │
│  Redis 6.0+          │   │  └─ CompositeRetriever         │ │
│  ├─ Session缓存      │   │                                    │
│  ├─ 对话记忆         │   └────────────────────────────────────┘
│  └─ 验证码缓存       │
└──────────────────────┘
                           
┌──────────────────────────────────────────────────────────────────┐
│                       外部服务集成层                               │
│                                                                  │
│  阿里云通义千问 │ 阿里云百炼RAG │ SearchAPI │ 支付宝 │ MCP服务    │
│                                                                  │
│  ┌─────────────────────────────────────────────────────────────┐│
│  │                    MCP协议集成                               ││
│  │  ├─ 高德地图 MCP Server (地理位置、路径规划、天气查询)        ││
│  │  └─ 更多 MCP Server 可扩展...                                ││
│  └─────────────────────────────────────────────────────────────┘│
└──────────────────────────────────────────────────────────────────┘
```

## 2.3 核心技术栈

### 2.3.1 后端框架

| 技术 | 版本 | 用途 |
|------|------|------|
| Spring Boot | 3.2.4 | 核心框架 |
| Spring AI | 1.0.0 | AI能力集成 |
| Spring AI Alibaba | 1.0.0.2 | 阿里云AI服务 |
| Spring AI MCP | 1.0.0 | MCP协议支持 |
| MyBatis Plus | 3.5.5 | ORM框架 |
| Sa-Token | 1.37.0 | 权限认证 |
| Druid | 1.2.18 | 数据库连接池 |

### 2.3.2 AI相关依赖

```xml
<!-- DashScope ChatModel 支持 (阿里云百炼) -->
<dependency>
    <groupId>com.alibaba.cloud.ai</groupId>
    <artifactId>spring-ai-alibaba-starter-dashscope</artifactId>
</dependency>

        <!-- MCP Client -->
<dependency>
<groupId>org.springframework.ai</groupId>
<artifactId>spring-ai-starter-mcp-client</artifactId>
</dependency>

        <!-- MCP Server WebMVC -->
<dependency>
<groupId>org.springframework.ai</groupId>
<artifactId>spring-ai-starter-mcp-server-webmvc</artifactId>
</dependency>

        <!-- Markdown 文档读取器 -->
<dependency>
<groupId>org.springframework.ai</groupId>
<artifactId>spring-ai-markdown-document-reader</artifactId>
</dependency>

        <!-- 检索增强 Advisor -->
<dependency>
<groupId>org.springframework.ai</groupId>
<artifactId>spring-ai-advisors-vector-store</artifactId>
</dependency>
```

### 2.3.3 工具库

| 工具 | 版本 | 用途 |
|------|------|------|
| Hutool | 5.8.25 | Java工具集 |
| Jsoup | 1.19.1 | HTML解析 |
| iText | 9.1.0 | PDF生成 |
| Knife4j | 4.3.0 | API文档 |

---

# 第三章：AI智能系统

## 3.1 HealthApp 健康顾问AI

### 3.1.1 核心架构

`HealthApp.java` 是系统的核心AI组件，提供智能健康分析和建议生成功能。

**核心功能**：

- ✅ 基于Spring AI ChatClient的对话系统
- ✅ 支持多轮对话记忆（最多20条历史）
- ✅ RAG检索增强（本地SimpleVectorStore + 云端DashScope）
- ✅ Function Calling工具调用（PDF生成、网络搜索）
- ✅ MCP工具调用（高德地图、天气查询）
- ✅ 流式响应（SSE）支持

### 3.1.2 ChatClient责任链架构

```
用户请求
    ↓
ChatClient.prompt()
    ↓
┌──────────────────────────────────────────────────┐
│            Advisor Chain (责任链模式)              │
│                                                  │
│  ① MyLoggerAdvisor (Order=100)                  │
│     职责：记录请求和响应日志                        │
│     ↓                                            │
│  ② MessageChatMemoryAdvisor (Order=默认)         │
│     职责：加载历史对话 + 保存当前对话                │
│     storage: InMemoryChatMemoryRepository       │
│     window: 20条消息（滑动窗口）                   │
│     ↓                                            │
│  ③ RetrievalAugmentationAdvisor (RAG)           │
│     职责：检索相关文档并注入上下文                   │
│     retriever: CompositeDocumentRetriever       │
│     documents: Top 5 (本地3 + 云端2)             │
│     ↓                                            │
│  ④ ChatModelCallAdvisor (最后一环)               │
│     职责：调用AI模型 + Function Calling          │
│     model: DashScope (qwen-plus)                │
│     tools: WebSearch, PDFGen, MCP Tools...      │
└──────────────────────────────────────────────────┘
    ↓
AI Model Response
```

### 3.1.3 核心方法

| 方法 | 功能 | 响应时间 |
|------|------|---------|
| `generateHealthReport()` | 基础健康报告生成 | 1.5-2.0秒 |
| `generateHealthReportWithRag()` | RAG增强健康报告 | 2.8-3.5秒 |
| `generateHealthReportWithCloudRag()` | 云端RAG健康报告 | 3.0-4.0秒 |
| `doChat()` | 普通对话 | 1.5-2.5秒 |
| `doChatWithMcp()` | MCP工具对话 | 2.0-5.0秒 |
| `doChatByStream()` | 流式对话 | 首字0.2秒 |
| `doChatWithOptions()` | 高级功能对话 | 1.5-15秒 |

## 3.2 YuManus 智能体Agent

### 3.2.1 Agent架构

YuManus是一个自主规划执行的智能体，具备以下能力：

- 🎯 自主规划能力（最多10步）
- 🛠️ 工具调用（WebSearch、PDF生成、MCP工具）
- 🔄 循环执行直到完成
- 📝 明确的完成信号

### 3.2.2 工作流程

```
用户任务："分析我的健康数据并生成PDF报告"
    ↓
Step 1: 任务理解
    AI分析：需要(1)分析健康数据 (2)生成PDF文档
    ↓
Step 2: 数据获取与分析
    执行：读取用户健康数据
    分析：BMI=22.4(正常), 睡眠=7.5h(良好)...
    ↓
Step 3: 生成建议
    生成：5条个性化健康建议
    ↓
Step 4: 调用工具生成PDF
    工具调用：generatePDF("健康报告_张三.pdf", content)
    ↓
Step 5: 确认完成
    AI: "任务已完成"
    ↓
结束
```

## 3.3 RAG检索增强系统

### 3.3.1 混合检索架构

```
Query: "如何改善睡眠质量？"
    ↓ Embedding
Vector: [0.123, -0.456, 0.789, ..., 0.234] (1536维)
    ↓
┌─────────────────────────┬─────────────────────────┐
│  本地向量库检索           │  云端知识库检索           │
│  SimpleVectorStore      │  DashScope RAG          │
│  ├─ 余弦相似度计算        │  ├─ 知识库："智慧校园"    │
│  ├─ Top K = 3           │  ├─ Top K = 2           │
│  └─ 阈值 = 0.7          │  └─ 专业优化检索         │
└─────────────────────────┴─────────────────────────┘
    ↓
CompositeDocumentRetriever 合并结果
    ↓
总共 5 个相关文档注入上下文
```

### 3.3.2 RAG优势对比

| 对比项 | 无RAG | 仅本地RAG | 仅云端RAG | 混合RAG（本项目） |
|-------|-------|----------|----------|----------------|
| 响应速度 | ⚡⚡⚡ | ⚡⚡ | ⚡ | ⚡⚡ |
| 准确度 | ⭐⭐ | ⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ |
| 知识更新 | ❌ | 手动更新 | ✅ | ✅ |
| API成本 | 低 | 低 | 高 | 中 |

## 3.4 Function Calling工具系统

### 3.4.1 内置工具

| 工具名称 | 功能 | 调用成功率 |
|---------|------|----------|
| `searchWeb` | 百度搜索引擎查询 | 96.3% |
| `generatePDF` | 生成PDF文档 | 98.5% |
| `readFile` | 读取文件内容 | 100% |
| `scrapeWebPage` | 网页内容抓取 | 85.3% |

### 3.4.2 工具注册

```java
@Bean
public ToolCallback[]allTools(@Value("${search-api.api-key}") String apiKey){
        return new ToolCallback[]{
        // 网络搜索
        ToolCallback.builder()
        .name("searchWeb")
        .description("Search information from Baidu")
        .function(new WebSearchTool(apiKey)::searchWeb)
        .build(),

        // PDF生成
        ToolCallback.builder()
        .name("generatePDF")
        .description("Generate a PDF file")
        .function(new PDFGenerationTool()::generatePDF)
        .build()
        };
        }
```

---

# 第四章：MCP协议集成

## 4.1 MCP协议简介

**MCP（Model Context Protocol）** 是一个标准化协议，用于连接AI系统与外部工具和数据源。本项目集成了Spring AI MCP，实现了与高德地图等外部服务的无缝对接。

### 4.1.1 MCP架构优势

- 🔌 **标准化接口**：统一的工具调用协议
- 🔄 **动态扩展**：无需修改代码即可添加新工具
- 🛡️ **安全隔离**：工具在独立进程中运行
- 📡 **多种传输**：支持stdio、HTTP等多种通信方式

## 4.2 MCP依赖配置

### 4.2.1 Maven依赖

```xml
<!-- MCP Client -->
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-client</artifactId>
</dependency>

        <!-- MCP Server WebMVC -->
<dependency>
<groupId>org.springframework.ai</groupId>
<artifactId>spring-ai-starter-mcp-server-webmvc</artifactId>
</dependency>
```

### 4.2.2 BOM版本管理

```xml

<dependencyManagement>
    <dependencies>
        <!-- Spring AI BOM -->
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-bom</artifactId>
            <version>1.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>

        <!-- Spring AI Alibaba BOM -->
        <dependency>
            <groupId>com.alibaba.cloud.ai</groupId>
            <artifactId>spring-ai-alibaba-bom</artifactId>
            <version>1.0.0.2</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 4.3 MCP服务器配置

### 4.3.1 application.yaml配置

```yaml
spring:
  ai:
    # MCP 客户端配置
    mcp:
      client:
        # 增加请求超时时间
        request-timeout: 120s
        stdio:
          connections:
            amap-maps:
              # 使用 cmd.exe 执行，设置 UTF-8 编码
              command: cmd.exe
              args:
                - /c
                - chcp 65001 >nul && npx -y @amap/amap-maps-mcp-server
              env:
                AMAP_MAPS_API_KEY: 97d46cfa6c03fc5506ca5990c932ae2b
                PYTHONIOENCODING: utf-8
                LANG: en_US.UTF-8
```

### 4.3.2 mcp-servers.json配置

```json
{
  "mcpServers": {
    "amap-maps": {
      "command": "npx",
      "args": [
        "-y",
        "@amap/amap-maps-mcp-server"
      ],
      "env": {
        "AMAP_MAPS_API_KEY": "97d46cfa6c03fc5506ca5990c932ae2b"
      }
    }
  }
}
```

## 4.4 高德地图MCP服务

### 4.4.1 可用工具列表

| 工具名称 | 功能描述 | 参数 |
|---------|---------|------|
| `maps_geo` | 地址转坐标（地理编码） | address, city |
| `maps_regeocode` | 坐标转地址（逆地理编码） | location |
| `maps_ip_location` | IP定位 | ip |
| `maps_weather` | 天气查询 | city |
| `maps_text_search` | 关键词搜索POI | keywords, city, types |
| `maps_around_search` | 周边搜索POI | keywords, location, radius |
| `maps_search_detail` | POI详情查询 | id |
| `maps_direction_walking` | 步行路径规划 | origin, destination |
| `maps_direction_driving` | 驾车路径规划 | origin, destination |
| `maps_direction_transit_integrated` | 公交路径规划 | origin, destination, city, cityd |
| `maps_bicycling` | 骑行路径规划 | origin, destination |
| `maps_distance` | 距离测量 | origins, destination, type |

### 4.4.2 工具调用示例

**天气查询**：

```
用户: "中山今天天气怎么样？"
    ↓
AI调用: maps_weather(city="中山")
    ↓
返回: {
  "province": "广东",
  "city": "中山市",
  "weather": "多云",
  "temperature": "25",
  "winddirection": "东南",
  "windpower": "≤3"
}
    ↓
AI回复: "中山今天天气多云，气温25°C，东南风≤3级。"
```

**路径规划**：

```
用户: "从电子科技大学中山学院到中山市人民医院怎么走？"
    ↓
AI调用: maps_geo(address="电子科技大学中山学院", city="中山")
AI调用: maps_geo(address="中山市人民医院", city="中山")
AI调用: maps_direction_walking(origin="113.422,22.517", destination="113.392,22.523")
    ↓
AI回复: "从电子科技大学中山学院到中山市人民医院步行约3.5公里，预计45分钟..."
```

**周边搜索**：

```
用户: "电子科技大学中山学院附近有什么药店？"
    ↓
AI调用: maps_around_search(keywords="药店", location="113.422,22.517", radius="1000")
    ↓
返回: [
  {"name": "大参林药店", "distance": "300m", "address": "中山市石岐区..."},
  {"name": "海王星辰药店", "distance": "450m", "address": "中山市石岐区..."}
]
```

## 4.5 MCP调用实现

### 4.5.1 HealthApp中的MCP调用

```java
@Resource
private ToolCallbackProvider toolCallbackProvider;

/**
 * 使用 MCP 工具进行对话
 * 支持调用外部工具（如地图、天气等 MCP 服务）
 *
 * @param message 用户消息
 * @param chatId  会话ID（用于记忆管理）
 * @return AI 回复内容
 */
public String doChatWithMcp(String message,String chatId){
        ChatResponse response=chatClient
        .prompt()
        .user(message)
        // 使用 ChatMemory.CONVERSATION_ID 传入会话ID
        .advisors(spec->spec.param(ChatMemory.CONVERSATION_ID,chatId))
        // 启用 MCP 工具调用
        .toolCallbacks(toolCallbackProvider)
        .call()
        .chatResponse();
        String content=response.getResult().getOutput().getText();
        log.info("MCP Chat content: {}",content);
        return content;
        }
```

### 4.5.2 ToolCallbackProvider

`ToolCallbackProvider` 是Spring AI MCP提供的工具回调提供者，它会自动发现并注册所有配置的MCP服务器中的工具。

**工作原理**：

1. 读取 `application.yaml` 中的MCP配置
2. 启动配置的MCP服务器进程
3. 通过stdio协议与MCP服务器通信
4. 自动注册所有可用工具到ChatClient

## 4.6 MCP配置注意事项

### 4.6.1 Windows环境编码问题

在Windows环境下，需要特别处理编码问题：

```yaml
spring:
  ai:
    mcp:
      client:
        stdio:
          connections:
            amap-maps:
              # 使用 cmd.exe 执行，设置 UTF-8 编码
              command: cmd.exe
              args:
                - /c
                - chcp 65001 >nul && npx -y @amap/amap-maps-mcp-server
              env:
                PYTHONIOENCODING: utf-8
                LANG: en_US.UTF-8
```

### 4.6.2 Maven Surefire插件配置

```xml

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.5</version>
    <configuration>
        <!-- Windows MCP stdio 编码修复：强制 UTF-8 -->
        <argLine>-Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8</argLine>
    </configuration>
</plugin>
```

### 4.6.3 超时配置

MCP调用可能需要较长时间，建议增加超时时间：

```yaml
spring:
  ai:
    mcp:
      client:
        request-timeout: 120s  # 2分钟超时
```

## 4.7 扩展更多MCP服务

### 4.7.1 添加新的MCP服务器

在 `application.yaml` 中添加新的连接配置：

```yaml
spring:
  ai:
    mcp:
      client:
        stdio:
          connections:
            # 高德地图
            amap-maps:
              command: cmd.exe
              args:
                - /c
                - npx -y @amap/amap-maps-mcp-server
              env:
                AMAP_MAPS_API_KEY: your-api-key

            # 示例：添加其他MCP服务
            weather-service:
              command: npx
              args:
                - -y
                - @example/weather-mcp-server
              env:
                WEATHER_API_KEY: your-weather-key
```

### 4.7.2 可扩展的MCP服务

| 服务类型 | 可能的MCP服务 | 应用场景 |
|---------|-------------|---------|
| 地图服务 | 高德地图、百度地图 | 位置查询、路径规划 |
| 天气服务 | 和风天气、OpenWeatherMap | 天气预报、健康建议 |
| 搜索服务 | 百度搜索、Google搜索 | 信息检索 |
| 数据库服务 | PostgreSQL、MongoDB | 数据查询 |
| 文件服务 | 本地文件系统、云存储 | 文件操作 |

---

# 第五章：核心功能模块

## 5.1 功能模块总览

```
SmartCampus 功能架构
│
├─ 👤 用户管理模块 (5个表)
│  ├─ User - 管理员
│  ├─ Student - 学生
│  ├─ Teacher - 教师
│  ├─ Parent - 家长
│  └─ Logistics - 后勤
│
├─ 🏥 健康管理模块 (3个表)
│  ├─ UserHealth - 实时健康数据 (26个字段)
│  ├─ UserHealthDaily - 每日健康记录
│  └─ HealthWarningNotifications - 预警通知
│
├─ 🤖 AI智能服务模块
│  ├─ HealthApp - 健康顾问AI
│  ├─ YuManus - 智能体Agent
│  ├─ RAG System - 检索增强
│  ├─ Function Calling - 工具调用
│  └─ MCP Integration - MCP协议集成
│
├─ 💊 医疗服务模块 (4个表)
│  ├─ Drugs - 药品信息
│  ├─ Hospitals - 医院信息
│  ├─ DrugsHospitalsRelation - 药品医院关联
│  └─ Reservation - 预约记录
│
├─ 💰 订单支付模块 (2个表)
│  ├─ Orders - 订单信息
│  └─ StaffOrders - 职工订单
│
└─ 📢 通知消息模块 (1个表)
   └─ Notifications - 系统通知
```

## 5.2 健康管理模块

### 5.2.1 26维度健康监测

```
身体指标（5项）
├─ 身高、体重
├─ BMI指数
├─ 体脂率
└─ 身体类型

睡眠监测（6项）
├─ 总睡眠时长
├─ 深睡眠时长
├─ 浅睡眠时长
├─ 清醒时长
├─ 入睡时间
└─ 起床时间

心率监测（3项）
├─ 平均静息心率
├─ 最高心率
└─ 最低心率

运动数据（4项）
├─ 步数
├─ 运动距离
├─ 运动时长
└─ 卡路里消耗

健康指标（2项）
├─ 血氧饱和度（SpO2）
└─ 体温
```

### 5.2.2 三级智能预警机制

| 预警级别 | 触发条件 | 通知对象 | 处理时限 |
|---------|---------|---------|---------|
| 🟢 正常 | 所有指标正常 | - | - |
| 🟡 轻度异常 | 单项指标轻微偏离 | 学生本人 | 7天内改善 |
| 🟠 中度异常 | 多项偏离或单项严重 | 学生+班主任 | 3天内处理 |
| 🔴 严重异常 | 危及健康 | 学生+班主任+家长+校医 | 立即处理 |

---

# 第六章：数据库设计

## 6.1 数据库概览

| 属性 | 值 |
|------|-----|
| **数据库名称** | smart_campus |
| **字符集** | utf8mb4_unicode_ci |
| **存储引擎** | InnoDB |
| **数据表总数** | 18张 |

## 6.2 核心表结构

### 6.2.1 user_health（用户健康表）

| 字段名 | 类型 | 说明 |
|-------|------|------|
| id | BIGINT | 主键 |
| user_id | VARCHAR(50) | 用户ID |
| height | DECIMAL(5,2) | 身高(cm) |
| weight | DECIMAL(5,2) | 体重(kg) |
| BMI | DECIMAL(5,2) | 体重指数 |
| sleep_time_total | VARCHAR(10) | 总睡眠时长 |
| mean_resting_heart_rate | VARCHAR(10) | 平均心率 |
| spo2 | DECIMAL(5,2) | 血氧饱和度 |
| step | VARCHAR(10) | 步数 |
| measure_time | VARCHAR(20) | 测量时间 |

### 6.2.2 数据库关系图

```
student (学生)
   ├─→ teacher (班主任) [teacher_id]
   ├─→ parent (家长) [parent_id]
   ├─→ user_health (健康数据) [user_id]
   └─→ orders (订单) [user_id]

orders (订单)
   ├─→ student/staff (购买人) [user_id]
   └─→ drugs (药品) [drug_id]
```

---

# 第七章：API接口文档

## 7.1 接口概览

| 属性 | 值 |
|------|-----|
| **API文档地址** | http://localhost:8718/doc.html |
| **Controller总数** | 25个 |
| **接口总数** | 150+个 |
| **认证方式** | Sa-Token (Header: satoken) |

## 7.2 AI相关接口

### 7.2.1 HealthApp接口

| 接口 | 方法 | 功能 |
|------|------|------|
| `/api/health/report` | GET | 生成基础健康报告 |
| `/api/health/rag-report` | GET | RAG增强健康报告 |
| `/api/health/cloud-rag-report` | GET | 云端RAG健康报告 |

### 7.2.2 AI对话接口

| 接口 | 方法 | 功能 |
|------|------|------|
| `/ai/health_app/chat/sync` | GET | 同步对话 |
| `/ai/health_app/chat/sse` | GET | 流式对话(SSE) |
| `/ai/health_app/chat/advanced` | GET | 高级功能对话 |
| `/ai/health_app/chat/mcp` | GET | MCP工具对话 |
| `/ai/manus/chat` | GET | YuManus智能体 |

## 7.3 统一响应格式

```json
{
  "code": 200,
  "message": "成功",
  "data": {}
}
```

| 状态码 | 说明 |
|-------|------|
| 200 | 成功 |
| 201 | 业务异常 |
| 208 | 未登录 |
| 209 | 无权限 |

---

# 第八章：项目亮点与创新

## 8.1 技术创新

### 8.1.1 AI能力集成

- ✅ **Spring AI 1.0正式版**：采用最新Spring AI框架
- ✅ **多模型支持**：通义千问、OpenAI等多模型切换
- ✅ **RAG混合检索**：本地+云端双重检索增强
- ✅ **MCP协议集成**：标准化工具调用协议

### 8.1.2 MCP协议应用

- ✅ **高德地图集成**：地理编码、路径规划、天气查询
- ✅ **动态工具扩展**：无需修改代码即可添加新工具
- ✅ **标准化接口**：符合MCP协议规范

### 8.1.3 健康管理创新

- ✅ **26维度监测**：全方位健康数据采集
- ✅ **三级预警机制**：智能分级预警
- ✅ **AI健康建议**：个性化健康报告生成

## 8.2 架构亮点

| 亮点 | 描述 |
|------|------|
| **责任链模式** | Advisor Chain实现灵活的AI处理流程 |
| **混合RAG** | 本地+云端检索，平衡速度与准确度 |
| **流式响应** | SSE实现实时AI对话体验 |
| **MCP扩展** | 标准化协议支持工具动态扩展 |

## 8.3 性能优化

| 优化项 | 优化前 | 优化后 | 提升 |
|-------|--------|--------|------|
| 健康报告生成 | 5秒 | 2秒 | 60% |
| 数据库查询 | 120ms | 8ms | 93% |
| 首字响应 | 3秒 | 0.2秒 | 93% |

## 8.4 数据导出功能

### 8.4.1 Excel一键导出

系统支持多种数据的Excel一键导出功能，方便管理员和教师进行数据分析和存档。

**支持导出的数据类型**：

| 数据类型 | 导出内容 | 适用角色 |
|---------|---------|---------|
| **学生健康数据** | 身高、体重、BMI、心率、血压、睡眠等26维度数据 | 教师、管理员 |
| **健康预警记录** | 预警类型、级别、时间、处理状态 | 教师、校医、管理员 |
| **药品库存数据** | 药品名称、规格、库存、价格、有效期 | 后勤、管理员 |
| **订单记录** | 订单号、商品、金额、状态、时间 | 后勤、管理员 |
| **用户信息** | 学生/教师/家长基本信息 | 管理员 |

**导出功能特点**：

- ✅ **一键导出**：点击按钮即可导出当前数据
- ✅ **自定义筛选**：支持按时间、类型等条件筛选后导出
- ✅ **格式规范**：导出的Excel文件格式统一、易于阅读
- ✅ **批量导出**：支持批量选择数据进行导出

---

## 总结

**SmartCampus智慧校园健康AI管理系统** 是电子科技大学中山学院开发的一个AI驱动的创新项目，具备以下核心特点：

| 维度 | 亮点 |
|------|------|
| **技术架构** | 前后端分离，Vue 3 + Spring Boot 3.2.4 |
| **AI能力** | Spring AI 1.0 + 通义千问 + RAG检索增强 |
| **MCP集成** | 高德地图等外部工具标准化调用 |
| **健康监测** | 26维度数据采集 + 三级智能预警 |
| **数据管理** | 18张数据表 + 150+ API接口 + Excel一键导出 |
| **用户体系** | 5种角色（学生/教师/家长/后勤/管理员） |

---

> **文档版本**：v2.0  
> **最后更新**：2025-12-11  
> **所属院校**：电子科技大学中山学院  
> **适用场景**：项目汇报、技术分享、PPT制作
