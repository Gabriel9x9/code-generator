package com.gabriel.generator.file;

import cn.hutool.core.io.FileUtil;
import com.gabriel.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//
public class DynamicFileGenerator {

    /**
     * 生成文件
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath,String outputPath,Object model) throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir=new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        configuration.setDefaultEncoding("utf-8");

        String templateName=new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        DataModel dataModel = new DataModel();
        dataModel.setAuthor("Gabriel");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果：");

        // 文件不存在则创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        FileWriter out = new FileWriter(outputPath);
        template.process(model,out);

        out.close();
    }



}
