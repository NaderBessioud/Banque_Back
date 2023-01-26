package tn.banque.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Comptebancaire;

@Repository
public interface ComptebancaireRepository extends JpaRepository<Comptebancaire,Long>{

	
	
}
