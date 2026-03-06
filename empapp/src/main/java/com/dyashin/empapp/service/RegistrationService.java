package com.dyashin.empapp.service;

import com.dyashin.empapp.dto.RegistrationDto;
import com.dyashin.empapp.request.RegistrationReqDto;

public interface RegistrationService {
	
	public RegistrationDto loginUser(String email, String pass);

	public boolean registerUser(RegistrationReqDto user);

}