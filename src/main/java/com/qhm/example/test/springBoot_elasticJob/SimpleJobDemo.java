package com.qhm.example.test.springBoot_elasticJob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2019/9/23 10:21
 */
@Component
public class SimpleJobDemo implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        //System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(String.format("------Thread ID: %s, 任務總片數: %s, " +
                        "当前分片項: %s.当前參數: %s," +
                        "当前任務名稱: %s.当前任務參數: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()

        ));
    }


    public static void main(String[] args){
        Date t = new Date(1574030209000L);
        System.out.println(t);
    }
}