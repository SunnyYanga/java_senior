package com.yang.service;

import com.yang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yg
 * @date 2020/5/1 9:15
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
}
