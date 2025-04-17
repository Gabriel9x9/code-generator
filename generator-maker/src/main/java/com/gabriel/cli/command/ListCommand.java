package com.gabriel.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * （辅助）遍历输出所有要生成文件列表
 */
@CommandLine.Command(name="list",description = "查看文件列表",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");  // basic
        File parentFile=new File(projectPath).getParentFile(); // root

        // input
        String inputPath=new File(parentFile,"demo-projects/acm-template").getAbsolutePath();
        List<File> files= FileUtil.loopFiles(inputPath);
        for(File file:files){
            System.out.println(file);
        }
    }

}
