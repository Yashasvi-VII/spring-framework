package com.yashasvi.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yashasvi.entity.Employee;

@Service
public interface EmployeeService {

	Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
	
}
