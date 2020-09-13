package com.yang.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author yg
 * @date 2020/3/13 17:46
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add(123);
        System.out.println(collection.size());

        Collection collection1 = new ArrayList();
        collection1.add(456);
        collection.addAll(collection1);
        System.out.println(collection.isEmpty());
        collection.clear();
    }
}
