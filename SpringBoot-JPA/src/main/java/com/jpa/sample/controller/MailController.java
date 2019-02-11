package com.jpa.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.sample.form.Mail;
import com.jpa.sample.util.MailSender;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "메일 Controller", value = "메일 Controller", description = "메일 Controller")
public class MailController {
	
	@ResponseBody
	@ApiOperation(value = "메일 보내기")
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendMail(HttpServletRequest req, Mail mail) throws Exception {
		
		
		
		boolean result =MailSender.sendMail(mail.getToAddr(), mail.getFromAddr(), mail.getSubject(), mail.getContents());
		String msg = "";
	    if(result)
	        msg = "success";
	    else
	        msg = "fail";
	    return msg;
	}
	 
}
