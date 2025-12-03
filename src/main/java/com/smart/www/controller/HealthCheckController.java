package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.smart.www.service.HealthCheckService;
import com.smart.www.util.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "健康检测分析")
@SaCheckLogin(type = StpUtil.TYPE)
public class HealthCheckController {
    private final ChatModel chatModel;
    @Autowired
    private HealthCheckService healthCheckService;

    public HealthCheckController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/healthCheck")
    public Result healthCheck() {
        healthCheckService.healthCheck();
        return Result.ok(null);
    }

    @PostMapping("/UpdatehealthCheck")
    public Result UpdatehealthCheck() {
        boolean isUpdate = healthCheckService.UpdatehealthCheck();
        if (!isUpdate)
            return Result.build(500, "更新失败");

        return Result.ok(null);
    }
}
