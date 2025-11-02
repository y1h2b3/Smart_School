package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.StaffOrdersMapper;
import com.smart.www.pojo.StaffOrders;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.StaffOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【staff_orders】的数据库操作Service实现
 * @createDate 2024-04-07 21:51:43
 */
@Service
public class StaffOrdersServiceImpl extends ServiceImpl<StaffOrdersMapper, StaffOrders>
        implements StaffOrdersService {

    @Autowired
    private StaffOrdersMapper staffOrdersMapper;

    @Override
    public Page<StaffOrders> findAllStaffOrders(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<StaffOrders> staffList = staffOrdersMapper.findAllStaffOrders(size, offset, orders, isAsc);
        Page<StaffOrders> staffPage = new Page<>();
        staffPage.setRecords(staffList);
        int total = staffOrdersMapper.countStaffOrders();
        staffPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        staffPage.setPages(pages);
        return staffPage;
    }

    @Override
    public Page<StaffOrders> searchStaffOrdersType(PageQuery pageQuery, String id, String name, String type) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<StaffOrders> list = null;
        int total = 0;
        Page<StaffOrders> StaffPage = new Page<>();
        list = staffOrdersMapper.searchStaffOrders(size, offset, orders, isAsc, id, name, type);
        total = staffOrdersMapper.countSearchStaffOrders(id, name, type);
        StaffPage.setRecords(list);
        StaffPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        StaffPage.setPages(pages);
        return StaffPage;
    }

    @Override
    public boolean removeStaffOrdersBySid(String sid) {
        return staffOrdersMapper.removeStaffOrdersBySid(sid) > 0;
    }

    @Override
    public boolean updateStaffOrders(StaffOrders staffOrders) {
        return staffOrdersMapper.updateStaffOrders(staffOrders) > 0;
    }

    @Override
    public List<StaffOrders> searchStaffOrdersLocation(String location) {
        return staffOrdersMapper.searchStaffOrdersLocation(location);
    }
}




