package com.qhm.collection.Queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description : 队列测试  //描述
 * @Author : qhm  //作者
 * @Date: 2021-04-02 10:29  //时间
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        //向队列添加元素，当在有界队列元素已满时返回false
        boolean offer = queue.offer(4);
        System.out.println(offer);
        //向队列添加元素，当在有界队列元素已满时抛出IllegalStateException
        //queue.add(4);

       /* Integer poll1 = queue.poll();
        System.out.println(poll1);*/
        Integer remove = queue.remove();
        System.out.println(remove);
        System.out.println(queue.toString());





        Queue<Integer> queue1 = new ArrayBlockingQueue<>(3);
        //移除元素，当队列为空时抛出NoSuchElementException
        //queue1.remove();

        //移除头部元素，当队列为空时返回null
        Integer poll = queue1.poll();
        System.out.println(poll);

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(3);
        //检索头部值，如果队列为，抛出NoSuchElementException
        /*Integer element = queue2.element();
        System.out.println(element);*/

        //检索队列头部值，如果队列为空，返回null
        Integer peek = queue2.peek();
        System.out.println(peek);


    }
}
