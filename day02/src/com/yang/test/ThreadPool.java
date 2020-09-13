package com.yang.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yg
 * @date 2020/3/10 17:19
 */
public class ThreadPool {
    public static void main(String[] args) {
        // 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor)executorService;
        // 设置线程池的属性
        executorService1.setCorePoolSize(15);
        // 执行指定的线程的操作
        executorService.execute(new NumThread1()); //适合Runnable
//        executorService.submit(); //适合Callable
        // 关闭连接池
        executorService.shutdown();
    }
}


class NumThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}