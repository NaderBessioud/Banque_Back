package tn.banque.Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Message;
import tn.banque.Entities.User;
import tn.banque.Repositories.MessageReposiory;
import tn.banque.Repositories.UserRepo;

@Service
public class MessageService {

	@Autowired
	private MessageReposiory reposiory;
	
	@Autowired
	private UserRepo userrep;
	
	@Autowired
    private SimpMessagingTemplate template;
	
	
	public Message addMessage(String content,long ids,long idr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String pattern = "E, dd MMM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("fr", "FR"));
		
		Message message=new Message();
		User sender=userrep.findById(ids).get();
		User reciever=userrep.findById(idr).get();
		message.setSender(sender);
		message.setReceiver(reciever);
		message.setContent(content);
		message.setDate(new Date());
		message.setHour(format.format(new Date()));
		message.setDateFormat(simpleDateFormat.format(new Date()));
		Date date=new Date();
		LocalDate local1=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate local2=message.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		message.setDateForTaday("Today");
	
		template.convertAndSend("/topic/messages", message);
		return reposiory.save(message);
	}
	
	public List<Message> getMessage(long ids,long idr){
		String pattern = "E, dd MMM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("fr", "FR"));
		List<Message> result=new ArrayList<>();
		User sender=userrep.findById(ids).get();
		User reciever=userrep.findById(idr).get();
		result=reposiory.findBySenderAndReceiver(sender, reciever);
		result.addAll(reposiory.findBySenderAndReceiver(reciever, sender));
		for (Message message : result) {
			message.setDateFormat(simpleDateFormat.format(new Date()));
			Date date=new Date();
			LocalDate local1=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate local2=message.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			
			if(Period.between(local1, local2).getDays()==0) {
				message.setDateForTaday("Today");
			}
			else if (Period.between(local1, local2).getDays()==-1) {
				message.setDateForTaday("Yesterday");
			}
			
			else if (Period.between(local1, local2).getDays()==-2) {
				message.setDateForTaday("2 days ago");
			}
			else {
				message.setDateForTaday("null");
			}
		}
		
		Collections.sort(result, new Comparator<Message>(){
		    public int compare(Message s1,Message s2) {
		        if(s1.getIdMe()>s2.getIdMe()) {
		        	return 1;
		        }
		        else if(s1.getIdMe()<s2.getIdMe()) {
		        	return -1;
		        }
		        else {
		        	return 0;
		        }
		    }

	});
		return result;
}
	
	public List<User> getHistoriqueuser(long id){
		List<User> result=new ArrayList<User>();
		result.addAll(userrep.gethistoriqueUserR(id));
		for (User user : userrep.gethistoriqueUserS(id)) {
			if(!result.contains(user)) {
				result.add(user);
			}
		}
		
		for (User user : result) {
			user.setOnline(false);
		}
		return result;
	}
	
	
}
