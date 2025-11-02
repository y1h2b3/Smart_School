package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName user_health
 */
@TableName(value = "user_health")
@Data
public class UserHealth implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    private String postOrClazz;
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 身高
     */
    @TableField(value = "height")
    private BigDecimal height;
    /**
     * 体重
     */
    @TableField(value = "weight")
    private BigDecimal weight;
    /**
     * 脂肪率
     */
    @TableField(value = "fat_percentage")
    private BigDecimal fatPercentage;
    /**
     * BMI
     */
    @TableField(value = "BMI")
    private BigDecimal bmi;
    /**
     * 身体类型
     */
    @TableField(value = "type")
    private String type;
    /**
     * 最近测量时间
     */
    @TableField(value = "measure_time")
    private String measureTime;
    /**
     * 累计睡眠时长
     */
    @TableField(value = "sleep_time_total")
    private String sleepTimeTotal;
    /**
     * 累计深睡时长
     */
    @TableField(value = "deep_sleep_total")
    private String deepSleepTotal;
    /**
     * 累计浅睡时长
     */
    @TableField(value = "light_sleep_total")
    private String lightSleepTotal;
    /**
     * 累计清醒时长
     */
    @TableField(value = "wake_time_total")
    private String wakeTimeTotal;
    /**
     * 昨晚入睡时间
     */
    @TableField(value = "list_sleep_time")
    private String listSleepTime;
    /**
     * 今天起床时间
     */
    @TableField(value = "today_wakeup_time")
    private String todayWakeupTime;
    /**
     * 走步步数
     */
    @TableField(value = "step")
    private String step;
    /**
     * 走步距离
     */
    @TableField(value = "walking_distance")
    private String walkingDistance;
    /**
     * 走步时长
     */
    @TableField(value = "walking_time")
    private String walkingTime;
    /**
     * 卡路里
     */
    @TableField(value = "calorie")
    private String calorie;
    /**
     * 平均静息心率
     */
    @TableField(value = "mean_resting_heart_rate")
    private String meanRestingHeartRate;
    /**
     * 静息心率最高
     */
    @TableField(value = "resting_heart_rate_max")
    private String restingHeartRateMax;
    /**
     * 静息心率最低
     */
    @TableField(value = "resting_heart_rate_min")
    private String restingHeartRateMin;
    /**
     * 血氧
     */
    @TableField(value = "spo2")
    private BigDecimal spo2;
    /**
     * 体温
     */
    @TableField(value = "temperature")
    private String temperature;
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
    @TableField(value = "check_warning")
    private String checkWarning;
}