package com.dyashin.empspringdatajpaapp.service;



import java.util.List;
import java.util.Optional;

import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;
import com.dyashin.empspringdatajpaapp.request.EmployeeReqDto;



public interface EmployeeService {
	public boolean insertData(EmployeeReqDto reqdto);

	public boolean delete(int id);

	public boolean update(int id, EmployeeReqDto reqdto);

	public List<EmployeeDto> allData();

	public Optional<EmployeeDto> getDataById(int id);
	
	public long countOfEmp();
	
	public EmployeeDto maxSalary();
	
	public EmployeeDto minSalary();

	public List<EmployeeDto> getByDesignation(String Designation);
}