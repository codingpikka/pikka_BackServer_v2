package com.ohgiraffers.pikka_backserver.curation.service;


import com.ohgiraffers.pikka_backserver.curation.entity.CurationEntity;
import com.ohgiraffers.pikka_backserver.curation.repository.CurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CurationService {

    @Autowired
    private CurationRepository repository;

    public List<CurationEntity> findAll() {
        return repository.findAll();
    }

    public Optional<CurationEntity> findById(Integer id) {
        return repository.findById(id);
    }

    public CurationEntity save(CurationEntity curationEntity) {
        return repository.save(curationEntity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
