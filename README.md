# SmartCampus - 智慧校园管理系统

## 📖 项目概述

**SmartCampus** 是一个基于 Spring Boot 的智慧校园一体化管理平台后端服务。它旨在为学生、教师和家长提供便捷的校园服务，核心功能包括健康监测、在线药品订购、支付宝支付集成以及基于 AI 的健康建议。

---

## 🚀 技术栈

| 技术             | 描述                               | 版本/组件                                |
| ---------------- | ---------------------------------- | ---------------------------------------- |
| **后端框架**     | Spring Boot                        | `3.2.4`                                  |
| **编程语言**     | Java                               | `17`                                     |
| **数据库**       | MySQL                              | `8.0+`                                   |
| **ORM框架**      | MyBatis-Plus                       | `3.5.5`                                  |
| **认证授权**     | Sa-Token                           | `1.37.0`                                 |
| **缓存中间件**   | Redis                              | -                                        |
| **支付集成**     | 支付宝 SDK (Alipay SDK)            | `4.22.110.ALL`                           |
| **AI集成**       | Spring AI (通义千问)               | `0.8.1`                                  |
| **API文档**      | Knife4j / SpringDoc (OpenAPI 3)    | `4.3.0` / `2.0.2`                        |
| **JSON处理**     | Fastjson                           | `1.2.76`                                 |
| **构建工具**     | Maven                              | -                                        |

---

## 🏛️ 项目架构

项目采用经典的三层架构模式，确保代码结构清晰、职责分明、易于维护。

- **Controller 层**: 负责处理 HTTP 请求，验证参数，并调用 Service 层。
- **Service 层**: 实现核心业务逻辑，处理数据和执行业务规则，管理数据库事务。
- **Mapper 层**: 数据访问层，通过 MyBatis-Plus 与数据库进行交互。

### 包结构 (`com.smart.www`)
SmartCampus_SpringBoot/
├── controller/          # 控制器层，REST API端点
│   ├── DrugsController.java          # 药品管理
│   ├── OrdersController.java         # 订单管理
│   ├── PayController.java            # 支付控制器
│   └── ShujiepayController.java      # 书杰支付控制器
├── service/            # 业务逻辑层
│   ├── DrugsService.java
│   ├── OrdersService.java
│   └── impl/
├── mapper/             # 数据访问层
│   ├── DrugsMapper.java
│   ├── OrdersMapper.java
│   └── xml/
├── pojo/               # 实体类
│   ├── Drugs.java
│   ├── Orders.java
│   ├── StaffOrders.java
│   └── Vo/             # 视图对象
│   └── dto/            # 数据传输对象
│   └── query/          # 查询对象
├── util/               # 工具类
│   ├── Result.java
│   ├── SaltMD5Util.java
│   ├── ShujiepayCore.java
│   └── RedisCache.java
├── interceptor/        # 请求拦截器
├── exception/          # 自定义异常处理
├── docs/               # 详细业务与接口文档
├── sql/                # 数据库脚本
├── src/main/resources/ # 配置文件、静态资源
│   ├── application.yaml
│   └── img/            # 药品图片存储
├── test/               # 单元测试
│   └── UserTest.java
└── WARP.md             # 业务逻辑与架构说明



---

## 🧩 主要功能模块

1. **用户管理**：学生、教师、家长、员工多角色管理，支持注册、登录、信息维护。
2. **健康监测**：每日健康数据采集、健康预警推送、健康日志。
3. **药品管理**：药品库存、药品图片上传、药品类型与医院关联。
4. **订单系统**：药品订单、员工订单，订单状态自动流转。
5. **支付系统**：集成支付宝沙箱、书杰支付，支持扫码支付、异步回调。
6. **物流追踪**：药品物流信息管理。
7. **通知系统**：系统消息推送、健康预警通知。
8. **AI健康建议**：集成 OpenAI，自动生成健康建议。
9. **权限与安全**：基于 Sa-Token 的认证与权限控制。
10. **缓存优化**：Redis 热门药品缓存、会话管理。

---

## 🗄️ 数据库表设计（部分）

- `drugs`：药品信息表，包含药品ID、类型、名称、价格、数量、图片、生产厂家、有效期等字段。
- `orders`：订单信息表，包含订单号、用户ID、药品ID、数量、金额、订单状态等。
- `health_warning_notifications`：健康预警通知表，记录预警类型、等级、时间、建议措施等。
- `logistics`：物流信息表，追踪药品流通。
- `notifications`：系统通知表。
- `parent`、`staff`、`student`、`teacher`：各类用户信息表。
- 详细建表SQL见 `smart_campus.sql` 和 `sql/rebuild_from_mapper.sql`。

---

## 🔗 典型业务流程

### 1. 药品管理

- 支持药品的增删改查（CRUD）、分页查询、模糊搜索、图片上传。
- 药品图片上传接口：
  - `POST /drugs/image`，参数为图片文件，返回图片UUID，图片存储于 `src/main/resources/img/{uuid}.jpg`。

### 2. 支付系统

- 支持支付宝沙箱支付与书杰支付，支付流程包括订单创建、支付链接生成、异步回调、订单状态更新。
- 书杰支付核心接口见 `ShujiepayCore.java`，控制器见 `ShujiepayController.java`。

### 3. 订单管理

- 订单自动创建，状态流转（待支付、已支付、已完成、已取消）。
- 订单状态更新接口：
  - `PUT /orders`，请求体包含 `orderId` 和 `orderStatus`，SQL见 `updateOrders`。

### 4. 健康监测与预警

- 每日健康数据采集，自动生成健康预警，推送通知至相关用户。
- 健康预警通知表结构详见数据库脚本。

---

## 🛠️ 主要接口示例

### 药品图片上传

```http
POST /drugs/image
Content-Type: multipart/form-data
参数: file=图片文件
返回: { "code": 200, "data": "uuid字符串" }


## 📌 总结与技术亮点
- MyBatis Plus 动态 SQL
- 支付宝电脑网站支付与书杰支付集成
- Session 管理订单状态
- 日志记录系统操作
- 统一结果封装
- Redis 热门药品缓存
- AI 健康建议自动生成
