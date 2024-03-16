package com.rsemihkoca.onlinealisveris;

import com.rsemihkoca.onlinealisveris.Report.Report;
import com.rsemihkoca.onlinealisveris.factory.CustomerFactory;
import com.rsemihkoca.onlinealisveris.factory.InvoiceFactory;
import com.rsemihkoca.onlinealisveris.factory.OrderFactory;
import com.rsemihkoca.onlinealisveris.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OnlineAlisverisApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlineAlisverisApplication.class, args);

        CustomerFactory customerFactory = CustomerFactory.getInstance();
        CustomerFactory customerFactory1 = CustomerFactory.getInstance();
        System.out.printf("customerFactory == customerFactory1: %b%n", customerFactory == customerFactory1);

        OrderFactory orderFactory = OrderFactory.getInstance();
        OrderFactory orderFactory1 = OrderFactory.getInstance();
        System.out.printf("orderFactory == orderFactory1: %b%n", orderFactory == orderFactory1);

        InvoiceFactory invoiceFactory = InvoiceFactory.getInstance();
        InvoiceFactory invoiceFactory1 = InvoiceFactory.getInstance();
        System.out.printf("invoiceFactory == invoiceFactory1: %b%n", invoiceFactory == invoiceFactory1);

        customerFactory.createRandomCustomers(15);


        String name = "Cem";
        Integer age = 30;
        List<Order > orders = orderFactory.createRandomOrders();
        customerFactory.create(name, age, orders);

        String name2 = "Cem";
        Integer age2 = 25;
        List<Order > orders2 = orderFactory.createRandomOrders();
        customerFactory.create(name2, age2, orders2);

        String name3 = "Cem";
        Integer age3 = 28;
        List<Order > orders3 = orderFactory.createRandomOrders();
        customerFactory.create(name3, age3, orders3);

        String name4 = "Cem";
        Integer age4 = 27;
        List<Order > orders4 = orderFactory.createRandomOrders();
        customerFactory.create(name4, age4, orders4);


        System.out.println("Sistemdeki bütün müşterisi sayısı: " + Report.findTotalCustomerCount());
        System.out.println("İsmi Cem olan müşterilerin aldıkları total ürün sayısı: " + Report.findTotalProductCountByCustomerName("Cem"));
        System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı: " + Report.findTotalAmountByCustomerNameWithCondition("Cem"));
        System.out.println("Sistemdeki 1500 TL üzerindeki faturalar: " + Report.findInvoiceWithTotalAmountAbove(1500));





    }

}
