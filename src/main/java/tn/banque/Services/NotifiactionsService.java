package tn.banque.Services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RepaintManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.param.ChargeUpdateParams.FraudDetails.UserReport;

import tn.banque.Entities.Notifications;
import tn.banque.Entities.User;

import tn.banque.Repositories.NotificationRepository;
import tn.banque.Repositories.UserRepo;

@Service
public class NotifiactionsService {
	@Autowired
	private NotificationRepository rep;
	@Autowired
	private UserRepo conseillerRepository;
	
	public List<Notifications> getNotificationNotSeen(long idc){
		List<Notifications> notifs=new ArrayList<>();
		User user=conseillerRepository.findById(idc).orElse(null);
		if(user != null)
		return rep.findByUserAndVu(user, false);
		else return notifs;
	}
	
	public Notifications addNotification(Notifications n) {
		return rep.save(n);
	}
	
	public void updateNotificationVu(long idn) {
		Notifications notifications=rep.findById(idn).get();
		notifications.setVu(true);
		rep.save(notifications);
	}

}
