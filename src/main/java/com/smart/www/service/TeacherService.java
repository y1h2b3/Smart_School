package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Teacher;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【teacher】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> searchTeacherType(PageQuery pageQuery, String post, String id, String name, String phone);

    Page<Teacher> findAllTeacher(PageQuery pageQuery);

    boolean removeTeacherByTid(String tid);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> findAllTeacher2();

    Long getTeacherToTal();
}
