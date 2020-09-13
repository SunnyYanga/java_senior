package com.yang.test;

import com.yang.pojo.User;
import com.yang.UserService;
import com.yang.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author yg
 * @date 2020/4/7 18:29
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "tom", "666666", "tom@qq.com"));
        userService.registerUser(new User(null, "carl", "666666", "carl@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "111111", "123@qq.com")));
    }

    @Test
    public void existsUsername() {
    }
}