package com.dyashin.springsecurityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dyashin.springsecurityexample.controller.HomeController;
import com.dyashin.springsecurityexample.exception.UserException;
import com.dyashin.springsecurityexample.model.UserPrincipal;
import com.dyashin.springsecurityexample.model.Users;
import com.dyashin.springsecurityexample.repo.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user=userRepo.findByName(username);
		if(user==null) {
			System.out.println("User not found");
			throw new UserException("User not found");
		}
		return new UserPrincipal(user);
	}
} 
