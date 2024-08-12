package com.ohgiraffers.pikka_backserver.questions.service;

import com.ohgiraffers.pikka_backserver.questions.entity.QuestionsEntity;
import com.ohgiraffers.pikka_backserver.questions.model.QuestionsDTO;
import com.ohgiraffers.pikka_backserver.questions.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<QuestionsDTO> getAllQuestions(){
        return questionsRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public QuestionsDTO getQuestionById(Long contactId){
        QuestionsEntity questionsEntity = questionsRepository.findById(contactId).orElse(null);
        return convertToDTO(questionsEntity);
    }

    // 새로운 질문을 저장하는 메서드 추가
    public QuestionsDTO addQuestion(QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = convertToEntity(questionsDTO);
        QuestionsEntity savedEntity = questionsRepository.save(questionsEntity);
        return convertToDTO(savedEntity);
    }

    public QuestionsDTO submitAnswer(Long contactId, QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = questionsRepository.findById(contactId).orElse(null);
        if (questionsEntity != null){
            questionsEntity.setAnswerContent(questionsDTO.getAnswerContent());
            questionsEntity.setResponsePostedDate(questionsDTO.getResponsePostedDate());
            questionsEntity.setResponseStatus("완료");
            questionsRepository.save(questionsEntity);
        }
        return convertToDTO(questionsEntity);
    }

    public void deleteQuestion(Long id){ questionsRepository.deleteById(id);}
    public void deleteQna(Long contactId) {
        questionsRepository.deleteById(contactId);
    }

    private QuestionsDTO convertToDTO(QuestionsEntity questionsEntity) {
        if (questionsEntity == null) {
            return null;
        }
        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setContactId(questionsEntity.getContactId());
        questionsDTO.setUserId(questionsEntity.getUserId());
        questionsDTO.setUserName(questionsEntity.getUserName());
        questionsDTO.setContactType(questionsEntity.getContactType());
        questionsDTO.setContactContents(questionsEntity.getContactContents());
        questionsDTO.setContactPostedDate(questionsEntity.getContactPostedDate());
        questionsDTO.setAdminId(questionsEntity.getAdminId());
        questionsDTO.setAdminName(questionsEntity.getAdminName());
        questionsDTO.setResponseTitle(questionsEntity.getResponseTitle());
        questionsDTO.setResponseContents(questionsEntity.getResponseContents());
        questionsDTO.setResponsePostedDate(questionsEntity.getResponsePostedDate());
        questionsDTO.setResponseStatus(questionsEntity.getResponseStatus());
        questionsDTO.setAnswerContent(questionsEntity.getAnswerContent());
        return questionsDTO;
    }

    private QuestionsEntity convertToEntity(QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = new QuestionsEntity();
        questionsEntity.setContactId(questionsDTO.getContactId());
        questionsEntity.setUserId(questionsDTO.getUserId());
        questionsEntity.setUserName(questionsDTO.getUserName());
        questionsEntity.setContactType(questionsDTO.getContactType());
        questionsEntity.setContactContents(questionsDTO.getContactContents());
        questionsEntity.setContactPostedDate(questionsDTO.getContactPostedDate());
        questionsEntity.setAdminId(questionsDTO.getAdminId());
        questionsEntity.setAdminName(questionsDTO.getAdminName());
        questionsEntity.setResponseTitle(questionsDTO.getResponseTitle());
        questionsEntity.setResponseContents(questionsDTO.getResponseContents());
        questionsEntity.setResponsePostedDate(questionsDTO.getResponsePostedDate());
        questionsEntity.setResponseStatus(questionsDTO.getResponseStatus());
        questionsEntity.setAnswerContent(questionsDTO.getAnswerContent());
        return questionsEntity;
    }
}
