package com.yang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yg
 * @date 2020/5/25 11:47
 */
@Configuration
@ComponentScan("com.yang")
@EnableTransactionManagement
public class SpringConfiguration {

}
