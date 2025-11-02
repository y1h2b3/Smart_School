package com.smart.www.pojo.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DrugsVo implements Serializable {
    /**
     * 药品ID
     */
    private String drugId;

    private String img;

    /**
     * 药品名字
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private Integer quantity;
    private String typeId;

    /**
     * 规格
     */
    private String specifications;
    /**
     * 类型
     */
    private String type;

    /**
     * 用法
     */
    private String usage1;

    /**
     * 使用剂量
     */
    private String dosage;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 有效期
     */
    private String expirationDate;

    /**
     * 症状
     */
    private String symptoms;

    /**
     * 备注
     */
    private String notes;

    private Date createTime;
    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
