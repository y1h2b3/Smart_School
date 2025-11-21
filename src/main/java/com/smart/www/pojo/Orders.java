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
 * @TableName orders
 */
@TableName(value = "orders")
@Data
public class Orders implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单id
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 药品id
     */
    @TableField(value = "drug_id")
    private String drugId;
    /**
     * 购买时间
     */
    @TableField(value = "time")
    private Date time;
    /**
     * 金额
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    private String orderStatus;
    /**
     * 支付方式：alipay-支付宝, wxpay-微信, bank-网银, jdpay-京东
     */
    @TableField(value = "payment_type")
    private String paymentType;
    /**
     * 平台订单号（书杰支付返回的trade_no）
     */
    @TableField(value = "platform_trade_no")
    private String platformTradeNo;
    /**
     * 接口订单号（微信/支付宝返回的单号）
     */
    @TableField(value = "api_trade_no")
    private String apiTradeNo;
    /**
     * 数量
     */
    @TableField(value = "quantity")
    private Integer quantity;
    /**
     * 总金额
     */
    @TableField(value = "total_price")
    private BigDecimal totalPrice;
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

    /**
     * 药品名称（关联查询时使用，非orders表字段）
     */
    @TableField(exist = false)
    private String drugName;
}
