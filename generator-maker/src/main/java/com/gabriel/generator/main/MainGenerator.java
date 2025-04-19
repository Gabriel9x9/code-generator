package com.gabriel.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.gabriel.generator.JarGenerator;
import com.gabriel.generator.ScriptGenerator;
import com.gabriel.generator.file.DynamicFileGenerator;
import com.gabriel.meta.Meta;
import com.gabriel.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator extends GenerateTemplate{

    @Override
    protected String buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要给我输出 dist 啦！");
        return "";
    }
}
