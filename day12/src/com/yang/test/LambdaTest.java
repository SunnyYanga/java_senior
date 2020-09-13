package com.yang.test;

/**
 * @author yg
 * @date 2020/3/22 10:39
 */
public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("水水水水");
        runnable.run();
    }
}
