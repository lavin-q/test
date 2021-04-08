package com.qhm.collection.selfMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description : 自实现HashMap  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-31 10:54  //时间
 */
public class SelfHashMap<K, V> {

    static int initialCapacity = 1 << 30;
    public static HashMap<Integer, Object> map = new HashMap<>(initialCapacity, 0.5f);
    int x = 1, y = 2;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Map<Integer, Object> map1 = new ConcurrentHashMap<>(1);
        ThreadPoolExecutor t = new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        for (int i = 0; i < Integer.MAX_VALUE - 1; i++) {
            int finalI = i;
            t.execute(() -> {
                map1.put(finalI, String.valueOf(0));
                System.out.println(map1.size());
            });


        }

        /*int j = 9999999;
        int cc = 9999;*/
        //System.out.println(j+cc);
        System.out.println(Math.pow(2, 31));
        System.out.println((1 << 31) - 1);
        System.out.println(0x7fffffff);
        /*int k = 1 << 30;
        int l = 1 << 31;
        //map.put(1,"aaa");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 23; i++) {
            map.put(i, i);
        }
        Spliterator<Integer> s1 = map.keySet().spliterator();
        Spliterator<Integer> s2 = s1.trySplit();
        Spliterator<Integer> s3 = s2.trySplit();

        Thread t1 = new Thread(new MyThread(s1, "线程1"));
        Thread t2 = new Thread(new MyThread(s2, "线程2"));
        Thread t3 = new Thread(new MyThread(s3, "线程3"));
        t1.start();
        t2.start();
        t3.start();*/



        /*System.out.println(initialCapacity);

        int k = 8 >> 2;
        System.out.println(k);
        int capacity = 1 << 30;
        int n = capacity - 1;
        System.out.println(n);
        n |= n >>> 1;
        n = n | n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
       *//* int qaaa = hash("qaaa");
        System.out.println(qaaa);*//*
        //测试HashMap最大初始化容量
        System.out.println("a");*/

    }

}

class MyThread implements Runnable {
    Spliterator<Integer> spliterator;
    String threadName;

    MyThread(Spliterator<Integer> spliterator, String threadName) {
        this.spliterator = spliterator;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        spliterator.forEachRemaining(s -> {
            System.out.println(threadName + "=" + s);
        });
    }
}

class B {
    private void a() {
        System.out.println("1");
    }

    public void c() {
        this.a();
    }


}

class C extends B {
    public void d() {
        c();
    }
}
