package com.dyashin.springpractice.requestDTO;

import lombok.Data;

@Data
public class StudentReqDTO {

	private int std_id;

	private String std_name;

	private String std_email;
}
