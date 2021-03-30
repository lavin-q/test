package com.qhm.zk.zkLock;

import java.util.concurrent.CountDownLatch;

/**
 * @Description : 无锁测试  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-24 16:33  //时间
 */
public class NoLockTest implements Runnable {


    static int inventory = 10;
    private static final int NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(10);


    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        try {

            for (int i = 1; i <= NUM; i++) {
                new Thread(new NoLockTest()).start();
                cdl.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "         总耗时：" + (endTime - startTime) + "         库存数为：" + inventory);
    }

    @Override
    public void run() {
        try {
            cdl.await();
            if (inventory > 0) {
                Thread.sleep(5);
                inventory--;
            }
            System.out.println(inventory);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
