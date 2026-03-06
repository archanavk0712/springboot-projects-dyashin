package com.dyashin.springpractice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.springpractice.dao.StudentDAO;
import com.dyashin.springpractice.dto.StudentDTO;
import com.dyashin.springpractice.requestDTO.StudentReqDTO;
import com.dyashin.springpractice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public boolean addStudent(StudentReqDTO studentReqDTO) {
		
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setStd_name(studentReqDTO.getStd_name());
		studentDTO.setStd_email(studentReqDTO.getStd_email());
		if(studentDAO.save(studentDTO) != null) {
			return true;
		}
		return false;
	}

}
