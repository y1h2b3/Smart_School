package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserHealthVo implements Serializable {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名字
     */
    private String userName;

    private String postOrClazz;

    /**
     * 身高
     */
    private BigDecimal height;

    /**
     * 体重
     */
    private BigDecimal weight;

    /**
     * 脂肪率
     */
    private BigDecimal fatPercentage;

    /**
     * BMI
     */
    private BigDecimal bmi;

    /**
     * 身体类型
     */
    private String type;

    /**
     * 最近测量时间
     */
    private String measureTime;

    /**
     * 累计睡眠时长
     */
    private String sleepTimeTotal;

    /**
     * 累计深睡时长
     */
    private String deepSleepTotal;

    /**
     * 累计浅睡时长
     */
    private String lightSleepTotal;

    /**
     * 累计清醒时长
     */
    private String wakeTimeTotal;

    /**
     * 昨晚入睡时间
     */
    private String listSleepTime;

    /**
     * 今天起床时间
     */
    private String todayWakeupTime;

    /**
     * 走步步数
     */
    private String step;

    /**
     * 走步距离
     */
    private String walkingDistance;

    /**
     * 走步时长
     */
    private String walkingTime;

    /**
     * 卡路里
     */
    private String calorie;

    /**
     * 平均静息心率
     */
    private String meanRestingHeartRate;

    /**
     * 静息心率最高
     */
    private String restingHeartRateMax;

    /**
     * 静息心率最低
     */
    private String restingHeartRateMin;

    /**
     * 血氧
     */
    private BigDecimal spo2;

    /**
     * 体温
     */
    private String temperature;

}
