package com.dyashin.springpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dyashin.springpractice.dto.EnrollmentDTO;

public interface EnrollmentDAO extends JpaRepository<EnrollmentDTO, Integer>{
	
	@Query("SELECT e FROM EnrollmentDTO e WHERE e.enroll_id=1 ")
	public EnrollmentDTO findByEnrollId(int enroll_id);
	
}
