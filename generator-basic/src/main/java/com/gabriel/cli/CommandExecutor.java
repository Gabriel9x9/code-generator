package com.gabriel.cli;

import com.gabriel.cli.command.ConfigCommand;
import com.gabriel.cli.command.GenerateCommand;
import com.gabriel.cli.command.ListCommand;
import picocli.CommandLine;

/**
 * 调用方（命令执行器类）
 */
@CommandLine.Command(name="gabriel",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        // don't input subcommand,give advice
        System.out.println(("请输入具体指令，或者输入 --help 查看命令提示"));

    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer deExecute(String[] args) {
        return commandLine.execute(args);
    }
}
