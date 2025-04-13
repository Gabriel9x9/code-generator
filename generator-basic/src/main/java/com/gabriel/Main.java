package com.gabriel;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。


import com.gabriel.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {

        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor=new CommandExecutor();
        commandExecutor.deExecute(args);
    }
}
