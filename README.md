# SmartCampus - 智慧校园管理系统

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![MyBatis-Plus](https://img.shields.io/badge/MyBatis--Plus-3.5.5-blue.svg)
![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)

一个功能完善的智慧校园综合管理平台后端系统

</div>

---

## 📋 目录

- [项目简介](#项目简介)
- [核心功能](#核心功能)
- [技术架构](#技术架构)
- [项目结构](#项目结构)
- [快速开始](#快速开始)
- [核心模块详解](#核心模块详解)
- [API 文档](#api-文档)
- [数据库设计](#数据库设计)
- [配置说明](#配置说明)
- [开发指南](#开发指南)
- [常见问题](#常见问题)
- [许可证](#许可证)

---

## 📖 项目简介

**SmartCampus** 是一个基于 Spring Boot 3.x 的现代化智慧校园一体化后端服务系统，面向学生、教师、家长、后勤人员及校医等多角色用户，提供全方位的校园管理解决方案。

### 🎯 核心特性

- **🏥 健康监测系统**：实时监测学生健康数据，支持每日健康报告、健康预警通知
- **💊 医疗服务管理**：药品库存管理、医院信息维护、在线预约挂号
- **💰 支付集成**：支持支付宝沙箱支付、书杰支付等多种支付方式
- **🤖 AI 健康顾问**：集成阿里云通义千问、OpenAI，提供智能健康建议
- **👥 多角色管理**：学生、教师、家长、后勤、校医等多角色权限管理
- **📢 通知公告**：系统通知发布与管理
- **📊 数据统计**：健康数据可视化、操作日志审计

### 🌟 应用场景

- 中小学智慧校园健康管理
- 大学校园医疗服务平台
- 教育机构健康监测系统
- 校园后勤服务管理

### 📍 项目信息

- **应用入口**：`src/main/java/com/smart/www/SpringbootApplication.java`
- **运行端口**：`8081`（可在 `application.yaml` 中配置）
- **数据库**：`smart_campus`（MySQL 8.0+）
- **缓存**：Redis 6.0+

---

## 🚀 核心功能

### 1️⃣ 用户管理模块

| 角色类型 | 功能描述 |
|---------|---------|
| **学生** | 个人信息管理、健康数据查看、药品购买、预约挂号 |
| **教师** | 班级管理、学生健康监控、通知发布 |
| **家长** | 关联学生信息、健康数据查看、接收预警通知 |
| **后勤人员** | 设备管理、物流跟踪 |
| **校医** | 预约管理、健康数据分析、药品管理 |
| **系统管理员** | 系统配置、用户管理、权限分配 |

### 2️⃣ 健康监测模块

**实时健康数据采集**
- 身高、体重、BMI、体脂率
- 心率（平均静息心率、最高/最低心率、24小时心率监测）
- 血氧饱和度（SpO2）、体温
- 睡眠监测（总睡眠时长、深睡/浅睡时长、入睡/起床时间）
- 运动数据（步数、运动距离、运动时长、卡路里消耗）

**健康预警系统**
- 自动检测异常健康指标
- 多级预警机制（轻度、中度、重度）
- 实时推送预警通知
- 提供针对性健康建议

**每日健康报告**
- 自动生成每日健康摘要
- 历史数据对比分析
- 健康趋势可视化

### 3️⃣ 医疗服务模块

**药品管理**
- 药品信息维护（名称、规格、价格、库存）
- 药品分类管理
- 库存预警
- 药品图片上传

**医院管理**
- 医院信息维护
- 药品-医院关联关系
- 医院科室管理

**预约系统**
- 在线预约挂号
- 预约状态管理
- 预约记录查询

### 4️⃣ 订单与支付模块

**订单管理**
- 药品订单创建
- 订单状态跟踪
- 订单历史查询
- 订单统计分析

**支付集成**
- 支付宝沙箱支付（PC网站支付）
- 书杰支付集成
- 支付回调处理（同步/异步）
- 支付状态同步

### 5️⃣ AI 智能服务

**健康建议生成**
- 基于用户健康数据的个性化建议
- 支持 OpenAI GPT 模型
- 支持阿里云通义千问模型
- 自然语言交互

**智能对话**
- AI 聊天机器人
- 健康咨询问答

### 6️⃣ 系统管理模块

**权限认证**
- 基于 Sa-Token 的会话管理
- 多端登录支持
- Token 自动续期
- 登录日志记录

**操作日志**
- 完整的操作审计
- 日志分类管理
- IP 地址记录
- 操作结果追踪

**通知管理**
- 系统通知发布
- 分组通知（按角色/班级）
- 通知历史查询

---

## 🛠 技术架构

### 后端技术栈

| 技术 | 版本 | 说明 |
|-----|------|------|
| **Spring Boot** | 3.2.4 | 核心框架 |
| **Java** | 17 | 开发语言 |
| **MyBatis-Plus** | 3.5.5 | ORM 框架，简化数据库操作 |
| **MySQL** | 8.0.28 | 关系型数据库 |
| **Redis** | 6.0+ | 缓存、会话存储 |
| **Sa-Token** | 1.37.0 | 权限认证框架 |
| **Druid** | 1.2.18 | 数据库连接池 |
| **Knife4j** | 4.3.0 | API 文档增强工具 |
| **SpringDoc** | 2.0.2 | OpenAPI 3.0 规范 |
| **Alipay SDK** | 4.22.110 | 支付宝支付集成 |
| **Spring AI** | 0.8.1 | AI 模型集成 |
| **Alibaba DashScope** | 2.22.0 | 阿里云通义千问 |
| **Spring AI Alibaba** | 1.0.0-M6.1 | 阿里云 AI 集成 |
| **Fastjson** | 1.2.76 | JSON 处理 |
| **Lombok** | - | 简化 Java 代码 |
| **Commons Codec** | - | MD5 加密 |
| **Thymeleaf** | - | 模板引擎 |

### 架构设计

```
┌─────────────────────────────────────────────────────────┐
│                      前端应用层                          │
│         (Web/Mobile/小程序 - 不包含在本项目)             │
└─────────────────────────────────────────────────────────┘
                            ↓ HTTP/HTTPS
┌─────────────────────────────────────────────────────────┐
│                    Controller 层                         │
│  (请求处理、参数验证、权限校验、统一响应封装)              │
└─────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────┐
│                     Service 层                           │
│     (业务逻辑、事务管理、数据组装、缓存处理)               │
└─────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────┐
│                     Mapper 层                            │
│          (数据访问、SQL 映射、MyBatis-Plus)               │
└─────────────────────────────────────────────────────────┘
                            ↓
┌──────────────┬──────────────┬──────────────┬────────────┐
│    MySQL     │    Redis     │  支付宝 API   │  AI API    │
│   (持久化)    │   (缓存)     │   (支付)     │  (智能)     │
└──────────────┴──────────────┴──────────────┴────────────┘
```

### 设计模式

- **三层架构**：Controller → Service → Mapper
- **统一响应**：`Result<T>` 封装所有 API 响应
- **统一异常处理**：全局异常拦截器
- **分页封装**：`PageQuery` 输入 + `PageDTO<T>` 输出
- **日志审计**：AOP 切面记录关键操作

---

## 📁 项目结构

```
SmartCampus_SpringBoot/
│
├── src/main/
│   ├── java/com/smart/www/
│   │   ├── SpringbootApplication.java      # 应用启动类
│   │   │
│   │   ├── config/                         # 配置类
│   │   │   ├── CorsConfig.java             # 跨域配置
│   │   │   ├── Knife4jConfig.java          # API 文档配置
│   │   │   ├── MybatisPlusConfig.java      # MyBatis-Plus 配置
│   │   │   ├── RedisConfig.java            # Redis 配置
│   │   │   └── WebMvcConfiguration.java    # Web MVC 配置
│   │   │
│   │   ├── controller/                     # 控制器层（22个）
│   │   │   ├── LoginController.java        # 登录认证
│   │   │   ├── StudentController.java      # 学生管理
│   │   │   ├── TeacherController.java      # 教师管理
│   │   │   ├── ParentController.java       # 家长管理
│   │   │   ├── StaffController.java        # 校医管理
│   │   │   ├── LogisticsController.java    # 后勤管理
│   │   │   ├── UserHealthController.java   # 用户健康
│   │   │   ├── UserHealthDailyController.java  # 每日健康
│   │   │   ├── HealthWarningNotificationsController.java  # 健康预警
│   │   │   ├── HealthCheckController.java  # 健康检测分析
│   │   │   ├── DrugsController.java        # 药品管理
│   │   │   ├── HospitalsController.java    # 医院管理
│   │   │   ├── DrugsHospitalsRelationController.java  # 药品医院关系
│   │   │   ├── ReservationController.java  # 预约管理
│   │   │   ├── OrdersController.java       # 订单管理
│   │   │   ├── StaffOrdersController.java  # 校医预约
│   │   │   ├── PayController.java          # 支付宝支付
│   │   │   ├── ShujiepayController.java    # 书杰支付
│   │   │   ├── ChatController.java         # AI 对话
│   │   │   ├── NotificationsController.java # 通知管理
│   │   │   ├── LogsDataController.java     # 日志管理
│   │   │   └── UserAccountController.java  # 账号管理
│   │   │
│   │   ├── service/                        # 服务层接口
│   │   │   └── impl/                       # 服务层实现
│   │   │
│   │   ├── mapper/                         # 数据访问层（18个）
│   │   │   ├── UserMapper.java
│   │   │   ├── StudentMapper.java
│   │   │   ├── TeacherMapper.java
│   │   │   ├── ParentMapper.java
│   │   │   ├── StaffMapper.java
│   │   │   ├── LogisticsMapper.java
│   │   │   ├── UserHealthMapper.java
│   │   │   ├── UserHealthDailyMapper.java
│   │   │   ├── HealthWarningNotificationsMapper.java
│   │   │   ├── DrugsMapper.java
│   │   │   ├── HospitalsMapper.java
│   │   │   ├── DrugsHospitalsRelationMapper.java
│   │   │   ├── ReservationMapper.java
│   │   │   ├── OrdersMapper.java
│   │   │   ├── StaffOrdersMapper.java
│   │   │   ├── NotificationsMapper.java
│   │   │   └── LogsDataMapper.java
│   │   │
│   │   ├── pojo/                           # 实体类
│   │   │   ├── dto/                        # 数据传输对象
│   │   │   │   └── PageDTO.java            # 分页响应封装
│   │   │   ├── query/                      # 查询对象
│   │   │   │   └── PageQuery.java          # 分页查询参数
│   │   │   ├── Vo/                         # 视图对象
│   │   │   └── *.java                      # 实体类（对应数据库表）
│   │   │
│   │   ├── util/                           # 工具类
│   │   │   ├── Result.java                 # 统一响应封装
│   │   │   ├── ResultCodeEnum.java         # 响应状态码枚举
│   │   │   ├── JwtHelper.java              # JWT 工具
│   │   │   ├── JwtUtil.java                # JWT 工具类
│   │   │   ├── SaltMD5Util.java            # MD5 加密工具
│   │   │   ├── RedisCache.java             # Redis 缓存工具
│   │   │   └── StpUserUtil.java            # Sa-Token 用户工具
│   │   │
│   │   ├── interceptor/                    # 拦截器
│   │   │   └── LoginCheckInterceptor.java  # 登录检查拦截器
│   │   │
│   │   ├── exception/                      # 异常处理
│   │   │   └── GloBalHandlerException.java # 全局异常处理器
│   │   │
│   │   └── app/                            # 应用配置
│   │
│   └── resources/
│       ├── application.yaml                # 主配置文件
│       ├── application.properties          # 属性配置
│       ├── application-dev.yml             # 开发环境配置
│       ├── static/                         # 静态资源
│       └── com/smart/www/mapper/*.xml      # MyBatis XML 映射文件
│
├── docs/                                   # 项目文档
│   ├── 支付.md                             # 支付模块文档
│   ├── 支付Bug修复文档.md                   # 支付问题修复记录
│   └── 药品与支付系统文档.md                # 药品支付系统文档
│
├── sql/                                    # SQL 脚本
├── web/                                    # Web 资源
├── smart_campus.sql                        # 数据库初始化脚本
├── pom.xml                                 # Maven 配置
├── README.md                               # 项目说明文档
├── WARP.md                                 # WARP 开发指南
├── alipayPublicKey_RSA2.txt               # 支付宝公钥
└── shujiepay_RSA2.txt                     # 书杰支付密钥
```

---

## 🚀 快速开始

### 环境要求

| 软件 | 版本要求 | 说明 |
|-----|---------|------|
| JDK | 17+ | 必须 |
| Maven | 3.8+ | 必须 |
| MySQL | 8.0+ | 必须 |
| Redis | 6.0+ | 必须 |
| IDE | IntelliJ IDEA / Eclipse | 推荐 IDEA |

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

**数据库包含以下核心表**：
- `user` - 系统管理员
- `student` - 学生信息
- `teacher` - 教师信息
- `parent` - 家长信息
- `staff` - 校医信息
- `logistics` - 后勤人员
- `user_health` - 用户健康数据
- `user_health_daily` - 每日健康数据
- `health_warning_notifications` - 健康预警通知
- `drugs` - 药品信息
- `hospitals` - 医院信息
- `drugs_hospitals_relation` - 药品医院关系
- `reservation` - 预约信息
- `orders` - 订单信息
- `staff_orders` - 校医预约订单
- `notifications` - 系统通知
- `logs_data` - 操作日志

#### 3. 配置文件修改

编辑 `src/main/resources/application.yaml`：

```yaml
# 数据库配置
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/smart_campus?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root
    password: 你的数据库密码

  # Redis 配置
  data:
    redis:
      host: 127.0.0.1
      port: 6379

  # AI 配置（可选）
  ai:
    dashscope:
      api-key: 你的阿里云DashScope API Key
```

⚠️ **安全提示**：
- 不要将真实的 API Key、密码等敏感信息提交到代码仓库
- 生产环境建议使用环境变量或配置中心管理敏感配置
- 支付相关配置需要到对应平台申请正式账号

#### 4. 启动 Redis

```bash
# Windows
redis-server.exe

# Linux/Mac
redis-server
```

#### 5. 编译项目

```bash
mvn clean compile
```

#### 6. 运行项目

**方式一：Maven 命令**
```bash
mvn spring-boot:run
```

**方式二：IDE 运行**
- 打开 `src/main/java/com/smart/www/SpringbootApplication.java`
- 右键选择 `Run 'SpringbootApplication'`

**方式三：打包运行**
```bash
mvn clean package -DskipTests
java -jar target/SmartSchool-0.0.1-SNAPSHOT.jar
```

#### 7. 验证启动

访问以下地址验证系统是否正常启动：

- **Knife4j 文档**：http://localhost:8081/doc.html
- **Swagger UI**：http://localhost:8081/swagger-ui.html

---

## 📚 核心模块详解

### 1. 用户认证模块

基于 **Sa-Token** 实现的轻量级权限认证框架。

#### 登录流程

```java
// 管理员登录
GET /Login/Admin?name=admin&pwd=123

// 学生登录
GET /Login/Student?name=学号&pwd=密码

// 教师登录
GET /Login/Teacher?name=工号&pwd=密码

// 家长登录
GET /Login/Parent?name=家长ID&pwd=密码
```

#### 登出

```java
GET /Logout
```

#### 会话查询

```java
GET /Login/isLogin
```

#### 配置说明

```yaml
sa-token:
  token-name: satoken                # Token 名称
  timeout: 2592000                   # Token 有效期（30天）
  active-timeout: -1                 # 活跃超时（-1 表示不限制）
  is-concurrent: true                # 允许并发登录
  is-share: true                     # 共享 Token
  token-style: uuid                  # Token 风格
  is-log: true                       # 输出日志
```

### 2. 健康监测模块

#### 健康数据采集

```java
// 获取用户健康数据
GET /userHealth?userId=xxx

// 获取每日健康数据
GET /userHealthDaily?userId=xxx&date=2024-01-01

// 添加健康数据
POST /userHealth
Content-Type: application/json
{
  "userId": "xxx",
  "height": 170.5,
  "weight": 65.0,
  "bmi": 22.5,
  // ... 其他健康指标
}
```

#### 健康预警

系统自动检测以下异常情况并发送预警：
- 心率异常（过高/过低）
- 血氧饱和度异常
- 体温异常
- BMI 异常
- 睡眠质量异常

```java
// 查询健康预警
GET /healthWarning?userId=xxx

// 查询预警详情
GET /healthWarning/{notificationId}
```

### 3. AI 健康顾问

#### 使用示例

```java
// AI 对话
GET /ai?message=你好

// 获取健康建议
GET /ai/Health?uid=学生ID
```

#### AI 响应示例

```json
{
  "code": 200,
  "message": "成功",
  "data": "根据您的健康数据分析：\n一、建议增加有氧运动，每天至少30分钟\n二、注意改善睡眠质量，建议22:00前入睡\n三、保持规律作息，避免熬夜\n四、适当增加蛋白质摄入\n五、定期监测心率变化\n六、保持良好的心理状态"
}
```

### 4. 药品管理模块

#### 药品 CRUD

```java
// 查询药品列表（分页）
GET /drugs?pageNum=1&pageSize=10

// 根据 ID 查询药品
GET /drugs/{drugId}

// 添加药品
POST /drugs
Content-Type: multipart/form-data
{
  "drugId": "D001",
  "name": "感冒灵",
  "price": 15.50,
  "quantity": 100,
  // ... 其他字段
}

// 更新药品
PUT /drugs/{id}

// 删除药品
DELETE /drugs/{id}
```

### 5. 订单与支付模块

#### 支付宝支付流程

```
用户下单 → 调用支付接口 → 跳转支付宝 → 用户支付 → 同步回调 → 异步通知 → 订单完成
```

#### 支付接口

```java
// 发起支付
GET /pay/alipay?dona_drugId=D001&dona_money=15.50&dona_sum=2&dona_userId=U001

// 同步回调（用户支付完成后跳转）
GET /pay/return

// 异步回调（支付宝服务器通知）
POST /pay/notify
```

#### 书杰支付

```java
// 发起书杰支付
GET /pay/shujiepay?dona_drugId=D001&dona_money=15.50&dona_sum=2&dona_userId=U001

// 同步回调
GET /pay/shujiepay/return

// 异步回调
POST /pay/shujiepay/notify
```

---

## 📖 API 文档

### 访问方式

启动项目后，访问以下地址查看完整 API 文档：

- **Knife4j 增强文档**：http://localhost:8081/doc.html
- **Swagger UI**：http://localhost:8081/swagger-ui.html
- **OpenAPI JSON**：http://localhost:8081/v3/api-docs

### API 分组

| 分组 | 说明 | 主要接口 |
|-----|------|---------|
| 登录接口 | 用户认证 | 登录、登出、会话查询 |
| 学生管理 | 学生信息 CRUD | 增删改查、批量操作 |
| 教师管理 | 教师信息 CRUD | 增删改查、班级关联 |
| 家长管理 | 家长信息 CRUD | 增删改查、学生关联 |
| 校医管理 | 校医信息 CRUD | 增删改查、预约管理 |
| 后勤管理 | 后勤人员管理 | 增删改查、设备管理 |
| 用户健康管理 | 健康数据 | 数据采集、查询、统计 |
| 用户健康日报 | 每日健康 | 日报生成、历史查询 |
| 健康预警通知管理 | 健康预警 | 预警查询、通知推送 |
| 健康检测分析 | AI 分析 | 健康建议、数据分析 |
| 药品管理 | 药品信息 | 增删改查、库存管理 |
| 医院管理 | 医院信息 | 增删改查、科室管理 |
| 药品医院关系管理 | 关联关系 | 关系维护、查询 |
| 预约管理 | 挂号预约 | 预约创建、查询、取消 |
| 订单管理 | 订单处理 | 订单创建、查询、统计 |
| 校医预约管理 | 校医预约 | 预约管理、状态更新 |
| 通知管理 | 系统通知 | 通知发布、查询 |
| 日志管理 | 操作日志 | 日志查询、审计 |
| 账号管理 | 账号操作 | 密码修改、状态管理 |

### 统一响应格式

所有 API 返回统一的 `Result<T>` 格式：

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    // 业务数据
  }
}
```

**状态码说明**：
- `200` - 成功
- `201` - 失败
- `208` - 未登录
- `209` - 无权限

### 分页响应格式

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "total": 100,
    "list": [
      // 数据列表
    ]
  }
}
```

---

## 🗄 数据库设计

### 核心表结构

#### 用户相关表

| 表名 | 说明 | 主要字段 |
|-----|------|---------|
| `user` | 系统管理员 | id, name, account, password, role |
| `student` | 学生信息 | id, student_id, name, grade, clazz, parent_id, teacher_id |
| `teacher` | 教师信息 | id, teacher_id, name, post, clazz |
| `parent` | 家长信息 | id, parent_id, name, student_id |
| `staff` | 校医信息 | id, staff_id, name, location, is_active |
| `logistics` | 后勤人员 | id, logistics_id, name, post, device_id |

#### 健康相关表

| 表名 | 说明 | 主要字段 |
|-----|------|---------|
| `user_health` | 用户健康数据 | id, user_id, height, weight, bmi, heart_rate, spo2, temperature |
| `user_health_daily` | 每日健康数据 | id, user_id, date, 各项健康指标 |
| `health_warning_notifications` | 健康预警通知 | id, notification_id, user_id, type, level, reading_value |

#### 医疗相关表

| 表名 | 说明 | 主要字段 |
|-----|------|---------|
| `drugs` | 药品信息 | id, drug_id, name, price, quantity, type, manufacturer |
| `hospitals` | 医院信息 | id, hospital_id, name, address, phone |
| `drugs_hospitals_relation` | 药品医院关系 | id, relation_type, type_id, type_name |
| `reservation` | 预约信息 | id, reservation_id, user_id, staff_id, status |

#### 订单相关表

| 表名 | 说明 | 主要字段 |
|-----|------|---------|
| `orders` | 订单信息 | id, orders_id, user_id, drug_id, amount, status |
| `staff_orders` | 校医预约订单 | id, orders_id, staff_id, user_id, status |

#### 系统相关表

| 表名 | 说明 | 主要字段 |
|-----|------|---------|
| `notifications` | 系统通知 | id, notify_id, title, content, publisher, notify_group |
| `logs_data` | 操作日志 | id, data_id, user_id, logs_type, result, ip |

### 数据库关系图

```
student (学生)
  ├─→ parent (家长) [parent_id]
  ├─→ teacher (教师) [teacher_id]
  └─→ user_health (健康数据) [student_id]
       └─→ user_health_daily (每日健康) [user_id]
            └─→ health_warning_notifications (预警) [user_id]

drugs (药品)
  ├─→ drugs_hospitals_relation (关联) [drug_id]
  └─→ orders (订单) [drug_id]

staff (校医)
  └─→ staff_orders (预约) [staff_id]
```

---

## ⚙️ 配置说明

### application.yaml 配置详解

```yaml
# 服务器配置
server:
  port: 8081                          # 应用端口

spring:
  # 应用名称
  application:
    name: SmartSchool

  # 环境配置
  profiles:
    active: dev                       # 激活开发环境

  # 数据源配置
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/smart_campus?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root
    password: 123456                  # ⚠️ 生产环境请修改

  # Redis 配置
  data:
    redis:
      host: 127.0.0.1
      port: 6379
      jedis:
        pool:
          max-active: 200             # 最大连接数
          max-idle: 10                # 最大空闲连接
          min-idle: 0                 # 最小空闲连接
          max-wait: -1ms              # 最大等待时间

  # AI 配置
  ai:
    dashscope:
      api-key: sk-xxx                 # ⚠️ 请替换为真实 API Key
      chat:
        options:
          model: qwen-plus            # 使用通义千问 Plus 模型

# MyBatis-Plus 配置
mybatis-plus:
  type-aliases-package: com.smart.www.pojo
  mapper-locations: classpath:com/smark/www/mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    cache-enabled: false
  global-config:
    db-config:
      id-type: assign_id              # 雪花算法生成 ID

# Knife4j 配置
knife4j:
  enable: true                        # 启用 Knife4j
  production: false                   # ⚠️ 生产环境建议设为 true

# SpringDoc 配置
springdoc:
  swagger-ui:
    path: /swagger-ui.html
  api-docs:
    path: /v3/api-docs
  group-configs:
    - group: 'default'
      paths-to-match: '/**'
      packages-to-scan: com.smart.www.controller

# Sa-Token 配置
sa-token:
  token-name: satoken
  timeout: 2592000                    # 30天
  active-timeout: -1
  is-concurrent: true
  is-share: true
  token-style: uuid
  is-log: true

# 书杰支付配置
shujiepay:
  pid: 1358                           # ⚠️ 商户ID
  platform-public-key: MIIBIjAN...   # ⚠️ 平台公钥
  merchant-private-key: MIIEvwIB...  # ⚠️ 商户私钥
  notify-url: http://xxx/pay/shujiepay/notify
  return-url: http://localhost:8081/pay/shujiepay/return
```

### 支付宝配置（PayController）

```java
private final String APP_ID = "9021000157658364";                    // ⚠️ 应用ID
private final String APP_PRIVATE_KEY = "MIIEvwIBADAN...";           // ⚠️ 应用私钥
private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkq...";         // ⚠️ 支付宝公钥
private final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";  // 沙箱网关
private final String NOTIFY_URL = "http://v2443f69.natappfree.cc/pay/notify";  // ⚠️ 异步通知地址（需公网）
private final String RETURN_URL = "http://localhost:8081/pay/return";          // 同步返回地址
```

⚠️ **重要提示**：
1. 支付宝沙箱环境仅用于测试，正式环境需要申请正式应用
2. `NOTIFY_URL` 必须是公网可访问地址，本地开发可使用内网穿透工具（如 natapp、ngrok）
3. 所有密钥信息不要提交到代码仓库，建议使用配置中心或环境变量

---

## 💻 开发指南

### 添加新功能模块

#### 1. 创建实体类

在 `pojo/` 包下创建实体类：

```java
@Data
@TableName("new_table")
public class NewEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    
    private String name;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
```

#### 2. 创建 Mapper 接口

在 `mapper/` 包下创建 Mapper：

```java
@Mapper
public interface NewEntityMapper extends BaseMapper<NewEntity> {
    // 自定义查询方法
}
```

#### 3. 创建 Service 接口和实现

```java
// Service 接口
public interface NewEntityService extends IService<NewEntity> {
    // 自定义业务方法
}

// Service 实现
@Service
public class NewEntityServiceImpl extends ServiceImpl<NewEntityMapper, NewEntity> 
    implements NewEntityService {
    // 实现业务逻辑
}
```

#### 4. 创建 Controller

```java
@RestController
@RequestMapping("/newEntity")
@Tag(name = "新模块管理")
public class NewEntityController {
    
    @Autowired
    private NewEntityService newEntityService;
    
    @GetMapping
    @Operation(summary = "查询列表")
    public Result<PageDTO<NewEntity>> list(PageQuery pageQuery) {
        Page<NewEntity> page = newEntityService.page(pageQuery.toMpPage());
        return Result.ok(PageDTO.of(page));
    }
    
    @PostMapping
    @Operation(summary = "添加")
    public Result<Void> add(@RequestBody NewEntity entity) {
        newEntityService.save(entity);
        return Result.ok();
    }
}
```

### 代码规范

#### 命名规范

- **类名**：大驼峰（PascalCase），如 `UserHealthController`
- **方法名**：小驼峰（camelCase），如 `getUserHealth`
- **常量**：全大写下划线分隔，如 `MAX_RETRY_COUNT`
- **包名**：全小写，如 `com.smart.www.controller`

#### 注释规范

```java
/**
 * 用户健康管理控制器
 * 
 * @author Smart Campus Team
 * @since 2024-01-01
 */
@RestController
@Tag(name = "用户健康管理")
public class UserHealthController {
    
    /**
     * 获取用户健康数据
     * 
     * @param userId 用户ID
     * @return 健康数据
     */
    @GetMapping("/{userId}")
    @Operation(summary = "获取用户健康数据")
    public Result<UserHealth> getUserHealth(@PathVariable String userId) {
        // 实现逻辑
    }
}
```

### 开发约定

- **统一返回结构**：`Result<T>`（`code/message/data`）
- **分页约定**：入参 `PageQuery`，出参 `PageDTO<T>`
- **控制器使用 `@Tag` / `@Operation` 注解维护文档**
- **Service 层封装业务与事务，Mapper 层专注数据访问**

---

## ❓ 常见问题

### 1. 启动问题

#### Q: 启动时报错 "Failed to configure a DataSource"

**A**: 检查数据库配置是否正确，确保 MySQL 服务已启动，数据库已创建。

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/smart_campus  # 确认数据库名称
    username: root                                  # 确认用户名
    password: 123456                                # 确认密码
```

#### Q: 启动时报错 "Could not connect to Redis"

**A**: 检查 Redis 是否已启动，端口是否正确。

```bash
# 启动 Redis
redis-server

# 测试连接
redis-cli ping
# 应返回 PONG
```

### 2. 支付问题

#### Q: 支付宝支付回调失败

**A**: 
1. 检查 `NOTIFY_URL` 是否为公网地址
2. 使用内网穿透工具（natapp、ngrok）将本地服务映射到公网
3. 检查支付宝应用配置中的回调地址是否正确

#### Q: 支付成功但订单状态未更新

**A**: 
1. 查看异步通知日志
2. 检查签名验证是否通过
3. 确认订单更新逻辑是否正确执行

### 3. API 文档问题

#### Q: 无法访问 Knife4j 文档

**A**: 
1. 确认项目已正常启动
2. 检查端口是否正确（默认 8081）
3. 访问 http://localhost:8081/doc.html
4. 检查 `knife4j.enable` 配置是否为 `true`

### 4. 权限问题

#### Q: 接口返回 "未登录"

**A**: 
1. 先调用登录接口获取 Token
2. 在请求头中携带 Token：`satoken: xxx`
3. 或在 Cookie 中携带 Token

#### Q: 接口返回 "无权限"

**A**: 
1. 检查用户角色是否正确
2. 确认接口是否需要特定权限
3. 查看 `@SaCheckLogin` 注解配置

### 5. 数据库问题

#### Q: MyBatis 找不到 Mapper XML 文件

**A**: 检查 `mybatis-plus.mapper-locations` 配置：

```yaml
mybatis-plus:
  mapper-locations: classpath:com/smart/www/mapper/*.xml  # 注意路径拼写
```

⚠️ **注意**：配置中写的是 `com/smark/www/mapper/*.xml`（smark），可能需要修改为 `com/smart/www/mapper/*.xml`（smart）

### 6. AI 功能问题

#### Q: AI 接口调用失败

**A**: 
1. 检查 API Key 是否正确配置
2. 确认 API Key 是否有效且有余额
3. 查看控制台错误日志
4. 检查网络连接是否正常

---

## 📝 更新日志

### v1.0.0 (2024-11-11)

- ✨ 初始版本发布
- ✅ 完成用户管理模块（学生、教师、家长、校医、后勤）
- ✅ 完成健康监测模块（健康数据、每日报告、预警通知）
- ✅ 完成医疗服务模块（药品、医院、预约）
- ✅ 完成订单支付模块（支付宝、书杰支付）
- ✅ 集成 AI 健康顾问（OpenAI、阿里云通义千问）
- ✅ 完成系统管理模块（通知、日志、权限）
- ✅ 集成 Knife4j API 文档
- ✅ 完成数据库设计与初始化脚本

---

## 🤝 贡献指南

欢迎贡献代码、提出问题和建议！

### 贡献流程

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

### 代码审查

所有 Pull Request 都需要经过代码审查才能合并。请确保：
- 代码符合项目规范
- 添加必要的注释
- 通过所有测试
- 更新相关文档

---

## 📄 许可证

本项目采用 **Apache License 2.0** 许可证。详见 [LICENSE](LICENSE) 文件。

---

## 📞 联系方式

- **项目维护**：Smart Campus Team
- **技术支持**：查看 API 文档中的联系信息
- **问题反馈**：提交 Issue 到本仓库

---

## 🙏 致谢

感谢以下开源项目：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MyBatis-Plus](https://baomidou.com/)
- [Sa-Token](https://sa-token.cc/)
- [Knife4j](https://doc.xiaominfo.com/)
- [Alibaba DashScope](https://dashscope.aliyun.com/)

---

<div align="center">

**⭐ 如果这个项目对你有帮助，请给一个 Star！⭐**

Made with ❤️ by Smart Campus Team

</div>
