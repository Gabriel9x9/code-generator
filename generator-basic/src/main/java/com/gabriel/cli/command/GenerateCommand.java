package com.gabriel.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.gabriel.generator.MainGenerator;
import com.gabriel.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * 接收参数，生成代码
 */
@CommandLine.Command(name="generate",description = "生成代码",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names={"-l","--loop"},arity = "0..1",description = "是否循环",interactive = true,echo = true)
    private boolean loop;

    @CommandLine.Option(names={"-a","--author"},arity = "0..1",description = "作者",interactive = true,echo = true)
    private String author="gabriel";

    @CommandLine.Option(names={"-o","--outputText"},arity = "0..1",description = "输出文本",interactive = true,echo = true)
    private String outputText="sum = ";

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        System.out.println(("配置信息：" + mainTemplateConfig));
        MainGenerator.doGenerator(mainTemplateConfig);
        return 0;
    }
}
