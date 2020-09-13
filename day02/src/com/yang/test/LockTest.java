package com.yang.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 *
 * 和synchronized不同：
 *
 *
 * @author yg
 * @date 2020/3/10 12:28
 */
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread1= new Thread(window);
        Thread thread2= new Thread(window);
        Thread thread3= new Thread(window);

        thread1.setName("窗口1");
        thread2.setName("窗口1");
        thread1.setName("窗口1");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class Window implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            try {
                // 调用lock()
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}