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
import tn.banque.Entities.Comptetitre;
import tn.banque.Services.ISCTit;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ct")
public class CTitController {
	@Autowired
	ISCTit service;
	public static String demanderib(int length) {
		String rib="";
		for (int i=0 ; i<length-2; i++) {
			rib=rib+ randomstr("0123456789");
		}
		String randomnum = randomstr("0123456789");
		rib= insertrib(rib,randomnum);
		return rib;
		
	}
	public static String randomstr(String characters) {
		int n= characters.length();
		int r=(int)(n* Math.random());
		return characters.substring(r,r+1);
	}
	public static String insertrib(String str, String toinsert) {
		int n=str.length();
		int r=(int)((n+1)*Math.random());
		return str.substring(0, r)+ toinsert +str.substring(r);
	}
	@PostMapping("/addctit/{idcb}")
	@ResponseBody
	public Comptetitre addctit(@RequestBody Comptetitre ct,@PathVariable("idcb")Long idcb){
		Long rib= Long.parseLong(demanderib(20));
		ct.setIdCT(String.valueOf(rib));
		System.out.println(rib);
		return service.addct(ct,idcb);
	}
	@PutMapping("/acheterob/{idu}/{idob}")
	public Comptetitre acheterob(@PathVariable("idu")String idu,@PathVariable("idob")Long idob) {
		return service.acheterobligation(idu, idob);
	}
	@PutMapping("/modifct")
	public Comptetitre modifct(@RequestBody Comptetitre ct) {
		return service.updateCt(ct);
	}
	@GetMapping("/affichect/{idct}")
	public Comptetitre affichect(@PathVariable("idct") String idct) {
		return service.retrieveCt(idct);
	}
	@GetMapping("/affichelistect")
	public List<Comptetitre> affichelsct(){
		return service.retrieveAllCt();
	}
	@GetMapping("/affichelistect/{id}")
	public List<Comptetitre> affichelsct(@PathVariable("id") Long id){
		return service.retrieveAllCtbyuser(id);
	}
	@GetMapping("/stats")
	public List<Object> stats(){
		return service.stats();
	}
	@GetMapping("/names")
	public List<String> names(){
		return service.names();
	}
	/*@PutMapping("/liquiderob/{idU}/{idO}/{idCt}")
	public Comptetitre liquiderob(@PathVariable("idU")Long idU,@PathVariable("idO")Long idO,@PathVariable("idCt")Long idCt) {
		return service.liquiderobligation(idU,idO, idCt);
	}*/
	
	
	@GetMapping("/affichelistecb/{id}")
	public List<Comptebancaire> affichelscb(@PathVariable("id") Long id){
	return service.afficheliste(id);
	}
	@PutMapping("/alimenter/{x}/{idct}/{idcb}")
	public float alimenter(@PathVariable("x") float x,@PathVariable("idct") String idct,@PathVariable("idcb") Long idcb) {
	return service.alimenter(x, idct, idcb);
	}
	
	
	
}