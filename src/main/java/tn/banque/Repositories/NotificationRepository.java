package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Notifications;
import tn.banque.Entities.User;

@Repository
public interface NotificationRepository extends CrudRepository<Notifications, Long> {
	
	List<Notifications> findByUserAndVu(User user,boolean vu);

}
