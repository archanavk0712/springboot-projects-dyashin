package com.dyashin.springpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.springpractice.dto.StudentDTO;

public interface StudentDAO extends JpaRepository<StudentDTO, Integer> {

	
	
}
