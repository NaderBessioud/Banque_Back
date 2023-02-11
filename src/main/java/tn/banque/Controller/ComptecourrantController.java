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

import tn.banque.Entities.Comptecourrant;
import tn.banque.Services.IComptecourrantService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comptecourrant")
public class ComptecourrantController {

	@Autowired
	IComptecourrantService iComptecourrantService;
	
	@PostMapping("/addCompteCourrant")
	@ResponseBody
	public Comptecourrant addCompteCourrant(@RequestBody Comptecourrant compte , @RequestParam("idCB") Long idCB, @RequestParam("idCBA") Long idCBA ) {
		try {
			iComptecourrantService.addCompteCourrant(compte, idCB, idCBA);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	return compte;
	}
	
	@GetMapping("/retrieveAllComptecourrant")
	public List<Comptecourrant> retieveAllComptecourrant(){
		List<Comptecourrant> list = iComptecourrantService.retrieveAllCompteCourrant();
	return list;
	}
	
	@GetMapping("/retrieveCompteCourrant")
	public Comptecourrant retrieveCompteCourrant(@RequestParam("idCC") Long idCC) {
		Comptecourrant compte = iComptecourrantService.retrieveCompteCourrant(idCC);
		return compte;
	}

}
