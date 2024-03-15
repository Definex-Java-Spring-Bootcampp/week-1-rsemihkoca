package com.patika.kredinbizdenservice.factory;

import java.util.ArrayList;
import java.util.List;

public class GenericFactory<T> {

    private static volatile GenericFactory<?> instance;

    private final List<T> itemList = new ArrayList<>();

    private GenericFactory() {
    }

    public static synchronized <T> GenericFactory<T> getInstance(Class<T> clazz) {
        if (instance == null) {
            synchronized (GenericFactory.class) {
                if (instance == null) {
                    instance = new GenericFactory<>();
                }
            }
        }
        return (GenericFactory<T>) instance;
    }

    public T create(T item) {
        itemList.add(item);
        return item;
    }

    public T createRandom(T item) {
        // Assuming you have a method to create a random instance
        // or you can pass additional parameters to generate random data
        // for now, just adding the item passed
        itemList.add(item);
        return item;
    }
}
