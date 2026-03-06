package com.dyashin.springpractice.validation;

import com.dyashin.springpractice.exception.EnrollmentException;
import com.dyashin.springpractice.requestDTO.CourseReqDTO;

public class EnrollmentValidation {

	public static void validateCourses(CourseReqDTO courseReqDTO) throws EnrollmentException {
		if(courseReqDTO.getCrs_id()<=0) {
			throw new EnrollmentException("Id must be positive");
		}
	}

	public static void validateStudent(CourseReqDTO courseReqDTO) throws EnrollmentException {

	}

	public static void validateEnrollment(CourseReqDTO courseReqDTO) throws EnrollmentException {

	}
}
