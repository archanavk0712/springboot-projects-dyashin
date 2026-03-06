package com.dyashin.springsecurityexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyashin.springsecurityexample.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Users findByName(String username);

}
