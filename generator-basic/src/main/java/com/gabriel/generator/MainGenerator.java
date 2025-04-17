package com.gabriel.generator;

import com.gabriel.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    /**
     * 生成
     * 接收者
     * @param model 数据模型
     */
    public static void doGenerator(Object model) throws TemplateException, IOException {

        String inputRootPath="F:\\Projects\\code-generator\\code-generator\\demo-projects\\acm-template-pro";
        String outputRootPath="F:\\Projects\\code-generator\\code-generator\\acm-template-pro";

        // input and output
        String inputPath ;
        String outputPath ;

        inputPath=new File(inputRootPath,"src/com/gabriel/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath=new File(outputRootPath,"src/com/gabriel/acm/MainTemplate.java").getAbsolutePath();

        DynamicGenerator.doGenerate(inputPath,outputPath,model);

        inputPath=new File(inputRootPath,".gitignore").getAbsolutePath();
        outputPath=new File(outputRootPath,".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);

        inputPath=new File(inputRootPath,"README.md").getAbsolutePath();
        outputPath=new File(outputRootPath,"README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);
    }

    public static void main(String[] args) throws TemplateException, IOException {

        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Gabriel");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");

        doGenerator(mainTemplateConfig);
    }
}
