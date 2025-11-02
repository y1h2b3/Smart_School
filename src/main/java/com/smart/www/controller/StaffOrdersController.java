package com.smart.www.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.StaffOrdersMapper;
import com.smart.www.pojo.StaffOrders;
import com.smart.www.pojo.Vo.StaffOrdersVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.StaffOrdersService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@Tag(name = "校医预约管理")
public class StaffOrdersController {
    @Autowired
    private StaffOrdersService staffOrdersService;
    @Autowired
    private LogsDataService logsDataService;
    @Autowired
    private StaffOrdersMapper staffOrdersMapper;

    @GetMapping("/staffOrders")
    @Operation(summary = "查询所有校医预约")
    public Result<PageDTO<StaffOrdersVo>> findAllStaffOrders(PageQuery pageQuery) {
        try {
            Page<StaffOrders> page = staffOrdersService.findAllStaffOrders(pageQuery);
            return getPageDTOResult(page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/searchStaffOrders")
    @Operation(summary = "根据关键字查询校医预约")
    public Result<PageDTO<StaffOrdersVo>> searchStaffOrdersType(PageQuery pageQuery, String id, String name, String type) {
        try {
            Page<StaffOrders> page = staffOrdersService.searchStaffOrdersType(pageQuery, id, name, type);
            return getPageDTOResult(page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }
    @GetMapping("/searchStaffOrdersLocation")
    @Operation(summary = "根据地点查询校医预约")
    public Result searchStaffOrdersLocation(String location) {
        try {
            List<StaffOrders> staffOrders = staffOrdersService.searchStaffOrdersLocation(location);
            HashMap map =  new HashMap();
            map.put("location",staffOrders.get(0).getLocation());
            return Result.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @DeleteMapping("/removeStaffOrders/{sid}")
    @Operation(summary = "根据id删除校医预约")
    public Result removeStaffOrdersBySid(@PathVariable String sid, HttpServletRequest request) {
        try {
            boolean i = staffOrdersService.removeStaffOrdersBySid(sid);
            if (i) {
                logsDataService.addLogsData("admin",
                        "删除预约",
                        "删除成功",
                        "删除id:" + sid + "预约:",
                        1,
                        request.getRemoteAddr());
                return Result.ok(null);
            } else {
                logsDataService.addLogsData("admin",
                        "删除预约",
                        "删除失败",
                        "删除id:" + sid + "不存在",
                        0,
                        request.getRemoteAddr());
                return Result.build(null, ResultCodeEnum.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logsDataService.addLogsData("admin",
                    "删除预约",
                    "删除失败",
                    "删除id:" + sid + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PutMapping("/updateStaffOrders")
    @Operation(summary = "更新校医预约")
    public Result updateStaffOrders(@RequestBody StaffOrders staffOrders, HttpServletRequest request) {
        try {
            staffOrders.setUpdateTime(new Date());
            boolean i = staffOrdersService.updateStaffOrders(staffOrders);
            if (i) {
                logsDataService.addLogsData("admin",
                        "更新预约",
                        "更新成功",
                        "更新id:" + staffOrders.getOrdersId() + ",名字:" + staffOrders.getUserName(),
                        1,
                        request.getRemoteAddr());
                return Result.ok(null);
            }
            logsDataService.addLogsData("admin",
                    "更新预约",
                    "更新失败",
                    "更新id:" + staffOrders.getOrdersId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        } catch (Exception e) {
            logsDataService.addLogsData("admin",
                    "更新预约",
                    "更新失败",
                    "更新id:" + staffOrders.getOrdersId() + "不存在",
                    0,
                    request.getRemoteAddr());
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PostMapping("/saveStaffOrders")
    @Operation(summary = "添加校医预约")
    public Result saveStaffOrders(@RequestBody StaffOrders staffOrders, HttpServletRequest request) {
        try {
            Random r = new Random();
            staffOrders.setCreateTime(new Date());
            staffOrders.setUpdateTime(new Date());
            staffOrders.setOrdersId("O" + (r.nextInt(90000) + 1000));
            staffOrders.setStatus("已预约");
            boolean i = staffOrdersService.save(staffOrders);
            if (i) {
                logsDataService.addLogsData("admin",
                        "添加预约",
                        "添加成功",
                        "添加id:" + staffOrders.getOrdersId() + ",名字:" + staffOrders.getUserName(),
                        1,
                        request.getRemoteAddr());
                return Result.ok(null);
            }
            logsDataService.addLogsData("admin",
                    "添加预约",
                    "添加失败",
                    "添加id:" + staffOrders.getOrdersId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            logsDataService.addLogsData("admin",
                    "添加预约",
                    "添加失败",
                    "未知错误",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private Result<PageDTO<StaffOrdersVo>> getPageDTOResult(Page<StaffOrders> page) {
        List<StaffOrdersVo> staffVos = page.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<StaffOrdersVo> staffVoPageDTO = new PageDTO<>();
        staffVoPageDTO.setRecords(staffVos);
        staffVoPageDTO.setPages((int) page.getPages());
        staffVoPageDTO.setTotal((int) page.getTotal());
        return Result.ok(staffVoPageDTO);
    }


    public StaffOrdersVo ConvertToVo(StaffOrders staffOrders) {
        StaffOrdersVo staffOrdersVo = new StaffOrdersVo();
        staffOrdersVo.setStaffName(staffOrders.getStaffName());
        staffOrdersVo.setUserName(staffOrders.getUserName());
        staffOrdersVo.setCreateTime(staffOrders.getCreateTime());
        staffOrdersVo.setUpdateTime(staffOrders.getUpdateTime());
        staffOrdersVo.setStaffId(staffOrders.getStaffId());
        staffOrdersVo.setUserId(staffOrders.getUserId());
        staffOrdersVo.setLocation(staffOrders.getLocation());
        staffOrdersVo.setOrdersId(staffOrders.getOrdersId());
        staffOrdersVo.setStatus(staffOrders.getStatus());
        return staffOrdersVo;
    }

}
