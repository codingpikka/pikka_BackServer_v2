package com.ohgiraffers.pikka_backserver.curation.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class CurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curation1")
    private String curation1;

    @Column(name = "curation_title")
    private String title;

    @CreationTimestamp
    @Column(name = "curation_date")
    private LocalDate date;



    public CurationEntity() {

    }

    public CurationEntity(Long id, String curation1, String title, LocalDate date) {
        this.id = id;
        this.curation1 = curation1;
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuration1() {
        return curation1;
    }

    public void setCuration1(String curation1) {
        this.curation1 = curation1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CurationEntity{" +
                "id=" + id +
                ", curation1='" + curation1 + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
