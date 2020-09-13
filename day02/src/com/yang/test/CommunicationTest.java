package com.yang.test;

/**
 * wait() notify() notifyAll() 都必须使用在同步代码块或同步方法之中
 *
 * @author yg
 * @date 2020/3/10 13:15
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.setName("xiancheng1");
        thread2.setName("xiancheng2");
        thread1.start();
        thread2.start();
    }
}


class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}