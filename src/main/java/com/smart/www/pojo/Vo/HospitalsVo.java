package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HospitalsVo implements Serializable {
    /**
     * 医院ID
     */
    private Integer hospitalId;

    /**
     * 医院名称
     */
    private String name;
    private String image;
    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 医院等级
     */
    private String grade;

    /**
     * 类型
     */
    private String type;

    /**
     * 医保情况
     */
    private String medicalInsurance;

    /**
     * 备注
     */
    private String note;
}
