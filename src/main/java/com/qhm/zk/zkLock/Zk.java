package com.qhm.zk.zkLock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description : Zk  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-23 14:58  //时间
 */
public class Zk implements Lock {

    private static CountDownLatch cdl = new CountDownLatch(1);

    private static final String IP_PORT = "192.168.120.22:2181";
    private static final String Z_NODE = "/LOCK";

    //多线程维护
    private volatile String beforePath;

    private volatile Map<String, String> beforePathMap = new HashMap<>();
    //多线程维护
    private volatile String path;
    private volatile Map<String, String> pathMap = new HashMap<>();

    private ZkClient zkClient = new ZkClient(IP_PORT);

    public Zk() {
        //初始化父节点
        if (!zkClient.exists(Z_NODE)) {
            zkClient.createPersistent(Z_NODE);
        }
    }


    @Override
    public void lock() {
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName() + "获得锁");
        } else {
            //等待加锁
            waitForLock();
            //尝试加锁
            lock();
        }
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName() + "释放锁：" + path);
        zkClient.delete(path);
    }

    //synchronized使此方法同步，线程进来创建临时顺序节点, 获取子节点数量必定为 1
    //进而导致永远加锁成功, 并不会监听加锁失败的 别的顺序节点, 所以这个lock是个分布式锁, 却是个阻塞锁,会导致羊群效应
    @Override
    public synchronized boolean tryLock() {
        //当线程进入尝试加锁时直接创建自己的临时节点并监听前一个节点
        if (StringUtils.isBlank(path)) {
            //创建临时顺序节点
            path = zkClient.createEphemeralSequential(Z_NODE + "/", "lock");

        }
        //对目录下的节点进行排序
        List<String> children = zkClient.getChildren(Z_NODE);
        Collections.sort(children);

        //如果当前节点（path）是最小节点，则加锁成功
        if (path.equals(Z_NODE + "/" + children.get(0))) {
            System.out.println(Thread.currentThread().getName() + "加锁成功:" + path);
            return true;
        } else {
            //当前节点不是头部节点，找到前一个节点，依次类推，释放也如此
            int i = Collections.binarySearch(children, path.substring(Z_NODE.length() + 1));

            beforePath = Z_NODE + "/" + children.get(i - 1);
            System.out.println(Thread.currentThread().getName() + "前一节点：" + beforePath);
        }
        return false;
    }

    public void waitForLock() {
        //监听Zk节点
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) {

            }

            @Override
            public void handleDataDeleted(String s) {
                System.out.println(Thread.currentThread().getName() + ":监听到节点删除事件！---------------------------");
                cdl.countDown();
            }
        };
        //监听前一个节点
        //this表示当前线程
        this.zkClient.subscribeDataChanges(beforePath, listener);
        if (zkClient.exists(beforePath)) {
            try {
                System.out.println(Thread.currentThread().getName() + "加锁失败，等待");
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        System.out.println(Thread.currentThread().getName() + "释放监听：" + beforePath);
        zkClient.unsubscribeDataChanges(beforePath, listener);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
