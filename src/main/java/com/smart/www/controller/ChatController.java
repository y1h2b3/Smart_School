package com.smart.www.controller;

import com.smart.www.pojo.UserHealth;
import com.smart.www.service.UserHealthService;
import com.smart.www.util.Result;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ChatController {
    private final OpenAiChatClient OpenAiChatClient;
    @Autowired
    private UserHealthService userHealthService;

    public ChatController(OpenAiChatClient openAiChatClient) {
        OpenAiChatClient = openAiChatClient;
    }

    @GetMapping("/ai")
    public Map GPT(@RequestParam(value = "message", defaultValue = "讲个笑话") String message) {
        System.out.println(message);
        System.out.println(OpenAiChatClient.call(message));
        return Map.of("message", OpenAiChatClient.call(message));
    }
    @GetMapping("/ai/Health")
    public Result getHealth(String uid) {
        List<UserHealth> userHealth = userHealthService.searchIdUserHealthType(uid);
        String message = "我的身高是" + userHealth.get(0).getHeight() +"，\n"+
                "我的体脂是" + userHealth.get(0).getBmi() +"，\n"+
                "我的脂肪率是" + userHealth.get(0).getFatPercentage() + "，\n"+
                "我昨晚累计睡眠时间是" + userHealth.get(0).getSleepTimeTotal() +"小时" +"，\n"+
                "我昨晚累计深睡眠时间是" + userHealth.get(0).getDeepSleepTotal()+"小时" +"，\n"+
                "我昨晚累计浅睡眠时间是" + userHealth.get(0).getDeepSleepTotal()+"小时" +"，\n"+
                "我昨天平均静息心率是" + userHealth.get(0).getMeanRestingHeartRate()+"，\n"+
                "我昨天静息心率最高是" + userHealth.get(0).getRestingHeartRateMax()+"，\n"+
                "我昨天静息心率最低是" + userHealth.get(0).getRestingHeartRateMin()+"，\n"+
                "我今日步数是" + userHealth.get(0).getStep() +"\n"+
                "我今日运动时长是" + userHealth.get(0).getWalkingTime()+"小时，针对我的健康数据，给我有效性建议，不要长篇大论，简短为宜,给我的格式为：\n" +
                "一、第一条建议\n" +
                "二、第一条建议\n" +
                "三、第一条建议\n" +
                "四、第一条建议\n" +
                "五、第一条建议\n" +
                "六、第一条建议\n";
        System.out.println(message);
        String call = OpenAiChatClient.call(message);
        return Result.ok(call);


    }


}
