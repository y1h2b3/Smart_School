package com.smart.www.config;

import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * AI 客户端全局配置类
 * 用于解决默认超时时间过短导致的大模型调用失败问题
 */
@Configuration
public class RestClientConfig {

    /**
     * 全局定制 RestClient
     * Spring AI 底层使用 RestClient 发起 HTTP 请求，通过此配置可修改底层 HTTP 客户端行为
     */
    @Bean
    public RestClientCustomizer restClientCustomizer() {
        return restClientBuilder -> {
            // 使用 SimpleClientHttpRequestFactory (基于 JDK HttpURLConnection)
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

            // 建立连接超时时间 (握手时间) - 设置为 300秒
            requestFactory.setConnectTimeout(300000);

            // 读取数据超时时间 (AI 生成回复等待时间) - 设置为 300秒
            // 阿里云 Qwen-Plus 等大模型生成长文本时耗时较长，默认的 30s 很容易超时
            requestFactory.setReadTimeout(300000);

            // 将自定义的请求工厂应用到 Builder
            restClientBuilder.requestFactory(requestFactory);
        };
    }
}
