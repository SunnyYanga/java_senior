package com.yang.dao;

import com.yang.bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author yg
 * @date 2020/5/10 10:09
 */
public interface CustomerDao {

    void insert(Connection connection, Customer customer);

    void deleteById(Connection connection, int id);

    void update(Connection connection, Customer customer);

    Customer getById(Connection connection, int id);

    List<Customer> getAll(Connection connection);

    Long getCount(Connection connection);
}
