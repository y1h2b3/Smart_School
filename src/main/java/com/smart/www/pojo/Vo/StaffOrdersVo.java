package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StaffOrdersVo implements Serializable {
    /**
     * 预约id
     */
    private String ordersId;
    private String StaffId;
    private String userId;

    /**
     * 预约状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;
    private String userName;
    private String StaffName;
    private String location;

}
