package com.dyashin.empapp.service;



import java.util.List;
import java.util.Optional;

import com.dyashin.empapp.dto.EmployeeDto;
import com.dyashin.empapp.request.EmployeeReqDto;



public interface EmployeeService {
	public boolean insertData(EmployeeReqDto reqdto);

	public boolean delete(int id);

	public boolean update(int id, EmployeeReqDto reqdto);

	public List<EmployeeDto> allData();

	public Optional<EmployeeDto> getDataById(int id);
	
	

}