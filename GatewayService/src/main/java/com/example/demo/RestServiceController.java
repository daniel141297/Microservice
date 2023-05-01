package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServiceController {

	@Autowired
	RestServiceDelegate delegate;
	@GetMapping("/loademp")
	public String loademp() {
		return delegate.loadEmp();
	}
}
