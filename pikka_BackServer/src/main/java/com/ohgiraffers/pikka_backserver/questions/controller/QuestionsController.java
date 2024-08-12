package com.ohgiraffers.pikka_backserver.questions.controller;

import com.ohgiraffers.pikka_backserver.questions.model.QuestionsDTO;
import com.ohgiraffers.pikka_backserver.questions.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<QuestionsDTO> getQnaById(@PathVariable("contactId") Long contactId){
        QuestionsDTO qna = questionsService.getQuestionById(contactId);
        return ResponseEntity.ok(qna);
    }

    @PutMapping("/insert/qna-list/{contactId}/answer")
    public ResponseEntity<QuestionsDTO> submitAnswer(@PathVariable("contactId") Long contactId, @RequestBody QuestionsDTO questionsDTO){
        QuestionsDTO updatedQna = questionsService.submitAnswer(contactId, questionsDTO);
        return ResponseEntity.ok(updatedQna);
    }

    @DeleteMapping("/insert/qna-list/{contactId}")
    public ResponseEntity<Void> deleteQna(@PathVariable("contactId") Long contactId){
        questionsService.deleteQna(contactId);
        return ResponseEntity.noContent().build();
    }

    // 유저용 엔드포인트
    @PostMapping("/inquiry")
    public ResponseEntity<QuestionsDTO> createUserQuestion(@RequestBody QuestionsDTO questionsDTO) {
        QuestionsDTO createdQuestion = questionsService.addQuestion(questionsDTO);
        return ResponseEntity.ok(createdQuestion);
    }
}
