package com.ohgiraffers.pikka_backserver.post.model;

public class PostDTO {


    private Integer Id;
    private String title;
    private String thumbnail;
    private String content;

    public PostDTO() {
    }

    public PostDTO(Integer id, String title, String thumbnail, String content) {
        Id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.content = content;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
        return "PostDTO{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
