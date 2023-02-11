package tn.banque.Controller;

import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Formation;
import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;
import tn.banque.Repositories.UserRepo;

import tn.banque.Services.FormationService;

@RestController
@CrossOrigin("*")
public class FormationController {

	
	@Autowired
	FormationService formationService;
	@Autowired
	UserRepo userRepository;
	
	
	@PostMapping("/ajouterFormation")
	@ResponseBody
	public ResponseEntity<String> ajouterFormation(@RequestBody Formation f) throws MessagingException
	{
		formationService.ajouter_formation(f);
		return  ResponseEntity.ok("ajouter avec succes");
	}
	
	@PutMapping("/modifierFormation/{idf}")
	@ResponseBody
	public Formation modifierFormation(@RequestBody Formation f,@PathVariable ("idf") Long id)
	{
		return formationService.modifier_formation(f, id);
	}
	
	@GetMapping("/afficher-all-Formation")
	@ResponseBody
	public List<Formation> afficherAllFormation() {
	List<Formation> list = formationService.all_Formations();
	return list;
	}
	
	@GetMapping("/afficher-Formation/{idf}")
	@ResponseBody
	public Formation afficherFormation(@PathVariable ("idf") Long id) {
	Formation formation = formationService.afficher_Formation(id);
	return formation;
	}
	
	@DeleteMapping("/supprimerFormation/{idf}")
	@ResponseBody
	public void removeCreditCard (@PathVariable ("idf") Long id) {
		formationService.SupprimerFormation(id);
	}
	
	@GetMapping("/affecterFormation/{id}/{type}")
	@ResponseBody
	public void affecterFormation(@PathVariable ("id") Long id,@PathVariable("type") TypeEmployee type)
	{
		 formationService.affecterFormation(id,type);
	}
	
	
	

	
}
