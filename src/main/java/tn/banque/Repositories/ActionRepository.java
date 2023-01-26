package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Action;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long>{

	List<Action> findByTitreContaining(String titre);	

}
