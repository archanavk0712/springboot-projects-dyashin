package com.dyashin.empspringdatajpaapp.response;


import java.util.List;

import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class EmployeeResponse {
	private int statusCode;
	private boolean error;
	private String msg;
	private EmployeeDto singeRecord;
	private List<EmployeeDto> allRecord;
}
