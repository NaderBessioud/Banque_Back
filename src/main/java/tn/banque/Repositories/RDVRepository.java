package tn.banque.Repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.RDV;
import tn.banque.Entities.User;

@Repository
public interface RDVRepository extends CrudRepository<RDV, Long> {
	List<RDV> findByEmployeeAndDaterdvBetween(User employee,Date date1,Date date2);
	List<RDV> findByClient(User client);
	

}
