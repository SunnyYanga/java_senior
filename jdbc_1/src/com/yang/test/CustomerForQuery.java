package com.yang.test;

import com.yang.bean.Customer;
import com.yang.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author yg
 * @date 2020/5/8 17:05
 */
public class CustomerForQuery {

    public static void main(String[] args) {
        CustomerForQuery customerForQuery = new CustomerForQuery();
        Customer customer = customerForQuery.queryForCustomers("select id, name from customers where id=?", 1);
        System.out.println(customer);
    }

    public Customer queryForCustomers(String sql, Object...args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();
            if (resultSet.next()) {
                Customer customer = new Customer();
                for (int i = 0; i < count; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnName(i + 1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, columnValue);
                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }

        return null;
    }



    public void testQuery1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id, name, email, birth from customers where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 2);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
    //            Object[] data = new Object[]{id, name, email, birth};
                Customer customer = new Customer(id, name, email, birth);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }


    }
}
