package com.dyashin.springpractice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class CourseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int crs_id;
	
	private String crs_title;
	
	private int crs_duration;
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<EnrollmentDTO> enrollments;
	
}
