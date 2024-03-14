package com.patika.kredinbizdenservice.model.Loan;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Product;
import lombok.Getter;

import java.math.BigDecimal;

public abstract class Loan implements Product {

    @Getter private BigDecimal amount;
    @Getter private Integer installment;
    @Getter private Bank bank;
    @Getter private Double interestRate;
    // private Campaign campaign; // kampanyalı kredileri üstte çıkart

    //sponsorlu kampanyaları üstte çıkart

    public Loan() {
    }

    public Loan(BigDecimal amount, Integer installment, Double interestRate, Bank bank) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
        this.bank = bank;

        Bank.addLoan(this);
    }

    abstract void calculate(BigDecimal amount, int installment);


    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", installment=" + installment +
                ", bank=" + bank +
                ", interestRate=" + interestRate +
                '}';
    }
}
