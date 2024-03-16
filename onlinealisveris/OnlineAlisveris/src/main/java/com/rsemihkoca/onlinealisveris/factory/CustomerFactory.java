package com.rsemihkoca.onlinealisveris.factory;

import com.rsemihkoca.onlinealisveris.model.Customer;
import com.rsemihkoca.onlinealisveris.model.Order;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerFactory {

    private static volatile CustomerFactory instance;
    @Getter
    private List<Customer> customerList = new ArrayList<>();

    private CustomerFactory() {
    }

    public static CustomerFactory getInstance() {
        if (instance == null) {
            synchronized (CustomerFactory.class) {
                if (instance == null) {
                    instance = new CustomerFactory();
                }
            }
        }
        return instance;
    }

    public void create(String name, Integer age, List<Order> orders) {

        Customer customer = Customer.create(name, age, orders);
        customerList.add(customer);

    }

    public void createRandomCustomers() {
        Integer age =  new Random().nextInt(18, 100);
        String name = "Customer " + age;
        List<Order> orders = OrderFactory.getInstance().createRandomOrders();
        create(name, age, orders);
    }

    public void createRandomCustomers(int count) {
        for (int i = 0; i < count; i++) {
            createRandomCustomers();
        }
    }


}
