package com.dyashin.empapp.request;

import lombok.Data;

@Data
public class RegistrationReqDto {

	private int id;

	private String name;

	private String email;

	private long mobile_no;

	private String pass;

}