package com.yang.config;

import com.yang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yg
 * @date 2020/5/1 19:12
 */
@PropertySource("")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean("person")
    public Person person() {
        return new Person("李四", "20");
    }
}
