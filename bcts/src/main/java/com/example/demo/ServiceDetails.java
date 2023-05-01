package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ServiceDetails {

	List<Service> serviceList;
	
	public List<Service> getServiceList(){
		if(serviceList == null) {
			serviceList = new ArrayList<Service>();
		}
		return serviceList;
	}
	public void setServiceList(List<Service> serviceList) {
		 this.serviceList=serviceList;
	}
}
