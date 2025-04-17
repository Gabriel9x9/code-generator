package com.gabriel.generator;

import java.io.*;
import java.util.Map;



public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        // 直接把 where mvn.cmd 给你的绝对路径硬编码进来
        // —— 或者用 System.getenv("MAVEN_HOME") 拼一下也行
        String mvnCmd = "F:\\Java\\apache-maven-3.9.9\\bin\\mvn.cmd";
        String[] command = { "cmd", "/c", mvnCmd, "clean", "package", "-DskipTests=true" };

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File(projectDir));
        pb.redirectErrorStream(true);

        Process p = pb.start();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }
        }
        int code = p.waitFor();
        System.out.println("Maven 构建结束，退出码：" + code);
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("F:\\Projects\\code-generator\\code-generator\\generator-maker\\generated\\acm-template-pro-generator");
    }
}
