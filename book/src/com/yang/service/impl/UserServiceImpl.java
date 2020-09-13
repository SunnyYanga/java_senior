package com.yang.service.impl;

import com.yang.dao.UserDao;
import com.yang.dao.impl.UserDaoImpl;
import com.yang.pojo.User;
import com.yang.UserService;

/**
 * @author yg
 * @date 2020/4/7 18:25
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
