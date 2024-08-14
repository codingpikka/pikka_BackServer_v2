package com.ohgiraffers.pikka_backserver.auth.cafeApi.service;

import com.ohgiraffers.pikka_backserver.auth.cafeApi.entitiy.JobCafeEntity;
import com.ohgiraffers.pikka_backserver.auth.cafeApi.model.JobCafeDTO;
import com.ohgiraffers.pikka_backserver.auth.cafeApi.repository.JobCafeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobCafeService {

    @Autowired
    private JobCafeRepositry jobCafeRepository;

    public JobCafeEntity saveJobCafe(JobCafeDTO jobCafeDTO) {
        JobCafeEntity jobCafe = new JobCafeEntity();
        jobCafe.setCafeName(jobCafeDTO.getCafeName());
        jobCafe.setSimpleIntro(jobCafeDTO.getSimpleIntro());
        jobCafe.setCafeType(jobCafeDTO.getCafeType());
        jobCafe.setUseDate(jobCafeDTO.getUseDate());
        jobCafe.setBaseAddress(jobCafeDTO.getBaseAddress());
        jobCafe.setRoadAddress(jobCafeDTO.getRoadAddress());
        jobCafe.setSpaceInfo(jobCafeDTO.getSpaceInfo());
        jobCafe.setFacilityInfo1(jobCafeDTO.getFacilityInfo1());
        jobCafe.setFacilityInfo2(jobCafeDTO.getFacilityInfo2());
        jobCafe.setFacilityInfo3(jobCafeDTO.getFacilityInfo3());
        jobCafe.setFacilityInfo4(jobCafeDTO.getFacilityInfo4());
        jobCafe.setFacilityInfo5(jobCafeDTO.getFacilityInfo5());
        jobCafe.setFacilityInfo6(jobCafeDTO.getFacilityInfo6());
        jobCafe.setFacilityInfo7(jobCafeDTO.getFacilityInfo7());
        jobCafe.setFacilityInfo8(jobCafeDTO.getFacilityInfo8());
        jobCafe.setFacilityInfo9(jobCafeDTO.getFacilityInfo9());
        jobCafe.setFacilityInfo10(jobCafeDTO.getFacilityInfo10());
        jobCafe.setHoliday(jobCafeDTO.getHoliday());
        jobCafe.setReservationSuggestion1(jobCafeDTO.getReservationSuggestion1());
        jobCafe.setReservationSuggestion2(jobCafeDTO.getReservationSuggestion2());
        jobCafe.setReservationSuggestion3(jobCafeDTO.getReservationSuggestion3());
        jobCafe.setReservationSuggestion4(jobCafeDTO.getReservationSuggestion4());
        jobCafe.setReservationSuggestion5(jobCafeDTO.getReservationSuggestion5());
        jobCafe.setReservationSuggestion6(jobCafeDTO.getReservationSuggestion6());
        jobCafe.setReservationSuggestion7(jobCafeDTO.getReservationSuggestion7());
        jobCafe.setReservationSuggestion8(jobCafeDTO.getReservationSuggestion8());
        jobCafe.setReservationSuggestion9(jobCafeDTO.getReservationSuggestion9());
        jobCafe.setReservationSuggestion10(jobCafeDTO.getReservationSuggestion10());
        jobCafe.setFileName(jobCafeDTO.getFileName());

        return jobCafeRepository.save(jobCafe);
    }


    public List<JobCafeEntity> getAllJobCafes() {
        return jobCafeRepository.findAll();
    }

    public Optional<JobCafeEntity> getJobCafeById(Integer id) {
        return jobCafeRepository.findById(id);
    }
}
