package com.ohgiraffers.pikka_backserver.auth.jopApi.repository;


import com.ohgiraffers.pikka_backserver.auth.jopApi.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {


}
