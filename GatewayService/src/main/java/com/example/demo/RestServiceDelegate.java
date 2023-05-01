package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceDelegate {
	@Bean
	public RestTemplate getTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	@Autowired
	private RestTemplate template;
	public String loadEmp() {
		//String response=template.exchange
		String products= template.getForObject("http://192.168.1.100:8081/employees",String.class);
		return products;
		/*String response=template.exchange("http://192.168.1.100:8081/employees",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<String>() {}).getBody();
		return response;*/
	}

}
