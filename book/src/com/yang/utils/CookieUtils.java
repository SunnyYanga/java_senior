package com.yang.utils;

import javax.servlet.http.Cookie;

/**
 * @author yg
 * @date 2020/4/14 18:29
 */
public class CookieUtils {
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}