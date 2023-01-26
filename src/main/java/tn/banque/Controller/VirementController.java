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

import tn.banque.Entities.Virement;
import tn.banque.Services.IVirementService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/virement")
public class VirementController {

	
	@Autowired
	IVirementService ivirementService;
	
	@PostMapping("/addVirement")
	@ResponseBody
	public boolean addVirement(@RequestBody Virement virement , @RequestParam("idCC") Long idCC) {
		return ivirementService.addVirement(virement, idCC);
	}
	
	
	@GetMapping("/retrieveAllVirement")
	public List<Object[]> retrieveAllVirement(){
		return ivirementService.retrieveAllVirement();
	}
	
	@GetMapping("retrieveVirementEmetteur")
	public List<Virement> retrieveVirementEmetteur(@RequestParam("idCC") Long idCC){
		return ivirementService.retrieveVirementEmetteur(idCC);
	}
	
	@GetMapping("/retrieveVirementRecepteur")
	public List<Virement> retrieveVirementRecepteur(@RequestParam("idCC") Long idCC){
		return ivirementService.retrieveVirementRecepteur(idCC);
	}
}
