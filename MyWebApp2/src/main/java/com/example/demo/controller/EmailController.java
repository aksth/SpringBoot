package com.example.demo.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmailDTO;

@RestController
public class EmailController {
	
	@Autowired
    public JavaMailSender emailSender;
	
	@CrossOrigin(origins = "http://localhost:9000")
	@PostMapping("email")
	public ResponseEntity<Void> sendEmail(@RequestBody EmailDTO email){
	
		/*
		 * SimpleMailMessage email = new SimpleMailMessage();
		 * email.setTo("shrestha.akash01@gmail.com");
		 * email.setSubject("Prospective Student"); email.setText("");
		 * emailSender.send(email);
		 */
		
		try {
			MimeMessage message = emailSender.createMimeMessage();
		      
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    
		    helper.setTo(email.getEmail());
		    helper.setSubject("Prospective Student");
		    helper.setText("Hello,<br /><br />"
		    		+ "How are you?<br />"
		    		+ "<b>I'm fine.</b><br />You?<br /><br />"
		    		+ "Thank you.", true);
		         
		    FileSystemResource resume 
		      = new FileSystemResource(new File("/home/akash/Desktop/google drive/jobs/test_resume.pdf"));
		    helper.addAttachment("Resume.pdf", resume);
		 
		    emailSender.send(message);
		
		    return new ResponseEntity<>(HttpStatus.OK);
		    
		}catch(MessagingException exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
