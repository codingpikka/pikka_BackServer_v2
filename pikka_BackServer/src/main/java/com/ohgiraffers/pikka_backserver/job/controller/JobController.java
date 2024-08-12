package com.ohgiraffers.pikka_backserver.job.controller;


import com.ohgiraffers.pikka_backserver.auth.jopApi.entity.JobEntity;
import com.ohgiraffers.pikka_backserver.auth.jopApi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;


    @GetMapping
    public ResponseEntity<List<JobEntity>> getAllJobs() {
        List<JobEntity> jobEntities = jobService.getAllJobs(); // 모든 JobEntity를 가져옵니다
        return ResponseEntity.ok(jobEntities); // JSON으로 반환합니다
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobEntity> getJobById(@PathVariable Integer id) {
        Optional<JobEntity> jobEntity = jobService.getJobById(id);
        return jobEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
