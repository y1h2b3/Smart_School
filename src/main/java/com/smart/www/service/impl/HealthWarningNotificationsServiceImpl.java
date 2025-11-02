package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.HealthWarningNotificationsMapper;
import com.smart.www.pojo.HealthWarningNotifications;
import com.smart.www.pojo.Vo.LogisticsHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.StudentHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.TeacherHealthWarningNotificationsVo;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.HealthWarningNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【health_warning_notifications】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class HealthWarningNotificationsServiceImpl extends ServiceImpl<HealthWarningNotificationsMapper, HealthWarningNotifications>
        implements HealthWarningNotificationsService {

    @Autowired
    private HealthWarningNotificationsMapper healthWarningNotificationsMapper;

    @Override
    public Page<StudentHealthWarningNotificationsVo> searchStudentHealthWarningNotifications(PageQuery pageQuery, String id, String type, String startTime, String endTime) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<StudentHealthWarningNotificationsVo> list = null;
        int total = 0;
        Page<StudentHealthWarningNotificationsVo> healthWarningNotifications = new Page<>();
        list = healthWarningNotificationsMapper.searchStudentHealthWarningNotifications(size, offset, orders, isAsc, id, type, startTime, endTime);
        total = healthWarningNotificationsMapper.countStudentHealthWarningNotifications(id, type, startTime, endTime);
        healthWarningNotifications.setRecords(list);
        healthWarningNotifications.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        healthWarningNotifications.setPages(pages);
        return healthWarningNotifications;
    }

    @Override
    public Page<StudentHealthWarningNotificationsVo> findAllStudentHealthWarningNotifications(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<StudentHealthWarningNotificationsVo> studenthealthWarningNotificationsList = healthWarningNotificationsMapper.findAllStudentHealthWarningNotifications(size, offset, orders, isAsc);
        Page<StudentHealthWarningNotificationsVo> studenthealthWarningNotificationsPage = new Page<>();
        studenthealthWarningNotificationsPage.setRecords(studenthealthWarningNotificationsList);
        int total = healthWarningNotificationsMapper.countAllhealthWarningNotifications();
        studenthealthWarningNotificationsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        studenthealthWarningNotificationsPage.setPages(pages);
        return studenthealthWarningNotificationsPage;
    }

    @Override
    public Page<TeacherHealthWarningNotificationsVo> findAllTeacherHealthWarningNotifications(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<TeacherHealthWarningNotificationsVo> studenthealthWarningNotificationsList = healthWarningNotificationsMapper.findAllTeacherHealthWarningNotifications(size, offset, orders, isAsc);
        Page<TeacherHealthWarningNotificationsVo> studenthealthWarningNotificationsPage = new Page<>();
        studenthealthWarningNotificationsPage.setRecords(studenthealthWarningNotificationsList);
        int total = healthWarningNotificationsMapper.countTeacherAllhealthWarningNotifications();
        studenthealthWarningNotificationsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        studenthealthWarningNotificationsPage.setPages(pages);
        return studenthealthWarningNotificationsPage;
    }

    @Override
    public Page<TeacherHealthWarningNotificationsVo> searchTeacherHealthWarningNotifications(PageQuery pageQuery, String id, String type, String startTime, String endTime) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        Page<TeacherHealthWarningNotificationsVo> studenthealthWarningNotificationsPage = new Page<>();
        List<TeacherHealthWarningNotificationsVo> list = healthWarningNotificationsMapper.searchTeacherHealthWarningNotifications(size, offset, orders, isAsc, id, type, startTime, endTime);
        studenthealthWarningNotificationsPage.setRecords(list);
        int total = healthWarningNotificationsMapper.countTeacherHealthWarningNotifications(id, type, startTime, endTime);
        studenthealthWarningNotificationsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        studenthealthWarningNotificationsPage.setPages(pages);
        return studenthealthWarningNotificationsPage;
    }

    @Override
    public Page<LogisticsHealthWarningNotificationsVo> findAllLogisticsHealthWarningNotifications(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<LogisticsHealthWarningNotificationsVo> LogisticshealthWarningNotificationsList = healthWarningNotificationsMapper.findAllLogisticsHealthWarningNotifications(size, offset, orders, isAsc);
        Page<LogisticsHealthWarningNotificationsVo> LogisticshealthWarningNotificationsPage = new Page<>();
        LogisticshealthWarningNotificationsPage.setRecords(LogisticshealthWarningNotificationsList);
        int total = healthWarningNotificationsMapper.countAllLogisticshealthWarningNotifications();
        LogisticshealthWarningNotificationsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        LogisticshealthWarningNotificationsPage.setPages(pages);
        return LogisticshealthWarningNotificationsPage;
    }

    @Override
    public Page<LogisticsHealthWarningNotificationsVo> searchLogisticsHealthWarningNotifications(PageQuery pageQuery, String id, String type, String startTime, String endTime) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<LogisticsHealthWarningNotificationsVo> list = null;
        int total = 0;
        Page<LogisticsHealthWarningNotificationsVo> healthWarningNotifications = new Page<>();
