package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName health_warning_notifications
 */
@TableName(value = "health_warning_notifications")
@Data
public class HealthWarningNotifications implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 通知ID
     */
    @TableField(value = "notification_id")
    private String notificationId;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 预警类型
     */
    @TableField(value = "type")
    private String type;
    /**
     * 预警等级
     */
    @TableField(value = "level")
    private String level;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 预警发出的时间
     */
    @TableField(value = "time")
    private Date time;
    /**
     * 测量值
     */
    @TableField(value = "reading_value")
    private String readingValue;
    @TableField(value = "reading_key")
    private String readingKey;
    /**
     * 建议的行动或措施
     */
    @TableField(value = "recommended_action")
    private String recommendedAction;
    /**
     * 用户名字
     */
    private String userName;
    private String name;
    /**
     * 班级或者岗位
     */
    private String userClazzOrPost;
    /**
     * 性别
     */
    private String sex;

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
