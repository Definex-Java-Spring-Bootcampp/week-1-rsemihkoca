package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.Loan.Loan;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {

    private String name;
    private String location;
    private static List<Loan> loanList = new ArrayList<>();
    @Getter
    private static List<CreditCard> creditCards = new ArrayList<>();

    public static void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    public Bank(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public static void addLoan(Loan loan) {
        loanList.add(loan);
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
                new Bank("Yapı Kredi", "Istanbul"),
                new Bank("Ziraat", "Ankara"),
                new Bank("Vakıf", "Ankara"),
                new Bank("Halk", "Ankara"),
                new Bank("TEB", "Istanbul"),
                new Bank("ING", "Istanbul"),
                new Bank("QNB Finansbank", "Istanbul"),
                new Bank("Denizbank", "Istanbul")
        );

        return banks.get(random.nextInt(banks.size()));


    }
}
