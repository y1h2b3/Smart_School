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

 Date: 12/11/2025 13:08:41
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`           bigint                                                       NOT NULL AUTO_INCREMENT,
    `order_id`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务订单号',
    `user_id`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `drug_id`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `time`         datetime NULL DEFAULT NULL COMMENT '购买时间',
    `price`        decimal(10, 2)                                               NOT NULL DEFAULT 0.00 COMMENT '单价',
    `order_status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `quantity`     int                                                          NOT NULL DEFAULT 1,
    `total_price`  decimal(10, 2)                                               NOT NULL DEFAULT 0.00,
    `create_time`  datetime NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_order_id`(`order_id` ASC) USING BTREE,
    INDEX          `idx_orders_user_id`(`user_id` ASC) USING BTREE,
    INDEX          `idx_orders_drug_id`(`drug_id` ASC) USING BTREE,
    INDEX          `idx_orders_create_time`(`create_time` ASC) USING BTREE,
    INDEX          `idx_orders_status`(`order_status` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders`
VALUES (1, 'O202511010001', 'U1001', 'D001', '2025-11-01 09:15:00', 28.90, '已支付', 2, 57.80, '2025-11-01 09:15:00',
        '2025-11-01 09:15:00');
INSERT INTO `orders`
VALUES (2, 'O202511020001', 'U1002', 'D002', '2025-11-02 14:02:21', 18.50, '已支付', 1, 18.50, '2025-11-02 14:02:21',
        '2025-11-02 14:02:21');
INSERT INTO `orders`
VALUES (3, 'O202511020002', 'U1003', 'D003', '2025-11-02 19:30:00', 12.00, '待支付', 5, 60.00, '2025-11-02 19:30:00',
        '2025-11-02 19:30:00');
INSERT INTO `orders`
VALUES (4, 'O202511030001', 'U1001', 'D004', '2025-11-03 10:05:11', 35.00, '已支付', 1, 35.00, '2025-11-03 10:05:11',
        '2025-11-03 10:05:11');
INSERT INTO `orders`
VALUES (5, 'O202511030002', 'U1004', 'D001', '2025-11-03 16:45:00', 28.90, '已取消', 3, 86.70, '2025-11-03 16:45:00',
        '2025-11-03 16:45:00');
INSERT INTO `orders`
VALUES (6, 'O202511040001', 'U1002', 'D003', '2025-11-04 08:20:00', 12.00, '已支付', 2, 24.00, '2025-11-04 08:20:00',
        '2025-11-04 08:20:00');
INSERT INTO `orders`
VALUES (7, 'O202511050001', 'U1005', 'D002', '2025-11-05 12:10:33', 18.50, '已支付', 3, 55.50, '2025-11-05 12:10:33',
        '2025-11-05 12:10:33');
INSERT INTO `orders`
VALUES (8, 'O202511060001', 'U1006', 'D004', '2025-11-06 15:28:49', 35.00, '待支付', 2, 70.00, '2025-11-06 15:28:49',
        '2025-11-06 15:28:49');
INSERT INTO `orders`
VALUES (9, 'O202511070001', 'U1003', 'D001', '2025-11-07 09:59:00', 28.90, '已支付', 1, 28.90, '2025-11-07 09:59:00',
        '2025-11-07 09:59:00');
INSERT INTO `orders`
VALUES (10, 'O202511080001', 'U1001', 'D002', '2025-11-08 11:11:11', 18.50, '已支付', 4, 74.00, '2025-11-08 11:11:11',
        '2025-11-08 11:11:11');
INSERT INTO `orders`
VALUES (11, 'O202511090001', 'U1002', 'D003', '2025-11-09 17:00:00', 12.00, '已取消', 1, 12.00, '2025-11-09 17:00:00',
        '2025-11-09 17:00:00');
INSERT INTO `orders`
VALUES (12, 'O202511100001', 'U1004', 'D004', '2025-11-10 13:37:22', 35.00, '已支付', 5, 175.00, '2025-11-10 13:37:22',
        '2025-11-10 13:37:22');

SET
FOREIGN_KEY_CHECKS = 1;
