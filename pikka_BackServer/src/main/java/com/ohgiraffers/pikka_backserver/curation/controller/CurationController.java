package com.ohgiraffers.pikka_backserver.curation.controller;


import com.ohgiraffers.pikka_backserver.curation.entity.CurationEntity;
import com.ohgiraffers.pikka_backserver.curation.model.CurationDTO;
import com.ohgiraffers.pikka_backserver.curation.service.CurationService;
import com.ohgiraffers.pikka_backserver.auth.jopApi.entity.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curation")
public class CurationController {

    private CurationService service;

    @Autowired
    public CurationController(CurationService service) {
        this.service = service;
    }

    // 조회
    @GetMapping
    public ResponseEntity<List<JobEntity>> getAllItems() {
        List<JobEntity> items = service.findCuration();

        return ResponseEntity.ok(items);

    }

    // id 값으로 상세조회
    @GetMapping("/{id}")
    public ResponseEntity<JobEntity> getItemById(@PathVariable Integer id) {
        Optional<JobEntity> item = service.findById(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 저장
    @PostMapping
    public ResponseEntity<JobEntity> createItem(@RequestBody CurationDTO curationDTO) {
        JobEntity item = new JobEntity();
        item.setJobCompanyName(curationDTO.getJobCompanyName());
        item.setJobInfoTitle(curationDTO.getJobInfoTitle());
        item.setJobWageType(curationDTO.getJobWageType());
        item.setJobSalary(curationDTO.getJobSalary());
        item.setJobLocation(curationDTO.getJobLocation());
        item.setJobEmploymentType(curationDTO.getJobEmploymentType());
        item.setJobWebInfoUrl(curationDTO.getJobWebInfoUrl());
        item.setJobMobileInfoUrl(curationDTO.getJobMobileInfoUrl());
        item.setStatus(curationDTO.getStatus());
        item.setDate(curationDTO.getDate());
        item.setTitle(curationDTO.getTitle());
        JobEntity savedItem = service.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<JobEntity> updateItem(@PathVariable Integer id, @RequestBody CurationDTO curationDTO) {
        Optional<JobEntity> existingItem = service.findById(id);
        if (existingItem.isPresent()) {
            JobEntity item = existingItem.get();
            item.setJobCompanyName(curationDTO.getJobCompanyName());
            item.setJobInfoTitle(curationDTO.getJobInfoTitle());
            item.setJobWageType(curationDTO.getJobWageType());
            item.setJobSalary(curationDTO.getJobSalary());
            item.setJobLocation(curationDTO.getJobLocation());
            item.setJobEmploymentType(curationDTO.getJobEmploymentType());
            item.setJobWebInfoUrl(curationDTO.getJobWebInfoUrl());
            item.setJobMobileInfoUrl(curationDTO.getJobMobileInfoUrl());
            JobEntity updatedItem = service.save(item);
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        Optional<JobEntity> existingItem = service.findById(id);
        if (existingItem.isPresent()) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    // 검색 엔드포인트 추가
    @GetMapping("/search")
    public ResponseEntity<List<JobEntity>> searchPosts(@RequestParam String term) {
        List<JobEntity> results = service.searchPosts(term);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
