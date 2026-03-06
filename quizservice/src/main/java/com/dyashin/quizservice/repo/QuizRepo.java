package com.dyashin.quizservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.quizservice.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
