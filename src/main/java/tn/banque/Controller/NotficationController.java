package tn.banque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Notifications;

@RestController
public class NotficationController {
	 @Autowired
	    private SimpMessagingTemplate template;
	 private Notifications notifications=new Notifications("title","content");
	 
	 @GetMapping("/notify")
	 @ResponseBody
	 public String getNotification() {
		  template.convertAndSend("/topic/notification", notifications);
		  return "Notifications successfully sent to Angular !";
	 }

}
