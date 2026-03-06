package com.dyashin.springpractice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProjectDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prj_id;
	
	private String prj_name;
	
	private String prj_duration;
}
