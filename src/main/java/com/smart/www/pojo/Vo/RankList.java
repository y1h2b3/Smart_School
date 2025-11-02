package com.smart.www.pojo.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RankList implements Serializable {
    private String type;
    private int BIM;
    private int HEART;
    private int SLEEP;
    private int SPO2;
}
