package com.qhm.zk.zkLock;

import java.util.concurrent.CountDownLatch;

/**
 * @Description : 无锁测试  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-24 16:33  //时间
 */
public class NoLockTest implements Runnable {


    static int intentory = 1;
    private static final int NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(NUM);


    public static void main(String[] args) {

        try {

            for (int i = 1; i <= NUM; i++) {
                new Thread(new NoLockTest()).start();
                cdl.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        try {
            cdl.await();
            if (intentory > 0) {
                Thread.sleep(5);
                intentory--;
            }
            System.out.println(intentory);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
