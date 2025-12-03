package com.smart.www.controller;

import com.smart.www.app.HealthApp;
import com.smart.www.pojo.UserHealth;
import com.smart.www.service.UserHealthService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 健康建议 AI 控制器
 * 使用 HealthApp 和 PromptTemplate 生成结构化健康报告
 * 支持 RAG（检索增强生成）功能
 */
@RestController
@RequestMapping("/api/health")
@Tag(name = "健康建议", description = "基于用户健康数据的 AI 建议接口")
public class HealthAppController {

    @Autowired
    private HealthApp healthApp;

    @Autowired
    private UserHealthService userHealthService;

    /**
     * 获取用户健康建议报告（结构化输出）
     *
     * @param uid 用户ID
     * @return 包含标题和建议列表的健康报告
     */
    @GetMapping("/report")
    @Operation(summary = "生成健康报告", description = "根据用户健康数据生成个性化建议报告")
    public Result<HealthApp.HealthReport> getHealthReport(@RequestParam String uid) {
        // 1. 获取用户健康数据
        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(uid);

        if (userHealthList == null || userHealthList.isEmpty()) {
            return Result.<HealthApp.HealthReport>build(null, ResultCodeEnum.ERROR).message("未找到用户健康数据");
        }

        UserHealth userHealth = userHealthList.get(0);

        // 2. 使用 HealthApp 生成结构化健康报告
        // 这里使用 uid 作为用户名，你也可以从其他地方获取真实用户名
        HealthApp.HealthReport healthReport = healthApp.generateHealthReport(
                userHealth,
                "用户" + uid,
                uid // 使用 uid 作为会话ID
        );

        // 3. 返回结构化报告
        return Result.ok(healthReport);
    }

    /**
     * 使用 RAG 生成用户健康建议报告（结合健康知识库）
     *
     * @param uid      用户ID
     * @param username 用户名（可选）
     * @return 包含标题和建议列表的健康报告
     */
    @GetMapping("/rag-report")
    @Operation(summary = "RAG 健康报告", description = "结合健康知识库生成更专业的健康建议报告")
    public Result<HealthApp.HealthReport> getRagHealthReport(
            @RequestParam String uid,
            @RequestParam(required = false, defaultValue = "用户") String username) {

        // 1. 获取用户健康数据
        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(uid);

        if (userHealthList == null || userHealthList.isEmpty()) {
            return Result.<HealthApp.HealthReport>build(null, ResultCodeEnum.ERROR).message("未找到用户健康数据");
        }

        UserHealth userHealth = userHealthList.get(0);

        // 2. 使用 RAG 生成健康报告（结合本地和云端知识库）
        HealthApp.HealthReport healthReport = healthApp.generateHealthReportWithRag(
                userHealth,
                username,
                uid // 使用 uid 作为会话ID
        );

        return Result.ok(healthReport);
    }

    /**
     * 使用云端 RAG 生成用户健康建议报告（仅云服务检索）
     * 只从云端知识库检索，不使用本地向量库
     *
     * @param uid      用户ID
     * @param username 用户名（可选）
     * @return 包含标题和建议列表的健康报告
     */
    @GetMapping("/cloud-rag-report")
    @Operation(summary = "云端 RAG 健康报告", description = "仅使用云端知识库生成健康建议报告")
    public Result<HealthApp.HealthReport> getCloudRagHealthReport(
            @RequestParam String uid,
            @RequestParam(required = false, defaultValue = "用户") String username) {

        // 1. 获取用户健康数据
        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(uid);

        if (userHealthList == null || userHealthList.isEmpty()) {
            return Result.<HealthApp.HealthReport>build(null, ResultCodeEnum.ERROR).message("未找到用户健康数据");
        }

        UserHealth userHealth = userHealthList.get(0);

        // 2. 使用云端 RAG 生成健康报告（仅云服务检索）
        HealthApp.HealthReport healthReport = healthApp.generateHealthReportWithCloudRag(
                userHealth,
                username,
                uid // 使用 uid 作为会话ID
        );

        return Result.ok(healthReport);
    }
}
