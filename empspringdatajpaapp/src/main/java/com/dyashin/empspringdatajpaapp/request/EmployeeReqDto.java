package com.dyashin.empspringdatajpaapp.request;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonRootName("employee")
public class EmployeeReqDto {

	private int id;

	private String fname;

	private String lName;

	private String email;

	private String phoneNumber;

	private int age;

	private LocalDate dob;

	private String gender;

	private LocalDate joiningDate;

	private int deptNumber;

	private String designation;

	private int experience;

	private double salary;

}