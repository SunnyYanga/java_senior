package com.yang.test;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * 线程的优先级
 * 1.MAX_PRIORITY：10
 * 2.MIN_PRIORITY:1
 * 3.NORM_PRIORITY:5
 *
 * @author yg
 * @date 2020/3/9 16:00

 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
