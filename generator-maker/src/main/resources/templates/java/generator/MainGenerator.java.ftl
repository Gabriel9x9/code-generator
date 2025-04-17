package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;
import com.gabriel.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 核心生成器
 */


public class MainGenerator {

    /**
    * 生成
    *
    * @param model 数据模型
    * @throws TemplateException
    * @throws IOException
    */
    public static void doGenerator(Object model) throws TemplateException, IOException {

        String inputRootPath="F:\\Projects\\code-generator\\code-generator\\demo-projects\\acm-template-pro";
        String outputRootPath="F:\\Projects\\code-generator\\code-generator\\acm-template-pro";

        // input and output
        String inputPath ;
        String outputPath ;

        inputPath=new File(inputRootPath,"src/com/gabriel/acm/MainTemplate.java.ftl").getAbsolutePath();


        // create files
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);


        // 一定要先声明 projectPath，否则后面用不了！
        String projectPath = System.getProperty("user.dir");
        String inputDynamicFilePath=projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath=outputPath+File.separator+"acm-template/src/com/gabriel/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath,outputDynamicFilePath,model);

    }


}
