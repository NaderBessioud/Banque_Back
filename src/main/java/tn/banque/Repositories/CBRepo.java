package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Comptebancaire;



@Repository
public interface CBRepo extends CrudRepository<Comptebancaire, Long>{
	@Query("SELECT c from Comptebancaire c WHERE c.clcomptes.idEmployee= :id")
	List<Comptebancaire> getcomptebc(@Param("id") Long id);
}
