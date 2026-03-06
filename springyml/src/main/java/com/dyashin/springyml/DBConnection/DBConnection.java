package com.dyashin.springyml.DBConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBConnection {
	
	@Value("${db.username}")
	String username;
	
	@Value("${db.password}")
	String password;
	
	@PostConstruct
	public void init() {
		System.out.println("DBConnection initializing");
		System.out.println("Username: "+username+ " | Password: "+password);
	}
}
