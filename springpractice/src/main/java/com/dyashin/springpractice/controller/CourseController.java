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

import com.dyashin.springpractice.requestDTO.CourseReqDTO;
import com.dyashin.springpractice.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("add")
	public ResponseEntity<?> addCourse(@RequestBody CourseReqDTO courseReqDTO) {
		boolean isSaved=courseService.addCourse(courseReqDTO);
		Map<String, Object> response= new LinkedHashMap<>();
		int status= isSaved ? HttpStatus.OK.value() : HttpStatus.BAD_REQUEST.value();
		response.put("status", status);
		if(isSaved) {
			response.put("error", false);
			response.put("message","Course added successfully");
		}else {
			response.put("error", true);
			response.put("message", "Course not added");
		}
		return ResponseEntity.status(status).body(response);
	}
	
}
