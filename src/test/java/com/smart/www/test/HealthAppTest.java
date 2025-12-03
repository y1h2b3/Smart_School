package com.smart.www.test;

import com.smart.www.app.HealthApp;
import com.smart.www.pojo.UserHealth;
import com.smart.www.service.UserHealthService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 健康建议测试类
 * 测试用户：李莉
 */
@SpringBootTest
class HealthAppTest {

    @Resource
    private HealthApp healthApp;

    @Autowired
    private UserHealthService userHealthService;

    /**
     * 测试李莉的健康建议生成
     * <p>
     * SQL 查询李莉的 user_id:
     * SELECT student_id AS user_id, name, clazz FROM student WHERE name = '李莉';
     * <p>
     * 如果数据库中没有李莉，可以使用现有学生测试，例如:
     * - 迪丽热巴: student_id = '20004'
     * - 王宝强: student_id = '20005'
     * - 黄林峰: student_id = '20003'
     */
    @Test
    void testLiLiHealthReport() {
        // 1. 查询李莉的健康数据
        // 根据 SQL 查询结果填写 user_id
        // 如果数据库中没有李莉，请先插入数据或使用现有学生测试
        String liLiUid = "S202409000739"; // 示例：使用迪丽热巴的 student_id 进行测试

        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(liLiUid);

        // 2. 验证数据存在
        Assertions.assertNotNull(userHealthList, "李莉的健康数据不应为空");
        Assertions.assertFalse(userHealthList.isEmpty(), "李莉应该有健康数据");

        UserHealth liLiHealth = userHealthList.get(0);

        // 3. 打印李莉的健康数据
        System.out.println("========== 李莉的健康数据 ==========");
        System.out.println("身高: " + liLiHealth.getHeight());
        System.out.println("体脂: " + liLiHealth.getBmi());
        System.out.println("脂肪率: " + liLiHealth.getFatPercentage());
        System.out.println("睡眠时间: " + liLiHealth.getSleepTimeTotal() + "小时");
        System.out.println("深睡眠时间: " + liLiHealth.getDeepSleepTotal() + "小时");
        System.out.println("平均静息心率: " + liLiHealth.getMeanRestingHeartRate());
        System.out.println("今日步数: " + liLiHealth.getStep());
        System.out.println("运动时长: " + liLiHealth.getWalkingTime() + "小时");
        System.out.println("=====================================");

        // 4. 生成健康建议报告
        HealthApp.HealthReport healthReport = healthApp.generateHealthReport(
                liLiHealth,
                "李莉",
                liLiUid
        );

        // 5. 验证报告生成成功
        Assertions.assertNotNull(healthReport, "健康报告不应为空");
        Assertions.assertNotNull(healthReport.title(), "报告标题不应为空");
        Assertions.assertNotNull(healthReport.suggestions(), "建议列表不应为空");
        Assertions.assertFalse(healthReport.suggestions().isEmpty(), "建议列表不应为空");

        // 6. 打印健康报告
        System.out.println("\n========== 李莉的健康报告 ==========");
        System.out.println("标题: " + healthReport.title());
        System.out.println("\n建议列表:");
        for (int i = 0; i < healthReport.suggestions().size(); i++) {
            System.out.println((i + 1) + ". " + healthReport.suggestions().get(i));
        }
        System.out.println("=====================================");
    }

    /**
     * 测试快速生成健康报告（使用默认会话ID）
     */
    @Test
    void testQuickHealthReport() {
        String liLiUid = "S202409000739"; // 使用迪丽热巴的 student_id 测试

        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(liLiUid);
        Assertions.assertNotNull(userHealthList);
        Assertions.assertFalse(userHealthList.isEmpty());

        UserHealth liLiHealth = userHealthList.get(0);

        // 使用默认会话ID生成报告
        HealthApp.HealthReport healthReport = healthApp.generateHealthReport(
                liLiHealth,
                "李莉",
                "quick-test-session"
        );

        Assertions.assertNotNull(healthReport);
        System.out.println("快速报告标题: " + healthReport.title());
        System.out.println("建议数量: " + healthReport.suggestions().size());
    }

