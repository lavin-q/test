package com.qhm.shiro;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description : 测试定时任务  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-13 12:11  //时间
 */
@Component
public class TestScheduled {


    @Scheduled(cron = "0 0 19 * * ?")
    public void test(){
        System.out.println("测试定时任务Job");
    }
}
