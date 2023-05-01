package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao service;
    
	@GetMapping("/employees")
	public EmployeeDetails getAllEmployees() {
		return service.getAllEmployees();
	}
}
