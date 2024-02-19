package com.yashasvi.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashasvi.employee.service.EmployeeService;
import com.yashasvi.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee rest API
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeService.saveEmployee(employee) ,HttpStatus.CREATED);
	}
}
