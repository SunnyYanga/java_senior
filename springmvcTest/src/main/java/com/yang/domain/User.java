package com.yang.domain;

import java.io.Serializable;

/**
 * @author yg
 * @date 2020/5/25 17:57
 */
public class User implements Serializable {
    private String uname;
    private Integer age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
