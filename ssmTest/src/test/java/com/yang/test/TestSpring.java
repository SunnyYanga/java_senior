package com.yang.test;

import com.yang.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yg
 * @date 2020/4/30 9:34
 */
public class TestSpring {

    @Test
    public void run1() {
        // 1. 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 2.获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //3.调用方法
        as.findAll();
    }
}
