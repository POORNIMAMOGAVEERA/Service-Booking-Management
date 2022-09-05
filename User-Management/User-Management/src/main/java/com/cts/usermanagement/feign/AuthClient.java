package com.cts.usermanagement.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.usermanagement.model.JwtResponse;

/*
@FeignClient(name="authorization-service",url="http://localhost:8084")
public interface AuthClient {

	@GetMapping("/api/auth/validate")
	public JwtResponse verifyToken(@RequestHeader(name="authorization",required = true)String token) ;
	
	//@GetMapping("/validate")
	//public JwtResponse verifyToken(@RequestHeader(name="authorization",required = true)String token) ;
				
	
}*/

@FeignClient(name="authorization-service",url="http://localhost:9192")
public interface AuthClient {

	@GetMapping("/validate")
	public JwtResponse getValidity(@RequestHeader("Authorization") final String token) ;
				
	
}