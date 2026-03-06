package com.dyashin.springpractice.requestDTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EnrollmentReqDTO {

	private int enroll_id;

	private int std_id;

	private int crs_id;

	private LocalDate enroll_date;

}
