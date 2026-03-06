package com.dyashin.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dyashin.questionservice.DTO.QuestionDTO;
import com.dyashin.questionservice.DTO.ResponseDTO;
import com.dyashin.questionservice.entity.Question;
import com.dyashin.questionservice.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public ResponseEntity<List<Question>> getAllQuestion() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionRepo.save(question);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQues) {
		Pageable pageable = PageRequest.of(0, numQues);

		List<Integer> questions = questionRepo.findRandomQuesByCategory(category, pageable);

		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<QuestionDTO>> getQuestionsFromIds(List<Integer> questionIds) {
		List<QuestionDTO> dto = new ArrayList<>();
		List<Question> questions = new ArrayList<>();

		for (int id : questionIds) {
			questions.add(questionRepo.findById(id).get());
		}

		for (Question question : questions) {
			QuestionDTO questionDTO = new QuestionDTO();
			questionDTO.setId(question.getId());
			questionDTO.setQuestionTitle(question.getQuestionTitle());
			questionDTO.setOption1(question.getOption1());
			questionDTO.setOption2(question.getOption2());
			questionDTO.setOption3(question.getOption3());
			questionDTO.setOption4(question.getOption4());
			dto.add(questionDTO);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> getScore(List<ResponseDTO> responses) {
		int right = 0;
		for (ResponseDTO res : responses) {
			Question question = questionRepo.findById(res.getId()).get();
			if (res.getAnswer().equals(question.getRightAnswer())) {
				right++;
			}
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
