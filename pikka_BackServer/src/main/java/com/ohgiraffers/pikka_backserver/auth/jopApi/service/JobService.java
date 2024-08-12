package com.ohgiraffers.pikka_backserver.auth.jopApi.service;

import com.ohgiraffers.pikka_backserver.auth.jopApi.repository.JobRepository;
import com.ohgiraffers.pikka_backserver.auth.jopApi.entity.JobEntity;
import com.ohgiraffers.pikka_backserver.auth.jopApi.model.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    public void saveJob(JobDTO jobDTO) {
        JobEntity jobEntity = new JobEntity();

        jobEntity.setJobCompanyName(jobDTO.getJobCompanyName());
        jobEntity.setJobInfoTitle(jobDTO.getJobInfoTitle());
        jobEntity.setJobWageType(jobDTO.getJobWageType());
        jobEntity.setJobSalary(jobDTO.getJobSalary());
        jobEntity.setJobLocation(jobDTO.getJobLocation());
        jobEntity.setJobEmploymentType(jobDTO.getJobEmploymentType());
//        jobEntity.setJobPostedDate(jobDTO.getJobPostedDate());
//        jobEntity.setJobClosingDate(jobDTO.getJobClosingDate());
        jobEntity.setJobWebInfoUrl(jobDTO.getJobWebInfoUrl());
        jobEntity.setJobMobileInfoUrl(jobDTO.getJobMobileInfoUrl());

        jobRepository.save(jobEntity);


    }

    // 취업 정보에 저장된 테이블을 다 불러오는 거

    public List<JobEntity> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<JobEntity> getJobById(Integer id) {
        return jobRepository.findById(id);
    }
}
