package com.cts.productmanagement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.productmanagement.model.JwtResponse;


@FeignClient(name="authorization-service",url="http://localhost:9192")
public interface AuthClient {

	@GetMapping("/validate")
	public JwtResponse getValidity(@RequestHeader("Authorization") final String token) ;
				
	
}

