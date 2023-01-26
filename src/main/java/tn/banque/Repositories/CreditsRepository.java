package tn.banque.Repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Credits;

@Repository
public interface CreditsRepository extends CrudRepository<Credits , Long> {
	 
}
