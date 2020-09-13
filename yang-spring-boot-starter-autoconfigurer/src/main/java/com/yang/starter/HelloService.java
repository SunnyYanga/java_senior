package com.yang.starter;

/**
 * @author yg
 * @date 2020/7/12 15:25
 */
public class HelloService {

    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloYang(String name) {
        return helloProperties.getPrefix() + "-" + name + "" + helloProperties.getSuffix();
    }
}
