package com.yang.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yg
 * @date 2020/3/20 8:50
 */
public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        // 1.通过反射，创建Person类的对象
        // 方式一：调用运行时类的属性: .class
        Class<Person> personClass = Person.class;
        // 方式二： 通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        // 方式三： 调用Class的静态方法: forName(String classPath)
        Class clazz3 = Class.forName("com.yang.test.Person");
        // 方式四：使用类的加载器 ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.yang.test.Person");

        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        Person person = (Person) tom;
        System.out.println(person.toString());

        // 2.通过反射调用对象指定的属性方法
        Field age = personClass.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person.toString());

        Method show = personClass.getDeclaredMethod("show");
        show.invoke(person);

        // 通过反射，可以调用Person类私有结构，比如：私有的构造器、方法、属性
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person person1 = declaredConstructor.newInstance("Jerry");
        System.out.println(person1);

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "HanMeimei");
        System.out.println(person1);

        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1, "中国");
        System.out.println(nation);
    }
}
