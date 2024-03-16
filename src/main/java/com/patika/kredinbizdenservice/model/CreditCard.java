package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.factory.BankFactory;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreditCard implements Product{

    private BigDecimal fee;
    @Getter private Bank bank;


    private CreditCard(BigDecimal fee, Bank bank) {
        this.fee = fee;
        this.bank = bank;
    }

    public static CreditCard create(BigDecimal fee, Bank bank) {
        return new CreditCard(fee, bank);
    }

    public static CreditCard createRandom() {
        return new CreditCard(BigDecimal.valueOf(100), BankFactory.getInstance().createRandom());
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + bank.getCampaignList() +
                ", bank=" + bank +
                '}';
    }
}
