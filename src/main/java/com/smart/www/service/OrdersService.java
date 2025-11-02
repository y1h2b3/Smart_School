package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Orders;
import com.smart.www.pojo.query.PageQuery;

/**
 * @author Administrator
 * @description 针对表【orders】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface OrdersService extends IService<Orders> {

    Page<Orders> searchOrdersType(PageQuery pageQuery, String oid, String uid, String type,String startTime, String endTime);

    Page<Orders> findAllOrders(PageQuery pageQuery);

    boolean removeOrdersByOid(String oid);

    boolean updateOrders(Orders orders);

    String findID(String donaDrugId);

}
