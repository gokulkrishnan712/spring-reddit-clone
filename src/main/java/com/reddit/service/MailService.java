package com.reddit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.reddit.exception.SubRedditException;
import com.reddit.model.NotificationEmail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
	
	@Autowired
	private final JavaMailSender mailSender;
	@Autowired
	private final MailContentBuilder mailContentBuilder;
	
	void sendMail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagePreparator=mimeMessage->{
			MimeMessageHelper msgHelper=new MimeMessageHelper(mimeMessage);
			msgHelper.setFrom("71gokulkrishnan@email.com");
			msgHelper.setTo(notificationEmail.getRecipient());
			msgHelper.setSubject(notificationEmail.getSubject());
			msgHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
		};
		try {
			mailSender.send(messagePreparator);
			log.info("Activation Email Sent");
		}catch(MailException e) {
			e.printStackTrace();
			throw new SubRedditException("Exception occured when sending mail to"+notificationEmail.getRecipient());
		}
	}

}
