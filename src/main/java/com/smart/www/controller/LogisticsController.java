package com.smart.www.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.Logistics;
import com.smart.www.pojo.Vo.LogisticsVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogisticsService;
import com.smart.www.service.LogsDataService;
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
@Tag(name = "后勤管理")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @Autowired
    private LogsDataService logsDataService;

    /**
     * 查询所有后勤
     *
     * @return
     */
    @GetMapping("/logistics")
    @Operation(summary = "查询所有后勤")
    public Result<PageDTO<LogisticsVo>> findAllLogistics(PageQuery pageQuery) {
        try {
            Page<Logistics> teacherVOs = logisticsService.findAllLogistics(pageQuery);
            return getPageDTOResult(teacherVOs);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/logistics2")
    @Operation(summary = "查询不带分页的所有后勤")
    public Result<List<LogisticsVo>> findAllLogistics2() {
        try {
            List<Logistics> logistics = logisticsService.findAllLogistics2();
            return Result.ok(logistics.stream().map(this::ConvertToVo).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据岗位类型查询后勤
     *
     * @param
     * @param
     * @return
     */
    @GetMapping(value = "/searchLogistics")
    @Operation(summary = "根据关键字查询后勤")
    public Result<PageDTO<LogisticsVo>> searchLogisticsType(PageQuery pageQuery, String post, String id, String name,String phone) {
        try {
            Page<Logistics> teacherVOs = logisticsService.searchLogisticsType(pageQuery, post, id, name,phone);
            return getPageDTOResult(teacherVOs);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private Result<PageDTO<LogisticsVo>> getPageDTOResult(Page<Logistics> Logistics) {
        List<LogisticsVo> logisticsVos = Logistics.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<LogisticsVo> logisticsVoPageDTO = new PageDTO<>();
        logisticsVoPageDTO.setRecords(logisticsVos);
        logisticsVoPageDTO.setTotal((int) Logistics.getTotal());
        logisticsVoPageDTO.setPages((int) Logistics.getPages());
        return Result.ok(logisticsVoPageDTO);
    }

    /**
     * 根据id删除后勤
     *
     * @param lid
     * @return
     */
    @DeleteMapping(value = "/logistics/{lid}")
    @Operation(summary = "根据id删除后勤")
    public Result removeLogisticsByLid(@PathVariable String lid, HttpServletRequest request) {
        PageQuery pageQuery = new PageQuery();
        Page<Logistics> logisticsId = logisticsService.searchLogisticsType(pageQuery, null, lid, null, null);
        boolean b = logisticsService.removeLogisticsByLid(lid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除后勤",
                    "删除成功",
                    "删除id:" + logisticsId.getRecords().get(0).getLogisticsId() + ",名字:" + logisticsId.getRecords().get(0).getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除后勤",
                    "删除失败",
                    "删除id:" + lid + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 更新后勤信息
     *
     * @param logistics
     * @return
     */
    @PutMapping("/logistics")
    @Operation(summary = "更新后勤信息")
    public Result updateLogistics(@RequestBody Logistics logistics, HttpServletRequest request) {
        logistics.setUpdateTime(new Date());
        boolean b = logisticsService.updateLogistics(logistics);
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新后勤",
                    "更新成功",
                    "更新id:" + logistics.getLogisticsId() + ",名字:" + logistics.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新后勤",
                    "更新失败",
                    "更新id:" + logistics.getLogisticsId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加后勤信息
     *
     * @param logistics
     * @return
     */
    @PostMapping("/logistics")
    @Operation(summary = "添加后勤信息")
    public Result addLogistics(@RequestBody Logistics logistics, HttpServletRequest request) {
        logistics.setCreateTime(new Date());
        logistics.setUpdateTime(new Date());
        logistics.setStatus(1);
        logistics.setType("后勤");
        boolean b = logisticsService.save(logistics);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加后勤",
                    "添加失败",
                    "添加id:" + logistics.getLogisticsId() + ",名字:" + logistics.getName(),
                    0,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加后勤",
                    "添加失败",
                    "添加id:" + logistics.getLogisticsId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private LogisticsVo ConvertToVo(Logistics logistics) {
        LogisticsVo logisticsVo = new LogisticsVo();
        logisticsVo.setImage(logistics.getImage());
        logisticsVo.setBirth(logistics.getBirth());
        logisticsVo.setLogisticsId(logistics.getLogisticsId());
        logisticsVo.setDeviceId(logistics.getDeviceId());
        logisticsVo.setName(logistics.getName());
        logisticsVo.setSex(logistics.getSex());
        logisticsVo.setPost(logistics.getPost());
        logisticsVo.setPhone(logistics.getPhone());
        logisticsVo.setStatus(logistics.getStatus());
        logisticsVo.setPassword(logistics.getPassword());
        return logisticsVo;
    }

    @GetMapping("/getLogisticsToTal")
    public Result getLogisticsToTal() {
        Long size = logisticsService.getLogisticsToTal();
        return Result.ok(size);
    }
}
