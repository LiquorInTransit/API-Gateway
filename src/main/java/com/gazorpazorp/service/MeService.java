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
	
	private final String IMGUR_URL = "https://i.imgur.com/";

	public CustomerDetailsDto getCustomer() {
		CustomerDetailsDto dto = CustomerMapper.INSTANCE.customerAndUserToCustomerDetailsDto(accountClient.getCustomer().getBody(), userClient.getUser());
		dto.setProfileImageUrl(IMGUR_URL+dto.getProfileImageUrl()+".jpg");
		return dto;
	}
	
	public DriverDetailsDto getDriver() {
		return DriverMapper.INSTANCE.driverAndUserToDriverDetailsDto(accountClient.getDriver(), userClient.getUser());
	}
}
