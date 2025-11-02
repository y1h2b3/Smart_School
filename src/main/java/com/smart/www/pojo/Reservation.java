package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName reservation
 */
@TableName(value = "reservation")
@Data
public class Reservation implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 预约id
     */
    @TableField(value = "reservation_id")
    private Integer reservationId;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 医生id
     */
    @TableField(value = "staff_id")
    private String staffId;
    /**
     * 预约时间
     */
    @TableField(value = "time")
    private String time;
    /**
     * 地点
     */
    @TableField(value = "location")
    private String location;
    /**
     * 医生名字
     */
    private String staffName;
    /**
     * 用户名字
     */
    private String userName;
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
