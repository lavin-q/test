package com.qhm.redis.jedis.PubSub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description :   //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-30 14:06  //时间
 */
public class PubSubTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService exec = Executors.newCachedThreadPool();
        String channel = "c1";
        exec.execute(new Publisher("p1", channel));
        exec.execute(new Subscriber("s1", channel, null));
        exec.execute(new Subscriber("s2", null, "c*"));
    }
}
