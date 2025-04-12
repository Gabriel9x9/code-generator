package com.gabriel.generator;

import com.gabriel.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     */
    public static void doGenerator(Object model) throws TemplateException, IOException {
        String projectPath=System.getProperty("user.dir");
        // root
        File parentFile = new File(projectPath).getParentFile();

        // input and output
        String inputPath = new File(parentFile, "demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        System.out.println(inputPath);
        System.out.println(outputPath);

        // create files
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);



        String inputDynamicFilePath=projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath=outputPath+File.separator+"acm-template/src/com/gabriel/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath,outputDynamicFilePath,model);

    }

    public static void main(String[] args) throws TemplateException, IOException {

        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Gabriel");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");

        doGenerator(mainTemplateConfig);
    }
}
