package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NotificationsVo implements Serializable {
    /**
     * 消息id
     */
    private Integer notifyId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布者
     */
    private String publisher;

    /**
     * 日志时间
     */
    private Date time;

    /**
     * 通知群体
     */
    private String notifyGroup;
}
