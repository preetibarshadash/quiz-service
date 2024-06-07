package com.microservice.quiz_service.model;

import java.util.List;

import lombok.Data;

@Data
public class QuizModel {
    
    private Long id;

    private String title;

    private List<QuestionModel> questions;
}