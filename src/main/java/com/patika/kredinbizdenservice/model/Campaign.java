package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.factory.BankFactory;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Campaign {

    private String title;
    private String content;
    private LocalDate dueDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private SectorType sector;
    @Getter
    private Bank bank;

    private Campaign(Bank bank, String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
        this.bank = bank;
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.sector = sector;
    }

    public static Campaign create(Bank bank, String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
        return new Campaign(bank, title, content, dueDate, createDate, updateDate, sector);
    }

    public static Campaign createRandom() {

        List<Campaign> campaignList = new ArrayList<>(List.of(
                Campaign.create(
                        BankFactory.getInstance().createRandom(),
                        "Yeni Nesil Akıllı Telefon Lansmanı",
                        "Yüksek performanslı, uygun fiyatlı akıllı telefonun lansmanı.",
                        LocalDate.of(2024, 6, 1),
                        LocalDate.of(2024, 3, 1),
                        LocalDate.of(2024, 3, 15),
                        SectorType.TECHNOLOGY
                ),
                Campaign.create(
                        BankFactory.getInstance().createRandom(),
                        "Kanserle Mücadele Bilinçlendirme Kampanyası",
                        "Kanserle mücadelede erken teşhisin önemini vurgulayan bir kampanya.",
                        LocalDate.of(2024, 10, 1),
                        LocalDate.of(2024, 2, 15),
                        LocalDate.of(2024, 3, 10),
                        SectorType.HEALTH
                ),
                Campaign.create(
                        BankFactory.getInstance().createRandom(),
                        "Yaratıcı Yazarlık Kursu Lansmanı",
                        "Yaratıcı yazarlık becerilerini geliştirmek için yeni bir kursun lansmanı.",
                        LocalDate.of(2024, 8, 1),
                        LocalDate.of(2024, 3, 1),
                        LocalDate.of(2024, 3, 20),
                        SectorType.EDUCATION
                ),
                Campaign.create(
                        BankFactory.getInstance().createRandom(),
                        "Yazılım Güncellemesi: Yeni Özelliklerle Güncellendi",
                        "Müşterilerimize daha iyi hizmet verebilmek için yeni yazılım güncellememizin tanıtımı.",
                        LocalDate.of(2024, 5, 1),
                        LocalDate.of(2024, 3, 1),
                        LocalDate.of(2024, 3, 18),
                        SectorType.TECHNOLOGY
                ),
                Campaign.create(
                        BankFactory.getInstance().createRandom(),
                        "İstanbul Turlarıyla Taksim'i Gezin",
                        "Cumhuriyet'in 100. yılını kutlamak, halkı teşvik etmek.",
                        LocalDate.of(2024, 7, 1),
                        LocalDate.of(2024, 3, 1),
                        LocalDate.of(2024, 3, 16),
                        SectorType.TRAVELS
                )
        ));
        Campaign campaign = campaignList.get((int) (Math.random() * campaignList.size()));
        campaignList.remove(campaign);
        return campaign;

    }

    @Override
    public String toString() {
        return "Campaign{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dueDate=" + dueDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sector=" + sector +
                '}';
    }
}
