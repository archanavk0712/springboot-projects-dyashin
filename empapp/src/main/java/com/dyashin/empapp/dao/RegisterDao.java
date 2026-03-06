package com.dyashin.empapp.dao;

import com.dyashin.empapp.dto.RegistrationDto;

public interface RegisterDao {
	
	public RegistrationDto loginUser(String email, String pass);

	public boolean registerUser(RegistrationDto user);

}