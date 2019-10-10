package org.spiderflow.mailbox.utils;

import java.util.Date;
import java.util.Properties;

import org.spiderflow.model.JsonBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailboxUtils {

	public static JavaMailSenderImpl createMailSender(String host, int port, String username, String password, int timeout) {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(host);
		sender.setPort(port);
		sender.setUsername(username);
		sender.setPassword(password);
		sender.setDefaultEncoding("Utf-8");
		Properties p = new Properties();
		p.setProperty("mail.smtp.timeout", timeout + "");
		p.setProperty("mail.smtp.auth", "true");
		sender.setJavaMailProperties(p);
		return sender;
	}

	public static void main(String[] args) {
		try {
			String host = "";
			int port = 25;
			int timeout = 60000;
			String username = "";
			String password = "";
			JavaMailSenderImpl mailboxTemplate = MailboxUtils.createMailSender(host, port, username, password, timeout);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(username);
			mailMessage.setTo("865173901@qq.com");
			mailMessage.setSubject("邮箱发送测试");
			mailMessage.setSentDate(new Date());//发送时间
			mailMessage.setText("邮箱发送测试");
			mailboxTemplate.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
