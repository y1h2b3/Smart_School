package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class dateList implements Serializable {
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;
    private String Sunday;
}
