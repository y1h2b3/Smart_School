package com.smart.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置类
 * 用于HTTP请求
 *
 * @author Smart Campus
 * @date 2025-11-14
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000);  // 连接超时10秒
        factory.setReadTimeout(10000);     // 读取超时10秒
        return new RestTemplate(factory);
    }
}
