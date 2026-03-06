package com.dyashin.empapp.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@JsonRootName("employee")
@JsonPropertyOrder({"id","Name","LName","phoneNumber","email","dob","age","gender"})
@JsonInclude(value = Include.NON_NULL)
public class EmployeeDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fname")
	@JsonProperty("Name")
	private String fname;

	@Column(name = "last_name")
	@JsonProperty("LName")
	private String lastName;

	@Column(name = "email")
	@JsonIgnore
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "age")
	private int age;

	@Column(name = "DOB")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "joining_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	@Column(name = "dept_number")
	private int deptNumber;

	@Column(name = "designation")
	private String designation;

	@Column(name = "experience")
	private int experience;

	@Column(name = "salary")
	private double salary;
}