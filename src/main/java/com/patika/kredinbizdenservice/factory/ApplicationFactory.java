package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationFactory {

    private static volatile ApplicationFactory instance;
    private List<Application> applicationList = new ArrayList<>();

    private ApplicationFactory() {
    }

    public static ApplicationFactory getInstance() {
        if (instance == null) {
            synchronized (ApplicationFactory.class) {
                if (instance == null) {
                    instance = new ApplicationFactory();
                }
            }
        }
        return instance;
    }

    public Application create(Loan loan, User user, LocalDateTime localDateTime) {

        Application application = Application.create(loan, user, localDateTime);

        applicationList.add(application);
        return application;

    }

    public Application createRandom(Loan loan, User user) {

        Application application = Application.createRandom(loan, user);

        applicationList.add(application);
        return application;

    }
}
