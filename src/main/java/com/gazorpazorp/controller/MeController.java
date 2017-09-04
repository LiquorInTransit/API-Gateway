//package com.gazorpazorp.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gazorpazorp.service.MeService;
//
//@RestController
//public class MeController {
//	
//	@Autowired
//	MeService meService;
//
//	@GetMapping("/me")
//	public ResponseEntity me () throws Exception {
//		return Optional.ofNullable(meService.getCustomer())
//				.map(m -> new ResponseEntity(m, HttpStatus.OK))
//				.orElseThrow(() -> new Exception("An error occured"));
//	}
//}
