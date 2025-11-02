package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName student
 */
@TableName(value = "student")
@Data
public class Student implements Serializable {
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
     * 年级
     */
    @TableField(value = "grade")
    private String grade;
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
     * 家长ID
     */
    @TableField(value = "parent_id")
    private String parentId;
    /**
     * 学号
     */
    @TableField(value = "student_id")
    private String studentId;
    /**
     * 班主任
     */
    @TableField(value = "teacher_id")
    private String teacherId;
    /**
     * 班级
     */
    @TableField(value = "clazz")
    private String clazz;
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
     * 状态
     */
    @TableField(value = "status")
    private int status;
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
     * 出生日期
     */
    @TableField(value = "birth")
    private String birth;
    private String parentName;
    private String teacherName;

}
