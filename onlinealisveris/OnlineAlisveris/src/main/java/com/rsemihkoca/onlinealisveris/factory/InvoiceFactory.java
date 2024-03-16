package com.rsemihkoca.onlinealisveris.factory;

import com.rsemihkoca.onlinealisveris.enums.Category;
import com.rsemihkoca.onlinealisveris.model.Invoice;
import com.rsemihkoca.onlinealisveris.model.Invoice;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceFactory {

    private static volatile InvoiceFactory instance;
    @Getter
    private List<Invoice> invoiceList = new ArrayList<>();

    private InvoiceFactory() {
    }

    public static InvoiceFactory getInstance() {
        if (instance == null) {
            synchronized (InvoiceFactory.class) {
                if (instance == null) {
                    instance = new InvoiceFactory();
                }
            }
        }
        return instance;
    }

    public Invoice create(int id) {

        Invoice invoice = Invoice.create(id);
        invoiceList.add(invoice);

        return invoice;
    }

    public Invoice createRandomInvoice() {
        int id = new Random().nextInt(1, 500);
        return create(id);
    }

    public void createRandomInvoices(int count) {
        for (int i = 0; i < count; i++) {
            createRandomInvoice();
        }
    }


}
