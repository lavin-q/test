package com.qhm.zk.zkLock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description : zkTest  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-18 15:02  //时间
 */
public class ZKTest implements Runnable, Lock {

    static int intentory = 10;
    private static final int NUM = 10;
    //发令枪,所有线程准备就绪后，同时执行,在还有线程未就绪时，已准备好的线程执行等待操作
    private static CountDownLatch cdl = new CountDownLatch(1);
    //private static MyCountDownLatch cdl = new MyCountDownLatch(NUM);


    private static final String IP_PORT = "192.168.120.22:2181";
    private static final String Z_NODE = "/LOCK";
    private static ZkClient zkClient = new ZkClient(IP_PORT);

    public static void main(String[] args) {

        try {

            for (int i = 1; i <= NUM; i++) {
                new Thread(new ZKTest()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        try {
            //尝试枷锁
            new ZKTest().lock();
            if (intentory > 0) {
                intentory--;
            }
            System.out.println(intentory);
            //return;
        } finally {
            new ZKTest().unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
    }

    public void lock() {
        //尝试加锁
        if (tryLock()) {
            return;
        }
        //等待锁,进入监听队列
        waitForLock();
        //再次尝试获取锁
        lock();
    }


    public boolean tryLock() {
        try {
            //尝试加锁
            zkClient.createPersistent(Z_NODE);
            return true;
        } catch (ZkNodeExistsException e) {
            //加锁失败
            return false;
        }
    }

    public void waitForLock() {
        System.out.println(Thread.currentThread().getName() + "加锁失败");
        //监听节点状态
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                //当监听到节点被删除时，将线程放入cdl中，进行锁抢占
                System.out.println("唤醒");
                cdl.countDown();
            }
        };
        //监听
        zkClient.subscribeDataChanges(Z_NODE, listener);
        if (zkClient.exists(Z_NODE)) {
            try {
                //节点存在,所有线程等待
                cdl.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //节点删除，释放监听
        zkClient.unsubscribeDataChanges(Z_NODE, listener);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        zkClient.delete(Z_NODE);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
