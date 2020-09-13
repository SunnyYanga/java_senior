package com.yang.test;

import com.yang.dao.UserDao;
import com.yang.dao.impl.UserDaoImpl;
import com.yang.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yg
 * @date 2020/4/7 18:04
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "admin1", "123456", "admin@126.com")));
    }
}