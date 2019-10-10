package org.spiderflow.mailbox.web;

import java.util.Date;

import org.spiderflow.mailbox.utils.MailboxUtils;
import org.spiderflow.model.JsonBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mailbox")
public class MailboxController {

	@RequestMapping("/test")
	public JsonBean<String> test(String host, Integer port, String username, String password, Integer timeout, String mail) {
		try {
			JavaMailSenderImpl mailboxTemplate = MailboxUtils.createMailSender(host, port, username, password, timeout);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(username);
			mailMessage.setTo(mail);
			mailMessage.setSubject("邮箱发送测试");
			mailMessage.setSentDate(new Date());//发送时间
			mailMessage.setText("邮箱发送测试");
			mailboxTemplate.send(mailMessage);
			return new JsonBean<String>(1, "测试成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonBean<String>(-1, e.getMessage());
		}
	}

}
