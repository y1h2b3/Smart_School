package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StaffVo implements Serializable {

    /**
     * 员工ID
     */
    private String staffId;


    private String image;

    /**
     * 名字
     */
    private String name;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 地点
     */
    private String location;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private String birth;

    /**
     * 是否在职
     */
    private String isActive;
    /**
     * 备注
     */
    private String note;
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date updateTime;

}
