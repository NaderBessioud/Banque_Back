package tn.banque.Services;

import static javax.mail.Message.RecipientType.TO;

import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sun.mail.smtp.SMTPTransport;

import freemarker.template.Configuration;




@Service
public class ServiceAllEmail {
	
	@Autowired
	Configuration configuration;
	

	
	//private JavaMailSender javaMailSender;
	


 

    private Session getEmailSession() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.starttls.required", true);  
        return Session.getInstance(properties, null);
    }
    
    
    //-------------------EventDonation-------------------------------------------------
    
    private Message createEmailForEvent(String body, String email) throws MessagingException {
        Message message = new MimeMessage(getEmailSession());
        message.setFrom(new InternetAddress("iheb.gharbi@gmail.com"));
        message.setRecipients(TO, InternetAddress.parse(email, false));
        //message.setRecipients(CC, InternetAddress.parse("bdtcourse@gmail.com", false));
        message.setSubject("Banque en ligne");
        message.setText(   body );
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

  

    
  //------------------------------------Forummails-------------------------------
    public void sendAllertReport(String body, String email) throws MessagingException {
        Message message = createEmailForEvent(body, email);
        SMTPTransport smtpTransport = (SMTPTransport) getEmailSession().getTransport("smtps");
        smtpTransport.connect("smtp.gmail.com", "iheb.gharbi@esprit.tn", "Moncefgharbi983753421995");
        smtpTransport.sendMessage(message, message.getAllRecipients());
        smtpTransport.close();
    }
//-----------------------------------------------------------------------------    
    
    
  

 
    

    //Welcome Email -----------------------------------------------------------------------------------
    
    
   




}
