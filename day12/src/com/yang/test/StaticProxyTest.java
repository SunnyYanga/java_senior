package com.yang.test;

/**
 * @author yg
 * @date 2020/3/21 12:48
 */
interface ClothFactory {
    void produceCloth();
}


class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理工厂收尾工作");
    }
}


class Nike implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("nik工厂");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        Nike nike = new Nike();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
