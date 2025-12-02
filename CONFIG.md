# Smart Campus 配置文件说明

## 📋 配置文件结构

```
src/main/resources/
└── application.yaml           # 唯一配置文件（所有配置统一管理）

项目根目录/
├── .env                       # 环境变量文件（本地开发使用，不提交到Git）
└── .env.example              # 环境变量模板（提交到Git）
```

**简化说明：**

- ✅ 只有一个 `application.yaml` 配置文件
- ✅ 所有配置通过环境变量灵活控制
- ✅ 不再需要多个环境配置文件（dev/prod）

## 🚀 快速开始

### 1. 配置环境变量

**开发环境：**

```bash
# 复制模板文件
cp .env.example .env

# 编辑 .env 文件，填写实际的配置值
# 注意：.env 文件已被 .gitignore 忽略，不会提交到版本控制
```

**生产环境：**

- 使用系统环境变量或配置中心（如 Nacos、Apollo）
- 不要在配置文件中硬编码敏感信息

### 2. 启动应用

```bash
# 开发环境
mvn spring-boot:run

# 生产环境
java -jar SmartSchool.jar
```

## 📝 配置文件详解

### application.yaml

唯一的配置文件，包含所有配置项：

**服务器配置**

- 端口配置（默认 8718）

**Spring 配置**

- MVC 配置
- Thymeleaf 模板引擎
- 数据源配置（Druid 连接池）
- Redis 配置
- AI 服务配置（OpenAI / 阿里云通义千问）

**框架配置**

- MyBatis Plus 配置
- Knife4j API 文档配置
- Sa-Token 权限配置
- 书杰支付配置

**日志配置**

- 可通过环境变量控制日志级别

**特点：**

- ✅ 所有配置项都支持环境变量覆盖
- ✅ 提供合理的默认值，开箱即用
- ✅ 敏感信息通过环境变量配置
- ✅ 开发和生产环境使用同一配置文件

## 🔐 环境变量说明

### 必需的环境变量

#### 数据库配置

```bash
DB_HOST=localhost              # 数据库主机
DB_PORT=3306                   # 数据库端口
DB_NAME=smart_campus           # 数据库名称
DB_USERNAME=root               # 数据库用户名
DB_PASSWORD=your_password      # 数据库密码
```

#### Redis 配置

```bash
REDIS_HOST=127.0.0.1          # Redis 主机
REDIS_PORT=6379               # Redis 端口
REDIS_PASSWORD=               # Redis 密码（可选）
```

#### AI 服务配置

```bash
# OpenAI（如果使用）
OPENAI_API_KEY=sk-xxx         # OpenAI API Key

# 阿里云通义千问（如果使用）
DASHSCOPE_API_KEY=sk-xxx      # DashScope API Key
```

### 可选的环境变量

#### 应用配置

```bash
SERVER_PORT=8718              # 应用端口（可选，默认8718）
LOG_LEVEL=DEBUG               # 日志级别（可选，默认DEBUG）
DRUID_USERNAME=admin          # Druid监控用户名（可选，默认admin）
DRUID_PASSWORD=admin          # Druid监控密码（可选，默认admin）
```

#### 支付配置

```bash
# 支付宝
ALIPAY_APP_ID=xxx
ALIPAY_MERCHANT_PRIVATE_KEY=xxx
ALIPAY_PUBLIC_KEY=xxx

# 书杰支付
SHUJIEPAY_PID=xxx
SHUJIEPAY_PLATFORM_PUBLIC_KEY=xxx
SHUJIEPAY_MERCHANT_PRIVATE_KEY=xxx
SHUJIEPAY_NOTIFY_URL=xxx
SHUJIEPAY_RETURN_URL=xxx
```

## 🛠️ 开发环境配置示例

### 本地开发（使用 .env 文件）

1. 复制 `.env.example` 为 `.env`
2. 修改 `.env` 中的配置：

```bash
# 数据库配置
DB_HOST=localhost
DB_PORT=3306
DB_NAME=smart_campus
DB_USERNAME=root
DB_PASSWORD=123456

# Redis 配置
REDIS_HOST=127.0.0.1
REDIS_PORT=6379
REDIS_PASSWORD=

# AI 配置（根据实际使用选择）
OPENAI_API_KEY=sk-your-openai-key
DASHSCOPE_API_KEY=sk-your-dashscope-key

# 应用配置
SERVER_PORT=8718
LOG_LEVEL=DEBUG
```

