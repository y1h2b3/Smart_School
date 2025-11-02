package com.smart.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.Drugs;
import com.smart.www.pojo.Vo.DrugsVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.DrugsService;
import com.smart.www.service.LogsDataService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@MultipartConfig
@RestController
@Tag(name = "药品管理")
@AllArgsConstructor
public class DrugsController {
    private static final String url = "src/main/resources/img/";
    private DrugsService drugsService;
    private LogsDataService logsDataService;

    /**
     * 查询所有药品
     *
     * @return
     */
    @GetMapping("/drugs")
    @Operation(summary = "查询所有药品")
    public Result<PageDTO<DrugsVo>> findAllDrugs(PageQuery pageQuery) {
        try {
            Page<Drugs> page1 = drugsService.findAllDrugs(pageQuery);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据药品名称查询药品
     *
     * @param
     * @return
     */
    @GetMapping(value = "/searchDrugs")
    @Operation(summary = "根据药品名称查询药品")
    public Result<PageDTO<DrugsVo>> searchDrugs(PageQuery pageQuery,
                                                String id, String name, String type, String startTime, String endTime) {
        try {
            Page<Drugs> pageResult = drugsService.searchDrugs(pageQuery, id, name, type, startTime, endTime);
            return getPageDTOResult(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }
    @GetMapping(value = "/searchIdDrugs")
    @Operation(summary = "根据药品id查询药品")
    public Result searchIdDrugs(String Did) {
        try {
            List<Drugs> drugs = drugsService.searchIdDrugs(Did);
            HashMap map  = new HashMap();
            map.put("name",drugs.get(0).getName());
            return Result.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }
    @GetMapping(value = "/getTypeID")
    @Operation(summary = "根据药品名字查询药品类型id")
    public Result getTypeID(String name) {
        try {
            List<Drugs> drugs = drugsService.getTypeID(name);
            HashMap map  = new HashMap();
            map.put("typeId",drugs.get(0).getTypeId());
            return Result.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<DrugsVo>> getPageDTOResult(Page<Drugs> page1) {
        List<DrugsVo> drugsVos = page1.getRecords().stream()
                .map(this::ConvertToVo)
                .collect(Collectors.toList());
        PageDTO<DrugsVo> drugsVoPageDTO = new PageDTO<>();
        drugsVoPageDTO.setRecords(drugsVos);
        drugsVoPageDTO.setTotal((int) page1.getTotal());
        drugsVoPageDTO.setPages((int) page1.getPages());
        return Result.ok(drugsVoPageDTO);
    }


    /**
     * 根据药品id删除药品
     *
     * @param did
     * @return
     */
    @DeleteMapping(value = "/drugs/{did}")
    @Operation(summary = "根据药品id删除药品")
    public Result removeDrugsByDid(@PathVariable String did, HttpServletRequest request) {
        PageQuery pageQuery = new PageQuery();
        Page<Drugs> byId = drugsService.searchDrugs(pageQuery, did, null, null, null, null);
        try {
            boolean b = drugsService.removeDrugsByDid(did);
            if (b) {
                logsDataService.addLogsData("admin",
                        "删除药品",
                        "删除成功",
                        "删除id:" + byId.getRecords().get(0).getDrugId() + ",名字:" + byId.getRecords().get(0).getDrugId(),
                        1,
                        request.getRemoteAddr());
                return Result.ok(null);
            } else {
                logsDataService.addLogsData("admin",
                        "删除药品",
                        "删除失败",
                        "删除id:" + did + "不存在",
                        0,
                        request.getRemoteAddr());
                return Result.build(null, ResultCodeEnum.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }


    /**
     * 更新药品信息
     *
     * @param drugs
     * @return
     */
    @PutMapping("/drugs")
    @Operation(summary = "更新药品信息")
    public Result updateDrugs(@RequestBody Drugs drugs, HttpServletRequest request) {
        try {
            drugs.setUpdateTime(new Date());
            boolean b = drugsService.updateBydrugId(drugs);
            if (b) {
                logsDataService.addLogsData("admin",
                        "修改药品",
                        "修改成功",
                        "修改id:" + drugs.getDrugId() + ",名字:" + drugs.getName(),
                        1,
                        request.getRemoteAddr());
                return Result.ok(null);
            } else {
                logsDataService.addLogsData("admin",
                        "修改药品",
                        "修改失败",
                        "修改id:" + drugs.getDrugId() + "不存在",
                        0,
                        request.getRemoteAddr());
                return Result.build(null, ResultCodeEnum.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PostMapping("/drugs")
    @Operation(summary = "添加药品")
    public Result saveDrugs(@RequestBody Drugs drugs, HttpServletRequest request) {
        drugs.setCreateTime(new Date());
        drugs.setUpdateTime(new Date());
        boolean b = drugsService.saveDrugs(drugs);
        try {
            if (b) {
                logsDataService.addLogsData("admin",
                        "添加药品",
                        "添加成功",
                        "添加id:" + drugs.getDrugId() + ",名字:" + drugs.getName(),
                        1,
                        request.getRemoteAddr());
                return Result.ok(null);
            } else {
                logsDataService.addLogsData("admin",
                        "添加药品",
                        "添加失败",
                        "添加id:" + drugs.getDrugId() + "已存在",
                        0,
                        request.getRemoteAddr());
                return Result.build(null, ResultCodeEnum.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @PostMapping("/drugs/image")
    @Operation(summary = "上传药品图片")
    public Result saveImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.build(null, ResultCodeEnum.ERROR);
        }
        try {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 文件保存路径
            String filePath = "C:\\Users\\Administrator\\Desktop\\SmartSchool\\src\\main\\resources\\img\\";
            // 文件重命名，防止重复
            UUID uuid = UUID.randomUUID();
            fileName = uuid + suffixName;
            // 文件对象
            File dest = new File(filePath + fileName);
            // 创建路径
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return Result.ok(uuid.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.build(null, ResultCodeEnum.ERROR);
    }

    private DrugsVo ConvertToVo(Drugs drugs) {
        DrugsVo drugsVo = new DrugsVo();
        drugsVo.setDrugId(drugs.getDrugId());
        drugsVo.setImg(url + drugs.getImg() + ".jpg");
        drugsVo.setName(drugs.getName());
        drugsVo.setPrice(drugs.getPrice());
        drugsVo.setQuantity(drugs.getQuantity());
        drugsVo.setSpecifications(drugs.getSpecifications());
        drugsVo.setType(drugs.getType());
        drugsVo.setTypeId(drugs.getTypeId());
        drugsVo.setUsage1(drugs.getUsage1());
        drugsVo.setDosage(drugs.getDosage());
        drugsVo.setManufacturer(drugs.getManufacturer());
        drugsVo.setExpirationDate(drugs.getExpirationDate());
        drugsVo.setNotes(drugs.getNotes());
        drugsVo.setSymptoms(drugs.getSymptoms());
        drugsVo.setCreateTime(drugs.getCreateTime());
        drugsVo.setUpdateTime(drugs.getUpdateTime());
        return drugsVo;
    }
}
