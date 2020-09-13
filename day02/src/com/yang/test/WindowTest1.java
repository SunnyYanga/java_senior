package com.yang.test;

/**
 * 方式一：同步代码块
 * synchronized(同步监视器) {
 *      //需要被同步的代码
 * }
 * 说明：操作共享数据的方法，即为需要被同步的代码
 * 共享数据：多个线程共同操作的变量
 * 同步监视器：锁。任何一个类的对象都可以当锁。要求：多个线程必须共用同一把锁。
 *
 * 方式二：同步方法
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
 * 2.非静态的同步方法，同步监视器是this,静态的是当前类本身
 *
 * @author yg
 * @date 2020/3/10 9:58
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3= new Thread(window1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}


class Window1 implements Runnable {

    private int ticket = 100;
    Object object = new Object();

    @Override
    public void run() {
        while(true) {
//            synchronized (object) {
//            synchronized (this) {
            synchronized (Window1.class) {  //Window1.class只会加载一次
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}