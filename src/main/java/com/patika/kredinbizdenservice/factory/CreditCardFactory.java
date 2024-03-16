package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.CreditCard;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreditCardFactory {

    private static volatile CreditCardFactory instance;
    @Getter private List<CreditCard> creditCardList = new ArrayList<>();

    private CreditCardFactory() {
    }

    public static CreditCardFactory getInstance() {
        if (instance == null) {
            synchronized (CreditCardFactory.class) {
                if (instance == null) {
                    instance = new CreditCardFactory();
                }
            }
        }
        return instance;
    }

    public CreditCard create(BigDecimal fee, Bank bank) {

        CreditCard creditCard = CreditCard.create(fee, bank);

        bank.addCreditCard(creditCard);
        creditCardList.add(creditCard);

        return creditCard;

    }

    public CreditCard createRandom() {

        CreditCard creditCard = CreditCard.createRandom();

        creditCard.getBank().addCreditCard(creditCard);
        creditCardList.add(creditCard);

        return creditCard;

    }

    public void createRandomCreditCards(int count) {

        for (int i = 0; i < count; i++) {
            createRandom();
        }

    }


}

