package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class StudentDao {

	 static StudentDetails StudentDetails = new StudentDetails();
	 static {
		 StudentDetails.getStudentList().add(new Student(123,"Daniel","john"));
		 StudentDetails.getStudentList().add(new Student(124,"Nancy","arun"));
		 StudentDetails.getStudentList().add(new Student(125,"Daniel","ansi"));
		 
	 }
	 public StudentDetails getAllStudents() {
		 return StudentDetails;
	 }
}
