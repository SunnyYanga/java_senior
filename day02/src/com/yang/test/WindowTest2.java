package com.yang.test;

/**
 * @author yg
 * @date 2020/3/10 11:21
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2= new Window2();
        Thread t1 = new Thread(window2);
        Thread t2 = new Thread(window2);
        Thread t3= new Thread(window2);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class Window2 implements Runnable {

    private int ticket = 100;
    Object object = new Object();

    @Override
    public void run() {
        while(true) {
            show();

        }
    }


    private synchronized void show() {  //同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号为" + ticket);
            ticket--;
        }
    }
}
