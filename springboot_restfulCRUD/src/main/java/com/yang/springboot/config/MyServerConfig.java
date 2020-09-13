package com.yang.springboot.config;

import com.yang.springboot.filter.MyFilter;
import com.yang.springboot.listener.MyListener;
import com.yang.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;

/**
 * @author yg
 * @date 2020/5/7 9:12
 */
@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return  servletServletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterFilterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
}
