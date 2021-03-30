package com.qhm.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description :   //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-26 16:27  //时间
 */
public class SimpleRateLimiter {

    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }


}
