package com.omniwyse.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.omniwyse.model.MailModel;

@Service
public class MailService {
     private JavaMailSender javaMailSender;
     
    @Autowired
    public MailService(JavaMailSender javaMailSender)
    {
    	this.javaMailSender = javaMailSender;
    }
    
    public void sendEmail(MailModel mailModel) throws MailException {
    	SimpleMailMessage message = new SimpleMailMessage();
    	message.setTo(mailModel.getEmailAddress());
    	message.setSubject("Testing Mail API");
    	message.setText("Hurray ! You have done that dude...");
		
		javaMailSender.send(message);
    }
    
    public void sendEmailWithAttachment(MailModel mailModel) throws MailException, MessagingException {
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(mailModel.getEmailAddress());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
    }
     
}
