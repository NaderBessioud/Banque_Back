package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Message;
import tn.banque.Entities.User;

@Repository
public interface MessageReposiory extends CrudRepository<Message, Long>{

	List<Message> findBySenderAndReceiver(User sender,User receiver);
	
}
