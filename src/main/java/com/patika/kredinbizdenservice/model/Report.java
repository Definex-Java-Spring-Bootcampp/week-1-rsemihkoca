package com.patika.kredinbizdenservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Report {

    public static User findMostAppliedUser() {

        User user = User.getApplicationList()
                .stream()
                .collect(Collectors.groupingBy(Application::getUser, Collectors.counting()))
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .get()
                .getKey();


        return user;
    }

    public static Application findHighestCreditApplication() {
        return User.getApplicationList()
                .stream()
                .max((o1, o2) -> o1.getLoan().getAmount().compareTo(o2.getLoan().getAmount()))
                .get();
    }

    public static List<Application> findLastMonthApplications() {
        return User.getApplicationList()
                .stream()
                .filter(application -> application.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.toList());
    }

    public static List<CreditCard> listCreditCardOffersByCampaignCount() {
        return Bank.getCreditCards()
                .stream()
                .sorted((o1, o2) -> o2.getCampaignList().size() - o1.getCampaignList().size())
                .collect(Collectors.toList());
    }

    public static List<Application> listApplicationsByEmail(String email) {
        return User.getApplicationList()
                .stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .collect(Collectors.toList());
    }
}

