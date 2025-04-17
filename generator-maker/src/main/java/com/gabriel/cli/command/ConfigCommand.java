package com.gabriel.cli.command;


import cn.hutool.core.util.ReflectUtil;
import com.gabriel.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;


/**
 * （辅助）输出允许用户传入的动态参数信息
 */
@CommandLine.Command(name="config",description = "查看参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        System.out.println(("查看参数信息"));

        // get information
//        Class<?> myClass=MainTemplateConfig.class;
//        Field[] fields=myClass.getDeclaredFields();
        Field[] fields= ReflectUtil.getFields(DataModel.class);

        // print
        for(Field field:fields){
            System.out.println(("字段名称：" + field.getName()));
            System.out.println(("字段类型：" + field.getType()));
            System.out.println(("---"));
        }
    }

}


