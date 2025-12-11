# AI 对话高级功能接口文档

## 概述

新增支持**联网搜索**和**深度思考**开关的 AI 对话接口，提供同步和流式两种调用方式。

---

## 接口列表

### 1. 同步对话（支持开关）

**接口地址**: `GET /ai/health_app/chat/advanced`

**参数**:

- `message` (必填): 用户消息
- `chatId` (必填): 会话ID，用于维护对话上下文
- `enableWebSearch` (可选，默认 false): 是否启用联网搜索
- `enableDeepThinking` (可选，默认 false): 是否启用深度思考

**示例**:

```bash
# 普通对话
curl "http://localhost:8718/ai/health_app/chat/advanced?message=你好&chatId=test001"

# 启用联网搜索
curl "http://localhost:8718/ai/health_app/chat/advanced?message=今天北京的天气如何&chatId=test001&enableWebSearch=true"

# 启用深度思考
curl "http://localhost:8718/ai/health_app/chat/advanced?message=如何提高睡眠质量&chatId=test001&enableDeepThinking=true"

# 同时启用联网搜索和深度思考
curl "http://localhost:8718/ai/health_app/chat/advanced?message=2024年人工智能发展趋势&chatId=test001&enableWebSearch=true&enableDeepThinking=true"
```

---

### 2. 流式对话（Flux 方式）

**接口地址**: `GET /ai/health_app/chat/advanced/stream`

**响应类型**: `text/event-stream`

**参数**: 与同步接口相同

**示例**:

```bash
curl -N "http://localhost:8718/ai/health_app/chat/advanced/stream?message=介绍一下健康饮食&chatId=test002&enableDeepThinking=true"
```

---

### 3. 流式对话（SseEmitter 方式）

**接口地址**: `GET /ai/health_app/chat/advanced/emitter`

**参数**: 与同步接口相同

**特点**:

- 超时时间: 3分钟
- 自动管理连接生命周期
- 适用于长时间对话

**示例**:

```bash
curl -N "http://localhost:8718/ai/health_app/chat/advanced/emitter?message=分析当前全球经济形势&chatId=test003&enableWebSearch=true&enableDeepThinking=true"
```

---

## 功能说明

### 联网搜索 (enableWebSearch)

- **功能**: 通过 `WebSearchTool` 实时获取网络信息
- **适用场景**:
    - 查询实时数据（天气、新闻、股票等）
    - 需要最新信息的问题
    - 事实性查询
- **注意**: 会增加响应时间（需要调用搜索 API）

### 深度思考 (enableDeepThinking)

- **功能**: 通过增强提示词引导 AI 进行更深入的分析
- **适用场景**:
    - 复杂问题分析
    - 需要多角度思考
    - 需要详细推理过程
    - 战略规划类问题
- **效果**:
    - 回答更详细
    - 包含推理过程
    - 多角度分析

---

## PowerShell 测试命令

由于 PowerShell 中的 `curl` 是 `Invoke-WebRequest` 的别名，不支持 `-N` 参数，建议使用以下方式测试：

### 同步接口测试

```powershell
# 普通对话
Invoke-WebRequest -Uri "http://localhost:8718/ai/health_app/chat/advanced?message=你好&chatId=test001" -Method Get

# 启用联网搜索
Invoke-WebRequest -Uri "http://localhost:8718/ai/health_app/chat/advanced?message=今天的新闻&chatId=test001&enableWebSearch=true" -Method Get

# 启用深度思考
Invoke-WebRequest -Uri "http://localhost:8718/ai/health_app/chat/advanced?message=如何学习编程&chatId=test001&enableDeepThinking=true" -Method Get
```

### 流式接口测试（需要额外工具）

```powershell
# 使用 curl.exe（非 PowerShell 别名）
curl.exe -N "http://localhost:8718/ai/health_app/chat/advanced/stream?message=介绍Spring Boot&chatId=test002"
```

---

## 实现细节

### HealthApp.java 新增方法

#### 1. `doChatWithOptions()` - 同步对话

```java
public String doChatWithOptions(String message, String chatId, 
                                boolean enableWebSearch, boolean enableDeepThinking)
```

#### 2. `doChatByStreamWithOptions()` - 流式对话

```java
public Flux<String> doChatByStreamWithOptions(String message, String chatId, 
                                              boolean enableWebSearch, boolean enableDeepThinking)
```

### 核心逻辑

1. **深度思考**: 通过在原始消息前添加引导性提示词实现
   ```java
   "请深入思考以下问题，分析多个角度并给出详细的推理过程：\n" + message
   ```

2. **联网搜索**: 动态添加 `allTools`（包含 WebSearchTool）
   ```java
   if (enableWebSearch) {
       promptSpec = promptSpec.toolCallbacks(allTools);
   }
   ```

---

## 已有接口对比

| 接口路径 | 类型 | 功能 | 开关支持 |
|---------|------|------|---------|
| `/ai/health_app/chat/sync` | 同步 | 基础对话 | ❌ |
| `/ai/health_app/chat/sse` | 流式 | 基础流式对话 | ❌ |
| `/ai/health_app/chat/advanced` | 同步 | **高级对话** | ✅ 联网+深度思考 |
| `/ai/health_app/chat/advanced/stream` | 流式 | **高级流式对话** | ✅ 联网+深度思考 |
| `/ai/health_app/chat/advanced/emitter` | 流式 | **高级流式对话(Emitter)** | ✅ 联网+深度思考 |

---

## 测试建议

### 测试场景 1: 联网搜索

```bash
# 查询实时天气
message="北京今天的天气怎么样"
enableWebSearch=true

# 查询最新新闻
message="今天的科技新闻有哪些"
enableWebSearch=true
```

### 测试场景 2: 深度思考

```bash
# 复杂问题分析
message="如何平衡工作与生活"
enableDeepThinking=true

# 战略规划
message="如何制定个人职业发展规划"
enableDeepThinking=true
```

### 测试场景 3: 组合使用

```bash
# 联网搜索 + 深度分析
message="分析2024年AI行业的发展趋势"
enableWebSearch=true
enableDeepThinking=true
```

---

## 注意事项

1. **API 调用限制**: 联网搜索会消耗 SearchAPI 配额，请合理使用
2. **响应时间**:
    - 普通对话: 2-5秒
    - 启用联网搜索: 5-10秒
    - 启用深度思考: 5-15秒
    - 两者同时启用: 10-20秒
3. **会话管理**: `chatId` 用于维护对话上下文，相同 `chatId` 的请求会共享历史记录
4. **超时设置**: 流式接口默认 3分钟超时，可根据需要调整

---

## 后续优化建议

1. **深度思考模式增强**:
    - 可以接入通义千问的 `qwen-max` 或 `qwen-long` 模型
    - 调整 `temperature` 参数以控制创造性

2. **联网搜索优化**:
    - 添加搜索结果缓存
    - 支持指定搜索引擎
    - 支持搜索结果过滤

3. **组合策略**:
    - 自动判断何时需要联网搜索
    - 根据问题复杂度自动启用深度思考

4. **监控与日志**:
    - 记录每次调用的参数和响应时间
    - 统计各开关的使用频率
