package com.gabriel.cli.example;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name="main",mixinStandardHelpOptions = true)
public class SubCommand implements Runnable{
    @Override
    public void run() {
        System.out.println(("执行主命令"));
    }

    @Command(name="add",description = "增加",mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable{
        @Override
        public void run() {
            System.out.println(("执行增加命令"));
        }
    }

    @Command(name="delete",description = "删除",mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable{
        @Override
        public void run() {
            System.out.println(("执行删除命令"));
        }
    }

    @Command(name="query",description = "查询",mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable{
        @Override
        public void run() {
            System.out.println(("执行查询命令"));
        }
    }

    public static void main(String[] args) {
        // execute root
//        String[] myArgs=new String[]{};
        // the help of root
        String[] myArgs=new String[]{"--help"};
        // execute add
//        String[] myArgs=new String[]{"add"};
//        String[] myArgs=new String[]{"add","--help"};
        // execute not exist
//        String[] myArgs=new String[]{"update"};

        int exitCode=new CommandLine(new SubCommand())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);

        System.exit(exitCode);
    }
}

