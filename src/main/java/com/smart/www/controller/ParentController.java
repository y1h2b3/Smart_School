package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.ParentMapper;
import com.smart.www.pojo.Parent;
import com.smart.www.pojo.Vo.ParentVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.ParentService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "家长管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class ParentController {
    @Autowired
    private ParentService ParentService;
    @Autowired
    private LogsDataService logsDataService;
    @Autowired
    private ParentMapper ParentMapper;

    /**
     * 查询所有家长
     *
     * @return
     */
    @GetMapping("/parent")
    @Operation(summary = "查询所有家长")
    public Result<PageDTO<ParentVo>> findAllParent(PageQuery pageQuery) {
        try {
            Page<Parent> page1 = ParentService.findAllParent(pageQuery);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/parent2")
    @Operation(summary = "查询不带分页的所有家长")
    public Result<List<ParentVo>> findAllParent2() {
        try {
            List<Parent> parents = ParentService.findAllParent2();
            return Result.ok(parents.stream().map(this::ConvertToVo).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据家长类型查询家长
     *
     * @return
     */
    @GetMapping("/searchParent")
    @Operation(summary = "根据关键字类型查询家长")
    public Result<PageDTO<ParentVo>> searchParentType(PageQuery pageQuery, String clazz, String PName, String SName, String Sid,String phone) {
        try {
            Page<Parent> page1 = ParentService.searchParentType(pageQuery, clazz, PName, SName, Sid, phone);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/searchParentID")
    @Operation(summary = "根据ID查询家长")
    public Result searchParentID(String id) {
        try {
            String name = ParentService.searchParentID(id);
            if (name != null) {
                return Result.ok(name);
            } else {
                // 处理未找到家长的情况
                return Result.ok("暂未找到此人");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<ParentVo>> getPageDTOResult(Page<Parent> page1) {
        List<ParentVo> ParentVos = page1.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<ParentVo> ParentVoPageDTO = new PageDTO<>();
        ParentVoPageDTO.setRecords(ParentVos);
        ParentVoPageDTO.setPages((int) page1.getPages());
        ParentVoPageDTO.setTotal((int) page1.getTotal());
        return Result.ok(ParentVoPageDTO);
    }

    /**
     * 根据id删除家长
     *
     * @param pid
     * @return
     */
    @DeleteMapping("/Parent/{pid}")
    @Operation(summary = "根据id删除家长")
    public Result removeParentByPid(@PathVariable String pid, HttpServletRequest request) {
        Page<Parent> page1 = ParentService.findAllParent(new PageQuery());
        boolean b = ParentService.removeParentByPid(pid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除家长",
                    "删除成功",
                    "删除id:" + page1.getRecords().get(0).getParentId() + ",名字:" + page1.getRecords().get(0).getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除家长",
                    "删除失败",
                    "删除id:" + page1.getRecords().get(0).getParentId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 更新家长信息
     *
     * @param Parent1
     * @return
     */
    @PutMapping("/Parent")
    @Operation(summary = "更新家长信息")
    public Result updateParent(@RequestBody Parent Parent1, HttpServletRequest request) {
        Parent1.setUpdateTime(new Date());
        boolean b = ParentService.update(Parent1, new LambdaQueryWrapper<Parent>().eq(Parent::getParentId, Parent1.getParentId()));
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新家长",
                    "更新成功",
                    "更新id:" + Parent1.getParentId() + ",名字:" + Parent1.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新家长",
                    "更新失败",
                    "更新id:" + Parent1.getParentId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加家长
     *
     * @param Parent
     * @return
     */
    @PostMapping("/Parent")
    @Operation(summary = "添加家长")
    public Result addParent(@RequestBody Parent Parent, HttpServletRequest request) {
        Parent.setType("家长");
        Parent.setCreateTime(new Date());
        Parent.setUpdateTime(new Date());
        boolean b = ParentService.save(Parent);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加家长",
                    "添加成功",
                    "添加id:" + Parent.getParentId() + ",名字:" + Parent.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加家长",
                    "添加失败",
                    "添加id:" + Parent.getParentId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    public ParentVo ConvertToVo(Parent Parent) {
        ParentVo ParentVo = new ParentVo();
        ParentVo.setParentId(Parent.getParentId());
        ParentVo.setImage(Parent.getImage());
        ParentVo.setParentName(Parent.getName());
        ParentVo.setPhone(Parent.getPhone());
        ParentVo.setStudentId(Parent.getStudentId());
        ParentVo.setStudentName(Parent.getStudentName());
        ParentVo.setStudentClazz(Parent.getStudentClazz());
        ParentVo.setPhone(Parent.getPhone());
        ParentVo.setSex(Parent.getSex());
        ParentVo.setPassword(Parent.getPassword());
        ParentVo.setStatus(Parent.getStatus());
        ParentVo.setGrade(Parent.getGrade());
        ParentVo.setClazz(Parent.getClazz());
        return ParentVo;
    }
    @GetMapping("getParentToTal")
    public Result getParentToTal() {
        Long size = ParentService.getParentToTal();
        return Result.ok(size);
    }
}
