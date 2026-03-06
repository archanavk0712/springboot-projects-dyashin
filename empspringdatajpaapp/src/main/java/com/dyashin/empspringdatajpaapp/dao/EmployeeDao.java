package com.dyashin.empspringdatajpaapp.dao;


import java.util.List;
import java.util.Optional;

import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;
import com.dyashin.empspringdatajpaapp.request.EmployeeReqDto;



public interface EmployeeDao {
	public boolean insertData(EmployeeDto dto);

	public boolean delete(int id);

	public boolean update(int id, EmployeeReqDto dataDto);

	public List<EmployeeDto> allData();

	public Optional<EmployeeDto> getDataById(int id);
	

}