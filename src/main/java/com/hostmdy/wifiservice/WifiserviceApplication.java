package com.hostmdy.wifiservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.wifiservice.service.UserService;

@SpringBootApplication
public class WifiserviceApplication {

	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(WifiserviceApplication.class, args);
	}

}
