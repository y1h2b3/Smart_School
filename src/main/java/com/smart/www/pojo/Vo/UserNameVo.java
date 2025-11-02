package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserNameVo implements Serializable {
    private String phone;
    private String password;
    private String type;
}
