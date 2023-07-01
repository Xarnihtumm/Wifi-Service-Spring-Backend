package com.hostmdy.wifiservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailRequest {
    private String fileContent;
    private String to;
    private String[] cc;
    private String subject;
    private String body;
    
    
	public EmailRequest(String fileContent, String to, String[] cc, String subject, String body) {
		super();
		this.fileContent = fileContent;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.body = body;
	}

   
    
    
}
