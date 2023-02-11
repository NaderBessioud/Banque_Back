package tn.banque.Controller;




import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.banque.Entities.Conge;
import tn.banque.Services.CongeService;


@RestController
@CrossOrigin("*")
public class CongeController {

	@Autowired
	CongeService congeService;
	
	@PostMapping("/ajouterConge/{idU}")
	@ResponseBody
	public Conge ajouterConge(@RequestBody Conge c,@PathVariable("idU") Long idU)
	{
		return congeService.ajouter_Conge(c,idU);
	}
	
	@PutMapping("/modifierConge/{idc}")
	@ResponseBody
	public Conge modifierConge(@RequestBody Conge c,@PathVariable ("idc") Long id)
	{
		return congeService.modifier_Conge(c, id);
	}
	
	@GetMapping("/afficher-all-Conge")
	@ResponseBody
	public List<Conge> afficherAllConge() {
	List<Conge> list = congeService.all_Conge();
	return list;
	}
	
	@GetMapping("/afficher-Conge/{idf}")
	@ResponseBody
	public Conge afficherConge(@PathVariable ("idf") Long id) {
		Conge conge = congeService.afficher_Conge(id);
	return conge;
	}
	
	@DeleteMapping("/supprimerConge/{idf}")
	@ResponseBody
	public void supprimerConge (@PathVariable ("idf") Long id) {
		congeService.SupprimerConge(id);
	}
	
	@GetMapping("/calculer-Conge/{idU}")
	@ResponseBody
	public int calculer_Conge(@PathVariable ("idU") Long idU) {
		return congeService.calcul_conge(idU);
	
	}
	
	@PostMapping("/accepterConge/{idU}/{mail}")
	@ResponseBody
	public void accepterConge(@PathVariable ("idU") Long id,@RequestBody String body,@PathVariable ("mail") String mail) throws MessagingException
	{
		 congeService.accepter_conge(id,body,mail);
	}
	
	@GetMapping("/retrieve-all-Conges-accepter")
	@ResponseBody
	public List<Conge> Congesaccepter() {
	List<Conge> list = congeService.retrieveAllSliceAccepter();
	return list;
	}
	
	@GetMapping("/retrieve-all-Conges-non-accepter")
	@ResponseBody
	public List<Conge> getCongeNonaccepter() {
	List<Conge> list = congeService.retrieveAllCangeNonAccepter();
	return list;
	
	}
	
}
		
		
		
		
	

		
	


	
	


	
	
	
	


