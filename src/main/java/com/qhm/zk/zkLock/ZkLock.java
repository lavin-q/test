package com.qhm.zk.zkLock;

/**
 * @Description : zkLock  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-23 14:47  //时间
 */
public class ZkLock {
    static int inventory = 10;
    private static final int NUM = 5;

    private static Zk zk = new Zk();

    public static void main(String[] args) {
        try {
            for (int i = 0; i < NUM; i++) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            zk.lock();
                            Thread.sleep(100);
                            if (inventory > 0) {
                                inventory--;
                            }
                            System.out.println(Thread.currentThread().getName() + inventory);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            zk.unlock();
                            System.out.println(Thread.currentThread().getName() + "释放锁");
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
