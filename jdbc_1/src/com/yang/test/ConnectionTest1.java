package com.yang.test;

import com.yang.util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author yg
 * @date 2020/3/24 15:43
 */
public class ConnectionTest1 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String user = (String) properties.get("user");
            String password = (String) properties.get("password");
            String url = (String) properties.get("url");
            String driver = (String) properties.get("driver");

            // 加载驱动
            Class.forName(driver);

            //获取连接
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);

            String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "是是是");
            preparedStatement.setString(2, "sad@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("2001-02-02");
            preparedStatement.setDate(3, new Date(date.getTime()));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public void Update(String sql, Object...args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }

    public <T> T getInstance(Class T, String sql, Object ...args) {
        return null;
    }
}
