package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankFactory {

    private static volatile BankFactory instance;
    private List<Bank> bankList = new ArrayList<>();

    private BankFactory() {
    }

    public static BankFactory getInstance() {
        if (instance == null) {
            synchronized (BankFactory.class) {
                if (instance == null) {
                    instance = new BankFactory();
                }
            }
        }
        return instance;
    }

    public Bank create(String name, String location) {
        Bank bank = Bank.create(name, location);
        bankList.add(bank);
        return bank;
    }

    public Bank createRandom() {
        Bank bank = Bank.createRandom();
        bankList.add(bank);
        return bank;
    }
}
