package com.patika.kredinbizdenservice.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreditCard implements Product{

    private BigDecimal fee;
    private Bank bank;
    @Getter private Set<Campaign> campaignList;

    public CreditCard(BigDecimal fee, Set<Campaign> campaignList, Bank bank) {
        this.fee = fee;
        this.campaignList = campaignList;
        this.bank = bank;

        Bank.addCreditCard(this);
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + campaignList +
                ", bank=" + bank +
                '}';
    }
}
