# SmartSchool 部署指南

## 📋 部署前准备

### 1. 环境要求

- **JDK**: 17+
- **Maven**: 3.6+
- **MySQL**: 8.0+
- **Redis**: 5.0+

### 2. 数据库准备

```sql
-- 创建数据库
CREATE
DATABASE smart_campus CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 导入数据库脚本
-- 请执行项目中的 SQL 脚本文件
```

### 3. 配置环境变量（推荐）

在服务器上设置以下环境变量：

```bash
# 数据库配置
export DB_HOST=your_mysql_host
export DB_PORT=3306
export DB_NAME=smart_campus
export DB_USERNAME=your_db_username
export DB_PASSWORD=your_db_password

# Redis 配置
export REDIS_HOST=your_redis_host
export REDIS_PORT=6379
export REDIS_PASSWORD=your_redis_password

# OpenAI API Key (如果使用 AI 功能)
export OPENAI_API_KEY=your_openai_api_key
```

## 🚀 打包部署步骤

### 方式一：使用环境变量（推荐）

1. **修改配置文件**

```properties
# 编辑 src/main/resources/application.properties
# 将环境改为生产环境
spring.profiles.active=prod
```

2. **打包项目**

```bash
mvn clean package -DskipTests
```

3. **运行应用**

```bash
# 使用环境变量运行
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar
```

### 方式二：直接修改配置文件

1. **修改生产环境配置**

```yaml
# 编辑 src/main/resources/application-prod.yml
# 将占位符替换为实际值
spring:
  datasource:
    url: jdbc:mysql://实际数据库地址:3306/smart_campus?...
    username: 实际用户名
    password: 实际密码
  redis:
    host: 实际Redis地址
    password: 实际Redis密码
  ai:
    openai:
      api-key: 实际OpenAI_API_Key
```

2. **修改主配置**

```properties
# 编辑 src/main/resources/application.properties
spring.profiles.active=prod
```

3. **打包运行**

```bash
mvn clean package -DskipTests
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar
```

## 🐳 Docker 部署（可选）

创建 `Dockerfile`:

```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/SmartSchool-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

构建并运行：

```bash
docker build -t smartschool:latest .
docker run -d -p 8080:8080 \
  -e DB_HOST=your_db_host \
  -e DB_USERNAME=your_username \
  -e DB_PASSWORD=your_password \
  -e REDIS_HOST=your_redis_host \
  --name smartschool \
  smartschool:latest
```

## 📝 生产环境配置说明

### application-prod.yml 配置项

| 配置项 | 说明 | 默认值 | 是否必须 |
|--------|------|--------|----------|
| DB_HOST | 数据库地址 | localhost | ✅ 是 |
| DB_PORT | 数据库端口 | 3306 | ❌ 否 |
| DB_NAME | 数据库名称 | smart_campus | ✅ 是 |
| DB_USERNAME | 数据库用户名 | root | ✅ 是 |
| DB_PASSWORD | 数据库密码 | - | ✅ 是 |
| REDIS_HOST | Redis地址 | localhost | ✅ 是 |
| REDIS_PORT | Redis端口 | 6379 | ❌ 否 |
| REDIS_PASSWORD | Redis密码 | 空 | ❌ 否 |
| OPENAI_API_KEY | OpenAI API密钥 | - | ⚠️ AI功能需要 |

## ⚠️ 安全建议

1. **不要将敏感信息提交到 Git**
   - API Key
   - 数据库密码
   - Redis 密码

2. **生产环境建议**
   - 使用强密码
   - 启用 SSL/TLS
   - 配置防火墙
   - 定期备份数据库
   - 关闭 Swagger 文档（已在配置中关闭）

3. **日志管理**
   - 日志文件位置: `/var/log/smartschool/`
   - 日志保留天数: 30天
   - 单个日志文件最大: 10MB

## 🔍 健康检查

应用启动后，可以通过以下方式检查：

```bash
# 检查应用是否启动
curl http://localhost:8080/actuator/health

# 查看日志
tail -f /var/log/smartschool/application.log
```

## 🛠️ 常见问题

### 1. 数据库连接失败

- 检查数据库地址、端口是否正确
- 检查数据库用户名密码是否正确
- 检查防火墙是否开放 3306 端口

### 2. Redis 连接失败

- 检查 Redis 服务是否启动
- 检查 Redis 地址、端口是否正确
- 检查 Redis 密码是否正确

### 3. AI 功能不可用

- 检查 OPENAI_API_KEY 是否配置
- 检查 API Key 是否有效
- 检查网络是否能访问 OpenAI 服务

## 📞 技术支持

如有问题，请联系开发团队。
