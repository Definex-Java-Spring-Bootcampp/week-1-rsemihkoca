package com.rsemihkoca.onlinealisveris.factory;

import com.rsemihkoca.onlinealisveris.enums.Category;
import com.rsemihkoca.onlinealisveris.model.Customer;
import com.rsemihkoca.onlinealisveris.model.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductFactory {

    private static volatile ProductFactory instance;
    @Getter
    private List<Product> productList = new ArrayList<>();

    private ProductFactory() {
    }

    public static ProductFactory getInstance() {
        if (instance == null) {
            synchronized (ProductFactory.class) {
                if (instance == null) {
                    instance = new ProductFactory();
                }
            }
        }
        return instance;
    }

    public Product create(String name, double price, int stock, Category category) {

        Product product = Product.create(name, price, stock, category);
        productList.add(product);
        return product;

    }

    public Product createRandomProduct() {
        int stock = new Random().nextInt(1, 100);
        double price = new Random().nextDouble() * 100;
        String name = "Product " + stock;
        Category category = Category.values()[new Random().nextInt(Category.values().length)];
        return create(name, price, stock, category);
    }

    public void createRandomProducts(int count) {
        for (int i = 0; i < count; i++) {
            createRandomProduct();
        }
    }


}
