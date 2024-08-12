package com.ohgiraffers.pikka_backserver.curation.repository;


import com.ohgiraffers.pikka_backserver.curation.entity.CurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurationRepository extends JpaRepository<CurationEntity, Integer> {
}
