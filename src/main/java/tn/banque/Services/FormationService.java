package tn.banque.Services;

import java.util.List;

import javax.mail.MessagingException;
import javax.management.relation.Role;

import org.springframework.http.ResponseEntity;

import tn.banque.Entities.Formation;
import tn.banque.Entities.TypeEmployee;

public interface FormationService {

	ResponseEntity<Formation> ajouter_formation(Formation f) throws MessagingException;
	Formation modifier_formation(Formation f , Long idf);
	List<Formation> all_Formations();
	Formation afficher_Formation(Long idf);
	void SupprimerFormation(Long idf); 
	void affecterFormation(Long id, TypeEmployee type );
	
}
