package com.ohgiraffers.pikka_backserver.jobcafe.controller;

import com.ohgiraffers.pikka_backserver.auth.cafeApi.entitiy.JobCafeEntity;
import com.ohgiraffers.pikka_backserver.auth.cafeApi.service.JobCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobcafes")
public class JobCafeController {

    @Autowired
    private JobCafeService jobCafeService;

    // 데이터베이스에 저장된 모든 JobCafe 정보를 반환
    @GetMapping
    public ResponseEntity<List<JobCafeEntity>> getAllJobCafes() {
        List<JobCafeEntity> jobCafeEntities = jobCafeService.getAllJobCafes(); // 모든 JobCafeEntity를 가져옵니다
        return ResponseEntity.ok(jobCafeEntities); // JSON으로 반환합니다
    }

    // ID로 특정 JobCafe 정보를 반환
    @GetMapping("/{id}")
    public ResponseEntity<JobCafeEntity> getJobCafeById(@PathVariable Integer id) {
        Optional<JobCafeEntity> jobCafeEntity = jobCafeService.getJobCafeById(id);
        return jobCafeEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
