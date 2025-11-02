package com.smart.www.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class LockTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    // 添加消息
    Long addWarningNotice(String userid, String msg) {
        ListOperations<String, String> ops = stringRedisTemplate.opsForList();
        return ops.rightPush("warn:" + userid, msg);
    }
    // 获取是否存在消息
    String isEmptyWaringNotice(String userid) {
        ListOperations<String, String> ops = stringRedisTemplate.opsForList();
        String msg = ops.leftPop("warn:"+userid);
        return msg;
    }
    @Test
    void test01() {
        String userid = "202203130192";
        String msg = "紧急通知";
        String getMsg = isEmptyWaringNotice(userid);
        if(getMsg == null) {
            System.out.println("暂未接收到预警通知");
        }else {
            System.out.println("接受预警通知: "+getMsg);
        }
        addWarningNotice(userid, msg);
        getMsg = isEmptyWaringNotice(userid);
        if(getMsg == null) {
            System.out.println("暂未接收到预警通知");
        }else {
            System.out.println("接受预警通知: "+getMsg);
        }
    }
}
