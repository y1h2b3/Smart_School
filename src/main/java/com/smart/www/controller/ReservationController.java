package com.smart.www.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.ReservationMapper;
import com.smart.www.pojo.Reservation;
import com.smart.www.pojo.Vo.ReservationVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.ReservationService;
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
@Tag(name = "预约管理")
public class ReservationController {
    @Autowired
    private ReservationService ReservationService;
    @Autowired
    private ReservationMapper ReservationMapper;
    @Autowired
    private LogsDataService logsDataService;

    /**
     * 查询所有预约
     *
     * @return
     */
    @GetMapping("/Reservation")
    @Operation(summary = "查询所有预约")
    public Result<PageDTO<ReservationVo>> findAllReservation(PageQuery pageQuery) {
        try {
            Page<Reservation> page1 = ReservationService.findAllReservation(pageQuery);
            List<ReservationVo> ReservationVos = page1.getRecords().stream().map(this::convertToVO).collect(Collectors.toList());
            PageDTO<ReservationVo> ReservationVoPageDTO = new PageDTO<>();
            ReservationVoPageDTO.setRecords(ReservationVos);
            ReservationVoPageDTO.setPages((int) page1.getPages());
            ReservationVoPageDTO.setTotal((int) page1.getTotal());
            return Result.ok(ReservationVoPageDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据预约类型查询预约
     *
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/searchReservation")
    @Operation(summary = "根据预约类型查询预约")
    public Result<PageDTO<ReservationVo>> searchReservationType(PageQuery pageQuery, String key, String value) {
        try {
            Page<Reservation> ReservationPage = ReservationService.searchReservationType(pageQuery, key, value);
            List<ReservationVo> ReservationVos = ReservationPage.getRecords().stream().map(this::convertToVO).toList();
            PageDTO<ReservationVo> ReservationVoPageDTO = new PageDTO<>();
            ReservationVoPageDTO.setRecords(ReservationVos);
            ReservationVoPageDTO.setPages((int) ReservationPage.getPages());
            ReservationVoPageDTO.setTotal((int) ReservationPage.getTotal());
            return Result.ok(ReservationVoPageDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据id删除预约
     *
     * @param rid
     * @return
     */
    @DeleteMapping("/Reservation/{rid}")
    @Operation(summary = "根据id删除预约")
    public Result removeReservationByRid(@PathVariable String rid, HttpServletRequest request) {
        Page<Reservation> page1 = ReservationService.findAllReservation(new PageQuery());
        boolean b = ReservationService.removeReservationByRid(rid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除预约",
                    "删除成功",
                    "删除id:" + page1.getRecords().get(0).getReservationId() + ",预约人名字:" + page1.getRecords().get(0).getUserName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除预约",
                    "删除失败",
                    "删除id:" + page1.getRecords().get(0).getReservationId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }

    }

    /**
     * 更新预约信息
     *
     * @param Reservation1
     * @return
     */
    @PutMapping("/Reservation")
    @Operation(summary = "更新预约信息")
    public Result updateReservation(@RequestBody Reservation Reservation1, HttpServletRequest request) {
        boolean b = ReservationService.updateReservation(Reservation1);
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新预约",
                    "更新成功",
                    "更新id:" + Reservation1.getReservationId() + ",预约人名字:" + Reservation1.getUserName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新预约",
                    "更新失败",
                    "更新id:" + Reservation1.getReservationId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加预约
     *
     * @param Reservation
     * @return
     */
    @PostMapping("/Reservation")
    @Operation(summary = "添加预约")
    public Result addReservation(@RequestBody Reservation Reservation, HttpServletRequest request) {
        Reservation.setCreateTime(new Date());
        Reservation.setUpdateTime(new Date());
        boolean b = ReservationService.save(Reservation);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加预约",
                    "添加成功",
                    "添加id:" + Reservation.getReservationId() + ",预约人名字:" + Reservation.getUserName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加预约",
                    "添加失败",
                    "添加id:" + Reservation.getReservationId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private ReservationVo convertToVO(Reservation Reservation) {
        ReservationVo ReservationVo = new ReservationVo();
        ReservationVo.setReservationId(Reservation.getReservationId());
        ReservationVo.setTime(Reservation.getTime());
        ReservationVo.setLocation(Reservation.getLocation());
        ReservationVo.setUserId(Reservation.getUserId());
        ReservationVo.setUserName(Reservation.getUserName());
        ReservationVo.setStaffId(Reservation.getStaffId());
        ReservationVo.setStaffName(Reservation.getStaffName());
        return ReservationVo;
    }

}
