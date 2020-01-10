package com.qhm.example.test.springBoot_elasticJob;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @ Description:
 * @ Author: qhm
 * @ Date: 2020/1/10 10:17
 * @ Version: 1.0
 */
@Slf4j
public class MyElasticJobListener implements ElasticJobListener {

    private long beginTime = 0;

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();

        log.info("===>{} 执行开始时间 {} <===", shardingContexts.getJobName(), new Date());
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        long endTime = System.currentTimeMillis();
        log.info("===>{} 执行结束时间:{} <===", shardingContexts.getJobName(), new Date());
    }
}
