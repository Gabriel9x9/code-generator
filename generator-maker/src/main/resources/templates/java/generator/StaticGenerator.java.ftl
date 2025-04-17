package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成
 */
public class StaticGenerator {

    public static void copyFilesByHutool(String inputPath, String outputPath) {
         FileUtil.copy(inputPath,outputPath,false);
    }

}
