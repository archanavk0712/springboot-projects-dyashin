package com.dyashin.empapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.empapp.dao.EmployeeDao;
import com.dyashin.empapp.dto.EmployeeDto;
import com.dyashin.empapp.request.EmployeeReqDto;
import com.dyashin.empapp.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Override
	public boolean insertData(EmployeeReqDto reqdto) {

		EmployeeDto dto = new EmployeeDto();
		dto.setLastName(reqdto.getLastName());
		dto.setFname(reqdto.getFname());
		dto.setEmail(reqdto.getEmail());
		dto.setAge(reqdto.getAge());
		dto.setPhoneNumber(reqdto.getPhoneNumber());
		dto.setDob(reqdto.getDob());
		dto.setGender(reqdto.getGender());
		dto.setJoiningDate(reqdto.getJoiningDate());
		dto.setDeptNumber(reqdto.getDeptNumber());
		dto.setDesignation(reqdto.getDesignation());
		dto.setExperience(reqdto.getExperience());
		dto.setSalary(reqdto.getSalary());

		boolean insert = dao.insertData(dto);
		return insert;
	}

	@Override
	public boolean delete(int id) {
		boolean delete = dao.delete(id);
		return delete;

	}

	@Override
	public boolean update(int id, EmployeeReqDto reqdto) {

		boolean update = dao.update(id, reqdto);

		return update;
	}

	@Override
	public List<EmployeeDto> allData() {
		List<EmployeeDto> list = dao.allData();
		return list;
	}

	@Override
	public Optional<EmployeeDto> getDataById(int id) {
		Optional<EmployeeDto> dto = dao.getDataById(id);
		return dto;
	}

}