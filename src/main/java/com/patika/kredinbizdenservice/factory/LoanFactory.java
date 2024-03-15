package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Loan.ConsumerLoan;
import com.patika.kredinbizdenservice.model.Loan.HouseLoan;
import com.patika.kredinbizdenservice.model.Loan.Loan;
import com.patika.kredinbizdenservice.model.Loan.VehicleLoan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanFactory{

    private static volatile LoanFactory instance;
    private List<Loan> loanList = new ArrayList<>();

    private LoanFactory() {
    }

    public static LoanFactory getInstance() {
        if (instance == null) {
            synchronized (LoanFactory.class) {
                if (instance == null) {
                    instance = new LoanFactory();
                }
            }
        }
        return instance;
    }

    public Loan create(LoanType loanType, BigDecimal amount, Integer installment, Double interestRate, Bank bank) {

        Loan loan = switch (loanType) {
            case IHTIYAC_KREDISI -> ConsumerLoan.create(amount, installment, interestRate, bank);
            case KONUT_KREDISI -> HouseLoan.create(amount, installment, interestRate, bank);
            case ARAC_KREDISI -> VehicleLoan.create(amount, installment, interestRate, bank);
        };

        loanList.add(loan);

        return loan;

    }

    public Loan createRandom(LoanType loanType) {

        Loan loan = switch (loanType) {
            case IHTIYAC_KREDISI -> ConsumerLoan.createRandom();
            case KONUT_KREDISI -> HouseLoan.createRandom();
            case ARAC_KREDISI -> VehicleLoan.createRandom();
        };

        loanList.add(loan);

        return loan;

    }
}
