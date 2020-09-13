package com.yang.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author yg
 * @date 2020/4/30 15:16
 */
public class Person {

    // 1.基本数值
    // 2. SpEL #{}
    // 3. ${} 取出配置文件【properties】的值 (在运行环境变量里的值)
    @Value("llll")
    private String name;
    @Value("#{20-2}")
    private String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
