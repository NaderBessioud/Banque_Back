package tn.banque.Controller;

import java.util.List;

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

import tn.banque.Entities.Salaire;

import tn.banque.Services.SalaireService;

@RestController
@CrossOrigin("*")
public class SalaireController {

	
	@Autowired
	SalaireService salaireService;
	
	@PostMapping("/ajouterSalaire")
	@ResponseBody
	public Salaire ajouterSalaire(@RequestBody Salaire s)
	{
		return salaireService.ajouter_Salaire(s);
	}
	
	@PutMapping("/modifierSalaire/{idf}")
	@ResponseBody
	public Salaire modifierSalaire(@RequestBody Salaire s,@PathVariable ("ids") Long id)
	{
		return salaireService.modifier_Salaire(s, id);
	}
	
	@GetMapping("/afficher-all-Salaire")
	@ResponseBody
	public List<Salaire> afficherAllSalaire() {
	List<Salaire> list = salaireService.all_Salaire();
	return list;
	}
	
	@GetMapping("/afficher-Salaire/{ids}")
	@ResponseBody
	public Salaire afficherSalaire(@PathVariable ("ids") Long id) {
		Salaire formation = salaireService.afficher_Salaire(id);
	return formation;
	}
	
	@DeleteMapping("/supprimerSalaire/{ids}")
	@ResponseBody
	public void SupprimerSalaire (@PathVariable ("ids") Long id) {
		salaireService.SupprimerSalaire(id);
	}
	
	@PutMapping("/calculsalaires")
	@ResponseBody
	public void salaire()
	{
		 salaireService.Calculer_Salaire_net();
	}
	
	@GetMapping("/afficher-Salaire-month/{m}/{a}")
	@ResponseBody
	public List<Salaire> afficherSalairemonth(@PathVariable ("m") int m,@PathVariable ("a") int a) {
		return salaireService.afficher_Salaire_month(m,a);
	}
}
