package com.rsemihkoca.onlinealisveris.factory;

import com.rsemihkoca.onlinealisveris.enums.Category;
import com.rsemihkoca.onlinealisveris.model.Invoice;
import com.rsemihkoca.onlinealisveris.model.Order;
import com.rsemihkoca.onlinealisveris.model.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class OrderFactory {

    private static volatile OrderFactory instance;
    @Getter
    private List<Order> orderList = new ArrayList<>();

    private OrderFactory() {
    }

    public static OrderFactory getInstance() {
        if (instance == null) {
            synchronized (OrderFactory.class) {
                if (instance == null) {
                    instance = new OrderFactory();
                }
            }
        }
        return instance;
    }

    public Order create(Invoice invoice, List<Product> products) {
        Order order = Order.create(invoice, products);
        orderList.add(order);
        return order;

    }

    public Order createRandomOrder() {
        List<Product> products = new ArrayList<>();
        Invoice invoice = InvoiceFactory.getInstance().createRandomInvoice();
        int numberOfProducts = new Random().nextInt(1, 35);
        IntStream.range(0, numberOfProducts)
                .forEach(i -> {
                    Product product = ProductFactory.getInstance().createRandomProduct();
                    invoice.add(product.getPrice());
                    products.add(product);
                });
        return create(invoice, products);
    }

    public List<Order> createRandomOrders() {
        List<Order> orders = new ArrayList<>();
        int numberOfOrders = new Random().nextInt(1, 25);
        IntStream.range(0, numberOfOrders)
                .forEach(i -> {
                    orders.add(createRandomOrder());
                });
        return orders;
    }


}
