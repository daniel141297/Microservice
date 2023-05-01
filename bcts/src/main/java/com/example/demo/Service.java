package com.example.demo;

public class Service {
	private String Service_Name;
	public String getService_Name() {
		return Service_Name;
	}
	public void setService_Name(String service_Name) {
		Service_Name = service_Name;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	private int count;
	public Service(String service_Name, int count) {
		super();
		Service_Name = service_Name;
		
		this.count = count;
	}
	
	
}
