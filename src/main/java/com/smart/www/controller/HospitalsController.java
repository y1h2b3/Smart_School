package com.smart.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.HospitalsMapper;
import com.smart.www.pojo.Hospitals;
import com.smart.www.pojo.Vo.HospitalsVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.HospitalsService;
import com.smart.www.service.LogsDataService;
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

@RestController
@Tag(name = "医院管理")
public class HospitalsController {

    @Autowired
    private HospitalsService hospitalsService;
    @Autowired
    private HospitalsMapper hospitalsMapper;
    @Autowired
    private LogsDataService logsDataService;

    /**
     * 查询所有医院
     *
     * @return
     */
    @GetMapping("/hospitals")
    @Operation(summary = "查询所有医院")
    public Result<PageDTO<HospitalsVo>> findAllHospitals(PageQuery pageQuery) {
        try {
            Page<Hospitals> page1 = hospitalsService.findAllHospitals(pageQuery);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据条件搜索
     *
     * @param key value
     * @return
     */
    @GetMapping(value = "/searchHospitals")
    @Operation(summary = "根据医院条件查询医院")
    public Result<PageDTO<HospitalsVo>> searchHospitals(PageQuery pageQuery, String key, String value) {
        try {
            Page<Hospitals> pageResult = hospitalsService.searchHospitals(pageQuery, key, value);
            return getPageDTOResult(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据医院id删除医院
     *
     * @param hid
     * @return
     */
    @DeleteMapping(value = "/hospitals")
    @Operation(summary = "根据医院id删除医院")
    public Result removeHospitalsByHid(String hid, HttpServletRequest request) {
        LambdaQueryWrapper<Hospitals> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Hospitals::getHospitalId, hid);
        Hospitals hospitals = hospitalsMapper.selectOne(wrapper);
        boolean b = hospitalsService.remove(wrapper);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除医院",
                    "删除成功",
                    "删除id:" + hospitals.getHospitalId() + ",名字:" + hospitals.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除医院",
                    "删除失败",
                    "删除id:" + hospitals.getHospitalId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 更新医院信息
     *
     * @param hospitals
     * @return
     */
    @PutMapping("/hospitals")
    @Operation(summary = "更新医院信息")
    public Result updateHospitals(@RequestBody Hospitals hospitals, HttpServletRequest request) {
        boolean b = hospitalsService.updateHospitals(hospitals);
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新医院",
                    "更新成功",
                    "更新id:" + hospitals.getHospitalId() + ",名字:" + hospitals.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新医院",
                    "更新失败",
                    "更新id:" + hospitals.getHospitalId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加医院
     *
     * @param hospitals
     * @return
     */
    @PostMapping("/hospitals")
    @Operation(summary = "添加医院")
    public Result addHospitals(@RequestBody Hospitals hospitals, HttpServletRequest request) {
        hospitals.setCreateTime(new Date());
        hospitals.setUpdateTime(new Date());
        boolean b = hospitalsService.save(hospitals);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加医院",
                    "添加成功",
                    "添加id:" + hospitals.getHospitalId() + ",名字:" + hospitals.getName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加医院",
                    "添加失败",
                    "添加id:" + hospitals.getHospitalId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<HospitalsVo>> getPageDTOResult(Page<Hospitals> pageResult) {
        List<HospitalsVo> hospitalsVos = pageResult.getRecords().stream()
                .map(this::ConvertToVo)
                .toList();
        PageDTO<HospitalsVo> hospitalsVoPage = new PageDTO<>();
        hospitalsVoPage.setRecords(hospitalsVos);
        hospitalsVoPage.setTotal((int) pageResult.getTotal());
        hospitalsVoPage.setPages((int) pageResult.getPages());
        return Result.ok(hospitalsVoPage);
    }

    private HospitalsVo ConvertToVo(Hospitals hospitals) {
        HospitalsVo hospitalsVo = new HospitalsVo();
        hospitalsVo.setHospitalId(hospitals.getHospitalId());
        hospitalsVo.setImage(hospitals.getImage());
        hospitalsVo.setAddress(hospitals.getAddress());
        hospitalsVo.setGrade(hospitals.getGrade());
        hospitalsVo.setNote(hospitals.getNote());
        hospitalsVo.setType(hospitals.getType());
        hospitalsVo.setMedicalInsurance(hospitals.getMedicalInsurance().equals("1") ? "是" : "否");
        hospitalsVo.setName(hospitals.getName());
        hospitalsVo.setPhone(hospitals.getPhone());
        return hospitalsVo;
    }
}
