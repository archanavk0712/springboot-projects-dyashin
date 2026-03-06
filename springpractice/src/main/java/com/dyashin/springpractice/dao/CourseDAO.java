package com.dyashin.springpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.springpractice.dto.CourseDTO;

public interface CourseDAO extends JpaRepository<CourseDTO, Integer>{

	
}
