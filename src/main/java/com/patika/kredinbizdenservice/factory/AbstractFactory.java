package com.patika.kredinbizdenservice.factory;

public abstract class AbstractFactory<T> {

    public abstract T create(String... args);

    public abstract T createRandom(String... args);

}
