package com.ohgiraffers.pikka_backserver.questions.controller;

import com.ohgiraffers.pikka_backserver.questions.model.QuestionsDTO;
import com.ohgiraffers.pikka_backserver.questions.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionsController {
    private QuestionsService questionsService;

    @Autowired
    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    // 관리자용 엔드포인트
    @GetMapping("/insert/qna-list")
    public ResponseEntity<List<QuestionsDTO>> getAllQna(){
        List<QuestionsDTO> qnaList = questionsService.getAllQuestions();
        return ResponseEntity.ok(qnaList);
    }

    @GetMapping("/insert/qna-list/{contactId}")
    public ResponseEntity<QuestionsDTO> getQnaById(@PathVariable("contactId") Integer contactId){
        QuestionsDTO qna = questionsService.getQuestionById(contactId);
        return ResponseEntity.ok(qna);
    }

    @PutMapping("/insert/qna-list/{contactId}/answer")
    public ResponseEntity<QuestionsDTO> submitAnswer(@PathVariable("contactId") Integer contactId, @RequestBody QuestionsDTO questionsDTO){
        QuestionsDTO updatedQna = questionsService.submitAnswer(contactId, questionsDTO);
        return ResponseEntity.ok(updatedQna);
    }

    @DeleteMapping("/insert/qna-list/{contactId}")
    public ResponseEntity<Void> deleteQna(@PathVariable("contactId") Integer contactId){
        questionsService.deleteQna(contactId);
        return ResponseEntity.noContent().build();
    }

    // 유저용 엔드포인트
    @GetMapping("/inquiry")
    public ResponseEntity<List<QuestionsDTO>> getInquirys(){
        List<QuestionsDTO> questions = questionsService.getAllInquirys();
        System.out.println("Received data2: " + questions);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/inquiry")
    public ResponseEntity<QuestionsDTO> createInquiry(@RequestBody QuestionsDTO questionsDTO) {
        System.out.println("Received postDTO: " + questionsDTO);
        QuestionsDTO createdInquiry = questionsService.add(questionsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInquiry);
    }

    @GetMapping("/inquiry/{id}")
    public ResponseEntity<QuestionsDTO> getInquiry(@PathVariable Integer id){
        QuestionsDTO questionsDTO = questionsService.getInquiry(id);
        if (questionsDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(questionsDTO);
    }

    @PutMapping("/inquiry/{id}")
    public ResponseEntity<QuestionsDTO> updateQuestion(@PathVariable Integer id, @RequestBody QuestionsDTO questionsDTO){
        try {
            System.out.println("Received update request for id: " + id);
            System.out.println("Received DTO in controller: " + questionsDTO);
            QuestionsDTO updatedQuestion = questionsService.updateInquiry(id, questionsDTO);
            System.out.println("Updated question in controller: " + updatedQuestion);
            return ResponseEntity.ok(updatedQuestion);
        } catch (Exception e){
            System.err.println("Error updating inquiry: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/inquiry/{id}")
    public ResponseEntity<QuestionsDTO> deleteInquiry(@PathVariable Integer id){
        try {
            QuestionsDTO deletedQuestions = questionsService.findInquiryById(id);
            questionsService.deleteInquiryById(id);
            return ResponseEntity.ok(deletedQuestions);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}