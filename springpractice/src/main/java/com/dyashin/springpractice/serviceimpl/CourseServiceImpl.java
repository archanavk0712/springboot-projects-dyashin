package com.dyashin.springpractice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.springpractice.dao.CourseDAO;
import com.dyashin.springpractice.dto.CourseDTO;
import com.dyashin.springpractice.requestDTO.CourseReqDTO;
import com.dyashin.springpractice.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public boolean addCourse(CourseReqDTO courseReqDTO) {
		CourseDTO courseDTO=new CourseDTO();
		courseDTO.setCrs_title(courseReqDTO.getCrs_title());
		courseDTO.setCrs_duration(courseReqDTO.getCrs_duration());
		if(courseDAO.save(courseDTO) != null) {
			return true;
		}
		return false;
	}

}
