package com.smart.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.www.pojo.DrugsHospitalsRelation;
import com.smart.www.pojo.Vo.DrugsHospitalsRelationVo;
import com.smart.www.service.DrugsHospitalsRelationService;
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

@RestController
@Tag(name = "药品医院关系管理")
public class DrugsHospitalsRelationController {
    @Autowired
    private DrugsHospitalsRelationService drugsHospitalsRelationService;
    @Autowired
    private LogsDataService logsDataService;

    @GetMapping("/DrugsRelation")
    @Operation(summary = "查询药品id关系")
    public Result<List<DrugsHospitalsRelationVo>> findDrugsRelation() {
        try {
            List<DrugsHospitalsRelation> DrugsRelation = drugsHospitalsRelationService.findDrugsRelation();
            List<DrugsHospitalsRelationVo> drugsHospitalsRelationVos = DrugsRelation.stream()
                    .map(this::ConvertToVo)
                    .toList();
            return Result.ok(drugsHospitalsRelationVos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/HospitalsGradeRelation")
    @Operation(summary = "查询医院等级id关系")
    public Result<List<DrugsHospitalsRelationVo>> findHospitalsGradeRelation() {
        try {
            List<DrugsHospitalsRelation> DrugsRelation = drugsHospitalsRelationService.findHospitalsGradeRelation();
            List<DrugsHospitalsRelationVo> drugsHospitalsRelationVos = DrugsRelation.stream()
                    .map(this::ConvertToVo)
                    .toList();
            return Result.ok(drugsHospitalsRelationVos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/HospitalsTypeRelation")
    @Operation(summary = "查询医院类型id关系")
    public Result<List<DrugsHospitalsRelationVo>> findHospitalsTypeRelation() {
        try {
            List<DrugsHospitalsRelation> DrugsRelation = drugsHospitalsRelationService.findHospitalsTypeRelation();
            List<DrugsHospitalsRelationVo> drugsHospitalsRelationVos = DrugsRelation.stream()
                    .map(this::ConvertToVo)
                    .toList();
            return Result.ok(drugsHospitalsRelationVos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PutMapping("/DrugsRelation")
    @Operation(summary = "修改药品关系id")
    public Result updateDrugsRelation(@RequestBody DrugsHospitalsRelation drugsHospitalsRelation, HttpServletRequest request) {
        drugsHospitalsRelation.setUpdateTime(new Date());
        boolean b = drugsHospitalsRelationService.updateHospitalsDrugsRelation(drugsHospitalsRelation, 1);
        if (b) {
            logsDataService.addLogsData("admin",
                    "修改药品关系",
                    "修改成功",
                    "修改id:" + drugsHospitalsRelation.getTypeId() + ",名字:" + drugsHospitalsRelation.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "修改药品关系",
                    "修改失败",
                    "修改id:" + drugsHospitalsRelation.getTypeId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PutMapping("/HospitalsGradeRelation")
    @Operation(summary = "修改医院等级关系id")
    public Result updateHospitalsGradeRelation(@RequestBody DrugsHospitalsRelation drugsHospitalsRelation, HttpServletRequest request) {
        boolean b = drugsHospitalsRelationService.updateHospitalsDrugsRelation(drugsHospitalsRelation, 2);
        if (b) {
            logsDataService.addLogsData("admin",
                    "修改医院等级关系",
                    "修改成功",
                    "修改id:" + drugsHospitalsRelation.getTypeId() + ",名字:" + drugsHospitalsRelation.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "修改医院等级关系",
                    "修改失败",
                    "修改id:" + drugsHospitalsRelation.getTypeId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PutMapping("/HospitalsTypeRelation")
    @Operation(summary = "修改医院类型关系id")
    public Result updateHospitalsTypeRelation(@RequestBody DrugsHospitalsRelation drugsHospitalsRelation, HttpServletRequest request) {
        boolean b = drugsHospitalsRelationService.updateHospitalsDrugsRelation(drugsHospitalsRelation, 3);
        if (b) {
            logsDataService.addLogsData("admin",
                    "修改医院类型关系",
                    "修改成功",
                    "修改id:" + drugsHospitalsRelation.getTypeId() + ",名字:" + drugsHospitalsRelation.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "修改医院类型关系",
                    "修改失败",
                    "修改id:" + drugsHospitalsRelation.getTypeId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @DeleteMapping("/DrugsRelation/{typeId}")
    @Operation(summary = "删除药品关系id")
    public Result removeDrugsRelation(@PathVariable Integer typeId, HttpServletRequest request) {
        DrugsHospitalsRelation byId = getDrugsHospitalsRelation(typeId, 1);
        boolean b = drugsHospitalsRelationService.removeHospitalsDrugsById(typeId, 1);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除药品关系",
                    "删除成功",
                    "删除id:" + byId.getTypeId() + ",名字:" + byId.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除药品关系",
                    "删除失败",
                    "删除id:" + typeId + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @DeleteMapping("/HospitalsGradeRelation/{typeId}")
    @Operation(summary = "删除医院等级关系id")
    public Result removeHospitalsGradeRelation(@PathVariable Integer typeId, HttpServletRequest request) {
        DrugsHospitalsRelation byId = getDrugsHospitalsRelation(typeId, 2);
        boolean b = drugsHospitalsRelationService.removeHospitalsDrugsById(typeId, 2);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除医院等级关系",
                    "删除成功",
                    "删除id:" + byId.getTypeId() + ",名字:" + byId.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        }
        return Result.build(null, ResultCodeEnum.ERROR);
    }

    @DeleteMapping("/HospitalsTypeRelation/{typeId}")
    @Operation(summary = "删除医院类型关系id")
    public Result removeHospitalsTypeRelation(@PathVariable Integer typeId, HttpServletRequest request) {
        DrugsHospitalsRelation byId = getDrugsHospitalsRelation(typeId, 3);
        boolean b = drugsHospitalsRelationService.removeHospitalsDrugsById(typeId, 3);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除医院类型关系",
                    "删除成功",
                    "删除id:" + byId.getTypeId() + ",名字:" + byId.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除医院类型关系",
                    "删除失败",
                    "删除id:" + typeId + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PostMapping("/DrugsRelation")
    @Operation(summary = "添加药品关系id")
    public Result saveDrugsRelationRelation(@RequestBody DrugsHospitalsRelation drugsHospitalsRelation, HttpServletRequest request) {
        drugsHospitalsRelation.setCreateTime(new Date());
        drugsHospitalsRelation.setUpdateTime(new Date());
        boolean b = drugsHospitalsRelationService.saveDrugsHospitalsRelation(drugsHospitalsRelation, 1);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加药品关系",
                    "添加成功",
                    "添加id:" + drugsHospitalsRelation.getTypeId() + ",名字:" + drugsHospitalsRelation.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加药品关系",
                    "添加失败",
                    "添加id:" + drugsHospitalsRelation.getTypeId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PostMapping("/HospitalsGradeRelation")
    @Operation(summary = "添加医院等级关系id")
    public Result saveHospitalsGradeRelation(@RequestBody DrugsHospitalsRelation drugsHospitalsRelation, HttpServletRequest request) {
        boolean b = drugsHospitalsRelationService.saveDrugsHospitalsRelation(drugsHospitalsRelation, 2);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加医院等级关系",
                    "添加成功",
                    "添加id:" + drugsHospitalsRelation.getTypeId() + ",名字:" + drugsHospitalsRelation.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加医院等级关系",
                    "添加失败",
                    "添加id:" + drugsHospitalsRelation.getTypeId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PostMapping("/HospitalsTypeRelation")
    @Operation(summary = "添加医院类型关系id")
    public Result saveHospitalsTypeRelation(@RequestBody DrugsHospitalsRelation drugsHospitalsRelation, HttpServletRequest request) {
        boolean b = drugsHospitalsRelationService.saveDrugsHospitalsRelation(drugsHospitalsRelation, 3);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加医院类型关系",
                    "添加成功",
                    "添加id:" + drugsHospitalsRelation.getTypeId() + ",名字:" + drugsHospitalsRelation.getTypeName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加医院类型关系",
                    "添加失败",
                    "添加id:" + drugsHospitalsRelation.getTypeId() + "已存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/DrugsRelationName")
    @Operation(summary = "根据药品名字模糊查询")
    public Result<List<DrugsHospitalsRelationVo>> DrugsRelationName(String value) {
        try {
            List<DrugsHospitalsRelation> DrugsRelation = drugsHospitalsRelationService.findDrugsRelationByValue(value, 1);
            List<DrugsHospitalsRelationVo> drugsHospitalsRelationVos = DrugsRelation.stream()
                    .map(this::ConvertToVo)
                    .toList();
            return Result.ok(drugsHospitalsRelationVos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/HospitalsGradeRelation/{value}")
    @Operation(summary = "根据医院等级名字模糊查询")
    public Result<List<DrugsHospitalsRelationVo>> findHospitalsGradeRelationByValue(@PathVariable String value) {
        try {
            List<DrugsHospitalsRelation> DrugsRelation = drugsHospitalsRelationService.findDrugsRelationByValue(value, 2);
            List<DrugsHospitalsRelationVo> drugsHospitalsRelationVos = DrugsRelation.stream()
                    .map(this::ConvertToVo)
                    .toList();
            return Result.ok(drugsHospitalsRelationVos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/HospitalsTypeRelation/{value}")
    @Operation(summary = "根据医院类型名字模糊查询")
    public Result<List<DrugsHospitalsRelationVo>> findHospitalsTypeRelationByValue(@PathVariable String value) {
        try {
            List<DrugsHospitalsRelation> DrugsRelation = drugsHospitalsRelationService.findDrugsRelationByValue(value, 3);
            List<DrugsHospitalsRelationVo> drugsHospitalsRelationVos = DrugsRelation.stream()
                    .map(this::ConvertToVo)
                    .toList();
            return Result.ok(drugsHospitalsRelationVos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    private DrugsHospitalsRelation getDrugsHospitalsRelation(Integer typeId, Integer relationType) {
        QueryWrapper<DrugsHospitalsRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id", typeId).eq("relation_type", relationType);
        DrugsHospitalsRelation byId = drugsHospitalsRelationService.getOne(queryWrapper);
        return byId;
    }


    private DrugsHospitalsRelationVo ConvertToVo(DrugsHospitalsRelation drugsHospitalsRelation) {
        DrugsHospitalsRelationVo drugsHospitalsRelationVo = new DrugsHospitalsRelationVo();
        drugsHospitalsRelationVo.setTypeName(drugsHospitalsRelation.getTypeName());
        drugsHospitalsRelationVo.setTypeId(drugsHospitalsRelation.getTypeId());
        return drugsHospitalsRelationVo;
    }

}
