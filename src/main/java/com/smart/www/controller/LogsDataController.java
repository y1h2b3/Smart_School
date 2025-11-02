package com.smart.www.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.LogsData;
import com.smart.www.pojo.Vo.LogsDataVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "日志管理")
@SaCheckLogin(type = StpUtil.TYPE)
public class LogsDataController {

    @Autowired
    private LogsDataService logsDataService;

    /**
     * 查询所有日志
     *
     * @return
     */
    @GetMapping("/logsData")
    @Operation(summary = "查询所有日志")
    public Result<PageDTO<LogsDataVo>> findLogsData(PageQuery pageQuery) {
        try {
            pageQuery.setOrders("create_time");
            Page<LogsData> logsData = logsDataService.findLogsData(pageQuery);
            return getPageDTOResult(logsData);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据关键字查询日志
     *
     * @param
     * @return
     */
    @GetMapping("/searchLogsData")
    @Operation(summary = "根据关键字查询日志")
    public Result<PageDTO<LogsDataVo>> searchLogsData(PageQuery pageQuery,
                                                      String account,
                                                      String startTime,
                                                      String endTime,
                                                      String type,
                                                      String result) {
        try {
            pageQuery.setOrders("create_time");
            Page<LogsData> logsData = logsDataService.searchLogsData(pageQuery, account, startTime, endTime, type, result);
            return getPageDTOResult(logsData);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<LogsDataVo>> getPageDTOResult(Page<LogsData> logsData) {
        List<LogsDataVo> logsDataVos = logsData.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<LogsDataVo> logsDataVoPageDTO = new PageDTO<>();
        logsDataVoPageDTO.setRecords(logsDataVos);
        logsDataVoPageDTO.setPages((int) logsData.getPages());
        logsDataVoPageDTO.setTotal((int) logsData.getTotal());
        return Result.ok(logsDataVoPageDTO);
    }

    private LogsDataVo ConvertToVo(LogsData logsData) {
        LogsDataVo logisticsVo = new LogsDataVo();
        logisticsVo.setDataId(logsData.getDataId());
        logisticsVo.setUserId("admin");
        logisticsVo.setLogsType(logsData.getLogsType());
        logisticsVo.setResult(logsData.getResult());
        logisticsVo.setMsg(logsData.getMsg());
        logisticsVo.setIsSuccess(logsData.getIsSuccess());
        logisticsVo.setIp(logsData.getIp());
        logisticsVo.setCreateTime(logsData.getCreateTime());
        return logisticsVo;
    }
}
