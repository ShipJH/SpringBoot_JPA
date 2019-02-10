package com.jpa.sample.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private static String strMailServerPort = "25";
//	private static String strMailFrom = "qocngus@gmail.com"; // 보내는 사람 메일 주소
	private static String strMailFrom = "ship_reappearance@naver.com"; // 보내는 사람 메일 주소

	public static Boolean sendMail(String strMailTo, String strTitle, String strContents) throws Exception {
		Boolean result = true;
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "106.10.51.157"); // sendmail ip address
			props.put("mail.smtp.port", strMailServerPort); // 25
			props.put("mail.smtp.auth", "false");
			
//			props.put("mail.smtp.timeout", "30000");
//			props.put("mail.smtp.ssl.enable", "true");
			Session msgSession = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(msgSession);
			InternetAddress from = new InternetAddress(strMailFrom, "bjh", "UTF-8"); // (보내는사람 메일 주소 , 표시 할 이름 ,
																							// 문자셋)

			msg.setFrom(from);
			InternetAddress to = new InternetAddress(strMailTo); // 받는사람 메일주소
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject(strTitle); // 메일 제목
			msg.setContent(strContents, "text/html; charset=UTF-8"); // 메일 내용

			Transport.send(msg);
		} catch (MessagingException e) {
			result = false;
			System.out.println(e);
			System.out.println("---------------------");
			e.getStackTrace();
		}
		return result;
	}
}
