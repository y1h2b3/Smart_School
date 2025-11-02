package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.HealthWarningNotifications;
import com.smart.www.pojo.Vo.LogisticsHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.StudentHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.TeacherHealthWarningNotificationsVo;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【health_warning_notifications】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface HealthWarningNotificationsService extends IService<HealthWarningNotifications> {

    Page<StudentHealthWarningNotificationsVo> searchStudentHealthWarningNotifications(PageQuery pageQuery, String id, String type, String startTime, String endTime);

    Page<StudentHealthWarningNotificationsVo> findAllStudentHealthWarningNotifications(PageQuery pageQuery);

    Page<TeacherHealthWarningNotificationsVo> findAllTeacherHealthWarningNotifications(PageQuery pageQuery);

    Page<TeacherHealthWarningNotificationsVo> searchTeacherHealthWarningNotifications(PageQuery pageQuery, String id, String type, String startTime, String endTime);

    Page<LogisticsHealthWarningNotificationsVo> findAllLogisticsHealthWarningNotifications(PageQuery pageQuery);

    Page<LogisticsHealthWarningNotificationsVo> searchLogisticsHealthWarningNotifications(PageQuery pageQuery, String id, String type, String startTime, String endTime);

    List<StudentHealthWarningNotificationsVo> findAllStudentHealthWarningNotifications2();

    List<TeacherHealthWarningNotificationsVo> findAllTeacherHealthWarningNotifications2();

    List<LogisticsHealthWarningNotificationsVo> findAllLogisticsHealthWarningNotifications2();

    boolean removeHealthWarningNotificationsByHid(String hid);
}
