package com.patika.kredinbizdenservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Report {

    /*

        En çok başvuru yapan kullanıcıyı bulan methodu yazın.
    4. En yüksek kredi isteyen kullanıcıyı ve istediği tutarı bulan methodu yazın.
    5. Son bir aylık yapılan başvuruları listeleyen methodu yazın.
    6. Kampanya sayısı en çoktan aza doğru olacak şekilde kredi kartı tekliflerini listeleyen
    methodu yazın.
    7. cemdrman@gmail.com mail adresine sahip kullanıcının bütün başvurularını
    listeleyen methodu yazın.(Parametrik şekilde çalışmalıdır.)
    */

    public static User findMostAppliedUser() {
        // En çok başvuru yapan kullanıcıyı bulan methodu yazın.

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

    // 4. En yüksek kredili application:
    public static Application findHighestCreditApplication() {
        return User.getApplicationList()
                .stream()
                .max((o1, o2) -> o1.getLoan().getAmount().compareTo(o2.getLoan().getAmount()))
                .get();
    }

    //5. Son bir aylık yapılan başvuruları listeleyen methodu yazın.
    public static List<Application> findLastMonthApplications() {
        return User.getApplicationList()
                .stream()
                .filter(application -> application.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.toList());
    }

    //  İçindeki Kampanya sayısı en çoktan aza doğru olacak şekilde kredi kartı tekliflerini listeleyen
    //methodu yazın
    public static List<CreditCard> listCreditCardOffersByCampaignCount() {
        return Bank.getCreditCards()
                .stream()
                .sorted((o1, o2) -> o2.getCampaignList().size() - o1.getCampaignList().size())
                .collect(Collectors.toList());
    }

    // 7. List all applications for a given email address
    public static List<Application> listApplicationsByEmail(String email) {
        return User.getApplicationList()
                .stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .collect(Collectors.toList());
    }
}

