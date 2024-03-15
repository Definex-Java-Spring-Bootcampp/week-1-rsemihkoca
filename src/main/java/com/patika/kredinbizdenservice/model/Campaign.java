package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.SectorType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Campaign {

    private String title;
    private String content;
    private LocalDate dueDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private SectorType sector;

    private Campaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.sector = sector;
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
