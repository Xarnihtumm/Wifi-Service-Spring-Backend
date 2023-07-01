package com.hostmdy.wifiservice.service;

import com.hostmdy.wifiservice.payload.AttachmentEmailRequest;
import com.hostmdy.wifiservice.payload.SimpleEmailRequest;

public interface EmailService {

	void sendEmail(SimpleEmailRequest email);
	
	void sendAttachmentEmail(AttachmentEmailRequest email);
}
