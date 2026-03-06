package com.dyashin.empspringdatajpaapp.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;
import com.dyashin.empspringdatajpaapp.exception.EmployeeException;
import com.dyashin.empspringdatajpaapp.request.EmployeeReqDto;
import com.dyashin.empspringdatajpaapp.service.EmployeeService;
import com.dyashin.empspringdatajpaapp.validation.EmployeeValidation;

//@Controller
@RestController
@RequestMapping("/empl")
public class EmployeeController {
	
//	private static final Logger log=LogManager.getLogger(EmployeeController.class);

	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
//  @ResponseBody
	public ResponseEntity<?> getAll() {
		
		log.info("Control in api1");
		
		List<EmployeeDto> list=service.allData();
		log.debug("Service logic is been invoked and we got the response");
		Map<String, Object> response =new HashMap<>();
		if (list!=null && !list.isEmpty()) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "All records fetched successfully");
			response.put("record", list);
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	@GetMapping("/id")
//	@ResponseBody
	public ResponseEntity<?>  getEmployeeById(@RequestParam("id") int id) throws EmployeeException {
		EmployeeValidation.validateId(id);
		Optional<EmployeeDto> dto = service.getDataById(id);
		Map<String, Object> response =new HashMap<>();
		if (dto.isPresent()) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "Record found");
			response.put("record", dto.get());
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "Record not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
//  @ResponseBody
	public ResponseEntity<?> insertEmp(@RequestBody EmployeeReqDto employeeReqDto) throws EmployeeException{
		EmployeeValidation.validateFields(employeeReqDto);
		boolean saved=service.insertData(employeeReqDto);
		Map<String, Object> response =new HashMap<>();
		if (saved) {
			response.put("status",HttpStatus.CREATED.value());
			response.put("error", false);
			response.put("message", "Employee inserted successfully");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} else {
			response.put("status",HttpStatus.BAD_REQUEST.value());
			response.put("error", true);
			response.put("message", "Unable to insert employee record");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PutMapping("/update")
//    @ResponseBody
	public ResponseEntity<?> updateEmp(@RequestParam("id") int id, @RequestBody EmployeeReqDto employeeReqDto) throws EmployeeException {
		EmployeeValidation.validateFields(employeeReqDto);
		boolean updated=service.update(id, employeeReqDto);
		Map<String, Object> response =new HashMap<>();
		if (updated) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "Employee updated successfully");
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "Unable to update employee record");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
	
	@DeleteMapping("/delete/{id}")
//    @ResponseBody
	public ResponseEntity<?> deleteEmp(@PathVariable("id") int id) throws EmployeeException {
		EmployeeValidation.validateId(id);
		boolean deleted=service.delete(id);
		Map<String, Object> response =new HashMap<>();
		if (deleted) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "Employee deleted successfully");
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "Unable to delete employee record");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
	
	@GetMapping("/count")
	public ResponseEntity<?> emplCount() {
		long count=service.countOfEmp();
		Map<String, Object> response =new HashMap<>();
		response.put("status",HttpStatus.OK.value());
		response.put("error", false);
		response.put("count", count);
		response.put("message", count>0 ? "Total employee count found" : "No employees found");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/maxsalary")
//	@ResponseBody
	public ResponseEntity<?>  maxSalary() throws EmployeeException {
		EmployeeDto maxSalary = service.maxSalary();
		Map<String, Object> response =new HashMap<>();
		if (maxSalary!=null) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "Maximum salary fetched");
			response.put("maxSalary", maxSalary);
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "No Record found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
	
	@GetMapping("/minsalary")
//	@ResponseBody
	public ResponseEntity<?>  minSalary() throws EmployeeException {
		EmployeeDto minSalary = service.minSalary();
		Map<String, Object> response =new HashMap<>();
		if (minSalary!=null) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "Minimun salary fetched");
			response.put("minSalary", minSalary);
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "No Record found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
	
	
	@GetMapping("/getByDesignation/{designation}")
//	@ResponseBody
	public ResponseEntity<?>  getEmployeeByDesignation(@PathVariable("designation") String designation) throws EmployeeException {
		List<EmployeeDto> list = service.getByDesignation(designation);
		Map<String, Object> response =new HashMap<>();
		if (list!=null && !list.isEmpty()) {
			response.put("status",HttpStatus.OK.value());
			response.put("error", false);
			response.put("message", "All records fetched successfully");
			response.put("record", list);
			return ResponseEntity.ok(response);
		} else {
			response.put("status",HttpStatus.NOT_FOUND.value());
			response.put("error", true);
			response.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
}