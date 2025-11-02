package com.smart.www.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName drugs_hospitals_relation
 */
@TableName(value = "drugs_relation")
@Data
public class DrugsHospitalsRelation implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 关系类型
     */
    @TableField(value = "relation_type")
    private Integer relationType;
    /**
     * 关联id
     */
    @TableField(value = "type_id")
    private Integer typeId;
    /**
     * 关联名字
     */
    @TableField(value = "type_name")
    private String typeName;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}