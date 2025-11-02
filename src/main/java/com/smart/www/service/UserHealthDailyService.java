package com.smart.www.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.UserHealthDaily;
import com.smart.www.pojo.Vo.EveryDayWarning;
import com.smart.www.pojo.Vo.FindStudentEveryMonthAvgStep;
import com.smart.www.pojo.Vo.RankList;
import com.smart.www.pojo.Vo.dateList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @description 针对表【user_health_daily】的数据库操作Service
 * @createDate 2024-03-26 12:48:15
 */
public interface UserHealthDailyService extends IService<UserHealthDaily> {

    String FindAllAvgSteps(String NewDate);

    String FindAllAvgSleep(String todayDate);

    String FindAllWarning(String low, String NewDate, String type);

    String FindBodyIndex(String fatPercentage);

    String FindAllCount(String student);

    String FindAvgBodyIndex(String level, String type,String date,String ren);

    List<HashMap<String, Object>> FindSportsReach(String s);

    List<RankList> FindRankList(String type);

    List<RankList> FindStudentRankList();

    List<dateList> FindSleepReach(String type,String sex);

    String FindAvgStepByAge(String type, String number, String number1);

    String FindStudentFatPercentage(String type,String st);

    String FindEveryWeekWarning(String type, String sex, String startDate, String endDate);

    String FindStudentMotion(String type,String sex);

    String FindStudentFever(String type, String sex);

    List<FindStudentEveryMonthAvgStep> FindStudentEveryMonthAvgStep(String type);

    List<EveryDayWarning> FindStudentMEveryFeverSum(String type, String sex);

    List<Map<String, String>> findUserIdHealth(String id);
}
