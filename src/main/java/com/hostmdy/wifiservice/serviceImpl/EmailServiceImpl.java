package com.hostmdy.wifiservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.payload.AttachmentEmailRequest;
import com.hostmdy.wifiservice.payload.SimpleEmailRequest;
import com.hostmdy.wifiservice.service.EmailService;
import com.hostmdy.wifiservice.utility.MailConstructor;

@Service
public class EmailServiceImpl implements EmailService {
	
	private final JavaMailSender sender;
	private final MailConstructor mailConstructor;
	
	

	@Autowired
	public EmailServiceImpl(JavaMailSender sender, MailConstructor mailConstructor) {
		super();
		this.sender = sender;
		this.mailConstructor = mailConstructor;
	}

	@Override
	public void sendEmail(SimpleEmailRequest email) {
		// TODO Auto-generated method stub
		SimpleMailMessage mail = mailConstructor.constructSimpleMail(email.getTo(),email.getSubject(),email.getText());
		sender.send(mail);
	}

	@Override
	public void sendAttachmentEmail(AttachmentEmailRequest email) {
		// TODO Auto-generated method stub
		MimeMessagePreparator mail = mailConstructor.constructAttachmentMail(email.getTo(),email.getSubject(),email.getFilePath(),email.getText());
		sender.send(mail);
	}

}
