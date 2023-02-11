package tn.banque.Services;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.banque.Entities.User;

@Service

public class MailService {
	private JavaMailSender javaMailSender;

	
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

public void sendEmail(User user) throws MailException {

		

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("mohammedamine.kridiss@esprit.tn");
		mail.setSubject("Testing Mail API");
		mail.setText("you recieved");
		

		javaMailSender.send(mail);
	}
}
