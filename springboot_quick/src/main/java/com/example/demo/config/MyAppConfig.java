package com.example.demo.config;

import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yg
 * @date 2020/5/4 15:43
 */
//@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService() {
        System.out.println("配置类@Bean给容器中添加组件了");
        return new HelloService();
    }
}
