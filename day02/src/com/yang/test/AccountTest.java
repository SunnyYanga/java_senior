package com.yang.test;

/**
 * @author yg
 * @date 2020/3/10 13:00
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.setName("甲");
        customer2.setName("乙");
        customer1.start();
        customer2.start();
        
    }
}


class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }

    }
}


class Customer extends Thread {
    private Account account;

    public Customer (Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}