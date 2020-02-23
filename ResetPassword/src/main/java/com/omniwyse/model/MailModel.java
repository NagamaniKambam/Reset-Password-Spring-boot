package com.omniwyse.model;

import org.springframework.stereotype.Component;

@Component
public class MailModel {
     private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
     
}
