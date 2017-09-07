package com.gazorpazorp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.gazorpazorp.model.User;

@FeignClient(name="uaa-service")
public interface UserClient {
	@GetMapping(value="/uaa/me", consumes = "application/json")
	User getUser();
}
