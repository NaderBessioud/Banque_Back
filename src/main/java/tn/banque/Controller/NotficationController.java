package tn.banque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Notifications;
import tn.banque.Services.NotifiactionsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notif")
public class NotficationController {
	 @Autowired
	    private SimpMessagingTemplate template;
	 @Autowired
	 private NotifiactionsService notifiactionsService;
	 
	 @GetMapping("/notify")
	 @ResponseBody
	 public String getNotification() {
		  //template.convertAndSend("/topic/notification", notifications);
		  return "Notifications successfully sent to Angular !";
	 }
	 
	 @GetMapping("/NotificationsNotSeen")
	 @ResponseBody
	 public List<Notifications> getNotificationNotSeen(@RequestParam("idc") long idc){
		 return  notifiactionsService.getNotificationNotSeen(idc);
	 }
	 
	 @PutMapping("/updateNotification")
	 public void updateNotificationVu(@RequestBody Notifications notifications) {
		 notifiactionsService.updateNotificationVu(notifications.getIdNotif());
	 }

}
