package com.yang.test;

import com.yang.bean.Person;
import com.yang.config.MainConfig;
import com.yang.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author yg
 * @date 2020/4/30 15:20
 */
public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
//        Person person = ac.getBean(Person.class);
//        System.out.println(person);
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = ac.getBean(Person.class);
        System.out.println(person);

        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

    @Test
    public void test1() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Object colorFactoryBean = ac.getBean("colorFactoryBean");
        System.out.println("bean的类型" + colorFactoryBean.getClass());

        Object colorFactoryBean1 = ac.getBean("&colorFactoryBean");
        System.out.println("bean1的类型" + colorFactoryBean1.getClass());

//        Person person1 = ac.getBean(Person.class);
//        System.out.println(person1);
//        System.out.println(person == person1);
    }

    @Test
    public void test3() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);

        ConfigurableEnvironment environment = (ConfigurableEnvironment) ac.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> beans = ac.getBeansOfType(Person.class);
        System.out.println(beans);

    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);

        ac.close();
        Object colorFactoryBean = ac.getBean("colorFactoryBean");
        System.out.println("bean的类型" + colorFactoryBean.getClass());

        Object colorFactoryBean1 = ac.getBean("&colorFactoryBean");
        System.out.println("bean1的类型" + colorFactoryBean1.getClass());

//        Person person1 = ac.getBean(Person.class);
//        System.out.println(person1);
//        System.out.println(person == person1);
    }
}
