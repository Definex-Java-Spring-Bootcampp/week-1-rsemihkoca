package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.factory.ApplicationFactory;
import com.patika.kredinbizdenservice.factory.CreditCardFactory;
import com.patika.kredinbizdenservice.factory.UserFactory;

import java.time.LocalDateTime;
import java.util.List;

public class Report {

    public static User findMostAppliedUser() {

        User user = UserFactory.getInstance().getUserList()
                .stream()
                .max((o1, o2) -> (int) (o1.getApplicationList().stream().count() - o2.getApplicationList().stream().count()))
                .get();

        return user;
    }

    public static Application findHighestCreditApplication() {

        Application application = ApplicationFactory.getInstance().getApplicationList()
                .stream()
                .max((o1, o2) -> o1.getLoan().getAmount().compareTo(o2.getLoan().getAmount()))
                .get();

        return application;
    }

    public static List<Application> findLastMonthApplications() {

        List<Application> applicationList =  ApplicationFactory.getInstance().getApplicationList()
                .stream()
                .filter(application -> application.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(1)))
                .toList();

        return applicationList;
    }

    public static List<CreditCard> listCreditCardOffersByCampaignCount() {
//        return Bank.getCreditCards()
//                .stream()
//                .sorted((o1, o2) -> o2.getCampaignList().size() - o1.getCampaignList().size())
//                .collect(Collectors.toList());

        return CreditCardFactory.getInstance().getCreditCardList()
                .stream()
                .sorted((o1, o2) -> o2.getBank().getCampaignList().size() - o1.getBank().getCampaignList().size())
                .toList();


    }

    public static List<Application> listApplicationsByEmail(String email) {
//        return User.getApplicationList()
//                .stream()
//                .filter(application -> application.getUser().getEmail().equals(email))
//                .collect(Collectors.toList());
//    }
        return ApplicationFactory.getInstance().getApplicationList()
                .stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .toList();
    }
}

