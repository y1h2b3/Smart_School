package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Account implements Serializable {
    private String deviceId;
    private String userId;
    private String userType;
    private String userName;
    private String sex;
    private String phone;
    private String password;
    private String status;
    private Date createTime;
    private Date updateTime;
}
