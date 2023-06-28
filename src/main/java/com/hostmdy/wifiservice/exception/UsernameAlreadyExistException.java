package com.hostmdy.wifiservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,code = HttpStatus.BAD_REQUEST,reason = "cause : Username is already exists")
public class UsernameAlreadyExistException extends RuntimeException{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
