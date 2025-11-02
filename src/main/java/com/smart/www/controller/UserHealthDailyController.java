package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.smart.www.mapper.UserHealthDailyMapper;
import com.smart.www.pojo.UserHealth;
import com.smart.www.pojo.UserHealthDaily;
import com.smart.www.pojo.Vo.EveryDayWarning;
import com.smart.www.pojo.Vo.FindStudentEveryMonthAvgStep;
import com.smart.www.pojo.Vo.RankList;
import com.smart.www.pojo.Vo.dateList;
import com.smart.www.service.UserHealthDailyService;
import com.smart.www.util.RedisCache;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;


@RestController
@Tag(name = "用户健康日报")
@SaCheckLogin(type = StpUtil.TYPE)
public class UserHealthDailyController {

    @Autowired
    private UserHealthDailyService userHealthDailyService;
    @Autowired
    private UserHealthDailyMapper userHealthDailyMapper;
    @Autowired
    private RedisCache redisCache;
    String[] levels = {"excellent", "normal", "poor"};
    String[] types = {"height", "calorie", "sleep", "step", "motion", "bim"};
    String[] level = {"低", "中", "高"};
    String[] day = {"今日", "昨日"};
    String[] selectRole = {"T","S","L"};
    String[] SelectRole1 = {"ALL","Student","Teacher","Logistics"};

