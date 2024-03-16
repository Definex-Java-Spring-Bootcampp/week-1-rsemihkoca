package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.Loan.Loan;
import lombok.Getter;

import java.util.*;

public class Bank {

    private String name;
    private String location;
    @Getter
    private Set<Loan> loanList = new HashSet<>();
    @Getter
    private Set<CreditCard> creditCardList = new HashSet<>();
    @Getter
    private Set<Campaign> campaignList = new HashSet<>();
    /* !!! bankalaarın hem credit cardları var hem de campaignları var*/

//    private static List<Bank> initializedBanks = new ArrayList<>(List.of(
//            Bank.create("Garanti", "Istanbul"),
//            Bank.create("Akbank", "Istanbul"),
//            Bank.create("Yapi Kredi", "Istanbul"),
//            Bank.create("Ziraat", "Ankara"),
//            Bank.create("Vakif Bank", "Istanbul"),
//            Bank.create("Halk Bank", "Ankara"),
//            Bank.create("Is Bank", "Istanbul"),
//            Bank.create("TEB", "Istanbul"),
//            Bank.create("QNB Finansbank", "Istanbul"),
//            Bank.create("Deniz Bank", "Istanbul")
//    ));
//    private static Random random = new Random();



    public void addCreditCard(CreditCard creditCard) {
        creditCardList.add(creditCard);
    }

    public void addCampaign(Campaign campaign) {
        campaignList.add(campaign);
    }

    public void addLoan(Loan loan) {
        loanList.add(loan);
    }
    private Bank(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
//                ", loanList=" + loanList +
                '}';
    }

    public static Bank create(String name, String location) {
        return new Bank(name, location);
    }

//    public static Bank createRandom() {
//
//        if (initializedBanks.isEmpty()) {
//            return null;
//        } else {
//            int randomIndex = random.nextInt(initializedBanks.size());
//            Bank bank = initializedBanks.get(randomIndex);
//            initializedBanks.remove(randomIndex);
//            return bank;
//
//        }


//    }
}
