package com.yang.springboot.exception;

/**
 * @author yg
 * @date 2020/5/6 17:02
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
