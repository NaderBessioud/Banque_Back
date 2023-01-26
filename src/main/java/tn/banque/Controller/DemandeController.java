package tn.banque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.DemandeCreationCtit;

import tn.banque.Services.IServiceDemande;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/demande")
public class DemandeController {
	@Autowired
	IServiceDemande serv;

	@PostMapping("/addm/{idcb}")
	@ResponseBody
	public Boolean adddemande(@RequestBody DemandeCreationCtit demande,@PathVariable("idcb")Long idcb){
		
		return serv.addct(demande, idcb);
	}
	@GetMapping("/affichedm/{iddm}")
	public DemandeCreationCtit affichedm(@PathVariable("iddm") Long iddm) {
		return serv.retrieveDemande(iddm);
	}

	@GetMapping("/affichelistedm")
	public List<DemandeCreationCtit> affichelsct(){
		return serv.retrieveAllDemande();
	}
	@GetMapping("/affichelistecb/{id}")
	public List<Comptebancaire> affichelscb(@PathVariable("id") Long id){
		return serv.afficheliste(id);
	}
	@PutMapping("/changestate/{id}")
	public void changestate(@PathVariable("id") Long id) {
		 serv.changerstatut(id);
	}
	
}
