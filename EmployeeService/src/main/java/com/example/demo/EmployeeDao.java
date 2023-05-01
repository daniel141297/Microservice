package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class EmployeeDao {

	
	static EmployeeDetails employeeDetails = new EmployeeDetails();
	  static {
		  employeeDetails.getEmployeeList().add(new Employee(1234,"Nancy","Uk"));
		  employeeDetails.getEmployeeList().add(new Employee(1235,"Jack","Us"));
		  employeeDetails.getEmployeeList().add(new Employee(1236,"peter","Germancy"));
		  employeeDetails.getEmployeeList().add(new Employee(1237,"Arun","India"));
		  employeeDetails.getEmployeeList().add(new Employee(1238,"Guru","Australia"));
	  }
	  public EmployeeDetails getAllEmployees() {
			return employeeDetails;
		}
}
