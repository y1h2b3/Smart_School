package com.smart.www.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 书杰支付配置类
 *
 * @author Smart Campus
 * @date 2025-11-14
 */
@Data
@Component
@ConfigurationProperties(prefix = "shujiepay")
public class ShujiepayConfig {

    /**
     * 支付接口地址
     */
    private String apiUrl = "https://www.shujiepay.com";

    /**
     * 商户ID
     */
    private String pid;

    /**
     * 平台公钥（用于验签）
     */
    private String platformPublicKey;

    /**
     * 商户私钥（用于签名）
     */
    private String merchantPrivateKey;

    /**
     * 异步通知地址
     */
    private String notifyUrl;

    /**
     * 同步返回地址
     */
    private String returnUrl;
}
