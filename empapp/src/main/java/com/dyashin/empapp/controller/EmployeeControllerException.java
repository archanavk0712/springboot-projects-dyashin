package com.dyashin.empapp.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dyashin.empapp.exception.EmployeeException;
import com.dyashin.empapp.response.EmployeeResponse;

@RestControllerAdvice
public class EmployeeControllerException {

	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse handleEmployeeException(EmployeeException employeeException) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(404);
		response.setError(true);
		response.setMsg(employeeException.getMessage());
		return response;
	}

	@ExceptionHandler(SQLException.class)
	public EmployeeResponse handleSQLException(SQLException sqlException) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(404);
		response.setError(true);
		response.setMsg(sqlException.getMessage());
		return response;
	}

	@ExceptionHandler(Exception.class)
	public EmployeeResponse handleException(Exception exception) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(404);
		response.setError(true);
		response.setMsg(exception.getMessage());
		return response;
	}
}
