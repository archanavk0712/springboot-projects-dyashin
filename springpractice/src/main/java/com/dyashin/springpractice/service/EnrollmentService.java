package com.dyashin.springpractice.service;

import java.util.List;

import com.dyashin.springpractice.dto.EnrollmentDTO;

public interface EnrollmentService {
	List<EnrollmentDTO> viewAllEnrollments();
	
	boolean enrollStudent(int std_id, int crs_id);
	
	public EnrollmentDTO findByEnrollId(int enroll_id);
}
