package com.smart.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.Drugs;
import com.smart.www.pojo.Orders;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.DrugsService;
import com.smart.www.service.OrdersService;
import com.smart.www.util.ShujiepayCore;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 书杰支付控制器
 * 新增书杰支付接口，不影响现有的支付宝支付接口
 *
 * @author Smart Campus
 * @date 2025-11-14
 */
@Slf4j
@Controller
@RequestMapping("/pay/shujiepay")
public class ShujiepayController {

    @Autowired
    private ShujiepayCore shujiepayCore;

    @Autowired
    private OrdersService orderService;

    @Autowired
    private DrugsService drugsService;

    /**
     * 发起书杰支付
     *
     * @param session     HttpSession
     * @param drugId      药品ID
     * @param money       单价
     * @param sum         数量
     * @param userId      用户ID
     * @param paymentType 支付方式：alipay/wxpay/bank/jdpay
     * @return 支付页面URL
     */
    @ResponseBody
    @GetMapping("/submit")
    public Map<String, Object> submitPay(HttpSession session,
                                         @RequestParam(value = "drugId") String drugId,
                                         @RequestParam(value = "money") Float money,
                                         @RequestParam(value = "sum") Integer sum,
                                         @RequestParam(value = "userId") String userId,
                                         @RequestParam(value = "paymentType", defaultValue = "alipay") String paymentType) {

        Map<String, Object> result = new HashMap<>();

        try {
            // 1. 查询药品信息
            Page<Drugs> drugsPage = drugsService.searchDrugs(
                    new PageQuery(), drugId, null, null, null, null
            );

            if (drugsPage.getRecords().isEmpty()) {
                result.put("code", 1);
                result.put("msg", "药品不存在");
                return result;
            }

            String drugName = drugsPage.getRecords().get(0).getName();

            // 2. 生成商户订单号（与支付宝保持一致的格式）
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            String orderId = time + uuid;

            // 3. 计算总金额
            Float totalAmount = money * sum;

            // 4. 保存订单信息到session（回调时使用）
            session.setAttribute("shujiepay_order_id", orderId);
            session.setAttribute("shujiepay_user_id", userId);
            session.setAttribute("shujiepay_drug_id", drugId);
            session.setAttribute("shujiepay_money", money);
            session.setAttribute("shujiepay_sum", sum);
            session.setAttribute("shujiepay_drug_name", drugName);
            session.setAttribute("shujiepay_payment_type", paymentType);

            log.info("创建书杰支付订单 - 订单号: {}, 用户: {}, 药品: {}, 金额: {}",
                    orderId, userId, drugName, totalAmount);

            // 5. 构建支付参数
            Map<String, String> payParams = new HashMap<>();
            payParams.put("type", paymentType);
            payParams.put("out_trade_no", orderId);
            payParams.put("name", drugName);
            payParams.put("money", String.format("%.2f", totalAmount));
            payParams.put("notify_url", "http://yourserver.com/pay/shujiepay/notify");  // 需要公网地址
            payParams.put("return_url", "http://localhost:8081/pay/shujiepay/return");

            // 6. 获取支付链接
            String payUrl = shujiepayCore.getPayLink(payParams);

            log.info("生成支付链接: {}", payUrl);

            result.put("code", 0);
            result.put("msg", "success");
            result.put("data", payUrl);

        } catch (Exception e) {
            log.error("创建支付订单失败", e);
            result.put("code", 1);
            result.put("msg", "创建支付订单失败: " + e.getMessage());
        }

        return result;
    }

    /**
     * 支付异步回调通知
     * 书杰支付支付成功后会调用此接口
     *
     * @param request HttpServletRequest
     * @return success 或 fail
     */
    @ResponseBody
    @GetMapping("/notify")
    public String notifyCallback(HttpServletRequest request) {
        log.info("收到书杰支付异步回调通知");

        // 1. 获取所有回调参数
        Map<String, String> params = new HashMap<>();
        request.getParameterMap().forEach((key, values) -> {
            if (values != null && values.length > 0) {
                params.put(key, values[0]);
            }
        });

        log.info("回调参数: {}", params);

        // 2. 验证签名
        if (!shujiepayCore.verify(params)) {
            log.error("签名验证失败");
            return "fail";
        }

        // 3. 获取回调数据
        String outTradeNo = params.get("out_trade_no");      // 商户订单号
        String platformTradeNo = params.get("trade_no");     // 平台订单号
        String apiTradeNo = params.get("api_trade_no");      // 接口订单号
        String tradeStatus = params.get("trade_status");     // 交易状态
        String paymentType = params.get("type");             // 支付方式
        String money = params.get("money");                  // 支付金额

        // 4. 判断交易状态
        if (!"TRADE_SUCCESS".equals(tradeStatus)) {
            log.warn("交易状态不是成功: {}", tradeStatus);
            return "fail";
        }

        // 5. 查询订单是否已处理
        Orders existOrder = orderService.getOne(
                new QueryWrapper<Orders>().eq("order_id", outTradeNo)
        );

        if (existOrder != null && "已支付".equals(existOrder.getOrderStatus())) {
            log.info("订单已处理，订单号: {}", outTradeNo);
            return "success";
        }

        // 6. 如果订单不存在，需要从其他途径获取订单信息（这里简化处理）
        // 实际应用中，应该在数据库中查找订单或从Session/Redis中获取

        log.info("处理支付成功回调 - 订单号: {}, 平台订单号: {}, 金额: {}",
                outTradeNo, platformTradeNo, money);

        // 7. 返回成功
        return "success";
    }

