package com.yang;

import com.yang.pojo.User;

/**
 * @author yg
 * @date 2020/4/7 18:20
 */
public interface UserService {

    public void registerUser(User user);

    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
