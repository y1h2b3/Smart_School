package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.UserHealthDaily;
import com.smart.www.pojo.Vo.EveryDayWarning;
import com.smart.www.pojo.Vo.FindStudentEveryMonthAvgStep;
import com.smart.www.pojo.Vo.RankList;
import com.smart.www.pojo.Vo.dateList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @description 针对表【user_health_daily】的数据库操作Mapper
 * @createDate 2024-03-26 12:48:15
 * @Entity com.smart.www.pojo.UserHealthDaily
 */
@Mapper
public interface UserHealthDailyMapper extends BaseMapper<UserHealthDaily> {
    @Select("SELECT AVG(step) FROM smart_campus.user_health_daily WHERE create_time LIKE CONCAT(#{NewDate},'%')")
    String FindAllAvgSteps(String NewDate);

    @Select("SELECT AVG(sleep_time_total) FROM smart_campus.user_health_daily WHERE create_time LIKE CONCAT(#{NewDate},'%')")
    String FindAllAvgSleep(String newDate);
    @Select("select count(*) from smart_campus.health_warning_notifications where level=#{rank} and create_time like concat(#{NewDate},'%') and user_id like concat(#{type},'%')")
    String FindAllWarning(String rank,String NewDate,String type);
    @Select("select AVG(${fatPercentage}) from smart_campus.user_health")
    String FindBodyIndex(String fatPercentage);

    @Select("select count(*) from smart_campus.${count}")
    String FindAllCount(String count);

