package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.StudentMapper;
import com.smart.www.pojo.Student;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page<Student> searchStudentType(PageQuery pageQuery, String clazz, String Id, String name,String phone) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Student> list = null;
        int total = 0;
        Page<Student> StudentPage = new Page<>();

//            switch (key) {
//                case "name":
//                    //模糊查询name的value值
//                    list = studentMapper.searchByName(size, offset, orders, isAsc, value);
//                    total = studentMapper.countStudentByName(value);
//                    break;
//                case "type":
//                    list = studentMapper.searchByType(size, offset, orders, isAsc, value);
//                    total = studentMapper.countStudentByType(value);
//                    break;
//                case "studentId":
//                    list = studentMapper.searchByStudentId(size, offset, orders, isAsc, value);
//                    total = studentMapper.countStudentByStudentId(value);
//                    break;
//                case "clazz":
//                    list = studentMapper.searchByClazz(size, offset, orders, isAsc, value);
//                    total = studentMapper.countStudentByClazz(value);
//                    break;
//                case "status":
//                    list = studentMapper.searchByStatus(size, offset, orders, isAsc, value);
//                    total = studentMapper.countStudentByStatus(value);
//                    break;
//            }
        list = studentMapper.searchStudent(size, offset, orders, isAsc, clazz, Id, name,phone);
        total = studentMapper.countStudent(clazz, Id, name,phone);
        StudentPage.setRecords(list);
        StudentPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        StudentPage.setPages(pages);
        return StudentPage;
    }

    @Override
    public Page<Student> findAllStudent(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Student> studentList = studentMapper.findAllStudent(size, offset, orders, isAsc);
        Page<Student> studentPage = new Page<>();
        studentPage.setRecords(studentList);
        int total = studentMapper.countAllDrugs();
        studentPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        studentPage.setPages(pages);
        return studentPage;
    }

    @Override
    public boolean removeStudentBySid(String sid) {
        return studentMapper.removeStudentBySid(sid) > 0;
    }

    @Override
    public boolean updateStudentById(Student student) {
        return studentMapper.updateStudentById(student) > 0;
    }

    @Override
    public List<Student> findAllStudent2() {
        return studentMapper.findAllStudent2();
    }

    @Override
    public List<Student> findClszz() {
        return studentMapper.findClszz();
    }

    @Override
    public List<Student> findGrader() {
        return studentMapper.findGrader();
    }

    @Override
    public Long getStudentTotal() {
        return studentMapper.getStudentTotal();
    }
}




