package com.ohgiraffers.pikka_backserver.post.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostDTO {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Integer id;
    private String title;
    private String thumbnail;
    private String content;
    private String createAt;



    public PostDTO() {
        this.createAt = LocalDateTime.now().format(DATE_FORMATTER);
    }

    public PostDTO(Integer id, String title, String thumbnail, String content, String createAt) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.content = content;
        this.createAt = (createAt == null || createAt.isEmpty())
                ? LocalDateTime.now().format(DATE_FORMATTER)
                : createAt;
    }

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
        this.createAt = (createAt == null || createAt.isEmpty())
                ? LocalDateTime.now().format(DATE_FORMATTER)
                : createAt;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", content='" + content + '\'' +
                ", createAt='" + createAt + '\'' +
                '}';
    }
}
