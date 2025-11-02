package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.LogisticsMapper;
import com.smart.www.pojo.Logistics;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【logistics】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class LogisticsServiceImpl extends ServiceImpl<LogisticsMapper, Logistics>
        implements LogisticsService {

    @Autowired
    private LogisticsMapper logisticsMapper;

    @Override
    public Page<Logistics> searchLogisticsType(PageQuery pageQuery, String post, String id, String name, String phone) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Logistics> list = null;
        int total = 0;
        Page<Logistics> TeacherPage = new Page<>();
//            switch (key) {
//                case "name":
//                    //模糊查询name的value值
//                    list = logisticsMapper.searchByName(size, offset, orders, isAsc, value);
//                    total = logisticsMapper.countlogisticsByName(value);
//                    break;
//                case "post":
//                    list = logisticsMapper.searchByType(size, offset, orders, isAsc, value);
//                    total = logisticsMapper.countlogisticsByType(value);
//                    break;
//                case "logisticsId":
//                    list = logisticsMapper.searchBylogisticsId(size, offset, orders, isAsc, value);
//                    total = logisticsMapper.countlogisticsByTeacherId(value);
//                    break;
//                case "sex":
//                    list = logisticsMapper.searchBysex(size, offset, orders, isAsc, value);
//                    total = logisticsMapper.countlogisticsBysex(value);
//                    break;
//                case "status":
//                    list = logisticsMapper.searchByStatus(size, offset, orders, isAsc, value);
//                    total = logisticsMapper.countlogisticsByStatus(value);
//                    break;
//            }
        list = logisticsMapper.searchLogistics(size, offset, orders, isAsc, post, id, name,phone);
        total = logisticsMapper.countLogistics(post, id, name,phone);
        TeacherPage.setRecords(list);
        TeacherPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        TeacherPage.setPages(pages);
        return TeacherPage;
    }

    @Override
    public Page<Logistics> findAllLogistics(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Logistics> LogisticsList = logisticsMapper.findAlllogistics(size, offset, orders, isAsc);
        Page<Logistics> LogisticsPage = new Page<>();
        LogisticsPage.setRecords(LogisticsList);
        int total = logisticsMapper.countAlllogistics();
        LogisticsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        LogisticsPage.setPages(pages);
        return LogisticsPage;
    }

    @Override
    public boolean removeLogisticsByLid(String lid) {
        return logisticsMapper.removeLogisticsByLid(lid) > 0;
    }

    @Override
    public List<Logistics> findAllLogistics2() {
        return logisticsMapper.findAlllogistics2();
    }


    @Override
    public boolean updateLogistics(Logistics logistics) {
        return logisticsMapper.updateLogistics(logistics) > 0;
    }

    @Override
    public Long getLogisticsToTal() {
        return logisticsMapper.getLogisticsToTal();
    }
}




