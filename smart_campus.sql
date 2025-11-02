/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL82
 Source Server Type    : MySQL
 Source Server Version : 80200
 Source Host           : localhost:3306
 Source Schema         :  smart_campus

 Target Server Type    : MySQL
 Target Server Version : 80200
 File Encoding         : 65001

 Date: 30/03/2024 21:16:35
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
    `id`              bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `img`             longblob                                                      NOT NULL COMMENT '图片',
    `drug_id`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品ID',
    `type_id`         int(0) NOT NULL COMMENT '药品类型id',
    `name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品名字',
    `price`           decimal(10, 2)                                                NOT NULL COMMENT '价格',
    `quantity`        int(0) NOT NULL COMMENT '数量',
    `specifications`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规格',
    `type`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型',
    `usage1`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用法',
    `dosage`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '使用剂量',
    `manufacturer`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生产厂家',
    `expiration_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '有效期',
    `symptoms`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '症状',
    `notes`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `create_time`     datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`     datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX             `drug_id`(`drug_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugs
-- ----------------------------
INSERT INTO `drugs`
VALUES (1, 0x31, '1', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (2, 0x31, '2', 1, '感冒灵', 20.50, 100, '10片/盒', '天帝', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 23:14:21');
INSERT INTO `drugs`
VALUES (3, 0x31, '3', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (4, 0x31, '4', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (5, 0x31, '5', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (6, 0x31, '6', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (7, 0x31, '7', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (8, 0x31, '8', 1, '感冒灵', 20.50, 100, '10片/盒', '感冒药', '口服', '一次2片，一日3次', 'XX制药', '2025-12-31',
        '感冒', '', '2024-03-25 19:47:53', '2024-03-25 19:47:53');
INSERT INTO `drugs`
VALUES (124, 0x706C616365686F6C6465725F696D6731, 'D001', 1, '药品1', 20.00, 100, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司A', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (125, 0x706C616365686F6C6465725F696D6732, 'D002', 2, '药品2', 30.00, 80, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司B', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (126, 0x706C616365686F6C6465725F696D6733, 'D003', 1, '药品3', 25.00, 120, '150mg', '类型A', '口服',
        '每次1片，每日4次', '制药公司C', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (127, 0x706C616365686F6C6465725F696D6734, 'D004', 3, '药品4', 15.00, 150, '50mg', '类型C', '口服',
        '每次1片，每日3次', '制药公司D', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (128, 0x706C616365686F6C6465725F696D6735, 'D005', 2, '药品5', 40.00, 90, '300mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司E', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (129, 0x706C616365686F6C6465725F696D6736, 'D006', 1, '药品6', 18.00, 200, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司F', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (130, 0x706C616365686F6C6465725F696D6737, 'D007', 3, '药品7', 22.00, 110, '150mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司G', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (131, 0x706C616365686F6C6465725F696D6738, 'D008', 2, '药品8', 35.00, 70, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司H', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (132, 0x706C616365686F6C6465725F696D6739, 'D009', 1, '药品9', 27.00, 180, '250mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司I', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (133, 0x706C616365686F6C6465725F696D673130, 'D010', 3, '药品10', 17.00, 130, '100mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司J', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (134, 0x706C616365686F6C6465725F696D6731, 'D0011', 1, '药品1', 20.00, 100, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司K', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (135, 0x706C616365686F6C6465725F696D6732, 'D0012', 2, '药品2', 30.00, 80, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司L', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (136, 0x706C616365686F6C6465725F696D6733, 'D0013', 1, '药品3', 25.00, 120, '150mg', '类型A', '口服',
        '每次1片，每日4次', '制药公司N', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (137, 0x706C616365686F6C6465725F696D6734, 'D0014', 3, '药品4', 15.00, 150, '50mg', '类型C', '口服',
        '每次1片，每日3次', '制药公司M', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (138, 0x706C616365686F6C6465725F696D6735, 'D0015', 2, '药品5', 40.00, 90, '300mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司O', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (139, 0x706C616365686F6C6465725F696D6736, 'D0016', 1, '药品6', 18.00, 200, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司P', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (140, 0x706C616365686F6C6465725F696D6737, 'D0017', 3, '药品7', 22.00, 110, '150mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司Q', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (141, 0x706C616365686F6C6465725F696D6738, 'D0018', 2, '药品8', 35.00, 70, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司R', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (142, 0x706C616365686F6C6465725F696D6739, 'D0019', 1, '药品9', 27.00, 180, '250mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司S', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (143, 0x706C616365686F6C6465725F696D673130, 'D0020', 3, '药品10', 17.00, 130, '100mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司T', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (144, 0x706C616365686F6C6465725F696D6731, 'D0011', 1, '药品1', 20.00, 100, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司K', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (145, 0x706C616365686F6C6465725F696D6732, 'D0012', 2, '药品2', 30.00, 80, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司L', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (146, 0x706C616365686F6C6465725F696D6733, 'D0013', 1, '药品3', 25.00, 120, '150mg', '类型A', '口服',
        '每次1片，每日4次', '制药公司N', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (147, 0x706C616365686F6C6465725F696D6734, 'D0014', 3, '药品4', 15.00, 150, '50mg', '类型C', '口服',
        '每次1片，每日3次', '制药公司M', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (148, 0x706C616365686F6C6465725F696D6735, 'D0015', 2, '药品5', 40.00, 90, '300mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司O', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (149, 0x706C616365686F6C6465725F696D6736, 'D0016', 1, '药品6', 18.00, 200, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司P', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (150, 0x706C616365686F6C6465725F696D6737, 'D0017', 3, '药品7', 22.00, 110, '150mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司Q', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (151, 0x706C616365686F6C6465725F696D6738, 'D0018', 2, '药品8', 35.00, 70, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司R', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (152, 0x706C616365686F6C6465725F696D6739, 'D0019', 1, '药品9', 27.00, 180, '250mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司S', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (153, 0x706C616365686F6C6465725F696D673130, 'D0020', 3, '药品10', 17.00, 130, '100mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司T', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (154, 0x706C616365686F6C6465725F696D6731, 'D0011', 1, '药品1', 20.00, 100, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司K', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (155, 0x706C616365686F6C6465725F696D6732, 'D0012', 2, '药品2', 30.00, 80, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司L', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (156, 0x706C616365686F6C6465725F696D6733, 'D0013', 1, '药品3', 25.00, 120, '150mg', '类型A', '口服',
        '每次1片，每日4次', '制药公司N', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (157, 0x706C616365686F6C6465725F696D6734, 'D0014', 3, '药品4', 15.00, 150, '50mg', '类型C', '口服',
        '每次1片，每日3次', '制药公司M', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (158, 0x706C616365686F6C6465725F696D6735, 'D0015', 2, '药品5', 40.00, 90, '300mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司O', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (159, 0x706C616365686F6C6465725F696D6736, 'D0016', 1, '药品6', 18.00, 200, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司P', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (160, 0x706C616365686F6C6465725F696D6737, 'D0017', 3, '药品7', 22.00, 110, '150mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司Q', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (161, 0x706C616365686F6C6465725F696D6738, 'D0018', 2, '药品8', 35.00, 70, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司R', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (162, 0x706C616365686F6C6465725F696D6739, 'D0019', 1, '药品9', 27.00, 180, '250mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司S', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (163, 0x706C616365686F6C6465725F696D673130, 'D0020', 3, '药品10', 17.00, 130, '100mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司T', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (164, 0x706C616365686F6C6465725F696D6731, 'D0011', 1, '药品1', 20.00, 100, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司K', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (165, 0x706C616365686F6C6465725F696D6732, 'D0012', 2, '药品2', 30.00, 80, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司L', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (166, 0x706C616365686F6C6465725F696D6733, 'D0013', 1, '药品3', 25.00, 120, '150mg', '类型A', '口服',
        '每次1片，每日4次', '制药公司N', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (167, 0x706C616365686F6C6465725F696D6734, 'D0014', 3, '药品4', 15.00, 150, '50mg', '类型C', '口服',
        '每次1片，每日3次', '制药公司M', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (168, 0x706C616365686F6C6465725F696D6735, 'D0015', 2, '药品5', 40.00, 90, '300mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司O', '2024-12-31', '头痛', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (169, 0x706C616365686F6C6465725F696D6736, 'D0016', 1, '药品6', 18.00, 200, '100mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司P', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (170, 0x706C616365686F6C6465725F696D6737, 'D0017', 3, '药品7', 22.00, 110, '150mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司Q', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (171, 0x706C616365686F6C6465725F696D6738, 'D0018', 2, '药品8', 35.00, 70, '200mg', '类型B', '口服',
        '每次2片，每日2次', '制药公司R', '2024-12-31', '发烧', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (172, 0x706C616365686F6C6465725F696D6739, 'D0019', 1, '药品9', 27.00, 180, '250mg', '类型A', '口服',
        '每次1片，每日3次', '制药公司S', '2024-12-31', '咳嗽', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');
INSERT INTO `drugs`
VALUES (173, 0x706C616365686F6C6465725F696D673130, 'D0020', 3, '药品10', 17.00, 130, '100mg', '类型C', '口服',
        '每次1片，每日4次', '制药公司T', '2024-12-31', '感冒', '无', '2024-03-30 08:00:00', '2024-03-30 08:00:00');

-- ----------------------------
-- Table structure for drugs_hospitals_relation
-- ----------------------------
DROP TABLE IF EXISTS `drugs_hospitals_relation`;
CREATE TABLE `drugs_hospitals_relation`
(
    `id`            bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `relation_type` int(0) NOT NULL COMMENT '关系类型',
    `type_id`       int(0) NOT NULL COMMENT '关联id',
    `type_name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联名字',
    `create_time`   datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`   datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugs_hospitals_relation
-- ----------------------------
INSERT INTO `drugs_hospitals_relation`
VALUES (3, 1, 3, '天帝灵', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (4, 2, 1, '1级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (5, 2, 2, '2级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (6, 2, 3, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (7, 2, 4, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (8, 2, 5, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (9, 2, 6, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (10, 2, 7, '十级甲等', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (11, 3, 1, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (12, 3, 2, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (13, 3, 3, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (14, 3, 4, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (15, 3, 5, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (16, 3, 6, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (17, 3, 7, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (18, 3, 8, '综合专科', '2024-03-23 23:30:06', '2024-03-23 23:30:06');
INSERT INTO `drugs_hospitals_relation`
VALUES (19, 1, 1, '天帝', '2024-03-24 23:03:24', '2024-03-24 23:03:24');
INSERT INTO `drugs_hospitals_relation`
VALUES (70, 1, 2, '假药A', '2024-03-25 10:15:00', '2024-03-25 10:15:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (71, 1, 3, '假药B', '2024-03-25 11:20:00', '2024-03-25 11:20:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (72, 1, 4, '假药C', '2024-03-25 12:30:00', '2024-03-25 12:30:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (73, 2, 8, '五级甲等', '2024-03-25 09:45:00', '2024-03-25 09:45:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (74, 2, 9, '六级甲等', '2024-03-25 13:50:00', '2024-03-25 13:50:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (75, 2, 10, '七级甲等', '2024-03-25 14:55:00', '2024-03-25 14:55:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (76, 3, 9, '心脏科', '2024-03-25 10:30:00', '2024-03-25 10:30:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (77, 3, 10, '神经科', '2024-03-25 11:40:00', '2024-03-25 11:40:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (78, 3, 11, '内科', '2024-03-25 12:50:00', '2024-03-25 12:50:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (79, 3, 12, '外科', '2024-03-25 15:00:00', '2024-03-25 15:00:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (80, 1, 5, '假药D', '2024-03-26 09:30:00', '2024-03-26 09:30:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (81, 1, 6, '假药E', '2024-03-26 10:45:00', '2024-03-26 10:45:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (82, 1, 7, '假药F', '2024-03-26 11:55:00', '2024-03-26 11:55:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (83, 2, 11, '八级甲等', '2024-03-26 08:20:00', '2024-03-26 08:20:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (84, 2, 12, '九级甲等', '2024-03-26 12:10:00', '2024-03-26 12:10:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (85, 2, 13, '十级甲等', '2024-03-26 13:25:00', '2024-03-26 13:25:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (86, 3, 13, '耳鼻喉科', '2024-03-26 09:15:00', '2024-03-26 09:15:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (87, 3, 14, '骨科', '2024-03-26 10:20:00', '2024-03-26 10:20:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (88, 3, 15, '儿科', '2024-03-26 11:35:00', '2024-03-26 11:35:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (89, 3, 16, '眼科', '2024-03-26 14:40:00', '2024-03-26 14:40:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (90, 1, 8, '假药G', '2024-03-27 09:00:00', '2024-03-27 09:00:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (91, 1, 9, '假药H', '2024-03-27 10:15:00', '2024-03-27 10:15:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (92, 1, 10, '假药I', '2024-03-27 11:30:00', '2024-03-27 11:30:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (93, 2, 14, '十一级甲等', '2024-03-27 08:45:00', '2024-03-27 08:45:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (94, 2, 15, '十二级甲等', '2024-03-27 12:20:00', '2024-03-27 12:20:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (95, 2, 16, '十三级甲等', '2024-03-27 13:40:00', '2024-03-27 13:40:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (96, 3, 17, '口腔科', '2024-03-27 09:50:00', '2024-03-27 09:50:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (97, 3, 18, '皮肤科', '2024-03-27 10:55:00', '2024-03-27 10:55:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (98, 3, 19, '肿瘤科', '2024-03-27 12:05:00', '2024-03-27 12:05:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (99, 3, 20, '康复科', '2024-03-27 14:10:00', '2024-03-27 14:10:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (100, 1, 11, '假药J', '2024-03-28 09:10:00', '2024-03-28 09:10:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (101, 1, 12, '假药K', '2024-03-28 10:25:00', '2024-03-28 10:25:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (102, 1, 13, '假药L', '2024-03-28 11:40:00', '2024-03-28 11:40:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (103, 2, 17, '十四级甲等', '2024-03-28 08:30:00', '2024-03-28 08:30:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (104, 2, 18, '十五级甲等', '2024-03-28 12:15:00', '2024-03-28 12:15:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (105, 2, 19, '十六级甲等', '2024-03-28 13:35:00', '2024-03-28 13:35:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (106, 3, 21, '内分泌科', '2024-03-28 09:45:00', '2024-03-28 09:45:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (107, 3, 22, '神经科', '2024-03-28 10:50:00', '2024-03-28 10:50:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (108, 3, 23, '血液科', '2024-03-28 12:00:00', '2024-03-28 12:00:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (109, 3, 24, '感染科', '2024-03-28 14:05:00', '2024-03-28 14:05:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (110, 1, 14, '假药M', '2024-03-29 09:20:00', '2024-03-29 09:20:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (111, 1, 15, '假药N', '2024-03-29 10:35:00', '2024-03-29 10:35:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (112, 1, 16, '假药O', '2024-03-29 11:50:00', '2024-03-29 11:50:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (113, 2, 20, '十七级甲等', '2024-03-29 08:15:00', '2024-03-29 08:15:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (114, 2, 21, '十八级甲等', '2024-03-29 12:10:00', '2024-03-29 12:10:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (115, 2, 22, '十九级甲等', '2024-03-29 13:30:00', '2024-03-29 13:30:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (116, 3, 25, '风湿科', '2024-03-29 09:40:00', '2024-03-29 09:40:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (117, 3, 26, '胃肠科', '2024-03-29 10:45:00', '2024-03-29 10:45:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (118, 3, 27, '内科', '2024-03-29 12:55:00', '2024-03-29 12:55:00');
INSERT INTO `drugs_hospitals_relation`
VALUES (119, 3, 28, '外科', '2024-03-29 14:00:00', '2024-03-29 14:00:00');

-- ----------------------------
-- Table structure for health_warning_notifications
-- ----------------------------
DROP TABLE IF EXISTS `health_warning_notifications`;
CREATE TABLE `health_warning_notifications`
(
    `id`                 bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `notification_id`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `user_id`            varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `type`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预警类型',
    `level`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预警等级',
    `time`               datetime(0) NOT NULL COMMENT '预警发出的时间',
    `reading_value`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '测量值',
    `recommended_action` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '建议的行动或措施',
    `note`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注',
    `create_time`        datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`        datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                `notification_id`(`notification_id`) USING BTREE,
    INDEX                `time`(`time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_warning_notifications
-- ----------------------------
INSERT INTO `health_warning_notifications`
VALUES (1, '1', '30005', '体重过高', '高', '2024-03-20 22:42:20', '55kg', '建议增加体育活动', '', '2024-03-20 22:42:20',
        '2024-03-20 22:42:20');
INSERT INTO `health_warning_notifications`
VALUES (2, '2', '20006', '心率过快', '低', '2024-03-20 22:42:20', '55kg', '建议增加休息时间', '', '2024-03-20 22:42:20',
        '2024-03-20 22:42:20');
INSERT INTO `health_warning_notifications`
VALUES (3, '3', '30003', '睡眠时间过低', '高', '2024-03-20 22:42:20', '55kg', '建议增加睡眠时间', '',
        '2024-03-20 22:42:20', '2024-03-20 22:42:20');
INSERT INTO `health_warning_notifications`
VALUES (4, '4', '40008', '步数过低', '高', '2024-03-20 22:42:20', '55kg', '建议增加体育活动', '', '2024-03-20 22:42:20',
        '2024-03-20 22:42:20');
INSERT INTO `health_warning_notifications`
VALUES (34, '5', '20003', '体重过低', '低', '2024-03-21 08:15:00', '45kg', '建议增加营养摄入', '',
        '2024-03-21 08:15:00', '2024-03-21 08:15:00');
INSERT INTO `health_warning_notifications`
VALUES (35, '6', '30002', '心率异常', '高', '2024-03-21 09:30:00', '110次/分钟', '建议减少压力', '',
        '2024-03-21 09:30:00', '2024-03-21 09:30:00');
INSERT INTO `health_warning_notifications`
VALUES (36, '7', '40005', '血压偏低', '低', '2024-03-21 10:45:00', '90/60 mmHg', '建议增加盐分摄入', '',
        '2024-03-21 10:45:00', '2024-03-21 10:45:00');
INSERT INTO `health_warning_notifications`
VALUES (37, '8', '20009', '血糖异常', '高', '2024-03-21 12:00:00', '8.5 mmol/L', '建议减少糖类摄入', '',
        '2024-03-21 12:00:00', '2024-03-21 12:00:00');
INSERT INTO `health_warning_notifications`
VALUES (38, '9', '30006', '睡眠不足', '高', '2024-03-21 13:15:00', '6小时', '建议规律作息', '', '2024-03-21 13:15:00',
        '2024-03-21 13:15:00');
INSERT INTO `health_warning_notifications`
VALUES (39, '10', '40003', '缺乏运动', '低', '2024-03-21 14:30:00', '0步', '建议增加日常活动', '',
        '2024-03-21 14:30:00', '2024-03-21 14:30:00');
INSERT INTO `health_warning_notifications`
VALUES (40, '11', '20007', '饮水不足', '低', '2024-03-21 15:45:00', '1000ml', '建议增加水分摄入', '',
        '2024-03-21 15:45:00', '2024-03-21 15:45:00');
INSERT INTO `health_warning_notifications`
VALUES (41, '12', '30004', '缺乏蔬菜水果', '低', '2024-03-21 17:00:00', '一份', '建议增加膳食纤维摄入', '',
        '2024-03-21 17:00:00', '2024-03-21 17:00:00');
INSERT INTO `health_warning_notifications`
VALUES (42, '13', '40001', '饮食不均衡', '低', '2024-03-21 18:15:00', '高热量', '建议均衡饮食', '',
        '2024-03-21 18:15:00', '2024-03-21 18:15:00');
INSERT INTO `health_warning_notifications`
VALUES (43, '14', '20008', '缺乏维生素', '低', '2024-03-21 19:30:00', '维生素C', '建议增加新鲜水果摄入', '',
        '2024-03-21 19:30:00', '2024-03-21 19:30:00');
INSERT INTO `health_warning_notifications`
VALUES (54, '15', '20003', '体重过低', '低', '2024-03-21 08:15:00', '45kg', '建议增加营养摄入', '',
        '2024-03-21 08:15:00', '2024-03-21 08:15:00');
INSERT INTO `health_warning_notifications`
VALUES (55, '16', '30002', '心率异常', '高', '2024-03-21 09:30:00', '110次/分钟', '建议减少压力', '',
        '2024-03-21 09:30:00', '2024-03-21 09:30:00');
INSERT INTO `health_warning_notifications`
VALUES (56, '17', '40005', '血压偏低', '低', '2024-03-21 10:45:00', '90/60 mmHg', '建议增加盐分摄入', '',
        '2024-03-21 10:45:00', '2024-03-21 10:45:00');
INSERT INTO `health_warning_notifications`
VALUES (57, '18', '20009', '血糖异常', '高', '2024-03-21 12:00:00', '8.5 mmol/L', '建议减少糖类摄入', '',
        '2024-03-21 12:00:00', '2024-03-21 12:00:00');
INSERT INTO `health_warning_notifications`
VALUES (58, '19', '30006', '睡眠不足', '高', '2024-03-21 13:15:00', '6小时', '建议规律作息', '', '2024-03-21 13:15:00',
        '2024-03-21 13:15:00');
INSERT INTO `health_warning_notifications`
VALUES (59, '20', '40003', '缺乏运动', '低', '2024-03-21 14:30:00', '0步', '建议增加日常活动', '',
        '2024-03-21 14:30:00', '2024-03-21 14:30:00');
INSERT INTO `health_warning_notifications`
VALUES (60, '21', '20007', '饮水不足', '低', '2024-03-21 15:45:00', '1000ml', '建议增加水分摄入', '',
        '2024-03-21 15:45:00', '2024-03-21 15:45:00');
INSERT INTO `health_warning_notifications`
VALUES (61, '22', '30004', '缺乏蔬菜水果', '低', '2024-03-21 17:00:00', '一份', '建议增加膳食纤维摄入', '',
        '2024-03-21 17:00:00', '2024-03-21 17:00:00');
INSERT INTO `health_warning_notifications`
VALUES (62, '23', '40001', '饮食不均衡', '低', '2024-03-21 18:15:00', '高热量', '建议均衡饮食', '',
        '2024-03-21 18:15:00', '2024-03-21 18:15:00');
INSERT INTO `health_warning_notifications`
VALUES (63, '24', '20008', '缺乏维生素', '低', '2024-03-21 19:30:00', '维生素C', '建议增加新鲜水果摄入', '',
        '2024-03-21 19:30:00', '2024-03-21 19:30:00');
INSERT INTO `health_warning_notifications`
VALUES (64, '25', '20003', '体重过低', '低', '2024-03-21 08:15:00', '45kg', '建议增加营养摄入', '',
        '2024-03-21 08:15:00', '2024-03-21 08:15:00');
INSERT INTO `health_warning_notifications`
VALUES (65, '26', '30002', '心率异常', '高', '2024-03-21 09:30:00', '110次/分钟', '建议减少压力', '',
        '2024-03-21 09:30:00', '2024-03-21 09:30:00');
INSERT INTO `health_warning_notifications`
VALUES (66, '27', '40005', '血压偏低', '低', '2024-03-21 10:45:00', '90/60 mmHg', '建议增加盐分摄入', '',
        '2024-03-21 10:45:00', '2024-03-21 10:45:00');
INSERT INTO `health_warning_notifications`
VALUES (67, '28', '20009', '血糖异常', '高', '2024-03-21 12:00:00', '8.5 mmol/L', '建议减少糖类摄入', '',
        '2024-03-21 12:00:00', '2024-03-21 12:00:00');
INSERT INTO `health_warning_notifications`
VALUES (68, '29', '30006', '睡眠不足', '高', '2024-03-21 13:15:00', '6小时', '建议规律作息', '', '2024-03-21 13:15:00',
        '2024-03-21 13:15:00');
INSERT INTO `health_warning_notifications`
VALUES (69, '30', '40003', '缺乏运动', '低', '2024-03-21 14:30:00', '0步', '建议增加日常活动', '',
        '2024-03-21 14:30:00', '2024-03-21 14:30:00');
INSERT INTO `health_warning_notifications`
VALUES (70, '31', '20007', '饮水不足', '低', '2024-03-21 15:45:00', '1000ml', '建议增加水分摄入', '',
        '2024-03-21 15:45:00', '2024-03-21 15:45:00');
INSERT INTO `health_warning_notifications`
VALUES (71, '32', '30004', '缺乏蔬菜水果', '低', '2024-03-21 17:00:00', '一份', '建议增加膳食纤维摄入', '',
        '2024-03-21 17:00:00', '2024-03-21 17:00:00');
INSERT INTO `health_warning_notifications`
VALUES (72, '33', '40001', '饮食不均衡', '低', '2024-03-21 18:15:00', '高热量', '建议均衡饮食', '',
        '2024-03-21 18:15:00', '2024-03-21 18:15:00');
INSERT INTO `health_warning_notifications`
VALUES (73, '34', '20008', '缺乏维生素', '低', '2024-03-21 19:30:00', '维生素C', '建议增加新鲜水果摄入', '',
        '2024-03-21 19:30:00', '2024-03-21 19:30:00');
INSERT INTO `health_warning_notifications`
VALUES (74, '35', '20003', '体重过低', '低', '2024-03-21 08:15:00', '45kg', '建议增加营养摄入', '',
        '2024-03-21 08:15:00', '2024-03-21 08:15:00');
INSERT INTO `health_warning_notifications`
VALUES (75, '36', '30002', '心率异常', '高', '2024-03-21 09:30:00', '110次/分钟', '建议减少压力', '',
        '2024-03-21 09:30:00', '2024-03-21 09:30:00');
INSERT INTO `health_warning_notifications`
VALUES (76, '37', '40005', '血压偏低', '低', '2024-03-21 10:45:00', '90/60 mmHg', '建议增加盐分摄入', '',
        '2024-03-21 10:45:00', '2024-03-21 10:45:00');
INSERT INTO `health_warning_notifications`
VALUES (77, '38', '20009', '血糖异常', '高', '2024-03-21 12:00:00', '8.5 mmol/L', '建议减少糖类摄入', '',
        '2024-03-21 12:00:00', '2024-03-21 12:00:00');
INSERT INTO `health_warning_notifications`
VALUES (78, '39', '30006', '睡眠不足', '高', '2024-03-21 13:15:00', '6小时', '建议规律作息', '', '2024-03-21 13:15:00',
        '2024-03-21 13:15:00');
INSERT INTO `health_warning_notifications`
VALUES (79, '40', '40003', '缺乏运动', '低', '2024-03-21 14:30:00', '0步', '建议增加日常活动', '',
        '2024-03-21 14:30:00', '2024-03-21 14:30:00');
INSERT INTO `health_warning_notifications`
VALUES (80, '41', '20007', '饮水不足', '低', '2024-03-21 15:45:00', '1000ml', '建议增加水分摄入', '',
        '2024-03-21 15:45:00', '2024-03-21 15:45:00');
INSERT INTO `health_warning_notifications`
VALUES (81, '42', '30004', '缺乏蔬菜水果', '低', '2024-03-21 17:00:00', '一份', '建议增加膳食纤维摄入', '',
        '2024-03-21 17:00:00', '2024-03-21 17:00:00');
INSERT INTO `health_warning_notifications`
VALUES (82, '43', '40001', '饮食不均衡', '低', '2024-03-21 18:15:00', '高热量', '建议均衡饮食', '',
        '2024-03-21 18:15:00', '2024-03-21 18:15:00');
INSERT INTO `health_warning_notifications`
VALUES (83, '44', '20008', '缺乏维生素', '低', '2024-03-21 19:30:00', '维生素C', '建议增加新鲜水果摄入', '',
        '2024-03-21 19:30:00', '2024-03-21 19:30:00');
INSERT INTO `health_warning_notifications`
VALUES (84, '45', '20003', '体重过低', '低', '2024-03-21 08:15:00', '45kg', '建议增加营养摄入', '',
        '2024-03-21 08:15:00', '2024-03-21 08:15:00');
INSERT INTO `health_warning_notifications`
VALUES (85, '46', '30002', '心率异常', '高', '2024-03-21 09:30:00', '110次/分钟', '建议减少压力', '',
        '2024-03-21 09:30:00', '2024-03-21 09:30:00');
INSERT INTO `health_warning_notifications`
VALUES (86, '47', '40005', '血压偏低', '低', '2024-03-21 10:45:00', '90/60 mmHg', '建议增加盐分摄入', '',
        '2024-03-21 10:45:00', '2024-03-21 10:45:00');
INSERT INTO `health_warning_notifications`
VALUES (87, '48', '20009', '血糖异常', '高', '2024-03-21 12:00:00', '8.5 mmol/L', '建议减少糖类摄入', '',
        '2024-03-21 12:00:00', '2024-03-21 12:00:00');
INSERT INTO `health_warning_notifications`
VALUES (88, '49', '30006', '睡眠不足', '高', '2024-03-21 13:15:00', '6小时', '建议规律作息', '', '2024-03-21 13:15:00',
        '2024-03-21 13:15:00');
INSERT INTO `health_warning_notifications`
VALUES (89, '50', '40003', '缺乏运动', '低', '2024-03-21 14:30:00', '0步', '建议增加日常活动', '',
        '2024-03-21 14:30:00', '2024-03-21 14:30:00');
INSERT INTO `health_warning_notifications`
VALUES (90, '51', '20007', '饮水不足', '低', '2024-03-21 15:45:00', '1000ml', '建议增加水分摄入', '',
        '2024-03-21 15:45:00', '2024-03-21 15:45:00');
INSERT INTO `health_warning_notifications`
VALUES (91, '52', '30004', '缺乏蔬菜水果', '低', '2024-03-21 17:00:00', '一份', '建议增加膳食纤维摄入', '',
        '2024-03-21 17:00:00', '2024-03-21 17:00:00');
INSERT INTO `health_warning_notifications`
VALUES (92, '53', '40001', '饮食不均衡', '低', '2024-03-21 18:15:00', '高热量', '建议均衡饮食', '',
        '2024-03-21 18:15:00', '2024-03-21 18:15:00');
INSERT INTO `health_warning_notifications`
VALUES (93, '54', '20008', '缺乏维生素', '低', '2024-03-21 19:30:00', '维生素C', '建议增加新鲜水果摄入', '',
        '2024-03-21 19:30:00', '2024-03-21 19:30:00');

-- ----------------------------
-- Table structure for hospitals
-- ----------------------------
DROP TABLE IF EXISTS `hospitals`;
CREATE TABLE `hospitals`
(
    `id`                bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `img`               longblob                                                      NOT NULL COMMENT '图片',
    `hospital_id`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医院ID',
    `name`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医院名称',
    `address`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
    `phone`             varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '联系电话',
    `grade`             int(0) NOT NULL COMMENT '医院等级',
    `type`              int(0) NOT NULL COMMENT '类型',
    `medical_insurance` int(0) NOT NULL COMMENT '医保情况，1支持，0不支持',
    `note`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `create_time`       datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`       datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX               `hospital_id`(`hospital_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospitals
-- ----------------------------
INSERT INTO `hospitals`
VALUES (1, 0x31, '1', '人民医院', '市中心路1号', '12345678910', 1, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (3, 0x31, '3', '人民医院', '市中心路1号', '12345678910', 3, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (4, 0x31, '4', '人民医院', '市中心路1号', '12345678910', 3, 2, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (5, 0x31, '5', '人民医院', '市中心路1号', '12345678910', 1, 3, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (6, 0x31, '6', '人民医院', '市中心路1号', '12345678910', 2, 4, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (7, 0x31, '7', '人民医院', '市中心路1号', '12345678910', 2, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (8, 0x31, '8', '人民医院', '市中心路1号', '12345678910', 2, 2, 1, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (9, 0x31, '9', '人民医院', '市中心路1号', '12345678910', 2, 2, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (10, 0x31, '10', '人民医院', '市中心路1号', '12345678910', 3, 3, 0, '', '2024-03-23 23:15:30',
        '2024-03-23 23:15:30');
INSERT INTO `hospitals`
VALUES (11, 0x31, '11', '市立医院', '建设路2号', '13579246810', 2, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (12, 0x31, '12', '中医院', '文化街3号', '15975324680', 1, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (13, 0x31, '13', '协和医院', '和平路4号', '13859762480', 3, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (14, 0x31, '14', '妇幼保健院', '幸福街5号', '15263748950', 1, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (15, 0x31, '15', '胸科医院', '健康路6号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (16, 0x31, '16', '眼科医院', '学府路7号', '13958624703', 3, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (17, 0x31, '17', '第一医院', '民主街8号', '13659874260', 1, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (18, 0x31, '18', '华西医院', '建设路9号', '15036987425', 2, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (19, 0x31, '19', '解放军总医院', '解放路10号', '13847529684', 3, 2, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (20, 0x31, '20', '肿瘤医院', '健康路11号', '18745296301', 2, 4, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (21, 0x31, '21', '口腔医院', '民主路12号', '13958624703', 1, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (22, 0x31, '22', '儿童医院', '幸福路13号', '13659874260', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (23, 0x31, '23', '心理医院', '建设路14号', '15036987425', 3, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (24, 0x31, '24', '皮肤医院', '解放路15号', '13847529684', 1, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (25, 0x31, '25', '骨科医院', '健康路16号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (26, 0x31, '26', '康复医院', '民主路17号', '13958624703', 3, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (27, 0x31, '27', '市立医院', '建设路2号', '13579246810', 2, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (28, 0x31, '28', '中医院', '文化街3号', '15975324680', 1, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (29, 0x31, '29', '协和医院', '和平路4号', '13859762480', 3, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (30, 0x31, '30', '妇幼保健院', '幸福街5号', '15263748950', 1, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (31, 0x31, '31', '胸科医院', '健康路6号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (32, 0x31, '32', '眼科医院', '学府路7号', '13958624703', 3, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (33, 0x31, '33', '第一医院', '民主街8号', '13659874260', 1, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (34, 0x31, '34', '华西医院', '建设路9号', '15036987425', 2, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (35, 0x31, '35', '解放军总医院', '解放路10号', '13847529684', 3, 2, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (36, 0x31, '36', '肿瘤医院', '健康路11号', '18745296301', 2, 4, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (37, 0x31, '37', '口腔医院', '民主路12号', '13958624703', 1, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (38, 0x31, '38', '儿童医院', '幸福路13号', '13659874260', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (39, 0x31, '39', '心理医院', '建设路14号', '15036987425', 3, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (40, 0x31, '40', '皮肤医院', '解放路15号', '13847529684', 1, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (41, 0x31, '41', '骨科医院', '健康路16号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (42, 0x31, '42', '康复医院', '民主路17号', '13958624703', 3, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (43, 0x31, '43', '市立医院', '建设路2号', '13579246810', 2, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (44, 0x31, '44', '中医院', '文化街3号', '15975324680', 1, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (45, 0x31, '45', '协和医院', '和平路4号', '13859762480', 3, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (46, 0x31, '46', '妇幼保健院', '幸福街5号', '15263748950', 1, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (47, 0x31, '47', '胸科医院', '健康路6号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (48, 0x31, '48', '眼科医院', '学府路7号', '13958624703', 3, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (49, 0x31, '49', '第一医院', '民主街8号', '13659874260', 1, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (50, 0x31, '50', '华西医院', '建设路9号', '15036987425', 2, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (51, 0x31, '51', '解放军总医院', '解放路10号', '13847529684', 3, 2, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (52, 0x31, '52', '肿瘤医院', '健康路11号', '18745296301', 2, 4, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (53, 0x31, '53', '口腔医院', '民主路12号', '13958624703', 1, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (54, 0x31, '54', '儿童医院', '幸福路13号', '13659874260', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (55, 0x31, '55', '心理医院', '建设路14号', '15036987425', 3, 3, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (56, 0x31, '56', '皮肤医院', '解放路15号', '13847529684', 1, 4, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (57, 0x31, '57', '骨科医院', '健康路16号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (58, 0x31, '58', '康复医院', '民主路17号', '13958624703', 3, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (59, 0x31, '59', '骨科医院', '健康路16号', '18745296301', 2, 2, 1, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');
INSERT INTO `hospitals`
VALUES (60, 0x31, '60', '康复医院', '民主路17号', '13958624703', 3, 3, 0, NULL, '2024-03-30 08:41:42',
        '2024-03-30 08:41:42');

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics`
(
    `id`           bigint(0) NOT NULL AUTO_INCREMENT,
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
    `status`       int(0) NOT NULL COMMENT '账号状态',
    `create_time`  datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`  datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `logistics_id`(`logistics_id`) USING BTREE,
    INDEX          `post`(`post`) USING BTREE,
    INDEX          `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics`
VALUES (1, 0x31, '后勤', 'dev103', '40001', '保安', '王二狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (4, 0x31, '后勤', 'dev133', '40004', '保安', '校二狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (5, 0x32, '后勤', 'dev133', '40005', '保安', '校二', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (6, 0x31, '后勤', 'dev312', '40006', '保洁', '王四狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (7, 0x31, '后勤', 'dev233', '40007', '饭堂', '王六狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (8, 0x31, '后勤', 'dev436', '40008', '保洁', '王坝狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (9, 0x31, '后勤', 'dev241', '40009', '保安', '王尔狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (10, 0x31, '后勤', 'dev361', '40010', '保洁', '王嗄狗', '1980-06-06', 'password', '12345678903', '男', 1,
        '2024-03-23 23:09:56', '2024-03-23 23:09:56');
INSERT INTO `logistics`
VALUES (11, 0x31, '后勤', 'dev103', '40010', '保安', '王二狗', '1980-06-06', '12131', '12345678903', '男', 1,
        '2024-03-26 22:47:54', '2024-03-26 22:47:54');
INSERT INTO `logistics`
VALUES (12, 0x31, '后勤', 'dev789', '40011', '保洁', '张三', '1990-05-15', 'fakepassword', '13987654321', '男', 1,
        '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `logistics`
VALUES (13, 0x31, '后勤', 'dev123', '40012', '保安', '李四', '1985-07-20', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 10:15:00', '2024-03-30 10:15:00');
INSERT INTO `logistics`
VALUES (14, 0x32, '后勤', 'dev456', '40013', '保洁', '王五', '1992-09-10', 'fakepassword', '13899998888', '女', 1,
        '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `logistics`
VALUES (15, 0x31, '后勤', 'dev789', '40014', '保安', '赵六', '1988-03-25', 'fakepassword', '13777776666', '男', 1,
        '2024-03-30 10:45:00', '2024-03-30 10:45:00');
INSERT INTO `logistics`
VALUES (16, 0x31, '后勤', 'dev123', '40015', '饭堂', '钱七', '1995-12-05', 'fakepassword', '13511112222', '女', 1,
        '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `logistics`
VALUES (17, 0x31, '后勤', 'dev789', '40016', '保安', '孙八', '1983-10-18', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 11:15:00', '2024-03-30 11:15:00');
INSERT INTO `logistics`
VALUES (18, 0x32, '后勤', 'dev123', '40017', '保洁', '周九', '1998-08-30', 'fakepassword', '13222221111', '女', 1,
        '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `logistics`
VALUES (19, 0x31, '后勤', 'dev456', '40018', '饭堂', '吴十', '1993-06-12', 'fakepassword', '13133334444', '男', 1,
        '2024-03-30 11:45:00', '2024-03-30 11:45:00');
INSERT INTO `logistics`
VALUES (20, 0x31, '后勤', 'dev789', '40019', '保安', '郑十一', '1987-04-03', 'fakepassword', '13000001111', '男', 1,
        '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `logistics`
VALUES (21, 0x31, '后勤', 'dev123', '40020', '饭堂', '王十二', '1991-01-28', 'fakepassword', '13987654321', '女', 1,
        '2024-03-30 12:15:00', '2024-03-30 12:15:00');
INSERT INTO `logistics`
VALUES (22, 0x32, '后勤', 'dev456', '40021', '保洁', '李十三', '1994-11-14', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `logistics`
VALUES (23, 0x31, '后勤', 'dev789', '40022', '保安', '张十四', '1989-08-08', 'fakepassword', '13899998888', '男', 1,
        '2024-03-30 12:45:00', '2024-03-30 12:45:00');
INSERT INTO `logistics`
VALUES (24, 0x31, '后勤', 'dev123', '40023', '饭堂', '李十五', '1996-02-22', 'fakepassword', '13777776666', '女', 1,
        '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `logistics`
VALUES (25, 0x32, '后勤', 'dev456', '40024', '保洁', '王十六', '1990-05-01', 'fakepassword', '13511112222', '男', 1,
        '2024-03-30 13:15:00', '2024-03-30 13:15:00');
INSERT INTO `logistics`
VALUES (26, 0x31, '后勤', 'dev789', '40025', '保安', '赵十七', '1986-09-16', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `logistics`
VALUES (27, 0x31, '后勤', 'dev789', '40011', '保洁', '张三', '1990-05-15', 'fakepassword', '13987654321', '男', 1,
        '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `logistics`
VALUES (28, 0x31, '后勤', 'dev123', '40012', '保安', '李四', '1985-07-20', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 10:15:00', '2024-03-30 10:15:00');
INSERT INTO `logistics`
VALUES (29, 0x32, '后勤', 'dev456', '40013', '保洁', '王五', '1992-09-10', 'fakepassword', '13899998888', '女', 1,
        '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `logistics`
VALUES (30, 0x31, '后勤', 'dev789', '40014', '保安', '赵六', '1988-03-25', 'fakepassword', '13777776666', '男', 1,
        '2024-03-30 10:45:00', '2024-03-30 10:45:00');
INSERT INTO `logistics`
VALUES (31, 0x31, '后勤', 'dev123', '40015', '饭堂', '钱七', '1995-12-05', 'fakepassword', '13511112222', '女', 1,
        '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `logistics`
VALUES (32, 0x31, '后勤', 'dev789', '40016', '保安', '孙八', '1983-10-18', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 11:15:00', '2024-03-30 11:15:00');
INSERT INTO `logistics`
VALUES (33, 0x32, '后勤', 'dev123', '40017', '保洁', '周九', '1998-08-30', 'fakepassword', '13222221111', '女', 1,
        '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `logistics`
VALUES (34, 0x31, '后勤', 'dev456', '40018', '饭堂', '吴十', '1993-06-12', 'fakepassword', '13133334444', '男', 1,
        '2024-03-30 11:45:00', '2024-03-30 11:45:00');
INSERT INTO `logistics`
VALUES (35, 0x31, '后勤', 'dev789', '40019', '保安', '郑十一', '1987-04-03', 'fakepassword', '13000001111', '男', 1,
        '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `logistics`
VALUES (36, 0x31, '后勤', 'dev123', '40020', '饭堂', '王十二', '1991-01-28', 'fakepassword', '13987654321', '女', 1,
        '2024-03-30 12:15:00', '2024-03-30 12:15:00');
INSERT INTO `logistics`
VALUES (37, 0x32, '后勤', 'dev456', '40021', '保洁', '李十三', '1994-11-14', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `logistics`
VALUES (38, 0x31, '后勤', 'dev789', '40022', '保安', '张十四', '1989-08-08', 'fakepassword', '13899998888', '男', 1,
        '2024-03-30 12:45:00', '2024-03-30 12:45:00');
INSERT INTO `logistics`
VALUES (39, 0x31, '后勤', 'dev123', '40023', '饭堂', '李十五', '1996-02-22', 'fakepassword', '13777776666', '女', 1,
        '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `logistics`
VALUES (40, 0x32, '后勤', 'dev456', '40024', '保洁', '王十六', '1990-05-01', 'fakepassword', '13511112222', '男', 1,
        '2024-03-30 13:15:00', '2024-03-30 13:15:00');
INSERT INTO `logistics`
VALUES (41, 0x31, '后勤', 'dev789', '40025', '保安', '赵十七', '1986-09-16', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `logistics`
VALUES (42, 0x31, '后勤', 'dev789', '40011', '保洁', '张三', '1990-05-15', 'fakepassword', '13987654321', '男', 1,
        '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `logistics`
VALUES (43, 0x31, '后勤', 'dev123', '40012', '保安', '李四', '1985-07-20', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 10:15:00', '2024-03-30 10:15:00');
INSERT INTO `logistics`
VALUES (44, 0x32, '后勤', 'dev456', '40013', '保洁', '王五', '1992-09-10', 'fakepassword', '13899998888', '女', 1,
        '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `logistics`
VALUES (45, 0x31, '后勤', 'dev789', '40014', '保安', '赵六', '1988-03-25', 'fakepassword', '13777776666', '男', 1,
        '2024-03-30 10:45:00', '2024-03-30 10:45:00');
INSERT INTO `logistics`
VALUES (46, 0x31, '后勤', 'dev123', '40015', '饭堂', '钱七', '1995-12-05', 'fakepassword', '13511112222', '女', 1,
        '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `logistics`
VALUES (47, 0x31, '后勤', 'dev789', '40016', '保安', '孙八', '1983-10-18', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 11:15:00', '2024-03-30 11:15:00');
INSERT INTO `logistics`
VALUES (48, 0x32, '后勤', 'dev123', '40017', '保洁', '周九', '1998-08-30', 'fakepassword', '13222221111', '女', 1,
        '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `logistics`
VALUES (49, 0x31, '后勤', 'dev456', '40018', '饭堂', '吴十', '1993-06-12', 'fakepassword', '13133334444', '男', 1,
        '2024-03-30 11:45:00', '2024-03-30 11:45:00');
INSERT INTO `logistics`
VALUES (50, 0x31, '后勤', 'dev789', '40019', '保安', '郑十一', '1987-04-03', 'fakepassword', '13000001111', '男', 1,
        '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `logistics`
VALUES (51, 0x31, '后勤', 'dev123', '40020', '饭堂', '王十二', '1991-01-28', 'fakepassword', '13987654321', '女', 1,
        '2024-03-30 12:15:00', '2024-03-30 12:15:00');
INSERT INTO `logistics`
VALUES (52, 0x32, '后勤', 'dev456', '40021', '保洁', '李十三', '1994-11-14', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `logistics`
VALUES (53, 0x31, '后勤', 'dev789', '40022', '保安', '张十四', '1989-08-08', 'fakepassword', '13899998888', '男', 1,
        '2024-03-30 12:45:00', '2024-03-30 12:45:00');
INSERT INTO `logistics`
VALUES (54, 0x31, '后勤', 'dev123', '40023', '饭堂', '李十五', '1996-02-22', 'fakepassword', '13777776666', '女', 1,
        '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `logistics`
VALUES (55, 0x32, '后勤', 'dev456', '40024', '保洁', '王十六', '1990-05-01', 'fakepassword', '13511112222', '男', 1,
        '2024-03-30 13:15:00', '2024-03-30 13:15:00');
INSERT INTO `logistics`
VALUES (56, 0x31, '后勤', 'dev789', '40025', '保安', '赵十七', '1986-09-16', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `logistics`
VALUES (57, 0x31, '后勤', 'dev789', '40011', '保洁', '张三', '1990-05-15', 'fakepassword', '13987654321', '男', 1,
        '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `logistics`
VALUES (58, 0x31, '后勤', 'dev123', '40012', '保安', '李四', '1985-07-20', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 10:15:00', '2024-03-30 10:15:00');
INSERT INTO `logistics`
VALUES (59, 0x32, '后勤', 'dev456', '40013', '保洁', '王五', '1992-09-10', 'fakepassword', '13899998888', '女', 1,
        '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `logistics`
VALUES (60, 0x31, '后勤', 'dev789', '40014', '保安', '赵六', '1988-03-25', 'fakepassword', '13777776666', '男', 1,
        '2024-03-30 10:45:00', '2024-03-30 10:45:00');
INSERT INTO `logistics`
VALUES (61, 0x31, '后勤', 'dev123', '40015', '饭堂', '钱七', '1995-12-05', 'fakepassword', '13511112222', '女', 1,
        '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `logistics`
VALUES (62, 0x31, '后勤', 'dev789', '40016', '保安', '孙八', '1983-10-18', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 11:15:00', '2024-03-30 11:15:00');
INSERT INTO `logistics`
VALUES (63, 0x32, '后勤', 'dev123', '40017', '保洁', '周九', '1998-08-30', 'fakepassword', '13222221111', '女', 1,
        '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `logistics`
VALUES (64, 0x31, '后勤', 'dev456', '40018', '饭堂', '吴十', '1993-06-12', 'fakepassword', '13133334444', '男', 1,
        '2024-03-30 11:45:00', '2024-03-30 11:45:00');
INSERT INTO `logistics`
VALUES (65, 0x31, '后勤', 'dev789', '40019', '保安', '郑十一', '1987-04-03', 'fakepassword', '13000001111', '男', 1,
        '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `logistics`
VALUES (66, 0x31, '后勤', 'dev123', '40020', '饭堂', '王十二', '1991-01-28', 'fakepassword', '13987654321', '女', 1,
        '2024-03-30 12:15:00', '2024-03-30 12:15:00');
INSERT INTO `logistics`
VALUES (67, 0x32, '后勤', 'dev456', '40021', '保洁', '李十三', '1994-11-14', 'fakepassword', '13612345678', '男', 1,
        '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `logistics`
VALUES (68, 0x31, '后勤', 'dev789', '40022', '保安', '张十四', '1989-08-08', 'fakepassword', '13899998888', '男', 1,
        '2024-03-30 12:45:00', '2024-03-30 12:45:00');
INSERT INTO `logistics`
VALUES (69, 0x31, '后勤', 'dev123', '40023', '饭堂', '李十五', '1996-02-22', 'fakepassword', '13777776666', '女', 1,
        '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `logistics`
VALUES (70, 0x32, '后勤', 'dev456', '40024', '保洁', '王十六', '1990-05-01', 'fakepassword', '13511112222', '男', 1,
        '2024-03-30 13:15:00', '2024-03-30 13:15:00');
INSERT INTO `logistics`
VALUES (71, 0x31, '后勤', 'dev789', '40025', '保安', '赵十七', '1986-09-16', 'fakepassword', '13444445555', '男', 1,
        '2024-03-30 13:30:00', '2024-03-30 13:30:00');

-- ----------------------------
-- Table structure for logs_data
-- ----------------------------
DROP TABLE IF EXISTS `logs_data`;
CREATE TABLE `logs_data`
(
    `id`          bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `data_id`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志id',
    `user_id`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员id',
    `logs_type`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志类型',
    `result`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '执行结果',
    `msg`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '结果说明',
    `ip`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ip地址',
    `is_success`  int(0) NOT NULL COMMENT '是否成功,1成功,0失败',
    `create_time` datetime(0) NOT NULL COMMENT '操作时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `data_id`(`data_id`) USING BTREE,
    INDEX         `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logs_data
-- ----------------------------
INSERT INTO `logs_data`
VALUES (3, 'c478eea0-b5ee-4cbd-a93d-52b45a5afee0', 'admin', '删除药品', '删除失败', '删除id:10不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-25 23:06:47');
INSERT INTO `logs_data`
VALUES (4, '07f11c6f-00bf-41a5-b906-ff5afc4eba96', 'admin', '删除药品', '删除成功', '删除id:9,名字:感冒灵',
        '0:0:0:0:0:0:0:1', 1, '2024-03-25 23:07:04');
INSERT INTO `logs_data`
VALUES (5, 'b431498e-79df-498b-a684-647a9e8ce2b3', 'admin', '修改药品', '修改成功', '修改id:2,名字:感冒灵',
        '0:0:0:0:0:0:0:1', 1, '2024-03-25 23:14:22');
INSERT INTO `logs_data`
VALUES (7, '4ae550d1-5b2c-470b-bf5a-f9055dc0bc1c', 'admin', '删除学生', '删除成功', '删除id:20002,名字:肖战',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 11:28:04');
INSERT INTO `logs_data`
VALUES (8, 'ce5953c6-2561-4bb7-b341-b37ae45a09f6', 'admin', '删除学生', '删除失败', '删除id:20002不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 11:28:42');
INSERT INTO `logs_data`
VALUES (9, '8ba5dfc8-bf2d-4d01-8c1b-eae5e22a0476', 'admin', '添加学生', '添加成功', '添加id:20201,名字:蔡徐坤',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 12:35:21');
INSERT INTO `logs_data`
VALUES (10, 'c9cf2136-0988-45fa-8841-513678dde733', 'admin', '修改学生', '修改成功', '修改id:20201,名字:蔡徐',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:17:13');
INSERT INTO `logs_data`
VALUES (11, '125553c1-cfcc-4fcf-aaaf-ef7859dfd0f9', 'admin', '修改学生', '修改成功', '修改id:20201,名字:蔡徐',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:17:51');
INSERT INTO `logs_data`
VALUES (12, '96639bfe-1be5-4bb8-9ac0-b610efd5947f', 'admin', '修改学生', '修改成功', '修改id:20201,名字:蔡徐',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:18:56');
INSERT INTO `logs_data`
VALUES (13, 'de6fd0aa-4527-4a05-bd94-582a62c09ad6', 'admin', '修改学生', '修改成功', '修改id:20003,名字:黄林峰',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 16:26:07');
INSERT INTO `logs_data`
VALUES (14, '94c0f184-5dd4-4e1f-9592-7b89a4f44814', 'admin', '删除老师', '删除失败', '删除id:30005不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 21:58:03');
INSERT INTO `logs_data`
VALUES (15, '4f305a96-b1f8-493a-b302-1803debc3c2b', 'admin', '删除老师', '删除成功', '删除id:30006,名字:胡老师',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 21:58:17');
INSERT INTO `logs_data`
VALUES (16, 'fa85bc1b-1417-4143-ae4b-e9f8c3a5cee7', 'admin', '更新老师', '更新成功', '更新id:30001,名字:李老师',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 22:01:35');
INSERT INTO `logs_data`
VALUES (17, 'b5fe3bcb-e91e-4e0f-818c-d45db267c587', 'admin', '删除后勤', '删除成功', '删除id:40003,名字:张二狗',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 22:40:10');
INSERT INTO `logs_data`
VALUES (18, 'bbee9d4c-678b-4e56-ab10-0b5903e3ac02', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:40:51');
INSERT INTO `logs_data`
VALUES (19, '6978dec8-513d-430a-bf9d-1cd50d72841a', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:41:02');
INSERT INTO `logs_data`
VALUES (20, '98c6343a-6fd2-4bec-907d-85adff875c1b', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:41:14');
INSERT INTO `logs_data`
VALUES (21, '8ccfa7c8-23f7-4ebd-ae44-c666a8447f06', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:43:34');
INSERT INTO `logs_data`
VALUES (22, '27c3b6a8-cba8-49e7-9bf2-647194ea38fe', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:43:42');
INSERT INTO `logs_data`
VALUES (23, '2d3a654d-555d-4607-924e-f1252b3c113d', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:43:57');
INSERT INTO `logs_data`
VALUES (24, 'df54fcd9-b622-4d45-9617-c6ce1b92501f', 'admin', '添加后勤', '添加失败', '添加id:40010,名字:王二狗',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:47:54');
INSERT INTO `logs_data`
VALUES (25, '19edfd4d-1134-4dc8-ad80-45b47d74bccc', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:48:28');
INSERT INTO `logs_data`
VALUES (26, '9748c2bc-f934-42d7-bf9a-dd4f8502050d', 'admin', '更新后勤', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-26 22:48:39');
INSERT INTO `logs_data`
VALUES (27, '445e636b-b32b-4a9b-8a86-f1d8792ea3dc', 'admin', '更新后勤', '更新成功', '更新id:40005,名字:校二',
        '0:0:0:0:0:0:0:1', 1, '2024-03-26 22:51:01');
INSERT INTO `logs_data`
VALUES (28, 'e2d324af-5ad6-406c-b4c3-496911ef8578', 'admin', '删除家长', '删除成功', '删除id:10003,名字:赵嗄六',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:23:04');
INSERT INTO `logs_data`
VALUES (29, '5179b5f7-1263-406a-8a27-9ad77d1fee36', 'admin', '更新家长', '更新失败', '更新id:10003已存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 20:25:03');
INSERT INTO `logs_data`
VALUES (30, 'a03b1977-00a3-4a28-8185-bba843cbae36', 'admin', '更新家长', '更新失败', '更新id:10004已存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 20:25:27');
INSERT INTO `logs_data`
VALUES (31, 'c7e10d8e-f6fa-44dd-83eb-41922579eeab', 'admin', '更新家长', '更新失败', '更新id:10004已存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 20:25:28');
INSERT INTO `logs_data`
VALUES (32, 'cfec75c3-ba11-472e-886d-f55388ce3c8c', 'admin', '更新家长', '更新成功', '更新id:10004,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:26:55');
INSERT INTO `logs_data`
VALUES (33, 'c1ce8e9c-e735-4cd1-b8d7-859dac1b387b', 'admin', '更新家长', '更新成功', '更新id:10004,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:01');
INSERT INTO `logs_data`
VALUES (34, '71fbcd1c-8ea1-434b-bce9-5ecff74e6435', 'admin', '更新家长', '更新成功', '更新id:10004,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:07');
INSERT INTO `logs_data`
VALUES (35, 'b20862a3-4a55-4984-9904-9c9bd2197d5d', 'admin', '更新家长', '更新成功', '更新id:10005,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:19');
INSERT INTO `logs_data`
VALUES (36, '1d9b3cd9-3065-4744-b33f-9bf997c2e04d', 'admin', '更新家长', '更新成功', '更新id:10005,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:19');
INSERT INTO `logs_data`
VALUES (37, '19f98042-fad3-4545-a7b3-d33833d988c8', 'admin', '更新家长', '更新成功', '更新id:10005,名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:19');
INSERT INTO `logs_data`
VALUES (38, '4ae97ed1-e383-4a93-8135-16dbc60331c6', 'admin', '更新家长', '更新成功', '更新id:10005,名字:赵1六',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 20:27:55');
INSERT INTO `logs_data`
VALUES (39, '91341cb3-2661-4518-95a2-409da2b1a83e', 'admin', '删除预约', '删除失败', '删除id:1不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 22:40:15');
INSERT INTO `logs_data`
VALUES (40, '1658f3fc-0d11-48e4-91b9-835a771c7fa3', 'admin', '删除预约', '删除失败', '删除id:1不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-28 22:40:20');
INSERT INTO `logs_data`
VALUES (41, '42ac575e-b51c-4a93-bc21-17e2419db037', 'admin', '删除预约', '删除成功', '删除id:1,预约人名字:王宝强',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 22:41:06');
INSERT INTO `logs_data`
VALUES (42, '1324fb1b-6e7a-4ee5-b3ac-a2adbe574e54', 'admin', '更新预约', '更新成功', '更新id:1,预约人名字:王强',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 22:58:08');
INSERT INTO `logs_data`
VALUES (43, '8dab9f0e-4251-4b20-b946-9d42862a76a7', 'admin', '更新预约', '更新成功', '更新id:1,预约人名字:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 22:59:44');
INSERT INTO `logs_data`
VALUES (44, '496a4282-85d4-4354-a2f7-4d5640dfc673', 'admin', '更新订单', '更新成功', '更新id:1,购买药品:感灵',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 23:00:23');
INSERT INTO `logs_data`
VALUES (45, 'aa0e0b62-e6b3-490a-82a7-0dfde227f17f', 'admin', '更新订单', '更新成功', '更新id:1,购买药品:null',
        '0:0:0:0:0:0:0:1', 1, '2024-03-28 23:00:42');
INSERT INTO `logs_data`
VALUES (46, '188b6163-3c77-40d2-805a-b50135365c20', 'admin', '删除通知', '删除成功', '删除id:1,标题:学校教务处',
        '0:0:0:0:0:0:0:1', 1, '2024-03-29 17:12:14');
INSERT INTO `logs_data`
VALUES (47, '7439c5fc-c81c-4231-bb29-2fd8dcaca625', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:21:49');
INSERT INTO `logs_data`
VALUES (48, '25fb5940-2198-48ed-a97c-d08f388b04be', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:22:00');
INSERT INTO `logs_data`
VALUES (49, '39312eda-46b2-4c24-8e82-c779cd089029', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:24:29');
INSERT INTO `logs_data`
VALUES (50, '84d0be24-0fb9-4f5f-98f9-0de74f75a088', 'admin', '更新通知', '更新成功', '更新id:3,标题:校',
        '0:0:0:0:0:0:0:1', 1, '2024-03-29 17:29:17');
INSERT INTO `logs_data`
VALUES (51, '3af74fb5-e3cd-44ed-9f5e-69329339fcda', 'admin', '更新通知', '更新失败', '更新id:null不存在',
        '0:0:0:0:0:0:0:1', 0, '2024-03-29 17:29:40');
INSERT INTO `logs_data`
VALUES (52, 'bbe23547-0407-436a-9e9c-04b7d6b2395a', 'admin', '更新通知', '更新成功', '更新id:4,标题:校',
        '0:0:0:0:0:0:0:1', 1, '2024-03-29 17:29:54');
INSERT INTO `logs_data`
VALUES (53, '20240330001', 'USR2024', '订单操作', '成功', '提交订单成功', '192.168.1.101', 1, '2024-03-30 08:50:00');
INSERT INTO `logs_data`
VALUES (54, '20240330002', 'USR2024', '订单操作', '失败', '库存不足', '192.168.1.102', 0, '2024-03-30 08:55:00');
INSERT INTO `logs_data`
VALUES (55, '20240330003', 'USR2025', '登录操作', '成功', '登录成功', '192.168.1.103', 1, '2024-03-30 09:00:00');
INSERT INTO `logs_data`
VALUES (56, '20240330004', 'USR2026', '数据修改', '成功', '修改个人信息成功', '192.168.1.104', 1,
        '2024-03-30 09:05:00');
INSERT INTO `logs_data`
VALUES (57, '20240330005', 'USR2027', '数据查询', '成功', '查询商品信息成功', '192.168.1.105', 1,
        '2024-03-30 09:10:00');
INSERT INTO `logs_data`
VALUES (58, '20240330006', 'USR2028', '数据删除', '失败', '删除文件失败', '192.168.1.106', 0, '2024-03-30 09:15:00');
INSERT INTO `logs_data`
VALUES (59, '20240330007', 'USR2029', '登录操作', '失败', '用户名或密码错误', '192.168.1.107', 0,
        '2024-03-30 09:20:00');
INSERT INTO `logs_data`
VALUES (60, '20240330008', 'USR2030', '订单操作', '成功', '取消订单成功', '192.168.1.108', 1, '2024-03-30 09:25:00');
INSERT INTO `logs_data`
VALUES (61, '20240330009', 'USR2031', '数据查询', '失败', '数据库连接超时', '192.168.1.109', 0, '2024-03-30 09:30:00');
INSERT INTO `logs_data`
VALUES (62, '20240330010', 'USR2032', '数据修改', '成功', '修改密码成功', '192.168.1.110', 1, '2024-03-30 09:35:00');
INSERT INTO `logs_data`
VALUES (63, '20240330001', 'USR2024', '订单操作', '成功', '提交订单成功', '192.168.1.101', 1, '2024-03-30 08:50:00');
INSERT INTO `logs_data`
VALUES (64, '20240330002', 'USR2024', '订单操作', '失败', '库存不足', '192.168.1.102', 0, '2024-03-30 08:55:00');
INSERT INTO `logs_data`
VALUES (65, '20240330003', 'USR2025', '登录操作', '成功', '登录成功', '192.168.1.103', 1, '2024-03-30 09:00:00');
INSERT INTO `logs_data`
VALUES (66, '20240330004', 'USR2026', '数据修改', '成功', '修改个人信息成功', '192.168.1.104', 1,
        '2024-03-30 09:05:00');
INSERT INTO `logs_data`
VALUES (67, '20240330005', 'USR2027', '数据查询', '成功', '查询商品信息成功', '192.168.1.105', 1,
        '2024-03-30 09:10:00');
INSERT INTO `logs_data`
VALUES (68, '20240330006', 'USR2028', '数据删除', '失败', '删除文件失败', '192.168.1.106', 0, '2024-03-30 09:15:00');
INSERT INTO `logs_data`
VALUES (69, '20240330007', 'USR2029', '登录操作', '失败', '用户名或密码错误', '192.168.1.107', 0,
        '2024-03-30 09:20:00');
INSERT INTO `logs_data`
VALUES (70, '20240330008', 'USR2030', '订单操作', '成功', '取消订单成功', '192.168.1.108', 1, '2024-03-30 09:25:00');
INSERT INTO `logs_data`
VALUES (71, '20240330009', 'USR2031', '数据查询', '失败', '数据库连接超时', '192.168.1.109', 0, '2024-03-30 09:30:00');
INSERT INTO `logs_data`
VALUES (72, '20240330010', 'USR2032', '数据修改', '成功', '修改密码成功', '192.168.1.110', 1, '2024-03-30 09:35:00');
INSERT INTO `logs_data`
VALUES (73, '20240330001', 'USR2024', '订单操作', '成功', '提交订单成功', '192.168.1.101', 1, '2024-03-30 08:50:00');
INSERT INTO `logs_data`
VALUES (74, '20240330002', 'USR2024', '订单操作', '失败', '库存不足', '192.168.1.102', 0, '2024-03-30 08:55:00');
INSERT INTO `logs_data`
VALUES (75, '20240330003', 'USR2025', '登录操作', '成功', '登录成功', '192.168.1.103', 1, '2024-03-30 09:00:00');
INSERT INTO `logs_data`
VALUES (76, '20240330004', 'USR2026', '数据修改', '成功', '修改个人信息成功', '192.168.1.104', 1,
        '2024-03-30 09:05:00');
INSERT INTO `logs_data`
VALUES (77, '20240330005', 'USR2027', '数据查询', '成功', '查询商品信息成功', '192.168.1.105', 1,
        '2024-03-30 09:10:00');
INSERT INTO `logs_data`
VALUES (78, '20240330006', 'USR2028', '数据删除', '失败', '删除文件失败', '192.168.1.106', 0, '2024-03-30 09:15:00');
INSERT INTO `logs_data`
VALUES (79, '20240330007', 'USR2029', '登录操作', '失败', '用户名或密码错误', '192.168.1.107', 0,
        '2024-03-30 09:20:00');
INSERT INTO `logs_data`
VALUES (80, '20240330008', 'USR2030', '订单操作', '成功', '取消订单成功', '192.168.1.108', 1, '2024-03-30 09:25:00');
INSERT INTO `logs_data`
VALUES (81, '20240330009', 'USR2031', '数据查询', '失败', '数据库连接超时', '192.168.1.109', 0, '2024-03-30 09:30:00');
INSERT INTO `logs_data`
VALUES (82, '20240330010', 'USR2032', '数据修改', '成功', '修改密码成功', '192.168.1.110', 1, '2024-03-30 09:35:00');
INSERT INTO `logs_data`
VALUES (83, '20240330001', 'USR2024', '订单操作', '成功', '提交订单成功', '192.168.1.101', 1, '2024-03-30 08:50:00');
INSERT INTO `logs_data`
VALUES (84, '20240330002', 'USR2024', '订单操作', '失败', '库存不足', '192.168.1.102', 0, '2024-03-30 08:55:00');
INSERT INTO `logs_data`
VALUES (85, '20240330003', 'USR2025', '登录操作', '成功', '登录成功', '192.168.1.103', 1, '2024-03-30 09:00:00');
INSERT INTO `logs_data`
VALUES (86, '20240330004', 'USR2026', '数据修改', '成功', '修改个人信息成功', '192.168.1.104', 1,
        '2024-03-30 09:05:00');
INSERT INTO `logs_data`
VALUES (87, '20240330005', 'USR2027', '数据查询', '成功', '查询商品信息成功', '192.168.1.105', 1,
        '2024-03-30 09:10:00');
INSERT INTO `logs_data`
VALUES (88, '20240330006', 'USR2028', '数据删除', '失败', '删除文件失败', '192.168.1.106', 0, '2024-03-30 09:15:00');
INSERT INTO `logs_data`
VALUES (89, '20240330007', 'USR2029', '登录操作', '失败', '用户名或密码错误', '192.168.1.107', 0,
        '2024-03-30 09:20:00');
INSERT INTO `logs_data`
VALUES (90, '20240330008', 'USR2030', '订单操作', '成功', '取消订单成功', '192.168.1.108', 1, '2024-03-30 09:25:00');
INSERT INTO `logs_data`
VALUES (91, '20240330009', 'USR2031', '数据查询', '失败', '数据库连接超时', '192.168.1.109', 0, '2024-03-30 09:30:00');
INSERT INTO `logs_data`
VALUES (92, '20240330010', 'USR2032', '数据修改', '成功', '修改密码成功', '192.168.1.110', 1, '2024-03-30 09:35:00');

-- ----------------------------
-- Table structure for notifications
-- ----------------------------
DROP TABLE IF EXISTS `notifications`;
CREATE TABLE `notifications`
(
    `id`           bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `notify_id`    int(0) NOT NULL COMMENT '消息id',
    `title`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
    `publisher`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发布者',
    `content`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
    `time`         datetime(0) NOT NULL COMMENT '日志时间',
    `notify_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知群体',
    `create_time`  datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`  datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `notify_id`(`notify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notifications
-- ----------------------------
INSERT INTO `notifications`
VALUES (2, 2, '校长', '紧急通知', '请所有学生注意安全', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41',
        '2024-03-20 22:00:41');
INSERT INTO `notifications`
VALUES (3, 3, '校', '校长', '放假', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41', '2024-03-29 17:29:17');
INSERT INTO `notifications`
VALUES (4, 4, '校', '紧急通知', '请所有学生注意安全', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41',
        '2024-03-29 17:29:54');
INSERT INTO `notifications`
VALUES (5, 5, '学校教务处', '紧急通知', '请所有学生注意安全', '2024-03-20 22:00:41', '全校', '2024-03-20 22:00:41',
        '2024-03-20 22:00:41');
INSERT INTO `notifications`
VALUES (6, 6, '教务通知', '教务处', '今天下午的课程取消', '2024-03-30 14:00:00', '全校教职员工', '2024-03-30 14:00:00',
        '2024-03-30 14:00:00');
INSERT INTO `notifications`
VALUES (7, 7, '校车行程调整', '后勤部', '由于路面施工，校车行程调整，请留意', '2024-03-31 07:30:00', '校内学生',
        '2024-03-30 14:05:00', '2024-03-30 14:05:00');
INSERT INTO `notifications`
VALUES (8, 8, '体育课取消', '体育部', '今天下午的体育课取消，请同学们注意安排', '2024-03-30 15:00:00', '全校学生',
        '2024-03-30 14:10:00', '2024-03-30 14:10:00');
INSERT INTO `notifications`
VALUES (9, 9, '图书馆闭馆通知', '图书馆', '由于设备维护，图书馆闭馆一天，给大家带来不便敬请谅解', '2024-03-31 18:00:00',
        '全校师生', '2024-03-30 14:15:00', '2024-03-30 14:15:00');
INSERT INTO `notifications`
VALUES (10, 10, '食堂饭菜调整', '食堂管理处', '今天晚上的饭菜将有所调整，请同学们提前做好准备', '2024-03-30 18:00:00',
        '校内学生', '2024-03-30 14:20:00', '2024-03-30 14:20:00');
INSERT INTO `notifications`
VALUES (11, 11, '宿舍停电通知', '后勤部', '今晚22:00-23:00，宿舍楼将停电进行维护，请提前做好准备', '2024-03-30 22:00:00',
        '校内住宿学生', '2024-03-30 14:25:00', '2024-03-30 14:25:00');
INSERT INTO `notifications`
VALUES (12, 12, '校园安全事项提醒', '保卫处', '提醒各位师生注意校园安全，禁止私自攀爬校园设施', '2024-03-31 09:00:00',
        '全校师生', '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `notifications`
VALUES (13, 13, '教学楼维修通知', '后勤部', '本周五晚上将进行教学楼维修，请注意安全', '2024-04-05 18:00:00',
        '校内教职员工', '2024-03-30 14:35:00', '2024-03-30 14:35:00');
INSERT INTO `notifications`
VALUES (14, 14, '校园环境卫生整治通知', '后勤部', '本周六将进行校园环境卫生整治，请各位师生积极配合',
        '2024-04-06 08:00:00', '全校师生', '2024-03-30 14:40:00', '2024-03-30 14:40:00');
INSERT INTO `notifications`
VALUES (15, 15, '暑期实习安排通知', '学院办公室', '请各位同学查看暑期实习安排通知，及时报名', '2024-04-01 09:00:00',
        '相关专业学生', '2024-03-30 14:45:00', '2024-03-30 14:45:00');
INSERT INTO `notifications`
VALUES (16, 6, '教务通知', '教务处', '今天下午的课程取消', '2024-03-30 14:00:00', '全校教职员工', '2024-03-30 14:00:00',
        '2024-03-30 14:00:00');
INSERT INTO `notifications`
VALUES (17, 7, '校车行程调整', '后勤部', '由于路面施工，校车行程调整，请留意', '2024-03-31 07:30:00', '校内学生',
        '2024-03-30 14:05:00', '2024-03-30 14:05:00');
INSERT INTO `notifications`
VALUES (18, 8, '体育课取消', '体育部', '今天下午的体育课取消，请同学们注意安排', '2024-03-30 15:00:00', '全校学生',
        '2024-03-30 14:10:00', '2024-03-30 14:10:00');
INSERT INTO `notifications`
VALUES (19, 9, '图书馆闭馆通知', '图书馆', '由于设备维护，图书馆闭馆一天，给大家带来不便敬请谅解', '2024-03-31 18:00:00',
        '全校师生', '2024-03-30 14:15:00', '2024-03-30 14:15:00');
INSERT INTO `notifications`
VALUES (20, 10, '食堂饭菜调整', '食堂管理处', '今天晚上的饭菜将有所调整，请同学们提前做好准备', '2024-03-30 18:00:00',
        '校内学生', '2024-03-30 14:20:00', '2024-03-30 14:20:00');
INSERT INTO `notifications`
VALUES (21, 11, '宿舍停电通知', '后勤部', '今晚22:00-23:00，宿舍楼将停电进行维护，请提前做好准备', '2024-03-30 22:00:00',
        '校内住宿学生', '2024-03-30 14:25:00', '2024-03-30 14:25:00');
INSERT INTO `notifications`
VALUES (22, 12, '校园安全事项提醒', '保卫处', '提醒各位师生注意校园安全，禁止私自攀爬校园设施', '2024-03-31 09:00:00',
        '全校师生', '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `notifications`
VALUES (23, 13, '教学楼维修通知', '后勤部', '本周五晚上将进行教学楼维修，请注意安全', '2024-04-05 18:00:00',
        '校内教职员工', '2024-03-30 14:35:00', '2024-03-30 14:35:00');
INSERT INTO `notifications`
VALUES (24, 14, '校园环境卫生整治通知', '后勤部', '本周六将进行校园环境卫生整治，请各位师生积极配合',
        '2024-04-06 08:00:00', '全校师生', '2024-03-30 14:40:00', '2024-03-30 14:40:00');
INSERT INTO `notifications`
VALUES (25, 15, '暑期实习安排通知', '学院办公室', '请各位同学查看暑期实习安排通知，及时报名', '2024-04-01 09:00:00',
        '相关专业学生', '2024-03-30 14:45:00', '2024-03-30 14:45:00');
INSERT INTO `notifications`
VALUES (26, 6, '教务通知', '教务处', '今天下午的课程取消', '2024-03-30 14:00:00', '全校教职员工', '2024-03-30 14:00:00',
        '2024-03-30 14:00:00');
INSERT INTO `notifications`
VALUES (27, 7, '校车行程调整', '后勤部', '由于路面施工，校车行程调整，请留意', '2024-03-31 07:30:00', '校内学生',
        '2024-03-30 14:05:00', '2024-03-30 14:05:00');
INSERT INTO `notifications`
VALUES (28, 8, '体育课取消', '体育部', '今天下午的体育课取消，请同学们注意安排', '2024-03-30 15:00:00', '全校学生',
        '2024-03-30 14:10:00', '2024-03-30 14:10:00');
INSERT INTO `notifications`
VALUES (29, 9, '图书馆闭馆通知', '图书馆', '由于设备维护，图书馆闭馆一天，给大家带来不便敬请谅解', '2024-03-31 18:00:00',
        '全校师生', '2024-03-30 14:15:00', '2024-03-30 14:15:00');
INSERT INTO `notifications`
VALUES (30, 10, '食堂饭菜调整', '食堂管理处', '今天晚上的饭菜将有所调整，请同学们提前做好准备', '2024-03-30 18:00:00',
        '校内学生', '2024-03-30 14:20:00', '2024-03-30 14:20:00');
INSERT INTO `notifications`
VALUES (31, 11, '宿舍停电通知', '后勤部', '今晚22:00-23:00，宿舍楼将停电进行维护，请提前做好准备', '2024-03-30 22:00:00',
        '校内住宿学生', '2024-03-30 14:25:00', '2024-03-30 14:25:00');
INSERT INTO `notifications`
VALUES (32, 12, '校园安全事项提醒', '保卫处', '提醒各位师生注意校园安全，禁止私自攀爬校园设施', '2024-03-31 09:00:00',
        '全校师生', '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `notifications`
VALUES (33, 13, '教学楼维修通知', '后勤部', '本周五晚上将进行教学楼维修，请注意安全', '2024-04-05 18:00:00',
        '校内教职员工', '2024-03-30 14:35:00', '2024-03-30 14:35:00');
INSERT INTO `notifications`
VALUES (34, 14, '校园环境卫生整治通知', '后勤部', '本周六将进行校园环境卫生整治，请各位师生积极配合',
        '2024-04-06 08:00:00', '全校师生', '2024-03-30 14:40:00', '2024-03-30 14:40:00');
INSERT INTO `notifications`
VALUES (35, 15, '暑期实习安排通知', '学院办公室', '请各位同学查看暑期实习安排通知，及时报名', '2024-04-01 09:00:00',
        '相关专业学生', '2024-03-30 14:45:00', '2024-03-30 14:45:00');
INSERT INTO `notifications`
VALUES (36, 6, '教务通知', '教务处', '今天下午的课程取消', '2024-03-30 14:00:00', '全校教职员工', '2024-03-30 14:00:00',
        '2024-03-30 14:00:00');
INSERT INTO `notifications`
VALUES (37, 7, '校车行程调整', '后勤部', '由于路面施工，校车行程调整，请留意', '2024-03-31 07:30:00', '校内学生',
        '2024-03-30 14:05:00', '2024-03-30 14:05:00');
INSERT INTO `notifications`
VALUES (38, 8, '体育课取消', '体育部', '今天下午的体育课取消，请同学们注意安排', '2024-03-30 15:00:00', '全校学生',
        '2024-03-30 14:10:00', '2024-03-30 14:10:00');
INSERT INTO `notifications`
VALUES (39, 9, '图书馆闭馆通知', '图书馆', '由于设备维护，图书馆闭馆一天，给大家带来不便敬请谅解', '2024-03-31 18:00:00',
        '全校师生', '2024-03-30 14:15:00', '2024-03-30 14:15:00');
INSERT INTO `notifications`
VALUES (40, 10, '食堂饭菜调整', '食堂管理处', '今天晚上的饭菜将有所调整，请同学们提前做好准备', '2024-03-30 18:00:00',
        '校内学生', '2024-03-30 14:20:00', '2024-03-30 14:20:00');
INSERT INTO `notifications`
VALUES (41, 11, '宿舍停电通知', '后勤部', '今晚22:00-23:00，宿舍楼将停电进行维护，请提前做好准备', '2024-03-30 22:00:00',
        '校内住宿学生', '2024-03-30 14:25:00', '2024-03-30 14:25:00');
INSERT INTO `notifications`
VALUES (42, 12, '校园安全事项提醒', '保卫处', '提醒各位师生注意校园安全，禁止私自攀爬校园设施', '2024-03-31 09:00:00',
        '全校师生', '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `notifications`
VALUES (43, 13, '教学楼维修通知', '后勤部', '本周五晚上将进行教学楼维修，请注意安全', '2024-04-05 18:00:00',
        '校内教职员工', '2024-03-30 14:35:00', '2024-03-30 14:35:00');
INSERT INTO `notifications`
VALUES (44, 14, '校园环境卫生整治通知', '后勤部', '本周六将进行校园环境卫生整治，请各位师生积极配合',
        '2024-04-06 08:00:00', '全校师生', '2024-03-30 14:40:00', '2024-03-30 14:40:00');
INSERT INTO `notifications`
VALUES (45, 15, '暑期实习安排通知', '学院办公室', '请各位同学查看暑期实习安排通知，及时报名', '2024-04-01 09:00:00',
        '相关专业学生', '2024-03-30 14:45:00', '2024-03-30 14:45:00');
INSERT INTO `notifications`
VALUES (46, 6, '教务通知', '教务处', '今天下午的课程取消', '2024-03-30 14:00:00', '全校教职员工', '2024-03-30 14:00:00',
        '2024-03-30 14:00:00');
INSERT INTO `notifications`
VALUES (47, 7, '校车行程调整', '后勤部', '由于路面施工，校车行程调整，请留意', '2024-03-31 07:30:00', '校内学生',
        '2024-03-30 14:05:00', '2024-03-30 14:05:00');
INSERT INTO `notifications`
VALUES (48, 8, '体育课取消', '体育部', '今天下午的体育课取消，请同学们注意安排', '2024-03-30 15:00:00', '全校学生',
        '2024-03-30 14:10:00', '2024-03-30 14:10:00');
INSERT INTO `notifications`
VALUES (49, 9, '图书馆闭馆通知', '图书馆', '由于设备维护，图书馆闭馆一天，给大家带来不便敬请谅解', '2024-03-31 18:00:00',
        '全校师生', '2024-03-30 14:15:00', '2024-03-30 14:15:00');
INSERT INTO `notifications`
VALUES (50, 10, '食堂饭菜调整', '食堂管理处', '今天晚上的饭菜将有所调整，请同学们提前做好准备', '2024-03-30 18:00:00',
        '校内学生', '2024-03-30 14:20:00', '2024-03-30 14:20:00');
INSERT INTO `notifications`
VALUES (51, 11, '宿舍停电通知', '后勤部', '今晚22:00-23:00，宿舍楼将停电进行维护，请提前做好准备', '2024-03-30 22:00:00',
        '校内住宿学生', '2024-03-30 14:25:00', '2024-03-30 14:25:00');
INSERT INTO `notifications`
VALUES (52, 12, '校园安全事项提醒', '保卫处', '提醒各位师生注意校园安全，禁止私自攀爬校园设施', '2024-03-31 09:00:00',
        '全校师生', '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `notifications`
VALUES (53, 13, '教学楼维修通知', '后勤部', '本周五晚上将进行教学楼维修，请注意安全', '2024-04-05 18:00:00',
        '校内教职员工', '2024-03-30 14:35:00', '2024-03-30 14:35:00');
INSERT INTO `notifications`
VALUES (54, 14, '校园环境卫生整治通知', '后勤部', '本周六将进行校园环境卫生整治，请各位师生积极配合',
        '2024-04-06 08:00:00', '全校师生', '2024-03-30 14:40:00', '2024-03-30 14:40:00');
INSERT INTO `notifications`
VALUES (55, 15, '暑期实习安排通知', '学院办公室', '请各位同学查看暑期实习安排通知，及时报名', '2024-04-01 09:00:00',
        '相关专业学生', '2024-03-30 14:45:00', '2024-03-30 14:45:00');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`          bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`    int(0) NOT NULL COMMENT '订单id',
    `user_id`     int(0) NOT NULL COMMENT '用户id',
    `drug_id`     int(0) NOT NULL COMMENT '药品id',
    `time`        datetime(0) NOT NULL COMMENT '购买时间',
    `price`       decimal(10, 2) NOT NULL COMMENT '金额',
    `quantity`    int(0) NOT NULL COMMENT '数量',
    `total_price` decimal(10, 2) NOT NULL COMMENT '总金额',
    `create_time` datetime(0) NOT NULL COMMENT '创建时间',
    `update_time` datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `order_id`(`order_id`) USING BTREE,
    INDEX         `user_id`(`user_id`) USING BTREE,
    INDEX         `drug_id`(`drug_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders`
VALUES (1, 1, 10001, 1, '2024-03-17 21:46:27', 20.00, 2, 41.00, '2024-03-17 21:46:27', '2024-03-28 23:00:41');
INSERT INTO `orders`
VALUES (2, 2, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27');
INSERT INTO `orders`
VALUES (3, 3, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27');
INSERT INTO `orders`
VALUES (4, 4, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27');
INSERT INTO `orders`
VALUES (5, 5, 10001, 1, '2024-03-17 21:46:27', 20.50, 2, 41.00, '2024-03-17 21:46:27', '2024-03-17 21:46:27');
INSERT INTO `orders`
VALUES (76, 6, 10002, 2, '2024-03-18 10:30:15', 15.80, 3, 47.40, '2024-03-18 10:30:15', '2024-03-18 10:30:15');
INSERT INTO `orders`
VALUES (77, 7, 10003, 3, '2024-03-19 14:20:55', 25.50, 1, 25.50, '2024-03-19 14:20:55', '2024-03-19 14:20:55');
INSERT INTO `orders`
VALUES (78, 8, 10004, 1, '2024-03-20 09:45:37', 18.90, 2, 37.80, '2024-03-20 09:45:37', '2024-03-20 09:45:37');
INSERT INTO `orders`
VALUES (79, 9, 10005, 2, '2024-03-21 11:55:22', 15.80, 1, 15.80, '2024-03-21 11:55:22', '2024-03-21 11:55:22');
INSERT INTO `orders`
VALUES (80, 10, 10006, 3, '2024-03-22 16:10:48', 25.50, 3, 76.50, '2024-03-22 16:10:48', '2024-03-22 16:10:48');
INSERT INTO `orders`
VALUES (81, 11, 10007, 1, '2024-03-23 20:35:12', 18.90, 1, 18.90, '2024-03-23 20:35:12', '2024-03-23 20:35:12');
INSERT INTO `orders`
VALUES (82, 12, 10008, 2, '2024-03-24 13:40:29', 15.80, 2, 31.60, '2024-03-24 13:40:29', '2024-03-24 13:40:29');
INSERT INTO `orders`
VALUES (83, 13, 10009, 3, '2024-03-25 17:55:41', 25.50, 1, 25.50, '2024-03-25 17:55:41', '2024-03-25 17:55:41');
INSERT INTO `orders`
VALUES (84, 14, 10010, 1, '2024-03-26 22:10:03', 18.90, 3, 56.70, '2024-03-26 22:10:03', '2024-03-26 22:10:03');
INSERT INTO `orders`
VALUES (85, 15, 10011, 2, '2024-03-27 08:15:19', 15.80, 1, 15.80, '2024-03-27 08:15:19', '2024-03-27 08:15:19');
INSERT INTO `orders`
VALUES (86, 6, 10002, 2, '2024-03-18 10:30:15', 15.80, 3, 47.40, '2024-03-18 10:30:15', '2024-03-18 10:30:15');
INSERT INTO `orders`
VALUES (87, 7, 10003, 3, '2024-03-19 14:20:55', 25.50, 1, 25.50, '2024-03-19 14:20:55', '2024-03-19 14:20:55');
INSERT INTO `orders`
VALUES (88, 8, 10004, 1, '2024-03-20 09:45:37', 18.90, 2, 37.80, '2024-03-20 09:45:37', '2024-03-20 09:45:37');
INSERT INTO `orders`
VALUES (89, 9, 10005, 2, '2024-03-21 11:55:22', 15.80, 1, 15.80, '2024-03-21 11:55:22', '2024-03-21 11:55:22');
INSERT INTO `orders`
VALUES (90, 10, 10006, 3, '2024-03-22 16:10:48', 25.50, 3, 76.50, '2024-03-22 16:10:48', '2024-03-22 16:10:48');
INSERT INTO `orders`
VALUES (91, 11, 10007, 1, '2024-03-23 20:35:12', 18.90, 1, 18.90, '2024-03-23 20:35:12', '2024-03-23 20:35:12');
INSERT INTO `orders`
VALUES (92, 12, 10008, 2, '2024-03-24 13:40:29', 15.80, 2, 31.60, '2024-03-24 13:40:29', '2024-03-24 13:40:29');
INSERT INTO `orders`
VALUES (93, 13, 10009, 3, '2024-03-25 17:55:41', 25.50, 1, 25.50, '2024-03-25 17:55:41', '2024-03-25 17:55:41');
INSERT INTO `orders`
VALUES (94, 14, 10010, 1, '2024-03-26 22:10:03', 18.90, 3, 56.70, '2024-03-26 22:10:03', '2024-03-26 22:10:03');
INSERT INTO `orders`
VALUES (95, 15, 10011, 2, '2024-03-27 08:15:19', 15.80, 1, 15.80, '2024-03-27 08:15:19', '2024-03-27 08:15:19');
INSERT INTO `orders`
VALUES (96, 6, 10002, 2, '2024-03-18 10:30:15', 15.80, 3, 47.40, '2024-03-18 10:30:15', '2024-03-18 10:30:15');
INSERT INTO `orders`
VALUES (97, 7, 10003, 3, '2024-03-19 14:20:55', 25.50, 1, 25.50, '2024-03-19 14:20:55', '2024-03-19 14:20:55');
INSERT INTO `orders`
VALUES (98, 8, 10004, 1, '2024-03-20 09:45:37', 18.90, 2, 37.80, '2024-03-20 09:45:37', '2024-03-20 09:45:37');
INSERT INTO `orders`
VALUES (99, 9, 10005, 2, '2024-03-21 11:55:22', 15.80, 1, 15.80, '2024-03-21 11:55:22', '2024-03-21 11:55:22');
INSERT INTO `orders`
VALUES (100, 10, 10006, 3, '2024-03-22 16:10:48', 25.50, 3, 76.50, '2024-03-22 16:10:48', '2024-03-22 16:10:48');
INSERT INTO `orders`
VALUES (101, 11, 10007, 1, '2024-03-23 20:35:12', 18.90, 1, 18.90, '2024-03-23 20:35:12', '2024-03-23 20:35:12');
INSERT INTO `orders`
VALUES (102, 12, 10008, 2, '2024-03-24 13:40:29', 15.80, 2, 31.60, '2024-03-24 13:40:29', '2024-03-24 13:40:29');
INSERT INTO `orders`
VALUES (103, 13, 10009, 3, '2024-03-25 17:55:41', 25.50, 1, 25.50, '2024-03-25 17:55:41', '2024-03-25 17:55:41');
INSERT INTO `orders`
VALUES (104, 14, 10010, 1, '2024-03-26 22:10:03', 18.90, 3, 56.70, '2024-03-26 22:10:03', '2024-03-26 22:10:03');
INSERT INTO `orders`
VALUES (105, 15, 10011, 2, '2024-03-27 08:15:19', 15.80, 1, 15.80, '2024-03-27 08:15:19', '2024-03-27 08:15:19');
INSERT INTO `orders`
VALUES (106, 6, 10002, 2, '2024-03-18 10:30:15', 15.80, 3, 47.40, '2024-03-18 10:30:15', '2024-03-18 10:30:15');
INSERT INTO `orders`
VALUES (107, 7, 10003, 3, '2024-03-19 14:20:55', 25.50, 1, 25.50, '2024-03-19 14:20:55', '2024-03-19 14:20:55');
INSERT INTO `orders`
VALUES (108, 8, 10004, 1, '2024-03-20 09:45:37', 18.90, 2, 37.80, '2024-03-20 09:45:37', '2024-03-20 09:45:37');
INSERT INTO `orders`
VALUES (109, 9, 10005, 2, '2024-03-21 11:55:22', 15.80, 1, 15.80, '2024-03-21 11:55:22', '2024-03-21 11:55:22');
INSERT INTO `orders`
VALUES (110, 10, 10006, 3, '2024-03-22 16:10:48', 25.50, 3, 76.50, '2024-03-22 16:10:48', '2024-03-22 16:10:48');
INSERT INTO `orders`
VALUES (111, 11, 10007, 1, '2024-03-23 20:35:12', 18.90, 1, 18.90, '2024-03-23 20:35:12', '2024-03-23 20:35:12');
INSERT INTO `orders`
VALUES (112, 12, 10008, 2, '2024-03-24 13:40:29', 15.80, 2, 31.60, '2024-03-24 13:40:29', '2024-03-24 13:40:29');
INSERT INTO `orders`
VALUES (113, 13, 10009, 3, '2024-03-25 17:55:41', 25.50, 1, 25.50, '2024-03-25 17:55:41', '2024-03-25 17:55:41');
INSERT INTO `orders`
VALUES (114, 14, 10010, 1, '2024-03-26 22:10:03', 18.90, 3, 56.70, '2024-03-26 22:10:03', '2024-03-26 22:10:03');
INSERT INTO `orders`
VALUES (115, 15, 10011, 2, '2024-03-27 08:15:19', 15.80, 1, 15.80, '2024-03-27 08:15:19', '2024-03-27 08:15:19');
INSERT INTO `orders`
VALUES (116, 6, 10002, 2, '2024-03-18 10:30:15', 15.80, 3, 47.40, '2024-03-18 10:30:15', '2024-03-18 10:30:15');
INSERT INTO `orders`
VALUES (117, 7, 10003, 3, '2024-03-19 14:20:55', 25.50, 1, 25.50, '2024-03-19 14:20:55', '2024-03-19 14:20:55');
INSERT INTO `orders`
VALUES (118, 8, 10004, 1, '2024-03-20 09:45:37', 18.90, 2, 37.80, '2024-03-20 09:45:37', '2024-03-20 09:45:37');
INSERT INTO `orders`
VALUES (119, 9, 10005, 2, '2024-03-21 11:55:22', 15.80, 1, 15.80, '2024-03-21 11:55:22', '2024-03-21 11:55:22');
INSERT INTO `orders`
VALUES (120, 10, 10006, 3, '2024-03-22 16:10:48', 25.50, 3, 76.50, '2024-03-22 16:10:48', '2024-03-22 16:10:48');
INSERT INTO `orders`
VALUES (121, 11, 10007, 1, '2024-03-23 20:35:12', 18.90, 1, 18.90, '2024-03-23 20:35:12', '2024-03-23 20:35:12');
INSERT INTO `orders`
VALUES (122, 12, 10008, 2, '2024-03-24 13:40:29', 15.80, 2, 31.60, '2024-03-24 13:40:29', '2024-03-24 13:40:29');
INSERT INTO `orders`
VALUES (123, 13, 10009, 3, '2024-03-25 17:55:41', 25.50, 1, 25.50, '2024-03-25 17:55:41', '2024-03-25 17:55:41');
INSERT INTO `orders`
VALUES (124, 14, 10010, 1, '2024-03-26 22:10:03', 18.90, 3, 56.70, '2024-03-26 22:10:03', '2024-03-26 22:10:03');
INSERT INTO `orders`
VALUES (125, 15, 10011, 2, '2024-03-27 08:15:19', 15.80, 1, 15.80, '2024-03-27 08:15:19', '2024-03-27 08:15:19');

-- ----------------------------
-- Table structure for parent
-- ----------------------------
DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent`
(
    `id`          bigint(0) NOT NULL AUTO_INCREMENT,
    `img`         longblob                                                      NOT NULL COMMENT '图片',
    `type`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '人员类型',
    `parent_id`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '家长ID',
    `student_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
    `name`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '姓名',
    `password`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '密码',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '手机号',
    `sex`         varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '性别',
    `status`      int(0) NOT NULL COMMENT '账号状态',
    `create_time` datetime(0) NOT NULL COMMENT '创建时间',
    `update_time` datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `parent_id`(`parent_id`) USING BTREE,
    INDEX         `student_id`(`student_id`) USING BTREE,
    INDEX         `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parent
-- ----------------------------
INSERT INTO `parent`
VALUES (1, 0x31, '家长', '10001', '20001', '张赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (2, 0x31, '家长', '10001', '20001', '赵是六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (3, 0x31, '家长', '10001', '20001', '赵嗄六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (4, 0x31, '家长', '10001', '20001', '啊赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-28 20:27:07');
INSERT INTO `parent`
VALUES (5, 0x31, '家长', '10001', '20001', '赵1六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-28 20:27:55');
INSERT INTO `parent`
VALUES (6, 0x31, '家长', '10001', '20001', '锕赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (8, 0x31, '家长', '10001', '20001', '吃赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (9, 0x31, '家长', '10001', '20001', '阿赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (10, 0x31, '家长', '10001', '20001', '向赵六', 'password', '12345678904', '女', 1, '2024-03-23 23:08:13',
        '2024-03-23 23:08:13');
INSERT INTO `parent`
VALUES (11, 0x31, '家长', '10001', '20001', '王小明', 'password123', '13987654321', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (12, 0x31, '家长', '10001', '20001', '李小红', 'password123', '13876543210', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (13, 0x31, '家长', '10001', '20001', '张小华', 'password123', '13765432109', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (14, 0x31, '家长', '10001', '20001', '刘小杰', 'password123', '13654321098', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (15, 0x31, '家长', '10001', '20001', '陈小美', 'password123', '13543210987', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (16, 0x31, '家长', '10001', '20001', '杨小强', 'password123', '13432109876', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (17, 0x31, '家长', '10001', '20001', '吴小云', 'password123', '13321098765', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (18, 0x31, '家长', '10001', '20001', '孙小刚', 'password123', '13210987654', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (19, 0x31, '家长', '10001', '20001', '周小芳', 'password123', '13109876543', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (20, 0x31, '家长', '10001', '20001', '郑小弟', 'password123', '13098765432', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (21, 0x31, '家长', '10001', '20001', '王小明', 'password123', '13987654321', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (22, 0x31, '家长', '10001', '20001', '李小红', 'password123', '13876543210', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (23, 0x31, '家长', '10001', '20001', '张小华', 'password123', '13765432109', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (24, 0x31, '家长', '10001', '20001', '刘小杰', 'password123', '13654321098', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (25, 0x31, '家长', '10001', '20001', '陈小美', 'password123', '13543210987', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (26, 0x31, '家长', '10001', '20001', '杨小强', 'password123', '13432109876', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (27, 0x31, '家长', '10001', '20001', '吴小云', 'password123', '13321098765', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (28, 0x31, '家长', '10001', '20001', '孙小刚', 'password123', '13210987654', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (29, 0x31, '家长', '10001', '20001', '周小芳', 'password123', '13109876543', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (30, 0x31, '家长', '10001', '20001', '郑小弟', 'password123', '13098765432', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (31, 0x31, '家长', '10001', '20001', '王小明', 'password123', '13987654321', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (32, 0x31, '家长', '10001', '20001', '李小红', 'password123', '13876543210', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (33, 0x31, '家长', '10001', '20001', '张小华', 'password123', '13765432109', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (34, 0x31, '家长', '10001', '20001', '刘小杰', 'password123', '13654321098', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (35, 0x31, '家长', '10001', '20001', '陈小美', 'password123', '13543210987', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (36, 0x31, '家长', '10001', '20001', '杨小强', 'password123', '13432109876', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (37, 0x31, '家长', '10001', '20001', '吴小云', 'password123', '13321098765', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (38, 0x31, '家长', '10001', '20001', '孙小刚', 'password123', '13210987654', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (39, 0x31, '家长', '10001', '20001', '周小芳', 'password123', '13109876543', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (40, 0x31, '家长', '10001', '20001', '郑小弟', 'password123', '13098765432', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (41, 0x31, '家长', '10001', '20001', '王小明', 'password123', '13987654321', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (42, 0x31, '家长', '10001', '20001', '李小红', 'password123', '13876543210', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (43, 0x31, '家长', '10001', '20001', '张小华', 'password123', '13765432109', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (44, 0x31, '家长', '10001', '20001', '刘小杰', 'password123', '13654321098', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (45, 0x31, '家长', '10001', '20001', '陈小美', 'password123', '13543210987', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (46, 0x31, '家长', '10001', '20001', '杨小强', 'password123', '13432109876', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (47, 0x31, '家长', '10001', '20001', '吴小云', 'password123', '13321098765', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (48, 0x31, '家长', '10001', '20001', '孙小刚', 'password123', '13210987654', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (49, 0x31, '家长', '10001', '20001', '周小芳', 'password123', '13109876543', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (50, 0x31, '家长', '10001', '20001', '郑小弟', 'password123', '13098765432', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (51, 0x31, '家长', '10001', '20001', '王小明', 'password123', '13987654321', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (52, 0x31, '家长', '10001', '20001', '李小红', 'password123', '13876543210', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (53, 0x31, '家长', '10001', '20001', '张小华', 'password123', '13765432109', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (54, 0x31, '家长', '10001', '20001', '刘小杰', 'password123', '13654321098', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (55, 0x31, '家长', '10001', '20001', '陈小美', 'password123', '13543210987', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (56, 0x31, '家长', '10001', '20001', '杨小强', 'password123', '13432109876', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (57, 0x31, '家长', '10001', '20001', '吴小云', 'password123', '13321098765', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (58, 0x31, '家长', '10001', '20001', '孙小刚', 'password123', '13210987654', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (59, 0x31, '家长', '10001', '20001', '周小芳', 'password123', '13109876543', '女', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');
INSERT INTO `parent`
VALUES (60, 0x31, '家长', '10001', '20001', '郑小弟', 'password123', '13098765432', '男', 1, '2024-03-30 10:00:00',
        '2024-03-30 10:00:00');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`
(
    `id`             bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `reservation_id` int(0) NOT NULL COMMENT '预约id',
    `user_id`        int(0) NOT NULL COMMENT '用户id',
    `staff_id`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生id',
    `time`           datetime(0) NOT NULL COMMENT '预约时间',
    `location`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点',
    `create_time`    datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`    datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX            `reservation_id`(`reservation_id`) USING BTREE,
    INDEX            `user_id`(`user_id`) USING BTREE,
    INDEX            `staff_id`(`staff_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation`
VALUES (1, 1, 20005, '50004', '2024-03-17 21:46:27', '医室', '2024-03-17 21:46:27', '2024-03-28 22:59:43');
INSERT INTO `reservation`
VALUES (3, 3, 20002, '50003', '2024-03-17 21:46:27', '医务室', '2024-03-17 21:46:27', '2024-03-17 21:46:27');
INSERT INTO `reservation`
VALUES (4, 4, 20001, '50001', '2024-03-30 10:00:00', '门诊部', '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `reservation`
VALUES (5, 5, 20002, '50002', '2024-03-30 11:00:00', '急诊科', '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `reservation`
VALUES (6, 6, 20003, '50003', '2024-03-30 12:00:00', '内科门诊', '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `reservation`
VALUES (7, 7, 20004, '50004', '2024-03-30 13:00:00', '外科门诊', '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `reservation`
VALUES (8, 8, 20005, '50005', '2024-03-30 14:00:00', '儿科门诊', '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `reservation`
VALUES (9, 9, 20006, '50006', '2024-03-30 15:00:00', '妇产科门诊', '2024-03-30 15:00:00', '2024-03-30 15:00:00');
INSERT INTO `reservation`
VALUES (10, 10, 20007, '50007', '2024-03-30 16:00:00', '眼科门诊', '2024-03-30 16:00:00', '2024-03-30 16:00:00');
INSERT INTO `reservation`
VALUES (11, 11, 20008, '50008', '2024-03-30 17:00:00', '耳鼻喉科门诊', '2024-03-30 17:00:00', '2024-03-30 17:00:00');
INSERT INTO `reservation`
VALUES (12, 12, 20009, '50009', '2024-03-30 18:00:00', '口腔科门诊', '2024-03-30 18:00:00', '2024-03-30 18:00:00');
INSERT INTO `reservation`
VALUES (13, 13, 20010, '50010', '2024-03-30 19:00:00', '皮肤科门诊', '2024-03-30 19:00:00', '2024-03-30 19:00:00');
INSERT INTO `reservation`
VALUES (14, 4, 20001, '50001', '2024-03-30 10:00:00', '门诊部', '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `reservation`
VALUES (15, 5, 20002, '50002', '2024-03-30 11:00:00', '急诊科', '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `reservation`
VALUES (16, 6, 20003, '50003', '2024-03-30 12:00:00', '内科门诊', '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `reservation`
VALUES (17, 7, 20004, '50004', '2024-03-30 13:00:00', '外科门诊', '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `reservation`
VALUES (18, 8, 20005, '50005', '2024-03-30 14:00:00', '儿科门诊', '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `reservation`
VALUES (19, 9, 20006, '50006', '2024-03-30 15:00:00', '妇产科门诊', '2024-03-30 15:00:00', '2024-03-30 15:00:00');
INSERT INTO `reservation`
VALUES (20, 10, 20007, '50007', '2024-03-30 16:00:00', '眼科门诊', '2024-03-30 16:00:00', '2024-03-30 16:00:00');
INSERT INTO `reservation`
VALUES (21, 11, 20008, '50008', '2024-03-30 17:00:00', '耳鼻喉科门诊', '2024-03-30 17:00:00', '2024-03-30 17:00:00');
INSERT INTO `reservation`
VALUES (22, 12, 20009, '50009', '2024-03-30 18:00:00', '口腔科门诊', '2024-03-30 18:00:00', '2024-03-30 18:00:00');
INSERT INTO `reservation`
VALUES (23, 13, 20010, '50010', '2024-03-30 19:00:00', '皮肤科门诊', '2024-03-30 19:00:00', '2024-03-30 19:00:00');
INSERT INTO `reservation`
VALUES (24, 4, 20001, '50001', '2024-03-30 10:00:00', '门诊部', '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `reservation`
VALUES (25, 5, 20002, '50002', '2024-03-30 11:00:00', '急诊科', '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `reservation`
VALUES (26, 6, 20003, '50003', '2024-03-30 12:00:00', '内科门诊', '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `reservation`
VALUES (27, 7, 20004, '50004', '2024-03-30 13:00:00', '外科门诊', '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `reservation`
VALUES (28, 8, 20005, '50005', '2024-03-30 14:00:00', '儿科门诊', '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `reservation`
VALUES (29, 9, 20006, '50006', '2024-03-30 15:00:00', '妇产科门诊', '2024-03-30 15:00:00', '2024-03-30 15:00:00');
INSERT INTO `reservation`
VALUES (30, 10, 20007, '50007', '2024-03-30 16:00:00', '眼科门诊', '2024-03-30 16:00:00', '2024-03-30 16:00:00');
INSERT INTO `reservation`
VALUES (31, 11, 20008, '50008', '2024-03-30 17:00:00', '耳鼻喉科门诊', '2024-03-30 17:00:00', '2024-03-30 17:00:00');
INSERT INTO `reservation`
VALUES (32, 12, 20009, '50009', '2024-03-30 18:00:00', '口腔科门诊', '2024-03-30 18:00:00', '2024-03-30 18:00:00');
INSERT INTO `reservation`
VALUES (33, 13, 20010, '50010', '2024-03-30 19:00:00', '皮肤科门诊', '2024-03-30 19:00:00', '2024-03-30 19:00:00');
INSERT INTO `reservation`
VALUES (34, 4, 20001, '50001', '2024-03-30 10:00:00', '门诊部', '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `reservation`
VALUES (35, 5, 20002, '50002', '2024-03-30 11:00:00', '急诊科', '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `reservation`
VALUES (36, 6, 20003, '50003', '2024-03-30 12:00:00', '内科门诊', '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `reservation`
VALUES (37, 7, 20004, '50004', '2024-03-30 13:00:00', '外科门诊', '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `reservation`
VALUES (38, 8, 20005, '50005', '2024-03-30 14:00:00', '儿科门诊', '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `reservation`
VALUES (39, 9, 20006, '50006', '2024-03-30 15:00:00', '妇产科门诊', '2024-03-30 15:00:00', '2024-03-30 15:00:00');
INSERT INTO `reservation`
VALUES (40, 10, 20007, '50007', '2024-03-30 16:00:00', '眼科门诊', '2024-03-30 16:00:00', '2024-03-30 16:00:00');
INSERT INTO `reservation`
VALUES (41, 11, 20008, '50008', '2024-03-30 17:00:00', '耳鼻喉科门诊', '2024-03-30 17:00:00', '2024-03-30 17:00:00');
INSERT INTO `reservation`
VALUES (42, 12, 20009, '50009', '2024-03-30 18:00:00', '口腔科门诊', '2024-03-30 18:00:00', '2024-03-30 18:00:00');
INSERT INTO `reservation`
VALUES (43, 13, 20010, '50010', '2024-03-30 19:00:00', '皮肤科门诊', '2024-03-30 19:00:00', '2024-03-30 19:00:00');
INSERT INTO `reservation`
VALUES (44, 4, 20001, '50001', '2024-03-30 10:00:00', '门诊部', '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `reservation`
VALUES (45, 5, 20002, '50002', '2024-03-30 11:00:00', '急诊科', '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `reservation`
VALUES (46, 6, 20003, '50003', '2024-03-30 12:00:00', '内科门诊', '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `reservation`
VALUES (47, 7, 20004, '50004', '2024-03-30 13:00:00', '外科门诊', '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `reservation`
VALUES (48, 8, 20005, '50005', '2024-03-30 14:00:00', '儿科门诊', '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `reservation`
VALUES (49, 9, 20006, '50006', '2024-03-30 15:00:00', '妇产科门诊', '2024-03-30 15:00:00', '2024-03-30 15:00:00');
INSERT INTO `reservation`
VALUES (50, 10, 20007, '50007', '2024-03-30 16:00:00', '眼科门诊', '2024-03-30 16:00:00', '2024-03-30 16:00:00');
INSERT INTO `reservation`
VALUES (51, 11, 20008, '50008', '2024-03-30 17:00:00', '耳鼻喉科门诊', '2024-03-30 17:00:00', '2024-03-30 17:00:00');
INSERT INTO `reservation`
VALUES (52, 12, 20009, '50009', '2024-03-30 18:00:00', '口腔科门诊', '2024-03-30 18:00:00', '2024-03-30 18:00:00');
INSERT INTO `reservation`
VALUES (53, 13, 20010, '50010', '2024-03-30 19:00:00', '皮肤科门诊', '2024-03-30 19:00:00', '2024-03-30 19:00:00');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`
(
    `id`          bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `staff_id`    int(0) NOT NULL COMMENT '员工ID',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
    `sex`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
    `birth`       date                                                          NOT NULL COMMENT '出生日期',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '联系电话',
    `location`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位地点',
    `is_active`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否在职',
    `note`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime(0) NOT NULL COMMENT '创建时间',
    `update_time` datetime(0) NOT NULL COMMENT '最后修改时间',
    `img`         longblob NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `staff_id`(`staff_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff`
VALUES (1, 50001, '校张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (2, 50002, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (3, 50003, '校医张', '男', '1990-01-01', '123478911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (4, 50004, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x3131);
INSERT INTO `staff`
VALUES (5, 50005, '校医张', '男', '1990-01-01', '123458911', '医务室', '休假', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (7, 50007, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (8, 50008, '校医张', '男', '1990-01-01', '123478911', '医务室', '休假', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (9, 50009, '校医张', '男', '1990-01-01', '123478911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (10, 50010, '校医张', '男', '1990-01-01', '123458911', '医务室', '在职', '暂无', '2024-03-20 17:08:05',
        '2024-03-20 17:08:05', 0x31);
INSERT INTO `staff`
VALUES (11, 50011, '张三', '男', '1995-05-15', '13812345678', '行政办公室', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (12, 50012, '李四', '女', '1992-09-25', '13987654321', '财务部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (13, 50013, '王五', '男', '1988-12-03', '13798765432', '人力资源部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (14, 50014, '赵六', '女', '1993-07-18', '13567894567', '市场部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (15, 50015, '刘七', '男', '1990-02-10', '13678901234', '技术部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (16, 50016, '陈八', '男', '1991-11-20', '13209876543', '客服部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (17, 50017, '张九', '女', '1989-04-30', '13398765432', '市场部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (18, 50018, '李十', '男', '1987-08-08', '13012345678', '技术部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (19, 50019, '王十一', '女', '1994-06-22', '13123456789', '客服部', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (20, 50020, '赵十二', '男', '1996-03-05', '13456789012', '行政办公室', '在职', NULL, '2024-03-30 20:17:36',
        '2024-03-30 20:17:36', NULL);
INSERT INTO `staff`
VALUES (21, 50011, '张三', '男', '1995-05-15', '13812345678', '行政办公室', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (22, 50012, '李四', '女', '1992-09-25', '13987654321', '财务部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (23, 50013, '王五', '男', '1988-12-03', '13798765432', '人力资源部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (24, 50014, '赵六', '女', '1993-07-18', '13567894567', '市场部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (25, 50015, '刘七', '男', '1990-02-10', '13678901234', '技术部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (26, 50016, '陈八', '男', '1991-11-20', '13209876543', '客服部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (27, 50017, '张九', '女', '1989-04-30', '13398765432', '市场部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (28, 50018, '李十', '男', '1987-08-08', '13012345678', '技术部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (29, 50019, '王十一', '女', '1994-06-22', '13123456789', '客服部', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (30, 50020, '赵十二', '男', '1996-03-05', '13456789012', '行政办公室', '在职', NULL, '2024-03-30 20:17:38',
        '2024-03-30 20:17:38', NULL);
INSERT INTO `staff`
VALUES (31, 50011, '张三', '男', '1995-05-15', '13812345678', '行政办公室', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (32, 50012, '李四', '女', '1992-09-25', '13987654321', '财务部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (33, 50013, '王五', '男', '1988-12-03', '13798765432', '人力资源部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (34, 50014, '赵六', '女', '1993-07-18', '13567894567', '市场部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (35, 50015, '刘七', '男', '1990-02-10', '13678901234', '技术部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (36, 50016, '陈八', '男', '1991-11-20', '13209876543', '客服部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (37, 50017, '张九', '女', '1989-04-30', '13398765432', '市场部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (38, 50018, '李十', '男', '1987-08-08', '13012345678', '技术部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (39, 50019, '王十一', '女', '1994-06-22', '13123456789', '客服部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (40, 50020, '赵十二', '男', '1996-03-05', '13456789012', '行政办公室', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (41, 50011, '张三', '男', '1995-05-15', '13812345678', '行政办公室', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (42, 50012, '李四', '女', '1992-09-25', '13987654321', '财务部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (43, 50013, '王五', '男', '1988-12-03', '13798765432', '人力资源部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (44, 50014, '赵六', '女', '1993-07-18', '13567894567', '市场部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (45, 50015, '刘七', '男', '1990-02-10', '13678901234', '技术部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (46, 50016, '陈八', '男', '1991-11-20', '13209876543', '客服部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (47, 50017, '张九', '女', '1989-04-30', '13398765432', '市场部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (48, 50018, '李十', '男', '1987-08-08', '13012345678', '技术部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (49, 50019, '王十一', '女', '1994-06-22', '13123456789', '客服部', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (50, 50020, '赵十二', '男', '1996-03-05', '13456789012', '行政办公室', '在职', NULL, '2024-03-30 20:17:39',
        '2024-03-30 20:17:39', NULL);
INSERT INTO `staff`
VALUES (51, 50011, '张三', '男', '1995-05-15', '13812345678', '行政办公室', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (52, 50012, '李四', '女', '1992-09-25', '13987654321', '财务部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (53, 50013, '王五', '男', '1988-12-03', '13798765432', '人力资源部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (54, 50014, '赵六', '女', '1993-07-18', '13567894567', '市场部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (55, 50015, '刘七', '男', '1990-02-10', '13678901234', '技术部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (56, 50016, '陈八', '男', '1991-11-20', '13209876543', '客服部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (57, 50017, '张九', '女', '1989-04-30', '13398765432', '市场部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (58, 50018, '李十', '男', '1987-08-08', '13012345678', '技术部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (59, 50019, '王十一', '女', '1994-06-22', '13123456789', '客服部', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);
INSERT INTO `staff`
VALUES (60, 50020, '赵十二', '男', '1996-03-05', '13456789012', '行政办公室', '在职', NULL, '2024-03-30 20:17:40',
        '2024-03-30 20:17:40', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`          bigint(0) NOT NULL AUTO_INCREMENT,
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
    `status`      int(0) NOT NULL COMMENT '账号状态',
    `create_time` datetime(0) NOT NULL COMMENT '创建时间',
    `update_time` datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `device_id`(`device_id`) USING BTREE,
    INDEX         `parent_id`(`parent_id`) USING BTREE,
    INDEX         `student_id`(`student_id`) USING BTREE,
    INDEX         `teacher_id`(`teacher_id`) USING BTREE,
    INDEX         `clazz`(`clazz`) USING BTREE,
    INDEX         `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES (3, 0x31, '学生', '高中部', 'dev003', '2022-03-10', '10001', '20001', '30001', '高三2班', '黄林峰', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 16:26:07');
INSERT INTO `student`
VALUES (4, 0x31, '学生', '高中部', 'dev004', '2022-03-10', '10001', '20001', '30001', '高三1班', '迪丽热巴', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (5, 0x31, '学生', '高中部', 'dev005', '2022-03-10', '10001', '20001', '30001', '高三2班', '王宝强', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (6, 0x31, '学生', '高中部', 'dev006', '2022-03-10', '10001', '20001', '30001', '高三1班', '王二狗', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (7, 0x31, '学生', '高中部', 'dev007', '2022-03-10', '10001', '20001', '30001', '高三3班', '李大钊', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (8, 0x31, '学生', '高中部', 'dev008', '2022-03-10', '10001', '20001', '30001', '高三3班', '胡适', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (9, 0x31, '学生', '高中部', 'dev009', '2022-03-10', '10001', '20001', '30001', '高三1班', '周星驰', 'password',
        '12345678901', '男', 1, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (10, 0x31, '学生', '高中部', 'dev010', '2022-03-10', '10001', '20001', '30001', '高三4班', '陈龙', 'password',
        '12345678901', '男', 0, '2024-03-26 08:56:31', '2024-03-26 08:56:31');
INSERT INTO `student`
VALUES (12, 0x31, '学生', '高中部', 'dev5168', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生86', 'password',
        '1373090671', '男', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (13, 0x31, '学生', '高中部', 'dev6722', '2006-01-01', '10001', '20001', '30001', '高三4班', '学生23', 'password',
        '1333138727', '男', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (14, 0x31, '学生', '高中部', 'dev3325', '2006-01-01', '10001', '20001', '30001', '高三4班', '学生24', 'password',
        '1332111703', '男', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (15, 0x31, '学生', '高中部', 'dev8716', '2006-01-01', '10001', '20001', '30001', '高三4班', '学生28', 'password',
        '1314793332', '女', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (16, 0x31, '学生', '高中部', 'dev1180', '2006-01-01', '10001', '20001', '30001', '高三4班', '学生45', 'password',
        '1339655737', '女', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (17, 0x31, '学生', '高中部', 'dev5672', '2006-01-01', '10001', '20001', '30001', '高三2班', '学生74', 'password',
        '1354881252', '女', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (18, 0x31, '学生', '高中部', 'dev8937', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生2', 'password',
        '1362709589', '男', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (19, 0x31, '学生', '高中部', 'dev7362', '2006-01-01', '10001', '20001', '30001', '高三3班', '学生79', 'password',
        '1385952828', '男', 1, '2024-03-30 20:37:43', '2024-03-30 20:37:43');
INSERT INTO `student`
VALUES (27, 0x31, '学生', '高中部', 'dev7633', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生72', 'password',
        '1322678768', '男', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (28, 0x31, '学生', '高中部', 'dev4035', '2006-01-01', '10001', '20001', '30001', '高三3班', '学生40', 'password',
        '1314281864', '女', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (29, 0x31, '学生', '高中部', 'dev1617', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生87', 'password',
        '1338268798', '男', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (30, 0x31, '学生', '高中部', 'dev8899', '2006-01-01', '10001', '20001', '30001', '高三2班', '学生1', 'password',
        '1333349583', '女', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (31, 0x31, '学生', '高中部', 'dev6417', '2006-01-01', '10001', '20001', '30001', '高三3班', '学生72', 'password',
        '1311238107', '男', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (32, 0x31, '学生', '高中部', 'dev6007', '2006-01-01', '10001', '20001', '30001', '高三2班', '学生90', 'password',
        '1315187516', '男', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (33, 0x31, '学生', '高中部', 'dev8160', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生85', 'password',
        '1362802343', '女', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (34, 0x31, '学生', '高中部', 'dev3389', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生20', 'password',
        '1364000842', '女', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (35, 0x31, '学生', '高中部', 'dev3038', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生27', 'password',
        '1311088900', '女', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (36, 0x31, '学生', '高中部', 'dev2962', '2006-01-01', '10001', '20001', '30001', '高三3班', '学生98', 'password',
        '1382473058', '女', 1, '2024-03-30 20:38:27', '2024-03-30 20:38:27');
INSERT INTO `student`
VALUES (42, 0x31, '学生', '高中部', 'dev1789', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生87', 'password',
        '1378201847', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (43, 0x31, '学生', '高中部', 'dev7509', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生45', 'password',
        '1325068726', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (44, 0x31, '学生', '高中部', 'dev9612', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生73', 'password',
        '1397418244', '男', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (45, 0x31, '学生', '高中部', 'dev5843', '2006-01-01', '10001', '20001', '30001', '高三2班', '学生6', 'password',
        '1331635148', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (46, 0x31, '学生', '高中部', 'dev4995', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生91', 'password',
        '1397845551', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (47, 0x31, '学生', '高中部', 'dev9292', '2006-01-01', '10001', '20001', '30001', '高三2班', '学生13', 'password',
        '1342427096', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (48, 0x31, '学生', '高中部', 'dev2135', '2006-01-01', '10001', '20001', '30001', '高三4班', '学生43', 'password',
        '1377977036', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (49, 0x31, '学生', '高中部', 'dev2593', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生11', 'password',
        '1314256831', '男', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (50, 0x31, '学生', '高中部', 'dev4686', '2006-01-01', '10001', '20001', '30001', '高三1班', '学生93', 'password',
        '1345360330', '女', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');
INSERT INTO `student`
VALUES (51, 0x31, '学生', '高中部', 'dev7363', '2006-01-01', '10001', '20001', '30001', '高三3班', '学生12', 'password',
        '1350335750', '男', 1, '2024-03-30 20:39:40', '2024-03-30 20:39:40');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `id`                bigint(0) NOT NULL AUTO_INCREMENT,
    `img`               longblob                                                      NOT NULL COMMENT '图片',
    `type`              varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '人员类型',
    `device_id`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '设备ID',
    `birth`             date                                                          NOT NULL COMMENT '出生日期',
    `clazz`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `teacher_id`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师工号',
    `post`              varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '岗位',
    `name`              varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '姓名',
    `password`          varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '密码',
    `phone`             varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '手机号',
    `sex`               varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '性别',
    `emergency_contact` int(0) NOT NULL COMMENT '紧急联系人员',
    `status`            int(0) NOT NULL COMMENT '账号状态',
    `create_time`       datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`       datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX               `device_id`(`device_id`) USING BTREE,
    INDEX               `teacher_id`(`teacher_id`) USING BTREE,
    INDEX               `post`(`post`) USING BTREE,
    INDEX               `phone`(`phone`) USING BTREE,
    INDEX               `emergency_contact`(`emergency_contact`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher`
VALUES (1, 0x31, '老师', 'dev321', '1998-01-01', '高三1班', '30001', '班主任', '李老师', 'password', '12345678902',
        '女', 0, 1, '2024-03-23 23:12:03', '2024-03-26 22:01:35');
INSERT INTO `teacher`
VALUES (2, 0x31, '老师', 'dev323', '1998-01-01', '暂无', '30001', '普通教师', '张老师', 'password', '12345678902', '女',
        1, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (3, 0x31, '老师', 'dev123', '1998-01-01', '暂无', '30001', '普通教师', '王老师', 'password', '12345678902', '女',
        0, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (4, 0x31, '老师', 'dev432', '1998-01-01', '高三2班', '30001', '班主任', '陈老师', 'password', '12345678902',
        '女', 0, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (7, 0x31, '老师', 'dev868', '1998-01-01', '暂无', '30001', '教务处', '黄老师', 'password', '12345678902', '女',
        0, 0, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (8, 0x31, '老师', 'dev456', '1998-01-01', '暂无', '30001', '教务处', '赵老师', 'password', '12345678902', '女',
        1, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (9, 0x31, '老师', 'dev564', '1998-01-01', '暂无', '30001', '普通教师', '谢老师', 'password', '12345678902', '女',
        0, 0, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (10, 0x31, '老师', 'dev054', '1998-01-01', '暂无', '30001', '教务处', '成老师', 'password', '12345678902', '女',
        1, 1, '2024-03-23 23:12:03', '2024-03-23 23:12:03');
INSERT INTO `teacher`
VALUES (11, 0x31, '老师', 'dev456', '1995-05-15', '高三3班', '30001', '普通教师', '王小明', 'password123',
        '13987654321', '男', 1, 1, '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `teacher`
VALUES (12, 0x31, '老师', 'dev321', '1990-09-20', '高二1班', '30001', '班主任', '张丽', 'password456', '13876543210',
        '女', 2, 1, '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `teacher`
VALUES (13, 0x31, '老师', 'dev987', '1985-03-10', '高一2班', '30001', '普通教师', '李刚', 'password789', '13765432109',
        '男', 3, 0, '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `teacher`
VALUES (14, 0x31, '老师', 'dev789', '1988-07-25', '暂无', '30001', '普通教师', '刘芳', 'passwordabc', '13654321098',
        '女', 4, 1, '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `teacher`
VALUES (15, 0x31, '老师', 'dev654', '1993-11-02', '高三1班', '30001', '班主任', '王伟', 'passworddef', '13543210987',
        '男', 5, 0, '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `teacher`
VALUES (16, 0x31, '老师', 'dev123', '1992-04-18', '高二3班', '30001', '普通教师', '张晓', 'passwordghi', '13432109876',
        '女', 6, 1, '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `teacher`
VALUES (17, 0x31, '老师', 'dev345', '1987-08-09', '高一1班', '30001', '班主任', '李雷', 'passwordjkl', '13321098765',
        '男', 7, 0, '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `teacher`
VALUES (18, 0x31, '老师', 'dev567', '1991-12-05', '高三2班', '30001', '普通教师', '刘雨', 'passwordmno', '13210987654',
        '女', 8, 1, '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `teacher`
VALUES (19, 0x31, '老师', 'dev890', '1986-06-21', '高二2班', '30001', '班主任', '王强', 'passwordpqr', '13109876543',
        '男', 9, 0, '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `teacher`
VALUES (20, 0x31, '老师', 'dev432', '1994-10-14', '暂无', '30001', '普通教师', '张阳', 'passwordstu', '13098765432',
        '男', 10, 1, '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `teacher`
VALUES (21, 0x31, '老师', 'dev456', '1995-05-15', '高三3班', '30001', '普通教师', '王小明', 'password123',
        '13987654321', '男', 1, 1, '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `teacher`
VALUES (22, 0x31, '老师', 'dev321', '1990-09-20', '高二1班', '30001', '班主任', '张丽', 'password456', '13876543210',
        '女', 2, 1, '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `teacher`
VALUES (23, 0x31, '老师', 'dev987', '1985-03-10', '高一2班', '30001', '普通教师', '李刚', 'password789', '13765432109',
        '男', 3, 0, '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `teacher`
VALUES (24, 0x31, '老师', 'dev789', '1988-07-25', '暂无', '30001', '普通教师', '刘芳', 'passwordabc', '13654321098',
        '女', 4, 1, '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `teacher`
VALUES (25, 0x31, '老师', 'dev654', '1993-11-02', '高三1班', '30001', '班主任', '王伟', 'passworddef', '13543210987',
        '男', 5, 0, '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `teacher`
VALUES (26, 0x31, '老师', 'dev123', '1992-04-18', '高二3班', '30001', '普通教师', '张晓', 'passwordghi', '13432109876',
        '女', 6, 1, '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `teacher`
VALUES (27, 0x31, '老师', 'dev345', '1987-08-09', '高一1班', '30001', '班主任', '李雷', 'passwordjkl', '13321098765',
        '男', 7, 0, '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `teacher`
VALUES (28, 0x31, '老师', 'dev567', '1991-12-05', '高三2班', '30001', '普通教师', '刘雨', 'passwordmno', '13210987654',
        '女', 8, 1, '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `teacher`
VALUES (29, 0x31, '老师', 'dev890', '1986-06-21', '高二2班', '30001', '班主任', '王强', 'passwordpqr', '13109876543',
        '男', 9, 0, '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `teacher`
VALUES (30, 0x31, '老师', 'dev432', '1994-10-14', '暂无', '30001', '普通教师', '张阳', 'passwordstu', '13098765432',
        '男', 10, 1, '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `teacher`
VALUES (31, 0x31, '老师', 'dev456', '1995-05-15', '高三3班', '30001', '普通教师', '王小明', 'password123',
        '13987654321', '男', 1, 1, '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `teacher`
VALUES (32, 0x31, '老师', 'dev321', '1990-09-20', '高二1班', '30001', '班主任', '张丽', 'password456', '13876543210',
        '女', 2, 1, '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `teacher`
VALUES (33, 0x31, '老师', 'dev987', '1985-03-10', '高一2班', '30001', '普通教师', '李刚', 'password789', '13765432109',
        '男', 3, 0, '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `teacher`
VALUES (34, 0x31, '老师', 'dev789', '1988-07-25', '暂无', '30001', '普通教师', '刘芳', 'passwordabc', '13654321098',
        '女', 4, 1, '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `teacher`
VALUES (35, 0x31, '老师', 'dev654', '1993-11-02', '高三1班', '30001', '班主任', '王伟', 'passworddef', '13543210987',
        '男', 5, 0, '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `teacher`
VALUES (36, 0x31, '老师', 'dev123', '1992-04-18', '高二3班', '30001', '普通教师', '张晓', 'passwordghi', '13432109876',
        '女', 6, 1, '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `teacher`
VALUES (37, 0x31, '老师', 'dev345', '1987-08-09', '高一1班', '30001', '班主任', '李雷', 'passwordjkl', '13321098765',
        '男', 7, 0, '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `teacher`
VALUES (38, 0x31, '老师', 'dev567', '1991-12-05', '高三2班', '30001', '普通教师', '刘雨', 'passwordmno', '13210987654',
        '女', 8, 1, '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `teacher`
VALUES (39, 0x31, '老师', 'dev890', '1986-06-21', '高二2班', '30001', '班主任', '王强', 'passwordpqr', '13109876543',
        '男', 9, 0, '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `teacher`
VALUES (40, 0x31, '老师', 'dev432', '1994-10-14', '暂无', '30001', '普通教师', '张阳', 'passwordstu', '13098765432',
        '男', 10, 1, '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `teacher`
VALUES (41, 0x31, '老师', 'dev456', '1995-05-15', '高三3班', '30001', '普通教师', '王小明', 'password123',
        '13987654321', '男', 1, 1, '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `teacher`
VALUES (42, 0x31, '老师', 'dev321', '1990-09-20', '高二1班', '30001', '班主任', '张丽', 'password456', '13876543210',
        '女', 2, 1, '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `teacher`
VALUES (43, 0x31, '老师', 'dev987', '1985-03-10', '高一2班', '30001', '普通教师', '李刚', 'password789', '13765432109',
        '男', 3, 0, '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `teacher`
VALUES (44, 0x31, '老师', 'dev789', '1988-07-25', '暂无', '30001', '普通教师', '刘芳', 'passwordabc', '13654321098',
        '女', 4, 1, '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `teacher`
VALUES (45, 0x31, '老师', 'dev654', '1993-11-02', '高三1班', '30001', '班主任', '王伟', 'passworddef', '13543210987',
        '男', 5, 0, '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `teacher`
VALUES (46, 0x31, '老师', 'dev123', '1992-04-18', '高二3班', '30001', '普通教师', '张晓', 'passwordghi', '13432109876',
        '女', 6, 1, '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `teacher`
VALUES (47, 0x31, '老师', 'dev345', '1987-08-09', '高一1班', '30001', '班主任', '李雷', 'passwordjkl', '13321098765',
        '男', 7, 0, '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `teacher`
VALUES (48, 0x31, '老师', 'dev567', '1991-12-05', '高三2班', '30001', '普通教师', '刘雨', 'passwordmno', '13210987654',
        '女', 8, 1, '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `teacher`
VALUES (49, 0x31, '老师', 'dev890', '1986-06-21', '高二2班', '30001', '班主任', '王强', 'passwordpqr', '13109876543',
        '男', 9, 0, '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `teacher`
VALUES (50, 0x31, '老师', 'dev432', '1994-10-14', '暂无', '30001', '普通教师', '张阳', 'passwordstu', '13098765432',
        '男', 10, 1, '2024-03-30 14:30:00', '2024-03-30 14:30:00');
INSERT INTO `teacher`
VALUES (51, 0x31, '老师', 'dev456', '1995-05-15', '高三3班', '30001', '普通教师', '王小明', 'password123',
        '13987654321', '男', 1, 1, '2024-03-30 10:00:00', '2024-03-30 10:00:00');
INSERT INTO `teacher`
VALUES (52, 0x31, '老师', 'dev321', '1990-09-20', '高二1班', '30001', '班主任', '张丽', 'password456', '13876543210',
        '女', 2, 1, '2024-03-30 10:30:00', '2024-03-30 10:30:00');
INSERT INTO `teacher`
VALUES (53, 0x31, '老师', 'dev987', '1985-03-10', '高一2班', '30001', '普通教师', '李刚', 'password789', '13765432109',
        '男', 3, 0, '2024-03-30 11:00:00', '2024-03-30 11:00:00');
INSERT INTO `teacher`
VALUES (54, 0x31, '老师', 'dev789', '1988-07-25', '暂无', '30001', '普通教师', '刘芳', 'passwordabc', '13654321098',
        '女', 4, 1, '2024-03-30 11:30:00', '2024-03-30 11:30:00');
INSERT INTO `teacher`
VALUES (55, 0x31, '老师', 'dev654', '1993-11-02', '高三1班', '30001', '班主任', '王伟', 'passworddef', '13543210987',
        '男', 5, 0, '2024-03-30 12:00:00', '2024-03-30 12:00:00');
INSERT INTO `teacher`
VALUES (56, 0x31, '老师', 'dev123', '1992-04-18', '高二3班', '30001', '普通教师', '张晓', 'passwordghi', '13432109876',
        '女', 6, 1, '2024-03-30 12:30:00', '2024-03-30 12:30:00');
INSERT INTO `teacher`
VALUES (57, 0x31, '老师', 'dev345', '1987-08-09', '高一1班', '30001', '班主任', '李雷', 'passwordjkl', '13321098765',
        '男', 7, 0, '2024-03-30 13:00:00', '2024-03-30 13:00:00');
INSERT INTO `teacher`
VALUES (58, 0x31, '老师', 'dev567', '1991-12-05', '高三2班', '30001', '普通教师', '刘雨', 'passwordmno', '13210987654',
        '女', 8, 1, '2024-03-30 13:30:00', '2024-03-30 13:30:00');
INSERT INTO `teacher`
VALUES (59, 0x31, '老师', 'dev890', '1986-06-21', '高二2班', '30001', '班主任', '王强', 'passwordpqr', '13109876543',
        '男', 9, 0, '2024-03-30 14:00:00', '2024-03-30 14:00:00');
INSERT INTO `teacher`
VALUES (60, 0x31, '老师', 'dev432', '1994-10-14', '暂无', '30001', '普通教师', '张阳', 'passwordstu', '13098765432',
        '男', 10, 1, '2024-03-30 14:30:00', '2024-03-30 14:30:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
    `account`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
    `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
    `role`     int(0) NOT NULL COMMENT '1系统管理员,2学校教务处',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '系统管理员', 'admin', 'admin', 1);
INSERT INTO `user`
VALUES (2, '用户11', 'user85', 'password', 1);
INSERT INTO `user`
VALUES (3, '用户1', 'user1', 'password', 1);
INSERT INTO `user`
VALUES (4, '用户2', 'user2', 'password', 2);
INSERT INTO `user`
VALUES (5, '用户3', 'user3', 'password', 1);
INSERT INTO `user`
VALUES (6, '用户4', 'user4', 'password', 2);
INSERT INTO `user`
VALUES (7, '用户5', 'user5', 'password', 1);
INSERT INTO `user`
VALUES (8, '用户6', 'user6', 'password', 2);
INSERT INTO `user`
VALUES (9, '用户7', 'user7', 'password', 1);
INSERT INTO `user`
VALUES (10, '用户8', 'user8', 'password', 2);
INSERT INTO `user`
VALUES (11, '用户9', 'user9', 'password', 1);
INSERT INTO `user`
VALUES (12, '用户10', 'user10', 'password', 2);
INSERT INTO `user`
VALUES (13, '用户1', 'user1', 'password', 1);
INSERT INTO `user`
VALUES (14, '用户2', 'user2', 'password', 2);
INSERT INTO `user`
VALUES (15, '用户3', 'user3', 'password', 1);
INSERT INTO `user`
VALUES (16, '用户4', 'user4', 'password', 2);
INSERT INTO `user`
VALUES (17, '用户5', 'user5', 'password', 1);
INSERT INTO `user`
VALUES (18, '用户6', 'user6', 'password', 2);
INSERT INTO `user`
VALUES (19, '用户7', 'user7', 'password', 1);
INSERT INTO `user`
VALUES (20, '用户8', 'user8', 'password', 2);
INSERT INTO `user`
VALUES (21, '用户9', 'user9', 'password', 1);
INSERT INTO `user`
VALUES (22, '用户10', 'user10', 'password', 2);
INSERT INTO `user`
VALUES (23, '用户1', 'user1', 'password', 1);
INSERT INTO `user`
VALUES (24, '用户2', 'user2', 'password', 2);
INSERT INTO `user`
VALUES (25, '用户3', 'user3', 'password', 1);
INSERT INTO `user`
VALUES (26, '用户4', 'user4', 'password', 2);
INSERT INTO `user`
VALUES (27, '用户5', 'user5', 'password', 1);
INSERT INTO `user`
VALUES (28, '用户6', 'user6', 'password', 2);
INSERT INTO `user`
VALUES (29, '用户7', 'user7', 'password', 1);
INSERT INTO `user`
VALUES (30, '用户8', 'user8', 'password', 2);
INSERT INTO `user`
VALUES (31, '用户9', 'user9', 'password', 1);
INSERT INTO `user`
VALUES (32, '用户10', 'user10', 'password', 2);
INSERT INTO `user`
VALUES (33, '用户1', 'user1', 'password', 1);
INSERT INTO `user`
VALUES (34, '用户2', 'user2', 'password', 2);
INSERT INTO `user`
VALUES (35, '用户3', 'user3', 'password', 1);
INSERT INTO `user`
VALUES (36, '用户4', 'user4', 'password', 2);
INSERT INTO `user`
VALUES (37, '用户5', 'user5', 'password', 1);
INSERT INTO `user`
VALUES (38, '用户6', 'user6', 'password', 2);
INSERT INTO `user`
VALUES (39, '用户7', 'user7', 'password', 1);
INSERT INTO `user`
VALUES (40, '用户8', 'user8', 'password', 2);
INSERT INTO `user`
VALUES (41, '用户9', 'user9', 'password', 1);
INSERT INTO `user`
VALUES (42, '用户10', 'user10', 'password', 2);
INSERT INTO `user`
VALUES (43, '用户1', 'user1', 'password', 1);
INSERT INTO `user`
VALUES (44, '用户2', 'user2', 'password', 2);
INSERT INTO `user`
VALUES (45, '用户3', 'user3', 'password', 1);
INSERT INTO `user`
VALUES (46, '用户4', 'user4', 'password', 2);
INSERT INTO `user`
VALUES (47, '用户5', 'user5', 'password', 1);
INSERT INTO `user`
VALUES (48, '用户6', 'user6', 'password', 2);
INSERT INTO `user`
VALUES (49, '用户7', 'user7', 'password', 1);
INSERT INTO `user`
VALUES (50, '用户8', 'user8', 'password', 2);
INSERT INTO `user`
VALUES (51, '用户9', 'user9', 'password', 1);
INSERT INTO `user`
VALUES (52, '用户10', 'user10', 'password', 2);

-- ----------------------------
-- Table structure for user_health
-- ----------------------------
DROP TABLE IF EXISTS `user_health`;
CREATE TABLE `user_health`
(
    `id`                      bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`                 int(0) NOT NULL COMMENT '用户id',
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
    `create_time`             datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`             datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                     `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_health
-- ----------------------------
INSERT INTO `user_health`
VALUES (1, 20001, 170.50, 60.50, 20.50, 22.05, '偏瘦', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '0小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '75次/分钟', '90次/分钟', '60次/分钟', 98.5, '36.5°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (2, 20002, 165.50, 55.50, 18.50, 20.95, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '6.5小时', '1小时',
        '22:30', '07:30', '8000', '4公里', '45分钟', '1800', '70次/分钟', '85次/分钟', '65次/分钟', 98.0, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (3, 20003, 180.50, 75.50, 25.50, 23.95, '偏重', '2022-01-01 08:00:00', '8小时', '2小时', '6小时', '2小时',
        '23:30', '06:30', '12000', '6公里', '1小时30分钟', '2400', '80次/分钟', '95次/分钟', '70次/分钟', 97.5,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (4, 20004, 155.50, 45.50, 14.50, 19.75, '偏瘦', '2022-01-01 08:00:00', '11小时', '3.5小时', '8.5小时', '0小时',
        '22:30', '07:30', '9000', '4.5公里', '45分钟', '1600', '65次/分钟', '80次/分钟', '60次/分钟', 98.8, '36.3°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (5, 20005, 175.50, 65.50, 22.50, 21.95, '正常', '2022-01-01 08:00:00', '9小时30分钟', '2.5小时', '7小时',
        '1小时30分钟', '23:00', '07:00', '11000', '5.5公里', '1小时15分钟', '2200', '78次/分钟', '92次/分钟',
        '68次/分钟', 98.3, '36.7°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (6, 20006, 160.50, 50.50, 16.50, 20.35, '偏瘦', '2022-01-01 08:00:00', '10小时30分钟', '3小时', '7.5小时',
        '30分钟', '23:00', '07:30', '9500', '4.8公里', '1小时', '1850', '72次/分钟', '88次/分钟', '63次/分钟', 98.6,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (7, 20007, 185.50, 80.50, 28.50, 24.75, '偏重', '2022-01-01 08:00:00', '8小时30分钟', '2.5小时', '6小时30分钟',
        '2小时30分钟', '23:30', '06:30', '13000', '6.5公里', '1小时15分钟', '2600', '85次/分钟', '98次/分钟',
        '73次/分钟', 97.8, '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (8, 20008, 150.50, 40.50, 12.50, 18.95, '偏瘦', '2022-01-01 08:00:00', '12小时', '4小时', '8小时', '30分钟',
        '22:30', '07:30', '8500', '4.2公里', '45分钟', '1450', '68次/分钟', '83次/分钟', '62次/分钟', 98.9, '36.2°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (9, 20009, 178.50, 72.50, 24.50, 22.35, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '7小时', '30分钟',
        '23:30', '07:30', '11500', '5.8公里', '1小时', '2350', '74次/分钟', '91次/分钟', '67次/分钟', 98.4, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (10, 20010, 163.50, 53.50, 19.50, 21.15, '正常', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '1小时',
        '23:30', '07:30', '10500', '5.2公里', '1小时15分钟', '2150', '71次/分钟', '86次/分钟', '64次/分钟', 98.7,
        '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (11, 30001, 170.50, 60.50, 20.50, 22.05, '偏瘦', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '0小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '75次/分钟', '90次/分钟', '60次/分钟', 98.5, '36.5°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (12, 30002, 165.50, 55.50, 18.50, 20.95, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '6.5小时', '1小时',
        '22:30', '07:30', '8000', '4公里', '45分钟', '1800', '70次/分钟', '85次/分钟', '65次/分钟', 98.0, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (13, 30003, 180.50, 75.50, 25.50, 23.95, '偏重', '2022-01-01 08:00:00', '8小时', '2小时', '6小时', '2小时',
        '23:30', '06:30', '12000', '6公里', '1小时30分钟', '2400', '80次/分钟', '95次/分钟', '70次/分钟', 97.5,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (14, 30004, 155.50, 45.50, 14.50, 19.75, '偏瘦', '2022-01-01 08:00:00', '11小时', '3.5小时', '8.5小时', '0小时',
        '22:30', '07:30', '9000', '4.5公里', '45分钟', '1600', '65次/分钟', '80次/分钟', '60次/分钟', 98.8, '36.3°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (15, 30005, 175.50, 65.50, 22.50, 21.95, '正常', '2022-01-01 08:00:00', '9小时30分钟', '2.5小时', '7小时',
        '1小时30分钟', '23:00', '07:00', '11000', '5.5公里', '1小时15分钟', '2200', '78次/分钟', '92次/分钟',
        '68次/分钟', 98.3, '36.7°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (16, 30006, 160.50, 50.50, 16.50, 20.35, '偏瘦', '2022-01-01 08:00:00', '10小时30分钟', '3小时', '7.5小时',
        '30分钟', '23:00', '07:30', '9500', '4.8公里', '1小时', '1850', '72次/分钟', '88次/分钟', '63次/分钟', 98.6,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (17, 30007, 185.50, 80.50, 28.50, 24.75, '偏重', '2022-01-01 08:00:00', '8小时30分钟', '2.5小时', '6小时30分钟',
        '2小时30分钟', '23:30', '06:30', '13000', '6.5公里', '1小时15分钟', '2600', '85次/分钟', '98次/分钟',
        '73次/分钟', 97.8, '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (18, 30008, 150.50, 40.50, 12.50, 18.95, '偏瘦', '2022-01-01 08:00:00', '12小时', '4小时', '8小时', '30分钟',
        '22:30', '07:30', '8500', '4.2公里', '45分钟', '1450', '68次/分钟', '83次/分钟', '62次/分钟', 98.9, '36.2°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (19, 30009, 178.50, 72.50, 24.50, 22.35, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '7小时', '30分钟',
        '23:30', '07:30', '11500', '5.8公里', '1小时', '2350', '74次/分钟', '91次/分钟', '67次/分钟', 98.4, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (20, 30010, 163.50, 53.50, 19.50, 21.15, '正常', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '1小时',
        '23:30', '07:30', '10500', '5.2公里', '1小时15分钟', '2150', '71次/分钟', '86次/分钟', '64次/分钟', 98.7,
        '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (21, 40001, 170.50, 60.50, 20.50, 22.05, '偏瘦', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '0小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '75次/分钟', '90次/分钟', '60次/分钟', 98.5, '36.5°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (22, 40002, 165.50, 55.50, 18.50, 20.95, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '6.5小时', '1小时',
        '22:30', '07:30', '8000', '4公里', '45分钟', '1800', '70次/分钟', '85次/分钟', '65次/分钟', 98.0, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (23, 40003, 180.50, 75.50, 25.50, 23.95, '偏重', '2022-01-01 08:00:00', '8小时', '2小时', '6小时', '2小时',
        '23:30', '06:30', '12000', '6公里', '1小时30分钟', '2400', '80次/分钟', '95次/分钟', '70次/分钟', 97.5,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (24, 40004, 155.50, 45.50, 14.50, 19.75, '偏瘦', '2022-01-01 08:00:00', '11小时', '3.5小时', '8.5小时', '0小时',
        '22:30', '07:30', '9000', '4.5公里', '45分钟', '1600', '65次/分钟', '80次/分钟', '60次/分钟', 98.8, '36.3°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (25, 40005, 175.50, 65.50, 22.50, 21.95, '正常', '2022-01-01 08:00:00', '9小时30分钟', '2.5小时', '7小时',
        '1小时30分钟', '23:00', '07:00', '11000', '5.5公里', '1小时15分钟', '2200', '78次/分钟', '92次/分钟',
        '68次/分钟', 98.3, '36.7°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (26, 40006, 160.50, 50.50, 16.50, 20.35, '偏瘦', '2022-01-01 08:00:00', '10小时30分钟', '3小时', '7.5小时',
        '30分钟', '23:00', '07:30', '9500', '4.8公里', '1小时', '1850', '72次/分钟', '88次/分钟', '63次/分钟', 98.6,
        '36.4°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (27, 40007, 185.50, 80.50, 28.50, 24.75, '偏重', '2022-01-01 08:00:00', '8小时30分钟', '2.5小时', '6小时30分钟',
        '2小时30分钟', '23:30', '06:30', '13000', '6.5公里', '1小时15分钟', '2600', '85次/分钟', '98次/分钟',
        '73次/分钟', 97.8, '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (28, 40008, 150.50, 40.50, 12.50, 18.95, '偏瘦', '2022-01-01 08:00:00', '12小时', '4小时', '8小时', '30分钟',
        '22:30', '07:30', '8500', '4.2公里', '45分钟', '1450', '68次/分钟', '83次/分钟', '62次/分钟', 98.9, '36.2°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (29, 40009, 178.50, 72.50, 24.50, 22.35, '正常', '2022-01-01 08:00:00', '9小时', '2.5小时', '7小时', '30分钟',
        '23:30', '07:30', '11500', '5.8公里', '1小时', '2350', '74次/分钟', '91次/分钟', '67次/分钟', 98.4, '36.6°C',
        '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (30, 40010, 163.50, 53.50, 19.50, 21.15, '正常', '2022-01-01 08:00:00', '10小时', '3小时', '7小时', '1小时',
        '23:30', '07:30', '10500', '5.2公里', '1小时15分钟', '2150', '71次/分钟', '86次/分钟', '64次/分钟', 98.7,
        '36.5°C', '2022-01-01 00:00:00', '2022-01-01 00:00:00');
INSERT INTO `user_health`
VALUES (31, 20031, 175.00, 70.00, 22.00, 22.86, '偏胖', '2022-01-02 08:00:00', '8小时', '2小时', '6小时', '1小时',
        '23:30', '07:00', '12000', '6公里', '1.5小时', '2200', '80次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.7°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (32, 20032, 180.00, 80.00, 25.00, 24.69, '肥胖', '2022-01-02 08:00:00', '7小时', '1.5小时', '5.5小时', '2小时',
        '00:00', '08:00', '14000', '7公里', '2小时', '2500', '85次/分钟', '100次/分钟', '75次/分钟', 98.0, '36.8°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (33, 20033, 160.00, 50.00, 15.00, 19.53, '偏瘦', '2022-01-03 08:00:00', '10小时', '3.5小时', '6.5小时',
        '0.5小时', '23:30', '07:30', '9000', '5公里', '1小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.4,
        '36.9°C', '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (34, 20034, 168.00, 65.00, 20.00, 22.98, '正常', '2022-01-03 08:00:00', '9小时', '2小时', '7小时', '0小时',
        '22:45', '07:15', '11000', '6公里', '1.5小时', '2100', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (35, 20035, 172.00, 75.00, 23.00, 25.35, '偏胖', '2022-01-04 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '80次/分钟', '100次/分钟', '75次/分钟', 98.1, '36.5°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (36, 20036, 178.00, 85.00, 26.00, 26.85, '肥胖', '2022-01-04 08:00:00', '7小时', '1小时', '6小时', '1小时',
        '00:15', '08:15', '13000', '7公里', '2小时', '2400', '85次/分钟', '105次/分钟', '80次/分钟', 98.2, '36.7°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (37, 20037, 163.00, 55.00, 17.00, 20.70, '正常', '2022-01-05 08:00:00', '10小时', '4小时', '6小时', '0小时',
        '23:45', '07:45', '9500', '5公里', '1.5小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.5, '36.8°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (38, 20038, 170.00, 65.00, 21.00, 22.49, '偏胖', '2022-01-05 08:00:00', '9小时', '3小时', '5.5小时', '0.5小时',
        '22:30', '07:00', '10500', '6公里', '1.5小时', '2200', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (39, 20039, 175.00, 80.00, 26.00, 26.12, '肥胖', '2022-01-06 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '11000', '5公里', '1小时', '2100', '80次/分钟', '100次/分钟', '75次/分钟', 98.4, '36.9°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (40, 20040, 170.00, 60.00, 20.00, 20.76, '正常', '2022-01-06 08:00:00', '9小时', '3小时', '6小时', '0小时',
        '22:45', '07:15', '10000', '6公里', '1.5小时', '2000', '75次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.5°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (41, 20031, 175.00, 70.00, 22.00, 22.86, '偏胖', '2022-01-02 08:00:00', '8小时', '2小时', '6小时', '1小时',
        '23:30', '07:00', '12000', '6公里', '1.5小时', '2200', '80次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.7°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (42, 20032, 180.00, 80.00, 25.00, 24.69, '肥胖', '2022-01-02 08:00:00', '7小时', '1.5小时', '5.5小时', '2小时',
        '00:00', '08:00', '14000', '7公里', '2小时', '2500', '85次/分钟', '100次/分钟', '75次/分钟', 98.0, '36.8°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (43, 20033, 160.00, 50.00, 15.00, 19.53, '偏瘦', '2022-01-03 08:00:00', '10小时', '3.5小时', '6.5小时',
        '0.5小时', '23:30', '07:30', '9000', '5公里', '1小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.4,
        '36.9°C', '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (44, 20034, 168.00, 65.00, 20.00, 22.98, '正常', '2022-01-03 08:00:00', '9小时', '2小时', '7小时', '0小时',
        '22:45', '07:15', '11000', '6公里', '1.5小时', '2100', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (45, 20035, 172.00, 75.00, 23.00, 25.35, '偏胖', '2022-01-04 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '80次/分钟', '100次/分钟', '75次/分钟', 98.1, '36.5°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (46, 20036, 178.00, 85.00, 26.00, 26.85, '肥胖', '2022-01-04 08:00:00', '7小时', '1小时', '6小时', '1小时',
        '00:15', '08:15', '13000', '7公里', '2小时', '2400', '85次/分钟', '105次/分钟', '80次/分钟', 98.2, '36.7°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (47, 20037, 163.00, 55.00, 17.00, 20.70, '正常', '2022-01-05 08:00:00', '10小时', '4小时', '6小时', '0小时',
        '23:45', '07:45', '9500', '5公里', '1.5小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.5, '36.8°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (48, 20038, 170.00, 65.00, 21.00, 22.49, '偏胖', '2022-01-05 08:00:00', '9小时', '3小时', '5.5小时', '0.5小时',
        '22:30', '07:00', '10500', '6公里', '1.5小时', '2200', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (49, 20039, 175.00, 80.00, 26.00, 26.12, '肥胖', '2022-01-06 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '11000', '5公里', '1小时', '2100', '80次/分钟', '100次/分钟', '75次/分钟', 98.4, '36.9°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (50, 20040, 170.00, 60.00, 20.00, 20.76, '正常', '2022-01-06 08:00:00', '9小时', '3小时', '6小时', '0小时',
        '22:45', '07:15', '10000', '6公里', '1.5小时', '2000', '75次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.5°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (51, 20031, 175.00, 70.00, 22.00, 22.86, '偏胖', '2022-01-02 08:00:00', '8小时', '2小时', '6小时', '1小时',
        '23:30', '07:00', '12000', '6公里', '1.5小时', '2200', '80次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.7°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (52, 20032, 180.00, 80.00, 25.00, 24.69, '肥胖', '2022-01-02 08:00:00', '7小时', '1.5小时', '5.5小时', '2小时',
        '00:00', '08:00', '14000', '7公里', '2小时', '2500', '85次/分钟', '100次/分钟', '75次/分钟', 98.0, '36.8°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (53, 20033, 160.00, 50.00, 15.00, 19.53, '偏瘦', '2022-01-03 08:00:00', '10小时', '3.5小时', '6.5小时',
        '0.5小时', '23:30', '07:30', '9000', '5公里', '1小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.4,
        '36.9°C', '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (54, 20034, 168.00, 65.00, 20.00, 22.98, '正常', '2022-01-03 08:00:00', '9小时', '2小时', '7小时', '0小时',
        '22:45', '07:15', '11000', '6公里', '1.5小时', '2100', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (55, 20035, 172.00, 75.00, 23.00, 25.35, '偏胖', '2022-01-04 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '80次/分钟', '100次/分钟', '75次/分钟', 98.1, '36.5°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (56, 20036, 178.00, 85.00, 26.00, 26.85, '肥胖', '2022-01-04 08:00:00', '7小时', '1小时', '6小时', '1小时',
        '00:15', '08:15', '13000', '7公里', '2小时', '2400', '85次/分钟', '105次/分钟', '80次/分钟', 98.2, '36.7°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (57, 20037, 163.00, 55.00, 17.00, 20.70, '正常', '2022-01-05 08:00:00', '10小时', '4小时', '6小时', '0小时',
        '23:45', '07:45', '9500', '5公里', '1.5小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.5, '36.8°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (58, 20038, 170.00, 65.00, 21.00, 22.49, '偏胖', '2022-01-05 08:00:00', '9小时', '3小时', '5.5小时', '0.5小时',
        '22:30', '07:00', '10500', '6公里', '1.5小时', '2200', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (59, 20039, 175.00, 80.00, 26.00, 26.12, '肥胖', '2022-01-06 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '11000', '5公里', '1小时', '2100', '80次/分钟', '100次/分钟', '75次/分钟', 98.4, '36.9°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (60, 20040, 170.00, 60.00, 20.00, 20.76, '正常', '2022-01-06 08:00:00', '9小时', '3小时', '6小时', '0小时',
        '22:45', '07:15', '10000', '6公里', '1.5小时', '2000', '75次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.5°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (61, 20031, 175.00, 70.00, 22.00, 22.86, '偏胖', '2022-01-02 08:00:00', '8小时', '2小时', '6小时', '1小时',
        '23:30', '07:00', '12000', '6公里', '1.5小时', '2200', '80次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.7°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (62, 20032, 180.00, 80.00, 25.00, 24.69, '肥胖', '2022-01-02 08:00:00', '7小时', '1.5小时', '5.5小时', '2小时',
        '00:00', '08:00', '14000', '7公里', '2小时', '2500', '85次/分钟', '100次/分钟', '75次/分钟', 98.0, '36.8°C',
        '2022-01-02 00:00:00', '2022-01-02 00:00:00');
INSERT INTO `user_health`
VALUES (63, 20033, 160.00, 50.00, 15.00, 19.53, '偏瘦', '2022-01-03 08:00:00', '10小时', '3.5小时', '6.5小时',
        '0.5小时', '23:30', '07:30', '9000', '5公里', '1小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.4,
        '36.9°C', '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (64, 20034, 168.00, 65.00, 20.00, 22.98, '正常', '2022-01-03 08:00:00', '9小时', '2小时', '7小时', '0小时',
        '22:45', '07:15', '11000', '6公里', '1.5小时', '2100', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-03 00:00:00', '2022-01-03 00:00:00');
INSERT INTO `user_health`
VALUES (65, 20035, 172.00, 75.00, 23.00, 25.35, '偏胖', '2022-01-04 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '10000', '5公里', '1小时', '2000', '80次/分钟', '100次/分钟', '75次/分钟', 98.1, '36.5°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (66, 20036, 178.00, 85.00, 26.00, 26.85, '肥胖', '2022-01-04 08:00:00', '7小时', '1小时', '6小时', '1小时',
        '00:15', '08:15', '13000', '7公里', '2小时', '2400', '85次/分钟', '105次/分钟', '80次/分钟', 98.2, '36.7°C',
        '2022-01-04 00:00:00', '2022-01-04 00:00:00');
INSERT INTO `user_health`
VALUES (67, 20037, 163.00, 55.00, 17.00, 20.70, '正常', '2022-01-05 08:00:00', '10小时', '4小时', '6小时', '0小时',
        '23:45', '07:45', '9500', '5公里', '1.5小时', '1900', '70次/分钟', '90次/分钟', '65次/分钟', 98.5, '36.8°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (68, 20038, 170.00, 65.00, 21.00, 22.49, '偏胖', '2022-01-05 08:00:00', '9小时', '3小时', '5.5小时', '0.5小时',
        '22:30', '07:00', '10500', '6公里', '1.5小时', '2200', '75次/分钟', '95次/分钟', '70次/分钟', 98.3, '36.6°C',
        '2022-01-05 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `user_health`
VALUES (69, 20039, 175.00, 80.00, 26.00, 26.12, '肥胖', '2022-01-06 08:00:00', '8小时', '2.5小时', '5.5小时', '1小时',
        '23:00', '07:00', '11000', '5公里', '1小时', '2100', '80次/分钟', '100次/分钟', '75次/分钟', 98.4, '36.9°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');
INSERT INTO `user_health`
VALUES (70, 20040, 170.00, 60.00, 20.00, 20.76, '正常', '2022-01-06 08:00:00', '9小时', '3小时', '6小时', '0小时',
        '22:45', '07:15', '10000', '6公里', '1.5小时', '2000', '75次/分钟', '95次/分钟', '70次/分钟', 98.2, '36.5°C',
        '2022-01-06 00:00:00', '2022-01-06 00:00:00');

-- ----------------------------
-- Table structure for user_health_daily
-- ----------------------------
DROP TABLE IF EXISTS `user_health_daily`;
CREATE TABLE `user_health_daily`
(
    `id`                      bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
    `date`                    date                                                          NOT NULL COMMENT '日期',
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
    `create_time`             datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`             datetime(0) NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                     `user_id`(`user_id`, `date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_health_daily
-- ----------------------------
INSERT INTO `user_health_daily`
VALUES (1, '20003', '2022-01-01', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-01 10:00:00', '7小时32分钟', '3小时',
        '4小时', '10小时32分钟', '23:00', '07:00', '23123', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-01 10:00:00', '2022-01-01 10:00:00');
INSERT INTO `user_health_daily`
VALUES (2, '20003', '2022-01-02', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-02 10:00:00', '7小时32分钟', '3小时',
        '4小时', '10小时', '23:00', '07:00', '3231', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-02 10:00:00', '2022-01-02 10:00:00');
INSERT INTO `user_health_daily`
VALUES (3, '20003', '2022-01-03', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-03 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '23', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-03 10:00:00', '2022-01-03 10:00:00');
INSERT INTO `user_health_daily`
VALUES (4, '20003', '2022-01-04', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-04 10:00:00', '7小时', '3小时32分钟',
        '4小时', '10小时', '23:00', '07:00', '1213', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-04 10:00:00', '2022-01-04 10:00:00');
INSERT INTO `user_health_daily`
VALUES (5, '20003', '2022-01-05', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-05 10:00:00', '7小时32分钟', '3小时',
        '4小时', '10小时', '23:00', '07:00', '2332', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-05 10:00:00', '2022-01-05 10:00:00');
INSERT INTO `user_health_daily`
VALUES (6, '20003', '2022-01-06', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-06 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '1212', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-06 10:00:00', '2022-01-06 10:00:00');
INSERT INTO `user_health_daily`
VALUES (7, '20003', '2022-01-07', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2022-01-07 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '31232', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2022-01-07 10:00:00', '2022-01-07 10:00:00');
INSERT INTO `user_health_daily`
VALUES (8, '20003', '2024-03-21', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-21 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (9, '20003', '2024-03-22', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-22 10:00:00', '7小时', '3小时', '4小时',
        '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (10, '20003', '2024-03-23', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-23 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (11, '20003', '2024-03-24', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-24 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (12, '20003', '2024-03-25', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-25 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (13, '20003', '2024-03-26', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-26 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (14, '20003', '2024-03-27', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-27 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (15, '20003', '2024-03-28', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-28 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (16, '20003', '2024-03-29', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-29 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (17, '20003', '2024-03-30', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-30 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:13', '2024-03-30 20:58:13');
INSERT INTO `user_health_daily`
VALUES (18, '20003', '2024-03-21', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-21 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (19, '20003', '2024-03-22', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-22 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (20, '20003', '2024-03-23', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-23 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (21, '20003', '2024-03-24', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-24 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (22, '20003', '2024-03-25', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-25 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (23, '20003', '2024-03-26', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-26 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (24, '20003', '2024-03-27', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-27 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (25, '20003', '2024-03-28', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-28 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (26, '20003', '2024-03-29', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-29 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (27, '20003', '2024-03-30', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-30 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:27', '2024-03-30 20:58:27');
INSERT INTO `user_health_daily`
VALUES (28, '20003', '2024-03-21', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-21 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (29, '20003', '2024-03-22', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-22 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (30, '20003', '2024-03-23', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-23 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (31, '20003', '2024-03-24', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-24 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (32, '20003', '2024-03-25', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-25 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (33, '20003', '2024-03-26', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-26 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (34, '20003', '2024-03-27', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-27 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (35, '20003', '2024-03-28', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-28 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (36, '20003', '2024-03-29', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-29 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (37, '20003', '2024-03-30', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-30 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (38, '20003', '2024-03-21', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-21 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (39, '20003', '2024-03-22', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-22 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (40, '20003', '2024-03-23', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-23 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (41, '20003', '2024-03-24', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-24 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (42, '20003', '2024-03-25', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-25 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (43, '20003', '2024-03-26', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-26 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (44, '20003', '2024-03-27', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-27 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (45, '20003', '2024-03-28', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-28 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (46, '20003', '2024-03-29', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-29 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (47, '20003', '2024-03-30', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-30 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:28', '2024-03-30 20:58:28');
INSERT INTO `user_health_daily`
VALUES (48, '20003', '2024-03-21', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-21 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (49, '20003', '2024-03-22', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-22 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (50, '20003', '2024-03-23', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-23 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (51, '20003', '2024-03-24', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-24 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (52, '20003', '2024-03-25', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-25 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (53, '20003', '2024-03-26', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-26 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (54, '20003', '2024-03-27', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-27 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (55, '20003', '2024-03-28', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-28 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (56, '20003', '2024-03-29', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-29 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');
INSERT INTO `user_health_daily`
VALUES (57, '20003', '2024-03-30', 170.00, 60.00, 20.00, 20.76, '偏瘦', '2024-03-30 10:00:00', '7小时', '3小时',
        '4小时', '10小时', '23:00', '07:00', '20000', '5公里', '1小时', '2000', '75', '90', '60', 95.0, '36.5',
        '2024-03-30 20:58:30', '2024-03-30 20:58:30');

SET
FOREIGN_KEY_CHECKS = 1;
