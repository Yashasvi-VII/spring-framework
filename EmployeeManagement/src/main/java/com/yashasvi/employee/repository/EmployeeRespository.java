package com.yashasvi.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashasvi.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
