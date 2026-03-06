package com.dyashin.coreconnectmessagingplatform.DBConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class MySQLConnection {

	@Value("${db.username}")
	String username;

	@Value("${db.password}")
	String password;

	@PostConstruct
	public void init() {
		System.out.println("MySQLConnection initializing");
		System.out.println("Username: " + username + " | Password: " + password);
	}
}