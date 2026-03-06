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
public class StudentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int std_id;
	
	private String std_name;
	
	private String std_email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<EnrollmentDTO> enrollments;
}
