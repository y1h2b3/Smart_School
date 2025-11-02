package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.UserHealth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HealthCheckMapper extends BaseMapper<UserHealth> {
    @Select("       select user_id,height,weight,fat_percentage,BMI,measure_time,sleep_time_total,deep_sleep_total,\n" +
            "               light_sleep_total,wake_time_total,today_wakeup_time,step,walking_distance,list_sleep_time,\n" +
            "               walking_time,calorie,mean_resting_heart_rate,resting_heart_rate_max,resting_heart_rate_min,\n" +
            "               resting_heart_rate_min,spo2,temperature,check_warning as checkWarning \n" +
            "        from user_health")
    List<UserHealth> healthCheck();

    @Update("UPDATE user_health SET check_warning = 'c'")
    int UpdatehealthCheck();
}
