package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import com.patika.kredinbizdenservice.model.Loan.Loan;
import lombok.Getter;

import java.time.LocalDateTime;

public class Application {

    @Getter private Loan loan;
    private Product product;
    @Getter private User user;
    @Getter private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;

        // add application list into user's application list
        User.getApplicationList().add(this);
    }

    public Application(Loan loan, User user, LocalDateTime localDateTime) {
        this.loan = loan;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;

        User.addApplication(this);
    }



    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
