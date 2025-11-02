package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentHealthWarningNotificationsVo implements Serializable {
    /**
     * 通知ID
     */
    private String notificationId;

    /**
     * 用户id
     */
    private String userId;


    /**
     * 学生名字
     */
    private String userName;

    /**
     * 学生班级
     */
    private String userPost;

    /**
     * 性别
     */
    private String sex;

    /**
     * 预警类型
     */
    private String type;

    /**
     * 预警等级
     */
    private String level;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 预警发出的时间
     */
    private Date time;

    /**
     * 测量值
     */
    private String readingValue;

    /**
     * 建议的行动或措施
     */
    private String recommendedAction;

}
