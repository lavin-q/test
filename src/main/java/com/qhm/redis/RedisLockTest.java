package com.qhm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description : redis 锁测试  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-25 10:01  //时间
 */
public class RedisLockTest {
    private static volatile AtomicInteger inventory = new AtomicInteger(1001);
    //private static AtomicInteger inventory = new AtomicInteger(1001);
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>();
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM);
    static RedisLock redisLock = new RedisLock();
    //可重入锁
    static ReentrantLock reentrantLock = new ReentrantLock();
    static JedisPoolConfig config = null;

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

    static Jedis jedis = new JedisPool(config, "127.0.0.1", 6379, 1000, "qhm1997").getResource();


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        //jedis.select(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(NUM, NUM, 10L, TimeUnit.SECONDS, linkedBlockingQueue);
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingQueue);
        //线程发令枪
        final CountDownLatch cdl = new CountDownLatch(NUM);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() ->
            {
                try {

                    redisLock.lock(UUID.randomUUID().toString());
                    //Thread.sleep(1);
                    inventory.getAndDecrement();

                    redisLock.unlock(UUID.randomUUID().toString());
                    //jedis.del("lock");
                    //synchronized (Object.class) {
                    //reentrantLock.lock();
                    //inventory.set(inventory.decrementAndGet());
                    //reentrantLock.unlock();
                    //}
                    System.out.println(Thread.currentThread().getName() + ":" + inventory.get());
                    cdl.countDown();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                //cyclicBarrier.await();
            });

        }
        threadPoolExecutor.shutdown();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "         总耗时：" + (endTime - startTime) + "         库存数为：" + inventory.get());
    }
}
