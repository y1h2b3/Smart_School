package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.UserHealthDailyMapper;
import com.smart.www.pojo.UserHealthDaily;
import com.smart.www.pojo.Vo.EveryDayWarning;
import com.smart.www.pojo.Vo.FindStudentEveryMonthAvgStep;
import com.smart.www.pojo.Vo.RankList;
import com.smart.www.pojo.Vo.dateList;
import com.smart.www.service.UserHealthDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @description 针对表【user_health_daily】的数据库操作Service实现
 * @createDate 2024-03-26 12:48:15
 */
@Service
public class UserHealthDailyServiceImpl extends ServiceImpl<UserHealthDailyMapper, UserHealthDaily>
        implements UserHealthDailyService {

    @Autowired
    private UserHealthDailyMapper userHealthDailyMapper;

    @Override
    public String FindAllAvgSteps(String NewDate) {
        return userHealthDailyMapper.FindAllAvgSteps(NewDate);
    }

    @Override
    public String FindAllAvgSleep(String NewDate) {
        return userHealthDailyMapper.FindAllAvgSleep(NewDate);
    }

    @Override
    public String FindAllWarning(String rank, String NewDate, String type) {
        return switch (type) {
            case "ALL" -> userHealthDailyMapper.FindAllWarning(rank, NewDate, "%");
            case "Student" -> userHealthDailyMapper.FindAllWarning(rank, NewDate, "S");
            case "Teacher" -> userHealthDailyMapper.FindAllWarning(rank, NewDate, "T");
            case "Logistics" -> userHealthDailyMapper.FindAllWarning(rank, NewDate, "L");
            default -> throw new IllegalArgumentException("Unsupported type: " + type);
        };
    }


    @Override
    public String FindBodyIndex(String fatPercentage) {
        return userHealthDailyMapper.FindBodyIndex(fatPercentage);
    }

    @Override
    public String FindAllCount(String count) {
        return userHealthDailyMapper.FindAllCount(count);
    }

    @Override
    public String FindAvgBodyIndex(String level, String type,String date,String ren) {
        switch (level) {
            case "excellent" : switch (type){
                case "height" : return userHealthDailyMapper.excellentHeight(date,ren);
                case "calorie" : return userHealthDailyMapper.excellentCalorie(date,ren);
                case "sleep" : return userHealthDailyMapper.excellentSleep(date,ren);
                case "step" : return userHealthDailyMapper.excellentStep(date,ren);
                case "motion" : return userHealthDailyMapper.excellentMotion(date,ren);
                case "bim" : return userHealthDailyMapper.excellentBim(date,ren);
            }
            case "normal" : switch (type){
                case "height" : return userHealthDailyMapper.normalHeight(date,ren);
                case "calorie" : return userHealthDailyMapper.normalCalorie(date,ren);
                case "sleep" : return userHealthDailyMapper.normalSleep(date,ren);
                case "step" : return userHealthDailyMapper.normalStep(date,ren);
                case "motion" : return userHealthDailyMapper.normalMotion(date,ren);
                case "bim" : return userHealthDailyMapper.normalBim(date,ren);
            }
            case "poor" : switch (type){
                case "height" : return userHealthDailyMapper.poorHeight(date,ren);
                case "calorie" : return userHealthDailyMapper.poorCalorie(date,ren);
                case "sleep" : return userHealthDailyMapper.poorSleep(date,ren);
                case "step" : return userHealthDailyMapper.poorStep(date,ren);
                case "motion" : return userHealthDailyMapper.poorMotion(date,ren);
                case "bim" : return userHealthDailyMapper.poorBim(date,ren);
            }
            default: return "error";
        }
    }

    @Override
    public List<HashMap<String, Object>> FindSportsReach(String s) {
        return userHealthDailyMapper.FindSportsReach(s);
    }

    @Override
    public List<RankList> FindRankList(String type) {
        return userHealthDailyMapper.FindRankList(type);
    }

    @Override
    public List<RankList> FindStudentRankList() {
        return userHealthDailyMapper.FindStudentRankList();
    }

    @Override
    public List<dateList> FindSleepReach(String type,String sex) {
        return userHealthDailyMapper.FindSleepReach(type,sex);
    }

    @Override
    public String FindAvgStepByAge(String type, String number, String number1) {
        return userHealthDailyMapper.FindAvgStepByAge(type,number,number1);
    }

    @Override
    public String FindStudentFatPercentage(String type,String st) {
        return switch (type) {
            case "normal" -> userHealthDailyMapper.FindStudentFatPercentage("18.5","24.9",st);
            case "overweight" -> userHealthDailyMapper.FindStudentFatPercentage("25","100",st);
            case "obesity" -> userHealthDailyMapper.FindStudentFatPercentage("0","18.4",st);
            default -> "error";
        };
    }

    @Override
    public String FindEveryWeekWarning(String type, String sex, String startDate, String endDate) {
        return userHealthDailyMapper.FindEveryWeekWarning(type,sex,startDate,endDate);
    }

    @Override
    public String FindStudentMotion(String type,String sex) {
        return userHealthDailyMapper.FindStudentMotion(type,sex);
    }

    @Override
    public String FindStudentFever(String type, String sex) {
        return userHealthDailyMapper.FindStudentFever(type,sex);
    }

    @Override
    public List<FindStudentEveryMonthAvgStep> FindStudentEveryMonthAvgStep(String type) {
        return userHealthDailyMapper.FindStudentEveryMonthAvgStep(type);
    }

    @Override
    public List<EveryDayWarning> FindStudentMEveryFeverSum(String type, String sex) {
        return userHealthDailyMapper.FindStudentMEveryFeverSum(type,sex);
    }

    @Override
    public List<Map<String, String>> findUserIdHealth(String id) {
        return userHealthDailyMapper.findUserIdHealth(id);
    }

}




