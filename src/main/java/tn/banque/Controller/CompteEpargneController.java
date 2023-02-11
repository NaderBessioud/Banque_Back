package tn.banque.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Compteepargne;
import tn.banque.Entities.Notifications;
import tn.banque.Entities.TypeEpargne;
import tn.banque.Services.CompteEpargneServiceInter;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/compteepargne")
public class CompteEpargneController {
	@Autowired
	private CompteEpargneServiceInter  compteEpargneService;
	 @Autowired
	    private SimpMessagingTemplate template;
	 
	
	@GetMapping("/CompteEpargnes")
	@ResponseBody
	public List<Compteepargne> getAllcompteEpargneService(){
		return compteEpargneService.retrieveAllCompteepargnes();
	}
	
	@GetMapping("/CompteEpargne")
	@ResponseBody
	public Compteepargne getCompteById(@RequestParam("id") long id) {
		return compteEpargneService.retrieveCompteepargne(id);
	}
	
	@PostMapping("/addCompteEpargne")
	@ResponseBody
	public Compteepargne addCompteEpargne(@RequestBody Compteepargne compteepargne) {
		return compteEpargneService.addCompteepargne(compteepargne);
	}
	
	@PutMapping("/updateCompteEpargne")
	@ResponseBody
	public Compteepargne updateCompteEpargne(@RequestBody Compteepargne compteepargne) {
		return compteEpargneService.updateCompteepargne(compteepargne);
	}
	
	
	public  double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
	
	@GetMapping("/Distance")
	@ResponseBody
	public double getDistance() {
		return distance(36.793528, 36.803174, 10.188419, 10.182803, 0, 0);
	}
	
	@GetMapping("/simulate")
	@ResponseBody
	public double simulateCE(@RequestParam("type") TypeEpargne type,@RequestParam("mens") float mens,@RequestParam("init") float init,@RequestParam("p") int periode,@RequestParam("typeV") String typeV) {
		if(typeV.equals("mensuel"))
			return compteEpargneService.simulate(type, mens, init, periode);
		else if(typeV.equals("semestriel"))
			return compteEpargneService.simulatePerSemesterPerA(type, mens, init, periode);
		else 
			return compteEpargneService.simulatePerYearPerA(type, mens, init, periode);
	}
	
	@GetMapping("/simulatePM")
	@ResponseBody
	public double simulateCEPM(@RequestParam("type") TypeEpargne type,@RequestParam("mens") float mens,@RequestParam("init") float init,@RequestParam("p") int periode,@RequestParam("typeV") String typeV) {
		 
		 
		
		if(typeV.equals("mensuel"))
			return compteEpargneService.simulatePM(type, mens, init, periode);
		else if(typeV.equals("semestriel"))
			return compteEpargneService.simulatePerSemesterPerM(type, mens, init, periode);
		else 
			return compteEpargneService.simulatePerYearPerM(type, mens, init, periode);
	}
	
	@GetMapping("/ContributionTotale")
	@ResponseBody
	public double getContributionTotal(@RequestParam("vers") double vers,@RequestParam("type") String type,@RequestParam("typeP") String typeP,@RequestParam("p") int p) {
		return compteEpargneService.ContributionTotale(vers, type, typeP, p);
	}

}
