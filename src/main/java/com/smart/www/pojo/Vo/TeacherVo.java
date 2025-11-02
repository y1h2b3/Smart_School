package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherVo implements Serializable {
    /**
     * 教师工号
     */
    private String teacherId;
    private String image;
    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 岗位
     */
    private String post;

    /**
     * 姓名
     */
    private String name;

    /**
     * 管理班级
     */
    private String clazz;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    private String birth;
    /**
     * 紧急联系人员
     */
    private Integer status;
    private String password;
}
