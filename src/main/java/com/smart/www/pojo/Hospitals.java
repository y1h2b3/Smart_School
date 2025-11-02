package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName hospitals
 */
@TableName(value = "hospitals")
@Data
public class Hospitals implements Serializable {
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
     * 医院ID
     */
    @TableField(value = "hospital_id")
    private Integer hospitalId;
    /**
     * 医院名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;
    /**
     * 联系电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 医院等级
     */
    @TableField(value = "grade")
    private String grade;
    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;
    /**
     * 医保情况
     */
    @TableField(value = "medical_insurance")
    private String medicalInsurance;
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
