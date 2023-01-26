package tn.banque.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Services.simulateurService;

@RestController
@CrossOrigin("*")
public class SimulateurController {

	@Autowired
	simulateurService simulateurService;
	
	@GetMapping("/creditSimulationImmoblier-Fixe/{c}/{m}/{r}")
	  @ResponseBody
	  public String creditPaymentSimulationimmoblier(@PathVariable("c") double capital,@PathVariable("m") int mois ,@PathVariable("r") double revenu_mensuel) {
	  return simulateurService.simulationInterestImmobilierAtauxFixe(capital,mois,revenu_mensuel);
	  }
	
	@GetMapping("/creditSimulationvehicule-Fixe/{c}/{m}/{r}")
	  @ResponseBody
	  public String creditPaymentSimulationvehicule(@PathVariable("c")double capital,@PathVariable("m")int mois ,@PathVariable("r") double revenu_mensuel) {
	  return simulateurService.simulationInterestveheculeAtauxFixe(capital,mois,revenu_mensuel);
	  }
	@GetMapping("/creditSimulationPersonnel-Fixe/{c}/{m}/{r}")
	  @ResponseBody
	  public String creditPaymentSimulationPersonnel(@PathVariable("c")double capital,@PathVariable("m")int mois ,@PathVariable("r") double revenu_mensuel) {
	  return simulateurService.simulationInterestPersonnelAtauxFixe(capital,mois,revenu_mensuel);
	  }
	
	
	@GetMapping("/creditSimulationImmoblier-Variable/{c}/{m}/{r}")
	  @ResponseBody
	  public String creditPaymentSimulationimmoblierVariable(@PathVariable("c") double capital,@PathVariable("m") int mois ,@PathVariable("r") double revenu_mensuel) {
	  return simulateurService.simulationInterestImmobilierAtauxVariable(capital,mois,revenu_mensuel);
	  }
	
	@GetMapping("/creditSimulationvehicule-Variable/{c}/{m}/{r}")
	  @ResponseBody
	  public String creditPaymentSimulationvehiculeVariable(@PathVariable("c")double capital,@PathVariable("m")int mois ,@PathVariable("r") double revenu_mensuel) {
	  return simulateurService.simulationInterestveheculeAtauxVariable(capital,mois,revenu_mensuel);
	  }
	@GetMapping("/creditSimulationPersonnel-Variable/{c}/{m}/{r}")
	  @ResponseBody
	  public String creditPaymentSimulationPersonnelVariable(@PathVariable("c")double capital,@PathVariable("m")int mois ,@PathVariable("r") double revenu_mensuel) {
	  return simulateurService.simulationInterestPersonnelAtauxVariable(capital,mois,revenu_mensuel);
	  }
}
