package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.Loan.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {

    private String name;
    private String location;
    private static List<Loan> loanList = new ArrayList<>();

    private Bank(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
//                ", loanList=" + loanList +
                '}';
    }

    public static Bank createRandom() {
        Random random = new Random();
        List<Bank> banks = List.of(
                new Bank("Garanti", "Istanbul"),
                new Bank("Akbank", "Istanbul"),
                new Bank("TEB", "Istanbul"),
                new Bank("Isbank", "Istanbul")
        );

        return banks.get(random.nextInt(banks.size()));


    }
}
