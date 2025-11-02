package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName notifications
 */
@TableName(value = "notifications")
@Data
public class Notifications implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 消息id
     */
    @TableField(value = "notify_id")
    private Integer notifyId;
    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;
    /**
     * 发布者
     */
    @TableField(value = "publisher")
    private String publisher;
    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;
    /**
     * 日志时间
     */
    @TableField(value = "time")
    private Date time;
    /**
     * 通知群体
     */
    @TableField(value = "notify_group")
    private String notifyGroup;
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
