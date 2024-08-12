package com.ohgiraffers.pikka_backserver.notice.repository;

import com.ohgiraffers.pikka_backserver.notice.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
    List<NoticeEntity> findAllByOrderByNotiCreateAtDesc();
}
