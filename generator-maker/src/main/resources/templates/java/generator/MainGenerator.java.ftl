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
    public static void doGenerator(DataModel model) throws TemplateException, IOException {

        String inputRootPath="${fileConnfig.inputRootPath}";
        String outputRootPath="${fileConnfig.outputRootPath}";

        // input and output
        String inputPath ;
        String outputPath ;

        <#list modelConfig.model as modelInfo>
            ${modelInfo.type} ${modelInfo.fieldName} = model.${modelInfo.fieldName};
        </#list>

        <#list fileConfig.files as fileInfo>

            <#if fileInfo.condition??>
                if(${fileInfo.condition}){
                    inputPath=new File(inputRootPath,"${fileInfo.inputPath}").getAbsolutePath();
                    outputPath=new File(outputRootPath,"${fileInfo.outputPath}").getAbsolutePath();
                    <#if fileInfo.generateType=="static">
                        StaticGenerator.copyFilesByHutool(inputPath,outputPath);
                        <#else>
                        DynamicGenerator.doGenerate(inputPath,outputPath,model);
                    </#if>
            <#else>
                inputPath=new File(inputRootPath,"${fileInfo.inputPath}").getAbsolutePath();
                outputPath=new File(outputRootPath,"${fileInfo.outputPath}").getAbsolutePath();
                <#if fileInfo.generateType=="static">
                    StaticGenerator.copyFilesByHutool(inputPath,outputPath);
                <#else>
                    DynamicGenerator.doGenerate(inputPath,outputPath,model);
                </#if>
            </#if>

        </#list>
    }


}
