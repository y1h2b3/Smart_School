package com.smart.www.util;

import com.smart.www.config.ShujiepayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 书杰支付核心SDK类
 * 实现签名、验签、发起支付、查询订单等功能
 *
 * @author Smart Campus
 * @date 2025-11-14
 */
@Slf4j
@Component
public class ShujiepayCore {

    private final ShujiepayConfig config;
    private final RestTemplate restTemplate;

    public ShujiepayCore(ShujiepayConfig config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    /**
     * 发起支付 - 获取支付链接（页面跳转）
     *
     * @param params 支付参数
     * @return 支付URL
     */
    public String getPayLink(Map<String, String> params) {
        String reqUrl = config.getApiUrl() + "/api/pay/submit";
        Map<String, String> requestParams = buildRequestParam(params);

        StringBuilder url = new StringBuilder(reqUrl).append("?");
        requestParams.forEach((k, v) -> url.append(k).append("=").append(v).append("&"));

        return url.substring(0, url.length() - 1);  // 移除最后的&
    }

    /**
     * API支付 - 统一下单接口
     *
     * @param params 支付参数
     * @return 支付结果
     */
    public Map<String, Object> apiPay(Map<String, String> params) throws Exception {
        return execute("/api/pay/create", params);
    }

    /**
     * 查询订单
     *
     * @param tradeNo 平台订单号或商户订单号
     * @return 订单信息
     */
    public Map<String, Object> queryOrder(String tradeNo) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("trade_no", tradeNo);
        return execute("/api/pay/query", params);
    }

    /**
     * 根据商户订单号查询订单
     *
     * @param outTradeNo 商户订单号
     * @return 订单信息
     */
    public Map<String, Object> queryOrderByOutTradeNo(String outTradeNo) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("out_trade_no", outTradeNo);
        return execute("/api/pay/query", params);
    }

    /**
     * 订单关闭
     *
     * @param tradeNo 平台订单号或商户订单号
     * @return 操作结果
     */
    public Map<String, Object> closeOrder(String tradeNo) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("trade_no", tradeNo);
        return execute("/api/pay/close", params);
    }

    /**
     * 验证回调签名
     *
     * @param params 回调参数
     * @return 是否验证通过
     */
    public boolean verify(Map<String, String> params) {
        if (params == null || !params.containsKey("sign")) {
            log.warn("回调参数为空或不包含签名");
            return false;
        }

        String timestamp = params.get("timestamp");
        if (timestamp == null) {
            log.warn("回调参数不包含时间戳");
            return false;
        }

        // 验证时间戳（5分钟内有效）
        try {
            long callbackTime = Long.parseLong(timestamp);
            long currentTime = System.currentTimeMillis() / 1000;
            if (Math.abs(currentTime - callbackTime) > 300) {
                log.warn("回调时间戳超时，回调时间: {}, 当前时间: {}", callbackTime, currentTime);
                return false;
            }
        } catch (NumberFormatException e) {
            log.error("时间戳格式错误: {}", timestamp);
            return false;
        }

        String sign = params.get("sign");
        String signContent = getSignContent(params);

        log.info("验签内容: {}", signContent);
        log.info("签名值: {}", sign);

        return rsaPublicVerify(signContent, sign);
    }

    /**
     * 执行API请求
     *
     * @param path   API路径
     * @param params 请求参数
     * @return API响应
     */
    private Map<String, Object> execute(String path, Map<String, String> params) throws Exception {
        String reqUrl = config.getApiUrl() + path;
        Map<String, String> requestParams = buildRequestParam(params);

        // 构建请求
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        requestParams.forEach(formData::add);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        log.info("请求URL: {}", reqUrl);
        log.info("请求参数: {}", requestParams);

        // 发送请求
        ResponseEntity<Map> response = restTemplate.postForEntity(reqUrl, request, Map.class);
        Map<String, Object> result = response.getBody();

        log.info("响应结果: {}", result);

        if (result != null && Integer.valueOf(0).equals(result.get("code"))) {
            // 验证返回签名 - 将 Map<String, Object> 转换为 Map<String, String>
            Map<String, String> verifyParams = new HashMap<>();
            result.forEach((k, v) -> {
                if (v != null) {
                    verifyParams.put(k, String.valueOf(v));
                }
            });

            if (!verify(verifyParams)) {
                throw new RuntimeException("返回数据验签失败");
            }
            return result;
        } else {
            String msg = result != null ? (String) result.get("msg") : "请求失败";
            throw new RuntimeException(msg);
        }
    }

    /**
     * 构建请求参数（添加签名）
     *
     * @param params 业务参数
     * @return 完整请求参数
     */
    private Map<String, String> buildRequestParam(Map<String, String> params) {
        params.put("pid", config.getPid());
        params.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));

        String sign = getSign(params);
        params.put("sign", sign);
        params.put("sign_type", "RSA");

        return params;
    }

    /**
     * 生成签名
     *
     * @param params 参数
     * @return 签名字符串
     */
    private String getSign(Map<String, String> params) {
        String signContent = getSignContent(params);
        log.info("待签名字符串: {}", signContent);
        return rsaPrivateSign(signContent);
    }

    /**
     * 获取待签名字符串
     * 按照ASCII码升序排列，用&连接
     *
     * @param params 参数
     * @return 待签名字符串
     */
    private String getSignContent(Map<String, String> params) {
        return params.entrySet().stream()
                .filter(e -> e.getValue() != null && !e.getValue().isEmpty())
                .filter(e -> !"sign".equals(e.getKey()) && !"sign_type".equals(e.getKey()))
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }

    /**
     * RSA私钥签名
     *
     * @param data 待签名数据
     * @return 签名字符串（Base64）
     */
    private String rsaPrivateSign(String data) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(config.getMerchantPrivateKey());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(signature.sign());
        } catch (Exception e) {
            log.error("RSA签名失败", e);
            throw new RuntimeException("签名失败: " + e.getMessage());
        }
    }

    /**
     * RSA公钥验签
     *
     * @param data 待验签数据
     * @param sign 签名字符串
     * @return 是否验证通过
     */
    private boolean rsaPublicVerify(String data, String sign) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(config.getPlatformPublicKey());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(data.getBytes(StandardCharsets.UTF_8));

            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            log.error("RSA验签失败", e);
            return false;
        }
    }
}
