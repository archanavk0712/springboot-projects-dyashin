package com.dyashin.empapp.dao;


import java.util.List;
import java.util.Optional;

import com.dyashin.empapp.dto.EmployeeDto;
import com.dyashin.empapp.request.EmployeeReqDto;



public interface EmployeeDao {
	public boolean insertData(EmployeeDto dto);

	public boolean delete(int id);

	public boolean update(int id, EmployeeReqDto dataDto);

	public List<EmployeeDto> allData();

	public Optional<EmployeeDto> getDataById(int id);
	

}