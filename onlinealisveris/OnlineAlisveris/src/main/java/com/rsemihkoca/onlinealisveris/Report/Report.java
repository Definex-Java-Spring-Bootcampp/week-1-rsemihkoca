package com.rsemihkoca.onlinealisveris.Report;

import com.rsemihkoca.onlinealisveris.factory.CustomerFactory;
import com.rsemihkoca.onlinealisveris.factory.InvoiceFactory;
import com.rsemihkoca.onlinealisveris.model.Invoice;

import java.util.List;

public class Report {

    public static Integer findTotalCustomerCount() {

        return CustomerFactory.getInstance().getCustomerList().size();
    }

    public static Integer findTotalProductCountByCustomerName(String name) {
        // there is many cem in the system
        // a order may have multiple products and a customer may have multiple orders
        return CustomerFactory.getInstance().getCustomerList().stream()
                .filter(customer -> customer.getName().equals(name))
                .map(customer -> customer.getOrders().stream().mapToInt(order -> order.getProducts().size()).sum())
                .reduce(0, Integer::sum);
    }

    public static Double findTotalAmountByCustomerNameWithCondition(String name) {
        return CustomerFactory.getInstance().getCustomerList().stream()
                .filter(customer -> customer.getName().equals(name))
                .filter(customer -> customer.getAge() > 25 && customer.getAge() < 30)
                .flatMap(customer -> customer.getOrders().stream())
                .map(order -> order.getInvoice().getTotal())
                .reduce(0.0, Double::sum);
    }

    public static List<Invoice> findInvoiceWithTotalAmountAbove(Integer totalAmount) {
        return InvoiceFactory.getInstance().getInvoiceList().stream()
                .filter(invoice -> invoice.getTotal()>totalAmount)
                .toList();

    }
}
