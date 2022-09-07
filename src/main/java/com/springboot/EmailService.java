package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Registration register) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("javafullstracktraining@outlook.com");
		mailMessage.setSubject("Welcome Message");
		mailMessage.setText("Welcome to Spring Application");
		mailMessage.setTo(register.getEmail());
		javaMailSender.send(mailMessage);
	}

}
