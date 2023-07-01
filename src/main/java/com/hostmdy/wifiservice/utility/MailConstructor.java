package com.hostmdy.wifiservice.utility;
import java.io.File;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import jakarta.mail.internet.InternetAddress;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MailConstructor {
	
	private final Environment env;

	private final ClasspathFileLoader classpathFileLoader;
	
	public SimpleMailMessage constructSimpleMail(String to,String subject,String text) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(env.getProperty("support.mail"));
		email.setTo(to);
		email.setSubject(subject);
		email.setText(text);
		return email;
	}
	
	public MimeMessagePreparator constructAttachmentMail(String to,String subject,String filePath,String text) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
			messageHelper.setFrom(env.getProperty("support.mail"));
			messageHelper.setTo(new InternetAddress(to));
			messageHelper.setSubject(subject);
			messageHelper.setText(text);
			messageHelper.addAttachment("Attachment",new File(classpathFileLoader.getClasspathFileRelativePath(filePath)));
		};
		
		return messagePreparator;
	}
	

}
