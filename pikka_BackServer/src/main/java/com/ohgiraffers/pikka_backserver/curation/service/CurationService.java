package com.ohgiraffers.pikka_backserver.curation.service;


import com.ohgiraffers.pikka_backserver.curation.repository.CurationRepository;
import com.ohgiraffers.pikka_backserver.auth.jopApi.entity.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class CurationService {

    @Autowired
    private CurationRepository repository;

    public List<JobEntity> findCuration() {
        // 1번 관리자가 선택한 큐레이션 번호를 조회함
        //  ex)1,2,3,4
        List<Integer> list = Arrays.asList(1,2,3,4);

        // 2번 1번에서 조회한 값을 기준으로 curation 데이터를 조회한다.
        List<JobEntity> results =  repository.findAllById(list);

        return results;
    }

    public Optional<JobEntity> findById(Integer id) {
        return repository.findById(id);
    }

    public JobEntity save(JobEntity jobEntity) {
        return repository.save(jobEntity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
