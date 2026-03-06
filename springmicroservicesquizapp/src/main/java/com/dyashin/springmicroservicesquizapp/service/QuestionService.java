package com.dyashin.springmicroservicesquizapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dyashin.springmicroservicesquizapp.entity.Question;

public interface QuestionService {

	ResponseEntity<List<Question>> getAllQuestion();

	ResponseEntity<List<Question>> getQuestionsByCategory(String category);

	ResponseEntity<String> addQuestion(Question question);

}
