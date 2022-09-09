package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	 
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		 
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getempAll() {
		 
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmpById(long id) {
		 
	//	return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee", "id", id));
		
		 Optional<Employee> employee=employeeRepository.findById(id);
		 if(employee.isPresent())
		 {
			 return employee.get();
		 }
		 else
		 {
			 throw new ResourceNotFoundException("employee", "id", id);
		 }
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		 Employee exitEmp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee", "id", id));
		 
		 exitEmp.setEname(employee.getEname());
		 exitEmp.setDob(employee.getDob());
		 exitEmp.setPhone(employee.getPhone());
		 exitEmp.setGender(employee.getGender());
		 exitEmp.setSalary(employee.getSalary());
		 
		 employeeRepository.save(exitEmp);
		 
		return exitEmp;
	}

	
}
