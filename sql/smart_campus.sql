-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smart_campus
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drugs`
--

DROP TABLE IF EXISTS `drugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drugs`
(
    `id`              bigint         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `img`             longblob       NOT NULL COMMENT '图片',
    `drug_id`         varchar(255)   NOT NULL COMMENT '药品ID',
    `type_id`         int            NOT NULL COMMENT '药品类型id',
    `name`            varchar(255)   NOT NULL COMMENT '药品名字',
    `price`           decimal(10, 2) NOT NULL COMMENT '价格',
    `quantity`        int            NOT NULL COMMENT '数量',
    `specifications`  varchar(255) DEFAULT NULL COMMENT '规格',
    `type`            varchar(255) DEFAULT NULL COMMENT '类型',
    `usage1`          varchar(255) DEFAULT NULL COMMENT '用法',
    `dosage`          varchar(255) DEFAULT NULL COMMENT '使用剂量',
    `manufacturer`    varchar(255)   NOT NULL COMMENT '生产厂家',
    `expiration_date` varchar(255)   NOT NULL COMMENT '有效期',
    `symptoms`        varchar(255) DEFAULT NULL COMMENT '症状',
    `notes`           varchar(255) DEFAULT NULL COMMENT '备注',
    `create_time`     datetime       NOT NULL COMMENT '创建时间',
    `update_time`     datetime       NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY               `drug_id` (`drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drugs`
--

LOCK
TABLES `drugs` WRITE;
/*!40000 ALTER TABLE `drugs` DISABLE KEYS */;
INSERT INTO `drugs`
VALUES (1, _binary '1', '1', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53'),
       (2, _binary '1', '2', 1, '感冒灵', 20.50, 100, '10片/盒', '天帝', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 23:14:21'),
       (3, _binary '1', '3', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53'),
       (4, _binary '1', '4', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53'),
       (5, _binary '1', '5', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53'),
       (6, _binary '1', '6', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53'),
       (7, _binary '1', '7', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53'),
       (8, _binary '1', '8', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药',
        '2025-12-31', '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
/*!40000 ALTER TABLE `drugs` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `drugs_hospitals_relation`
--

DROP TABLE IF EXISTS `drugs_hospitals_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drugs_hospitals_relation`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `relation_type` int          NOT NULL COMMENT '关系类型',
    `type_id`       int          NOT NULL COMMENT '关联id',
    `type_name`     varchar(255) NOT NULL COMMENT '关联名字',
    `create_time`   datetime     NOT NULL COMMENT '创建时间',
    `update_time`   datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drugs_hospitals_relation`
--