    /**
     * 测试多轮对话（会话记忆）
     */
    @Test
    void testMultiRoundConversation() {
        String liLiUid = "S202409000739"; // 使用迪丽热巴的 student_id 测试

        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(liLiUid);
        Assertions.assertNotNull(userHealthList);

        UserHealth liLiHealth = userHealthList.get(0);

        // 第一轮：生成初始报告
        System.out.println("\n========== 第一轮对话 ==========");
        HealthApp.HealthReport report1 = healthApp.generateHealthReport(
                liLiHealth,
                "李莉",
                "lili-session-001" // 使用固定的会话ID
        );
        System.out.println("第一次报告: " + report1.title());

        // 第二轮：使用相同的会话ID，AI会记住之前的对话
        System.out.println("\n========== 第二轮对话 ==========");
        HealthApp.HealthReport report2 = healthApp.generateHealthReport(
                liLiHealth,
                "李莉",
                "lili-session-001" // 相同的会话ID
        );
        System.out.println("第二次报告: " + report2.title());

        Assertions.assertNotNull(report1);
        Assertions.assertNotNull(report2);
    }

    /**
     * 测试云端 RAG 健康报告生成（仅云服务检索）
     * 只从云端知识库检索，不使用本地向量库
     */
    @Test
    void testCloudRagHealthReport() {
        String liLiUid = "S202409000739"; // 使用迪丽热巴的 student_id 测试

        // 1. 获取用户健康数据
        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(liLiUid);
        Assertions.assertNotNull(userHealthList, "用户健康数据不应为空");
        Assertions.assertFalse(userHealthList.isEmpty(), "用户应该有健康数据");

        UserHealth liLiHealth = userHealthList.get(0);

        // 2. 使用云端 RAG 生成健康报告
        System.out.println("\n========== 云端 RAG 健康报告 ==========");
        HealthApp.HealthReport cloudRagReport = healthApp.generateHealthReportWithCloudRag(
                liLiHealth,
                "李莉",
                "cloud-rag-session-001" // 会话ID
        );

        // 3. 验证报告生成成功
        Assertions.assertNotNull(cloudRagReport, "云端 RAG 健康报告不应为空");
        Assertions.assertNotNull(cloudRagReport.title(), "报告标题不应为空");
        Assertions.assertNotNull(cloudRagReport.suggestions(), "建议列表不应为空");
        Assertions.assertFalse(cloudRagReport.suggestions().isEmpty(), "建议列表不应为空");

        // 4. 打印报告内容
        System.out.println("标题: " + cloudRagReport.title());
        System.out.println("\n建议列表:");
        for (int i = 0; i < cloudRagReport.suggestions().size(); i++) {
            System.out.println((i + 1) + ". " + cloudRagReport.suggestions().get(i));
        }
        System.out.println("=========================================");
    }

    /**
     * 测试组合 RAG vs 云端 RAG 对比
     * 比较使用组合检索（本地+云端）和仅云端检索的差异
     */
    @Test
    void testRagComparison() {
        String liLiUid = "S202409000739"; // 使用迪丽热巴的 student_id 测试

        // 1. 获取用户健康数据
        List<UserHealth> userHealthList = userHealthService.searchIdUserHealthType(liLiUid);
        Assertions.assertNotNull(userHealthList);
        UserHealth liLiHealth = userHealthList.get(0);

        // 2. 生成组合 RAG 报告（本地 + 云端）
        System.out.println("\n========== 组合 RAG 报告（本地+云端） ==========");
        HealthApp.HealthReport compositeReport = healthApp.generateHealthReportWithRag(
                liLiHealth,
                "李莉",
                "composite-rag-test"
        );
        System.out.println("组合 RAG 标题: " + compositeReport.title());
        System.out.println("建议数量: " + compositeReport.suggestions().size());

        // 3. 生成云端 RAG 报告（仅云端）
        System.out.println("\n========== 云端 RAG 报告（仅云端） ==========");
        HealthApp.HealthReport cloudReport = healthApp.generateHealthReportWithCloudRag(
                liLiHealth,
                "李莉",
                "cloud-rag-test"
        );
        System.out.println("云端 RAG 标题: " + cloudReport.title());
        System.out.println("建议数量: " + cloudReport.suggestions().size());

        // 4. 验证两种方式都能成功生成报告
        Assertions.assertNotNull(compositeReport);
        Assertions.assertNotNull(cloudReport);

        System.out.println("\n========== 对比总结 ==========");
        System.out.println("组合 RAG：结合本地健康知识库和云端知识库");
        System.out.println("云端 RAG：仅使用云端知识库，避免本地向量库加载问题");
        System.out.println("============================");
    }
}
