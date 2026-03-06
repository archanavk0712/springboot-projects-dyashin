package com.dyashin.empspringdatajpaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(value = "*")
public class EmpspringdatajpaappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpspringdatajpaappApplication.class, args);
	}
}
