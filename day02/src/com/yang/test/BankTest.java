package com.yang.test;

/**
 * @author yg
 * @date 2020/3/10 11:41
 */
public class BankTest {
}


class Bank {
    private Bank() {}

    private static Bank instance = null;

    public static synchronized Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
            return instance;
        }
        return instance;
    }
}