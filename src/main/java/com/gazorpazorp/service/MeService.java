package com.gazorpazorp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gazorpazorp.client.AccountClient;
import com.gazorpazorp.client.UserClient;
import com.gazorpazorp.dto.CustomerDetailsDto;
import com.gazorpazorp.dto.DriverDetailsDto;
import com.gazorpazorp.model.dtoMapper.CustomerMapper;
import com.gazorpazorp.model.dtoMapper.DriverMapper;

@Service
public class MeService {
	
	@Autowired
	AccountClient accountClient;
	
	@Autowired
	UserClient userClient;

	public CustomerDetailsDto getCustomer() {
		return CustomerMapper.INSTANCE.customerAndUserToCustomerDetailsDto(accountClient.getCustomer().getBody(), userClient.getUser());
	}
	
	public DriverDetailsDto getDriver() {
		return DriverMapper.INSTANCE.driverAndUserToDriverDetailsDto(accountClient.getDriver(), userClient.getUser());
	}
}
