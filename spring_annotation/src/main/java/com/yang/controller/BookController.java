package com.yang.controller;

import com.yang.dao.BookDao;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author yg
 * @date 2020/5/1 9:15
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
