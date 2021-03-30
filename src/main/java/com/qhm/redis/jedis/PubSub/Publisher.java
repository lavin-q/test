package com.qhm.redis.jedis.PubSub;

import com.qhm.redis.jedis.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @Description : 发布者  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-30 14:00  //时间
 */
public class Publisher implements Runnable {

    private String name;
    private String channel;

    public Publisher(String name, String channel) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.channel = channel;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        Jedis jedis = JedisUtils.getInstance();
        while (true) {
            jedis.publish(channel, "New Message from " + this.name);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
