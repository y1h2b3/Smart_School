package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 名字
     */
    @TableField(value = "name")
    private String name;
    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 1系统管理员,2学校教务处
     */
    @TableField(value = "role")
    private Integer role;

}