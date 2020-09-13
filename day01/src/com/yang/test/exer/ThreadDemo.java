package com.yang.test.exer;

/**
 * @author yg
 * @date 2020/3/9 16:27
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        MyThread1 myThread1 = new MyThread1();
//        myThread.start();
//        myThread1.start();

        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 20 == 0) {
                this.yield();
            }
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}