//        if (key.isEmpty() || value.isEmpty()) {
//            list = healthWarningNotificationsMapper.findAllLogisticsHealthWarningNotifications(size, offset, orders, isAsc);
//            total = healthWarningNotificationsMapper.countAllLogisticshealthWarningNotifications();
//            healthWarningNotifications.setRecords(list);
//            healthWarningNotifications.setTotal(total);
//            int pages = (int) Math.ceil((double) total / size);
//            healthWarningNotifications.setPages(pages);
//            return healthWarningNotifications;
//        } else {
//            switch (key) {
//                case "username":
//                    list = healthWarningNotificationsMapper.searchLogisticsByUserName(size, offset, orders, isAsc, value);
//                    total = healthWarningNotificationsMapper.countLogisticsByName(value);
//                    break;
//                case "usertype":
//                    list = healthWarningNotificationsMapper.searchLogisticsByUserType(size, offset, orders, isAsc, value);
//                    total = healthWarningNotificationsMapper.countLogisticsByType(value);
//                    break;
//                case "level":
//                    list = healthWarningNotificationsMapper.searchLogisticsBylevel(size, offset, orders, isAsc, value);
//                    total = healthWarningNotificationsMapper.countLogisticsBylevel(value);
//                    break;
//                case "post":
//                    list = healthWarningNotificationsMapper.searchLogisticsByPost(size, offset, orders, isAsc, value);
//                    total = healthWarningNotificationsMapper.countLogisticsByPost(value);
//                    break;
//            }
//        }
        list = healthWarningNotificationsMapper.searchLogisticsHealthWarningNotifications(size, offset, orders, isAsc, id, type, startTime, endTime);
        total = healthWarningNotificationsMapper.countLogisticsHealthWarningNotifications(id, type, startTime, endTime);
        healthWarningNotifications.setRecords(list);
        healthWarningNotifications.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        healthWarningNotifications.setPages(pages);
        return healthWarningNotifications;
    }

    @Override
    public List<StudentHealthWarningNotificationsVo> findAllStudentHealthWarningNotifications2() {
        return healthWarningNotificationsMapper.findAllStudentHealthWarningNotifications2();
    }

    @Override
    public List<TeacherHealthWarningNotificationsVo> findAllTeacherHealthWarningNotifications2() {
        return healthWarningNotificationsMapper.findAllTeacherHealthWarningNotifications2();
    }

    @Override
    public List<LogisticsHealthWarningNotificationsVo> findAllLogisticsHealthWarningNotifications2() {
        return healthWarningNotificationsMapper.findAllLogisticsHealthWarningNotifications2();
    }

    @Override
    public boolean removeHealthWarningNotificationsByHid(String hid) {
        return healthWarningNotificationsMapper.removeHealthWarningNotificationsByHid(hid);
    }
}




