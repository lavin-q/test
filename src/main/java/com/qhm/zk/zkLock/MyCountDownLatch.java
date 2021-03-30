package com.qhm.zk.zkLock;

/**
 * @Description : 自实现CountDownLatch
 * 当所有线程准备就绪时，开始执行
 * //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-18 15:38  //时间
 */
public class MyCountDownLatch {

    private int total;

    private int count = 0;


    public MyCountDownLatch(int total) {
        this.total = total;
    }

    /**
     * 线程计数器
     */
    public void countDown() {
        //表示线程在累加，当线程计数器数量等于初始化的线程数量时，线程所有线程开始工作
        //因为时多线程调用，所以要使用同步锁(类锁),在当前线程工作完之后通知其他线程可以获取锁
        synchronized (this) {
            this.count++;
            this.notifyAll();
        }

    }


    public void await() {
        //判断当前线程数和初始胡线程总数的大小关系
        //多线程操作，使用同步锁
        synchronized (this){
            while (count != total) {
                this.await();
            }
        }

    }

}
