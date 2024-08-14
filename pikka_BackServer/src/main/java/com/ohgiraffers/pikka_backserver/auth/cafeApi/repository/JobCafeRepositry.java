package com.ohgiraffers.pikka_backserver.auth.cafeApi.repository;

import com.ohgiraffers.pikka_backserver.auth.cafeApi.entitiy.JobCafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobCafeRepositry extends JpaRepository<JobCafeEntity, Integer> {
}
