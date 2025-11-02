package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName logs_data
 */
@TableName(value = "logs_data")
@Data
public class LogsData implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 日志id
     */
    @TableField(value = "data_id")
    private String dataId;
    /**
     * 人员id
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 日志类型
     */
    @TableField(value = "logs_type")
    private String logsType;
    /**
     * 执行结果
     */
    @TableField(value = "result")
    private String result;
    /**
     * 结果说明
     */
    @TableField(value = "msg")
    private String msg;
    /**
     * ip地址
     */
    @TableField(value = "ip")
    private String ip;
    /**
     * ip地址
     */
    @TableField(value = "is_success")
    private int isSuccess;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
}