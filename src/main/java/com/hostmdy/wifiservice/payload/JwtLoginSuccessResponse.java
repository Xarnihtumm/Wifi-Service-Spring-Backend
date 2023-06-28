package com.hostmdy.wifiservice.payload;

import com.hostmdy.wifiservice.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtLoginSuccessResponse {
	
	private boolean success;
	private String token;
	private User user;

}
