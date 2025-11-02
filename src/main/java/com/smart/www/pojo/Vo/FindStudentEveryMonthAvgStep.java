package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindStudentEveryMonthAvgStep implements Serializable {
    private String month;
    private String avgStep;
}
