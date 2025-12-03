package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.HealthCheckMapper;
import com.smart.www.pojo.HealthWarningNotifications;
import com.smart.www.pojo.UserHealth;
import com.smart.www.service.HealthCheckService;
import com.smart.www.service.HealthWarningNotificationsService;
import com.smart.www.service.UserHealthService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

public class HealthCheckImpl extends ServiceImpl<HealthCheckMapper, UserHealth>
        implements HealthCheckService {
    private final ChatModel chatModel;
    @Autowired
    private UserHealthService userHealth;
    @Autowired
    private HealthCheckMapper healthCheck;
    @Autowired
    private HealthWarningNotificationsService healthWarning;

    public HealthCheckImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public static int getHoursFromString(String timeString) {
        int hours = 0;
        // 使用正则表达式匹配第一个数字
        Matcher matcher = Pattern.compile("\\d+").matcher(timeString);
        if (matcher.find()) {
            hours = Integer.parseInt(matcher.group());
        }
        return hours;
    }

    public static int getSum(String timeString) {
        int hours = 0;
        // 使用正则表达式匹配第一个数字
        Matcher matcher = Pattern.compile("(\\d{2})").matcher(timeString);
        if (matcher.find()) {
            hours = Integer.parseInt(matcher.group());
        }
        return hours;
    }

    @Override
    public void healthCheck() {
        Random random = new Random();
        List<UserHealth> list = healthCheck.healthCheck();
        for (int i = 0; i < list.size(); i++) {
            double bmi = list.get(i).getBmi().doubleValue();
            if (bmi < 18.5 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("B")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("BIM" + random.nextInt(900000));
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("体脂过低");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("体脂");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getBmi()));
                healthWarningNotifications.setRecommendedAction("增加营养摄入量，选择高蛋白质、高纤维和高热量的食物，以维持健康的体重和营养平衡");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "B");
                healthWarning.save(healthWarningNotifications);
                System.out.println(!healthCheck.healthCheck().get(i).getCheckWarning().contains("B"));
                System.out.println(healthCheck.healthCheck().get(i).getCheckWarning());
                System.out.println(healthCheck.healthCheck().get(i).getUserId());
            } else if (bmi >= 25 && bmi <= 30 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("B")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("BIM" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("体脂偏高");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("体脂");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getBmi()));
                healthWarningNotifications.setRecommendedAction("加强运动，控制饮食，以减轻体重");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "B");
                healthWarning.save(healthWarningNotifications);
            } else if (bmi > 30 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("B")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("BIM" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("体脂过高");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("体脂");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getBmi()));
                healthWarningNotifications.setRecommendedAction("增加有氧运动，如跑步、游泳或骑自行车，每周至少进行150分钟的中等强度有氧运动");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "B");
                healthWarning.save(healthWarningNotifications);
            }
            int sleepTimeTotal = getHoursFromString(list.get(i).getSleepTimeTotal());
            if (sleepTimeTotal >= 5 && sleepTimeTotal < 7 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("S")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SLEEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("睡眠偏短");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("睡眠");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getSleepTimeTotal()));
                healthWarningNotifications.setRecommendedAction("调整睡眠时间至每晚7至9小时，以确保充足的睡眠");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "S");
                healthWarning.save(healthWarningNotifications);
            } else if (sleepTimeTotal <= 5 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("S")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SLEEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("睡眠太短");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("睡眠");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getSleepTimeTotal()));
                healthWarningNotifications.setRecommendedAction("调整睡眠时间至每晚7至9小时，以确保充足的睡眠");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "S");
                healthWarning.save(healthWarningNotifications);
            }
            int deepSleepTotal = getHoursFromString(list.get(i).getDeepSleepTotal());
            if (deepSleepTotal < 2 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("D")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SLEEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("深睡眠过低");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("睡眠");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getDeepSleepTotal()));
                healthWarningNotifications.setRecommendedAction("尽量保持规律的作息时间，并创造一个舒适的睡眠环境，提高深睡眠质量");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "D");
                healthWarning.save(healthWarningNotifications);
            } else if (deepSleepTotal > 3 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("D")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SLEEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("深睡眠过高");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("睡眠");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getDeepSleepTotal()));
                healthWarningNotifications.setRecommendedAction("尽量规律作息时间、适度的运动和放松技巧，以帮助调节睡眠质量");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "D");
                healthWarning.save(healthWarningNotifications);
            }
            int lightSleepTotal = getHoursFromString(list.get(i).getLightSleepTotal());
            if (lightSleepTotal < 2 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("L")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SLEEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("浅睡眠过低");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("睡眠");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getLightSleepTotal()));
                healthWarningNotifications.setRecommendedAction("建议起床进行适量活动，睡前喝牛奶、吃香蕉等有助于改善睡眠");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "L");
                healthWarning.save(healthWarningNotifications);
            } else if (lightSleepTotal > 10 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("L")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SLEEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("浅睡眠过高");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("睡眠");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getLightSleepTotal()));
                healthWarningNotifications.setRecommendedAction("建议适当运动、调整饮食，避免长时间熬夜进行缓解");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "L");
                healthWarning.save(healthWarningNotifications);
            }
            int step = Integer.parseInt(list.get(i).getStep());
            if (step < 1000 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("T")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("STEP" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("运动量过低");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("运动");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getStep()));
                healthWarningNotifications.setRecommendedAction("建议增加运动量，进行一些有氧运动，如跑步、游泳等");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "T");
                healthWarning.save(healthWarningNotifications);
            }
            Double calorie = Double.parseDouble(list.get(i).getCalorie());
            if (calorie < 1000 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("I")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("CALORIE" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("热量摄入过低");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("热量");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getCalorie()));
                healthWarningNotifications.setRecommendedAction("建议增加热量摄入，如多吃高热量的食物，如肉类、蛋类、奶类等");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "I");
                healthWarning.save(healthWarningNotifications);
            }
            int meanRestingHeartRate = getSum(list.get(i).getMeanRestingHeartRate());
            if (meanRestingHeartRate < 60 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("M")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("HEART" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("心率过低");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("心率");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getMeanRestingHeartRate()));
                healthWarningNotifications.setRecommendedAction("需要立即去附近医院检查");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "M");
                healthWarning.save(healthWarningNotifications);
            } else if (meanRestingHeartRate > 100 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("M")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("HEART" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("心率过高");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("心率");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getMeanRestingHeartRate()));
                healthWarningNotifications.setRecommendedAction("需要立即去附近医院检查");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "M");
                healthWarning.save(healthWarningNotifications);
            }
            double spo2 = Double.parseDouble(String.valueOf(list.get(i).getSpo2()));
            if (spo2 < 90 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("P")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("SPO2" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("血氧饱和度过低");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("血氧饱和度");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getSpo2()));
                healthWarningNotifications.setRecommendedAction("可能出现心理不适，请尽快检查");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "P");
                healthWarning.save(healthWarningNotifications);
            }
            double temperature = Double.parseDouble(list.get(i).getTemperature().split("°C")[0]);
            if (temperature > 37.5 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("E")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("TEMPERATURE" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("体温过高");
                healthWarningNotifications.setLevel("高");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("体温");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getTemperature()));
                healthWarningNotifications.setRecommendedAction("可能出现发烧症状，请尽快检查");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "E");
                healthWarning.save(healthWarningNotifications);
            } else if (temperature < 36.5 && !healthCheck.healthCheck().get(i).getCheckWarning().contains("E")) {
                HealthWarningNotifications healthWarningNotifications = new HealthWarningNotifications();
                healthWarningNotifications.setNotificationId("TEMPERATURE" + random.nextInt(900000) + 100000);
                healthWarningNotifications.setUserId(list.get(i).getUserId());
                healthWarningNotifications.setType("体温过低");
                healthWarningNotifications.setLevel("中");
                healthWarningNotifications.setTime(new Date());
                healthWarningNotifications.setReadingKey("体温");
                healthWarningNotifications.setReadingValue(String.valueOf(list.get(i).getTemperature()));
                healthWarningNotifications.setRecommendedAction("可能出现发烧症状，请尽快检查");
                healthWarningNotifications.setCreateTime(new Date());
                healthWarningNotifications.setUpdateTime(new Date());
                userHealth.updateCheck(list.get(i).getUserId(), healthCheck.healthCheck().get(i).getCheckWarning() + "E");
                healthWarning.save(healthWarningNotifications);
            }
        }
    }

    @Override
    public boolean UpdatehealthCheck() {
        return healthCheck.UpdatehealthCheck() > 0;
    }
}
