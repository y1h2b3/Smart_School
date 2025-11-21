-- orders 表建表脚本
-- 适配 MySQL 8.0，字符集 utf8mb4
-- 根据 Orders.java 实体与 OrdersMapper.xml 生成

USE
`smart_campus`;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`           bigint         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`     varchar(255)   NOT NULL COMMENT '订单ID',
    `user_id`      varchar(255)   NOT NULL COMMENT '用户ID',
    `drug_id`      varchar(255)   NOT NULL COMMENT '药品ID',
    `time`         datetime NULL DEFAULT NULL COMMENT '购买时间',
    `price`        decimal(10, 2) NOT NULL COMMENT '单价',
    `order_status` varchar(255) NULL DEFAULT NULL COMMENT '订单状态',
    `quantity`     int            NOT NULL COMMENT '数量',
    `total_price`  decimal(10, 2) NOT NULL COMMENT '总金额',
    `create_time`  datetime       NOT NULL COMMENT '创建时间',
    `update_time`  datetime       NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `order_id`(`order_id`) USING BTREE,
    INDEX          `user_id`(`user_id`) USING BTREE,
    INDEX          `drug_id`(`drug_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = DYNAMIC;
