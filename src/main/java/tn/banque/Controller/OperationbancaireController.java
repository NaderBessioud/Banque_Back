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
import tn.banque.Entities.Operationbancaire;
import tn.banque.Services.IOperationbancaireService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/operationbancaire")
public class OperationbancaireController {

	@Autowired
	IOperationbancaireService iOperationService;
	
	
	@GetMapping("/retrieveAllOperation")
	public List<Operationbancaire> retrieveAllOperation(){
		return iOperationService.retrieveAllOperation();
	}
	
	@GetMapping("/StatOperationMois")
	public List<Object[]> StatOperationMois(){
		return iOperationService.StatOperationMois();
	}
	
	@GetMapping("/AllOperationCompte")
	public List<Object[]> AllOperationCompte(){
		return iOperationService.AllOperationCompte();
	}
	
	@GetMapping("/retrieveByCompte")
	public List<Operationbancaire> retrieveByCompte(@RequestParam("idCC") Long idCC){
		return iOperationService.retrieveByCompte(idCC);
	}
	
	
	@PostMapping("/addDepot")
	@ResponseBody
	public Operationbancaire addDepot(@RequestBody Operationbancaire operation , @RequestParam("idCC") Long idCC ) {
		try {
			iOperationService.addDepot(operation, idCC);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	return operation;
	}
	
	@PostMapping("/addRetrait")
	@ResponseBody
	public boolean addRetrait(@RequestBody Operationbancaire operation,@RequestParam("idCC") Long idCC) {
		return iOperationService.addRetrait(operation, idCC);
	}
	
	@PostMapping("/addAchat")
	@ResponseBody
	public boolean addAchat(@RequestBody Operationbancaire operation,@RequestParam("idCC") Long idCC) {
		return iOperationService.addAchat(operation, idCC);
	}
	
	@GetMapping("/currentRetrait")
	public float currentRetrait(Long idCC) {
		return iOperationService.currentRetrait(idCC);
	}
	
	@GetMapping("/currentPaiement")
	public float currentPaiement(Long idCC) {
		return iOperationService.currentPaiement(idCC);
	}
	
	

	@GetMapping("/OperationAVenir")
	public List<Operationbancaire> OperationAVenir(@RequestParam("idCC") Long idCC){
		return iOperationService.OperationAVenir(idCC);
	}
	
	@GetMapping("/statOperation")
	public float[] statOperation(@RequestParam("idCC") Long idCC) {
		return iOperationService.statOperation(idCC);
	}
	
	
	
	
}
