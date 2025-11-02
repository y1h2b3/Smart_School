package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.StudentMapper;
import com.smart.www.pojo.Student;
import com.smart.www.pojo.Vo.StudentVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.StudentService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@Tag(name = "学生管理")
@AllArgsConstructor
@SaCheckLogin(type = StpUtil.TYPE)
public class StudentController {
    private static final File BASEPATH = new File("C:\\Users\\Administrator\\Desktop\\SmartSchool");
    private StudentService studentService;
    private LogsDataService logsDataService;
    private StudentMapper studentMapper;

    /**
     * 查询所有学生
     *
     * @return
     */
    @GetMapping("/student")
    @Operation(summary = "查询带分页所有学生")
    public Result<PageDTO<StudentVo>> findAllStudent(PageQuery pageQuery) {
        try {
            Page<Student> students = studentService.findAllStudent(pageQuery);
            return getPageDTOResult(students);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    @GetMapping("/student2")
    @Operation(summary = "查询不带分页所有学生")
    public Result<List<StudentVo>> findAllStudent2() {
        try {
            List<Student> students = studentService.findAllStudent2();
            return Result.ok(students.stream().map(this::convertToVO).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }
    @GetMapping("/clazz")
    @Operation(summary = "查询班级")
    public Result findClazz(){
        List<Student> list = studentService.findClszz();
        List<String> resultList = new ArrayList<>();
        for (Student student : list) {
            resultList.add(student.getClazz());
        }
        return Result.ok(resultList);
    }

    @GetMapping("/grader")
    @Operation(summary = "查询年级")
    public Result findGrader(){
        List<Student> list = studentService.findGrader();
        List<String> resultList = new ArrayList<>();
        for (Student student : list) {
            resultList.add(student.getGrade());
        }
        return Result.ok(resultList);
    }

    /**
     * 根据关键字查询学生
     *
     * @param
     * @param
     * @return
     */
    @GetMapping("/searchStudent")
    @Operation(summary = "根据关键字查询学生")
    public Result<PageDTO<StudentVo>> searchStudentType(PageQuery pageQuery, String clazz, String id, String name,String phone) {
        try {
            Page<Student> students = studentService.searchStudentType(pageQuery, clazz, id, name,phone);
            return getPageDTOResult(students);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<StudentVo>> getPageDTOResult(Page<Student> students) {
        List<StudentVo> studentVos = students.getRecords().stream().map(this::convertToVO).collect(Collectors.toList());
        PageDTO<StudentVo> studentVoPageDTO = new PageDTO<>();
        studentVoPageDTO.setRecords(studentVos);
        studentVoPageDTO.setTotal((int) students.getTotal());
        studentVoPageDTO.setPages((int) students.getPages());
        return Result.ok(studentVoPageDTO);
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @PostMapping("/student")
    @Operation(summary = "添加学生")
    public Result addStudent(@RequestBody Student student, HttpServletRequest request) {
        student.setType("学生");
        student.setStatus(1);
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        boolean b = studentService.save(student);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加学生",
                    "添加成功",
                    "添加id:" + student.getStudentId() + ",名字:" + student.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加学生",
                    "添加失败",
                    "添加id:" + student.getStudentId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据id删除学生
     *
     * @param sid
     * @return
     */
    @DeleteMapping("/student/{sid}")
    @Operation(summary = "根据id删除学生")
    public Result removeStudentBySid(@PathVariable String sid, HttpServletRequest request) {
        PageQuery pageQuery = new PageQuery();
        Page<Student> studentId = studentService.searchStudentType(pageQuery, null, sid, null,null);
        boolean b = studentService.removeStudentBySid(sid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除学生",
                    "删除成功",
                    "删除id:" + studentId.getRecords().get(0).getStudentId() + ",名字:" + studentId.getRecords().get(0).getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除学生",
                    "删除失败",
                    "删除id:" + sid + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @PutMapping("/student")
    @Operation(summary = "更新学生信息")
    public Result updateStudent(@RequestBody Student student, HttpServletRequest request) {
        boolean b = studentService.updateStudentById(student);
        if (b) {
            logsDataService.addLogsData("admin",
                    "修改学生",
                    "修改成功",
                    "修改id:" + student.getStudentId() + ",名字:" + student.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "修改学生",
                    "修改失败",
                    "修改id:" + student.getStudentId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    private StudentVo convertToVO(Student student) {
        StudentVo studentVO = new StudentVo();
        studentVO.setPassword(student.getPassword());
        studentVO.setImage(student.getImage());
        studentVO.setGrade(student.getGrade());
        studentVO.setTeacherId(student.getTeacherId());
        studentVO.setParentId(student.getParentId());
        studentVO.setDeviceId(student.getDeviceId());
        studentVO.setStudentId(student.getStudentId());
        studentVO.setClazz(student.getClazz());
        studentVO.setName(student.getName());
        studentVO.setPassword(student.getPassword());
        studentVO.setParentName(student.getParentName());
        studentVO.setTeacherName(student.getTeacherName());
        studentVO.setSex(student.getSex());
        studentVO.setPhone(student.getPhone());
        studentVO.setBirth(student.getBirth());
        studentVO.setStatus(student.getStatus());
        return studentVO;
    }
    @GetMapping("/getStudentTotal")
    public Result getStudentToTal() {
        Long size = studentService.getStudentTotal();
        return Result.ok(size);
    }

}
