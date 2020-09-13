package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yg
 * @date 2020/4/28 17:11
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(Model model) {
        System.out.println("hello");
        return "success";
    }
}
