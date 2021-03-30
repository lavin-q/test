package com.qhm.redis.jedis.PubSub;

import com.qhm.redis.jedis.utils.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * @Description : 订阅者  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-30 14:04  //时间
 */
public class Subscriber implements Runnable {
    private String name;
    private String channel;
    private String pattern;

    public Subscriber(String name, String channel, String pattern) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.channel = channel;
        this.pattern = pattern;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        Jedis jedis = JedisUtils.getInstance();
        if (this.pattern != null) {
            jedis.psubscribe(new SubscribeListener(this.name), pattern);
        } else {
            jedis.subscribe(new SubscribeListener(this.name), channel);
        }
        while (true)
            ;

    }
}
