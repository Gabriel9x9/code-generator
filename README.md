


# Achieve

## first

1. 生成静态、动态文件，通过 Main 方法执行，得到完整代码
2. 命令行接收输入
3. 工具封装

静态文件复制：Hutool库

动态文件：模板引擎 FreeMaker 模板 + 数据模型

命令行开发：
CLI [commend、option、parameter]  可选、强制交互式
子命令：声明式、编程式
命令模式（设计模式）【行为类设计模式】：将请求的发送者（客户端）和接收者（执行请求的对象）解耦。
每个操作对应一个独立的命令类，广泛用于统一处理多种复杂操作，持续增加新命令，处理复杂组合命令
exp：人 -- 遥控器 -- 电视

实现：
需求，子命令：generate,list,config
分解：
1. 创建命令执行器
2. 实现子命令
3. 提供项目的全局调用入口
4. 构建jar报
5. 测试使用
6. 简化使用（封装脚本）

## Second

1. 制作工具整体规划
     生成器制作工具 --> 代码生成器 --> 目标代码
     思路：配置文件加上参数去生成模板文件及可执行文件


2. 制作工具核心设计

元信息（配置文件），一般用JSON格式，配置：
代码生成器的基本信息，
生成文件信息
数据模型信息

3. 制作工具开发

根据配置文件得到一个meta对象，后保存在内存中，避免重复创建对象的开销。  -- 单例模式



# Knowledge

1. 扩展思路：一个工具类可以用于多个模块的实现
2. 模板设计：分离数据处理和展示、重用、维护、安全性、性能
3. 单元测试：junit
4. 模板中文件：生成动态、静态文件
5. 用反射动态打印属性信息
6. 单例模式
双检锁进行并发控制
饿汉式
7. 路径分隔符可以混用
8. 


# Problems

1. Runnable & Callable
2. jar包运行
3. volatile关键字
保持变量值的一致性（可见性），防止对其修饰的变量相关的操作被重排列。  -- 保证变量的可见性和禁止指令重排序，不能保证原子性和顺序性。
volatile和synchronized的区别
