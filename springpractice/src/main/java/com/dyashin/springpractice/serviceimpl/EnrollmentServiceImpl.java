package com.dyashin.springpractice.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.springpractice.dao.CourseDAO;
import com.dyashin.springpractice.dao.EnrollmentDAO;
import com.dyashin.springpractice.dao.StudentDAO;
import com.dyashin.springpractice.dto.CourseDTO;
import com.dyashin.springpractice.dto.EnrollmentDTO;
import com.dyashin.springpractice.dto.StudentDTO;
import com.dyashin.springpractice.exception.EnrollmentException;
import com.dyashin.springpractice.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	EnrollmentDAO enrollmentDAO;

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	CourseDAO courseDAO;

	@Override
	public List<EnrollmentDTO> viewAllEnrollments() {
		List<EnrollmentDTO> list = enrollmentDAO.findAll();
		return list;
	}

	@Override
	public boolean enrollStudent(int std_id, int crs_id) {
		
		StudentDTO studentDTO=studentDAO.findById(std_id).orElseThrow(()->new EnrollmentException("Student not found"));
		
		CourseDTO courseDTO=courseDAO.findById(crs_id).orElseThrow(()->new EnrollmentException("Course not found"));
		
		EnrollmentDTO enrollmentDTO=new EnrollmentDTO();
		enrollmentDTO.setStudent(studentDTO);
		enrollmentDTO.setCourse(courseDTO);
		enrollmentDTO.setEnroll_date(LocalDate.now());
		enrollmentDAO.save(enrollmentDTO);
		return true;
		
	}

	@Override
	public EnrollmentDTO findByEnrollId(int enroll_id) {
		EnrollmentDTO enrollmentDTO=enrollmentDAO.findByEnrollId(enroll_id);
		return enrollmentDTO;
	}

}
