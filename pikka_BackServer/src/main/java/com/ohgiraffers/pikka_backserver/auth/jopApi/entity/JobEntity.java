package com.ohgiraffers.pikka_backserver.auth.jopApi.entity;


import jakarta.persistence.*;

@Entity
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column(name = "job_company_name", nullable = false)
    private String jobCompanyName;

    @Column(name = "job_info_title", nullable = false)
    private String jobInfoTitle;

    @Column(name = "job_wage_type")
    private String jobWageType;

    @Column(name = "job_salary")
    private String jobSalary;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "job_employment_type")
    private String jobEmploymentType;

//    @Column(name = "job_posted_date")
//    private LocalDate jobPostedDate;
//
//    @Column(name = "job_closing_date")
//    private LocalDate jobClosingDate;

    @Column(name = "job_web_info_url")
    private String jobWebInfoUrl;

    @Column(name = "job_mobile_info_url")
    private String jobMobileInfoUrl;

    public JobEntity() {
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

    @Override
    public String toString() {
        return "JobEntity{" +
                "jobId=" + jobId +
                ", jobCompanyName='" + jobCompanyName + '\'' +
                ", jobInfoTitle='" + jobInfoTitle + '\'' +
                ", jobWageType='" + jobWageType + '\'' +
                ", jobSalary='" + jobSalary + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", jobEmploymentType='" + jobEmploymentType + '\'' +
                ", jobWebInfoUrl='" + jobWebInfoUrl + '\'' +
                ", jobMobileInfoUrl='" + jobMobileInfoUrl + '\'' +
                '}'+'\n';
    }
}
