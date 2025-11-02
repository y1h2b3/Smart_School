package com.smart.www.pojo.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ParentVo implements Serializable {
    /**
     * 家长ID
     */
    private String parentId;
    private String image;
    /**
     * 学生名字
     */
    private String studentName;

    /**
     * 学生班级
     */
    private String studentClazz;

    /**
     * 姓名
     */
    private String ParentName;

    private String StudentId;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;
    private Integer status;
    private String grade;
    private String clazz;
}
