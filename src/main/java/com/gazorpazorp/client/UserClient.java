package com.gazorpazorp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gazorpazorp.model.User;

@FeignClient(name="uaa-service")
public interface UserClient {
	@GetMapping(value="/me", consumes = "application/json")
	User getUser();
}
