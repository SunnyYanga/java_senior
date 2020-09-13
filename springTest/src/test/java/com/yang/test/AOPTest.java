package com.yang.test;

import com.yang.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yg
 * @date 2020/4/25 16:06
 */
public class AOPTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.yang");
        IAccountService as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();
    }
}
