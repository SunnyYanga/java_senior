package com.yang.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author yg
 * @date 2020/4/7 16:27
 */
public class DruidTest {
    public void getConnection()  {

    }

    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
        pros.load(stream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
