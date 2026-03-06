package com.dyashin.springsecurityexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletRequest req) {
		return " Hi "+ " Session id: "+req.getSession().getId();
	}
}
