package com.microservice.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.quiz_service.model.Response;
import com.microservice.quiz_service.service.QuizService;



@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    QuizService service;

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam String category, @RequestParam Integer noOfQuests, @RequestParam String title){
        return service.createQuiz(category, noOfQuests, title);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getQuiz(@RequestParam Long id) {
        return service.get(id);
    }
    
    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestParam Long id, @RequestBody List<Response> response) {
        return service.submitQuiz(id, response);
    }
    
}