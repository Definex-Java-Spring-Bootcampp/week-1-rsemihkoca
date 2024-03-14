package com.patika.kredinbizdenservice.model.Loan;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VehicleStatuType;

import java.math.BigDecimal;

public class VehicleLoan extends Loan {

    private LoanType loanType = LoanType.ARAC_KREDISI;
    private VehicleStatuType VehicleStatuType;

    public VehicleLoan() {

    }

    public VehicleLoan(BigDecimal amount, Integer installment, Double interestRate) {
        super(amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        //istediği kadar ödeme yapabilir.
    }
}
