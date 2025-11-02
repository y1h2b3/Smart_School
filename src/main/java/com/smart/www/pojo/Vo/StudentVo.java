package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentVo implements Serializable {
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 图片
     */
    private String image;
    /**
     * 家长名字
     */
    private String parentName;

    /**
     * 年级
     */
    private String grade;
    private String teacherId;
    private String parentId;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 班主任名字
     */
    private String teacherName;

    /**
     * 班级
     */
    private String clazz;

    /**
     * 姓名
     */
    private String name;

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
    /**
     * 出生日期
     */
    private String birth;
    private Integer status;

}
