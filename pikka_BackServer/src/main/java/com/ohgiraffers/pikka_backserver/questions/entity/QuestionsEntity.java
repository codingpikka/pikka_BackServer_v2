package com.ohgiraffers.pikka_backserver.questions.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_contact")
public class QuestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact_contents")
    private String contactContents;

    @Column(name = "contact_posted_date")
    private String contactPostedDate;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "response_title")
    private String responseTitle;

    @Column(name = "response_contents")
    private String responseContents;

    @Column(name = "response_posted_date")
    private String responsePostedDate;

    @Column(name = "response_status")
    private String responseStatus;

    @Column(name = "answer_content")
    private String answerContent;

    public QuestionsEntity() {
    }

    public QuestionsEntity(Long contactId, Long userId, String userName, String contactType, String contactContents, String contactPostedDate, Long adminId, String adminName, String responseTitle, String responseContents, String responsePostedDate, String responseStatus, String answerContent) {
        this.contactId = contactId;
        this.userId = userId;
        this.userName = userName;
        this.contactType = contactType;
        this.contactContents = contactContents;
        this.contactPostedDate = contactPostedDate;
        this.adminId = adminId;
        this.adminName = adminName;
        this.responseTitle = responseTitle;
        this.responseContents = responseContents;
        this.responsePostedDate = responsePostedDate;
        this.responseStatus = responseStatus;
        this.answerContent = answerContent;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactContents() {
        return contactContents;
    }

    public void setContactContents(String contactContents) {
        this.contactContents = contactContents;
    }

    public String getContactPostedDate() {
        return contactPostedDate;
    }

    public void setContactPostedDate(String contactPostedDate) {
        this.contactPostedDate = contactPostedDate;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getResponseTitle() {
        return responseTitle;
    }

    public void setResponseTitle(String responseTitle) {
        this.responseTitle = responseTitle;
    }

    public String getResponseContents() {
        return responseContents;
    }

    public void setResponseContents(String responseContents) {
        this.responseContents = responseContents;
    }

    public String getResponsePostedDate() {
        return responsePostedDate;
    }

    public void setResponsePostedDate(String responsePostedDate) {
        this.responsePostedDate = responsePostedDate;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Override
    public String toString() {
        return "QuestionsEntity{" +
                "contactId=" + contactId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", contactType='" + contactType + '\'' +
                ", contactContents='" + contactContents + '\'' +
                ", contactPostedDate='" + contactPostedDate + '\'' +
                ", adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", responseTitle='" + responseTitle + '\'' +
                ", responseContents='" + responseContents + '\'' +
                ", responsePostedDate='" + responsePostedDate + '\'' +
                ", responseStatus='" + responseStatus + '\'' +
                ", answerContent='" + answerContent + '\'' +
                '}';
    }
}
