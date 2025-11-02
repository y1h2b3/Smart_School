package com.smart.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.StaffMapper;
import com.smart.www.pojo.Staff;
import com.smart.www.pojo.Vo.StaffVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.StaffService;
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
@Tag(name = "校医管理")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private LogsDataService logsDataService;
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询所有员工
     *
     * @return
     */
    @GetMapping("/staff")
    @Operation(summary = "查询所有校医")
    public Result<PageDTO<StaffVo>> findAllStaff(PageQuery pageQuery) {
        try {
            Page<Staff> page = new Page<>(pageQuery.getCurrent(), pageQuery.getSize());
            Page<Staff> page1 = staffService.page(page, null);
            List<StaffVo> staffVos = page1.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
            PageDTO<StaffVo> staffVoPageDTO = new PageDTO<>();
            staffVoPageDTO.setRecords(staffVos);
            staffVoPageDTO.setPages((int) page.getPages());
            staffVoPageDTO.setTotal((int) page.getTotal());
            return Result.ok(staffVoPageDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据关键字查询员工
     *
     * @return
     */
    @GetMapping("/searchStaff")
    @Operation(summary = "根据关键字查询校医")
    public Result<PageDTO<StaffVo>> searchStaffType(PageQuery pageQuery, String id, String name, String isOnline,String location) {
        Page<Staff> staffPage = staffService.searchStaffType(pageQuery, id, name, isOnline,location);
        List<StaffVo> staffVos = staffPage.getRecords().stream().map(this::ConvertToVo).toList();
        PageDTO<StaffVo> staffVoPageDTO = new PageDTO<>();
        staffVoPageDTO.setRecords(staffVos);
        staffVoPageDTO.setPages((int) staffPage.getPages());
        staffVoPageDTO.setTotal((int) staffPage.getTotal());
        return Result.ok(staffVoPageDTO);
    }

    /**
     * 根据id删除校医
     *
     * @param sid
     * @return
     */
    @DeleteMapping("/staff/{sid}")
    @Operation(summary = "根据id删除校医")
    public Result removeStaffBySid(@PathVariable String sid, HttpServletRequest request) {
        LambdaQueryWrapper<Staff> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Staff::getStaffId, sid);
        Staff staff = staffMapper.selectOne(wrapper);
        boolean remove = staffService.remove(wrapper);
        if (remove) {
            logsDataService.addLogsData("admin",
                    "删除校医",
                    "删除成功",
                    "删除id:" + staff.getStaffId() + ",名字:" + staff.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除校医",
                    "删除失败",
                    "删除id:" + staff.getStaffId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }

    }

    /**
     * 更新校医信息
     *
     * @param staff
     * @return
     */
    @PutMapping("/staff")
    @Operation(summary = "更新校医信息")
    public Result updateStaff(@RequestBody Staff staff, HttpServletRequest request) {
        staff.setUpdateTime(new Date());
        boolean b = staffService.update(staff, new LambdaQueryWrapper<Staff>().eq(Staff::getStaffId, staff.getStaffId()));
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新校医",
                    "更新成功",
                    "更新id:" + staff.getStaffId() + ",名字:" + staff.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新校医",
                    "更新失败",
                    "更新id:" + staff.getStaffId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加员工
     *
     * @param staff
     * @return
     */
    @PostMapping("/staff")
    @Operation(summary = "添加校医")
    public Result addStaff(@RequestBody Staff staff, HttpServletRequest request) {
        staff.setIsActive("在职");
        staff.setCreateTime(new Date());
        staff.setUpdateTime(new Date());
        boolean b = staffService.save(staff);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加校医",
                    "添加成功",
                    "添加id:" + staff.getStaffId() + ",名字:" + staff.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加校医",
                    "添加失败",
                    "添加id:" + staff.getStaffId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    public StaffVo ConvertToVo(Staff staff) {
        StaffVo staffVo = new StaffVo();
        staffVo.setStaffId(staff.getStaffId());
        staffVo.setImage(staff.getImage());
        staffVo.setName(staff.getName());
        staffVo.setPhone(staff.getPhone());
        staffVo.setLocation(staff.getLocation());
        staffVo.setSex(staff.getSex());
        staffVo.setBirth(staff.getBirth());
        staffVo.setIsActive(staff.getIsActive());
        staffVo.setNote(staff.getNote());
        staffVo.setCreateTime(staff.getCreateTime());
        staffVo.setUpdateTime(staff.getUpdateTime());
        return staffVo;
    }
}
