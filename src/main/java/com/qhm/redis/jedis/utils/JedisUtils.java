package com.qhm.redis.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

/**
 * @Description :   //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-30 14:02  //时间
 */
public class JedisUtils {

    private String LOCK_KEY = "redis_lock";

    protected long INTERNAL_LOCK_LEASE_TIME = 3;

    private long timeout = 1000;

    private SetParams params = SetParams.setParams().nx().px(INTERNAL_LOCK_LEASE_TIME);
    static JedisPoolConfig config;
    //private CountDownLatch cdl = new CountDownLatch(1);

    static {
        config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxIdle(30);
        config.setMinIdle(3);
        // 最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 60);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(true);
    }

    static JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379, 1000, "qhm1997");

    public static Jedis getInstance(){
       return jedisPool.getResource();
    }
}
