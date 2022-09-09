package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
  
	Employee saveEmployee(Employee employee);
	List<Employee> getempAll();
	Employee getEmpById(long id);
	Employee updateEmployee(Employee employee, long id);
}
