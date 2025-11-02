package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DrugsHospitalsRelationVo implements Serializable {
    /**
     * 关联id
     */
    private Integer typeId;

    /**
     * 关联名字
     */
    private String typeName;
}
