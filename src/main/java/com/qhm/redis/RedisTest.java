package com.qhm.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description :   //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-26 11:07  //时间
 */
public class RedisTest implements Runnable {

    private static Integer inventory = 1001;
    //private static AtomicInteger inventory = new AtomicInteger(1001);
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>();
    volatile static CountDownLatch countDownLatch = new CountDownLatch(NUM);
    //static RedisLock redisLock = new RedisLock();


    /**
     * 线程不安全
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(NUM, NUM, 1000L, TimeUnit.SECONDS, linkedBlockingQueue);
        long startTime;
        long endTime;
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("qhm1997");
        final RedissonClient client = Redisson.create(config);
        final RLock lock = client.getLock("lock1");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                lock.lock();
                //redisLock.lock(UUID.randomUUID().toString());
                //synchronized (Object.class) {
                inventory--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //}
                System.out.println(Thread.currentThread().getName() + ":" + inventory);
                lock.unlock();
                //redisLock.unlock(UUID.randomUUID().toString());
                countDownLatch.countDown();
            });
            //countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
        client.shutdown();
        endTime = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "         总耗时：" + (endTime - startTime) + "         库存数为：" + inventory);
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            if (inventory > 0) {
                //Thread.sleep(5);
                inventory--;
            }
            System.out.println(inventory);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
