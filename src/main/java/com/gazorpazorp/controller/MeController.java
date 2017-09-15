package com.gazorpazorp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gazorpazorp.dto.CustomerDetailsDto;
import com.gazorpazorp.dto.DriverDetailsDto;
import com.gazorpazorp.service.MeService;

@RestController
@RequestMapping("/api")
public class MeController {
	
	@Autowired
	MeService meService;

	@GetMapping("/me")
	@PreAuthorize("#oauth2.hasScope('customer')")
	public ResponseEntity<CustomerDetailsDto> me () throws Exception {
		return Optional.ofNullable(meService.getCustomer())
				.map(c -> new ResponseEntity<CustomerDetailsDto>(c, HttpStatus.OK))
				.orElseThrow(() -> new Exception("An error occured"));
	}
	@GetMapping("/drivers/me")
	@PreAuthorize("#oauth2.hasScope('driver')")
	public ResponseEntity<DriverDetailsDto> driverMe () throws Exception {
		return Optional.ofNullable(meService.getDriver())
				.map(d -> new ResponseEntity<DriverDetailsDto>(d, HttpStatus.OK))
				.orElseThrow(() -> new Exception("An error occured"));
	}
}
