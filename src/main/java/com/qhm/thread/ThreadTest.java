package com.qhm.thread;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description :   //描述
 * @Author : qhm  //作者
 * @Date: 2021-04-01 14:13  //时间
 */
public class ThreadTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        //创建线程池
        //核心线程池大小
        int corePoolSize = 2;
        //线程池最大线程数量
        int maximumPoolSize = 4;
        //线程等待时间（核心线程一直存活，大于核心线程数量的线程在存活时间后被移除）
        long keepAliveTime = 1000;
        //存活时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //阻塞队列最大值
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        executor.prestartAllCoreThreads(); // 预启动所有核心线程
        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
            Thread.sleep(1000);
            /*BlockingQueue<Runnable> queue = executor.getQueue();
            System.out.println(queue.size());*/
        }
        String s = executor.getQueue().toString();
        System.out.println(s);
        System.in.read(); //阻塞主线程
    }


    //自定义ThreadFactory
    static class NameThreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }


    //拒绝策略
    public static class MyIgnorePolicy implements RejectedExecutionHandler {

        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                //System.out.println(e.getQueue().toString());
                Runnable peek = e.getQueue().peek();
                //System.out.println(e.getQueue().toString());
                assert peek != null;
                System.out.println("移除队列中最老的线程：" + peek.toString()+",由当前线程添加到队尾："+r.toString());
                e.getQueue().poll();
                e.execute(r);
                //System.out.println(e.getQueue().toString());
            }
            //doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }

        /*public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                e.getQueue().poll();
                e.execute(r);
            }
        }*/


    }


    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running by:" + Thread.currentThread().getName());
                Thread.sleep(10000); //让任务执行慢点
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
