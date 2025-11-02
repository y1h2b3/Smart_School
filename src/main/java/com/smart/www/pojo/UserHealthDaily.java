package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName user_health_daily
 */
@TableName(value = "user_health_daily")
@Data
@Getter
public class UserHealthDaily implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /*
    学生心率分布
     */
    @TableField(exist = false)
    public String heartRateRange;
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
    /**
     * 日期
     */
    @TableField(value = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
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
    /*
    学生姓名
     */
    @TableField(exist = false)
    private String username;
    /*
    学生班级
     */
    @TableField(exist = false)
    private String clazz;
    /*
    步数
     */
    @TableField(exist = false)
    private Integer steps;
    /*
    每日平均步数
     */
    @TableField(exist = false)
    private Integer averDateSteps;
    /*
    年级
     */
    @TableField(exist = false)
    private String Grade;

    /*
    学生年龄
     */
    /*
    年级平均步数
     */
    @TableField(exist = false)
    private Integer averGradeSteps;

    /*
    年龄段平均步数
     */
    @TableField(exist = false)
    private Integer age;

    /*
    年龄段
     */
    @TableField(exist = false)
    private Integer averAgeSteps;

    /*
    年龄段平均体重
     */
    @TableField(exist = false)
    private String ageGroup;

    /*
    体重分布
     */
    @TableField(exist = false)
    private Integer averAgeWeight;

    /*
    体重分布数量
     */
    @TableField(exist = false)
    private String weightRange;
    @TableField(exist = false)
    private Integer weightCount;
    /*
    学生头像
     */
    @TableField(exist = false)
    private String Imgsrc;
    /*
    学生近七天平均每日睡眠时间
     */
    @TableField(exist = false)
    private Integer averDateSleep;
    /*
    学生近七天平均每日深度睡眠时间
    */
    @TableField(exist = false)
    private Integer avgDeepSleep;
    /*
    学生近七天平均每日浅度睡眠时间
    */
    @TableField(exist = false)
    private Integer avgLightSleep;
    /*
    各时间段分组
     */
    @TableField(exist = false)
    private String sleepTimeRange;
    /*
    各时间段平均睡眠时间人数
     */
    @TableField(exist = false)
    private Integer AverGradeSleepCount;
    /*
    各个心率人数数量
     */
    @TableField(exist = false)
    private Integer HeartRateCount;

    /*
    月份分组
     */
    @TableField(exist = false)
    private String monthRange;

    /*
    每月发烧学生数量统计
     */

    @TableField(exist = false)
    private Integer feverCountByMonth;

    /*
    各个年龄段学生发烧数量统计
     */
    @TableField(exist = false)
    private Integer feverCountByAge;

    /*
    各个年级学生发烧数量统计
     */
    @TableField(exist = false)
    private Integer feverCountByGrade;


}