package com.smart.www.pojo.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class LogisticsVo implements Serializable {
    /**
     * 工号
     */
    private String logisticsId;

    /**
     * 设备ID
     */
    private String deviceId;
    private String image;
    /**
     * 密码
     */
    private String password;
    /**
     * 岗位
     */
    private String post;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 密码
     */
    private String birth;
    private Integer status;

}
