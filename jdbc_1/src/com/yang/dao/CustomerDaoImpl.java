package com.yang.dao;

import com.yang.bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author yg
 * @date 2020/5/10 10:22
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public void insert(Connection connection, Customer customer) {

    }

    @Override
    public void deleteById(Connection connection, int id) {

    }

    @Override
    public void update(Connection connection, Customer customer) {

    }

    @Override
    public Customer getById(Connection connection, int id) {
        return null;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        return null;
    }

    @Override
    public Long getCount(Connection connection) {
        return null;
    }
}
