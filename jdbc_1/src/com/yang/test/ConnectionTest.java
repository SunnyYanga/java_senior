package com.yang.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

/**
 * @author yg
 * @date 2020/3/24 11:18
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Driver driver = new com.mysql.cj.jdbc.Driver();
        //使用反射
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/article_spider?serverTimezone=UTC";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "1234");
        Connection connection = driver.connect(url, info);
        System.out.println(connection);


        // 注册驱动
        DriverManager.registerDriver(driver);
        String user = "root";
        String password = "1234";
        Connection connection1 = DriverManager.getConnection(url, user, password);
        System.out.println(connection1);


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection2 = DriverManager.getConnection(url, user, password);
        System.out.println(connection2);

        Connection connection3 = DriverManager.getConnection(url, user, password);
        System.out.println(connection3);

    }
}
