/*
 Navicat Premium Data Transfer

 Source Server         : itheima
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : smart_campus

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 11/11/2025 15:45:31
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drugs
-- ----------------------------
DROP TABLE IF EXISTS `drugs`;
CREATE TABLE `drugs`
(
    `id`              bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `img`             longblob                                                      NOT NULL COMMENT '图片',
    `drug_id`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品ID',
    `type_id`         int                                                           NOT NULL COMMENT '药品类型id',
    `name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品名字',
    `price`           decimal(10, 2)                                                NOT NULL COMMENT '价格',
    `quantity`        int                                                           NOT NULL COMMENT '数量',
    `specifications`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规格',
    `type`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型',
    `usage1`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用法',
    `dosage`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '使用剂量',
    `manufacturer`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生产厂家',
    `expiration_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '有效期',
    `symptoms`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '症状',
    `notes`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `create_time`     datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`     datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX             `drug_id`(`drug_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 174 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for drugs_hospitals_relation
-- ----------------------------
DROP TABLE IF EXISTS `drugs_hospitals_relation`;
CREATE TABLE `drugs_hospitals_relation`
(
    `id`            bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `relation_type` int                                                           NOT NULL COMMENT '关系类型',
    `type_id`       int                                                           NOT NULL COMMENT '关联id',
    `type_name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联名字',
    `create_time`   datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for health_warning_notifications
-- ----------------------------
DROP TABLE IF EXISTS `health_warning_notifications`;
CREATE TABLE `health_warning_notifications`
(
    `id`                 bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `notification_id`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `user_id`            varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `type`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预警类型',
    `level`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预警等级',
    `time`               datetime                                                      NOT NULL COMMENT '预警发出的时间',
    `reading_value`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '测量值',
    `recommended_action` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '建议的行动或措施',
    `create_time`        datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`        datetime                                                      NOT NULL COMMENT '最后修改时间',
    `reading_key`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                `notification_id`(`notification_id` ASC) USING BTREE,
    INDEX                `time`(`time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5049 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics`
(
    `id`           bigint                                                        NOT NULL AUTO_INCREMENT,
    `img`          longblob                                                      NOT NULL COMMENT '图片',
    `type`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '人员类型',
    `device_id`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '设备ID',
    `logistics_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '后勤工号',
    `post`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '岗位',
    `name`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '姓名',
    `birth`        date                                                          NOT NULL COMMENT '出生日期',
    `password`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '密码',
    `phone`        varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '手机号',
    `sex`          varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '性别',
    `status`       int                                                           NOT NULL COMMENT '账号状态',
    `create_time`  datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`  datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `logistics_id`(`logistics_id` ASC) USING BTREE,
    INDEX          `post`(`post` ASC) USING BTREE,
    INDEX          `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for logs_data
-- ----------------------------
DROP TABLE IF EXISTS `logs_data`;
CREATE TABLE `logs_data`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `data_id`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志id',
    `user_id`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员id',
    `logs_type`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志类型',
    `result`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '执行结果',
    `msg`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '结果说明',
    `ip`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ip地址',
    `is_success`  int                                                           NOT NULL COMMENT '是否成功,1成功,0失败',
    `create_time` datetime                                                      NOT NULL COMMENT '操作时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `data_id`(`data_id` ASC) USING BTREE,
    INDEX         `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 235 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for notifications
-- ----------------------------
DROP TABLE IF EXISTS `notifications`;
CREATE TABLE `notifications`
(
    `id`           bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `notify_id`    int                                                           NOT NULL COMMENT '消息id',
    `title`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
    `publisher`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发布者',
    `content`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
    `time`         datetime                                                      NOT NULL COMMENT '日志时间',
    `notify_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知群体',
    `create_time`  datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`  datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `notify_id`(`notify_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for parent
-- ----------------------------
DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `img`         longblob                                                      NOT NULL COMMENT '图片',
    `type`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '人员类型',
    `parent_id`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '家长ID',
    `student_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
    `name`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '姓名',
    `password`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '密码',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '手机号',
    `sex`         varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '性别',
    `status`      int                                                           NOT NULL COMMENT '账号状态',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `parent_id`(`parent_id` ASC) USING BTREE,
    INDEX         `student_id`(`student_id` ASC) USING BTREE,
    INDEX         `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `staff_id`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
    `sex`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
    `birth`       date                                                          NOT NULL COMMENT '出生日期',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '联系电话',
    `location`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位地点',
    `is_active`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否在职',
    `note`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '最后修改时间',
    `img`         longblob NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `staff_id`(`staff_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for staff_orders
-- ----------------------------
DROP TABLE IF EXISTS `staff_orders`;
CREATE TABLE `staff_orders`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `orders_id`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '预约id',
    `staff_id`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '校医id',
    `user_id`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '用户id',
    `status`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预约状态',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `img`         longblob                                                      NOT NULL COMMENT '图片',
    `type`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '人员类型',
    `grade`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '年级',
    `device_id`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '设备ID',
    `birth`       date                                                          NOT NULL COMMENT '出生日期',
    `parent_id`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '家长ID',
    `student_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
    `teacher_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班主任',
    `clazz`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '班级',
    `name`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '姓名',
    `password`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '密码',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '手机号',
    `sex`         varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '性别',
    `status`      int                                                           NOT NULL COMMENT '账号状态',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `device_id`(`device_id` ASC) USING BTREE,
    INDEX         `parent_id`(`parent_id` ASC) USING BTREE,
    INDEX         `student_id`(`student_id` ASC) USING BTREE,
    INDEX         `teacher_id`(`teacher_id` ASC) USING BTREE,
    INDEX         `clazz`(`clazz` ASC) USING BTREE,
    INDEX         `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6501 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `img`         longblob                                                      NOT NULL COMMENT '图片',
    `type`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '人员类型',
    `device_id`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '设备ID',
    `birth`       date                                                          NOT NULL COMMENT '出生日期',
    `clazz`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `teacher_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师工号',
    `post`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '岗位',
    `name`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '姓名',
    `password`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '密码',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '手机号',
    `sex`         varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '性别',
    `status`      int                                                           NOT NULL COMMENT '账号状态',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `device_id`(`device_id` ASC) USING BTREE,
    INDEX         `teacher_id`(`teacher_id` ASC) USING BTREE,
    INDEX         `post`(`post` ASC) USING BTREE,
    INDEX         `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 251 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       bigint                                                       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
    `account`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `role`     int                                                          NOT NULL COMMENT '1系统管理员,2学校教务处',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_health
-- ----------------------------
DROP TABLE IF EXISTS `user_health`;
CREATE TABLE `user_health`
(
    `id`                      bigint                                                       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `height`                  decimal(5, 2)                                                NOT NULL COMMENT '身高',
    `weight`                  decimal(5, 2)                                                NOT NULL COMMENT '体重',
    `fat_percentage`          decimal(5, 2)                                                NOT NULL COMMENT '脂肪率',
    `BMI`                     decimal(5, 2)                                                NOT NULL COMMENT 'BMI',
    `type`                    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身体类型',
    `measure_time`            varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '最近测量时间',
    `sleep_time_total`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '累计睡眠时长',
    `deep_sleep_total`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '累计深睡时长',
    `light_sleep_total`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '累计浅睡时长',
    `wake_time_total`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '累计清醒时长',
    `list_sleep_time`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昨晚入睡时间',
    `today_wakeup_time`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '今天起床时间',
    `step`                    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '走步步数',
    `walking_distance`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '走步距离',
    `walking_time`            varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '走步时长',
    `calorie`                 varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '卡路里',
    `mean_resting_heart_rate` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '平均静息心率',
    `resting_heart_rate_max`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '静息心率最高',
    `resting_heart_rate_min`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '静息心率最低',
    `spo2`                    decimal(4, 1)                                                NOT NULL COMMENT '血氧',
    `temperature`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '体温',
    `create_time`             datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time`             datetime                                                     NOT NULL COMMENT '最后修改时间',
    `check_warning`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `0-6step`                 varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `6-12step`                varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `12-18step`               varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `18-24step`               varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `1hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `2hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `3hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `4hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `5hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `6hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `7hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `8hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `9hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `10hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `11hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `12hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `13hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `14hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `15hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `16hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `17hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `18hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `19hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `20hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `21hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `22hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `23hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `24hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                     `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3301 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_health_daily
-- ----------------------------
DROP TABLE IF EXISTS `user_health_daily`;
CREATE TABLE `user_health_daily`
(
    `id`                      bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
    `date`                    date NULL DEFAULT NULL,
    `height`                  decimal(5, 2)                                                 NOT NULL COMMENT '身高',
    `weight`                  decimal(5, 2)                                                 NOT NULL COMMENT '体重',
    `fat_percentage`          decimal(5, 2)                                                 NOT NULL COMMENT '脂肪率',
    `BMI`                     decimal(5, 2)                                                 NOT NULL COMMENT 'BMI',
    `type`                    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '身体类型',
    `measure_time`            varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '最近测量时间',
    `sleep_time_total`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '累计睡眠时长',
    `deep_sleep_total`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '累计深睡时长',
    `light_sleep_total`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '累计浅睡时长',
    `wake_time_total`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '累计清醒时长',
    `list_sleep_time`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '昨晚入睡时间',
    `today_wakeup_time`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '今天起床时间',
    `step`                    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '走步步数',
    `walking_distance`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '走步距离',
    `walking_time`            varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '走步时长',
    `calorie`                 varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '卡路里',
    `mean_resting_heart_rate` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '平均静息心率',
    `resting_heart_rate_max`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '静息心率最高',
    `resting_heart_rate_min`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '静息心率最低',
    `spo2`                    decimal(4, 1)                                                 NOT NULL COMMENT '血氧',
    `temperature`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '体温',
    `create_time`             datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`             datetime                                                      NOT NULL COMMENT '最后修改时间',
    `0-6step`                 varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `6-12step`                varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `12-18step`               varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `18-24step`               varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `1hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `2hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `3hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `4hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `5hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `6hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `7hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `8hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `9hour_avg_heart_rate`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `10hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `11hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `12hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `13hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `14hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `15hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `16hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `17hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `18hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `19hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `20hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `21hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `22hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `23hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `24hour_avg_heart_rate`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                     `user_id`(`user_id` ASC, `date` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113051 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

SET
FOREIGN_KEY_CHECKS = 1;
