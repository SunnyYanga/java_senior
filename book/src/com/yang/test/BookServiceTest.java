package com.yang.test;

import com.yang.pojo.Book;
import com.yang.BookService;
import com.yang.service.impl.BookServiceImpl;
import org.junit.Test;

/**
 * @author yg
 * @date 2020/4/11 16:40
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book());
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
    }
}