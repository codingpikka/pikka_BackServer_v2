package com.ohgiraffers.pikka_backserver.notice.model;

public class NoticeDTO {

    private Integer notiId;
    private Integer notiAdminId;
    private String notiAdminName;
    private String notiTitle;
    private String notiContents;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String notiCreateAt;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String notiStartDate;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String notiCloseDate;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String notiModiDate;

    // Constructors
    public NoticeDTO() {}

    public NoticeDTO(Integer notiId, Integer notiAdminId, String notiAdminName, String notiTitle, String notiContents, String notiCreateAt, String notiStartDate, String notiCloseDate, String notiModiDate) {
        this.notiId = notiId;
        this.notiAdminId = notiAdminId;
        this.notiAdminName = notiAdminName;
        this.notiTitle = notiTitle;
        this.notiContents = notiContents;
        this.notiCreateAt = notiCreateAt;
        this.notiStartDate = notiStartDate;
        this.notiCloseDate = notiCloseDate;
        this.notiModiDate = notiModiDate;
    }

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
        this.notiCreateAt = notiCreateAt;
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
        return "NoticeDTO{" +
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
