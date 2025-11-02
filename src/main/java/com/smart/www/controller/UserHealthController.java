package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.UserHealthMapper;
import com.smart.www.pojo.UserHealth;
import com.smart.www.pojo.Vo.UserHealthVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.UserHealthService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "用户健康管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class UserHealthController {

    @Autowired
    private UserHealthService userHealthService;
    @Autowired
    private UserHealthMapper userHealthMapper;
    @Autowired
    private LogsDataService logsDataService;

    @GetMapping("/StudentHealthDate")
    @Operation(summary = "查询所有学生健康")
    public Result<PageDTO<UserHealthVo>> findStudentUserHealth(PageQuery pageQuery) {
        try {
            Page<UserHealth> list = userHealthService.findStudentUserHealth(pageQuery);
            return getPageDTOResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/TeacherHealthDate")
    @Operation(summary = "查询所有老师健康")
    public Result<PageDTO<UserHealthVo>> findTeacherUserHealth(PageQuery pageQuery) {
        try {
            Page<UserHealth> list = userHealthService.findTeacherUserHealth(pageQuery);
            return getPageDTOResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<UserHealthVo>> getPageDTOResult(Page<UserHealth> list) {
        List<UserHealthVo> userHealthVos = list.getRecords().stream()
                .map(this::ConvertToVo)
                .toList();
        PageDTO<UserHealthVo> userHealthVoPageDTO = new PageDTO<>();
        userHealthVoPageDTO.setRecords(userHealthVos);
        userHealthVoPageDTO.setTotal((int) list.getTotal());
        userHealthVoPageDTO.setPages((int) list.getPages());
        return Result.ok(userHealthVoPageDTO);
    }

    @GetMapping("/LogisticsHealthDate")
    @Operation(summary = "查询所有后勤健康")
    public Result<PageDTO<UserHealthVo>> findLogisticsUserHealth(PageQuery pageQuery) {
        try {
            Page<UserHealth> list = userHealthService.findLogisticsUserHealth(pageQuery);
            return getPageDTOResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    @GetMapping("/StudentUserHealth")
    @Operation(summary = "根据关键字学生查询用户健康")
    public Result<PageDTO<UserHealthVo>> searchStudentUserHealthType(PageQuery pageQuery, String id, String name) {
        try {
            Page<UserHealth> list = userHealthService.searchStudentUserHealthType(pageQuery, id, name);
            return getPageDTOResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/TeacherUserHealth")
    @Operation(summary = "根据关键字老师查询用户健康")
    public Result<PageDTO<UserHealthVo>> searchTeacherUserHealthType(PageQuery pageQuery, String id, String name) {
        try {
            Page<UserHealth> list = userHealthService.searchTeacherUserHealthType(pageQuery, id, name);
            return getPageDTOResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/LogisticsUserHealth")
    @Operation(summary = "根据关键字后勤查询用户健康")
    public Result<PageDTO<UserHealthVo>> searchLogisticsUserHealthType(PageQuery pageQuery, String id, String name) {
        try {
            Page<UserHealth> list = userHealthService.searchLogisticsUserHealthType(pageQuery, id, name);
            return getPageDTOResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @DeleteMapping("/userHealth/{uid}")
    @Operation(summary = "根据id删除用户健康")
    public Result removeUserHealthByUid(@PathVariable String uid, HttpServletRequest request) {
        List<UserHealth> list = userHealthService.findId(uid);
        int delete = userHealthMapper.removeUserHealthByUid(uid);
        if (delete > 0) {
            logsDataService.addLogsData("admin",
                    "修改学生",
                    "修改成功",
                    "修改id:" + list.get(0).getUserId() + ",名字:" + list.get(0).getUserName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "修改学生",
                    "修改失败",
                    "修改id:" + list.get(0).getUserId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }
    @GetMapping("/userHealthByTime")
    public Result getUserHealthByDate(@RequestParam("userId") String userId, @RequestParam("time") String time) {
        String[] splitArr = time.split("-");
        for(int i = 1;i <= 2;i++)
            splitArr[i] = Integer.parseInt(splitArr[i])>10?splitArr[i]:"0"+splitArr[i];
        time = splitArr[0]+"-"+splitArr[1]+"-"+splitArr[2];
        UserHealth userHealth = userHealthService.findUserHealthByTime(userId, time);
        return Result.build(userHealth, userHealth!=null?1:0, "");
    }
    public UserHealthVo ConvertToVo(UserHealth userHealth) {
        UserHealthVo userHealthVo = new UserHealthVo();
        userHealthVo.setUserId(userHealth.getUserId());
        userHealthVo.setUserName(userHealth.getUserName());
        userHealthVo.setHeight(userHealth.getHeight());
        userHealthVo.setWeight(userHealth.getWeight());
        userHealthVo.setFatPercentage(userHealth.getFatPercentage());
        userHealthVo.setBmi(userHealth.getBmi());
        userHealthVo.setPostOrClazz(userHealth.getPostOrClazz());
        userHealthVo.setType(userHealth.getType());
        userHealthVo.setMeasureTime(userHealth.getMeasureTime());
        userHealthVo.setSleepTimeTotal(userHealth.getSleepTimeTotal());
        userHealthVo.setDeepSleepTotal(userHealth.getDeepSleepTotal());
        userHealthVo.setLightSleepTotal(userHealth.getLightSleepTotal());
        userHealthVo.setWakeTimeTotal(userHealth.getWakeTimeTotal());
        userHealthVo.setListSleepTime(userHealth.getListSleepTime());
        userHealthVo.setTodayWakeupTime(userHealth.getTodayWakeupTime());
        userHealthVo.setStep(userHealth.getStep());
        userHealthVo.setWalkingDistance(userHealth.getWalkingDistance());
        userHealthVo.setWalkingTime(userHealth.getWalkingTime());
        userHealthVo.setCalorie(userHealth.getCalorie());
        userHealthVo.setMeanRestingHeartRate(userHealth.getMeanRestingHeartRate());
        userHealthVo.setRestingHeartRateMax(userHealth.getRestingHeartRateMax());
        userHealthVo.setRestingHeartRateMin(userHealth.getRestingHeartRateMin());
        userHealthVo.setSpo2(userHealth.getSpo2());
        userHealthVo.setTemperature(userHealth.getTemperature());
        return userHealthVo;
    }
}
