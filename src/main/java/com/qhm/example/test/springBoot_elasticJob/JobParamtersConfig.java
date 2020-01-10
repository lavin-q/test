package com.qhm.example.test.springBoot_elasticJob;

/**
 * @ Description:定时任务常量相关配置类
 * @ Author: qhm
 * @ Date: 2020/1/10 10:10
 * @ Version: 1.0
 */
public class JobParamtersConfig {
    /**
     * 测试定时
     */
    public static String test_cron = "0/1 * * * * ?";

    /**
     * 测试作业分片总数
     */
    public static int test_total_count = 2;

    /**
     * 测试分片序列号和参数
     */
    public static String test_shardingItemParameters = "0=A,1=B";
}
