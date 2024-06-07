package com.microservice.quiz_service.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.quiz_service.model.QuestionModel;
import com.microservice.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    
    @GetMapping("/question/generateQuest")
    public ResponseEntity<List<Long>> generateQuestsForQuiz(@RequestParam String category,@RequestParam Integer noOfQuests);
    
    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionModel>> getQuestions(@RequestBody List<Long> questionIds);

    @PostMapping("/question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}