    @GetMapping("/findUserIdHealth")
    @Operation(summary = "根据id查询用户健康")
    public Result findUserIdHealth(String id) {
        try {
            List<Map<String,String>> list = userHealthDailyService.findUserIdHealth(id);
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/findAllStep")
    @Operation(summary = "查询所有用户步数")
    public Result findAllStep() {
        try {
            List<Map<String,String>> list = userHealthDailyMapper.findAllStep();
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/findMyStep")
    @Operation(summary = "查询我的步数")
    public Result findMyStep(String id) {
        try {
            List<Map<String,String>> list = userHealthDailyMapper.findMyStep(id);
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/findAllStudentRank")
    @Operation(summary = "查询所有学生预警等级占比")
    public Result findAllStudentRank() {
        try {
            List<Map<String,String>> list = userHealthDailyMapper.findAllStudentRank();
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/findAllStudentWarning")
    @Operation(summary = "查询所有学生预警原因占比")
    public Result findAllStudentWarning() {
        try {
            List<Map<String,String>> list = userHealthDailyMapper.findAllStudentWarning();
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    /*
    TODO : 学校人均步数
    */
    @GetMapping("/FindAllAvgSteps")
    @Operation(summary = "管理端学校人均步数")
    public Result FindAllAvgSteps() {
        Map<String, Object> schoolAvgSteps = redisCache.getCacheMap("schoolAvgSteps");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        String todayDate = "2023-04-15";
        String yesterdayDate= "2023-04-14";
        if (schoolAvgSteps!=null&&!schoolAvgSteps.isEmpty()){
            return Result.ok(schoolAvgSteps);
        }
        else {
            Map<String, String> find = new HashMap<>();
            String[] dates = {todayDate, yesterdayDate};
            for (int i = 0; i < dates.length; i++) {
                String steps = userHealthDailyService.FindAllAvgSteps(dates[i]);
                String[] split = steps.split("\\.");
                find.put(day[i] + "全校平均步数", split[0]);
            }
            redisCache.setCacheMap("schoolAvgSteps", find);
            redisCache.expire("schoolAvgSteps",1,TimeUnit.HOURS);
            return Result.ok(find);
        }
    }
    /*
        TODO : 学校平均睡眠时间
     */
    @GetMapping("/FindAllAvgSleep")
    @Operation(summary = "管理端学校平均睡眠时间")
    public Result FindAllAvgSleep() {
        Map<String, Object> schoolAvgSleep = redisCache.getCacheMap("schoolAvgSleep");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        String todayDate = "2023-04-15";
        String yesterdayDate= "2023-04-14";
        if (schoolAvgSleep!=null&&!schoolAvgSleep.isEmpty()){
            return Result.ok(schoolAvgSleep);
        }
        else {
            Map<String, String> find = new HashMap<>();
            String[] dates = {todayDate, yesterdayDate};
            for (int i = 0; i < dates.length; i++) {
                String steps = userHealthDailyService.FindAllAvgSleep(dates[i]);
                double value = Double.parseDouble(steps);
                String formattedValue = String.format("%.2f", value);
                find.put(day[i] + "全校平均睡眠", formattedValue);
            }
            redisCache.setCacheMap("schoolAvgSleep", find);
            redisCache.expire("schoolAvgSleep", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
        TODO : 学校预警人数接口
     */
    @GetMapping("/FindAllWarning")
    @Operation(summary = "管理端学校预警人数接口")
    public Result FindAllWarning() {
        Map<String, Object> schoolAllWarning = redisCache.getCacheMap("schoolAllWarning");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolAllWarning!=null&&!schoolAllWarning.isEmpty()){
            return Result.ok(schoolAllWarning);
        }else {
            Map<String, String> find = new HashMap<>();
            for (String level : level) {
                String result = userHealthDailyService.FindAllWarning(level, todayDate, SelectRole1[0]);
                find.put(level, result);
            }
            redisCache.setCacheMap("schoolAllWarning", find);
            redisCache.expire("schoolAllWarning", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }


    /*
    TODO : 全校身体指标分析接口
    */
    @GetMapping("/FindBodyIndex")
    @Operation(summary = "管理端全校身体指标分析接口")
    public Result FindBodyIndex() {
        Map<String, Object> schoolBodyIndex = redisCache.getCacheMap("schoolBodyIndex");
        if (schoolBodyIndex!=null&&!schoolBodyIndex.isEmpty()){
            return Result.ok(schoolBodyIndex);
        }else {
            String[] bodyIndexes = {"height", "weight", "fat_percentage", "BMI"};
            Map<String, String> find = new HashMap<>();
            for (String index : bodyIndexes) {
                String value = userHealthDailyService.FindBodyIndex(index);
                double numericValue = Double.parseDouble(value);
                String formattedValue = String.format("%.2f", numericValue);
                find.put(index, formattedValue);
            }
            redisCache.setCacheMap("schoolBodyIndex", find);
            redisCache.expire("schoolBodyIndex", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
        TODO : 学校人数接口
     */
    @GetMapping("/FindAllCount")
    @Operation(summary = "管理端学校人数接口")
    public Result FindAllCount() {
        Map<String, Object> schoolAllCount = redisCache.getCacheMap("schoolAllCount");
        if (schoolAllCount!=null&&!schoolAllCount.isEmpty()){
            return Result.ok(schoolAllCount);
        }else {
            String[] roles = {"student", "parent", "logistics", "teacher"};
            Map<String, String> find = new HashMap<>();
            for (String role : roles) {
                String result = userHealthDailyService.FindAllCount(role);
                find.put(role, result);
            }
            redisCache.setCacheMap("schoolAllCount", find);
            redisCache.expire("schoolAllCount", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO : 学生预警人数接口
    */
    @GetMapping("/FindStudentWarning")
    @Operation(summary = "管理端学生预警人数接口")
    public Result FindStudentWarning() {
        Map<String, Object> schoolStudentWarning = redisCache.getCacheMap("schoolStudentWarning");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolStudentWarning!=null&&!schoolStudentWarning.isEmpty()){
            return Result.ok(schoolStudentWarning);
        }else {
            Map<String, String> find = new HashMap<>();
            for (String level : level) {
                String result = userHealthDailyService.FindAllWarning(level, todayDate, SelectRole1[1]);
                find.put(level, result);
            }
            redisCache.setCacheMap("schoolStudentWarning", find);
            redisCache.expire("schoolStudentWarning", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
        TODO : 老师预警人数接口
    */
    @GetMapping("/FindTeacherWarning")
    @Operation(summary = "管理端老师预警人数接口")
    public Result FindTeacherWarning() {
        Map<String, Object> schoolTeacherWarning = redisCache.getCacheMap("schoolTeacherWarning");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolTeacherWarning!=null&&!schoolTeacherWarning.isEmpty()){
            return Result.ok(schoolTeacherWarning);
        }else {
            Map<String, String> find = new HashMap<>();
            for (String level : level) {
                String result = userHealthDailyService.FindAllWarning(level, todayDate, SelectRole1[2]);
                find.put(level, result);
            }
            redisCache.setCacheMap("schoolTeacherWarning", find);
            redisCache.expire("schoolTeacherWarning", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
        TODO : 后勤预警人数接口
    */
    @GetMapping("/FindLogisticsWarning")
    @Operation(summary = "管理端后勤预警人数接口")
    public Result FindLogisticsWarning() {
        Map<String, Object> schoolLogisticsWarning = redisCache.getCacheMap("schoolLogisticsWarning");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolLogisticsWarning!=null&&!schoolLogisticsWarning.isEmpty()){
            return Result.ok(schoolLogisticsWarning);
        }else {

            Map<String, String> find = new HashMap<>();
            for (String level : levels) {
                String result = userHealthDailyService.FindAllWarning(level, todayDate, SelectRole1[3]);
                find.put(level, result);
            }
            redisCache.setCacheMap("schoolLogisticsWarning", find);
            redisCache.expire("schoolLogisticsWarning", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
        TODO :  可视化界面学生健康平均指标人数
    */
    @GetMapping("/FindAvgStudentBodyIndex")
    @Operation(summary = "管理端可视化界面学生健康平均指标人数")
    public Result FindAvgStudentBodyIndex(){
        Map<String, Object> schoolAvgBodyIndex = redisCache.getCacheMap("schoolAvgStudentBodyIndex");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolAvgBodyIndex!=null&&!schoolAvgBodyIndex.isEmpty()){
            return Result.ok(schoolAvgBodyIndex);
        }else {
            Map<String, String> find = new HashMap<>();
            for (String level : levels) {
                for (String type : types) {
                    String key = level + "_" + type;
                    String value = userHealthDailyService.FindAvgBodyIndex(level, type, todayDate,selectRole[1]);
                    find.put(key, value);
                }
            }
            redisCache.setCacheMap("schoolAvgStudentBodyIndex", find);
            redisCache.expire("schoolAvgStudentBodyIndex", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO :  可视化界面老师健康平均指标人数
    */
    @GetMapping("/FindAvgTeacherBodyIndex")
    @Operation(summary = "管理端可视化界面老师健康平均指标人数")
    public Result FindAvgTeacherBodyIndex(){
        Map<String, Object> schoolAvgBodyIndex = redisCache.getCacheMap("schoolAvgTeacherBodyIndex");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolAvgBodyIndex!=null&&!schoolAvgBodyIndex.isEmpty()){
            return Result.ok(schoolAvgBodyIndex);
        }else {
            Map<String, String> find = new HashMap<>();
            for (String level : levels) {
                for (String type : types) {
                    String key = level + "_" + type;
                    String value = userHealthDailyService.FindAvgBodyIndex(level, type, todayDate,selectRole[0]);
                    find.put(key, value);
                }
            }
            redisCache.setCacheMap("schoolAvgTeacherBodyIndex", find);
            redisCache.expire("schoolAvgTeacherBodyIndex", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO :  可视化界面后勤健康平均指标人数
    */
    @GetMapping("/FindAvgLogisticsBodyIndex")
    @Operation(summary = "管理端可视化界面后勤健康平均指标人数")
    public Result FindAvgLogisticsBodyIndex(){
        Map<String, Object> schoolAvgBodyIndex = redisCache.getCacheMap("schoolAvgLogisticsBodyIndex");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedYesterday = sdf.format(yesterday);
        String formattedToday = sdf.format(today);
        //这个时间要改
        String todayDate = "2024-04-17";
        if (schoolAvgBodyIndex!=null&&!schoolAvgBodyIndex.isEmpty()){
            return Result.ok(schoolAvgBodyIndex);
        }else {
            Map<String, String> find = new HashMap<>();
            for (String level : levels) {
                for (String type : types) {
                    String key = level + "_" + type;
                    String value = userHealthDailyService.FindAvgBodyIndex(level, type, todayDate,selectRole[2]);
                    find.put(key, value);
                }
            }
            redisCache.setCacheMap("schoolAvgLogisticsBodyIndex", find);
            redisCache.expire("schoolAvgLogisticsBodyIndex", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO :  可视化界面学生每个月运动达标人数
    */
    @GetMapping("/FindStudentSportsReach")
    @Operation(summary = "管理端可视化学生界面每个月运动达标人数")
    public Result FindStudentSportsReach(){
        Map<String, Object> schoolSportsReach = redisCache.getCacheMap("schoolStudentSportsReach");
        if (schoolSportsReach!=null&&!schoolSportsReach.isEmpty()){
            return Result.ok(schoolSportsReach);
        }else {
            List<HashMap<String,Object>> list = userHealthDailyService.FindSportsReach(selectRole[1]);
            list.forEach(System.out::println);
            Map<String, Object> find = new HashMap<>();
            for (HashMap<String, Object> map : list) {
                String key = map.get("month").toString();
                String value = String.valueOf(map.get("count"));
                find.put(key, value);
            }
            redisCache.setCacheMap("schoolStudentSportsReach", find);
            redisCache.expire("schoolStudentSportsReach", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO :  可视化界面教师每个月运动达标人数
    */
    @GetMapping("/FindTeacherSportsReach")
    @Operation(summary = "管理端可视化界面教师每个月运动达标人数")
    public Result FindTeacherSportsReach(){
        Map<String, Object> schoolSportsReach = redisCache.getCacheMap("schoolTeacherSportsReach");
        if (schoolSportsReach!=null&&!schoolSportsReach.isEmpty()){
            return Result.ok(schoolSportsReach);
        }else {
            List<HashMap<String,Object>> list = userHealthDailyService.FindSportsReach(selectRole[0]);
            Map<String, Object> find = new HashMap<>();
            for (HashMap<String, Object> map : list) {
                String key = map.get("month").toString();
                String value = String.valueOf(map.get("count"));
                find.put(key, value);
            }
            redisCache.setCacheMap("schoolTeacherSportsReach", find);
            redisCache.expire("schoolTeacherSportsReach", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO :  可视化界面教师每个月运动达标人数
    */
    @GetMapping("/FindLogisticsSportsReach")
    @Operation(summary = "管理端可视化界面教师每个月运动达标人数")
    public Result FindLogisticsSportsReach(){
        Map<String, Object> schoolSportsReach = redisCache.getCacheMap("schoolLogisticsSportsReach");
        if (schoolSportsReach!=null&&!schoolSportsReach.isEmpty()){
            return Result.ok(schoolSportsReach);
        }else {
            List<HashMap<String,Object>> list = userHealthDailyService.FindSportsReach(selectRole[2]);
            Map<String, Object> find = new HashMap<>();
            for (HashMap<String, Object> map : list) {
                String key = map.get("month").toString();
                String value = String.valueOf(map.get("count"));
                find.put(key, value);
            }
            redisCache.setCacheMap("schoolLogisticsSportsReach", find);
            redisCache.expire("schoolLogisticsSportsReach", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    /*
    TODO :  可视化界面教师每月班级异常人数排行榜
    */
    @GetMapping("/FindTeacherRankList")
    @Operation(summary = " 管理端可视化界面教师每月班级异常人数排行榜 ")
    public Result FindTeacherRankList(){
        List<RankList> schoolStudentRankList = redisCache.getCacheList("schoolTeacherRankList");
        if (schoolStudentRankList!=null&&!schoolStudentRankList.isEmpty()){
            return Result.ok(schoolStudentRankList);
        }else {
            List<RankList> list = userHealthDailyService.FindRankList("teacher");
            redisCache.setCacheList("schoolTeacherRankList", list);
            redisCache.expire("schoolTeacherRankList", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
    TODO :  可视化界面后勤每月班级异常人数排行榜
    */
    @GetMapping("/FindLogisticsRankList")
    @Operation(summary = " 管理端可视化界面后勤每月班级异常人数排行榜 ")
    public Result FindLogisticsRankList(){
        List<RankList> schoolStudentRankList = redisCache.getCacheList("schoolLogisticsRankList");
        if (schoolStudentRankList!=null&&!schoolStudentRankList.isEmpty()){
            return Result.ok(schoolStudentRankList);
        }else {
            List<RankList> list = userHealthDailyService.FindRankList("logistics");
            redisCache.setCacheList("schoolLogisticsRankList", list);
            redisCache.expire("schoolLogisticsRankList", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
    TODO :  可视化界面学生每月班级异常人数排行榜
    */
    @GetMapping("/FindStudentRankList")
    @Operation(summary = " 管理端可视化界面学生每月班级异常人数排行榜 ")
    public Result FindStudentRankList(){
        List<RankList> schoolStudentRankList = redisCache.getCacheList("schoolStudentRankList");
        if (schoolStudentRankList!=null&&!schoolStudentRankList.isEmpty()){
            return Result.ok(schoolStudentRankList);
        }else {
            List<RankList> list = userHealthDailyService.FindStudentRankList();
            redisCache.setCacheList("schoolStudentRankList", list);
            redisCache.expire("schoolStudentRankList", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
    TODO :   男学生一周睡眠时间达标人数
    */
    @GetMapping("/FindStudentMSleepReach")
    @Operation(summary = " 管理端可视化界面男学生一周睡眠时间达标人数 ")
    public Result FindStudentMSleepReach(){
        List<dateList>  schoolSleepReach = redisCache.getCacheList("schoolStudentMSleepReach");
        if (schoolSleepReach!=null&&!schoolSleepReach.isEmpty()){
            return Result.ok(schoolSleepReach);
        }else {
            List<dateList> list = userHealthDailyService.FindSleepReach("student","男");
            redisCache.setCacheList("schoolStudentMSleepReach", list);
            redisCache.expire("schoolStudentMSleepReach", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
    TODO :   女学生一周睡眠时间达标人数
    */
    @GetMapping("/FindStudentFSleepReach")
    @Operation(summary = " 管理端可视化界面女学生一周睡眠时间达标人数 ")
    public Result FindStudentFSleepReach(){
        List<dateList> schoolSleepReach = redisCache.getCacheList("schoolStudentFSleepReach");
        if (schoolSleepReach!=null&&!schoolSleepReach.isEmpty()){
            return Result.ok(schoolSleepReach);
        }else {
            List<dateList> list = userHealthDailyService.FindSleepReach("student","女");
            redisCache.setCacheList("schoolStudentFSleepReach", list);
            redisCache.expire("schoolStudentFSleepReach", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
    TODO :   男老师一周睡眠时间达标人数
    */
    @GetMapping("/FindTeacherMSleepReach")
    @Operation(summary = " 管理端可视化界面男老师一周睡眠时间达标人数 ")
    public Result FindTeacherMSleepReach(){
            List<dateList> schoolSleepReach = redisCache.getCacheList("schoolTeacherMSleepReach");
        if (schoolSleepReach!=null&&!schoolSleepReach.isEmpty()){
            return Result.ok(schoolSleepReach);
        }else {
            List<dateList> list = userHealthDailyService.FindSleepReach("teacher","男");
            redisCache.setCacheList("schoolTeacherMSleepReach", list);
            redisCache.expire("schoolTeacherMSleepReach", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
TODO :   女老师一周睡眠时间达标人数
*/
    @GetMapping("/FindTeacherFSleepReach")
    @Operation(summary = " 管理端可视化界面女老师一周睡眠时间达标人数 ")
    public Result FindTeacherFSleepReach(){
        List<dateList> schoolSleepReach = redisCache.getCacheList("schoolTeacherFSleepReach");
        if (schoolSleepReach!=null&&!schoolSleepReach.isEmpty()){
            return Result.ok(schoolSleepReach);
        }else {
            List<dateList> list = userHealthDailyService.FindSleepReach("teacher","女");
            redisCache.setCacheList("schoolTeacherFSleepReach", list);
            redisCache.expire("schoolTeacherFSleepReach", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
TODO :   男后勤一周睡眠时间达标人数
*/
    @GetMapping("/FindLogisticsMSleepReach")
    @Operation(summary = " 管理端可视化界面男后勤一周睡眠时间达标人数 ")
    public Result FindLogisticsMSleepReach(){
        List<dateList> schoolSleepReach = redisCache.getCacheList("schoolLogisticsMSleepReach");
        if (schoolSleepReach!=null&&!schoolSleepReach.isEmpty()){
            return Result.ok(schoolSleepReach);
        }else {
            List<dateList> list = userHealthDailyService.FindSleepReach("logistics","男");
            redisCache.setCacheList("schoolLogisticsMSleepReach", list);
            redisCache.expire("schoolLogisticsMSleepReach", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
TODO :   女后勤一周睡眠时间达标人数
*/
    @GetMapping("/FindLogisticsFSleepReach")
    @Operation(summary = " 管理端可视化界面女后勤一周睡眠时间达标人数 ")
    public Result FindLogisticsFSleepReach(){
        List<dateList> schoolSleepReach = redisCache.getCacheList("schoolLogisticsFSleepReach");
        if (schoolSleepReach!=null&&!schoolSleepReach.isEmpty()){
            return Result.ok(schoolSleepReach);
        }else {
            List<dateList> list = userHealthDailyService.FindSleepReach("logistics","女");
            redisCache.setCacheList("schoolLogisticsFSleepReach", list);
            redisCache.expire("schoolLogisticsFSleepReach", 1, TimeUnit.HOURS);
            return Result.ok(list);
        }
    }

    /*
TODO :    年龄段平均步数分布
*/
    @GetMapping("/FindStudentAvgStepByAge")
    @Operation(summary = " 管理端可视化界面学生当月年龄段平均步数分布 ")
    public Result FindStudentAvgStepByAge(){
        Map<String, Object> schoolStudentAvgStepByAge = redisCache.getCacheMap("schoolStudentAvgStepByAge");
        if (schoolStudentAvgStepByAge!=null&&!schoolStudentAvgStepByAge.isEmpty()){
            return Result.ok(schoolStudentAvgStepByAge);
        }else {
            String six_8 = userHealthDailyService.FindAvgStepByAge("student","6","8");
            String nine_12 = userHealthDailyService.FindAvgStepByAge("student","9","12");
            String thirteen_15 = userHealthDailyService.FindAvgStepByAge("student","13","15");
            String sixteen_18 = userHealthDailyService.FindAvgStepByAge("student","16","18");
            Map<String, Object> find = new HashMap<>();
            find.put("6-8岁", six_8);
            find.put("9-12岁", nine_12);
            find.put("13-15岁", thirteen_15);
            find.put("16-18岁", sixteen_18);
            redisCache.setCacheMap("schoolStudentAvgStepByAge", find);
            redisCache.expire("schoolStudentAvgStepByAge", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindTeacherAvgStepByAge")
    @Operation(summary = " 管理端可视化界面老师当月年龄段平均步数分布 ")
    public Result FindTeacherAvgStepByAge(){
        Map<String, Object> schoolStudentAvgStepByAge = redisCache.getCacheMap("schoolTeacherAvgStepByAge");
        if (schoolStudentAvgStepByAge!=null&&!schoolStudentAvgStepByAge.isEmpty()){
            return Result.ok(schoolStudentAvgStepByAge);
        }else {
            String six_8 = userHealthDailyService.FindAvgStepByAge("teacher","20","30");
            String nine_12 = userHealthDailyService.FindAvgStepByAge("teacher","31","40");
            String thirteen_15 = userHealthDailyService.FindAvgStepByAge("teacher","41","50");
            String sixteen_18 = userHealthDailyService.FindAvgStepByAge("teacher","51","60");
            Map<String, Object> find = new HashMap<>();
            find.put("20-30岁", six_8);
            find.put("31-40岁", nine_12);
            find.put("41-50岁", thirteen_15);
            find.put("51-60岁", sixteen_18);
            redisCache.setCacheMap("schoolTeacherAvgStepByAge", find);
            redisCache.expire("schoolTeacherAvgStepByAge", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindLogisticsAvgStepByAge")
    @Operation(summary = " 管理端可视化界面后勤当月年龄段平均步数分布 ")
    public Result FindLogisticsAvgStepByAge(){
        Map<String, Object> schoolStudentAvgStepByAge = redisCache.getCacheMap("schoolLogisticsAvgStepByAge");
        if (schoolStudentAvgStepByAge!=null&&!schoolStudentAvgStepByAge.isEmpty()){
            return Result.ok(schoolStudentAvgStepByAge);
        }else {
            String six_8 = userHealthDailyService.FindAvgStepByAge("logistics","31","35");
            String nine_12 = userHealthDailyService.FindAvgStepByAge("logistics","36","40");
            String thirteen_15 = userHealthDailyService.FindAvgStepByAge("logistics","41","46");
            String sixteen_18 = userHealthDailyService.FindAvgStepByAge("logistics","47","60");
            Map<String, Object> find = new HashMap<>();
            find.put("31-35岁", six_8);
            find.put("36-40岁", nine_12);
            find.put("41-46岁", thirteen_15);
            find.put("47-60岁", sixteen_18);
            redisCache.setCacheMap("schoolLogisticsAvgStepByAge", find);
            redisCache.expire("schoolLogisticsAvgStepByAge", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindStudentFatPercentage")
    @Operation(summary = " 管理端可视化界面学生体型分布占比")
    public Result FindStudentFatPercentage(){
        Map<String, Object> schoolStudentFatPercentage = redisCache.getCacheMap("schoolStudentFatPercentage");
        if (schoolStudentFatPercentage!=null&&!schoolStudentFatPercentage.isEmpty()) {
            return Result.ok(schoolStudentFatPercentage);
        }else {
            String Normal = userHealthDailyService.FindStudentFatPercentage("normal","S");
            String Obesity = userHealthDailyService.FindStudentFatPercentage("obesity","S");
            String Overweight = userHealthDailyService.FindStudentFatPercentage("overweight","S");
            Map<String, Object> find = new HashMap<>();
            find.put("正常", Normal);
            find.put("肥胖", Obesity);
            find.put("瘦", Overweight);
            redisCache.setCacheMap("schoolStudentFatPercentage", find);
            redisCache.expire("schoolStudentFatPercentage", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindTeacherFatPercentage")
    @Operation(summary = " 管理端可视化界面教师体型分布占比")
    public Result FindTeacherFatPercentage(){
        Map<String, Object> schoolTeacherFatPercentage = redisCache.getCacheMap("schoolTeacherFatPercentage");
        if (schoolTeacherFatPercentage!=null&&!schoolTeacherFatPercentage.isEmpty()) {
            return Result.ok(schoolTeacherFatPercentage);
        }else {
            String Normal = userHealthDailyService.FindStudentFatPercentage("normal","T");
            String Obesity = userHealthDailyService.FindStudentFatPercentage("obesity","T");
            String Overweight = userHealthDailyService.FindStudentFatPercentage("overweight","T");
            Map<String, Object> find = new HashMap<>();
            find.put("正常", Normal);
            find.put("肥胖", Obesity);
            find.put("瘦", Overweight);
            redisCache.setCacheMap("schoolTeacherFatPercentage", find);
            redisCache.expire("schoolTeacherFatPercentage", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindLogisticsFatPercentage")
    @Operation(summary = " 管理端可视化界面后勤体型分布占比")
    public Result FindLogisticsFatPercentage(){
        Map<String, Object> schoolLogisticsFatPercentage = redisCache.getCacheMap("schoolLogisticsFatPercentage");
        if (schoolLogisticsFatPercentage!=null&&!schoolLogisticsFatPercentage.isEmpty()) {
            return Result.ok(schoolLogisticsFatPercentage);
        }else {
            String Normal = userHealthDailyService.FindStudentFatPercentage("normal","L");
            String Obesity = userHealthDailyService.FindStudentFatPercentage("obesity","L");
            String Overweight = userHealthDailyService.FindStudentFatPercentage("overweight","L");
            Map<String, Object> find = new HashMap<>();
            find.put("正常", Normal);
            find.put("肥胖", Obesity);
            find.put("瘦", Overweight);
            redisCache.setCacheMap("schoolLogisticsFatPercentage", find);
            redisCache.expire("schoolLogisticsFatPercentage", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindStudentMEveryWeekWarning")
    @Operation(summary = " 管理端可视化界面男学生每日预警人数")
    public Result FindStudentMEveryWeekWarning(){
        Map<String,String> schoolStudentMEveryWeekWarning = redisCache.getCacheMap("schoolStudentMEveryWeekWarning");
        if (schoolStudentMEveryWeekWarning!=null&&!schoolStudentMEveryWeekWarning.isEmpty()) {
            return Result.ok(schoolStudentMEveryWeekWarning);
        }else {
            LocalDate startDate = LocalDate.of(2024, 2, 26);
            String[] startDates = new String[15];
            String[] endDates = new String[15];
            Map<String,String> find = new HashMap<>();
            for (int i = 0; i < 15; i++) {
                LocalDate weekStart = startDate.plusWeeks(i);
                LocalDate weekEnd = weekStart.plusDays(6);
                startDates[i] = weekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDates[i] = weekEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sum = userHealthDailyService.FindEveryWeekWarning("student","男",startDates[i],endDates[i]);
                find.put("第"+(i+1) +"周",sum);
            }
            Map<String, String> sortedMap = new TreeMap<>((o1, o2) -> {
                int week1 = Integer.parseInt(o1.substring(1, o1.length() - 1));
                int week2 = Integer.parseInt(o2.substring(1, o2.length() - 1));
                return Integer.compare(week1, week2);
            });
            sortedMap.putAll(find);
            redisCache.setCacheMap("schoolStudentMEveryWeekWarning", sortedMap);
            redisCache.expire("schoolStudentMEveryWeekWarning", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindStudentFEveryWeekWarning")
    @Operation(summary = " 管理端可视化界面女学生每周预警人数")
    public Result FindStudentFEveryFWeekWarning(){
        Map<String,String> schoolStudentFEveryWeekWarning = redisCache.getCacheMap("schoolStudentFEveryWeekWarning");
        if (schoolStudentFEveryWeekWarning!=null&&!schoolStudentFEveryWeekWarning.isEmpty()) {
            return Result.ok(schoolStudentFEveryWeekWarning);
        }else {
            LocalDate startDate = LocalDate.of(2024, 2, 26);
            String[] startDates = new String[15];
            String[] endDates = new String[15];
            Map<String,String> find = new HashMap<>();
            for (int i = 0; i < 15; i++) {
                LocalDate weekStart = startDate.plusWeeks(i);
                LocalDate weekEnd = weekStart.plusDays(6);
                startDates[i] = weekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDates[i] = weekEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sum = userHealthDailyService.FindEveryWeekWarning("student","女",startDates[i],endDates[i]);
                find.put("第"+(i+1) +"周",sum);
            }
            Map<String, String> sortedMap = new TreeMap<>((o1, o2) -> {
                int week1 = Integer.parseInt(o1.substring(1, o1.length() - 1));
                int week2 = Integer.parseInt(o2.substring(1, o2.length() - 1));
                return Integer.compare(week1, week2);
            });
            sortedMap.putAll(find);
            redisCache.setCacheMap("schoolStudentFEveryWeekWarning", sortedMap);
            redisCache.expire("schoolStudentFEveryWeekWarning", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindTeacherMEveryWeekWarning")
    @Operation(summary = " 管理端可视化界面男老师每日预警人数")
    public Result FindTeacherMEveryWeekWarning(){
        Map<String,String> schoolTeacherMEveryWeekWarning = redisCache.getCacheMap("schoolTeacherMEveryWeekWarning");
        if (schoolTeacherMEveryWeekWarning!=null&&!schoolTeacherMEveryWeekWarning.isEmpty()) {
            return Result.ok(schoolTeacherMEveryWeekWarning);
        }else {
            LocalDate startDate = LocalDate.of(2024, 2, 26);
            String[] startDates = new String[15];
            String[] endDates = new String[15];
            Map<String,String> find = new HashMap<>();
            for (int i = 0; i < 15; i++) {
                LocalDate weekStart = startDate.plusWeeks(i);
                LocalDate weekEnd = weekStart.plusDays(6);
                startDates[i] = weekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDates[i] = weekEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sum = userHealthDailyService.FindEveryWeekWarning("teacher","男",startDates[i],endDates[i]);
                find.put("第"+(i+1) +"周",sum);
            }
            Map<String, String> sortedMap = new TreeMap<>((o1, o2) -> {
                int week1 = Integer.parseInt(o1.substring(1, o1.length() - 1));
                int week2 = Integer.parseInt(o2.substring(1, o2.length() - 1));
                return Integer.compare(week1, week2);
            });
            sortedMap.putAll(find);
            redisCache.setCacheMap("schoolTeacherMEveryWeekWarning", sortedMap);
            redisCache.expire("schoolTeacherMEveryWeekWarning", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindTeacherFEveryWeekWarning")
    @Operation(summary = " 管理端可视化界面女老师每周预警人数")
    public Result FindTeacherFEveryFWeekWarning(){
        Map<String,String> schoolTeacherFEveryWeekWarning = redisCache.getCacheMap("schoolTeacherFEveryWeekWarning");
        if (schoolTeacherFEveryWeekWarning!=null&&!schoolTeacherFEveryWeekWarning.isEmpty()) {
            return Result.ok(schoolTeacherFEveryWeekWarning);
        }else {
            LocalDate startDate = LocalDate.of(2024, 2, 26);
            String[] startDates = new String[15];
            String[] endDates = new String[15];
            Map<String,String> find = new HashMap<>();
            for (int i = 0; i < 15; i++) {
                LocalDate weekStart = startDate.plusWeeks(i);
                LocalDate weekEnd = weekStart.plusDays(6);
                startDates[i] = weekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDates[i] = weekEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sum = userHealthDailyService.FindEveryWeekWarning("teacher","女",startDates[i],endDates[i]);
                find.put("第"+(i+1) +"周",sum);
            }
            Map<String, String> sortedMap = new TreeMap<>((o1, o2) -> {
                int week1 = Integer.parseInt(o1.substring(1, o1.length() - 1));
                int week2 = Integer.parseInt(o2.substring(1, o2.length() - 1));
                return Integer.compare(week1, week2);
            });
            sortedMap.putAll(find);
            redisCache.setCacheMap("schoolTeacherFEveryWeekWarning", sortedMap);
            redisCache.expire("schoolTeacherFEveryWeekWarning", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindLogisticsMEveryWeekWarning")
    @Operation(summary = " 管理端可视化界面男后勤每日预警人数")
    public Result FindLogisticsMEveryWeekWarning(){
        Map<String,String> schoolLogisticsMEveryWeekWarning = redisCache.getCacheMap("schoolLogisticsMEveryWeekWarning");
        if (schoolLogisticsMEveryWeekWarning!=null&&!schoolLogisticsMEveryWeekWarning.isEmpty()) {
            return Result.ok(schoolLogisticsMEveryWeekWarning);
        }else {
            LocalDate startDate = LocalDate.of(2024, 2, 26);
            String[] startDates = new String[15];
            String[] endDates = new String[15];
            Map<String,String> find = new HashMap<>();
            for (int i = 0; i < 15; i++) {
                LocalDate weekStart = startDate.plusWeeks(i);
                LocalDate weekEnd = weekStart.plusDays(6);
                startDates[i] = weekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDates[i] = weekEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sum = userHealthDailyService.FindEveryWeekWarning("logistics","男",startDates[i],endDates[i]);
                find.put("第"+(i+1) +"周",sum);
            }
            Map<String, String> sortedMap = new TreeMap<>((o1, o2) -> {
                int week1 = Integer.parseInt(o1.substring(1, o1.length() - 1));
                int week2 = Integer.parseInt(o2.substring(1, o2.length() - 1));
                return Integer.compare(week1, week2);
            });
            sortedMap.putAll(find);
            redisCache.setCacheMap("schoolLogisticsMEveryWeekWarning", sortedMap);
            redisCache.expire("schoolLogisticsMEveryWeekWarning", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindLogisticsFEveryWeekWarning")
    @Operation(summary = " 管理端可视化界面女后勤每周预警人数")
    public Result FindLogisticsFEveryFWeekWarning(){
        Map<String,String> schoolLogisticsFEveryWeekWarning = redisCache.getCacheMap("schoolLogisticsFEveryWeekWarning");
        if (schoolLogisticsFEveryWeekWarning!=null&&!schoolLogisticsFEveryWeekWarning.isEmpty()) {
            return Result.ok(schoolLogisticsFEveryWeekWarning);
        }else {
            LocalDate startDate = LocalDate.of(2024, 2, 26);
            String[] startDates = new String[15];
            String[] endDates = new String[15];
            Map<String,String> find = new HashMap<>();
            for (int i = 0; i < 15; i++) {
                LocalDate weekStart = startDate.plusWeeks(i);
                LocalDate weekEnd = weekStart.plusDays(6);
                startDates[i] = weekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDates[i] = weekEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String sum = userHealthDailyService.FindEveryWeekWarning("logistics","女",startDates[i],endDates[i]);
                find.put("第"+(i+1) +"周",sum);
            }
            Map<String, String> sortedMap = new TreeMap<>((o1, o2) -> {
                int week1 = Integer.parseInt(o1.substring(1, o1.length() - 1));
                int week2 = Integer.parseInt(o2.substring(1, o2.length() - 1));
                return Integer.compare(week1, week2);
            });
            sortedMap.putAll(find);
            redisCache.setCacheMap("schoolLogisticsFEveryWeekWarning", sortedMap);
            redisCache.expire("schoolLogisticsFEveryWeekWarning", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }
    @GetMapping("/FindStudentMotion")
    @Operation(summary = " 管理端可视化界面学生运动人数占比")
    public Result FindStudentMotion(){
        Map<String, Object> schoolStudentMotion = redisCache.getCacheMap("schoolStudentMotion");
        if (schoolStudentMotion!=null&&!schoolStudentMotion.isEmpty()) {
            return Result.ok(schoolStudentMotion);
        }else {
            String sexM = userHealthDailyService.FindStudentMotion("student","男");
            String sexF = userHealthDailyService.FindStudentMotion("student","女");
            Map<String, Object> find = new HashMap<>();
            find.put("男", sexM);
            find.put("女", sexF);
            redisCache.setCacheMap("schoolStudentMotion", find);
            redisCache.expire("schoolStudentMotion", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindTeacherMotion")
    @Operation(summary = " 管理端可视化界面老师运动人数占比")
    public Result FindTeacherMotion(){
        Map<String, Object> schoolTeacherMotion = redisCache.getCacheMap("schoolTeacherMotion");
        if (schoolTeacherMotion!=null&&!schoolTeacherMotion.isEmpty()) {
            return Result.ok(schoolTeacherMotion);
        }else {
            String sexM = userHealthDailyService.FindStudentMotion("teacher","男");
            String sexF = userHealthDailyService.FindStudentMotion("teacher","女");
            Map<String, Object> find = new HashMap<>();
            find.put("男", sexM);
            find.put("女", sexF);
            redisCache.setCacheMap("schoolTeacherMotion", find);
            redisCache.expire("schoolTeacherMotion", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindLogisticsMotion")
    @Operation(summary = " 管理端可视化界面后勤运动人数占比")
    public Result FindLogisticsMotion(){
        Map<String, Object> schoolLogisticsMotion = redisCache.getCacheMap("schoolLogisticsMotion");
        if (schoolLogisticsMotion!=null&&!schoolLogisticsMotion.isEmpty()) {
            return Result.ok(schoolLogisticsMotion);
        }else {
            String sexM = userHealthDailyService.FindStudentMotion("logistics","男");
            String sexF = userHealthDailyService.FindStudentMotion("logistics","女");
            Map<String, Object> find = new HashMap<>();
            find.put("男", sexM);
            find.put("女", sexF);
            redisCache.setCacheMap("schoolLogisticsMotion", find);
            redisCache.expire("schoolLogisticsMotion", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindStudentFever")
    @Operation(summary = " 管理端可视化界面学生发烧人数占比")
    public Result FindStudentFever(){
        Map<String, Object> schoolStudentFever = redisCache.getCacheMap("schoolStudentFever");
        if (schoolStudentFever!=null&&!schoolStudentFever.isEmpty()) {
            return Result.ok(schoolStudentFever);
        }else {
            String sexM = userHealthDailyService.FindStudentFever("student","男");
            String sexF = userHealthDailyService.FindStudentFever("student","女");
            Map<String, Object> find = new HashMap<>();
            find.put("男", sexM);
            find.put("女", sexF);
            redisCache.setCacheMap("schoolStudentFever", find);
            redisCache.expire("schoolStudentFever", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindTeacherFever")
    @Operation(summary = " 管理端可视化界面教师发烧人数占比")
    public Result FindTeacherFever(){
        Map<String, Object> schoolTeacherFever = redisCache.getCacheMap("schoolTeacherFever");
        if (schoolTeacherFever!=null&&!schoolTeacherFever.isEmpty()) {
            return Result.ok(schoolTeacherFever);
        }else {
            String sexM = userHealthDailyService.FindStudentFever("teacher","男");
            String sexF = userHealthDailyService.FindStudentFever("teacher","女");
            Map<String, Object> find = new HashMap<>();
            find.put("男", sexM);
            find.put("女", sexF);
            redisCache.setCacheMap("schoolTeacherFever", find);
            redisCache.expire("schoolTeacherFever", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindLogisticsFever")
    @Operation(summary = " 管理端可视化界面学生发烧人数占比")
    public Result FindLogisticsFever(){
        Map<String, Object> schoolLogisticsFever = redisCache.getCacheMap("schoolLogisticsFever");
        if (schoolLogisticsFever!=null&&!schoolLogisticsFever.isEmpty()) {
            return Result.ok(schoolLogisticsFever);
        }else {
            String sexM = userHealthDailyService.FindStudentFever("logistics","男");
            String sexF = userHealthDailyService.FindStudentFever("logistics","女");
            Map<String, Object> find = new HashMap<>();
            find.put("男", sexM);
            find.put("女", sexF);
            redisCache.setCacheMap("schoolLogisticsFever", find);
            redisCache.expire("schoolLogisticsFever", 1, TimeUnit.HOURS);
            return Result.ok(find);
        }
    }

    @GetMapping("/FindStudentEveryMonthAvgStep")
    @Operation(summary = " 管理端可视化界面学生每个月平均步数")
    public Result FindStudentEveryMonthAvgStep(){
        Map<String, Object> schoolLogisticsFever = redisCache.getCacheMap("schoolStudentEveryMonthAvgStep");
        if (schoolLogisticsFever!=null&&!schoolLogisticsFever.isEmpty()) {
            return Result.ok(schoolLogisticsFever);
        }else {
            List<FindStudentEveryMonthAvgStep> list = userHealthDailyService.FindStudentEveryMonthAvgStep("student");
            Map<String, Object> find = new HashMap<>();
            for (FindStudentEveryMonthAvgStep findStudentEveryMonthAvgStep : list) {
                find.put(findStudentEveryMonthAvgStep.getMonth(), findStudentEveryMonthAvgStep.getAvgStep());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolStudentEveryMonthAvgStep", sortedMap);
            redisCache.expire("schoolStudentEveryMonthAvgStep", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindTeacherEveryMonthAvgStep")
    @Operation(summary = " 管理端可视化界面教师每个月平均步数")
    public Result FindTeacherEveryMonthAvgStep(){
        Map<String, Object> schoolTeacherEveryMonthAvgStep = redisCache.getCacheMap("schoolTeacherEveryMonthAvgStep");
        if (schoolTeacherEveryMonthAvgStep!=null&&!schoolTeacherEveryMonthAvgStep.isEmpty()) {
            return Result.ok(schoolTeacherEveryMonthAvgStep);
        }else {
            List<FindStudentEveryMonthAvgStep> list = userHealthDailyService.FindStudentEveryMonthAvgStep("teacher");
            Map<String, Object> find = new HashMap<>();
            for (FindStudentEveryMonthAvgStep findStudentEveryMonthAvgStep : list) {
                find.put(findStudentEveryMonthAvgStep.getMonth(), findStudentEveryMonthAvgStep.getAvgStep());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolTeacherEveryMonthAvgStep", sortedMap);
            redisCache.expire("schoolTeacherEveryMonthAvgStep", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindLogisticsEveryMonthAvgStep")
    @Operation(summary = " 管理端可视化界面后勤每个月平均步数")
    public Result FindLogisticsEveryMonthAvgStep(){
        Map<String, Object> schoolLogisticsEveryMonthAvgStep = redisCache.getCacheMap("schoolLogisticsEveryMonthAvgStep");
        if (schoolLogisticsEveryMonthAvgStep!=null&&!schoolLogisticsEveryMonthAvgStep.isEmpty()) {
            return Result.ok(schoolLogisticsEveryMonthAvgStep);
        }else {
            List<FindStudentEveryMonthAvgStep> list = userHealthDailyService.FindStudentEveryMonthAvgStep("logistics");
            Map<String, Object> find = new HashMap<>();
            for (FindStudentEveryMonthAvgStep findStudentEveryMonthAvgStep : list) {
                find.put(findStudentEveryMonthAvgStep.getMonth(), findStudentEveryMonthAvgStep.getAvgStep());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolLogisticsEveryMonthAvgStep", sortedMap);
            redisCache.expire("schoolLogisticsEveryMonthAvgStep", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindStudentMEveryFeverSum")
    @Operation(summary = " 管理端可视化界面男学生每个月发烧人数")
    public Result FindStudentMEveryFeverSum(){
        Map<String, Object> schoolStudentMEveryFeverSum = redisCache.getCacheMap("schoolStudentMEveryFeverSum");
        if (schoolStudentMEveryFeverSum!=null&&!schoolStudentMEveryFeverSum.isEmpty()) {
            return Result.ok(schoolStudentMEveryFeverSum);
        }else {
            List<EveryDayWarning> list = userHealthDailyService.FindStudentMEveryFeverSum("student","男");
            Map<String, Object> find = new HashMap<>();
            for (EveryDayWarning everyDayWarning : list) {
                find.put(everyDayWarning.getMonth(), everyDayWarning.getSum());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolStudentMEveryFeverSum", sortedMap);
            redisCache.expire("schoolStudentMEveryFeverSum", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindStudentFEveryFeverSum")
    @Operation(summary = " 管理端可视化界面女学生每个月发烧人数")
    public Result FindStudentFEveryFeverSum(){
        Map<String, Object> schoolStudentFEveryFeverSum = redisCache.getCacheMap("schoolStudentFEveryFeverSum");
        if (schoolStudentFEveryFeverSum!=null&&!schoolStudentFEveryFeverSum.isEmpty()) {
            return Result.ok(schoolStudentFEveryFeverSum);
        }else {
            List<EveryDayWarning> list = userHealthDailyService.FindStudentMEveryFeverSum("student","女");
            System.out.println(list);
            Map<String, Object> find = new HashMap<>();
            for (EveryDayWarning everyDayWarning : list) {
                find.put(everyDayWarning.getMonth(), everyDayWarning.getSum());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolStudentFEveryFeverSum", sortedMap);
            redisCache.expire("schoolStudentFEveryFeverSum", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindTeacherMEveryFeverSum")
    @Operation(summary = " 管理端可视化界面男教师每个月发烧人数")
    public Result FindTeacherMEveryFeverSum(){
        Map<String, Object> schoolTeacherMEveryFeverSum = redisCache.getCacheMap("schoolTeacherMEveryFeverSum");
        if (schoolTeacherMEveryFeverSum!=null&&!schoolTeacherMEveryFeverSum.isEmpty()) {
            return Result.ok(schoolTeacherMEveryFeverSum);
        }else {
            List<EveryDayWarning> list = userHealthDailyService.FindStudentMEveryFeverSum("teacher","男");
            System.out.println(list);
            Map<String, Object> find = new HashMap<>();
            for (EveryDayWarning everyDayWarning : list) {
                find.put(everyDayWarning.getMonth(), everyDayWarning.getSum());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolTeacherMEveryFeverSum", sortedMap);
            redisCache.expire("schoolTeacherMEveryFeverSum", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindTeacherFEveryFeverSum")
    @Operation(summary = " 管理端可视化界面女教师每个月发烧人数")
    public Result FindTeacherFEveryFeverSum(){
        Map<String, Object> schoolTeacherFEveryFeverSum = redisCache.getCacheMap("schoolTeacherFEveryFeverSum");
        if (schoolTeacherFEveryFeverSum!=null&&!schoolTeacherFEveryFeverSum.isEmpty()) {
            return Result.ok(schoolTeacherFEveryFeverSum);
        }else {
            List<EveryDayWarning> list = userHealthDailyService.FindStudentMEveryFeverSum("teacher","女");
            System.out.println(list);
            Map<String, Object> find = new HashMap<>();
            for (EveryDayWarning everyDayWarning : list) {
                find.put(everyDayWarning.getMonth(), everyDayWarning.getSum());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolTeacherFEveryFeverSum", sortedMap);
            redisCache.expire("schoolTeacherFEveryFeverSum", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindLogisticsMEveryFeverSum")
    @Operation(summary = " 管理端可视化界面男后勤每个月发烧人数")
    public Result FindLogisticsMEveryFeverSum(){
        Map<String, Object> schoolLogisticsMEveryFeverSum = redisCache.getCacheMap("schoolLogisticsMEveryFeverSum");
        if (schoolLogisticsMEveryFeverSum!=null&&!schoolLogisticsMEveryFeverSum.isEmpty()) {
            return Result.ok(schoolLogisticsMEveryFeverSum);
        }else {
            List<EveryDayWarning> list = userHealthDailyService.FindStudentMEveryFeverSum("logistics","男");
            System.out.println(list);
            Map<String, Object> find = new HashMap<>();
            for (EveryDayWarning everyDayWarning : list) {
                find.put(everyDayWarning.getMonth(), everyDayWarning.getSum());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolLogisticsMEveryFeverSum", sortedMap);
            redisCache.expire("schoolLogisticsMEveryFeverSum", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }

    @GetMapping("/FindLogisticsFEveryFeverSum")
    @Operation(summary = " 管理端可视化界面女后勤每个月发烧人数")
    public Result FindLogisticsFEveryFeverSum(){
        Map<String, Object> schoolLogisticsFEveryFeverSum = redisCache.getCacheMap("schoolLogisticsFEveryFeverSum");
        if (schoolLogisticsFEveryFeverSum!=null&&!schoolLogisticsFEveryFeverSum.isEmpty()) {
            return Result.ok(schoolLogisticsFEveryFeverSum);
        }else {
            List<EveryDayWarning> list = userHealthDailyService.FindStudentMEveryFeverSum("logistics","女");
            System.out.println(list);
            Map<String, Object> find = new HashMap<>();
            for (EveryDayWarning everyDayWarning : list) {
                find.put(everyDayWarning.getMonth(), everyDayWarning.getSum());
            }
            TreeMap<String, Object> sortedMap = new TreeMap<>(find);
            redisCache.setCacheMap("schoolLogisticsFEveryFeverSum", sortedMap);
            redisCache.expire("schoolLogisticsFEveryFeverSum", 1, TimeUnit.HOURS);
            return Result.ok(sortedMap);
        }
    }



}
