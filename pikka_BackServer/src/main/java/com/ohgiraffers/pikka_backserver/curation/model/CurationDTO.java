package com.ohgiraffers.pikka_backserver.curation.model;


import java.time.LocalDate;

public class CurationDTO {
    private Integer jobId;
    private String jobCompanyName;
    private String jobInfoTitle;
    private String jobWageType;
    private String jobSalary;
    private String jobLocation;
    private String jobEmploymentType;
    private String jobWebInfoUrl;
    private String jobMobileInfoUrl;
    private String status;
    private LocalDate date;
    private String title;

    public CurationDTO() {
    }

    public CurationDTO(Integer jobId, String jobCompanyName, String jobInfoTitle, String jobWageType, String jobSalary, String jobLocation, String jobEmploymentType, String jobWebInfoUrl, String jobMobileInfoUrl, String status, LocalDate date, String title) {
        this.jobId = jobId;
        this.jobCompanyName = jobCompanyName;
        this.jobInfoTitle = jobInfoTitle;
        this.jobWageType = jobWageType;
        this.jobSalary = jobSalary;
        this.jobLocation = jobLocation;
        this.jobEmploymentType = jobEmploymentType;
        this.jobWebInfoUrl = jobWebInfoUrl;
        this.jobMobileInfoUrl = jobMobileInfoUrl;
        this.status = status;
        this.date = date;
        this.title = title;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobCompanyName() {
        return jobCompanyName;
    }

    public void setJobCompanyName(String jobCompanyName) {
        this.jobCompanyName = jobCompanyName;
    }

    public String getJobInfoTitle() {
        return jobInfoTitle;
    }

    public void setJobInfoTitle(String jobInfoTitle) {
        this.jobInfoTitle = jobInfoTitle;
    }

    public String getJobWageType() {
        return jobWageType;
    }

    public void setJobWageType(String jobWageType) {
        this.jobWageType = jobWageType;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobEmploymentType() {
        return jobEmploymentType;
    }

    public void setJobEmploymentType(String jobEmploymentType) {
        this.jobEmploymentType = jobEmploymentType;
    }

    public String getJobWebInfoUrl() {
        return jobWebInfoUrl;
    }

    public void setJobWebInfoUrl(String jobWebInfoUrl) {
        this.jobWebInfoUrl = jobWebInfoUrl;
    }

    public String getJobMobileInfoUrl() {
        return jobMobileInfoUrl;
    }

    public void setJobMobileInfoUrl(String jobMobileInfoUrl) {
        this.jobMobileInfoUrl = jobMobileInfoUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CurationDTO{" +
                "jobId=" + jobId +
                ", jobCompanyName='" + jobCompanyName + '\'' +
                ", jobInfoTitle='" + jobInfoTitle + '\'' +
                ", jobWageType='" + jobWageType + '\'' +
                ", jobSalary='" + jobSalary + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", jobEmploymentType='" + jobEmploymentType + '\'' +
                ", jobWebInfoUrl='" + jobWebInfoUrl + '\'' +
                ", jobMobileInfoUrl='" + jobMobileInfoUrl + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                '}';
    }
}
