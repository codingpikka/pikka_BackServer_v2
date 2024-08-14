package com.ohgiraffers.pikka_backserver.questions.service;

import com.ohgiraffers.pikka_backserver.questions.entity.QuestionsEntity;
import com.ohgiraffers.pikka_backserver.questions.model.QuestionsDTO;
import com.ohgiraffers.pikka_backserver.questions.repository.QuestionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    // 새로운 질문을 저장하는 메서드 추가
    public QuestionsDTO addQuestion(QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = convertToEntity(questionsDTO);
        QuestionsEntity savedEntity = questionsRepository.save(questionsEntity);
        return convertToDTO(savedEntity);
    }

    public QuestionsDTO submitAnswer(Integer contactId, QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = questionsRepository.findById(contactId).orElse(null);
        if (questionsEntity != null){
            questionsEntity.setAnswerContent(questionsDTO.getAnswerContent());
            questionsEntity.setResponsePostedDate(questionsDTO.getResponsePostedDate());
            questionsEntity.setResponseStatus("완료");
            questionsRepository.save(questionsEntity);
        }
        return convertToDTO(questionsEntity);
    }

    public void deleteQuestion(Integer id){ questionsRepository.deleteById(id);}
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

    // 유저 엔드포인트 서비스
    @Transactional
    public Map<String, Integer> add(QuestionsDTO questionsDTO){
        QuestionsEntity questionsEntity = new QuestionsEntity();
        questionsEntity.setContactId(questionsDTO.getContactId());
        questionsEntity.setUserId(questionsDTO.getUserId());
        questionsEntity.setUserName(questionsDTO.getUserName());
        questionsEntity.setUserTitle(questionsDTO.getUserTitle());
        questionsEntity.setContactType(questionsDTO.getContactType());
        questionsEntity.setContactContents(questionsDTO.getContactContents());
        questionsEntity.setContactPostedDate(questionsDTO.getContactPostedDate());
//        questionsEntity.setAdminId(questionsDTO.getAdminId());
        questionsEntity.setAdminName(questionsDTO.getAdminName());
        questionsEntity.setResponseTitle(questionsDTO.getResponseTitle());
        questionsEntity.setResponseContents(questionsDTO.getResponseContents());
        questionsEntity.setResponsePostedDate(questionsDTO.getResponsePostedDate());
        questionsEntity.setResponseStatus(questionsDTO.getResponseStatus());
        questionsEntity.setAnswerContent(questionsDTO.getAnswerContent());

        QuestionsEntity savedInquiryEntity = questionsRepository.save(questionsEntity);

        if (Objects.isNull(savedInquiryEntity)) {
            return null;

        }else {
            return Map.of("postId", savedInquiryEntity.getUserId());
        }
    }

    public List<QuestionsDTO> getAllInquirys()  {
        List<QuestionsEntity> questionsEntities = questionsRepository.findAll();
        return questionsEntities.stream()
                .map(questions -> {
                    QuestionsDTO dto = new QuestionsDTO();
                    dto.setContactId(questions.getContactId());
                    dto.setUserId(questions.getUserId());
                    dto.setUserName(questions.getUserName());
                    dto.setUserTitle(questions.getUserTitle());
                    dto.setContactType(questions.getContactType());
                    dto.setContactContents(questions.getContactContents());
                    dto.setContactPostedDate(questions.getContactPostedDate());
//                    dto.setAdminId(questions.getAdminId());
                    dto.setAdminName(questions.getAdminName());
                    dto.setResponseTitle(questions.getResponseTitle());
                    dto.setResponseContents(questions.getResponseContents());
                    dto.setResponsePostedDate(questions.getResponsePostedDate());
                    dto.setResponseStatus(questions.getResponseStatus());
                    dto.setAnswerContent(questions.getAnswerContent());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public QuestionsDTO findInquiryById(Integer id) {
        QuestionsEntity questionsEntity = questionsRepository.findById(id).orElse(null);

        if (questionsEntity == null) {
            // 존재하지 않는 경우 null 반환
            return null;
        }
        // DTO 객체를 직접 생성
        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setContactId(questionsEntity.getContactId());
        questionsDTO.setUserId(questionsEntity.getUserId());
        questionsDTO.setUserName(questionsEntity.getUserName());
        questionsDTO.setUserTitle(questionsEntity.getUserTitle());
        questionsDTO.setContactType(questionsEntity.getContactType());
        questionsDTO.setContactContents(questionsEntity.getContactContents());
        questionsDTO.setContactPostedDate(questionsEntity.getContactPostedDate());
//        questionsDTO.setAdminId(questionsEntity.getAdminId());
        questionsDTO.setAdminName(questionsEntity.getAdminName());
        questionsDTO.setResponseTitle(questionsEntity.getResponseTitle());
        questionsDTO.setResponseContents(questionsEntity.getResponseContents());
        questionsDTO.setResponsePostedDate(questionsEntity.getResponsePostedDate());
        questionsDTO.setResponseStatus(questionsEntity.getResponseStatus());
        questionsDTO.setAnswerContent(questionsEntity.getAnswerContent());

        return questionsDTO;
    }

    public QuestionsDTO getInquiry(Integer id) {
        QuestionsEntity questionsEntity = questionsRepository.findById(id).orElse(null);
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
//        questionsDTO.setAdminId(questionsEntity.getAdminId());
        questionsDTO.setAdminName(questionsEntity.getAdminName());
        questionsDTO.setResponseTitle(questionsEntity.getResponseTitle());
        questionsDTO.setResponseContents(questionsEntity.getResponseContents());
        questionsDTO.setResponsePostedDate(questionsEntity.getResponsePostedDate());
        questionsDTO.setResponseStatus(questionsEntity.getResponseStatus());
        questionsDTO.setAnswerContent(questionsEntity.getAnswerContent());

        return questionsDTO;
    }

    public QuestionsDTO updateInquiry(Integer id, QuestionsDTO questionsDTO) {
        QuestionsEntity questionsEntity = questionsRepository.findById(id).orElse(null);
        if (questionsEntity == null) {
            // 게시글이 존재하지 않으면 null 반환
            return null;
        }

        // 기존 엔티티의 필드 수정
        questionsEntity.setContactId(questionsDTO.getContactId());
        questionsEntity.setUserId(questionsDTO.getUserId());
        questionsEntity.setUserName(questionsDTO.getUserName());
        questionsEntity.setUserTitle(questionsDTO.getUserTitle());
        questionsEntity.setContactType(questionsDTO.getContactType());
        questionsEntity.setContactContents(questionsDTO.getContactContents());
        questionsEntity.setContactPostedDate(questionsDTO.getContactPostedDate());
//        questionsEntity.setAdminId(questionsDTO.getAdminId());
        questionsEntity.setAdminName(questionsDTO.getAdminName());
        questionsEntity.setResponseTitle(questionsDTO.getResponseTitle());
        questionsEntity.setResponseContents(questionsDTO.getResponseContents());
        questionsEntity.setResponsePostedDate(questionsDTO.getResponsePostedDate());
        questionsEntity.setResponseStatus(questionsDTO.getResponseStatus());
        questionsEntity.setAnswerContent(questionsDTO.getAnswerContent());

        // 엔티티 저장
        QuestionsEntity updatedInquiryEntity = questionsRepository.save(questionsEntity);

        // DTO 객체 직접 생성
        QuestionsDTO updatedInquiryDTO = new QuestionsDTO();
        questionsDTO.setContactId(updatedInquiryEntity.getContactId());
        questionsDTO.setUserId(updatedInquiryEntity.getUserId());
        questionsDTO.setUserName(updatedInquiryEntity.getUserName());
        questionsDTO.setUserTitle(updatedInquiryEntity.getUserTitle());
        questionsDTO.setContactType(updatedInquiryEntity.getContactType());
        questionsDTO.setContactContents(updatedInquiryEntity.getContactContents());
        questionsDTO.setContactPostedDate(updatedInquiryEntity.getContactPostedDate());
//        questionsDTO.setAdminId(updatedInquiryEntity.getAdminId());
        questionsDTO.setAdminName(updatedInquiryEntity.getAdminName());
        questionsDTO.setResponseTitle(updatedInquiryEntity.getResponseTitle());
        questionsDTO.setResponseContents(updatedInquiryEntity.getResponseContents());
        questionsDTO.setResponsePostedDate(updatedInquiryEntity.getResponsePostedDate());
        questionsDTO.setResponseStatus(updatedInquiryEntity.getResponseStatus());
        questionsDTO.setAnswerContent(updatedInquiryEntity.getAnswerContent());

        return updatedInquiryDTO;
    }

    public void deleteInquiryById(Integer id){
        questionsRepository.deleteById(id);
    }
}
