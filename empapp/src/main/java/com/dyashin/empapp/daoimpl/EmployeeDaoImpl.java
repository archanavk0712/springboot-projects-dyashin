package com.dyashin.empapp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dyashin.empapp.dao.EmployeeDao;
import com.dyashin.empapp.dto.EmployeeDto;
import com.dyashin.empapp.request.EmployeeReqDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean insertData(EmployeeDto dto) {
		manager.persist(dto);
		return true;
	}

	@Override
	public boolean delete(int id) {
//			EmployeeDto employeeDto = manager.getReference(EmployeeDto.class, id); // Get a proxy reference
		EmployeeDto employeeDto = manager.find(EmployeeDto.class, id);
		if (employeeDto != null) {
			manager.remove(employeeDto);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(int id, EmployeeReqDto dataDto) {
		EmployeeDto employeeDto = manager.find(EmployeeDto.class, id);
		if (employeeDto == null) {
			return false;
		}
		employeeDto.setFname(dataDto.getFname());
		employeeDto.setLastName(dataDto.getLastName());
		employeeDto.setEmail(dataDto.getEmail());
		employeeDto.setAge(dataDto.getAge());
		employeeDto.setPhoneNumber(dataDto.getPhoneNumber());
		employeeDto.setDob(dataDto.getDob());
		employeeDto.setGender(dataDto.getGender());
		employeeDto.setJoiningDate(dataDto.getJoiningDate());
		employeeDto.setDeptNumber(dataDto.getDeptNumber());
		employeeDto.setDesignation(dataDto.getDesignation());
		employeeDto.setExperience(dataDto.getExperience());
		employeeDto.setSalary(dataDto.getSalary());
		manager.merge(employeeDto);
		return true;
	}

	@Override
	public List<EmployeeDto> allData() {
		String jpql = "select d from EmployeeDto d";
		TypedQuery<EmployeeDto> info = manager.createQuery(jpql, EmployeeDto.class);
		List<EmployeeDto> list = info.getResultList();
		return list;
	}

	@Override
	public Optional<EmployeeDto> getDataById(int id) {
		EmployeeDto dto = manager.find(EmployeeDto.class, id);
		return Optional.ofNullable(dto);
	}
}