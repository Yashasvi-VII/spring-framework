package com.yashasvi.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashasvi.employee.service.EmployeeService;
import com.yashasvi.entity.Employee;
import com.yashasvi.employee.exception.ResourceNotFoundException;
import com.yashasvi.employee.repository.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRepository;

	public EmployeeServiceImpl(EmployeeRespository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {

		// check if employee exists in database or not
		// this is lambda expression
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// save existing employee to db
		employeeRepository.save(existingEmployee);

		// return existingEmployee to controller
		return existingEmployee;
	}

}
