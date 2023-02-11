package tn.banque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Cartebancaire;
import tn.banque.Services.ICartebancaireService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cartebancaire")
public class CartebancaireController {
	
	@Autowired
	ICartebancaireService iCarteService;
	
	@PostMapping("/addCarteBancaire")
	@ResponseBody
	public Cartebancaire addCarteBancaire(@RequestBody Cartebancaire carte) {
		try {
			iCarteService.addCarteBancaire(carte);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return carte;
	}
	
	@GetMapping("/retrieveAllCartebancaire")
	public List<Cartebancaire> retrieveAllCartebancaire(){
		return iCarteService.retrieveAllCartebancaire();
	}
	
	@GetMapping("/retrieveCartebancaire")
	public Cartebancaire retrieveCartebancaire(@RequestParam("idCB")Long idCB) {
		Cartebancaire carte = iCarteService.retrieveCartebancaire(idCB);
		return carte;
	}
	
	
	@GetMapping("/CarteByCompteId")
	public Cartebancaire CarteByCompteId(@RequestParam("idCC") Long idCC) {
		Cartebancaire carte = iCarteService.CarteByCompteId(idCC);
		return carte;
	}
	
	@GetMapping("/nbrCarte")
	public int[] nbrCarte() {
		return iCarteService.nbrCarte();
	}
	
	
	@GetMapping("/nomCarte")
	public String[] nomCarte() {
		return iCarteService.nomCarte();
	}
	
	@GetMapping("/nbrCarteUtil")
	public String[][] nbrCarteUtil(){
		return iCarteService.nbrCarteUtil();
	}
	
	
	
	

}
