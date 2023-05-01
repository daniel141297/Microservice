package com.example.demo;

import com.example.data.*;
import com.example.model.*;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	HomeModel model;
	
	 @RequestMapping(value="/home")
	    public String details(@RequestParam(value = "time")String time) {
		
		// System.out.println(time);
	
		 LocalDateTime.now().minusHours(168);
		 
			/*
			 * HashMap map = new HashMap();
			 * 
			 * map.put ("count",27); map.put ("Service_Name","Service 1"); map.put
			 * ("count",26); map.put ("Service_Name","Service 2");
			 */
		 if(time.equals("4")) {
			
			 ServiceDetails  data=  getAllService4();
			 Gson json=new Gson();
			 String details =json.toJson(data);
			
		        return details;
		 }else if(time.equals("8")){
			 ServiceDetails  data=  getAllService8();
			 Gson json=new Gson();
			 String details =json.toJson(data);
			   
		        return details;
		 }else if(time.equals("12")) {
			 ServiceDetails  data= getAllService12();
			 Gson json=new Gson();
			 String details =json.toJson(data);
			   
		        return details;
		 }else if(time.equals("24")) {
			 ServiceDetails  data=  getAllService24();
			 Gson json=new Gson();
			 String details =json.toJson(data);
			   
		        return details;
		 }else if(time.equals("168")) {
			 ServiceDetails  data=  getAllService168();
			 Gson json=new Gson();
			 String details =json.toJson(data);
			   
		        return details;
		 }
		return null;
			
		 
		/*List<Homedata> data= jdbcTemplate.query("select * from services_details", new getdata());

//		String s = "[{"Service_Name":"service 1                                                                                                                                             ","count_four":0,"count":0,"count_eight":1},{"Service_Name":"service 2                                                                                                                                             ","count_four":0,"count":10,"count_eight":11},{"Service_Name":"service 3                                                                                                                                             ","count_four":0,"count":70,"count_eight":0},{"Service_Name":"service 4                                                                                                                                             ","count_four":0,"count":80,"count_eight":10},{"Service_Name":"service 5                                                                                                                                             ","count_four":0,"count":90,"count_eight":10},{"Service_Name":"service 6                                                                                                                                             ","count_four":0,"count":0,"count_eight":10},{"Service_Name":"service 7                                                                                                                                             ","count_four":0,"count":50,"count_eight":30}]";
		 Gson json=new Gson();
		 String details =json.toJson(data);
		   
	        return details;*/
	    }
	
	 static ServiceDetails serviceDetails4 = new ServiceDetails();
	  static {
		  serviceDetails4.getServiceList().add(new Service("Service1",4));
		  serviceDetails4.getServiceList().add(new Service("Service2",3));
		  serviceDetails4.getServiceList().add(new Service("Service3",0));
		  serviceDetails4.getServiceList().add(new Service("Service4",8));
		  serviceDetails4.getServiceList().add(new Service("Service5",10));
	  }
	  public ServiceDetails getAllService4() {
		  System.out.println("sdfhjdf");
			return serviceDetails4;
		} 
	  static ServiceDetails serviceDetails8 = new ServiceDetails();
	  static {
		  serviceDetails8.getServiceList().add(new Service("Service1",0));
		  serviceDetails8.getServiceList().add(new Service("Service2",3));
		  serviceDetails8.getServiceList().add(new Service("Service3",0));
		  serviceDetails8.getServiceList().add(new Service("Service4",89));
		  serviceDetails8.getServiceList().add(new Service("Service5",10));
	  }
	  public ServiceDetails getAllService8() {
			return serviceDetails8;
		} 
	  static ServiceDetails serviceDetails12 = new ServiceDetails();
	  static {
		  serviceDetails12.getServiceList().add(new Service("Service1",100));
		  serviceDetails12.getServiceList().add(new Service("Service2",0));
		  serviceDetails12.getServiceList().add(new Service("Service3",40));
		  serviceDetails12.getServiceList().add(new Service("Service4",0));
		  serviceDetails12.getServiceList().add(new Service("Service5",180));
	  }
	  public ServiceDetails getAllService12() {
			return serviceDetails12;
		} 
	  static ServiceDetails serviceDetails24 = new ServiceDetails();
	  static {
		  serviceDetails24.getServiceList().add(new Service("Service1",0));
		  serviceDetails24.getServiceList().add(new Service("Service2",19));
		  serviceDetails24.getServiceList().add(new Service("Service3",42));
		  serviceDetails24.getServiceList().add(new Service("Service4",85));
		  serviceDetails24.getServiceList().add(new Service("Service5",0));
	  }
	  public ServiceDetails getAllService24() {
			return serviceDetails24;
		} 
	  static ServiceDetails serviceDetails168 = new ServiceDetails();
	  static {
		  serviceDetails168.getServiceList().add(new Service("Service1",0));
		  serviceDetails168.getServiceList().add(new Service("Service2",0));
		  serviceDetails168.getServiceList().add(new Service("Service3",45));
		  serviceDetails168.getServiceList().add(new Service("Service4",87));
		  serviceDetails168.getServiceList().add(new Service("Service5",90));
	  }
	  public ServiceDetails getAllService168() {
			return serviceDetails168;
		} 
	
	 private static final class getdata implements RowMapper<Homedata>{
			
		public Homedata mapRow(ResultSet rs,int rowNum) throws SQLException{

			Homedata data=new Homedata();
			data.setService_Name(rs.getString("name_of_services"));
			data.setCount(rs.getInt("count_in_last_four_hour"));
			data.setCount_eight(rs.getInt("count_in_last_eight_hour"));
			data.setCount_eight(rs.getInt("count_in_last_eight_hour"));
			return data;
			
			
		}
	   
	 }
		
}
