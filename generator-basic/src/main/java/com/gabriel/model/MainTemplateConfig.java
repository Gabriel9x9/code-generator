package com.gabriel.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class MainTemplateConfig {

    //circulate
    private boolean loop=false;

    //auther
    private String author="Gabriel";

    //out
    private String outputText="sum = ";

}
