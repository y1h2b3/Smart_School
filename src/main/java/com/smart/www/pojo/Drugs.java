package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName drugs
 */
@TableName(value = "drugs")
@Data
public class Drugs implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 图片
     */
    @TableField(value = "img")
    private String img;
    /**
     * 药品ID
     */
    @TableField(value = "drug_id")
    private String drugId;
    /**
     * 药品名字
     */
    @TableField(value = "drug_name")
    private String name;
    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 数量
     */
    @TableField(value = "quantity")
    private Integer quantity;
    /**
     * 规格
     */
    @TableField(value = "specifications")
    private String specifications;
    /**
     * 类型
     */
    private String type;
    private String typeId;
    /**
     * 用法
     */
    @TableField(value = "usage1")
    private String usage1;
    /**
     * 使用剂量
     */
    @TableField(value = "dosage")
    private String dosage;
    /**
     * 生产厂家
     */
    @TableField(value = "manufacturer")
    private String manufacturer;
    /**
     * 有效期
     */
    @TableField(value = "expiration_date")
    private String expirationDate;
    /**
     * 症状
     */
    @TableField(value = "symptoms")
    private String symptoms;
    /**
     * 备注
     */
    @TableField(value = "notes")
    private String notes;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
