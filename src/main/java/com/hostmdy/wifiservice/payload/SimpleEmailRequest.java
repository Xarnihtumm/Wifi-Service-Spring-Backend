package com.hostmdy.wifiservice.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SimpleEmailRequest {
	
	private String to;
	private String subject;
	private String text;
	
}
