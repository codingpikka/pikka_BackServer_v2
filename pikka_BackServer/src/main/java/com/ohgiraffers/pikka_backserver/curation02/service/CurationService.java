package com.ohgiraffers.pikka_backserver.curation02.service;

import com.ohgiraffers.pikka_backserver.curation02.entity.CurationEntity;
import com.ohgiraffers.pikka_backserver.curation02.model.CurationDTO;
import com.ohgiraffers.pikka_backserver.curation02.repository.CurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurationService {

    @Autowired
    private CurationRepository repository;

    public CurationEntity createItem(CurationDTO curationDTO) {
        CurationEntity entity = new CurationEntity();
        entity.setCategory(curationDTO.getCategory());
        entity.setTitle(curationDTO.getTitle());
        entity.setJobCompanyName(curationDTO.getJobCompanyName());
        entity.setJobInfoTitle(curationDTO.getJobInfoTitle());
        entity.setJobWageType(curationDTO.getJobWageType());
        entity.setJobSalary(curationDTO.getJobSalary());
        entity.setJobLocation(curationDTO.getJobLocation());
        entity.setJobEmploymentType(curationDTO.getJobEmploymentType());
        entity.setJobWebInfoUrl(curationDTO.getJobWebInfoUrl());
        entity.setJobMobileInfoUrl(curationDTO.getJobMobileInfoUrl());
        entity.setStatus(curationDTO.getStatus());
        entity.setThumbnail(curationDTO.getThumbnail());
        entity.setDate(curationDTO.getDate());

        return repository.save(entity);
    }

    public List<CurationEntity> getAllItems() {
        return repository.findAll();
    }

    public CurationEntity getItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CurationEntity updateItem(Long id, CurationDTO curationDTO) {
        CurationEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setCategory(curationDTO.getCategory());
            entity.setTitle(curationDTO.getTitle());
            entity.setJobCompanyName(curationDTO.getJobCompanyName());
            entity.setJobInfoTitle(curationDTO.getJobInfoTitle());
            entity.setJobWageType(curationDTO.getJobWageType());
            entity.setJobSalary(curationDTO.getJobSalary());
            entity.setJobLocation(curationDTO.getJobLocation());
            entity.setJobEmploymentType(curationDTO.getJobEmploymentType());
            entity.setJobWebInfoUrl(curationDTO.getJobWebInfoUrl());
            entity.setJobMobileInfoUrl(curationDTO.getJobMobileInfoUrl());
            entity.setStatus(curationDTO.getStatus());
            entity.setThumbnail(curationDTO.getThumbnail());
            entity.setDate(curationDTO.getDate());

            return repository.save(entity);
        }
        return null;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}