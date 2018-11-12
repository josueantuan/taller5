package com.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.social.services.MailService;

@Controller
public class MailController {
	
	 @Autowired
	    private MailService mailService;

	    @GetMapping("/")
	    public String index(){
	        return "send_mail_view";
	    }

	    @PostMapping("/sendMail")
	    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

	        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
	        mailService.sendMail("josueantuan1996@gmail.com","antuan_1996@hotmail.com",subject,message);
	      
	        return "send_mail_view";
	    }
	
}
