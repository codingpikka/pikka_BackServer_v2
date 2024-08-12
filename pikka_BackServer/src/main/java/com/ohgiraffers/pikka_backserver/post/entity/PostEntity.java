package com.ohgiraffers.pikka_backserver.post.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_thumbnail")
    private String thumbnail;

    @Column(name = "post_content")
    private String content;


    public PostEntity() {
    }

    public PostEntity(Integer id, String title, String thumbnail, String content) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.content = content;
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

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
