package com.yang.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yg
 * @date 2020/3/21 12:59
 */
interface Human {
    String getBelief();
    void eat(String food);
}


class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}


class ProxyFactory {
    // 调用此方法，返回一个代理类对象
    public static Object getProxyInstance(Object obj) {  //obj 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}


class MyInvocationHandler implements InvocationHandler {

    private Object obj; //需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 通过代理类的对象调用方法a时，就会自动地调用如下方法：invoke()
    // 将被代理类要执行的方法a声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method即为代理类调用的方法，此方法也就作为了被代理类要调用的方法
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance:代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("apple");
    }
}
