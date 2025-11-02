package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersVo implements Serializable {
    /**
     * 订单id
     */
    private String orderId;
    private String orderStatus;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 药品名字
     */
    private String drugName;

    /**
     * 购买时间
     */
    private Date time;

    /**
     * 金额
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;
}
