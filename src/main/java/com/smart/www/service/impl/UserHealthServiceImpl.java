package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.UserHealthMapper;
import com.smart.www.pojo.UserHealth;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.UserHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user_health】的数据库操作Service实现
 * @createDate 2024-03-18 08:35:47
 */
@Service
public class UserHealthServiceImpl extends ServiceImpl<UserHealthMapper, UserHealth>
        implements UserHealthService {

    @Autowired
    private UserHealthMapper userHealthMapper;

    @Override
    public Page<UserHealth> searchStudentUserHealthType(PageQuery pageQuery, String id, String name) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<UserHealth> UserHealthList = userHealthMapper.searchStudentUserHealthType1(size, offset, orders, isAsc, id, name);
        Page<UserHealth> UserHealthPage = new Page<>();
        UserHealthPage.setRecords(UserHealthList);
        int total = userHealthMapper.countStudentUserHealthType(id, name);
        UserHealthPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        UserHealthPage.setPages(pages);
        return UserHealthPage;
    }


    @Override
    public Page<UserHealth> findStudentUserHealth(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<UserHealth> UserHealthList = userHealthMapper.findStudentUserHealth(size, offset, orders, isAsc);
        Page<UserHealth> UserHealthPage = new Page<>();
        UserHealthPage.setRecords(UserHealthList);
        int total = userHealthMapper.countStudentUserHealth();
        UserHealthPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        UserHealthPage.setPages(pages);
        return UserHealthPage;
    }

    @Override
    public Page<UserHealth> findTeacherUserHealth(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<UserHealth> UserHealthList = userHealthMapper.findTeacherUserHealth(size, offset, orders, isAsc);
        Page<UserHealth> UserHealthPage = new Page<>();
        UserHealthPage.setRecords(UserHealthList);
        int total = userHealthMapper.countTeacherUserHealth();
        UserHealthPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        UserHealthPage.setPages(pages);
        return UserHealthPage;
    }

    @Override
    public Page<UserHealth> findLogisticsUserHealth(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<UserHealth> UserHealthList = userHealthMapper.findLogisticsUserHealth(size, offset, orders, isAsc);
        Page<UserHealth> UserHealthPage = new Page<>();
        UserHealthPage.setRecords(UserHealthList);
        int total = userHealthMapper.countLogisticsUserHealth();
        UserHealthPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        UserHealthPage.setPages(pages);
        return UserHealthPage;
    }

    @Override
    public Page<UserHealth> searchTeacherUserHealthType(PageQuery pageQuery, String id, String name) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<UserHealth> UserHealthList = userHealthMapper.searchTeacherUserHealthType1(size, offset, orders, isAsc, id, name);
        Page<UserHealth> UserHealthPage = new Page<>();
        UserHealthPage.setRecords(UserHealthList);
        int total = userHealthMapper.countTeacherUserHealthType(id, name);
        UserHealthPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        UserHealthPage.setPages(pages);
        return UserHealthPage;
    }

    @Override
    public Page<UserHealth> searchLogisticsUserHealthType(PageQuery pageQuery, String id, String name) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<UserHealth> UserHealthList = userHealthMapper.searchLogisticsUserHealthType1(size, offset, orders, isAsc, id, name);
        Page<UserHealth> UserHealthPage = new Page<>();
        UserHealthPage.setRecords(UserHealthList);
        int total = userHealthMapper.countLogisticsUserHealthType(id, name);
        UserHealthPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        UserHealthPage.setPages(pages);
        return UserHealthPage;
    }

    @Override
    public List<UserHealth> findId(String uid) {
        return userHealthMapper.findId(uid);
    }

    @Override
    public void updateCheck(String userId, String s) {
        userHealthMapper.updateCheck(userId, s);
    }

    @Override
    public List<UserHealth> searchIdUserHealthType(String uid) {
        return userHealthMapper.searchIdUserHealthType(uid);
    }

    @Override
    public UserHealth findUserHealthByTime(String userId, String time) {
        return userHealthMapper.getUserHealthByTime(userId, time);
    }
}




