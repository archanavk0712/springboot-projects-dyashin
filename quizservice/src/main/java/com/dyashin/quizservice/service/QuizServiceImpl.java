package com.dyashin.quizservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dyashin.quizservice.DTO.QuestionDTO;
import com.dyashin.quizservice.DTO.ResponseDTO;
import com.dyashin.quizservice.entity.Quiz;
import com.dyashin.quizservice.feign.QuizInterface;
import com.dyashin.quizservice.repo.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;

	@Autowired
	private QuizInterface quizInterface;

	@Override
	public ResponseEntity<String> createQuiz(String category, int numQues, String title) {

		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQues).getBody();

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionsIds(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id) {

		Quiz quiz = quizRepo.findById(id).get();

		List<Integer> questionIds = quiz.getQuestionsIds();
		quizInterface.getQuestionsFromId(questionIds);

		ResponseEntity<List<QuestionDTO>> questions = quizInterface.getQuestionsFromId(questionIds);
		return questions;
	}

	@Override
	public ResponseEntity<Integer> calculateResult(int id, List<ResponseDTO> response) {
		ResponseEntity<Integer> score = quizInterface.getScore(response);
		return score;
	}

}
