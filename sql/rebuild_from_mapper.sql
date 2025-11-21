-- SmartCampus 数据库重建脚本（由 Mapper/实体推断生成）
-- 适配 MySQL 8.0，字符集 utf8mb4
-- 使用前请先备份现有数据；如需清空重建，可直接执行本脚本

-- 可选：创建并使用数据库
CREATE
DATABASE IF NOT EXISTS `smart_campus` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE
`smart_campus`;

-- 1) 分类/关系表（药品/医院公用）
-- 说明：
--   - relation_type: 1=药品类型, 2=医院等级, 3=医院类型
--   - 两个表都提供，兼容不同Mapper（drugs_relation / drugs_hospitals_relation）

DROP TABLE IF EXISTS `drugs_relation`;
CREATE TABLE `drugs_relation`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `relation_type` int          NOT NULL COMMENT '关系类型',
    `type_id`       int          NOT NULL COMMENT '关联id',
    `type_name`     varchar(255) NOT NULL COMMENT '关联名字',
    `create_time`   datetime     NOT NULL COMMENT '创建时间',
    `update_time`   datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `drugs_hospitals_relation`;
CREATE TABLE `drugs_hospitals_relation`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `relation_type` int          NOT NULL COMMENT '关系类型',
    `type_id`       int          NOT NULL COMMENT '关联id',
    `type_name`     varchar(255) NOT NULL COMMENT '关联名字',
    `create_time`   datetime     NOT NULL COMMENT '创建时间',
    `update_time`   datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- 2) 药品表
DROP TABLE IF EXISTS `drugs`;
CREATE TABLE `drugs`
(
    `id`              bigint         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `img`             longblob       NOT NULL COMMENT '图片',
    `drug_id`         varchar(255)   NOT NULL COMMENT '药品ID',
    `type_id`         int            NOT NULL COMMENT '药品类型id',
    `name`            varchar(255)   NOT NULL COMMENT '药品名字',
    `price`           decimal(10, 2) NOT NULL COMMENT '价格',
    `quantity`        int            NOT NULL COMMENT '数量',
    `specifications`  varchar(255) NULL DEFAULT NULL COMMENT '规格',
    `type`            varchar(255) NULL DEFAULT NULL COMMENT '类型',
    `usage1`          varchar(255) NULL DEFAULT NULL COMMENT '用法',
    `dosage`          varchar(255) NULL DEFAULT NULL COMMENT '使用剂量',
    `manufacturer`    varchar(255)   NOT NULL COMMENT '生产厂家',
    `expiration_date` varchar(255)   NOT NULL COMMENT '有效期',
    `symptoms`        varchar(255) NULL DEFAULT NULL COMMENT '症状',
    `notes`           varchar(255) NULL DEFAULT NULL COMMENT '备注',
    `create_time`     datetime       NOT NULL COMMENT '创建时间',
    `update_time`     datetime       NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX             `drug_id`(`drug_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- 3) 订单表
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`           BIGINT         NOT NULL AUTO_INCREMENT,
    `order_id`     VARCHAR(64)    NOT NULL COMMENT '业务订单号',
    `user_id`      VARCHAR(64)    NOT NULL,
    `drug_id`      VARCHAR(64)    NOT NULL,
    `time`         DATETIME                DEFAULT NULL COMMENT '购买时间',
    `price`        DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '单价',
    `order_status` VARCHAR(32)             DEFAULT NULL,
    `quantity`     INT            NOT NULL DEFAULT 1,
    `total_price`  DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    `create_time`  DATETIME                DEFAULT CURRENT_TIMESTAMP,
    `update_time`  DATETIME                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_id` (`order_id`),
    KEY            `idx_orders_user_id` (`user_id`),
    KEY            `idx_orders_drug_id` (`drug_id`),
    KEY            `idx_orders_create_time` (`create_time`),
    KEY            `idx_orders_status` (`order_status`)
    -- 可选外键（如你希望加上）：
    -- ,CONSTRAINT `fk_orders_drug` FOREIGN KEY (`drug_id`) REFERENCES `drugs`(`drug_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- 4) 医院表
DROP TABLE IF EXISTS `hospitals`;
CREATE TABLE `hospitals`
(
    `id`                BIGINT       NOT NULL AUTO_INCREMENT,
    `img`               VARCHAR(255) DEFAULT NULL COMMENT '图片',
    `hospital_id`       INT          NOT NULL,
    `name`              VARCHAR(255) NOT NULL,
    `address`           VARCHAR(255) DEFAULT NULL,
    `phone`             VARCHAR(50)  DEFAULT NULL,
    `grade`             INT          DEFAULT NULL COMMENT '关联drugs_hospitals_relation.type_id (relation_type=2)',
    `type`              INT          DEFAULT NULL COMMENT '关联drugs_hospitals_relation.type_id (relation_type=3)',
    `medical_insurance` TINYINT(1) DEFAULT NULL COMMENT '是否支持医保(0/1) 或按业务约定',
    `note`              VARCHAR(500) DEFAULT NULL,
    `create_time`       DATETIME     DEFAULT CURRENT_TIMESTAMP,
    `update_time`       DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_hospital_id` (`hospital_id`),
    KEY                 `idx_hospitals_name` (`name`),
    KEY                 `idx_hospitals_grade` (`grade`),
    KEY                 `idx_hospitals_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医院表';

-- 提示：如需演示数据，可在下方添加 INSERT 语句；
--      relation 表可先插入若干 (relation_type, type_id, type_name) 以供前端联动展示。