    @Select("SELECT SUM(count_value) AS total_count  \n" +
            "FROM (  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '男'  \n" +
            "      AND u.height >= 165  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) <= 15 and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '男'  \n" +
            "      AND u.height >= 178  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) > 15  and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '女'  \n" +
            "      AND u.height >= 153  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) <= 15  and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')   \n" +
            "      AND s.sex = '女'  \n" +
            "      AND u.height >= 165  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) > 15 and user_id like concat(#{rem},'%')  \n" +
            ") AS combined_counts ")
    String excellentHeight(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and calorie>=1400 and user_id like concat(#{rem},'%')")
    String excellentCalorie(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and sleep_time_total>=9 and user_id like concat(#{rem},'%')")
    String excellentSleep(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and step>=10000 and user_id like concat(#{rem},'%')")
    String excellentStep(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and walking_time>=1 and user_id like concat(#{rem},'%')")
    String excellentMotion(String date,String rem);

    @Select("SELECT\n" +
            "    (SELECT COUNT(*)\n" +
            "     FROM smart_campus.user_health u\n" +
            "     LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "     WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "     AND s.sex = '男'\n" +
            "     AND u.BMI >= 15 AND u.BMI <= 18) +\n" +
            "    (SELECT COUNT(*)\n" +
            "     FROM smart_campus.user_health u\n" +
            "     LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "     LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "     LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "     WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "     AND COALESCE(t.sex, s.sex, l.sex) = '女' and user_id like concat(#{rem},'%')\n" +
            "     AND u.BMI >= 20 AND u.BMI <= 25) AS total_count ")
    String excellentBim(String date,String rem);

    @Select("SELECT SUM(count_value) AS total_count\n" +
            "FROM (\n" +
            "    SELECT COUNT(*) AS count_value\n" +
            "    FROM smart_campus.user_health u\n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "      AND s.sex = '男'\n" +
            "      AND u.height >= 160 AND u.height < 165\n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) <= 15 and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL\n" +
            "    SELECT COUNT(*) AS count_value\n" +
            "    FROM smart_campus.user_health u\n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "      AND s.sex = '男'\n" +
            "      AND u.height >= 170 AND u.height < 178\n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) > 15 and user_id like concat(#{rem},'%')\n" +
            "    UNION ALL\n" +
            "    SELECT COUNT(*) AS count_value\n" +
            "    FROM smart_campus.user_health u\n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "      AND s.sex = '女'\n" +
            "      AND u.height >= 149 AND u.height < 153\n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) <= 15 and user_id like concat(#{rem},'%')\n" +
            "    UNION ALL\n" +
            "    SELECT COUNT(*) AS count_value\n" +
            "    FROM smart_campus.user_health u\n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "      AND s.sex = '女'\n" +
            "      AND u.height >= 153 and u.height < 165\n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) > 15 and user_id like concat(#{rem},'%')\n" +
            ") AS combined_counts;")
    String normalHeight(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and  calorie >= 1000 and calorie<1400 and user_id like concat(#{rem},'%')")
    String normalCalorie(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and sleep_time_total>=7 and sleep_time_total<9 and user_id like concat(#{rem},'%')")
    String normalSleep(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and step>=5000 and step<10000 and user_id like concat(#{rem},'%')")
    String normalStep(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and walking_time>=0.5 and walking_time<1 and user_id like concat(#{rem},'%')")
    String normalMotion(String date,String rem);

    @Select("select (SELECT(\n" +
            "SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '男'\n" +
            "AND u.BMI >= 13 and u.BMI < 15 and user_id like concat(#{rem},'%') )  +\n" +
            "(SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '男'\n" +
            "AND  u.BMI >= 19 and u.BMI <=21 and user_id like concat(#{rem},'%') ) as count) + (select (\n" +
            "    SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '女'\n" +
            "AND u.BMI > 18 and u.BMI < 20 and user_id like concat(#{rem},'%') ) +\n" +
            "       (SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '女'\n" +
            "AND u.BMI >= 21 and u.BMI <= 23 and user_id like concat(#{rem},'%') ) as count)as count")
    String normalBim(String date,String rem);

    @Select("SELECT SUM(count_value) AS total_count  \n" +
            "FROM (  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '男'  \n" +
            "      AND u.height < 165  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) <= 15 and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '男'  \n" +
            "      AND u.height < 170  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) > 15 and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '女'  \n" +
            "      AND u.height < 150  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) <= 15 and user_id like concat(#{rem},'%') \n" +
            "    UNION ALL  \n" +
            "    SELECT COUNT(*) AS count_value  \n" +
            "    FROM smart_campus.user_health u  \n" +
            "    LEFT JOIN smart_campus.student s ON u.user_id = s.student_id  \n" +
            "    WHERE u.create_time LIKE CONCAT(#{date},'%')  \n" +
            "      AND s.sex = '女'  \n" +
            "      AND u.height < 160  \n" +
            "      AND TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) > 15 and user_id like concat(#{rem},'%') \n" +
            ") AS combined_counts")
    String poorHeight(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and  calorie<1000 and user_id like concat(#{rem},'%')")
    String poorCalorie(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and sleep_time_total<7 and user_id like concat(#{rem},'%')")
    String poorSleep(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and step<5000 and user_id like concat(#{rem},'%')")
    String poorStep(String date,String rem);

    @Select("select count(*) from smart_campus.user_health where create_time LIKE CONCAT(#{date},'%') and walking_time<0.5 and user_id like concat(#{rem},'%')")
    String poorMotion(String date,String rem);

    @Select("select (SELECT(\n" +
            "SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '男'\n" +
            "AND u.BMI < 13 and user_id like concat(#{rem},'%') )+\n" +
            "(SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '男'\n" +
            "AND  u.BMI > 21 and user_id like concat(#{rem},'%') ) as count) + (select (\n" +
            "    SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '女'\n" +
            "AND u.BMI < 18 and user_id like concat(#{rem},'%') ) +\n" +
            "       (SELECT COUNT(*)\n" +
            "FROM smart_campus.user_health u\n" +
            "LEFT JOIN smart_campus.teacher t ON u.user_id = t.teacher_id\n" +
            "LEFT JOIN smart_campus.student s ON u.user_id = s.student_id\n" +
            "LEFT JOIN smart_campus.logistics l ON u.user_id = l.logistics_id\n" +
            "WHERE u.create_time LIKE CONCAT(#{date},'%')\n" +
            "AND COALESCE(t.sex, s.sex, l.sex) = '女'\n" +
            "AND u.BMI > 23 and user_id like concat(#{rem},'%') ) as count)as count")
    String poorBim(String date,String rem);

    @Select("SELECT MONTH(create_time) AS month, COUNT(*) AS count\n" +
            "FROM smart_campus.user_health_daily\n" +
            "WHERE user_id IN (\n" +
            "    SELECT user_id\n" +
            "    FROM smart_campus.user_health_daily\n" +
            "    where user_id like concat(#{s},'%')\n" +
            "    GROUP BY user_id, MONTH(create_time)\n" +
            "    HAVING SUM(walking_time) > 3\n" +
            ")\n" +
            "GROUP BY MONTH(create_time)\n" +
            "ORDER BY month")
    List<HashMap<String, Object>> FindSportsReach(String s);

    @Select("SELECT\n" +
            "    s.post as type ,\n" +
            "    SUM(IF(h.notification_id LIKE 'BIM%', 1, 0))  AS BIM,\n" +
            "    SUM(IF(h.notification_id LIKE 'HEART%', 1, 0)) AS HEART,\n" +
            "    SUM(IF(h.notification_id LIKE 'SLEEP%', 1, 0)) AS SLEEP,\n" +
            "    SUM(IF(h.notification_id LIKE 'SPO2%', 1, 0)) AS SPO2\n" +
            "FROM\n" +
            "    health_warning_notifications h\n" +
            "JOIN\n" +
            "    ${type} s ON h.user_id = s.${type}_id\n" +
            "GROUP BY\n" +
            "    s.post;")
    List<RankList> FindRankList(String type);

    @Select("SELECT\n" +
            "    s.clazz as type ,\n" +
            "    SUM(IF(h.notification_id LIKE 'BIM%', 1, 0))  AS BIM,\n" +
            "    SUM(IF(h.notification_id LIKE 'HEART%', 1, 0)) AS HEART,\n" +
            "    SUM(IF(h.notification_id LIKE 'SLEEP%', 1, 0)) AS SLEEP,\n" +
            "    SUM(IF(h.notification_id LIKE 'SPO2%', 1, 0)) AS SPO2\n" +
            "FROM\n" +
            "    health_warning_notifications h\n" +
            "JOIN\n" +
            "    student s ON h.user_id = s.student_id\n" +
            "GROUP BY\n" +
            "    s.clazz\n" +
            "limit 13;")
    List<RankList> FindStudentRankList();

    @Select("SELECT\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-03' AND u.sleep_time_total >= 8, 1, 0)) AS 'Monday',\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-04' AND u.sleep_time_total >= 8, 1, 0)) AS 'Tuesday',\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-05' AND u.sleep_time_total >= 8, 1, 0)) AS 'Wednesday',\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-06' AND u.sleep_time_total >= 8, 1, 0)) AS 'Thursday',\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-07' AND u.sleep_time_total >= 8, 1, 0)) AS 'Friday',\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-08' AND u.sleep_time_total >= 8, 1, 0)) AS 'Saturday',\n" +
            "    SUM(IF(DATE(u.create_time) = '2025-11-09' AND u.sleep_time_total >= 8, 1, 0)) AS 'Sunday'\n" +
            "FROM\n" +
            "    user_health_daily u\n" +
            "JOIN\n" +
            "    ${type} s ON u.user_id = s.${type}_id\n" +
            "WHERE\n" +
            "    DATE(u.create_time) BETWEEN '2025-11-03' AND '2025-11-09'\n" +
            "    AND u.sleep_time_total >= 8\n" +
            "    AND s.sex = #{sex};")
    List<dateList> FindSleepReach(String type, String sex);

    @Select("SELECT AVG(u.step) AS '6-8'\n" +
            "FROM user_health_daily u\n" +
            "JOIN ${type} s ON u.user_id = s.${type}_id\n" +
            "WHERE\n" +
            "    TIMESTAMPDIFF(YEAR, s.birth, CURDATE()) BETWEEN ${number} AND ${number1} and u.create_time like '2023-04%'")
    String FindAvgStepByAge(String type, String number, String number1);

    @Select("SELECT\n" +
            "    ROUND(\n" +
            "        (\n" +
            "            SELECT COUNT(*)\n" +
            "            FROM smart_campus.user_health\n" +
            "            WHERE BMI >= ${s} AND BMI <= ${s1} AND user_id LIKE CONCAT(#{type},'%')\n" +
            "        ) * 100.0 / (\n" +
            "            SELECT COUNT(*)\n" +
            "            FROM smart_campus.user_health\n where user_id LIKE CONCAT(#{type},'%')" +
            "        )\n" +
            "    ) AS percentage_within_range_rounded")
    String FindStudentFatPercentage(String s, String s1,String type);

    @Select("select count(*) from \n" +
            "                    health_warning_notifications h join ${type} s on h.user_id = s.${type}_id \n" +
            "                where s.sex = #{sex} and h.create_time >= #{startDate} and h.create_time <= #{endDate}")
    String FindEveryWeekWarning(String type, String sex, String startDate, String endDate);

    @Select("SELECT\n" +
            "    ROUND(\n" +
            "        (SELECT COUNT(*)\n" +
            "         FROM user_health u\n" +
            "         JOIN smart_campus.${type} s ON u.user_id = s.${type}_id\n" +
            "         WHERE walking_time >= 1 AND s.sex = #{sex})\n" +
            "        * 100.0 /\n" +
            "        (SELECT COUNT(*)\n" +
            "         FROM user_health u\n" +
            "         JOIN smart_campus.${type} s ON u.user_id = s.${type}_id\n" +
            "         WHERE walking_time >= 1)\n" +
            "        , 0) AS IntegerPercentageOfMaleWalking\n")
    String FindStudentMotion(String type,String sex);

    @Select("SELECT ROUND(\n" +
            "               (SELECT distinct COUNT(user_id)\n" +
            "                FROM health_warning_notifications u\n" +
            "                    JOIN smart_campus.${type} s ON u.user_id = s.${type}_id\n" +
            "                WHERE u.type = '体温过高'  and s.sex= #{sex}) * 100.0 /\n" +
            "               (SELECT distinct COUNT(user_id)\n" +
            "                FROM health_warning_notifications u\n" +
            "                    JOIN smart_campus.${type} s ON u.user_id = s.${type}_id\n" +
            "                WHERE u.type = '体温过高' ) ,0) AS IntegerPercentageOfMaleWalking")
    String FindStudentFever(String type, String sex);

    @Select("SELECT DATE_FORMAT(u.create_time, '%m') AS month, TRUNCATE(AVG(step), 0) AS avg_step\n" +
            "FROM user_health_daily u\n" +
            "JOIN smart_campus.${type} s ON u.user_id = s.${type}_id\n" +
            "GROUP BY DATE_FORMAT(u.create_time, '%m') order by month")
    List<FindStudentEveryMonthAvgStep> FindStudentEveryMonthAvgStep(String type);

    @Select("SELECT DATE_FORMAT(u.create_time, '%m') AS month, COUNT(*) AS Sum\n" +
            "FROM user_health_daily u\n" +
            "JOIN ${type} s ON u.user_id = s.${type}_id\n" +
            "WHERE s.sex = #{sex} and u.temperature >= '39'\n" +
            "GROUP BY DATE_FORMAT(u.create_time, '%m') order by month;")
    List<EveryDayWarning> FindStudentMEveryFeverSum(String type, String sex);

    @Select("select type as name,count(*) as value from health_warning_notifications where user_id = #{id} group by type;")
    List<Map<String, String>> findUserIdHealth(String id);

    @Select("select s.name as name, u.step as step from user_health u left join student s on s.student_id = u.user_id  order by u.step desc limit 100;")
    List<Map<String, String>> findAllStep();

    @Select("select s.name as name, u.step as step from user_health u left join student s on s.student_id = u.user_id where u.user_id = #{id};")
    List<Map<String, String>> findMyStep(String id);

    @Select("SELECT\n" +
            "    level as level,count(*) as count \n" +
            "FROM health_warning_notifications u\n" +
            "LEFT JOIN student s ON s.student_id = u.user_id group by level;")
    List<Map<String, String>> findAllStudentRank();

    @Select("SELECT\n" +
            "    u.type as 'type',count(*)\n as 'number'" +
            "FROM health_warning_notifications u\n" +
            "LEFT JOIN student s ON s.student_id = u.user_id group by u.type;")
    List<Map<String, String>> findAllStudentWarning();
}




