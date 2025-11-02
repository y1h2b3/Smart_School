package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.NotificationsMapper;
import com.smart.www.pojo.Notifications;
import com.smart.www.pojo.Notifications;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【notifications】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class NotificationsServiceImpl extends ServiceImpl<NotificationsMapper, Notifications>
        implements NotificationsService {

    @Autowired
    private NotificationsMapper notificationsMapper;
    @Autowired
    private NotificationsService notificationsService;

    @Override
    public Page<Notifications> searchNotifications(PageQuery pageQuery, String value) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Notifications> list = null;
        int total = 0;
        Page<Notifications> notificationsPage = new Page<>();
//        if (key.isEmpty() || value.isEmpty()) {
//            Page<Notifications> page = new Page<>(pageQuery.getCurrent(), pageQuery.getSize());
//            return notificationsService.page(page, null);
//        } else {
//            switch (key) {
//                case "title":
//                    //模糊查询name的value值
//                    list = notificationsMapper.searchBytitle(size, offset, orders, isAsc, value);
//                    total = notificationsMapper.countnotificationsBytitle(value);
//                    break;
//                case "publisher":
//                    list = notificationsMapper.searchBypublisher(size, offset, orders, isAsc, value);
//                    total = notificationsMapper.countBypublisher(value);
//                    break;
//                case "notifyGroup":
//                    list = notificationsMapper.searchBynotifyGroup(size, offset, orders, isAsc, value);
//                    total = notificationsMapper.countBynotifyGroup(value);
//                    break;
//            }
//        }
        list = notificationsMapper.searchBytitle(size, offset, orders, isAsc, value);
        total = notificationsMapper.countnotificationsBytitle(value);
        notificationsPage.setRecords(list);
        notificationsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        notificationsPage.setPages(pages);
        return notificationsPage;
    }

    @Override
    public boolean updateNotifications(Notifications notifications) {
        return notificationsMapper.updateNotifications(notifications) > 0;
    }

    @Override
    public Page<Notifications> findAllNotifications(PageQuery pageQuery, String user) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Notifications> studentList = notificationsMapper.findAllNotifications(size, offset, orders, isAsc,user);
        Page<Notifications> studentPage = new Page<>();
        studentPage.setRecords(studentList);
        int total = notificationsMapper.countAllNotifications(size, offset, orders, isAsc,user);
        studentPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        studentPage.setPages(pages);
        return studentPage;
    }
}




