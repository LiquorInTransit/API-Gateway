package com.gazorpazorp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.gazorpazorp.dto.CustomerDetailsDto;
import com.gazorpazorp.dto.DriverDetailsDto;

@FeignClient(name="account-service")
public interface AccountClient {
	
	@GetMapping(value="/me", consumes = "application/json")
	CustomerDetailsDto getCustomer();

	@GetMapping(value="drivers/me", consumes = "application/json")
	DriverDetailsDto getDriver();
}

