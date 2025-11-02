package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Student;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【student】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface StudentService extends IService<Student> {
    Page<Student> searchStudentType(PageQuery pageQuery, String key, String value, String name,String phone);

    Page<Student> findAllStudent(PageQuery pageQuery);

    boolean removeStudentBySid(String sid);

    boolean updateStudentById(Student student);

    List<Student> findAllStudent2();

    List<Student> findClszz();

    List<Student> findGrader();

    Long getStudentTotal();
}
