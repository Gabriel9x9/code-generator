package com.gabriel.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.gabriel.generator.JarGenerator;
import com.gabriel.generator.file.DynamicFileGenerator;
import com.gabriel.meta.Meta;
import com.gabriel.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);

        // output path
        String projectPath = System.getProperty("user.dir");
        String outputPath=projectPath+ File.separator+"generated"+File.separator+meta.getName();
        System.out.println(outputPath);

        if(!FileUtil.exist(outputPath)){
            FileUtil.mkdir(outputPath);
        }

        // 复制原始模板文件
        String sourceRootPath = meta.getFileConfig().getSourceRootPath();
        String sourceCopyDestPath = outputPath + File.separator + ".source";
        FileUtil.copy(sourceRootPath,sourceCopyDestPath,false);

        // read resource
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();

        // Java basic path
        String outputBasePackage = meta.getBasePackage();
//        String outputBasePackagePath= StrUtil.join("/",StrUtil.split(outputBasePackage,"."));
        String outputBasePackagePath= StrUtil.join(File.separator,StrUtil.split(outputBasePackage,"."));
        String outputBaseJavaPackagePath=outputPath+File.separator+"src/main/java/"+outputBasePackagePath;



        String inputFilePath;
        String outputFilePath;


// 1) 先把 Model 类生成出来
        inputFilePath  = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + File.separator + "model/DataModel.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        // generator.DynamicGenerator
        inputFilePath=inputResourcePath+File.separator+"templates/java/generator/DynamicGenerator.java.ftl";
        outputFilePath=outputBaseJavaPackagePath+"/generator/DynamicGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // generator.MainGenerator
        inputFilePath=inputResourcePath+File.separator+"templates/java/generator/MainGenerator.java.ftl";
        outputFilePath=outputBaseJavaPackagePath+"/generator/MainGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // generator.StaticGenerator
        inputFilePath=inputResourcePath+File.separator+"templates/java/generator/StaticGenerator.java.ftl";
        outputFilePath=outputBaseJavaPackagePath+"/generator/StaticGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // pom.xml
        inputFilePath=inputResourcePath+File.separator+"templates/pom.xml.ftl";
        outputFilePath=outputPath+File.separator+"pom.xml";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        File pom = new File(outputPath, "pom.xml");
        System.out.println(">>> pom.xml 存在吗？ " + pom.exists() + "，路径：" + pom.getAbsolutePath());

        // jar
        JarGenerator.doGenerate(outputPath);

        // 得到jar包，用ScriptGenerator工具类封装脚本。

    }
}
