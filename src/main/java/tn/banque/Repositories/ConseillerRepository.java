package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;

@Repository
public interface ConseillerRepository extends CrudRepository<User, Long> {
	
	List<User> findByRoleAndConge(TypeEmployee role,boolean conge);
	

}
