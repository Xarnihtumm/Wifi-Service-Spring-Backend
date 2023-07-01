package com.hostmdy.wifiservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AttachmentEmailRequest {
	String to;
	String subject;
	String filePath;
	String text;
}
