package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName teacher
 */
@TableName(value = "teacher")
@Data
public class Teacher implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 图片
     */
    @TableField(value = "img")
    private String image;
    /**
     * 人员类型
     */
    @TableField(value = "type")
    private String type;
    /**
     * 设备ID
     */
    @TableField(value = "device_id")
    private String deviceId;
    /**
     * 教师工号
     */
    @TableField(value = "teacher_id")
    private String teacherId;
    /**
     * 岗位
     */
    @TableField(value = "post")
    private String post;
    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;
    /**
     * 管理班级
     */
    @TableField(value = "clazz")
    private String clazz;
    /**
     * 紧急联系人员
     */
    @TableField(value = "birth")
    private String birth;
    @TableField(value = "status")
    private Integer status;
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
