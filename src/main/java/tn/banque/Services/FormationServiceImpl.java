package tn.banque.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Formation;
import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;
import tn.banque.Repositories.FormationRepository;
import tn.banque.Repositories.UserRepo;



@Service
public class FormationServiceImpl implements FormationService {

	@Autowired
	FormationRepository formationRepository;
	@Autowired 
	UserRepo userRepository;

	
	@Override
	public ResponseEntity<Formation> ajouter_formation( Formation f) throws MessagingException {
		    formationRepository.save(f);

			return new ResponseEntity<>(f, HttpStatus.OK);
		//}
		//else 
			
			//return new ResponseEntity<>(f, HttpStatus.BAD_REQUEST);
			
	}
	
	@Override
	public void affecterFormation(Long id, TypeEmployee type ) {
		List<User> users = userRepository.findByRoleAndConge(type, false);
		Formation f=formationRepository.findById(id).get();
		for (User user : users) {
			user.getFormations().add(f);
			
			userRepository.save(user);
			f.getUsers().add(user);
			
		}
		formationRepository.save(f);
		
	}
	

	@Override
	public Formation modifier_formation(Formation f, Long idf) {
		f.setIdFormation(idf);
		return formationRepository.save(f);
	}

	@Override
	public List<Formation> all_Formations() {
		List<Formation> list = formationRepository.findAll();
		return list;
	}

	@Override
	public Formation afficher_Formation(Long idf) {
		Formation formation =formationRepository.findById(idf).orElse(null);
		return formation;
	}

	@Override
	public void SupprimerFormation(Long idf) {
		formationRepository.deleteById(idf);
		
	}

	

}
