package com.dyashin.empapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.empapp.dto.EmployeeDto;

public interface EmployeeDaoRepo extends JpaRepository<EmployeeDto, Integer> {
	
}
