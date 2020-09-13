package com.yang.jdbcTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author yg
 * @date 2020/4/26 8:48
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.cj.mysql.driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/");
//        ds.setUsername("root");
//        ds.setPassword("1234");
//
//        JdbcTemplate jt = new JdbcTemplate();
//        jt.setDataSource(ds);
//        jt.execute("insert into account(name, money) values ('ccc', 1000)");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext();
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        jt.execute("insert into account(name, money) values ('ccc', 1000)");
    }
}
