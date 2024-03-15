package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.factory.LoanFactory;
import com.patika.kredinbizdenservice.factory.UserFactory;
import com.patika.kredinbizdenservice.model.*;
import com.patika.kredinbizdenservice.model.Loan.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

//@SpringBootApplication
public class KredinbizdenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KredinbizdenServiceApplication.class, args);


//        DataInitializer();
//        System.out.println();
//        System.out.println(Report.findMostAppliedUser());
//        System.out.println(Report.findHighestCreditApplication());
//        System.out.println(Report.findLastMonthApplications());
//        System.out.println(Report.listCreditCardOffersByCampaignCount());
//        System.out.println(Report.listApplicationsByEmail("cemdrman@gmail.com"));
        UserFactory userFactory = UserFactory.getInstance();
        UserFactory userFactory2 = UserFactory.getInstance();
        System.out.printf("userFactory == userFactory2: %b%n", userFactory == userFactory2);

        LoanFactory loanFactory = LoanFactory.getInstance();
        LoanFactory loanFactory2 = LoanFactory.getInstance();
        System.out.printf("loanFactory == loanFactory2: %b%n", loanFactory == loanFactory2);








    }

    private static void DataInitializer() {

//        User ali = new User("Ali", "Veli", LocalDate.of(1990, 1, 1), "aliveli@outlook.com", "123456", "1234567890", true);
//        User cem = new User("Cem", "Dırman", LocalDate.of(1973, 1, 1), "cemdrman@gmail.com", "5d5d5", "5569987562", true);
//        User zeynep = new User("Zeynep", "Yılmaz", LocalDate.of(1990, 1, 1), "zeynepyilmaz@example.com", "123456", "1234567890", true);
//        User mehmet = new User("Mehmet", "Doe", LocalDate.of(1985, 7, 15), "mehmet.doe@example.com", "password123", "5551234567", true);
//        User ahmet = new User("Ahmet", "Smith", LocalDate.of(1992, 3, 28), "ahmet.smith@example.com", "pass123", "5559876543", true);
//        User selen = new User("Selen", "Johnson", LocalDate.of(1979, 11, 9), "selen.j@example.com", "selepassword", "5551112233", true);
//        User melin = new User("Melin", "Brown", LocalDate.of(1988, 5, 4), "melin.b@example.com", "meliy123", "5554445566", true);
//        User melun = new User("Melun", "Taylor", LocalDate.of(1995, 9, 20), "melun.taylor@example.com", "melupass*", "5558889999", true);
//
//        List<Application> applications = new ArrayList<>();
//
//        User[] users = {ali, cem, zeynep, mehmet, ahmet, selen, melin, melun};
//        LoanType[] loans = {LoanType.IHTIYAC_KREDISI, LoanType.KONUT_KREDISI, LoanType.ARAC_KREDISI};
//
//        for (User user : users) {
//            for (LoanType loanType : loans) {
//                Random random = new Random();
//                int randInt = random.nextInt(3) + 1;
//                int[] arrayInt = new int[randInt];
//                for (int i : arrayInt){
//                    Loan loan = LoanFactory.createLoan(loanType);
//                     random time before 3 months to now
//                    LocalDateTime currentDateTime = LocalDateTime.now();
//                    LocalDateTime threeMonthsAgo = currentDateTime.minusMonths(3);
//                    long minSecond = threeMonthsAgo.atZone(ZoneId.systemDefault()).toEpochSecond();
//                    long maxSecond = currentDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
//                    long randomSecond = ThreadLocalRandom.current().nextLong(minSecond, maxSecond);
//                    LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomSecond, 0, ZoneOffset.UTC);
//
//                    applications.add(new Application(loan, user, randomDateTime)); // Use add method to add elements to the list
//
//                }
//            }
//        }
//
//        Campaign campaign1 = new Campaign(
//                "Yeni Nesil Akıllı Telefon Lansmanı",
//                "Yüksek performanslı, uygun fiyatlı akıllı telefonun lansmanı.",
//                LocalDate.of(2024, 6, 1),
//                LocalDate.of(2024, 3, 1),
//                LocalDate.of(2024, 3, 15),
//                SectorType.TECHNOLOGY
//        );
//
//        Campaign campaign2 = new Campaign(
//                "Kanserle Mücadele Bilinçlendirme Kampanyası",
//                "Kanserle mücadelede erken teşhisin önemini vurgulayan bir kampanya.",
//                LocalDate.of(2024, 10, 1),
//                LocalDate.of(2024, 2, 15),
//                LocalDate.of(2024, 3, 10),
//                SectorType.HEALTH
//        );
//
//         Kampanya 3: Eğitim Sektöründe Yeni Eğitim Programı Lansmanı
//        Campaign campaign3 = new Campaign(
//                "Yaratıcı Yazarlık Kursu Lansmanı",
//                "Yaratıcı yazarlık becerilerini geliştirmek için yeni bir kursun lansmanı.",
//                LocalDate.of(2024, 8, 1),
//                LocalDate.of(2024, 3, 1),
//                LocalDate.of(2024, 3, 20),
//                SectorType.EDUCATION
//        );
//
//         Kampanya 4: Teknoloji Sektöründe Yazılım Güncellemesi Tanıtımı
//        Campaign campaign4 = new Campaign(
//                "Yazılım Güncellemesi: Yeni Özelliklerle Güncellendi",
//                "Müşterilerimize daha iyi hizmet verebilmek için yeni yazılım güncellememizin tanıtımı.",
//                LocalDate.of(2024, 5, 1),
//                LocalDate.of(2024, 3, 1),
//                LocalDate.of(2024, 3, 18),
//                SectorType.TECHNOLOGY
//        );
//
//         Kampanya 5: Sağlık Sektöründe Aşı Kampanyası
//        Campaign campaign5 = new Campaign(
//                "İstanbul Turlarıyla Taksim'i Gezin",
//                "Cumhuriyet'in 100. yılını kutlamak, halkı teşvik etmek.",
//                LocalDate.of(2024, 7, 1),
//                LocalDate.of(2024, 3, 1),
//                LocalDate.of(2024, 3, 16),
//                SectorType.TRAVELS
//        );
//
//        CreditCard card1 = new CreditCard(BigDecimal.valueOf(5), Set.of(campaign1, campaign2), Bank.createRandom());
//        CreditCard card2 = new CreditCard(BigDecimal.valueOf(10), Set.of(campaign1, campaign2, campaign3, campaign4), Bank.createRandom());
//        CreditCard card3 = new CreditCard(BigDecimal.valueOf(150), Set.of(campaign1), Bank.createRandom());
//        CreditCard card4 = new CreditCard(BigDecimal.valueOf(1), Set.of(campaign1, campaign3, campaign5), Bank.createRandom());
//        CreditCard card5 = new CreditCard(BigDecimal.valueOf(895), Set.of(campaign1, campaign2, campaign3, campaign4, campaign5), Bank.createRandom());
    }

}
