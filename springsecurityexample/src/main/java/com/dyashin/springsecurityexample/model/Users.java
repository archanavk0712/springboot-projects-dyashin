package com.dyashin.springsecurityexample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
	private int id;

	private String name;
	
	private String password;

}
