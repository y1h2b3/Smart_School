package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.StaffOrders;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【staff_orders】的数据库操作Service
 * @createDate 2024-04-07 21:51:43
 */
public interface StaffOrdersService extends IService<StaffOrders> {

    Page<StaffOrders> findAllStaffOrders(PageQuery pageQuery);

    Page<StaffOrders> searchStaffOrdersType(PageQuery pageQuery, String id, String name, String type);

    boolean removeStaffOrdersBySid(String sid);

    boolean updateStaffOrders(StaffOrders staffOrders);

    List<StaffOrders> searchStaffOrdersLocation(String location);
}
