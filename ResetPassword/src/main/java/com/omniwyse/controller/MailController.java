
package com.omniwyse.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.model.MailModel;
import com.omniwyse.service.MailService;

@RestController
public class MailController {

	@Autowired
	private MailService mailService;
	
	@Autowired
	private MailModel mailModel;
	
	@RequestMapping("send-mail")
	public String send(){
		
			mailModel.setEmailAddress("kambhamnagamani1995@Gmail.com");
			try {
				mailService.sendEmail(mailModel);
			}
			catch(MailException mailException){
				System.out.println(mailException);
			}
			return "Mail sent successfully";
	}
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException  {
		mailModel.setEmailAddress("kambhamnagamani1995@gmail.com");
		try {
			mailService.sendEmailWithAttachment(mailModel);
		}catch(MailException mailException) {
			System.out.println(mailException);
		}
		return "Mail Sent Successfully.";
	}
}
