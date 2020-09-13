package com.example.demo.controller;

import com.yang.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yg
 * @date 2020/5/4 11:40
 */
//@ResponseBody  // 这个类的所有方法返回的数据直接写给浏览器(如果是对象转为json对象)
//@Controller
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHelloYang("yang");
    }
}
