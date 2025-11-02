package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName staff
 */
@TableName(value = "staff")
@Data
public class Staff implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 图片
     */
    @TableField(value = "img")
    private String image;
    /**
     * 员工ID
     */
    @TableField(value = "staff_id")
    private String staffId;
    /**
     * 名字
     */
    @TableField(value = "name")
    private String name;
    /**
     * 联系电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 地点
     */
    @TableField(value = "location")
    private String location;
    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;
    /**
     * 出生日期
     */
    @TableField(value = "birth")
    private String birth;
    /**
     * 是否在职
     */
    @TableField(value = "is_active")
    private String isActive;
    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;
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