3. 启动应用：

```bash
mvn spring-boot:run
```

### 访问开发工具

- **应用首页**：http://localhost:8718
- **API 文档（Knife4j）**：http://localhost:8718/doc.html
- **Swagger UI**：http://localhost:8718/swagger-ui.html
- **Druid 监控**：http://localhost:8718/druid（用户名/密码：admin/admin）

## 🚢 生产环境部署

### 方式一：使用环境变量

```bash
# 设置环境变量
export DB_HOST=prod-db-host
export DB_PORT=3306
export DB_NAME=smart_campus
export DB_USERNAME=prod_user
export DB_PASSWORD=prod_password
export REDIS_HOST=prod-redis-host
export REDIS_PORT=6379
export REDIS_PASSWORD=prod_redis_password
export OPENAI_API_KEY=sk-prod-key
export LOG_LEVEL=INFO

# 启动应用
java -jar SmartSchool.jar
```

### 方式二：使用启动脚本

创建 `start-prod.sh`：

```bash
#!/bin/bash

# 加载环境变量
source /etc/smartcampus/.env

# 启动应用
java -jar \
  -Xms512m \
  -Xmx2048m \
  -XX:+UseG1GC \
  SmartSchool.jar
```

### 方式三：使用 Docker

创建 `docker-compose.yml`：

```yaml
version: '3.8'
services:
  smartcampus:
    image: smartcampus:latest
    ports:
      - "8718:8718"
    environment:
      - DB_HOST=mysql
      - DB_PORT=3306
      - DB_NAME=smart_campus
      - DB_USERNAME=root
      - DB_PASSWORD=${DB_PASSWORD}
      - REDIS_HOST=redis
      - REDIS_PORT=6379
      - OPENAI_API_KEY=${OPENAI_API_KEY}
      - LOG_LEVEL=INFO
    depends_on:
      - mysql
      - redis
```

## ⚠️ 安全注意事项

1. **永远不要提交 `.env` 文件到版本控制**
   - `.env` 已在 `.gitignore` 中配置
   - 只提交 `.env.example` 模板文件

2. **生产环境必须使用环境变量**
   - 不要在配置文件中硬编码敏感信息
   - 使用配置中心或密钥管理服务

3. **定期更换密钥**
   - API Key
   - 数据库密码
   - Redis 密码
   - 支付密钥

4. **生产环境关闭调试功能**
   - 设置 `LOG_LEVEL=INFO` 或 `WARN`
   - 如需关闭 Druid 监控，设置环境变量禁用

## 🔧 常见问题

### Q1: 环境变量不生效？

**A:** 检查以下几点：

- 确认 `.env` 文件存在且格式正确
- 重启应用
- 检查环境变量名称是否正确
- 确认配置文件中使用了 `${VAR_NAME}` 语法

### Q2: 如何修改日志级别？

**A:** 设置环境变量 `LOG_LEVEL`：

```bash
# 开发环境
export LOG_LEVEL=DEBUG

# 生产环境
export LOG_LEVEL=INFO
```

### Q3: 如何配置多个实例？

**A:** 使用不同的端口启动多个实例：

```bash
SERVER_PORT=8718 java -jar SmartSchool.jar &
SERVER_PORT=8719 java -jar SmartSchool.jar &
```

### Q4: 如何在 IDE 中配置环境变量？

**A:**

- **IDEA**：Run → Edit Configurations → Environment variables
- **Eclipse**：Run → Run Configurations → Environment

### Q5: 如何访问 Druid 监控页面？

**A:** 启动应用后访问 http://localhost:8718/druid，使用配置的用户名密码登录（默认 admin/admin）

## 📚 相关文档

- [Spring Boot 配置文档](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
- [Spring Profiles 文档](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.profiles)
- [Druid 配置文档](https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE)
- [Sa-Token 配置文档](https://sa-token.cc/doc.html#/use/config)

## 📞 技术支持

如有问题，请联系开发团队或提交 Issue。
