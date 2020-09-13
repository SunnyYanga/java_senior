package com.yang.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yg
 * @date 2020/5/1 12:02
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }


    @Override
    public boolean isSingleton() {
        return true;
    }
}
