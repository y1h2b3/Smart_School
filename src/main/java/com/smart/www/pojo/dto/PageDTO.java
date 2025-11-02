package com.smart.www.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(defaultValue = "分页查询结果")
public class PageDTO<T> {
    @Schema(defaultValue = "总条数")
    private Integer total;
    @Schema(defaultValue = "总页数")
    private Integer pages;
    @Schema(defaultValue = "集合")
    private List<T> records;
}
