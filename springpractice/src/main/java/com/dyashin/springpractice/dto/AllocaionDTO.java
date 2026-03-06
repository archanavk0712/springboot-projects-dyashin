package com.dyashin.springpractice.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class AllocaionDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alloc_id;
	
	@OneToMany
	@JoinColumn(name = "emp_id")
	private List<EmployeeDTO> employee;
	
	
	@OneToMany
	@JoinColumn(name = "prj_id")
	private List<ProjectDTO> project;
}
