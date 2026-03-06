package com.dyashin.springpractice.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.springpractice.requestDTO.StudentReqDTO;
import com.dyashin.springpractice.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("add")
	public ResponseEntity<?> addStudent(@RequestBody StudentReqDTO studentReqDTO){
		
		boolean isAdded=studentService.addStudent(studentReqDTO);
		Map<String, Object> response=new LinkedHashMap<>();
		int status= isAdded ? HttpStatus.OK.value() : HttpStatus.BAD_REQUEST.value();
		response.put("status", status);
		if(isAdded) {
			response.put("error", false);
			response.put("message", "Student added successfully");
		}else {
			response.put("error", true);
			response.put("message", "Student not added");
		}
		return ResponseEntity.status(status).body(response);
	}
}
