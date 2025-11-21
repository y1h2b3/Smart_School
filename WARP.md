# WARP.md

这个文件为 WARP (warp.dev) 提供在本仓库中工作的指导。

## 项目概述

SmartSchool 是一个智慧校园管理系统的 Spring Boot 后端应用,提供学生、教师、家长管理,健康监测,药品订购,支付集成和 AI 健康建议等功能。

**技术栈:**

- Spring Boot 3.2.4
- Java 17
- MyBatis-Plus 3.5.5 (ORM)
- MySQL 8.0.28
- Redis (缓存和会话)
- Sa-Token 1.37.0 (认证授权)
- Spring AI 0.8.1 (OpenAI 集成)
- Alipay SDK 4.22.110 (支付宝支付)
- Swagger/SpringDoc 2.0.2 (API 文档)

## 常用命令

### 构建和运行

```powershell
# 编译项目
mvn clean compile

# 打包 (跳过测试)
mvn clean package -DskipTests

# 运行应用
mvn spring-boot:run

# 或直接运行打包的 JAR
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar
```

### 测试

```powershell
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=UserTest

# 运行特定测试方法
mvn test -Dtest=UserTest#test01
```

### 数据库

- 数据库初始化脚本: `smart_campus.sql`
- 默认连接: `localhost:3306/smart_campus`
- 默认凭证: `root/123456` (在 `application.yaml` 中配置)

### API 文档

应用运行后访问:

- Swagger UI: `http://localhost:8081/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8081/v3/api-docs`

## 代码架构

### 包结构 (`com.smart.www`)

```
├── config/          # Spring 配置类
│   ├── CorsConfig          # 跨域配置
│   ├── MybatisPlusConfig   # MyBatis-Plus 分页配置,Mapper 扫描
│   ├── RedisConfig         # Redis 序列化配置
│   ├── SwaggerConfig       # API 文档配置
│   └── WebMvcConfiguration # Web MVC 配置,拦截器 (Sa-Token 拦截器已注释)
│
├── controller/      # REST API 端点
├── service/         # 业务逻辑层
│   └── impl/        # Service 实现
├── mapper/          # MyBatis-Plus Mapper 接口
├── pojo/            # 实体类和 DTO
│   ├── dto/         # 数据传输对象 (如 PageDTO)
│   ├── query/       # 查询对象 (如 PageQuery)
│   └── Vo/          # 视图对象 (用于 API 响应)
├── util/            # 工具类
│   ├── Result             # 统一 API 响应包装器
│   ├── ResultCodeEnum     # 响应状态码枚举
│   ├── JwtHelper/JwtUtil  # JWT 令牌工具
│   ├── SaltMD5Util        # 密码加盐和哈希
│   ├── RedisCache         # Redis 操作封装
│   └── StpUserUtil        # Sa-Token 用户工具
├── interceptor/     # 请求拦截器
└── exception/       # 自定义异常处理
```

### 核心架构模式

**三层架构:**

1. **Controller 层**: 处理 HTTP 请求/响应,参数验证
2. **Service 层**: 业务逻辑,事务管理
3. **Mapper 层**: 数据库访问 (MyBatis-Plus)

**关键设计点:**

- **统一响应格式**: 所有 API 返回 `Result<T>` 对象,包含 `code`, `message`, `data`
- **分页**: 使用 `PageQuery` (输入) 和 `PageDTO<T>` (输出) 进行一致的分页处理
- **认证**: Sa-Token 用于基于会话的认证 (当前在 `WebMvcConfiguration` 中已禁用拦截器)
- **日志记录**: `LogsDataService` 记录管理操作 (添加/更新/删除) 的审计日志

### 数据流示例

添加学生的典型流程:

1. `StudentController.addStudent()` 接收 `@RequestBody Student`
2. 设置元数据 (type="学生", status=1, timestamps)
3. 调用 `studentService.save(student)` - MyBatis-Plus 方法
4. 通过 `logsDataService.addLogsData()` 记录操作
5. 返回 `Result.ok()` 或 `Result.build(null, ResultCodeEnum.ERROR)`

