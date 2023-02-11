package tn.banque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.User;
import tn.banque.Services.IComptebancaireService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comptebancaire")
public class ComptebancaireController {

	@Autowired
	IComptebancaireService icomptebancaireService;
	
	
	@PostMapping("/addComptebancaire")
	@ResponseBody
	public Comptebancaire addComptebancaire(@RequestBody Comptebancaire compte , @RequestParam("idU") Long idU ) {
		try {
			icomptebancaireService.addCompteBancaire(compte, idU);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	return compte;
	}
	
	@PostMapping("/addComptecourrantTobancaire")
	@ResponseBody
	public void addCompteCourrantBancaire(@RequestBody Comptecourrant comptecourrant ,@RequestParam("idCBA") Long idCBA,@RequestParam("idCB") Long idCB ) {
		try {
			icomptebancaireService.addCompteCourrantBancaire(idCBA,comptecourrant,idCB);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	
	}
	
	@GetMapping("/retrieveAllUser")
	public List<User> retrieveAllUser() {
		List<User> list = icomptebancaireService.retrieveAllUser();
		return list;
	}
	
	
	
	@GetMapping("/retrieveAllComptebancaire")
	public List<Comptebancaire> retrieveAllComptebancaire(){
		List<Comptebancaire> list = icomptebancaireService.retrieveAllComptebancaire();
		return list;
	}
	
	
}
