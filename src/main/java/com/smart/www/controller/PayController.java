package com.smart.www.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.Drugs;
import com.smart.www.pojo.Orders;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.DrugsService;
import com.smart.www.service.OrdersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class PayController {
    //appid
    private final String APP_ID = "9021000136620141";
    //应用私钥
    private final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCf5Th6bCemr/RdnnNTsSnClOQeIm86xSbXLlf9VX0gVkH82ipDKE+XOgOyqao6Q4Vou6O/Vu2aYsYL8WUTvFFbatD+xz6JtyZBBnp5AnQdvBLRZ4wkj4c3t2EoZhUM3ODRiJtWMnSsoxAjqqU7x38UlgXRbp5xvZj/T0F9D18v6cCJUh4yaEoWH//UqTAdYC+UCNIifhOcjVASeLDpvR7r++7L+wIy3RpxOZonCwQMwOUu/ME7dMCZCBQawfsXxXK1i2CLbvseYLvx8b1Urk1cq5XV1Zgn432XmDK+7QJVfncpSX0hJReVx4RL4dPMtQrL+lo3XDPGqzpyKzhsDFoxAgMBAAECggEASWIsP5Nvx0KuBmF4UIrYvaMT5viqz/A32T49x9j6amLsOh3uk4/mp2NK2y6fH8ppah3kEybUOazndAe/+gTN2gT2ElhjTVUvS1yrzOnhXNw6Tr0VRppQ1rNk9eOT+alNzRzDHhZeEfVsrNHer8bpfgs0dGAue8kmdNZtGfZ6G0STv/p3fNL7fxf1S65u3u5vjFaNtpZx/t+qr7f3SaVwgbeQGHoJWDb/Ypt81b8nd0b8wBXHEZvZ8lWl2hqYXbn/77rZOZwueAwj1oB8DldVXRa7IIJxohOemtYhltdKmKo+RTc5hmxfuRulMb7thMiYmgDUaclix21vcMGPhj3sIQKBgQDj4w29taupiIuMEouRTT7kKMkHcghwcDwdAUGEy24UTox/D6bFa5uXxc0BovoyAZd9kX4nuC89n/JutiSGBuM0tgzeiwkZdrqufUov758YqPJpoDDrGvOJFSnGkIsbroxSDk+TxnyIz9yiXh+ock0No0Ds/eGSDCdhL7k6JbnrXQKBgQCznulc1V5WWgpqBkaWroRGnK5v3XLKKQSIx8IeIRggOT2lw7LZd6xYshtI0s+7xk1fc81aPubWNgLeZzc3eeRSYEs+xrJylOs3MG0Ko3xbJu4gqGUc85Aywa4q+iIWuUn0oVJEwBzjOccDhOY+/9zwJhuTBqs51XoJT+sjrLMQ5QKBgQDJ1QMKjqhnEqRlftdV7ZBSCz1g9sI6s2zKU55vuqzYF2mf74DJQTEhDvMvC+WD/Jzrfby5+Qr+DXduTquyeM8qlEJ5p7J7dwiIGjdmlVfXQ2rP2iz5TXl8Y94IG2TZM5Lb6gjY3ObXVSIYPDzVt8Y+2eRbAdCSxWjrTpVCxr8PkQKBgD43xGPYsMW+iK7zH45gQwdmjHHJRlLKZHywnQfstLusuDLsF86GSpeqkhLmmvhTF0gCB9bDxRfcO6AoJpM70J/MJSRIlVVlShii2JJ/0LqOQJvlWKjvoTpDpn3SiO5QHlLzcljIJvl6cPpCFbMq07AHszN5cuQkkxIYsb14u8oVAoGBANCSgDU7wrpl8Vk8h8aROAf1eVbWlNUg9N9L6pWv++SeFm34oujTTPywsD+5iiO1rS7kCTWeaBXQQFOXT1ofAIkJjL5z80Y7GtZOKeo88r19g7w8EARgoss+okyrZnB+bUXu5WnUENs1vmzeupiQxagMyswfTcqLiyi9boLVa40I";
    private final String CHARSET = "UTF-8";
    // 支付宝公钥
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiqdmVB3xRUA1Gx+wz/9r9V53qrVQkc6yt6udNl61dl+QLuWG9Y3mrJCQZh6/sbyat7DhSjDLzxlqMgVmmunfcZlRly2eq0hYhfKlbe9cX1DAGPJfQPpzM2JOZhXRYhRZfDNonjouoFJU/vaM6DvEBX0Zn6/CK/H3qYvr7M801GSFzCLzTs1+VMdJV26jAO36+k/F6wLkajVvAsv0/KbkRl6K+LwPj8xzaa4qeq+z2DYUzBDCl7guO90DE4Y6C1cFYKeMO+wmw3D+KMex09rhgWdl6HQ10txJve9xCIpA5mw2ByNCP33GnL7pZAMApIqK3oTg8eogqjLtUAlJG31Y4wIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://w58znm.natappfree.cc";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8081/nofity";
    @Autowired
    private OrdersService orderService;
    @Autowired
    private DrugsService drugsService;

    //必须加ResponseBody注解，否则spring会寻找thymeleaf页面
    @ResponseBody
    @RequestMapping("/pay/alipay")
    public String alipay(HttpSession session,
                         @RequestParam(value = "dona_drugId") String dona_drugId,
                         @RequestParam(value = "dona_money") float dona_money,
                         @RequestParam(value = "dona_sum") int dona_sum,
                         @RequestParam(value = "dona_userId") String dona_userId) throws AlipayApiException {

        Page<Drugs> drugsPage = drugsService.searchDrugs(new PageQuery(),  dona_drugId, null, null, null, null);
        String name = drugsPage.getRecords().get(0).getName();
        //生成订单号（支付宝的要求）
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String user = UUID.randomUUID().toString().replace("-", "").toUpperCase();

        //把dona_id项目id 放在session中
        session.setAttribute("dona_userId", dona_userId);
        session.setAttribute("dona_money", dona_money);
        session.setAttribute("dona_drugId", dona_drugId);
        session.setAttribute("dona_sum", dona_sum);
        session.setAttribute("dona_id", user);
        session.setAttribute("dona_name", name);
        String dona_name = orderService.findID(dona_drugId);
        String OrderNum = time + user;
        dona_money = dona_money * dona_sum;
        //调用封装好的方法（给支付宝接口发送请求）
        return sendRequestToAlipay(OrderNum, dona_money, dona_name,name);
    }

    /*
参数1：订单号
参数2：订单金额
参数3：订单名称
 */
    //支付宝官方提供的接口
    private String sendRequestToAlipay(String outTradeNo, Float totalAmount, String subject,String name) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(RETURN_URL);
        alipayRequest.setNotifyUrl(NOTIFY_URL);

        //商品描述（可空）
        String body = "药品";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_name\":\"" + name + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }

    @GetMapping("nofity")
    public String notify(HttpSession session) {
        System.out.println("支付成功");
        //获得项目id
        String dona_id = (String) session.getAttribute("dona_id");
        String dona_userId = (String) session.getAttribute("dona_userId");
        String dona_drugId = (String) session.getAttribute("dona_drugId");
        float dona_money = (float) session.getAttribute("dona_money");
        Integer dona_sum = (Integer) session.getAttribute("dona_sum");
        //调用service层的方法
        Orders orders = new Orders();
        orders.setOrderId(dona_id);
        orders.setUserId(dona_userId);
        orders.setDrugId(dona_drugId);
        orders.setPrice(BigDecimal.valueOf(dona_money));
        orders.setQuantity(dona_sum);
        orders.setTime(new Date());
        orders.setTotalPrice(BigDecimal.valueOf(dona_money * dona_sum));
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setOrderStatus("已支付");
        orderService.save(orders);
        return "redirect:http://localhost:5173/index";
    }

}
