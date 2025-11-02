package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReservationVo implements Serializable {
    /**
     * 预约id
     */
    private Integer reservationId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 医生名字
     */
    private String staffName;

    /**
     * 医生id
     */
    private String staffId;

    /**
     * 预约时间
     */
    private String time;

    /**
     * 地点
     */
    private String location;
}
