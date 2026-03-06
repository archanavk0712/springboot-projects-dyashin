package com.dyashin.springmicroservicesquizapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dyashin.springmicroservicesquizapp.DTO.QuestionDTO;
import com.dyashin.springmicroservicesquizapp.DTO.ResponseDTO;

public interface QuizService {

	ResponseEntity<String> createQuiz(String category, int numQues, String title);

	ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id);

	ResponseEntity<Integer> calculateResult(int id, List<ResponseDTO> response);

}
