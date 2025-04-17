package com.gabriel.generator.file;

import com.gabriel.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class FileGenerator {

    /**
     * 生成
     * 接收者
     * @param model 数据模型
     */
    public static void doGenerator(Object model) throws TemplateException, IOException {

        String projectPath=System.getProperty("user.dir");
        // root
        File parentFile = new File(projectPath).getParentFile();
        System.out.println("projectPath: "+projectPath);
        System.out.println("parentPath: "+parentFile.getAbsolutePath());

        // input and output
        String inputPath = new File(parentFile, "demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        System.out.println("inputPath: "+inputPath);
        System.out.println("outputPath: "+outputPath);

        // create files
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);



        String inputDynamicFilePath=projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath=outputPath+File.separator+"acm-template/src/com/gabriel/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath,outputDynamicFilePath,model);

    }

    public static void main(String[] args) throws TemplateException, IOException {

        DataModel dataModel =new DataModel();
        dataModel.setAuthor("Gabriel");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果：");

        doGenerator(dataModel);
    }
}
