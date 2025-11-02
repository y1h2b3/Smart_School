package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.TeacherMapper;
import com.smart.www.pojo.Teacher;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【teacher】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
        implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Page<Teacher> searchTeacherType(PageQuery pageQuery, String post, String id, String name, String phone) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Teacher> list = null;
        int total = 0;
        Page<Teacher> TeacherPage = new Page<>();
//            switch (key) {
//                case "name":
//                    //模糊查询name的value值
//                    list = teacherMapper.searchByName(size, offset, orders, isAsc, value);
//                    total = teacherMapper.countTeacherByName(value);
//                    break;
//                case "post":
//                    list = teacherMapper.searchByType(size, offset, orders, isAsc, value);
//                    total = teacherMapper.countTeacherByType(value);
//                    break;
//                case "teacherId":
//                    list = teacherMapper.searchByTeacherId(size, offset, orders, isAsc, value);
//                    total = teacherMapper.countTeacherByTeacherId(value);
//                    break;
//                case "sex":
//                    list = teacherMapper.searchBysex(size, offset, orders, isAsc, value);
//                    total = teacherMapper.countTeacherBysex(value);
//                    break;
//                case "status":
//                    list = teacherMapper.searchByStatus(size, offset, orders, isAsc, value);
//                    total = teacherMapper.countTeacherByStatus(value);
//                    break;
//            }
        list = teacherMapper.searchTeacher(size, offset, orders, isAsc, post, id, name,phone);
        total = teacherMapper.countTeacher(post, id, name,phone);
        TeacherPage.setRecords(list);
        TeacherPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        TeacherPage.setPages(pages);
        return TeacherPage;
    }

    @Override
    public Page<Teacher> findAllTeacher(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Teacher> teacherList = teacherMapper.findAllTeacher(size, offset, orders, isAsc);
        Page<Teacher> teacherPage = new Page<>();
        teacherPage.setRecords(teacherList);
        int total = teacherMapper.countAllTeacher();
        teacherPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        teacherPage.setPages(pages);
        return teacherPage;
    }

    @Override
    public boolean removeTeacherByTid(String tid) {
        return teacherMapper.removeTeacherByTid(tid) > 0;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher) > 0;
    }

    @Override
    public List<Teacher> findAllTeacher2() {
        return teacherMapper.findAllTeacher2();
    }

    @Override
    public Long getTeacherToTal() {
        return teacherMapper.getTeacherToTal();
    }
}




