package com.ohgiraffers.pikka_backserver.auth.cafeApi.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "job_cafe")
public class JobCafeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column(name = "cafe_name")
    private String cafeName;

    @Column(name = "simple_intro")
    private String simpleIntro;

    @Column(name = "cafe_type")
    private String cafeType;

    @Column(name = "use_date")
    private String useDate;

    @Column(name = "base_address")
    private String baseAddress;

    @Column(name = "road_address")
    private String roadAddress;

    @Column(name = "space_info", columnDefinition = "TEXT")
    private String spaceInfo;

    @Column(name = "facility_info1")
    private String facilityInfo1;

    @Column(name = "facility_info2")
    private String facilityInfo2;

    @Column(name = "facility_info3")
    private String facilityInfo3;

    @Column(name = "facility_info4")
    private String facilityInfo4;

    @Column(name = "facility_info5")
    private String facilityInfo5;

    @Column(name = "facility_info6")
    private String facilityInfo6;

    @Column(name = "facility_info7")
    private String facilityInfo7;

    @Column(name = "facility_info8")
    private String facilityInfo8;

    @Column(name = "facility_info9")
    private String facilityInfo9;

    @Column(name = "facility_info10")
    private String facilityInfo10;

    @Column(name = "holiday")
    private String holiday;

    @Column(name = "reservation_suggestion1", columnDefinition = "TEXT")
    private String reservationSuggestion1;

    @Column(name = "reservation_suggestion2", columnDefinition = "TEXT")
    private String reservationSuggestion2;

    @Column(name = "reservation_suggestion3", columnDefinition = "TEXT")
    private String reservationSuggestion3;

    @Column(name = "reservation_suggestion4", columnDefinition = "TEXT")
    private String reservationSuggestion4;

    @Column(name = "reservation_suggestion5", columnDefinition = "TEXT")
    private String reservationSuggestion5;

    @Column(name = "reservation_suggestion6", columnDefinition = "TEXT")
    private String reservationSuggestion6;

    @Column(name = "reservation_suggestion7", columnDefinition = "TEXT")
    private String reservationSuggestion7;

    @Column(name = "reservation_suggestion8", columnDefinition = "TEXT")
    private String reservationSuggestion8;

    @Column(name = "reservation_suggestion9", columnDefinition = "TEXT")
    private String reservationSuggestion9;

    @Column(name = "reservation_suggestion10", columnDefinition = "TEXT")
    private String reservationSuggestion10;

    @Column(name = "file_name")
    private String fileName;


    public JobCafeEntity() {
    }


    public JobCafeEntity(Integer jobId, String cafeName, String simpleIntro, String cafeType, String useDate, String baseAddress, String roadAddress, String spaceInfo, String facilityInfo1, String facilityInfo2, String facilityInfo3, String facilityInfo4, String facilityInfo5, String facilityInfo6, String facilityInfo7, String facilityInfo8, String facilityInfo9, String facilityInfo10, String holiday, String reservationSuggestion1, String reservationSuggestion2, String reservationSuggestion3, String reservationSuggestion4, String reservationSuggestion5, String reservationSuggestion6, String reservationSuggestion7, String reservationSuggestion8, String reservationSuggestion9, String reservationSuggestion10, String fileName) {
        this.jobId = jobId;
        this.cafeName = cafeName;
        this.simpleIntro = simpleIntro;
        this.cafeType = cafeType;
        this.useDate = useDate;
        this.baseAddress = baseAddress;
        this.roadAddress = roadAddress;
        this.spaceInfo = spaceInfo;
        this.facilityInfo1 = facilityInfo1;
        this.facilityInfo2 = facilityInfo2;
        this.facilityInfo3 = facilityInfo3;
        this.facilityInfo4 = facilityInfo4;
        this.facilityInfo5 = facilityInfo5;
        this.facilityInfo6 = facilityInfo6;
        this.facilityInfo7 = facilityInfo7;
        this.facilityInfo8 = facilityInfo8;
        this.facilityInfo9 = facilityInfo9;
        this.facilityInfo10 = facilityInfo10;
        this.holiday = holiday;
        this.reservationSuggestion1 = reservationSuggestion1;
        this.reservationSuggestion2 = reservationSuggestion2;
        this.reservationSuggestion3 = reservationSuggestion3;
        this.reservationSuggestion4 = reservationSuggestion4;
        this.reservationSuggestion5 = reservationSuggestion5;
        this.reservationSuggestion6 = reservationSuggestion6;
        this.reservationSuggestion7 = reservationSuggestion7;
        this.reservationSuggestion8 = reservationSuggestion8;
        this.reservationSuggestion9 = reservationSuggestion9;
        this.reservationSuggestion10 = reservationSuggestion10;
        this.fileName = fileName;
    }


    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getSimpleIntro() {
        return simpleIntro;
    }

    public void setSimpleIntro(String simpleIntro) {
        this.simpleIntro = simpleIntro;
    }

    public String getCafeType() {
        return cafeType;
    }

    public void setCafeType(String cafeType) {
        this.cafeType = cafeType;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getSpaceInfo() {
        return spaceInfo;
    }

    public void setSpaceInfo(String spaceInfo) {
        this.spaceInfo = spaceInfo;
    }

    public String getFacilityInfo1() {
        return facilityInfo1;
    }

    public void setFacilityInfo1(String facilityInfo1) {
        this.facilityInfo1 = facilityInfo1;
    }

    public String getFacilityInfo2() {
        return facilityInfo2;
    }

    public void setFacilityInfo2(String facilityInfo2) {
        this.facilityInfo2 = facilityInfo2;
    }

    public String getFacilityInfo3() {
        return facilityInfo3;
    }

    public void setFacilityInfo3(String facilityInfo3) {
        this.facilityInfo3 = facilityInfo3;
    }

    public String getFacilityInfo4() {
        return facilityInfo4;
    }

    public void setFacilityInfo4(String facilityInfo4) {
        this.facilityInfo4 = facilityInfo4;
    }

    public String getFacilityInfo5() {
        return facilityInfo5;
    }

    public void setFacilityInfo5(String facilityInfo5) {
        this.facilityInfo5 = facilityInfo5;
    }

    public String getFacilityInfo6() {
        return facilityInfo6;
    }

    public void setFacilityInfo6(String facilityInfo6) {
        this.facilityInfo6 = facilityInfo6;
    }

    public String getFacilityInfo7() {
        return facilityInfo7;
    }

    public void setFacilityInfo7(String facilityInfo7) {
        this.facilityInfo7 = facilityInfo7;
    }

    public String getFacilityInfo8() {
        return facilityInfo8;
    }

    public void setFacilityInfo8(String facilityInfo8) {
        this.facilityInfo8 = facilityInfo8;
    }

    public String getFacilityInfo9() {
        return facilityInfo9;
    }

    public void setFacilityInfo9(String facilityInfo9) {
        this.facilityInfo9 = facilityInfo9;
    }

    public String getFacilityInfo10() {
        return facilityInfo10;
    }

    public void setFacilityInfo10(String facilityInfo10) {
        this.facilityInfo10 = facilityInfo10;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getReservationSuggestion1() {
        return reservationSuggestion1;
    }

    public void setReservationSuggestion1(String reservationSuggestion1) {
        this.reservationSuggestion1 = reservationSuggestion1;
    }

    public String getReservationSuggestion2() {
        return reservationSuggestion2;
    }

    public void setReservationSuggestion2(String reservationSuggestion2) {
        this.reservationSuggestion2 = reservationSuggestion2;
    }

    public String getReservationSuggestion3() {
        return reservationSuggestion3;
    }

    public void setReservationSuggestion3(String reservationSuggestion3) {
        this.reservationSuggestion3 = reservationSuggestion3;
    }

    public String getReservationSuggestion4() {
        return reservationSuggestion4;
    }

    public void setReservationSuggestion4(String reservationSuggestion4) {
        this.reservationSuggestion4 = reservationSuggestion4;
    }

    public String getReservationSuggestion5() {
        return reservationSuggestion5;
    }

    public void setReservationSuggestion5(String reservationSuggestion5) {
        this.reservationSuggestion5 = reservationSuggestion5;
    }

    public String getReservationSuggestion6() {
        return reservationSuggestion6;
    }

    public void setReservationSuggestion6(String reservationSuggestion6) {
        this.reservationSuggestion6 = reservationSuggestion6;
    }

    public String getReservationSuggestion7() {
        return reservationSuggestion7;
    }

    public void setReservationSuggestion7(String reservationSuggestion7) {
        this.reservationSuggestion7 = reservationSuggestion7;
    }

    public String getReservationSuggestion8() {
        return reservationSuggestion8;
    }

    public void setReservationSuggestion8(String reservationSuggestion8) {
        this.reservationSuggestion8 = reservationSuggestion8;
    }

    public String getReservationSuggestion9() {
        return reservationSuggestion9;
    }

    public void setReservationSuggestion9(String reservationSuggestion9) {
        this.reservationSuggestion9 = reservationSuggestion9;
    }

    public String getReservationSuggestion10() {
        return reservationSuggestion10;
    }

    public void setReservationSuggestion10(String reservationSuggestion10) {
        this.reservationSuggestion10 = reservationSuggestion10;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "JobcafeEntity{" +
                "jobId=" + jobId +
                ", cafeName='" + cafeName + '\'' +
                ", simpleIntro='" + simpleIntro + '\'' +
                ", cafeType='" + cafeType + '\'' +
                ", useDate='" + useDate + '\'' +
                ", baseAddress='" + baseAddress + '\'' +
                ", roadAddress='" + roadAddress + '\'' +
                ", spaceInfo='" + spaceInfo + '\'' +
                ", facilityInfo1='" + facilityInfo1 + '\'' +
                ", facilityInfo2='" + facilityInfo2 + '\'' +
                ", facilityInfo3='" + facilityInfo3 + '\'' +
                ", facilityInfo4='" + facilityInfo4 + '\'' +
                ", facilityInfo5='" + facilityInfo5 + '\'' +
                ", facilityInfo6='" + facilityInfo6 + '\'' +
                ", facilityInfo7='" + facilityInfo7 + '\'' +
                ", facilityInfo8='" + facilityInfo8 + '\'' +
                ", facilityInfo9='" + facilityInfo9 + '\'' +
                ", facilityInfo10='" + facilityInfo10 + '\'' +
                ", holiday='" + holiday + '\'' +
                ", reservationSuggestion1='" + reservationSuggestion1 + '\'' +
                ", reservationSuggestion2='" + reservationSuggestion2 + '\'' +
                ", reservationSuggestion3='" + reservationSuggestion3 + '\'' +
                ", reservationSuggestion4='" + reservationSuggestion4 + '\'' +
                ", reservationSuggestion5='" + reservationSuggestion5 + '\'' +
                ", reservationSuggestion6='" + reservationSuggestion6 + '\'' +
                ", reservationSuggestion7='" + reservationSuggestion7 + '\'' +
                ", reservationSuggestion8='" + reservationSuggestion8 + '\'' +
                ", reservationSuggestion9='" + reservationSuggestion9 + '\'' +
                ", reservationSuggestion10='" + reservationSuggestion10 + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
