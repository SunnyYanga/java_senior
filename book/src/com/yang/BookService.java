package com.yang;

import com.yang.pojo.Book;
import com.yang.pojo.Page;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/11 16:31
 */
public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
