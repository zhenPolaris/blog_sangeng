package com.zhen.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务 每隔十分钟把redis中浏览量更新到数据库
 */
@Component
public class TestJob {

    // @Scheduled(cron = "0/5 * * * * ?")
    // public void testJob(){
    //     //要执行的代码
    //     System.out.println("定时任务执行了");
    // }
}