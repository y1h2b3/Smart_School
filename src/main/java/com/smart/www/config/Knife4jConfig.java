package com.smart.www.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j 配置类
 * 访问地址: http://localhost:8081/doc.html
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SmartSchool 智慧校园管理系统 API")
                        .description("智慧校园后端接口文档 - 包含用户管理、健康监测、医疗服务、订单支付等功能")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Zzzzh")
                                .email("2873763187@qq.com")
                                .url("http://www.smart.cn"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    /**
     * 用户管理模块
     */
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("1-用户管理")
                .pathsToMatch(
                        "/student/**",
                        "/teacher/**",
                        "/parent/**",
                        "/staff/**",
                        "/login/**",
                        "/userAccount/**"
                )
                .build();
    }

    /**
     * 健康监测模块
     */
    @Bean
    public GroupedOpenApi healthApi() {
        return GroupedOpenApi.builder()
                .group("2-健康监测")
                .pathsToMatch(
                        "/userHealth/**",
                        "/userHealthDaily/**",
                        "/healthWarning/**",
                        "/healthCheck/**"
                )
                .build();
    }

    /**
     * 医疗服务模块
     */
    @Bean
    public GroupedOpenApi medicalApi() {
        return GroupedOpenApi.builder()
                .group("3-医疗服务")
                .pathsToMatch(
                        "/drugs/**",
                        "/hospitals/**",
                        "/drugsHospitalsRelation/**",
                        "/reservation/**"
                )
                .build();
    }

    /**
     * 订单支付模块
     */
    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder()
                .group("4-订单支付")
                .pathsToMatch(
                        "/orders/**",
                        "/staffOrders/**",
                        "/logistics/**",
                        "/pay/**"
                )
                .build();
    }

    /**
     * AI与通知模块
     */
    @Bean
    public GroupedOpenApi aiApi() {
        return GroupedOpenApi.builder()
                .group("5-AI与通知")
                .pathsToMatch(
                        "/ai/**",
                        "/notifications/**",
                        "/logsData/**"
                )
                .build();
    }

    /**
     * 全部接口
     */
    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("0-全部接口")
                .pathsToMatch("/**")
                .build();
    }
}