package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.factory.*;
import com.patika.kredinbizdenservice.model.*;

import com.patika.kredinbizdenservice.model.Loan.Loan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication
public class KredinbizdenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KredinbizdenServiceApplication.class, args);

        UserFactory userFactory = UserFactory.getInstance();
        UserFactory userFactory2 = UserFactory.getInstance();
        System.out.printf("userFactory == userFactory2: %b%n", userFactory == userFactory2);

        LoanFactory loanFactory = LoanFactory.getInstance();
        LoanFactory loanFactory2 = LoanFactory.getInstance();
        System.out.printf("loanFactory == loanFactory2: %b%n", loanFactory == loanFactory2);

        BankFactory bankFactory = BankFactory.getInstance();
        BankFactory bankFactory2 = BankFactory.getInstance();
        System.out.printf("bankFactory == bankFactory2: %b%n", bankFactory == bankFactory2);

        ApplicationFactory applicationFactory = ApplicationFactory.getInstance();
        ApplicationFactory applicationFactory2 = ApplicationFactory.getInstance();
        System.out.printf("applicationFactory == applicationFactory2: %b%n", applicationFactory == applicationFactory2);

        CampaignFactory campaignFactory = CampaignFactory.getInstance();
        CampaignFactory campaignFactory2 = CampaignFactory.getInstance();
        System.out.printf("campaignFactory == campaignFactory2: %b%n", campaignFactory == campaignFactory2);

        CreditCardFactory creditCardFactory = CreditCardFactory.getInstance();
        CreditCardFactory creditCardFactory2 = CreditCardFactory.getInstance();
        System.out.printf("creditCardFactory == creditCardFactory2: %b%n", creditCardFactory == creditCardFactory2);


        User ali = userFactory.create("Ali", "Veli", LocalDate.of(1990, 1, 1), "aliveli@outlook.com", "123456", "1234567890", true);
        User cem = userFactory.create("Cem", "Dırman", LocalDate.of(1973, 1, 1), "cemdrman@gmail.com", "5d5d5", "5569987562", true);
        User zeynep = userFactory.create("Zeynep", "Yılmaz", LocalDate.of(1990, 1, 1), "zeynepyilmaz@example.com", "123456", "1234567890", true);
        User mehmet = userFactory.create("Mehmet", "Doe", LocalDate.of(1985, 7, 15), "mehmet.doe@example.com", "password123", "5551234567", true);
        User ahmet = userFactory.create("Ahmet", "Smith", LocalDate.of(1992, 3, 28), "ahmet.smith@example.com", "pass123", "5559876543", true);
        User selen = userFactory.create("Selen", "Johnson", LocalDate.of(1979, 11, 9), "selen.j@example.com", "selepassword", "5551112233", true);
        User melin = userFactory.create("Melin", "Brown", LocalDate.of(1988, 5, 4), "melin.b@example.com", "meliy123", "5554445566", true);
        User melun = userFactory.create("Melun", "Taylor", LocalDate.of(1995, 9, 20), "melun.taylor@example.com", "melupass*", "5558889999", true);


        List<Application> applications = new ArrayList<>();

        User[] users = {ali, cem, zeynep, mehmet, ahmet, selen, melin, melun};
        LoanType[] loans = {LoanType.IHTIYAC_KREDISI, LoanType.KONUT_KREDISI, LoanType.ARAC_KREDISI};

        for (User user : users) {
            for (LoanType loanType : loans) {
                Random random = new Random();
                int randInt = random.nextInt(3) + 1;
                for (int i = 0; i < randInt; i++) {
                    Loan loan = loanFactory.createRandom(loanType);
                    applicationFactory.createRandom(loan, user);
                }
            }
        }

        campaignFactory.createRandomCampaigns(25);

        creditCardFactory.createRandomCreditCards(150);


        System.out.println();
        System.out.println(Report.findMostAppliedUser());
        System.out.println(Report.findHighestCreditApplication());
        System.out.println(Report.findLastMonthApplications());
        System.out.println(Report.listCreditCardOffersByCampaignCount());
        System.out.println(Report.listApplicationsByEmail("cemdrman@gmail.com"));





    }

}
