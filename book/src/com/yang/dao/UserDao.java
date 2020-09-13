package com.yang.dao;

import com.yang.pojo.User;

/**
 * @author yg
 * @date 2020/4/7 17:43
 */
public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);
}
