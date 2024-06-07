package com.microservice.quiz_service.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.quiz_service.entity.Quiz;
import com.microservice.quiz_service.model.QuestionModel;
import com.microservice.quiz_service.model.Response;
import com.microservice.quiz_service.repo.QuizRepo;

@Service
public class QuizService {
    
    @Autowired
    QuizRepo repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    QuizInterface qInterface;
    
    public ResponseEntity<?> createQuiz(String category, Integer noOfQuests, String title){
        List<Long> quests=qInterface.generateQuestsForQuiz(category, noOfQuests).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(quests);
        repo.save(quiz);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<?> get(Long id) {
        Optional<Quiz> quizObj = repo.findById(id);
        if(quizObj.isPresent()){
            List<Long> questionIds=quizObj.get().getQuestions();
            List<QuestionModel> response=qInterface.getQuestions(questionIds).getBody();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<?> submitQuiz(Long id, List<Response> response) {
        Integer score= qInterface.getScore(response).getBody();
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}