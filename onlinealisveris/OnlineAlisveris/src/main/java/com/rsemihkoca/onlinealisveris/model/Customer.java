package com.rsemihkoca.onlinealisveris.model;

import lombok.Getter;

import java.util.List;

public class Customer {

    @Getter
    private String name;
    @Getter
    private Integer age;
    @Getter
    private List<Order> orders;


    private Customer(String name, Integer age, List<Order> orders) {
        this.name = name;
        this.age = age;
        this.orders = orders;
    }

    public static Customer create(String name, Integer age, List<Order> orders) {
        return new Customer(name, age, orders);
    }
}
