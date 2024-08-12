package com.ohgiraffers.pikka_backserver.curation.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class CurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curation_category")
    private String category;

    @Column(name = "curation_title")
    private String title;

    @CreationTimestamp
    @Column(name = "curation_date")
    private LocalDate date;



    public CurationEntity() {

    }


    public CurationEntity(Long id, String category, String title, LocalDate date) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
