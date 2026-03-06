package com.dyashin.empspringdatajpaapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;

public interface EmployeeDaoRepo extends JpaRepository<EmployeeDto, Integer> {
	
	@Query("SELECT e FROM EmployeeDto e WHERE e.salary=(SELECT MAX(e1.salary) FROM EmployeeDto e1)")
	EmployeeDto getMaxSalary();

	@Query("SELECT e FROM EmployeeDto e WHERE e.salary=(SELECT MIN(e1.salary) FROM EmployeeDto e1)")
	EmployeeDto getMinSalary();
	
	List<EmployeeDto> findByDesignation(String designation);
}
