package com.myliblary.controller;

import java.util.Locale;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.myliblary.mailer.*;

@Controller
public class HomeController{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "Home";
	}
	

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody String PostService(@RequestBody Message email) {
		StringBuilder reponseData = new StringBuilder();
		reponseData.append("Name: "+email.getName()+" ");
		System.out.println(email.getEmail());
		
		 
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo("kowdominik2@gmail.com");
		mailMessage.setSubject("test");
		mailMessage.setFrom(email.getEmail());
		mailMessage.setText(email.getComment());
	
	 
		
		
		return reponseData.toString();
	}


	
	
}
