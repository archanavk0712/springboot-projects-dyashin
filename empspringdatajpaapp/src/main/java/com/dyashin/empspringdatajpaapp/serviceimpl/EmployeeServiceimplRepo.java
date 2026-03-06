package com.dyashin.empspringdatajpaapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.empspringdatajpaapp.controller.EmployeeController;
import com.dyashin.empspringdatajpaapp.dao.EmployeeDaoRepo;
import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;
import com.dyashin.empspringdatajpaapp.mapper.EmployeeMapper;
import com.dyashin.empspringdatajpaapp.request.EmployeeReqDto;
import com.dyashin.empspringdatajpaapp.service.EmployeeService;

@Service
public class EmployeeServiceimplRepo implements EmployeeService {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);

	private EmployeeDaoRepo dao;
	private EmployeeMapper employeeMapper;
	public EmployeeServiceimplRepo(EmployeeDaoRepo dao, EmployeeMapper employeeMapper) {
		this.dao=dao;
		this.employeeMapper=employeeMapper;
	}
	
	@Override
	public boolean insertData(EmployeeReqDto reqdto) {
		EmployeeDto dto=new EmployeeDto();
		
		dto=employeeMapper.mapEmployeeReqToDto(reqdto);
		
//		dto.setLastName(reqdto.getLastName());
//		dto.setFname(reqdto.getFname());
//		dto.setEmail(reqdto.getEmail());
//		dto.setAge(reqdto.getAge());
//		dto.setPhoneNumber(reqdto.getPhoneNumber());
//		dto.setDob(reqdto.getDob());
//		dto.setGender(reqdto.getGender());
//		dto.setJoiningDate(reqdto.getJoiningDate());
//		dto.setDeptNumber(reqdto.getDeptNumber());
//		dto.setDesignation(reqdto.getDesignation());
//		dto.setExperience(reqdto.getExperience());
//		dto.setSalary(reqdto.getSalary());
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
		if(find.isPresent()) {
		EmployeeDto dto=find.get();
		
		dto=employeeMapper.mapEmployeeReqToDto(reqdto);
//		dto.setLastName(reqdto.getLastName());
//		dto.setFname(reqdto.getFname());
//		dto.setEmail(reqdto.getEmail());
//		dto.setAge(reqdto.getAge());
//		dto.setPhoneNumber(reqdto.getPhoneNumber());
//		dto.setDob(reqdto.getDob());
//		dto.setGender(reqdto.getGender());
//		dto.setJoiningDate(reqdto.getJoiningDate());
//		dto.setDeptNumber(reqdto.getDeptNumber());
//		dto.setDesignation(reqdto.getDesignation());
//		dto.setExperience(reqdto.getExperience());
//		dto.setSalary(reqdto.getSalary());
		dao.save(dto);
			return true;
		}
		return false;
	}


	@Override
	public List<EmployeeDto> allData() {
		log.trace("Service/Business logic is been invoked");
		List<EmployeeDto> list=dao.findAll();
		return list;
	}

	@Override
	public Optional<EmployeeDto> getDataById(int id) {
		return dao.findById(id);
	}


	@Override
	public long countOfEmp() {
		return dao.count();
	}


	@Override
	public EmployeeDto maxSalary() {
		return dao.getMaxSalary();
	}


	@Override
	public EmployeeDto minSalary() {
		return dao.getMinSalary();
	}


	@Override
	public List<EmployeeDto> getByDesignation(String Designation) {
		return dao.findByDesignation(Designation);
	}
}
