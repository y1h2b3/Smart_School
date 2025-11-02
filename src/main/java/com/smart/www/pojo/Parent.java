package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName parent
 */
@TableName(value = "parent")
@Data
public class Parent implements Serializable {
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
     * 家长ID
     */
    @TableField(value = "parent_id")
    private String parentId;
    /**
     * 人员类型
     */
    @TableField(value = "type")
    private String type;
    /**
     * 学生学号
     */
    @TableField(value = "student_id")
    private String studentId;
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
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 学生名字
     */
    private String studentName;
    /**
     * 学生班级
     */
    private String studentClazz;
    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
    @TableField(value = "status")
    private Integer status;
    private String grade;
    private String clazz;
}
