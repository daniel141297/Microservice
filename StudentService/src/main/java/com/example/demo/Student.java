package com.example.demo;

public class Student {
	private int rollno;
	
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	private String firstName,LastName;

	public Student(int rollno, String firstName, String lastName) {
		super();
		this.rollno = rollno;
		this.firstName = firstName;
		LastName = lastName;
	}
}
