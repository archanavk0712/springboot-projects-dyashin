package com.dyashin.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.quizservice.DTO.QuestionDTO;
import com.dyashin.quizservice.DTO.QuizDTO;
import com.dyashin.quizservice.DTO.ResponseDTO;
import com.dyashin.quizservice.repo.QuizRepo;
import com.dyashin.quizservice.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizRepo quizRepo;

	@Autowired
	private QuizService quizService;

    QuizController(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }

	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizdto) {
		return quizService.createQuiz(quizdto.getCategory(), quizdto.getNumQues(), quizdto.getTitle());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<ResponseDTO> response){
		return quizService.calculateResult(id, response);
		
	}
}
