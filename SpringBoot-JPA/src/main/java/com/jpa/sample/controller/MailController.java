package com.jpa.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.sample.util.MailSender;

@RestController
public class MailController {
	
	@ResponseBody
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	public String sendMail(HttpServletRequest req) throws Exception {
	    boolean result =MailSender.sendMail("qocngus@gmail.com", "sendmail test title", "sendmail test contents");
	    String msg = "";
	    if(result)
	        msg = "success";
	    else
	        msg = "fail";
	    return msg;
	}
	 
}
