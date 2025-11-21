# SmartCampus - 智慧校园管理系统

## 项目概述

SmartCampus 是一个基于 Spring Boot 的智慧校园一体化后端服务，面向学生、教师、家长与后勤人员，提供健康监测、药品与医疗服务、订单与支付、通知公告、AI 健康建议等模块化能力。

应用入口：`src/main/java/com/smart/www/SpringbootApplication.java`

运行端口：`8081`（`src/main/resources/application.yaml` 配置）

---

## 技术栈

- Spring Boot `3.2.4`
- Java `17`
- MySQL `8.0+`，Redis
- MyBatis-Plus `3.5.5`
- Sa-Token `1.37.0`
- Knife4j / SpringDoc (OpenAPI 3)
- Alipay SDK，书杰支付
- Spring AI（含 Alibaba DashScope 集成）

---

## 目录结构

```
src/
└── main/
    ├── java/com/smart/www/
    │   ├── config/        # Spring & API 文档配置
    │   ├── controller/    # REST 控制器（药品、订单、通知、健康、支付等）
    │   ├── service/       # 业务服务（含 impl 实现）
    │   ├── mapper/        # MyBatis-Plus Mapper 接口
    │   ├── pojo/          # 实体、DTO、VO
    │   ├── util/          # 统一响应、缓存、加密等工具
    │   └── exception/     # 全局异常处理
    └── resources/
        ├── application.yaml    # 主配置（端口、DB、Redis、文档等）
        └── com/smart/www/mapper/*.xml  # MyBatis XML 映射
```

---

## 快速开始

### 环境要求

- JDK 17
- Maven 3.8+
- MySQL 8.0+，Redis 6+

### 数据库与缓存

- 默认数据库：`smart_campus`
- 连接配置：在 `application.yaml` 中修改 `spring.datasource.url/username/password`
- Redis：在 `application.yaml` 中配置 `spring.data.redis.host/port`

### 敏感配置

- 请为以下密钥与凭证使用环境变量或私密配置文件，不要在仓库中提交真实值：
  - OpenAI / DashScope API Key（`spring.ai.*`）
  - 支付宝应用私钥、公钥、网关与回调地址（`PayController` / `application.yaml`）
  - 书杰支付商户私钥与公钥（`shujiepay.*`）
  - 短信服务凭证

### 构建与运行

```
mvn clean package -DskipTests
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar
```

或开发模式：

```
mvn spring-boot:run
```

### API 文档

- Swagger UI：`http://localhost:8081/swagger-ui.html`
- Knife4j 文档：`http://localhost:8081/doc.html`

---

## 核心模块

- 用户与认证：基于 Sa-Token 的登录、注销与会话查询
  - 示例：`GET /Login/Admin?name=admin&pwd=123`，`GET /Logout`
- 健康监测：`UserHealthDaily`、`HealthWarningNotifications` 每日数据与预警
- 药品与医疗：药品、医院、药品-医院关联、预约等模块
- 订单与支付：订单创建查询，支付宝与书杰支付集成
- 通知公告：系统通知的发布与管理

---

## 示例接口

- 药品查询（分页）：`GET /drugs`（支持 `PageQuery` 参数）
- 订单列表：`GET /orders`（分页与条件查询）
- 支付发起（支付宝沙箱）：
  - `GET /pay/alipay?dona_drugId=D001&dona_money=15.50&dona_sum=2&dona_userId=U001`
  - 同步回调：`/pay/return`
  - 异步回调：`/pay/notify`

以上完整入参与返回示例可在 API 文档与 `docs/` 中查看。

---

## 开发约定

- 统一返回结构：`Result<T>`（`code/message/data`）
- 分页约定：入参 `PageQuery`，出参 `PageDTO<T>`
- 控制器使用 `@Tag` / `@Operation` 注解维护文档
- Service 层封装业务与事务，Mapper 层专注数据访问

---

## 常见问题

- 端口配置：默认 `8081`，可在 `application.yaml` 中修改
- MyBatis XML 路径：`classpath:com/smart/www/mapper/*.xml`（如路径有误请按实际修正）
- Sa-Token 拦截器：如需启用鉴权，请在 Web 配置中开启相关拦截器

---

## 许可与联系

- 许可：Apache-2.0（如未声明，按仓库 License 为准）
- 联系方式：在 API 文档或配置中可见（Knife4j 配置中包含作者信息）

---

## 参考入口文件

- 应用启动类：`src/main/java/com/smart/www/SpringbootApplication.java`
- 全局异常：`src/main/java/com/smart/www/exception/GloBalHandlerException.java`
- 文档配置：`src/main/java/com/smart/www/config/Knife4jConfig.java`