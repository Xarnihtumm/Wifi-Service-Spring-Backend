package com.hostmdy.wifiservice.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	@NotBlank(message = " username email is required")
	private String username;
	
	@NotBlank(message = "password is required")
	private String password;

}
