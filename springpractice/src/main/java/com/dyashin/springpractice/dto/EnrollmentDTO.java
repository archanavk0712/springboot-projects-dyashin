package com.dyashin.springpractice.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class EnrollmentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enroll_id;
	
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentDTO student; 
	
	@ManyToOne
	@JoinColumn(name = "crs_id")
	private CourseDTO course;
	
	private LocalDate enroll_date;
}
