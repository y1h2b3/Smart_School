package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.StaffMapper;
import com.smart.www.pojo.Staff;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【staff】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
        implements StaffService {
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    StaffService staffService;

    @Override
    public Page<Staff> searchStaffType(PageQuery pageQuery, String id, String name, String isOnline,String location) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Staff> list = null;
        int total = 0;
        Page<Staff> StaffPage = new Page<>();
//        if (key.isEmpty() || value.isEmpty()) {
//            Page<Staff> page = new Page<>(pageQuery.getCurrent(), pageQuery.getSize());
//            return staffService.page(page, null);
//        } else {
//            switch (key) {
//                case "name":
//                    //模糊查询name的value值
//                    list = staffMapper.searchByName(size, offset, orders, isAsc, value);
//                    total = staffMapper.countStaffByName(value);
//                    break;
//                case "staffId":
//                    list = staffMapper.searchByStaffId(size, offset, orders, isAsc, value);
//                    total = staffMapper.countStaffByStaffId(value);
//                    break;
//                case "isActive":
//                    list = staffMapper.searchByIsActive(size, offset, orders, isAsc, value);
//                    total = staffMapper.countStaffByIsActive(value);
//                    break;
//                case "location":
//                    list = staffMapper.searchByLocation(size, offset, orders, isAsc, value);
//                    total = staffMapper.countStaffByLocation(value);
//                    break;
//                case "sex":
//                    list = staffMapper.searchBySex(size, offset, orders, isAsc, value);
//                    total = staffMapper.countStaffBySex(value);
//                    break;
//            }
//        }
        list = staffMapper.searchStaff(size, offset, orders, isAsc, id, name, isOnline,location);
        total = staffMapper.countStaff(id, name, orders,location);

        StaffPage.setRecords(list);
        StaffPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        StaffPage.setPages(pages);
        return StaffPage;
    }

}




