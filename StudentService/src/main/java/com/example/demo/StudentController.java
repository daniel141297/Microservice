package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	 @Autowired
	 StudentDao service;
	 @GetMapping("/students")
	 public StudentDetails getAllEmployees() {
		 return service.getAllStudents();
	 }
	 
}
