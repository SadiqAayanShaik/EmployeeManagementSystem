package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class HomeController {
	
	
	private EmployeeService employeeService;
	
	
	public HomeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Employee> getAll()
	{
		return employeeService.getempAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") long employyeeid)
	{
		return new ResponseEntity<Employee>(employeeService.getEmpById(employyeeid),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> getEmpUpdate(@PathVariable("id") long id,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(emp,id),HttpStatus.OK);
	}
}
