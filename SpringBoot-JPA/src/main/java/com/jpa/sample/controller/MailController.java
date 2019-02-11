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
		boolean result =MailSender.sendMail("rose1223@naver.com", "테스트..", "자바단에서 메일 쏴봅니다. 잘갔으면 답장좀요 ^^ ");
		String msg = "";
	    if(result)
	        msg = "success";
	    else
	        msg = "fail";
	    return msg;
	}
	 
}
