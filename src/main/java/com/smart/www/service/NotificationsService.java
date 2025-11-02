package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Notifications;
import com.smart.www.pojo.query.PageQuery;

/**
 * @author Administrator
 * @description 针对表【notifications】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface NotificationsService extends IService<Notifications> {

    Page<Notifications> searchNotifications(PageQuery pageQuery,  String title);

    boolean updateNotifications(Notifications notifications);

    Page<Notifications> findAllNotifications(PageQuery pageQuery, String user);
}
