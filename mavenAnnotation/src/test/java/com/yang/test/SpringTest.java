package com.yang.test;

import com.yang.domain.Account;
import com.yang.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yg
 * @date 2020/4/23 15:44
 */
public class SpringTest {
    public static void main(String[] args) {
//        1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.根据id获取bean对象
        User user = (User) ac.getBean("user");
        System.out.println(user);
        Account account = ac.getBean("account", Account.class);
        System.out.println(account);
        Account account1 = ac.getBean("account", Account.class);
        System.out.println(account1);
        System.out.println(account == account1);
    }
}
