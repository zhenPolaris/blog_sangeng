package com.zhen.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** 项目启动时预处理
 *  这里主要是项目启动之前 要到数据库的浏览量信息 存储到redis中
 * @author 甄子函
 * @date: 2022/9/15__9:41
 */
@Component
public class TestRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("程序初始化");
    }
}
