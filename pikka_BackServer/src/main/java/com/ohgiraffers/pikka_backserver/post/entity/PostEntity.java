package com.ohgiraffers.pikka_backserver.post.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tbl_post")
public class PostEntity {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_thumbnail")
    private String thumbnail;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_create_at", nullable = false)
    private String createAt;

    public PostEntity() {
        this.createAt = LocalDateTime.now().format(DATE_FORMATTER);
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (this.createAt == null) {
            this.createAt = LocalDateTime.now().format(DATE_FORMATTER);
        }
    }
}
