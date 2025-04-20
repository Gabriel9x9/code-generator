package com.gabriel.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class DataModel {

    //circulate
    public boolean loop=false;

    //auther
    public String author="Gabriel";

    //out
    public String outputText="sum = ";

}
