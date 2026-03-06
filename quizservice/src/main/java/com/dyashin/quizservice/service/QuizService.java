package com.dyashin.quizservice.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.dyashin.quizservice.DTO.QuestionDTO;
import com.dyashin.quizservice.DTO.ResponseDTO;

public interface QuizService {

	ResponseEntity<String> createQuiz(String category, int numQues, String title);

	ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id);

	ResponseEntity<Integer> calculateResult(int id, List<ResponseDTO> response);

}
