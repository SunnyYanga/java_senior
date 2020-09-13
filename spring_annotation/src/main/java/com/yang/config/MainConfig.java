package com.yang.config;

import com.yang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author yg
 * @date 2020/4/30 15:24
 */
@Configuration
@ComponentScan(value = "com.yang", excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
})
public class MainConfig {

//    给容器中注册一个bean， 类型为返回值类型，id为方法名
    @Bean("person")
    public Person person1() {
        return new Person("李四", "20");
    }
}
