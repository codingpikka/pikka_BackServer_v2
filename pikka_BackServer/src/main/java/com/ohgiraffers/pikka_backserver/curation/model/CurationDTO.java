package com.ohgiraffers.pikka_backserver.curation.model;

import java.time.LocalDate;

public class CurationDTO {
    private Long id;
    private String category;
    private String title;
    private LocalDate date;

    public CurationDTO() {
    }

    public CurationDTO(Long id, String category, String title, LocalDate date) {
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
        return "CurationDTO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
