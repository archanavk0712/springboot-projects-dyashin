package com.dyashin.springpractice.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.springpractice.dto.EnrollmentDTO;
import com.dyashin.springpractice.service.EnrollmentService;

@RestController
@RequestMapping("enrollment")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	@GetMapping("all")
	public ResponseEntity<?> viewAllEnrollment() {
		List<EnrollmentDTO> display = enrollmentService.viewAllEnrollments();
		Map<String, Object> response = new LinkedHashMap<>();
		int status = display.isEmpty() ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value();
		response.put("status", status);
		if (!display.isEmpty()) {
			response.put("error", false);
			response.put("message", "All record fetched");
			response.put("record", display);
		} else {
			response.put("error", true);
			response.put("message", "No record found");
		}
		return ResponseEntity.status(status).body(response);

	}
	
	
	@PostMapping("add")
	public ResponseEntity<?> enrollStudent(@RequestParam("std_id") int std_id, @RequestParam("crs_id") int crs_id) {
		boolean isAdded = enrollmentService.enrollStudent(std_id, crs_id);
		Map<String, Object> response = new LinkedHashMap<>();
		int status = isAdded ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value();
		response.put("status", status);
		if (isAdded) {
			response.put("error", false);
			response.put("message", "Student enrolled successfully");
		} else {
			response.put("error", true);
			response.put("message", "Unable to enroll");
		}
		return ResponseEntity.status(status).body(response);

	}
	
	@GetMapping("id")
	public ResponseEntity<?> findByEnrollId(@RequestParam("enroll_id") int enroll_id) {
		EnrollmentDTO enrollmentDTO = enrollmentService.findByEnrollId(enroll_id);
		Map<String, Object> response = new LinkedHashMap<>();
		int status = enrollmentDTO!=null ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value();
		response.put("status", status);
		if (enrollmentDTO!=null ) {
			response.put("error", false);
			response.put("message", "Record fetched successfulyy");
			response.put("record", enrollmentDTO);
		} else {
			response.put("error", true);
			response.put("message", "Unable to fetch the record");
		}
		return ResponseEntity.status(status).body(response);

	}

}
