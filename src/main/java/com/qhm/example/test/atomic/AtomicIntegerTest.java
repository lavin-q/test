package com.qhm.example.test.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description : AtomicInteger测试类  //描述
 * @Author : qhm  //作者
 * @Date: 2020-07-30 14:58  //时间
 */
public class AtomicIntegerTest {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        getCurrentValue();
        setValue();
        getAndSet();
        //getCurrentValue();
        getAndIncrement();
        //getCurrentValue();
        getAndDecrement();
    }

    //获取当前值
    public static void getCurrentValue(){
        System.out.println(atomicInteger.get());//-->0
    }

    //设置value值
    public static void setValue(){
        atomicInteger.set(12);//直接用12覆盖旧值
        System.out.println(atomicInteger.get());//-->12
    }

    //根据方法名称getAndSet就知道先get，则最后返回的就是旧值，如果get在后，就是返回新值
    public static void getAndSet(){
        System.out.println(atomicInteger.getAndSet(15));//-->12,真实值-->15
    }

    public static void getAndIncrement(){
        System.out.println(atomicInteger.getAndIncrement());//-->15,真实值变为16
    }

    public static void getAndDecrement(){
        System.out.println(atomicInteger.getAndDecrement());//-->16,真实值15
    }

    public static void getAndAdd(){
        System.out.println(atomicInteger.getAndAdd(10));//-->15，真实值25
    }

    public static void incrementAndGet(){
        System.out.println(atomicInteger.incrementAndGet());//-->26，真实值26
    }

    public static void decrementAndGet(){
        System.out.println(atomicInteger.decrementAndGet());//-->25，真实值25
    }

    public static void addAndGet(){
        System.out.println(atomicInteger.addAndGet(20));//-->45真实值45
    }
}
