package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogsDataVo implements Serializable {
    /**
     * 日志id
     */
    private String dataId;

    /**
     * 人员id
     */
    private String userId;

    /**
     * 日志类型
     */
    private String logsType;

    /**
     * 执行结果
     */
    private String result;

    /**
     * 结果说明
     */
    private String msg;

    /**
     * ip地址
     */
    private String ip;

    private int isSuccess;

    /**
     * 操作时间
     */
    private Date createTime;

}
