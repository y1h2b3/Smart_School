package com.smart.www.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.smart.www.pojo.User;
import com.smart.www.pojo.Vo.UserNameVo;
import com.smart.www.service.UserService;
import com.smart.www.util.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * 登录测试
 */
@RestController
@Tag(name = "登录接口")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisCache redisCache;


    // 测试登录  ---- http://localhost:8081/Login/Admin?name=admin&pwd=123
    @GetMapping("/Login/Admin")
    @Operation(summary = "管理员账号登录")
    public Result AdminLogin(String name, String pwd) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount, name);
        User user = userService.getOne(queryWrapper);
        if (user.getAccount().equals(name)) {
            if (SaltMD5Util.verifySaltPassword(pwd, user.getPassword())) {
                StpUtil.login(name, true);
                SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
                tokenInfo.setLoginType("管理员");
                return Result.ok(tokenInfo);
            } else {
                return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        }
        return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
    }
    //http://localhost:8081/Login/User?phone=15578240762&pwd=password65
    @GetMapping("/Login/User")
    @Operation(summary = "用户账号登录")
    public Result UserLogin(String phone, String pwd) {
        List<UserNameVo> user = userService.findUser(phone);
        if (user.get(0).getPhone().equals(phone)) {
            if (user.get(0).getPassword().equals(pwd)) {
                System.out.println(user.get(0).getType());
                SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
                tokenInfo.setLoginType(user.get(0).getType());
                return Result.ok(tokenInfo);
            } else {
                return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        }
        return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
    }


    // 查询登录状态  ---- http://localhost:8081/isLogin
    @GetMapping("/isAdminLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/tokenInfo
    @GetMapping("/tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/logout
    @GetMapping("/Logout")
    @Operation(summary = "账号注销")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @GetMapping("/getSMS")
    public SaResult getSMS(String phone) throws Exception {
        Random r = new Random();
        String phoneRegex = "^1[3-9]\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        List<UserNameVo> user = userService.findUser(phone);
        boolean phoneBoolean = (pattern.matcher(phone).matches());
        if (user.isEmpty()){
            return SaResult.error("手机号不存在");
        }
        if (phoneBoolean) {
            if (phone.equals(user.get(0).getPhone())) {
                int i = r.nextInt(9000) + 1000;
                Config config = new Config()
                        .setAccessKeyId("LTAI5tRS9iZbcMgRMykkeEzC")
                        .setAccessKeySecret("EAR5ViQ9iMkiHTRHlxH1UEChidpsmU");
                config.endpoint = "dysmsapi.aliyuncs.com";
                Client client = new Client(config);
                SendSmsRequest sendSmsRequest = new SendSmsRequest()
                        .setSignName("阿里云短信测试")//短信签名
                        .setTemplateCode("SMS_154950909")//短信模板
                        .setPhoneNumbers(phone)//这里填写接受短信的手机号码
                        .setTemplateParam("{\"code\":" + i + "}");//验证码
                client.sendSms(sendSmsRequest);
                redisCache.setCacheObject(phone, i);
                redisCache.expire(phone, 300);
            }
        } else {
            return SaResult.error("手机号格式错误");
        }
        return SaResult.ok();
    }



    @GetMapping("/checkSMS")
    public Result checkSMS(String phone, String code) {
        String phoneRegex = "^1[3-9]\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        List<UserNameVo> user = userService.findUser(phone);
        String code1 = redisCache.getCacheObject(phone).toString();
        if (pattern.matcher(phone).matches()) {
            if (phone.equals(user.get(0).getPhone())) {
                if (code.equals(code1)) {
                    StpUserUtil.login(phone, true);
                    SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
                    tokenInfo.setLoginType(user.get(0).getType());
                    return Result.ok(tokenInfo);
                } else {
                    return Result.build(504,"验证码错误");
                }
            } else {
                return Result.build(505,"手机号不存在");
            }
        } else {
            return Result.build(506,"手机号格式错误");
        }
    }



}
