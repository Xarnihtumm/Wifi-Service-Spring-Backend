//////package com.hostmdy.wifiservice.resource;
//////
//////
//////
//////import com.hostmdy.wifiservice.service.EmailService;
//////
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.web.bind.annotation.PostMapping;
//////import org.springframework.web.bind.annotation.RequestMapping;
//////import org.springframework.web.bind.annotation.RequestParam;
//////import org.springframework.web.bind.annotation.RestController;
//////import org.springframework.web.multipart.MultipartFile;
//////
//////
//////@RestController
//////@RequestMapping("/mail")
//////public class EmailSendController {
//////    private EmailService emailService;
//////
//////    @Autowired
//////    public EmailSendController(EmailService emailService) {
//////        this.emailService = emailService;
//////    }
//////
//////    @PostMapping("/send")
//////    public String sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file, String to, String[] cc, String subject, String body) {
//////        return emailService.sendMail(file, to, cc, subject, body);
//////    }
//////
//////}
////
////
////package com.hostmdy.wifiservice.resource;
////
////import com.hostmdy.wifiservice.service.EmailService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////
////@RestController
////@RequestMapping("/mail")
////public class EmailSendController {
////    private final EmailService emailService;
////
////    @Autowired
////    public EmailSendController(EmailService emailService) {
////        this.emailService = emailService;
////    }
////
////    @PostMapping("/send")
////    public String sendMail(@RequestParam(value = "text", required = false) String text,
////                           String to, String[] cc, String subject, String body) {
////        return emailService.sendMail(text, to, cc, subject, body);
////    }
////}
//
//
////package com.hostmdy.wifiservice.resource;
////
////import com.hostmdy.wifiservice.service.EmailService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////@RestController
////@RequestMapping("/mail")
////public class EmailSendController {
////    private final EmailService emailService;
////
////    @Autowired
////    public EmailSendController(EmailService emailService) {
////        this.emailService = emailService;
////    }
////
////    @PostMapping("/send")
////    public String sendMail(@RequestBody String jsonPayload) {
////        return emailService.sendMail(jsonPayload);
////    }
////}
//
//package com.hostmdy.wifiservice.resource;
//
//import com.hostmdy.wifiservice.domain.EmailRequest;
//import com.hostmdy.wifiservice.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/mail")
//public class EmailSendController {
//    private final EmailService emailService;
//
//    @Autowired
//    public EmailSendController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @PostMapping("/send")
//    public String sendMail(@RequestBody EmailRequest emailRequest) {
//        return emailService.sendMail(emailRequest.getFileContent(), emailRequest.getTo(), emailRequest.getCc(), emailRequest.getSubject(), emailRequest.getBody());
//    }
//}
//