## 重要业务逻辑

### 主要功能模块

1. **用户管理**: `Student`, `Teacher`, `Parent`, `Staff` - 独立实体,具有不同的属性和控制器
2. **健康监测**: `UserHealth`, `UserHealthDaily`, `HealthWarningNotifications` - 每日健康数据和警报系统
3. **医疗服务**: `Drugs`, `Hospitals`, `DrugsHospitalsRelation`, `Reservation` - 药品库存和预约
4. **订单系统**: `Orders`, `StaffOrders` - 用户和员工订单处理
5. **物流**: `Logistics` - 货物追踪
6. **通知**: `Notifications` - 系统通知
7. **AI 集成**: `ChatController` - 使用 OpenAI (通过 Spring AI) 提供健康建议

### 第三方集成

- **支付宝支付**: `PayController` 处理沙箱支付流程
    - 配置: APP_ID, APP_PRIVATE_KEY, ALIPAY_PUBLIC_KEY
    - 流程: 创建订单 → 重定向到支付宝 → 回调到 `/nofity` → 保存订单

- **AI 健康建议**: `ChatController.getHealth()`
    - 从 `UserHealth` 获取数据
    - 生成健康建议提示词
    - 调用 `OpenAiChatClient.call(message)`

## 配置注意事项

### application.yaml

- **环境配置**: 使用 `spring.profiles.active: dev`
- **端口**: 默认 `8081`
- **数据库**: 配置在主 yaml 中
- **Redis**: 主机配置已脱敏 (标记为 `*********`)
- **Sa-Token**: 30 天令牌有效期,允许并发登录
- **MyBatis-Plus**:
    - 实体包: `com.smart.www.pojo`
    - Mapper XML: `classpath:com/smark/www/mapper/*.xml` (注意路径拼写)
    - ID 策略: 雪花算法 (`assign_id`)

### 敏感数据

以下配置包含占位符/测试凭证,部署前需要更新:

- Redis 主机 (`application.yaml`)
- 数据库密码
- 支付宝 API 密钥 (`PayController`)
- OpenAI API 密钥 (未在代码中显示,可能在环境变量中)
- 阿里云短信凭证 (`UserTest.tes07()` - 测试代码)

## 开发指南

### 添加新实体

1. 在 `pojo/` 中创建实体类 (使用 Lombok `@Data`)
2. 在 `mapper/` 中创建扩展 `BaseMapper<T>` 的 Mapper 接口
3. 在 `service/` 中创建扩展 `IService<T>` 的 Service 接口
4. 在 `service/impl/` 中实现 Service,扩展 `ServiceImpl<Mapper, Entity>`
5. 在 `controller/` 中创建 REST 控制器,注入 Service
6. 如果需要,在 `pojo/Vo/` 中添加视图对象用于 API 响应

### 运行单个测试

测试位于 `src/test/java/com/smart/www/test/`:

- `UserTest.java`: 主要测试套件 (包括 Sa-Token, 分页, 加密, SMS)
- `LockTest.java`: 并发测试

使用 `@SpringBootTest` 进行完整应用程序上下文测试。

### 常见问题

- **拦截器**: Sa-Token 拦截器在 `WebMvcConfiguration` 中已注释。要启用认证,取消注释 `addInterceptors` 方法。
- **MyBatis XML 路径**: 配置路径为 `classpath:com/smark/www/mapper/*.xml` (注意 "smark" 拼写,应为 "smart")。
- **跨域**: 由 `CorsConfig` 处理。
- **事务**: 在 Service 层方法上使用 `@Transactional`。

## 代码风格

- 控制器方法返回 `Result<T>`
- Service 方法抛出业务异常或返回布尔值/实体
- 所有实体使用 Lombok 注解 (`@Data`, `@AllArgsConstructor`)
- API 端点使用 Swagger 注解记录 (`@Tag`, `@Operation`)
- 使用 `PageQuery` 和 `PageDTO<T>` 实现分页的一致性
