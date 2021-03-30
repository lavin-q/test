package com.qhm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * @Description : redis锁  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-26 10:46  //时间
 */
public class RedisLock {

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


    /**
     * 加锁(存在多线程隐患)
     *
     * @param id
     * @return
     */
    public boolean lock(String id) {
        Long start = System.currentTimeMillis();
        //循环抓取
        Jedis jedis = jedisPool.getResource();
        try {
            for (; ; ) {
                try {
                    //SET命令返回OK ，则证明获取锁成功
                    String lock = jedis.set(LOCK_KEY, id, params);
                    if ("OK".equals(lock)) {
                        return true;
                    }
                    //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                    long l = System.currentTimeMillis() - start;
                    if (l >= timeout) {
                        return false;
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            jedis.close();
        }
    }


    /**
     * 解锁(存在多线程隐患)
     *
     * @param id
     * @return
     */
    public boolean unlock(String id) {
        Jedis jedis = jedisPool.getResource();
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            String result = jedis.eval(script, Collections.singletonList(LOCK_KEY), Collections.singletonList(id)).toString();
            return "1".equals(result);
        } finally {
            jedis.close();
        }

    }


}
