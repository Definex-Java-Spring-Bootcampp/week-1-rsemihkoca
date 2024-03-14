package com.patika.kredinbizdenservice.model.Loan;



import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.Bank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class HouseLoan extends Loan {

    private LoanType loanType = LoanType.KONUT_KREDISI;

    public HouseLoan(BigDecimal amount, Integer installment, Double interestRate, Bank bank) {
        super(amount, installment, interestRate, bank);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {

    }

    public static HouseLoan createRandom() {
        Random random = new Random();
        BigDecimal amount = new BigDecimal(random.nextInt(10_000, 10_000_000));
        int installment = random.nextInt(1, 120);
        double interestRate = random.nextDouble();
        Bank bank = Bank.createRandom();
        return new HouseLoan(amount, installment, interestRate, bank);
    }
}
