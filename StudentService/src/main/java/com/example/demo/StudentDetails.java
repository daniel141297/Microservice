package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class StudentDetails {

List<Student> studentList;
	
	public List<Student> getStudentList(){
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		return studentList;
	}
	public void setstudentList(List<Student> studentList) {
		 this.studentList=studentList;
	}
}
