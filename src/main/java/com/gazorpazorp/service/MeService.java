package com.gazorpazorp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gazorpazorp.client.AccountClient;
import com.gazorpazorp.dto.CustomerDetailsDto;
import com.gazorpazorp.dto.DriverDetailsDto;

@Service
public class MeService {
	
	@Autowired
	AccountClient accountClient;

	public CustomerDetailsDto getCustomer() {
		return accountClient.getCustomer();
	}
	
	public DriverDetailsDto getDriver() {
		return accountClient.getDriver();
	}
}
