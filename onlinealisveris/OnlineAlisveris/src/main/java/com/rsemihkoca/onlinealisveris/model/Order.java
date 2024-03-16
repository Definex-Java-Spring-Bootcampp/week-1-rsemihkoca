package com.rsemihkoca.onlinealisveris.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Order {

    @Getter @Setter
    private Invoice invoice;
    @Getter @Setter
    private List<Product> products;

    private Order(Invoice invoice, List<Product> products) {
        this.invoice = invoice;
        this.products = products;
    }

    public static Order create(Invoice invoice, List<Product> products) {
        return new Order(invoice, products);
    }
}
