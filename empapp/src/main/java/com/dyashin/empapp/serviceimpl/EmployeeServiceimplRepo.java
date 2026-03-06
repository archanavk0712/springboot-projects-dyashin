package com.dyashin.empapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dyashin.empapp.dao.EmployeeDaoRepo;
import com.dyashin.empapp.dto.EmployeeDto;
import com.dyashin.empapp.request.EmployeeReqDto;
import com.dyashin.empapp.service.EmployeeService;

public class EmployeeServiceimplRepo implements EmployeeService {
	
	@Autowired
	private EmployeeDaoRepo dao;

	@Override
	public boolean insertData(EmployeeReqDto reqdto) {
		EmployeeDto dto=new EmployeeDto();
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
		EmployeeDto add=dao.save(dto);
		if(add!=null) {
			return true;
		}
		return false;
	}


	@Override
	public boolean delete(int id) {
		Optional<EmployeeDto> dto=dao.findById(id);
		if(dto.isPresent()) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}


	@Override
	public boolean update(int id, EmployeeReqDto reqdto) {
		Optional<EmployeeDto> find=dao.findById(id);
		if(find==null) {
			return false;
		}
		EmployeeDto dto=new EmployeeDto();
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
		EmployeeDto update=dao.save(dto);
		if(update!=null) {
			return true;
		}
		return true;
	}


	@Override
	public List<EmployeeDto> allData() {
		List<EmployeeDto> list=dao.findAll();
		return list;
	}

	@Override
	public Optional<EmployeeDto> getDataById(int id) {
		Optional<EmployeeDto> getById=dao.findById(id);
		if(getById.isPresent()) {
			return Optional.ofNullable(getById.get());
		}
		return null;
	}
}
