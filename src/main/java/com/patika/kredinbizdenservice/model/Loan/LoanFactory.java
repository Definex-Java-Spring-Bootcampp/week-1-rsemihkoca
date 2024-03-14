package com.patika.kredinbizdenservice.model.Loan;

import com.patika.kredinbizdenservice.enums.LoanType;

public class LoanFactory {

    public static Loan createLoan(LoanType loanType) {
        switch (loanType) {
            case IHTIYAC_KREDISI:
                return ConsumerLoan.createRandom();
            case KONUT_KREDISI:
                return HouseLoan.createRandom();
            case ARAC_KREDISI:
                return VehicleLoan.createRandom();
            default:
                throw new IllegalArgumentException("Unexpected value: " + loanType);
        }
    }

}
