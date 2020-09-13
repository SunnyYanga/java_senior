package com.yang.dao;

import com.yang.domain.User;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/19 17:15
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    void saveUser(User user);
}
