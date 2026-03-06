package com.dyashin.springmicroservicesquizapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.springmicroservicesquizapp.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
