package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.TeacherMapper;
import com.smart.www.pojo.Teacher;
import com.smart.www.pojo.Vo.TeacherVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.TeacherService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "教师管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private LogsDataService logsDataService;

    @GetMapping("/teacher")
    @Operation(summary = "查询带分页的所有教师")
    public Result<PageDTO<TeacherVo>> findAllTeacher(PageQuery pageQuery) {
        try {
            Page<Teacher> teacherVOs = teacherService.findAllTeacher(pageQuery);
            return getPageDTOResult(teacherVOs);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/teacher2")
    @Operation(summary = "查询不带分页的所有教师")
    public Result<List<TeacherVo>> findAllTeacher2() {
        try {
            List<Teacher> teachers = teacherService.findAllTeacher2();
            return Result.ok(teachers.stream().map(this::ConvertToVo).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    @GetMapping("/searchTeacherType")
    @Operation(summary = "根据关键字查询教师")
    public Result<PageDTO<TeacherVo>> searchTeacherType(PageQuery pageQuery, String post, String id, String name,String phone) {
        try {
            Page<Teacher> teacherVOs = teacherService.searchTeacherType(pageQuery, post, id, name,phone);
            return getPageDTOResult(teacherVOs);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/searchTeacherID")
    @Operation(summary = "根据ID查询教师")
    public Result searchTeacherID(String id) {
        try {
            QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("teacher_id", id);
            Teacher teacher = teacherMapper.selectOne(queryWrapper);
            if (teacher !=null){
                return Result.ok(teacher.getName());
            }
            return Result.ok("暂未找到此人");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private Result<PageDTO<TeacherVo>> getPageDTOResult(Page<Teacher> teacher) {
        List<TeacherVo> teacherVos = teacher.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<TeacherVo> teacherVoPageDTO = new PageDTO<>();
        teacherVoPageDTO.setRecords(teacherVos);
        teacherVoPageDTO.setTotal((int) teacher.getTotal());
        teacherVoPageDTO.setPages((int) teacher.getPages());
        return Result.ok(teacherVoPageDTO);
    }


    @PostMapping("/teacher")
    @Operation(summary = "添加教师")
    public Result addTeacher(@RequestBody Teacher teacher, HttpServletRequest request) {
        teacher.setCreateTime(new Date());
        teacher.setUpdateTime(new Date());
        teacher.setType("老师");
        teacher.setStatus(1);
        boolean b = teacherService.save(teacher);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加老师",
                    "添加成功",
                    "添加id:" + teacher.getTeacherId() + ",名字:" + teacher.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加老师",
                    "添加失败",
                    "添加id:" + teacher.getTeacherId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }

    }

    @DeleteMapping("/teacher/{tid}")
    @Operation(summary = "根据id删除教师")
    public Result removeTeacherByTid(@PathVariable String tid, HttpServletRequest request) {
        PageQuery pageQuery = new PageQuery();
        Page<Teacher> teacherId = teacherService.searchTeacherType(pageQuery, null, tid, null, null);
        boolean b = teacherService.removeTeacherByTid(tid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除老师",
                    "删除成功",
                    "删除id:" + teacherId.getRecords().get(0).getTeacherId() + ",名字:" + teacherId.getRecords().get(0).getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除老师",
                    "删除失败",
                    "删除id:" + tid + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }

    }

    @PutMapping("/teacher")
    @Operation(summary = "更新教师信息")
    public Result updateTeacher(@RequestBody Teacher teacher, HttpServletRequest request) {
        teacher.setUpdateTime(new Date());
        boolean b = teacherService.updateTeacher(teacher);
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新老师",
                    "更新成功",
                    "更新id:" + teacher.getTeacherId() + ",名字:" + teacher.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新老师",
                    "更新失败",
                    "更新id:" + teacher.getTeacherId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private TeacherVo ConvertToVo(Teacher teacher) {
        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setImage(teacher.getImage());
        teacherVo.setTeacherId(teacher.getTeacherId());
        teacherVo.setDeviceId(teacher.getDeviceId());
        teacherVo.setPost(teacher.getPost());
        teacherVo.setName(teacher.getName());
        teacherVo.setPhone(teacher.getPhone());
        teacherVo.setSex(teacher.getSex());
        teacherVo.setClazz(teacher.getClazz());
        teacherVo.setBirth(teacher.getBirth());
        teacherVo.setStatus(teacher.getStatus());
        teacherVo.setPassword(teacher.getPassword());
        return teacherVo;
    }
    @GetMapping("/getTeacherToTal")
    public Result getTeacherToTal() {
        Long size = teacherService.getTeacherToTal();
        return Result.ok(size);
    }
}
