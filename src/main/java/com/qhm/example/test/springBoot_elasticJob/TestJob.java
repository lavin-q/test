package com.qhm.example.test.springBoot_elasticJob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.util.Date;

/**
 * @ Description:
 * @ Author: qhm
 * @ Date: 2020/1/10 10:16
 * @ Version: 1.0
 */
public class TestJob implements SimpleJob {
    /**
     * 定时任务调度
     * @param shardingContext
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("现在的日期是：" + new Date());
    }
}
