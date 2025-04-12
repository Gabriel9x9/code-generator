package com.gabriel.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {

    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath,outputPath,false);
    }

    public static void main(String[] args) {
        // 整个项目的根目录
        String projectPath = System.getProperty("user.dir");   // basic
        File parentFile=new File(projectPath).getParentFile(); // root
        System.out.println(projectPath);
        System.out.println(parentFile.getAbsolutePath());
        // 输入路径
        String inputPath=new File(parentFile,"demo-projects/acm-template").getAbsolutePath();
        System.out.println(inputPath);
        // 输出路径
        // String outputPath=projectPath;
        String outputPath=new File(projectPath,"acm-template").getAbsolutePath();
        System.out.println(outputPath);
        // copy
        copyFilesByHutool(inputPath,outputPath);

    }
}
