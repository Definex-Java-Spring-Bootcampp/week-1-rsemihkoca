package com.rsemihkoca.onlinealisveris.model;

import lombok.Getter;

public class Invoice {

    private int id;
    @Getter
    private double total = 0;

    public void add(double amount) {
        total += amount;
    }

    private Invoice(int id) {
        this.id = id;
    }

    public static Invoice create(int id) {
        return new Invoice(id);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", total=" + total +
                '}';
    }

}