    /**
     * 支付同步返回页面
     * 用户支付完成后会跳转到此页面
     *
     * @param request HttpServletRequest
     * @param session HttpSession
     * @return 重定向到前端页面
     */
    @GetMapping("/return")
    public String returnCallback(HttpServletRequest request, HttpSession session) {
        log.info("收到书杰支付同步返回");

        // 1. 获取所有回调参数
        Map<String, String> params = new HashMap<>();
        request.getParameterMap().forEach((key, values) -> {
            if (values != null && values.length > 0) {
                params.put(key, values[0]);
            }
        });

        log.info("返回参数: {}", params);

        // 2. 验证签名
        if (!shujiepayCore.verify(params)) {
            log.error("签名验证失败");
            return "redirect:http://localhost:5173/payment/fail";
        }

        // 3. 获取回调数据
        String outTradeNo = params.get("out_trade_no");      // 商户订单号
        String platformTradeNo = params.get("trade_no");     // 平台订单号
        String apiTradeNo = params.get("api_trade_no");      // 接口订单号
        String tradeStatus = params.get("trade_status");     // 交易状态
        String paymentType = params.get("type");             // 支付方式
        String money = params.get("money");                  // 支付金额

        // 4. 判断交易状态
        if (!"TRADE_SUCCESS".equals(tradeStatus)) {
            log.warn("交易状态不是成功: {}", tradeStatus);
            return "redirect:http://localhost:5173/payment/fail";
        }

        // 5. 从session获取订单信息
        String sessionOrderId = (String) session.getAttribute("shujiepay_order_id");
        String userId = (String) session.getAttribute("shujiepay_user_id");
        String drugId = (String) session.getAttribute("shujiepay_drug_id");
        Float unitPrice = (Float) session.getAttribute("shujiepay_money");
        Integer quantity = (Integer) session.getAttribute("shujiepay_sum");
        String drugName = (String) session.getAttribute("shujiepay_drug_name");

        // 6. 验证订单号是否匹配
        if (sessionOrderId == null || !sessionOrderId.equals(outTradeNo)) {
            log.error("订单号不匹配 - Session: {}, 回调: {}", sessionOrderId, outTradeNo);
            return "redirect:http://localhost:5173/payment/fail";
        }

        // 7. 查询订单是否已存在
        Orders existOrder = orderService.getOne(
                new QueryWrapper<Orders>().eq("order_id", outTradeNo)
        );

        if (existOrder != null && "已支付".equals(existOrder.getOrderStatus())) {
            log.info("订单已存在且已支付，直接跳转");
            return "redirect:http://localhost:5173/index";
        }

        // 8. 创建订单记录
        Orders order = new Orders();
        order.setOrderId(outTradeNo);
        order.setUserId(userId);
        order.setDrugId(drugId);
        order.setPrice(BigDecimal.valueOf(unitPrice));
        order.setQuantity(quantity);
        order.setTotalPrice(BigDecimal.valueOf(unitPrice * quantity));
        order.setOrderStatus("已支付");
        order.setPaymentType(paymentType);
        order.setPlatformTradeNo(platformTradeNo);
        order.setApiTradeNo(apiTradeNo);
        order.setTime(new Date());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());

        // 9. 保存订单
        boolean saved = orderService.save(order);

        if (saved) {
            log.info("订单创建成功 - 订单号: {}, 用户: {}, 药品: {}", outTradeNo, userId, drugName);

            // 清除session
            session.removeAttribute("shujiepay_order_id");
            session.removeAttribute("shujiepay_user_id");
            session.removeAttribute("shujiepay_drug_id");
            session.removeAttribute("shujiepay_money");
            session.removeAttribute("shujiepay_sum");
            session.removeAttribute("shujiepay_drug_name");
            session.removeAttribute("shujiepay_payment_type");

            return "redirect:http://localhost:5173/index";
        } else {
            log.error("订单创建失败");
            return "redirect:http://localhost:5173/payment/fail";
        }
    }

    /**
     * 查询订单状态
     *
     * @param orderId 商户订单号
     * @return 订单信息
     */
    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> queryOrder(@RequestParam String orderId) {
        Map<String, Object> result = new HashMap<>();

        try {
            Map<String, Object> orderInfo = shujiepayCore.queryOrderByOutTradeNo(orderId);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("data", orderInfo);
        } catch (Exception e) {
            log.error("查询订单失败", e);
            result.put("code", 1);
            result.put("msg", "查询订单失败: " + e.getMessage());
        }

        return result;
    }
}
