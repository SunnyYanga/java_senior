package com.yang.test;

import com.yang.config.SpringConfig;
import com.yang.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yg
 * @date 2020/4/24 9:57
 */
public class SpringAnnoTest {
    public static void main(String[] args) {
        //        1.获取核心容器对象
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
//        2.根据id获取bean对象
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
