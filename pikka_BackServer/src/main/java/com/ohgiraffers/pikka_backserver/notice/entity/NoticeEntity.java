package com.ohgiraffers.pikka_backserver.notice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tbl_notification")
public class NoticeEntity {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_id")
    private Integer notiId;

    @Column(name = "noti_admin_id")
    private Integer notiAdminId;

    @Column(name = "noti_admin_name")
    private String notiAdminName;

    @Column(name = "noti_title", nullable = false)
    private String notiTitle;

    @Column(name = "noti_contents", nullable = false, length = 1000)
    private String notiContents;

    @Column(name = "noti_createat", nullable = false)
    private String notiCreateAt;

    @Column(name = "noti_start_date")
    private String notiStartDate;

    @Column(name = "noti_close_date")
    private String notiCloseDate;

    @Column(name = "noti_modi_date")
    private String notiModiDate;

    public NoticeEntity() {
        this.notiCreateAt = LocalDateTime.now().format(DATE_FORMATTER);
    }

    @PrePersist
    public void prePersist() {
        if (this.notiCreateAt == null || this.notiCreateAt.isEmpty()) {
            this.notiCreateAt = LocalDateTime.now().format(DATE_FORMATTER);
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.notiModiDate = LocalDateTime.now().format(DATE_FORMATTER);
    }

    // Getters and setters

    public Integer getNotiId() {
        return notiId;
    }

    public void setNotiId(Integer notiId) {
        this.notiId = notiId;
    }

    public Integer getNotiAdminId() {
        return notiAdminId;
    }

    public void setNotiAdminId(Integer notiAdminId) {
        this.notiAdminId = notiAdminId;
    }

    public String getNotiAdminName() {
        return notiAdminName;
    }

    public void setNotiAdminName(String notiAdminName) {
        this.notiAdminName = notiAdminName;
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiContents() {
        return notiContents;
    }

    public void setNotiContents(String notiContents) {
        this.notiContents = notiContents;
    }

    public String getNotiCreateAt() {
        return notiCreateAt;
    }

    public void setNotiCreateAt(String notiCreateAt) {
        this.notiCreateAt = (notiCreateAt == null || notiCreateAt.isEmpty())
                ? LocalDateTime.now().format(DATE_FORMATTER)
                : notiCreateAt;
    }

    public String getNotiStartDate() {
        return notiStartDate;
    }

    public void setNotiStartDate(String notiStartDate) {
        this.notiStartDate = notiStartDate;
    }

    public String getNotiCloseDate() {
        return notiCloseDate;
    }

    public void setNotiCloseDate(String notiCloseDate) {
        this.notiCloseDate = notiCloseDate;
    }

    public String getNotiModiDate() {
        return notiModiDate;
    }

    public void setNotiModiDate(String notiModiDate) {
        this.notiModiDate = notiModiDate;
    }

    @Override
    public String toString() {
        return "NoticeEntity{" +
                "notiId=" + notiId +
                ", notiAdminId=" + notiAdminId +
                ", notiAdminName='" + notiAdminName + '\'' +
                ", notiTitle='" + notiTitle + '\'' +
                ", notiContents='" + notiContents + '\'' +
                ", notiCreateAt='" + notiCreateAt + '\'' +
                ", notiStartDate='" + notiStartDate + '\'' +
                ", notiCloseDate='" + notiCloseDate + '\'' +
                ", notiModiDate='" + notiModiDate + '\'' +
                '}';
    }
}