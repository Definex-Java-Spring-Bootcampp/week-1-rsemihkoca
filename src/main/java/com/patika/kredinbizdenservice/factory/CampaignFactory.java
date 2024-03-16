package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CampaignFactory {

    private static volatile CampaignFactory instance;
    private List<Campaign> campaignList = new ArrayList<>();

    private CampaignFactory() {
    }

    public static CampaignFactory getInstance() {
        if (instance == null) {
            synchronized (CampaignFactory.class) {
                if (instance == null) {
                    instance = new CampaignFactory();
                }
            }
        }
        return instance;
    }

    public Campaign create(Bank bank, String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
        Campaign campaign = Campaign.create(bank, title, content, dueDate, createDate, updateDate, sector);

        bank.addCampaign(campaign);
        campaignList.add(campaign);
        return campaign;
    }

    public Campaign createRandom() {
        Campaign campaign = Campaign.createRandom();

        campaign.getBank().addCampaign(campaign);
        campaignList.add(campaign);
        return campaign;
    }

    public void createRandomCampaigns(int count) {

        for (int i = 0; i < count; i++) {
            createRandom();
        }

    }
}
