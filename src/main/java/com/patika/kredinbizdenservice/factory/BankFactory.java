package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Bank;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankFactory {

    private static volatile BankFactory instance;
    @Getter private Set<Bank> bankList = new HashSet<>();



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

        if (bank == null) {
            return bankList.stream().findAny().orElse(null);
        }

        bankList.add(bank);
        return bank;
    }

    public void createRandomBanks(int count) {
        for (int i = 0; i < count; i++) {
            createRandom();
        }
    }
}
