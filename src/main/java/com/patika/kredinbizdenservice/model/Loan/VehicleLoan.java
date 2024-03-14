package com.patika.kredinbizdenservice.model.Loan;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VehicleStatusType;
import com.patika.kredinbizdenservice.model.Bank;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Random;

public class VehicleLoan extends Loan {

    @Getter private LoanType loanType = LoanType.ARAC_KREDISI;
    private VehicleStatusType VehicleStatusType;

    public VehicleLoan(BigDecimal amount, Integer installment, Double interestRate, Bank bank) {
        super(amount, installment, interestRate, bank);
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        //istediği kadar ödeme yapabilir.
    }

    public static VehicleLoan createRandom() {
        Random random = new Random();
        BigDecimal amount = new BigDecimal(random.nextInt(50_000, 200_000));
        int installment = random.nextInt(1, 120);
        double interestRate = random.nextDouble();
        Bank bank = Bank.createRandom();
        return new VehicleLoan(amount, installment, interestRate, bank);
    }
}
