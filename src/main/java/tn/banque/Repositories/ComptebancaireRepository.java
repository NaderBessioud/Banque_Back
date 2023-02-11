package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptecourrant;

@Repository
public interface ComptebancaireRepository extends JpaRepository<Comptebancaire,Long>{

	
	@Query("SELECT c from Comptebancaire c WHERE c.clcomptes.idEmployee= :id")
	List<Comptebancaire> getcomptebc(@Param("id") Long id);

	
}
