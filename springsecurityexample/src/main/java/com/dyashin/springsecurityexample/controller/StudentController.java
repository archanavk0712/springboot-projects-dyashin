package com.dyashin.springsecurityexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.springsecurityexample.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> s=new ArrayList<>(List.of(
			new Student(1, "abc"),new Student(2, "pqr")));

	@GetMapping("/student")
	public List<Student> getStudents() {
		return s;
	}
	
	@GetMapping("/csrftoken")
	public CsrfToken getCsrfToken(HttpServletRequest req){
		return (CsrfToken) req.getAttribute("_csrf");  		//returns an object but we need token hence type casted
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		s.add(student);
		return student;
	}
}
