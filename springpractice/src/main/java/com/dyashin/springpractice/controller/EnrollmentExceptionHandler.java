package com.dyashin.springpractice.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dyashin.springpractice.exception.EnrollmentException;

@RestControllerAdvice
public class EnrollmentExceptionHandler {

	@ExceptionHandler(EnrollmentException.class)
	public ResponseEntity<?> handleENrollmentException(EnrollmentException enrollmentException){
		Map<String, Object> response=new LinkedHashMap<>();
		response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.put("error", true);
		response.put("message", enrollmentException.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception){
		Map<String, Object> response=new LinkedHashMap<>();
		response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.put("error", true);
		response.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
	}
}
