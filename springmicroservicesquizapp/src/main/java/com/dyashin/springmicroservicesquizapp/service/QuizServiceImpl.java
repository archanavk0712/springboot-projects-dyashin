package com.dyashin.springmicroservicesquizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dyashin.springmicroservicesquizapp.DTO.QuestionDTO;
import com.dyashin.springmicroservicesquizapp.DTO.ResponseDTO;
import com.dyashin.springmicroservicesquizapp.entity.Question;
import com.dyashin.springmicroservicesquizapp.entity.Quiz;
import com.dyashin.springmicroservicesquizapp.repo.QuestionRepo;
import com.dyashin.springmicroservicesquizapp.repo.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService {


	@Autowired
	private QuizRepo quizRepo;

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public ResponseEntity<String> createQuiz(String category, int numQues, String title) {

		Pageable pageable = PageRequest.of(0, numQues);

		List<Question> questions = questionRepo.findRandomQuesByCategory(category, pageable);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id) {

		Optional<Quiz> quiz = quizRepo.findById(id);
		
		List<Question> questionsFromDB=quiz.get().getQuestions();
		
		List<QuestionDTO> questionsForUser = new ArrayList<>();
		
		for(Question q: questionsFromDB) {
			QuestionDTO questionDTO=new QuestionDTO(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(questionDTO);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> calculateResult(int id, List<ResponseDTO> response) {
		Quiz quiz=quizRepo.findById(id).get();
		List<Question> questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for(ResponseDTO res: response) {
			if(res.getAnswer().equals(questions.get(i).getRightAnswer())) {
				right++;
				i++;
			}
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