LOCK
TABLES `drugs_hospitals_relation` WRITE;
/*!40000 ALTER TABLE `drugs_hospitals_relation` DISABLE KEYS */;
INSERT INTO `drugs_hospitals_relation`
VALUES (3, 1, 3, '天帝灵', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (4, 2, 1, '1级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (5, 2, 2, '2级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (6, 2, 3, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (7, 2, 4, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (8, 2, 5, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (9, 2, 6, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (10, 2, 7, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (11, 3, 1, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (12, 3, 2, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (13, 3, 3, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (14, 3, 4, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (15, 3, 5, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (16, 3, 6, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (17, 3, 7, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (18, 3, 8, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06'),
       (19, 1, 1, '天帝', '2024-03-24 23:03:24', '2024-03-24 23:03:24');
/*!40000 ALTER TABLE `drugs_hospitals_relation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `health_warning_notifications`
--

DROP TABLE IF EXISTS `health_warning_notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_warning_notifications`
(
    `id`                 bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `notification_id`    varchar(32) DEFAULT NULL,
    `user_id`            varchar(32) DEFAULT NULL,
    `type`               varchar(255) NOT NULL COMMENT '预警类型',
    `level`              varchar(255) NOT NULL COMMENT '预警等级',
    `time`               datetime     NOT NULL COMMENT '预警发出的时间',
    `reading_value`      varchar(255) NOT NULL COMMENT '测量值',
    `recommended_action` varchar(255) NOT NULL COMMENT '建议的行动或措施',
    `note`               varchar(255) NOT NULL COMMENT '备注',
    `create_time`        datetime     NOT NULL COMMENT '创建时间',
    `update_time`        datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY                  `notification_id` (`notification_id`),
    KEY                  `time` (`time`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_warning_notifications`
--

LOCK
TABLES `health_warning_notifications` WRITE;
/*!40000 ALTER TABLE `health_warning_notifications` DISABLE KEYS */;
INSERT INTO `health_warning_notifications`
VALUES (1, '1', '30005', '体重过高', '高', '2024-03-20 22:42:20', '55kg', '建议增加体育活动', '', '2024-03-20 22:42:20',
        '2024-03-20 22:42:20'),
       (2, '2', '20006', '心率过快', '低', '2024-03-20 22:42:20', '55kg', '建议增加休息时间', '', '2024-03-20 22:42:20',
        '2024-03-20 22:42:20'),
       (3, '3', '30003', '睡眠时间过低', '高', '2024-03-20 22:42:20', '55kg', '建议增加睡眠时间', '',
        '2024-03-20 22:42:20', '2024-03-20 22:42:20'),
       (4, '4', '40008', '步数过低', '高', '2024-03-20 22:42:20', '55kg', '建议增加体育活动', '', '2024-03-20 22:42:20',
        '2024-03-20 22:42:20');
/*!40000 ALTER TABLE `health_warning_notifications` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `hospitals`
--

DROP TABLE IF EXISTS `hospitals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospitals`
(
    `id`                bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `img`               longblob     NOT NULL COMMENT '图片',
    `hospital_id`       varchar(255) NOT NULL COMMENT '医院ID',
    `name`              varchar(255) NOT NULL COMMENT '医院名称',
    `address`           varchar(255) NOT NULL COMMENT '地址',
    `phone`             varchar(11)  NOT NULL COMMENT '联系电话',
    `grade`             int          NOT NULL COMMENT '医院等级',
    `type`              int          NOT NULL COMMENT '类型',
    `medical_insurance` int          NOT NULL COMMENT '医保情况，1支持，0不支持',
    `note`              varchar(255) DEFAULT NULL COMMENT '备注',
    `create_time`       datetime     NOT NULL COMMENT '创建时间',
    `update_time`       datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY                 `hospital_id` (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitals`
--

LOCK
TABLES `hospitals` WRITE;
/*!40000 ALTER TABLE `hospitals` DISABLE KEYS */;
INSERT INTO `hospitals`
VALUES (1, _binary '1', '1', '人民医院', '市中心路1号', '12345678910', 1, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (3, _binary '1', '3', '人民医院', '市中心路1号', '12345678910', 3, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (4, _binary '1', '4', '人民医院', '市中心路1号', '12345678910', 3, 2, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (5, _binary '1', '5', '人民医院', '市中心路1号', '12345678910', 1, 3, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (6, _binary '1', '6', '人民医院', '市中心路1号', '12345678910', 2, 4, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (7, _binary '1', '7', '人民医院', '市中心路1号', '12345678910', 2, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (8, _binary '1', '8', '人民医院', '市中心路1号', '12345678910', 2, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (9, _binary '1', '9', '人民医院', '市中心路1号', '12345678910', 2, 2, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30'),
       (10, _binary '1', '10', '人民医院', '市中心路1号', '12345678910', 3, 3, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
/*!40000 ALTER TABLE `hospitals` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `logistics`
--

DROP TABLE IF EXISTS `logistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logistics`
(
    `id`           bigint       NOT NULL AUTO_INCREMENT,
    `img`          longblob     NOT NULL COMMENT '图片',
    `type`         varchar(32)  NOT NULL COMMENT '人员类型',
    `device_id`    varchar(32)  NOT NULL COMMENT '设备ID',
    `logistics_id` varchar(255) NOT NULL COMMENT '后勤工号',
    `post`         varchar(32)  NOT NULL COMMENT '岗位',
    `name`         varchar(32)  NOT NULL COMMENT '姓名',
    `birth`        date         NOT NULL COMMENT '出生日期',
    `password`     varchar(64)  NOT NULL COMMENT '密码',
    `phone`        varchar(11)  NOT NULL COMMENT '手机号',
    `sex`          varchar(2)   NOT NULL COMMENT '性别',
    `status`       int          NOT NULL COMMENT '账号状态',
    `create_time`  datetime     NOT NULL COMMENT '创建时间',
    `update_time`  datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY            `logistics_id` (`logistics_id`),
    KEY            `post` (`post`),
    KEY            `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logistics`
--

LOCK
TABLES `logistics` WRITE;
/*!40000 ALTER TABLE `logistics` DISABLE KEYS */;
INSERT INTO `logistics`
VALUES (1, _binary '1', '后勤', 'dev103', '40001', '保安', '王二狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (4, _binary '1', '后勤', 'dev133', '40004', '保安', '校二狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (5, _binary '2', '后勤', 'dev133', '40005', '保安', '校二', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (6, _binary '1', '后勤', 'dev312', '40006', '保洁', '王四狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (7, _binary '1', '后勤', 'dev233', '40007', '饭堂', '王六狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (8, _binary '1', '后勤', 'dev436', '40008', '保洁', '王坝狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (9, _binary '1', '后勤', 'dev241', '40009', '保安', '王尔狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (10, _binary '1', '后勤', 'dev361', '40010', '保洁', '王嗄狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56'),
       (11, _binary '1', '后勤', 'dev103', '40010', '保安', '王二狗', '1980-06-06', '12131', '12345678903', '男', 1,
        '2024-03-26 22:47:54', '2024-03-26 22:47:54');
/*!40000 ALTER TABLE `logistics` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `logs_data`
--

DROP TABLE IF EXISTS `logs_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs_data`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `data_id`     varchar(255) NOT NULL COMMENT '日志id',
    `user_id`     varchar(255) NOT NULL COMMENT '人员id',
    `logs_type`   varchar(255) NOT NULL COMMENT '日志类型',
    `result`      varchar(255) NOT NULL COMMENT '执行结果',
    `msg`         varchar(255) NOT NULL COMMENT '结果说明',
    `ip`          varchar(255) NOT NULL COMMENT 'ip地址',
    `is_success`  int          NOT NULL COMMENT '是否成功,1成功,0失败',
    `create_time` datetime     NOT NULL COMMENT '操作时间',
    PRIMARY KEY (`id`),
    KEY           `data_id` (`data_id`),
    KEY           `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs_data`
--

LOCK
TABLES `logs_data` WRITE;
/*!40000 ALTER TABLE `logs_data` DISABLE KEYS */;
INSERT INTO `logs_data`
VALUES (3, 'c478eea0-b5ee-4cbd-a93d-52b45a5afee0', 'admin', '删除药品', '删除失败', '删除id:10不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-25 23:06:47'),
       (4, '07f11c6f-00bf-41a5-b906-ff5afc4eba96', 'admin', '删除药品', '删除成功', '删除id:9,名字:感冒灵',
        '0:0:0:0:0:0:0:1', 1, '2024-03-25 23:07:04'),
       (5, 'b431498e-79df-498b-a684-647a9e8ce2b3', 'admin', '修改药品', '修改成功', '修改id:2,名字:感冒灵',
        '0:0:0:0:0:0:0:1', 1, '2024-03-25 23:14:22'),
       (7, '4ae550d1-5b2c-470b-bf5a-f9055dc0bc1c', 'admin', '删除学生', '删除成功', '删除id:20002,名字:肖战',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 11:28:04'),
       (8, 'ce5953c6-2561-4bb7-b341-b37ae45a09f6', 'admin', '删除学生', '删除失败', '删除id:20002不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 11:28:42'),
       (9, '8ba5dfc8-bf2d-4d01-8c1b-eae5e22a0476', 'admin', '添加学生', '添加成功', '添加id:20201,名字:蔡徐坤',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 12:35:21'),
       (10, 'c9cf2136-0988-45fa-8841-513678dde733', 'admin', '修改学生', '修改成功', '修改id:20201,名字:蔡徐',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:17:13'),
       (11, '125553c1-cfcc-4fcf-aaaf-ef7859dfd0f9', 'admin', '修改学生', '修改成功', '修改id:20201,名字:蔡徐',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:17:51'),
       (12, '96639bfe-1be5-4bb8-9ac0-b610efd5947f', 'admin', '修改学生', '修改成功', '修改id:20201,名字:蔡徐',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:18:56'),
       (13, 'de6fd0aa-4527-4a05-bd94-582a62c09ad6', 'admin', '修改学生', '修改成功', '修改id:20003,名字:黄林峰',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:26:07'),
       (14, '94c0f184-5dd4-4e1f-9592-7b89a4f44814', 'admin', '删除老师', '删除失败', '删除id:30005不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 21:58:03'),
       (15, '4f305a96-b1f8-493a-b302-1803debc3c2b', 'admin', '删除老师', '删除成功', '删除id:30006,名字:胡老师',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 21:58:17'),
       (16, 'fa85bc1b-1417-4143-ae4b-e9f8c3a5cee7', 'admin', '更新老师', '更新成功', '更新id:30001,名字:李老师',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 22:01:35'),
       (17, 'b5fe3bcb-e91e-4e0f-818c-d45db267c587', 'admin', '删除后勤', '删除成功', '删除id:40003,名字:张二狗',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 22:40:10'),
       (18, 'bbee9d4c-678b-4e56-ab10-0b5903e3ac02', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:40:51'),
       (19, '6978dec8-513d-430a-bf9d-1cd50d72841a', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:41:02'),
       (20, '98c6343a-6fd2-4bec-907d-85adff875c1b', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:41:14'),
       (21, '8ccfa7c8-23f7-4ebd-ae44-c666a8447f06', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:43:34'),
       (22, '27c3b6a8-cba8-49e7-9bf2-647194ea38fe', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:43:42'),
       (23, '2d3a654d-555d-4607-924e-f1252b3c113d', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:43:57'),
       (24, 'df54fcd9-b622-4d45-9617-c6ce1b92501f', 'admin', '添加后勤', '添加失败', '添加id:40010,名字:王二狗',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:47:54'),
       (25, '19edfd4d-1134-4dc8-ad80-45b47d74bccc', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:48:28'),
       (26, '9748c2bc-f934-42d7-bf9a-dd4f8502050d', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:48:39'),
       (27, '445e636b-b32b-4a9b-8a86-f1d8792ea3dc', 'admin', '更新后勤', '更新成功', '更新id:40005,名字:校二',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 22:51:01'),
       (28, 'e2d324af-5ad6-406c-b4c3-496911ef8578', 'admin', '删除家长', '删除成功', '删除id:10003,名字:赵嗄六',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:23:04'),
       (29, '5179b5f7-1263-406a-8a27-9ad77d1fee36', 'admin', '更新家长', '更新失败', '更新id:10003已存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 20:25:03'),
       (30, 'a03b1977-00a3-4a28-8185-bba843cbae36', 'admin', '更新家长', '更新失败', '更新id:10004已存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 20:25:27'),
       (31, 'c7e10d8e-f6fa-44dd-83eb-41922579eeab', 'admin', '更新家长', '更新失败', '更新id:10004已存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 20:25:28'),
       (32, 'cfec75c3-ba11-472e-886d-f55388ce3c8c', 'admin', '更新家长', '更新成功', '更新id:10004,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:26:55'),
       (33, 'c1ce8e9c-e735-4cd1-b8d7-859dac1b387b', 'admin', '更新家长', '更新成功', '更新id:10004,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:01'),
       (34, '71fbcd1c-8ea1-434b-bce9-5ecff74e6435', 'admin', '更新家长', '更新成功', '更新id:10004,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:07'),
       (35, 'b20862a3-4a55-4984-9904-9c9bd2197d5d', 'admin', '更新家长', '更新成功', '更新id:10005,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:19'),
       (36, '1d9b3cd9-3065-4744-b33f-9bf997c2e04d', 'admin', '更新家长', '更新成功', '更新id:10005,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:19'),
       (37, '19f98042-fad3-4545-a7b3-d33833d988c8', 'admin', '更新家长', '更新成功', '更新id:10005,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:19'),
       (38, '4ae97ed1-e383-4a93-8135-16dbc60331c6', 'admin', '更新家长', '更新成功', '更新id:10005,名字:赵1六',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:55'),
       (39, '91341cb3-2661-4518-95a2-409da2b1a83e', 'admin', '删除预约', '删除失败', '删除id:1不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 22:40:15'),
       (40, '1658f3fc-0d11-48e4-91b9-835a771c7fa3', 'admin', '删除预约', '删除失败', '删除id:1不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 22:40:20'),
       (41, '42ac575e-b51c-4a93-bc21-17e2419db037', 'admin', '删除预约', '删除成功', '删除id:1,预约人名字:王宝强',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 22:41:06'),
       (42, '1324fb1b-6e7a-4ee5-b3ac-a2adbe574e54', 'admin', '更新预约', '更新成功', '更新id:1,预约人名字:王强',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 22:58:08'),
       (43, '8dab9f0e-4251-4b20-b946-9d42862a76a7', 'admin', '更新预约', '更新成功', '更新id:1,预约人名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 22:59:44'),
       (44, '496a4282-85d4-4354-a2f7-4d5640dfc673', 'admin', '更新订单', '更新成功', '更新id:1,购买药品:感灵',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 23:00:23'),
       (45, 'aa0e0b62-e6b3-490a-82a7-0dfde227f17f', 'admin', '更新订单', '更新成功', '更新id:1,购买药品:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 23:00:42'),
       (46, '188b6163-3c77-40d2-805a-b50135365c20', 'admin', '删除通知', '删除成功', '删除id:1,标题:学校教务处',
        '0:0:0:0:0:0:0:1', 1, '2024-03-29 17:12:14'),
       (47, '7439c5fc-c81c-4231-bb29-2fd8dcaca625', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:21:49'),
       (48, '25fb5940-2198-48ed-a97c-d08f388b04be', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:22:00'),
       (49, '39312eda-46b2-4c24-8e82-c779cd089029', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:24:29'),
       (50, '84d0be24-0fb9-4f5f-98f9-0de74f75a088', 'admin', '更新通知', '更新成功', '更新id:3,标题:校',
        '0:0:0:0:0:0:0:1', 1, '2024-03-29 17:29:17'),
       (51, '3af74fb5-e3cd-44ed-9f5e-69329339fcda', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:29:40'),
       (52, 'bbe23547-0407-436a-9e9c-04b7d6b2395a', 'admin', '更新通知', '更新成功', '更新id:4,标题:校',
        '0:0:0:0:0:0:0:1', 1, '2024-03-29 17:29:54');
/*!40000 ALTER TABLE `logs_data` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications`
(
    `id`           bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `notify_id`    int          NOT NULL COMMENT '消息id',
    `title`        varchar(255) NOT NULL COMMENT '标题',
    `publisher`    varchar(255) NOT NULL COMMENT '发布者',
    `content`      varchar(255) NOT NULL COMMENT '内容',
    `time`         datetime     NOT NULL COMMENT '日志时间',
    `notify_group` varchar(255) NOT NULL COMMENT '通知群体',
    `create_time`  datetime     NOT NULL COMMENT '创建时间',
    `update_time`  datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY            `notify_id` (`notify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK
TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications`
VALUES (2, 2, '校长', '紧急通知', '请所有学生注意安全', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41',
        '2024-03-20 22:00:41'),
       (3, 3, '校', '校长', '放假', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41', '2024-03-29 17:29:17'),
       (4, 4, '校', '紧急通知', '请所有学生注意安全', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41',
        '2024-03-29 17:29:54'),
       (5, 5, '学校教务处', '紧急通知', '请所有学生注意安全', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41',
        '2024-03-20 22:00:41');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders`
(
    `id`          bigint         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`    int            NOT NULL COMMENT '订单id',
    `user_id`     int            NOT NULL COMMENT '用户id',
    `drug_id`     int            NOT NULL COMMENT '药品id',
    `time`        datetime       NOT NULL COMMENT '购买时间',
    `price`       decimal(10, 2) NOT NULL COMMENT '金额',
    `quantity`    int            NOT NULL COMMENT '数量',
    `total_price` decimal(10, 2) NOT NULL COMMENT '总金额',
    `create_time` datetime       NOT NULL COMMENT '创建时间',
    `update_time` datetime       NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY           `order_id` (`order_id`),
    KEY           `user_id` (`user_id`),
    KEY           `drug_id` (`drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK
TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders`
VALUES (1, 1, 10001, 1, '2024-03-17 21:46:27', 20.00, 2, 41.00, '2024-03-17 21:46:27', '2024-03-28 23:00:41'),
       (2, 2, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27'),
       (3, 3, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27'),
       (4, 4, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27'),
       (5, 5, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parent`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `img`         longblob     NOT NULL COMMENT '图片',
    `type`        varchar(32)  NOT NULL COMMENT '人员类型',
    `parent_id`   varchar(255) NOT NULL COMMENT '家长ID',
    `student_id`  varchar(255) NOT NULL COMMENT '学号',
    `name`        varchar(32)  NOT NULL COMMENT '姓名',
    `password`    varchar(64)  NOT NULL COMMENT '密码',
    `phone`       varchar(11)  NOT NULL COMMENT '手机号',
    `sex`         varchar(2)   NOT NULL COMMENT '性别',
    `status`      int          NOT NULL COMMENT '账号状态',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY           `parent_id` (`parent_id`),
    KEY           `student_id` (`student_id`),
    KEY           `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK
TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent`
VALUES (1, _binary '1', '家长', '10001', '20001', '张赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13'),
       (2, _binary '1', '家长', '10002', '20002', '赵是六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13'),
       (3, _binary '1', '家长', '10003', '20003', '赵嗄六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13'),
       (4, _binary '1', '家长', '10004', '20004', '啊赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-28 20:27:07'),
       (5, _binary '1', '家长', '10005', '20005', '赵1六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-28 20:27:55'),
       (6, _binary '1', '家长', '10006', '20006', '锕赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13'),
       (8, _binary '1', '家长', '10008', '20008', '吃赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13'),
       (9, _binary '1', '家长', '10009', '20009', '阿赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13'),
       (10, _binary '1', '家长', '10010', '20010', '向赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation`
(
    `id`             bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `reservation_id` int          NOT NULL COMMENT '预约id',
    `user_id`        int          NOT NULL COMMENT '用户id',
    `staff_id`       varchar(255) NOT NULL COMMENT '医生id',
    `time`           datetime     NOT NULL COMMENT '预约时间',
    `location`       varchar(255) NOT NULL COMMENT '地点',
    `create_time`    datetime     NOT NULL COMMENT '创建时间',
    `update_time`    datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY              `reservation_id` (`reservation_id`),
    KEY              `user_id` (`user_id`),
    KEY              `staff_id` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK
TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation`
VALUES (1, 1, 20005, '50004', '2024-03-17 21:46:27', '医室', '2024-03-17 21:46:27', '2024-03-28 22:59:43'),
       (3, 3, 20002, '50003', '2024-03-17 21:46:27', '医务室', '2024-03-17 21:46:27', '2024-03-17 21:46:27');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `staff_id`    int          NOT NULL COMMENT '员工ID',
    `name`        varchar(255) NOT NULL COMMENT '名字',
    `sex`         varchar(255) NOT NULL COMMENT '性别',
    `birth`       date         NOT NULL COMMENT '出生日期',
    `phone`       varchar(11)  NOT NULL COMMENT '联系电话',
    `location`    varchar(255) NOT NULL COMMENT '岗位地点',
    `is_active`   varchar(255) NOT NULL COMMENT '是否在职',
    `note`        varchar(255) DEFAULT NULL COMMENT '备注',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime     NOT NULL COMMENT '最后修改时间',
    `img`         longblob,
    PRIMARY KEY (`id`),
    KEY           `staff_id` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK
TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff`
VALUES (1, 50001, '校张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (2, 50002, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (3, 50003, '校医张', '男', '1990-01-01', '123478911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (4, 50004, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '11'),
       (5, 50005, '校医张', '男', '1990-01-01', '123458911', '医务室', '休假', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (7, 50007, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (8, 50008, '校医张', '男', '1990-01-01', '123478911', '医务室', '休假', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (9, 50009, '校医张', '男', '1990-01-01', '123478911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1'),
       (10, 50010, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', _binary '1');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `img`         longblob     NOT NULL COMMENT '图片',
    `type`        varchar(32)  NOT NULL COMMENT '人员类型',
    `grade`       varchar(32)  NOT NULL COMMENT '年级',
    `device_id`   varchar(32)  NOT NULL COMMENT '设备ID',
    `birth`       date         NOT NULL COMMENT '出生日期',
    `parent_id`   varchar(255) NOT NULL COMMENT '家长ID',
    `student_id`  varchar(255) NOT NULL COMMENT '学号',
    `teacher_id`  varchar(255) NOT NULL COMMENT '班主任',
    `clazz`       varchar(32)  NOT NULL COMMENT '班级',
    `name`        varchar(32)  NOT NULL COMMENT '姓名',
    `password`    varchar(64)  NOT NULL COMMENT '密码',
    `phone`       varchar(11)  NOT NULL COMMENT '手机号',
    `sex`         varchar(2)   NOT NULL COMMENT '性别',
    `status`      int          NOT NULL COMMENT '账号状态',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY           `device_id` (`device_id`),
    KEY           `parent_id` (`parent_id`),
    KEY           `student_id` (`student_id`),
    KEY           `teacher_id` (`teacher_id`),
    KEY           `clazz` (`clazz`),
    KEY           `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK
TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student`
VALUES (3, _binary '1', '学生', '高中部', 'dev003', '2022-03-10', '10001', '20003', '30002', '高三2班', '黄林峰',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 16:26:07'),
       (4, _binary '1', '学生', '高中部', 'dev004', '2022-03-10', '10001', '20004', '30001', '高三1班', '迪丽热巴',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31'),
       (5, _binary '1', '学生', '高中部', 'dev005', '2022-03-10', '10001', '20005', '30003', '高三2班', '王宝强',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31'),
       (6, _binary '1', '学生', '高中部', 'dev006', '2022-03-10', '10001', '20006', '30003', '高三1班', '王二狗',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31'),
       (7, _binary '1', '学生', '高中部', 'dev007', '2022-03-10', '10001', '20007', '30003', '高三3班', '李大钊',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31'),
       (8, _binary '1', '学生', '高中部', 'dev008', '2022-03-10', '10001', '20008', '30001', '高三3班', '胡适',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31'),
       (9, _binary '1', '学生', '高中部', 'dev009', '2022-03-10', '10001', '20009', '30002', '高三1班', '周星驰',
        'password', '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31'),
       (10, _binary '1', '学生', '高中部', 'dev010', '2022-03-10', '10001', '20010', '30003', '高三4班', '陈龙',
        'password', '12345678901', '男', 0, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher`
(
    `id`                bigint       NOT NULL AUTO_INCREMENT,
    `img`               longblob     NOT NULL COMMENT '图片',
    `type`              varchar(32)  NOT NULL COMMENT '人员类型',
    `device_id`         varchar(32)  NOT NULL COMMENT '设备ID',
    `birth`             date         NOT NULL COMMENT '出生日期',
    `clazz`             varchar(32) DEFAULT NULL,
    `teacher_id`        varchar(255) NOT NULL COMMENT '教师工号',
    `post`              varchar(32)  NOT NULL COMMENT '岗位',
    `name`              varchar(32)  NOT NULL COMMENT '姓名',
    `password`          varchar(64)  NOT NULL COMMENT '密码',
    `phone`             varchar(11)  NOT NULL COMMENT '手机号',
    `sex`               varchar(2)   NOT NULL COMMENT '性别',
    `emergency_contact` int          NOT NULL COMMENT '紧急联系人员',
    `status`            int          NOT NULL COMMENT '账号状态',
    `create_time`       datetime     NOT NULL COMMENT '创建时间',
    `update_time`       datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY                 `device_id` (`device_id`),
    KEY                 `teacher_id` (`teacher_id`),
    KEY                 `post` (`post`),
    KEY                 `phone` (`phone`),
    KEY                 `emergency_contact` (`emergency_contact`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK
TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher`
VALUES (1, _binary '1', '老师', 'dev321', '1998-01-01', '高三1班', '30001', '班主任', '李老师', 'password',
        '12345678902', '女', 0, 1, '2024-03-23 23:12:03', '2024-03-26 22:01:35'),
       (2, _binary '1', '老师', 'dev323', '1998-01-01', '暂无', '30002', '普通教师', '张老师', 'password',
        '12345678902', '女', 1, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03'),
       (3, _binary '1', '老师', 'dev123', '1998-01-01', '暂无', '30003', '普通教师', '王老师', 'password',
        '12345678902', '女', 0, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03'),
       (4, _binary '1', '老师', 'dev432', '1998-01-01', '高三2班', '30004', '班主任', '陈老师', 'password',
        '12345678902', '女', 0, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03'),
       (7, _binary '1', '老师', 'dev868', '1998-01-01', '暂无', '30007', '教务处', '黄老师', 'password', '12345678902',
        '女', 0, 0, '2024-03-23 23:12:03', '2024-03-23 23:12:03'),
       (8, _binary '1', '老师', 'dev456', '1998-01-01', '暂无', '30008', '教务处', '赵老师', 'password', '12345678902',
        '女', 1, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03'),
       (9, _binary '1', '老师', 'dev564', '1998-01-01', '暂无', '30009', '普通教师', '谢老师', 'password',
        '12345678902', '女', 0, 0, '2024-03-23 23:12:03', '2024-03-23 23:12:03'),
       (10, _binary '1', '老师', 'dev054', '1998-01-01', '暂无', '30010', '教务处', '成老师', 'password', '12345678902',
        '女', 1, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `id`       bigint      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`     varchar(32) NOT NULL COMMENT '名字',
    `account`  varchar(32) NOT NULL COMMENT '账号',
    `password` varchar(32) NOT NULL COMMENT '密码',
    `role`     int         NOT NULL COMMENT '1系统管理员,2学校教务处',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK
TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user`
VALUES (1, '系统管理员', 'admin', 'admin', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_health`
--

DROP TABLE IF EXISTS `user_health`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_health`
(
    `id`                      bigint        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`                 int           NOT NULL COMMENT '用户id',
    `height`                  decimal(5, 2) NOT NULL COMMENT '身高',
    `weight`                  decimal(5, 2) NOT NULL COMMENT '体重',
    `fat_percentage`          decimal(5, 2) NOT NULL COMMENT '脂肪率',
    `BMI`                     decimal(5, 2) NOT NULL COMMENT 'BMI',
    `type`                    varchar(32)   NOT NULL COMMENT '身体类型',
    `measure_time`            varchar(32)   NOT NULL COMMENT '最近测量时间',
    `sleep_time_total`        varchar(32)   NOT NULL COMMENT '累计睡眠时长',
    `deep_sleep_total`        varchar(32)   NOT NULL COMMENT '累计深睡时长',
    `light_sleep_total`       varchar(32)   NOT NULL COMMENT '累计浅睡时长',
    `wake_time_total`         varchar(32)   NOT NULL COMMENT '累计清醒时长',
    `list_sleep_time`         varchar(32)   NOT NULL COMMENT '昨晚入睡时间',
    `today_wakeup_time`       varchar(32)   NOT NULL COMMENT '今天起床时间',
    `step`                    varchar(32)   NOT NULL COMMENT '走步步数',
    `walking_distance`        varchar(32)   NOT NULL COMMENT '走步距离',
    `walking_time`            varchar(32)   NOT NULL COMMENT '走步时长',
    `calorie`                 varchar(32)   NOT NULL COMMENT '卡路里',
    `mean_resting_heart_rate` varchar(32)   NOT NULL COMMENT '平均静息心率',
    `resting_heart_rate_max`  varchar(32)   NOT NULL COMMENT '静息心率最高',
    `resting_heart_rate_min`  varchar(32)   NOT NULL COMMENT '静息心率最低',
    `spo2`                    decimal(4, 1) NOT NULL COMMENT '血氧',
    `temperature`             varchar(32)   NOT NULL COMMENT '体温',
    `create_time`             datetime      NOT NULL COMMENT '创建时间',
    `update_time`             datetime      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY                       `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_health`
--

LOCK
TABLES `user_health` WRITE;
/*!40000 ALTER TABLE `user_health` DISABLE KEYS */;
INSERT INTO `user_health`
VALUES (1, 20001, 170.50, 60.50, 20.50, 22.05, '偏瘦', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '0小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '75次/分钟', '90次/分钟', '60次/分钟', 98.5, '36.5°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (2, 20002, 165.50, 55.50, 18.50, 20.95, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '6.5小时', '1小时',
        '22:30', '07:30', '8000', '4公里', '45分钟', '1800', '70次/分钟', '85次/分钟', '65次/分钟', 98.0, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (3, 20003, 180.50, 75.50, 25.50, 23.95, '偏重', '2022-01-01 08:00:00', '8小时', '2小时', '6小时', '2小时',
        '23:30', '06:30', '12000', '6公里', '1小时30分钟', '2400', '80次/分钟', '95次/分钟', '70次/分钟', 97.5,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (4, 20004, 155.50, 45.50, 14.50, 19.75, '偏瘦', '2022-01-01 08:00:00', '11小时', '3.5小时', '8.5小时', '0小时',
        '22:30', '07:30', '9000', '4.5公里', '45分钟', '1600', '65次/分钟', '80次/分钟', '60次/分钟', 98.8, '36.3°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (5, 20005, 175.50, 65.50, 22.50, 21.95, '正常', '2022-01-01 08:00:00', '9小时30分钟', '2.5小时', '7小时',
        '1小时30分钟', '23:00', '07:00', '11000', '5.5公里', '1小时15分钟', '2200', '78次/分钟', '92次/分钟',
        '68次/分钟', 98.3, '36.7°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (6, 20006, 160.50, 50.50, 16.50, 20.35, '偏瘦', '2022-01-01 08:00:00', '10小时30分钟', '3小时', '7.5小时',
        '30分钟', '23:00', '07:30', '9500', '4.8公里', '1小时', '1850', '72次/分钟', '88次/分钟', '63次/分钟', 98.6,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (7, 20007, 185.50, 80.50, 28.50, 24.75, '偏重', '2022-01-01 08:00:00', '8小时30分钟', '2.5小时', '6小时30分钟',
        '2小时30分钟', '23:30', '06:30', '13000', '6.5公里', '1小时15分钟', '2600', '85次/分钟', '98次/分钟',
        '73次/分钟', 97.8, '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (8, 20008, 150.50, 40.50, 12.50, 18.95, '偏瘦', '2022-01-01 08:00:00', '12小时', '4小时', '8小时', '30分钟',
        '22:30', '07:30', '8500', '4.2公里', '45分钟', '1450', '68次/分钟', '83次/分钟', '62次/分钟', 98.9, '36.2°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (9, 20009, 178.50, 72.50, 24.50, 22.35, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '7小时', '30分钟',
        '23:30', '07:30', '11500', '5.8公里', '1小时', '2350', '74次/分钟', '91次/分钟', '67次/分钟', 98.4, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (10, 20010, 163.50, 53.50, 19.50, 21.15, '正常', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '1小时',
        '23:30', '07:30', '10500', '5.2公里', '1小时15分钟', '2150', '71次/分钟', '86次/分钟', '64次/分钟', 98.7,
        '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (11, 30001, 170.50, 60.50, 20.50, 22.05, '偏瘦', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '0小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '75次/分钟', '90次/分钟', '60次/分钟', 98.5, '36.5°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (12, 30002, 165.50, 55.50, 18.50, 20.95, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '6.5小时', '1小时',
        '22:30', '07:30', '8000', '4公里', '45分钟', '1800', '70次/分钟', '85次/分钟', '65次/分钟', 98.0, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (13, 30003, 180.50, 75.50, 25.50, 23.95, '偏重', '2022-01-01 08:00:00', '8小时', '2小时', '6小时', '2小时',
        '23:30', '06:30', '12000', '6公里', '1小时30分钟', '2400', '80次/分钟', '95次/分钟', '70次/分钟', 97.5,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (14, 30004, 155.50, 45.50, 14.50, 19.75, '偏瘦', '2022-01-01 08:00:00', '11小时', '3.5小时', '8.5小时', '0小时',
        '22:30', '07:30', '9000', '4.5公里', '45分钟', '1600', '65次/分钟', '80次/分钟', '60次/分钟', 98.8, '36.3°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (15, 30005, 175.50, 65.50, 22.50, 21.95, '正常', '2022-01-01 08:00:00', '9小时30分钟', '2.5小时', '7小时',
        '1小时30分钟', '23:00', '07:00', '11000', '5.5公里', '1小时15分钟', '2200', '78次/分钟', '92次/分钟',
        '68次/分钟', 98.3, '36.7°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (16, 30006, 160.50, 50.50, 16.50, 20.35, '偏瘦', '2022-01-01 08:00:00', '10小时30分钟', '3小时', '7.5小时',
        '30分钟', '23:00', '07:30', '9500', '4.8公里', '1小时', '1850', '72次/分钟', '88次/分钟', '63次/分钟', 98.6,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (17, 30007, 185.50, 80.50, 28.50, 24.75, '偏重', '2022-01-01 08:00:00', '8小时30分钟', '2.5小时', '6小时30分钟',
        '2小时30分钟', '23:30', '06:30', '13000', '6.5公里', '1小时15分钟', '2600', '85次/分钟', '98次/分钟',
        '73次/分钟', 97.8, '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (18, 30008, 150.50, 40.50, 12.50, 18.95, '偏瘦', '2022-01-01 08:00:00', '12小时', '4小时', '8小时', '30分钟',
        '22:30', '07:30', '8500', '4.2公里', '45分钟', '1450', '68次/分钟', '83次/分钟', '62次/分钟', 98.9, '36.2°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (19, 30009, 178.50, 72.50, 24.50, 22.35, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '7小时', '30分钟',
        '23:30', '07:30', '11500', '5.8公里', '1小时', '2350', '74次/分钟', '91次/分钟', '67次/分钟', 98.4, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (20, 30010, 163.50, 53.50, 19.50, 21.15, '正常', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '1小时',
        '23:30', '07:30', '10500', '5.2公里', '1小时15分钟', '2150', '71次/分钟', '86次/分钟', '64次/分钟', 98.7,
        '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (21, 40001, 170.50, 60.50, 20.50, 22.05, '偏瘦', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '0小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '75次/分钟', '90次/分钟', '60次/分钟', 98.5, '36.5°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (22, 40002, 165.50, 55.50, 18.50, 20.95, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '6.5小时', '1小时',
        '22:30', '07:30', '8000', '4公里', '45分钟', '1800', '70次/分钟', '85次/分钟', '65次/分钟', 98.0, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (23, 40003, 180.50, 75.50, 25.50, 23.95, '偏重', '2022-01-01 08:00:00', '8小时', '2小时', '6小时', '2小时',
        '23:30', '06:30', '12000', '6公里', '1小时30分钟', '2400', '80次/分钟', '95次/分钟', '70次/分钟', 97.5,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (24, 40004, 155.50, 45.50, 14.50, 19.75, '偏瘦', '2022-01-01 08:00:00', '11小时', '3.5小时', '8.5小时', '0小时',
        '22:30', '07:30', '9000', '4.5公里', '45分钟', '1600', '65次/分钟', '80次/分钟', '60次/分钟', 98.8, '36.3°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (25, 40005, 175.50, 65.50, 22.50, 21.95, '正常', '2022-01-01 08:00:00', '9小时30分钟', '2.5小时', '7小时',
        '1小时30分钟', '23:00', '07:00', '11000', '5.5公里', '1小时15分钟', '2200', '78次/分钟', '92次/分钟',
        '68次/分钟', 98.3, '36.7°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (26, 40006, 160.50, 50.50, 16.50, 20.35, '偏瘦', '2022-01-01 08:00:00', '10小时30分钟', '3小时', '7.5小时',
        '30分钟', '23:00', '07:30', '9500', '4.8公里', '1小时', '1850', '72次/分钟', '88次/分钟', '63次/分钟', 98.6,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (27, 40007, 185.50, 80.50, 28.50, 24.75, '偏重', '2022-01-01 08:00:00', '8小时30分钟', '2.5小时', '6小时30分钟',
        '2小时30分钟', '23:30', '06:30', '13000', '6.5公里', '1小时15分钟', '2600', '85次/分钟', '98次/分钟',
        '73次/分钟', 97.8, '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (28, 40008, 150.50, 40.50, 12.50, 18.95, '偏瘦', '2022-01-01 08:00:00', '12小时', '4小时', '8小时', '30分钟',
        '22:30', '07:30', '8500', '4.2公里', '45分钟', '1450', '68次/分钟', '83次/分钟', '62次/分钟', 98.9, '36.2°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (29, 40009, 178.50, 72.50, 24.50, 22.35, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '7小时', '30分钟',
        '23:30', '07:30', '11500', '5.8公里', '1小时', '2350', '74次/分钟', '91次/分钟', '67次/分钟', 98.4, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00'),
       (30, 40010, 163.50, 53.50, 19.50, 21.15, '正常', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '1小时',
        '23:30', '07:30', '10500', '5.2公里', '1小时15分钟', '2150', '71次/分钟', '86次/分钟', '64次/分钟', 98.7,
        '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
/*!40000 ALTER TABLE `user_health` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_health_daily`
--

DROP TABLE IF EXISTS `user_health_daily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_health_daily`
(
    `id`                      bigint        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`                 varchar(255)  NOT NULL COMMENT '用户id',
    `date`                    date          NOT NULL COMMENT '日期',
    `height`                  decimal(5, 2) NOT NULL COMMENT '身高',
    `weight`                  decimal(5, 2) NOT NULL COMMENT '体重',
    `fat_percentage`          decimal(5, 2) NOT NULL COMMENT '脂肪率',
    `BMI`                     decimal(5, 2) NOT NULL COMMENT 'BMI',
    `type`                    varchar(32)   NOT NULL COMMENT '身体类型',
    `measure_time`            varchar(32)   NOT NULL COMMENT '最近测量时间',
    `sleep_time_total`        varchar(32)   NOT NULL COMMENT '累计睡眠时长',
    `deep_sleep_total`        varchar(32)   NOT NULL COMMENT '累计深睡时长',
    `light_sleep_total`       varchar(32)   NOT NULL COMMENT '累计浅睡时长',
    `wake_time_total`         varchar(32)   NOT NULL COMMENT '累计清醒时长',
    `list_sleep_time`         varchar(32)   NOT NULL COMMENT '昨晚入睡时间',
    `today_wakeup_time`       varchar(32)   NOT NULL COMMENT '今天起床时间',
    `step`                    varchar(32)   NOT NULL COMMENT '走步步数',
    `walking_distance`        varchar(32)   NOT NULL COMMENT '走步距离',
    `walking_time`            varchar(32)   NOT NULL COMMENT '走步时长',
    `calorie`                 varchar(32)   NOT NULL COMMENT '卡路里',
    `mean_resting_heart_rate` varchar(32)   NOT NULL COMMENT '平均静息心率',
    `resting_heart_rate_max`  varchar(32)   NOT NULL COMMENT '静息心率最高',
    `resting_heart_rate_min`  varchar(32)   NOT NULL COMMENT '静息心率最低',
    `spo2`                    decimal(4, 1) NOT NULL COMMENT '血氧',
    `temperature`             varchar(32)   NOT NULL COMMENT '体温',
    `create_time`             datetime      NOT NULL COMMENT '创建时间',
    `update_time`             datetime      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY                       `user_id` (`user_id`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_health_daily`
--

LOCK
TABLES `user_health_daily` WRITE;
/*!40000 ALTER TABLE `user_health_daily` DISABLE KEYS */;
INSERT INTO `user_health_daily`
VALUES (1, '20003', '2022-01-01', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-01 10:00:00', '7小时32分钟', '3小时',
        '4小时', '10小时32分钟', '23:00', '07:00', '23123', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-01 10:00:00', '2022-01-01 10:00:00'),
       (2, '20003', '2022-01-02', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-02 10:00:00', '7小时32分钟', '3小时',
        '4小时', '10小时', '23:00', '07:00', '3231', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-02 10:00:00', '2022-01-02 10:00:00'),
       (3, '20003', '2022-01-03', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-03 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '23', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-03 10:00:00', '2022-01-03 10:00:00'),
       (4, '20003', '2022-01-04', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-04 10:00:00', '7小时', '3小时32分钟',
        '4小时', '10小时', '23:00', '07:00', '1213', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-04 10:00:00', '2022-01-04 10:00:00'),
       (5, '20003', '2022-01-05', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-05 10:00:00', '7小时32分钟', '3小时',
        '4小时', '10小时', '23:00', '07:00', '2332', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-05 10:00:00', '2022-01-05 10:00:00'),
       (6, '20003', '2022-01-06', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-06 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '1212', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-06 10:00:00', '2022-01-06 10:00:00'),
       (7, '20003', '2022-01-07', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-07 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '31232', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-07 10:00:00', '2022-01-07 10:00:00');
/*!40000 ALTER TABLE `user_health_daily` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-30 12:09:05
