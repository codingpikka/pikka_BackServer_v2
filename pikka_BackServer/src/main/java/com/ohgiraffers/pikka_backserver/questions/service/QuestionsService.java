package com.ohgiraffers.pikka_backserver.questions.service;

import com.ohgiraffers.pikka_backserver.questions.entity.QuestionsEntity;
import com.ohgiraffers.pikka_backserver.questions.model.QuestionsDTO;
import com.ohgiraffers.pikka_backserver.questions.repository.QuestionsRepository;
import jakarta.transaction.Transactional;
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

    public QuestionsDTO getQuestionById(Integer contactId){
        QuestionsEntity questionsEntity = questionsRepository.findById(contactId).orElse(null);
        return convertToDTO(questionsEntity);
    }

    @Transactional
    public QuestionsDTO addQuestion(QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = convertToEntity(questionsDTO);
        QuestionsEntity savedEntity = questionsRepository.save(questionsEntity);
        return convertToDTO(savedEntity);
    }

    @Transactional
    public QuestionsDTO submitAnswer(Integer contactId, QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = questionsRepository.findById(contactId)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + contactId));

        questionsEntity.setAnswerContent(questionsDTO.getAnswerContent());
        questionsEntity.setResponsePostedDate(questionsDTO.getResponsePostedDate());
        questionsEntity.setResponseStatus("완료");

        QuestionsEntity updatedEntity = questionsRepository.save(questionsEntity);
        return convertToDTO(updatedEntity);
    }

    public void deleteQuestion(Integer id){
        questionsRepository.deleteById(id);
    }

    public void deleteQna(Integer contactId) {
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
        questionsDTO.setUserTitle(questionsEntity.getUserTitle());
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
        if (questionsDTO == null) {
            return null;
        }
        QuestionsEntity questionsEntity = new QuestionsEntity();
        questionsEntity.setContactId(questionsDTO.getContactId());
        questionsEntity.setUserId(questionsDTO.getUserId());
        questionsEntity.setUserName(questionsDTO.getUserName());
        questionsEntity.setUserTitle(questionsDTO.getUserTitle());
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

    @Transactional
    public QuestionsDTO add(QuestionsDTO questionsDTO){
        QuestionsEntity questionsEntity = convertToEntity(questionsDTO);
        QuestionsEntity savedEntity = questionsRepository.save(questionsEntity);
        return convertToDTO(savedEntity);
    }

    public List<QuestionsDTO> getAllInquirys()  {
        List<QuestionsEntity> questionsEntities = questionsRepository.findAll();
        return questionsEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public QuestionsDTO findInquiryById(Integer id) {
        QuestionsEntity questionsEntity = questionsRepository.findById(id).orElse(null);
        return convertToDTO(questionsEntity);
    }

    public QuestionsDTO getInquiry(Integer id) {
        return findInquiryById(id);
    }

    @Transactional
    public QuestionsDTO updateInquiry(Integer id, QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = questionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inquiry not found with id: " + id));

        System.out.println("Updating inquiry with id: " + id);
        System.out.println("Current entity: " + questionsEntity);
        System.out.println("Received DTO: " + questionsDTO);

        // 업데이트할 필드들 설정
        if (questionsDTO.getUserTitle() != null && !questionsDTO.getUserTitle().isEmpty()) {
            questionsEntity.setUserTitle(questionsDTO.getUserTitle());
            System.out.println("Updated userTitle to: " + questionsDTO.getUserTitle());
        }

        // contactType 업데이트 (기존 값이 있어도 새 값으로 업데이트)
        if (questionsDTO.getContactType() != null) {
            String oldContactType = questionsEntity.getContactType();
            questionsEntity.setContactType(questionsDTO.getContactType());
            System.out.println("Updated contactType from '" + oldContactType + "' to '" + questionsDTO.getContactType() + "'");
        }

        if (questionsDTO.getContactContents() != null && !questionsDTO.getContactContents().isEmpty()) {
            questionsEntity.setContactContents(questionsDTO.getContactContents());
            System.out.println("Updated contactContents");
        }

        // 필요한 다른 필드들도 업데이트
        // ...

        QuestionsEntity updatedEntity = questionsRepository.save(questionsEntity);
        System.out.println("Updated entity: " + updatedEntity);

        return convertToDTO(updatedEntity);
    }
    public void deleteInquiryById(Integer id){
        questionsRepository.deleteById(id);
    }
}