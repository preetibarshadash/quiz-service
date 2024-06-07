package com.microservice.quiz_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.quiz_service.entity.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {
    
}