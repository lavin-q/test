package com.qhm.redis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description : redis 锁测试  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-25 10:01  //时间
 */
public class RedisLockTest {
    private static Integer inventory = 1001;
    //private static AtomicInteger inventory = new AtomicInteger(1001);
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>();
    //可重入锁
    static ReentrantLock reentrantLock = new ReentrantLock();
    //private static Jedis jedis = JedisApi.getResource();


    public static void main(String[] args) {
        //jedis.select(1);
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory.get(), inventory.get(), 10L, TimeUnit.SECONDS, linkedBlockingQueue);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingQueue);
        //线程发令枪
        final CountDownLatch cdl = new CountDownLatch(NUM);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() ->
            {
                try {
                    //redis单机锁
                    //jedis.setnx("lock", "test");
                    Thread.sleep(1);
                   if (inventory > 0) {
                        inventory--;
                    }
                    /*jedis.del("lock");*/
                    //synchronized (Object.class) {
                    //reentrantLock.lock();
                    //inventory.set(inventory.decrementAndGet());
                    //reentrantLock.unlock();
                    //}
                    System.out.println(Thread.currentThread().getName() + "执行,库存数：" + inventory);
                    cdl.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "         总耗时：" + (endTime - startTime) + "         库存数为：" + inventory);
    }

    /*private static int inventory = 1000;

    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(NUM);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingQueue);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                inventory--;
            });
            System.out.println(Thread.currentThread().getName() + "执行,库存数：" + inventory);
            cdl.countDown();
        }
        threadPoolExecutor.shutdown();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "         总耗时：" + (endTime - startTime) + "         库存数为：" + inventory);
    }*/
}
