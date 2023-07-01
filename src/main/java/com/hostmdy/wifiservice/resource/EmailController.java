package com.hostmdy.wifiservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.wifiservice.payload.AttachmentEmailRequest;
import com.hostmdy.wifiservice.payload.SimpleEmailRequest;
import com.hostmdy.wifiservice.service.EmailService;


@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = { "http://localhost:3000" })
public class EmailController {
	
	
	
	
private final EmailService emailService;




	@Autowired
	public EmailController(EmailService emailService) {
	super();
	this.emailService = emailService;
}

	@PostMapping("/contact")
	public ResponseEntity<String> sendEmail(@RequestBody SimpleEmailRequest emailRequest){
		emailService.sendEmail(emailRequest);
		
		return ResponseEntity.ok("Email Sent");
	}
	
	@PostMapping("/attachment")
	public ResponseEntity<String> sendAttachmentEmail(@RequestBody AttachmentEmailRequest emailRequest){
		emailService.sendAttachmentEmail(emailRequest);
		
		return ResponseEntity.ok("Email Sent");
	}

}
