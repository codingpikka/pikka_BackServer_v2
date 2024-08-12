package com.ohgiraffers.pikka_backserver.questions.repository;

import com.ohgiraffers.pikka_backserver.questions.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Long> {
}
