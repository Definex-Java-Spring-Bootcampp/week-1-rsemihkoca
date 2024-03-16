package com.rsemihkoca.onlinealisveris.model;

import com.rsemihkoca.onlinealisveris.enums.Category;
import lombok.Getter;

public class Product {

    private String name;
    @Getter
    private double price;
    private int stock;
    private Category category;


    private Product(String name, double price, int stock, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;

    }

    public static Product create(String name, double price, int stock, Category category) {
        return new Product(name, price, stock, category);
    }

}
