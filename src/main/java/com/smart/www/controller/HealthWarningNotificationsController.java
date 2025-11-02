package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.HealthWarningNotificationsMapper;
import com.smart.www.pojo.HealthWarningNotifications;
import com.smart.www.pojo.Vo.LogisticsHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.StudentHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.TeacherHealthWarningNotificationsVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.HealthWarningNotificationsService;
import com.smart.www.service.LogsDataService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "健康预警通知管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class HealthWarningNotificationsController {

    @Autowired
    private HealthWarningNotificationsService healthService;

    @Autowired
    private LogsDataService logsDataService;
    @Autowired
    private HealthWarningNotificationsMapper healthWarningNotificationsMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/IdHealthWarningNotifications/{hid}")
    @Operation(summary = "根据id查询健康预警通知")
    public Result<List<HealthWarningNotifications>> findHealthWarningNotificationsById(@PathVariable String hid) {
        List<HealthWarningNotifications> healthWarningNotifications = healthWarningNotificationsMapper.findAllStudentHealthWarningNotificationsById(hid);
        return Result.ok(healthWarningNotifications);
    }
    /**
     * 查询学生所有健康预警通知
     *
     * @return
     */
    @GetMapping("/studentHealthWarningNotifications")
    @Operation(summary = "查询学生健康预警通知")
    public Result<PageDTO<StudentHealthWarningNotificationsVo>> findAllStudentHealthWarningNotifications(PageQuery pageQuery) {
        try {
            Page<StudentHealthWarningNotificationsVo> studentHealthWarningNotificationsVo = healthService.findAllStudentHealthWarningNotifications(pageQuery);
            return getPageDTOResult(studentHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/studentHealthWarningNotifications2")
    @Operation(summary = "查询不带分页的所有学生健康预警通知")
    public Result<List<StudentHealthWarningNotificationsVo>> findAllStudentHealthWarningNotifications2() {
        try {
            List<StudentHealthWarningNotificationsVo> studentHealthWarningNotificationsVo = healthService.findAllStudentHealthWarningNotifications2();
            return Result.ok(studentHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据学生标题查询健康预警通知
     *
     * @return
     */
    @GetMapping(value = "/StudentSearchHealthWarningNotifications")
    @Operation(summary = "根据学生关键字查询健康预警通知")
    public Result<PageDTO<StudentHealthWarningNotificationsVo>> searchHealthWarningNotifications(PageQuery pageQuery,
                                                                                                 String id,
                                                                                                 String level,
                                                                                                 String startTime,
                                                                                                 String endTime) {
        try {
            Page<StudentHealthWarningNotificationsVo> studentHealthWarningNotificationsVo = healthService.searchStudentHealthWarningNotifications(pageQuery, id, level, startTime, endTime);
            return getPageDTOResult(studentHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<StudentHealthWarningNotificationsVo>> getPageDTOResult(Page<StudentHealthWarningNotificationsVo> studentHealthWarningNotificationsVo) {
        List<StudentHealthWarningNotificationsVo> records = studentHealthWarningNotificationsVo.getRecords();
        PageDTO<StudentHealthWarningNotificationsVo> pageDTO = new PageDTO<>();
        pageDTO.setRecords(records);
        pageDTO.setTotal((int) studentHealthWarningNotificationsVo.getTotal());
        pageDTO.setPages((int) studentHealthWarningNotificationsVo.getPages());
        return Result.ok(pageDTO);
    }

    /**
     * 根据id删除健康预警通知
     *
     * @param hid
     * @return
     */
    @DeleteMapping(value = "/HealthWarningNotifications/{hid}")
    @Operation(summary = "根据id删除健康预警通知")
    public Result removeHealthWarningNotificationsByHid(@PathVariable String hid, HttpServletRequest request) {

        boolean b = healthService.removeHealthWarningNotificationsByHid(hid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除健康预警通知",
                    "删除成功",
                    "删除id:" + hid ,
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除健康预警通知",
                    "删除失败",
                    "删除id:" + hid + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/teacherHealthWarningNotifications")
    @Operation(summary = "查询老师健康预警通知")
    public Result<PageDTO<TeacherHealthWarningNotificationsVo>> findAllTeacherHealthWarningNotifications(PageQuery pageQuery) {
        try {
            Page<TeacherHealthWarningNotificationsVo> TeacherHealthWarningNotificationsVo = healthService.findAllTeacherHealthWarningNotifications(pageQuery);
            return getPageDTOResult1(TeacherHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/teacherHealthWarningNotifications2")
    @Operation(summary = "查询不带分页的所有老师健康预警通知")
    public Result<List<TeacherHealthWarningNotificationsVo>> findAllTeacherHealthWarningNotifications2() {
        try {
            List<TeacherHealthWarningNotificationsVo> TeacherHealthWarningNotificationsVo = healthService.findAllTeacherHealthWarningNotifications2();
            return Result.ok(TeacherHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    @GetMapping(value = "/teacherSearchHealthWarningNotifications")
    @Operation(summary = "根据老师关键字查询健康预警通知")
    public Result<PageDTO<TeacherHealthWarningNotificationsVo>> searchTeacherHealthWarningNotifications(PageQuery pageQuery,
                                                                                                        String id,
                                                                                                        String level,
                                                                                                        String startTime,
                                                                                                        String endTime) {
        try {
            Page<TeacherHealthWarningNotificationsVo> TeacherHealthWarningNotificationsVo = healthService.searchTeacherHealthWarningNotifications(pageQuery, id, level, startTime, endTime);
            return getPageDTOResult1(TeacherHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<TeacherHealthWarningNotificationsVo>> getPageDTOResult1(Page<TeacherHealthWarningNotificationsVo> TeacherHealthWarningNotificationsVo) {
        List<TeacherHealthWarningNotificationsVo> records = TeacherHealthWarningNotificationsVo.getRecords();
        PageDTO<TeacherHealthWarningNotificationsVo> pageDTO = new PageDTO<>();
        pageDTO.setRecords(records);
        pageDTO.setTotal((int) TeacherHealthWarningNotificationsVo.getTotal());
        pageDTO.setPages((int) TeacherHealthWarningNotificationsVo.getPages());
        return Result.ok(pageDTO);
    }

    /**
     * 查询后勤所有健康预警通知
     *
     * @return
     */
    @GetMapping("/logisticsHealthWarningNotifications")
    @Operation(summary = "查询后勤健康预警通知")
    public Result<PageDTO<LogisticsHealthWarningNotificationsVo>> findAllLogisticsHealthWarningNotifications(PageQuery pageQuery) {
        try {
            Page<LogisticsHealthWarningNotificationsVo> studentHealthWarningNotificationsVo = healthService.findAllLogisticsHealthWarningNotifications(pageQuery);
            return getPageDTOResult2(studentHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/logisticsHealthWarningNotifications2")
    @Operation(summary = "查询不带分页的所有后勤健康预警通知")
    public Result<List<LogisticsHealthWarningNotificationsVo>> findAllLogisticsHealthWarningNotifications2() {
        try {
            List<LogisticsHealthWarningNotificationsVo> studentHealthWarningNotificationsVo = healthService.findAllLogisticsHealthWarningNotifications2();
            return Result.ok(studentHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据后勤标题查询健康预警通知
     *
     * @param
     * @return
     */
    @GetMapping(value = "/logisticsSearchHealthWarningNotifications")
    @Operation(summary = "根据后勤关键字查询健康预警通知")
    public Result<PageDTO<LogisticsHealthWarningNotificationsVo>> searchLogisticsHealthWarningNotifications(PageQuery pageQuery,
                                                                                                            String id,
                                                                                                            String level,
                                                                                                            String startTime,
                                                                                                            String endTime) {
        try {
            Page<LogisticsHealthWarningNotificationsVo> studentHealthWarningNotificationsVo = healthService.searchLogisticsHealthWarningNotifications(pageQuery, id, level, startTime, endTime);
            return getPageDTOResult2(studentHealthWarningNotificationsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<LogisticsHealthWarningNotificationsVo>> getPageDTOResult2(Page<LogisticsHealthWarningNotificationsVo> logisticsHealthWarningNotificationsVo) {
        List<LogisticsHealthWarningNotificationsVo> records = logisticsHealthWarningNotificationsVo.getRecords();
        PageDTO<LogisticsHealthWarningNotificationsVo> pageDTO = new PageDTO<>();
        pageDTO.setRecords(records);
        pageDTO.setTotal((int) logisticsHealthWarningNotificationsVo.getTotal());
        pageDTO.setPages((int) logisticsHealthWarningNotificationsVo.getPages());
        return Result.ok(pageDTO);
    }

    @GetMapping("/addWarningNotice")
    @Operation(summary = "添加预警通知")
    public Result addWarningNotice(@RequestBody HealthWarningNotifications warningNotice) {
        ListOperations<String, String> ops = stringRedisTemplate.opsForList();
        ops.rightPush(
                "warn:" + warningNotice.getUserId(),
                JSON.toJSONString(warningNotice)
        );
        return Result.ok("1");
    }
    @GetMapping("/isEmptyWaringNotice")
    @Operation(summary = "获取当前预警消息")
    public Result isEmptyWaringNotice(@RequestParam("userid") String userid) {
        ListOperations<String, String> ops = stringRedisTemplate.opsForList();
        String info = ops.leftPop("warn:" + userid);
        if(info == null) return Result.ok(null);
        return Result.ok(JSON.parse(info));
    }
}

