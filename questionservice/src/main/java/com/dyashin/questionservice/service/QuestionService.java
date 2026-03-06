package com.dyashin.questionservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dyashin.questionservice.DTO.QuestionDTO;
import com.dyashin.questionservice.DTO.ResponseDTO;
import com.dyashin.questionservice.entity.Question;

public interface QuestionService {

	ResponseEntity<List<Question>> getAllQuestion();

	ResponseEntity<List<Question>> getQuestionsByCategory(String category);

	ResponseEntity<String> addQuestion(Question question);

	ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQues);

	ResponseEntity<List<QuestionDTO>> getQuestionsFromIds(List<Integer> questionIds);

	ResponseEntity<Integer> getScore(List<ResponseDTO> responses);

}
