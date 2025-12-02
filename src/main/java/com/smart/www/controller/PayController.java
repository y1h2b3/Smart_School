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
    private final String APP_ID = "9021000157658364";
    //应用私钥
    private final String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCssFJTeIt3L/fIgbCJcXUhcdJPsyIHreIky8GfsmzlLJgB4Ja9EBPneEtt7ZESaGCmHCiqGLcXXgMCC14tS9+9G/fu1A9FRspyyUpk6kZufpubqOha4krspz+tXE8raobjSBiA0Bf5URpeZPkd7tGMJplXIY1SistF37My+PLQAiuwbmMNa37C82ya4pPsCjoW4KQ1MMFlLAOgfb06BjpqWYuS/EBv0NVcNWDx8c/hwk1yNykgR2jfLePGIp9XTiHfvqAidV1w+en/DA7kj7LNMG0nNW/eVP6p9i2gjhDbVj7wYlRSfJWW7szxFC5bSp/GN5Bc5JX0W4YmzxjzvtXNAgMBAAECggEBAIgc0kcIlKT1IhDgaA1taC1cUbCQORpkbAMktxDwyfQ5Gfcg1q9epNGld47F2brwmn1TZJntsSKx7x0FaM27KDcefGW6r+6ixZ+EGSdBoRImqPAgSkSYaQXvLbmvMJe/92HdybJ+UucojegpHlIBkxkss2CCCaoty9rfX5elsX1RarFqJLF93FmR9CRheQsldTtlLxXy08Qcgy3S9gvQLBriBAc2PTf4AJFp3Zeve1ibScLYO1qdsP0OI01owY2OOvXE7Nki1KhfY/IvwXmqWG6uvqlT6Z0YmtuhDfwnl/Zw4q245o8aC59Vs5AAszIGobfxNNAhTodRWTtqQ37u2eECgYEA7enbp5AHZmW/rBsWXtJzxakq63+DPWKJgiZvv0BW+AQJMxDTIQ7YsrC4xOv9Taj+2zw83fRfCMWPA9EV5nUHFDyfEWh/07ai2hVP6ATgblWzhJKxxiKasCx3SsRbx8LIweRN3s1OHTrOKa/kchArPUiEuRQ22rm5a/ot0RNCfh8CgYEAudEYZDV/nu2vEKxpigAudYjQ/H2HP3dQcLHOskukwNutj5yN4g3NyjXr8WAWRdbNgTTluc/XqosYJyU9fjcBCMfMFnyqp+xGbb/ZeO+QaWmdlzluwSjdWsymrwQNte+2UbhT88GFZvzZdQmo4W3YHuZuYwhXTsqrxfr5ikeOVpMCgYA9MODmAA1nMNRTl8PxL3/HXvNDDtDagPWNHAWx0wKLV75l+/XRktf5XaqoO2ozBzxFdwDQtYGb5/QYrzZKx97CPbVL7Oyzr03DeafLrTVsK264smI267+NgGJOQKK6hkbMV8QPgg6NRgqwfiTrkW0NnhFE6QYSy6H9O6N9Gs8HUQKBgQCzGwrJvI9w32V5StbHv/kILYJTfaOZ1yXgGmNDlIoPoy+eV6ajF+8eU+9Cz/1n/+5B9nzgJ6iXqE71nH2zZM1Ia10a57uO9L3GF8BFQ5UNJlJSa3eIFB2Y4d5goCWfEpnIF0ZElGpDpMDugQsZj0lcL3yDVIzjU5NS1+EkGmjmpQKBgQC7E/RpCoaqpVJ0uK/q2szJwS7qrbrJ37RBoEZuQs1oEqYTL/F6PJZdUZmPVcAPOPKSazpw8ncVk0C7v77a5KlQXMr34mwfhf91lxWNsAHnV0awmn9ixoTykXX8yDh2nND+mdt2y+Mj3GYJJhUhfTXzayDV1RWHsmFhVZ9sA1Us0g==";
    private final String CHARSET = "UTF-8";
    // 支付宝公钥
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAirU5SHyVzozG0VtFSXhwGUGWs/Sxic5KOAS9KdwDJyF30elcRYKH2u6EJy+VY6TRK5dDDvBGDagD06P/prqGo/4aJ+FIOMIHhq1pT1mIZkIibaIa1Q770GetRv5p2r8xg0X9PEfK0Ho4s4I98QcOvFg4X9O7sEt3woRK3Po/9jsACNsmCox2tKFp8IjF3fwD90IfyD1x0xCR2tRByv5/kIYEEFE2S3dbpCnUw5XQSZWsCR/HdcV7/tfV0ZogqDGDfm6nnn8jXF75v7r14x5P22pxAYtaguoCQ4tfWWUbPKBbEfFAFyeqJHEN29gi5/A2rSjRBDuNMBefrAYScZjYawIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://v2443f69.natappfree.cc/pay/notify";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8718/pay/return";
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

        Page<Drugs> drugsPage = drugsService.searchDrugs(new PageQuery(), dona_drugId, null, null, null, null);
        String name = drugsPage.getRecords().get(0).getName();

        //生成订单号（支付宝的要求）
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String user = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String OrderNum = time + user;  // 完整订单号

        //计算总金额（不要修改原始单价）
        float totalAmount = dona_money * dona_sum;

        //把订单信息放在session中（用于回调）
        session.setAttribute("dona_userId", dona_userId);
        session.setAttribute("dona_unit_price", dona_money);  // 保存单价
        session.setAttribute("dona_drugId", dona_drugId);
        session.setAttribute("dona_sum", dona_sum);
        session.setAttribute("dona_order_id", OrderNum);  // 保存完整订单号
        session.setAttribute("dona_name", name);

        String dona_name = orderService.findID(dona_drugId);

        //调用封装好的方法（给支付宝接口发送请求）
        return sendRequestToAlipay(OrderNum, totalAmount, dona_name, name);
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

    @GetMapping("/pay/return")
    public String payReturn(HttpSession session) {
        System.out.println("支付成功回调");

        //从session获取订单信息
        String orderId = (String) session.getAttribute("dona_order_id");
        String dona_userId = (String) session.getAttribute("dona_userId");
        String dona_drugId = (String) session.getAttribute("dona_drugId");
        Float unitPrice = (Float) session.getAttribute("dona_unit_price");  // 获取单价
        Integer dona_sum = (Integer) session.getAttribute("dona_sum");

        // 验证必要参数
        if (orderId == null || dona_userId == null || unitPrice == null) {
            System.err.println("Session数据丢失，无法创建订单");
            return "redirect:http://localhost:5173/index?error=session_lost";
        }

        // 检查订单是否已存在（防止重复创建）
        Orders existOrder = orderService.getOne(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Orders>()
                        .eq("order_id", orderId)
        );

        if (existOrder != null) {
            System.out.println("订单已存在，订单号: " + orderId);
            // 清除session
            clearPaymentSession(session);
            return "redirect:http://localhost:5173/store-buy?paymentSuccess=true";
        }

        //创建订单
        Orders orders = new Orders();
        orders.setOrderId(orderId);  // 使用完整订单号
        orders.setUserId(dona_userId);
        orders.setDrugId(dona_drugId);
        orders.setPrice(BigDecimal.valueOf(unitPrice));  // 单价
        orders.setQuantity(dona_sum);
        orders.setTotalPrice(BigDecimal.valueOf(unitPrice * dona_sum));  // 总价 = 单价 × 数量
        orders.setTime(new Date());
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setOrderStatus("已支付");
        orders.setPaymentType("alipay");  // 设置支付方式

        boolean saved = orderService.save(orders);

        if (saved) {
            System.out.println("订单创建成功: " + orderId);
            // 清除session
            clearPaymentSession(session);
            return "redirect:http://localhost:5173/store-buy?paymentSuccess=true";
        } else {
            System.err.println("订单创建失败");
            return "redirect:http://localhost:5173/store-buy?paymentSuccess=false";
        }
    }

    /**
     * 异步回调接口（支付宝后台调用）
     */
    @PostMapping("/pay/notify")
    @ResponseBody
    public String notifyAsync(@RequestParam("out_trade_no") String outTradeNo,
                              @RequestParam("trade_status") String tradeStatus) {
        System.out.println("支付宝异步回调: 订单号=" + outTradeNo + ", 状态=" + tradeStatus);

        // 只处理支付成功的通知
        if ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus)) {
            // 检查订单是否已存在
            Orders existOrder = orderService.getOne(
                    new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Orders>()
                            .eq("order_id", outTradeNo)
            );

            if (existOrder != null) {
                System.out.println("订单已存在，无需重复创建");
                return "success";  // 返回 success 告诉支付宝收到通知
            }

            System.out.println("异步回调无法创建订单（缺少详细信息），订单已由同步回调创建");
        }

        return "success";
    }

    /**
     * 清除支付相关的Session数据
     */
    private void clearPaymentSession(HttpSession session) {
        session.removeAttribute("dona_order_id");
        session.removeAttribute("dona_userId");
        session.removeAttribute("dona_drugId");
        session.removeAttribute("dona_unit_price");
        session.removeAttribute("dona_sum");
        session.removeAttribute("dona_name");
    }

}
