package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName staff_orders
 */
@TableName(value = "staff_orders")
@Data
public class StaffOrders implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 预约id
     */
    @TableField(value = "orders_id")
    private String ordersId;
    /**
     * 医生id
     */
    @TableField(value = "staff_id")
    private String staffId;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 预约状态
     */
    @TableField(value = "status")
    private String status;
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
    private String userName;
    private String StaffName;
    private String location;

}