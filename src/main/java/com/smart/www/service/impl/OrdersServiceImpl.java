package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.OrdersMapper;
import com.smart.www.pojo.Orders;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersService ordersService;

    @Override
    public Page<Orders> searchOrdersType(PageQuery pageQuery, String oid, String uid, String type,String startTime, String endTime) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Orders> list = null;
        int total = 0;
        Page<Orders> ordersPage = new Page<>();
//        if (key.isEmpty() || value.isEmpty()) {
//            return ordersService.findAllOrders(pageQuery);
//        } else {
//            switch (key) {
//                case "name":
//                    //模糊查询name的value值
//                    list = ordersMapper.searchByName(size, offset, orders, isAsc, value);
//                    total = ordersMapper.countordersByName(value);
//                    break;
//                case "ordersId":
//                    list = ordersMapper.searchByordersId(size, offset, orders, isAsc, value);
//                    total = ordersMapper.countordersByordersId(value);
//                    break;
//                case "userId":
//                    list = ordersMapper.searchBystudentId(size, offset, orders, isAsc, value);
//                    total = ordersMapper.countordersBystudentId(value);
//                    break;
//            }
//        }
        list = ordersMapper.searchOrders(size, offset, orders, isAsc, oid, uid, type, startTime,  endTime);
        total = ordersMapper.countOrders(oid, uid, type, startTime,  endTime);
        ordersPage.setRecords(list);
        ordersPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        ordersPage.setPages(pages);
        return ordersPage;
    }

    @Override
    public Page<Orders> findAllOrders(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Orders> ordersList = ordersMapper.findAllOrders(size, offset, orders, isAsc);
        Page<Orders> ordersPage = new Page<>();
        ordersPage.setRecords(ordersList);
        int total = ordersMapper.countAllOrders();
        ordersPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        ordersPage.setPages(pages);
        return ordersPage;
    }

    @Override
    public boolean removeOrdersByOid(String oid) {
        return ordersMapper.removeOrdersByOid(oid) > 0;
    }

    @Override
    public boolean updateOrders(Orders orders) {
        return ordersMapper.updateOrders(orders) > 0;
    }

    @Override
    public String findID(String donaDrugId) {
        return ordersMapper.findID(donaDrugId);
    }

}




