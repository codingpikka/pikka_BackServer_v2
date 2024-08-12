package com.ohgiraffers.pikka_backserver.curation02.repository;

import com.ohgiraffers.pikka_backserver.curation02.entity.CurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurationRepository extends JpaRepository<CurationEntity, Long> {
}