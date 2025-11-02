package com.smart.www.test;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.controller.*;
import com.smart.www.mapper.*;
import com.smart.www.pojo.LogsData;
import com.smart.www.pojo.Orders;
import com.smart.www.pojo.Teacher;
import com.smart.www.pojo.UserHealth;
import com.smart.www.pojo.Vo.StudentHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.StudentVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.*;
import com.smart.www.util.Result;
import com.smart.www.util.SaltMD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;


@SpringBootTest
public class UserTest {
    @Autowired
    private UserHealthController userHealthController;
    @Autowired
    private StudentController studentController;
    @Autowired
    private ParentMapper parentMapper;
    @Autowired
    private ParentService parentService;
    @Autowired
    private DrugsController drugsController;
    @Autowired
    private DrugsService drugsService;
    @Autowired
    private DrugsMapper drugsMapper;
    private PageQuery pageQuery;
    @Autowired
    private HospitalsController hospitalsController;
    @Autowired
    private DrugsHospitalsRelationService drugsHospitalsRelationService;
    @Autowired
    private HealthWarningNotificationsService healthWarningNotificationsService;
    @Autowired
    private UserHealthDailyMapper userHealthDailyMapper;
    @Autowired
    private NotificationsMapper NotificationsMapper;
    @Autowired
    private HealthWarningNotificationsService healthService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserHealthMapper userHealthMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private StaffOrdersService StaffordersService;
    @Autowired
    private StaffOrdersMapper StaffOrdersMapper;
    @Autowired
    private HealthCheckMapper healthCheck;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherController teacherController;
    @Autowired
    private LogsDataService logsDataService;
    @Autowired
    private LogsDataMapper logsDataMapper;
    @Test
    public void test01() {
        // 第1步，先登录上
        StpUtil.login(10001);
        // 第2步，获取 Token  相关参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 第3步，返回给前端
        System.out.println(tokenInfo);
    }

    @Test
    public void test02() {
        pageQuery = new PageQuery();
        pageQuery.setCurrent(1);
        pageQuery.setSize(5);
        Page<StudentHealthWarningNotificationsVo> allStudentHealthWarningNotifications = healthWarningNotificationsService.findAllStudentHealthWarningNotifications(pageQuery);
        allStudentHealthWarningNotifications.getRecords().forEach(System.out::println);
    }

    @Test
    public void test03() {
        PageQuery pageQuery1 = new PageQuery();
        pageQuery1.setCurrent(2);
        pageQuery1.setSize(100);
        Page<LogsData> logsDataPage = logsDataService.searchLogsData(pageQuery1, null, null, null, null, null);
        logsDataPage.getRecords().forEach(System.out::println);
        System.out.println(logsDataPage.getTotal());
    }
    @Test
    public void test04() {

    }

    @Test
    public void test05() {
        List<UserHealth> list = healthCheck.healthCheck();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCheckWarning());
        }
    }

    @Test
    public void test06() {
        SaltMD5Util saltMD5Util = new SaltMD5Util();
        // 原密码
        String password = "123";
        System.out.println("明文(原生)密码：" + password);
        // 获取加盐后的MD5值
        String SaltPassword = saltMD5Util.generateSaltPassword(password);
        System.out.println("加盐后的密码：" + SaltPassword);
        System.out.println("加盐后的密码和原生密码是否是同一字符串:" + saltMD5Util.verifySaltPassword(password, SaltPassword));
    }

    @Test
    public void tes07() throws Exception {
        Random r = new Random();
        int i = r.nextInt(9000) + 1000;
        Config config = new Config()
                //这里修改为我们上面生成自己的AccessKey ID
                .setAccessKeyId("LTAI5tBG4UPTKihth1U5SSFS")

                //这里修改为我们上面生成自己的AccessKey Secret
                .setAccessKeySecret("aJxYWz9tun6Sf1V89IFWyaM66w0vx1");
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        Client client = new Client(config);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("阿里云短信测试")//短信签名
                .setTemplateCode("SMS_154950909")//短信模板
                .setPhoneNumbers("17328253148")//这里填写接受短信的手机号码
                .setTemplateParam("{\"code\":" + i + "}");//验证码
        // 复制代码运行请自行打印 API 的返回值
        client.sendSms(sendSmsRequest);
        System.out.println(sendSmsRequest);
        System.out.println(client.sendSms(sendSmsRequest));
    }

    @Test
    public void test08() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId("T202409000001");
        teacher.setName("张三");
        teacher.setSex("男");
        teacher.setPhone("17328253148");
        teacher.setPassword("123456");
        teacher.setClazz("高三1班");
        teacherController.updateTeacher(teacher, null);
    }

}
