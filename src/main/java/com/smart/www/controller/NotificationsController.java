package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.NotificationsMapper;
import com.smart.www.pojo.Notifications;
import com.smart.www.pojo.Vo.NotificationsVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.NotificationsService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "通知管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;
    @Autowired
    private NotificationsMapper notificationsMapper;
    @Autowired
    private LogsDataService logsDataService;

    /**
     * 查询所有通知
     *
     * @return
     */
    @GetMapping("/notifications")
    @Operation(summary = "查询所有通知")
    public Result<PageDTO<NotificationsVo>> findAllNotifications(PageQuery pageQuery,String user) {
        try {
            Page<Notifications> page = notificationsService.findAllNotifications(pageQuery,user);
            return getPageDTOResult(page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    /**
     * 根据标题查询通知
     *
     * @param
     * @return
     */
    @GetMapping("/searchNotifications")
    @Operation(summary = "根据标题查询通知")
    public Result<PageDTO<NotificationsVo>> searchNotifications(PageQuery pageQuery, String value) {
        try {
            Page<Notifications> page1 = notificationsService.searchNotifications(pageQuery, value);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<NotificationsVo>> getPageDTOResult(Page<Notifications> page1) {
        List<NotificationsVo> notificationsVos = page1.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<NotificationsVo> notificationsVoPageDTO = new PageDTO<>();
        notificationsVoPageDTO.setRecords(notificationsVos);
        notificationsVoPageDTO.setPages((int) page1.getPages());
        notificationsVoPageDTO.setTotal((int) page1.getTotal());
        return Result.ok(notificationsVoPageDTO);
    }

    /**
     * 根据id删除通知
     *
     * @param nid
     * @return
     */
    @DeleteMapping("/notifications/{nid}")
    @Operation(summary = "根据id删除通知")
    public Result removeNotificationsByNid(@PathVariable String nid, HttpServletRequest request) {
        LambdaQueryWrapper<Notifications> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Notifications::getNotifyId, nid);
        Notifications notifications = notificationsMapper.selectOne(wrapper);
        boolean b = notificationsService.remove(wrapper);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除通知",
                    "删除成功",
                    "删除id:" + notifications.getNotifyId() + ",标题:" + notifications.getTitle(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除通知",
                    "删除失败",
                    "删除id:" + notifications.getNotifyId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 更新通知信息
     *
     * @param notifications
     * @return
     */
    @PutMapping("/notifications")
    @Operation(summary = "更新通知信息")
    public Result updateNotifications(@RequestBody Notifications notifications, HttpServletRequest request) {
        notifications.setUpdateTime(new Date());
        boolean b = notificationsService.updateNotifications(notifications);
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新通知",
                    "更新成功",
                    "更新id:" + notifications.getNotifyId() + ",标题:" + notifications.getTitle(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新通知",
                    "更新失败",
                    "更新id:" + notifications.getNotifyId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加通知
     *
     * @param notifications
     * @return
     */
    @PostMapping("/notifications")
    @Operation(summary = "添加通知")
    public Result addNotifications(@RequestBody Notifications notifications, HttpServletRequest request) {
        notifications.setCreateTime(new Date());
        notifications.setUpdateTime(new Date());
        notifications.setTime(new Date());
        boolean b = notificationsService.save(notifications);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加通知",
                    "添加成功",
                    "添加id:" + notifications.getNotifyId() + ",标题:" + notifications.getTitle(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加通知",
                    "添加失败",
                    "添加id:" + notifications.getNotifyId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private NotificationsVo ConvertToVo(Notifications notifications) {
        NotificationsVo notificationsVo = new NotificationsVo();
        notificationsVo.setNotifyId(notifications.getNotifyId());
        notificationsVo.setTime(notifications.getTime());
        notificationsVo.setNotifyGroup(notifications.getNotifyGroup());
        notificationsVo.setPublisher(notifications.getPublisher());
        notificationsVo.setTitle(notifications.getTitle());
        notificationsVo.setContent(notifications.getContent());
        return notificationsVo;
    }
}
