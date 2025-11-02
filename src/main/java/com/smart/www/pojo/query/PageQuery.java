package com.smart.www.pojo.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分页查询实体")
public class PageQuery {
    @Schema(defaultValue = "当前页码")
    private Integer current = 1;
    @Schema(defaultValue = "每页显示数量")
    private Integer size = 10;
    @Schema(defaultValue = "排序字段")
    private String orders;
    @Schema(defaultValue = "是否降序")
    private Boolean isAsc;
}