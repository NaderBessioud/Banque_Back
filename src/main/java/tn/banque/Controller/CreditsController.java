package tn.banque.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.CreditState;
import tn.banque.Entities.Credits;
import tn.banque.Entities.Offer;
import tn.banque.Entities.ReponseMessage;
import tn.banque.Entities.User;
import tn.banque.Services.ICreditsService;
import tn.banque.Services.IOfferService;
import tn.banque.Services.IRepaymentService;
 

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/credits")
public class CreditsController {

	@Autowired
	ICreditsService creditsService;
	@Autowired
	IOfferService offerService;
	@Autowired 
	IRepaymentService repaymentService;
	
	 
	
	@GetMapping("/select")
	@ResponseBody
	public List<Credits> getCredits() {
		List<Credits> listCredits = creditsService.retrieveAllCredits();
		return listCredits;
	}
	@PostMapping("/sim")
	@ResponseBody
	public ReponseMessage sim(@RequestBody Credits x ) {
 
		long l=1; 
		        creditsService.affectUser(l, x);
			    String str = "impossible de traiter votre demande réessayez";
				System.out.println(1);

				int score = creditsService.scooring(x);
				System.out.println(score);

				Offer o = offerService.searchOfferScore(score);
			

				if(o!=null)
				{
					str= creditsService.simulation(o.getInterestRate(), x.getAmount(), x.getDuration_months());
					
				}
				 	 	
				 
				
				
				ReponseMessage m = new ReponseMessage();
				m.setStr(str);
			
			 
		 
	 
		return m;

	}

	@GetMapping("/select/{id}")
	@ResponseBody
	public Credits getCredits(@PathVariable("id") Long Id) {
		Credits f = creditsService.retrieveCredits(Id);
		return f;
	}
	@GetMapping("/test/{id}")
	@ResponseBody
	public User x(@PathVariable("id") Long Id) {
		User u = creditsService.test(Id);
		return u;
 	}

	@PostMapping("/add/{id}")
	@ResponseBody
	public String addCredits(@RequestBody Credits x ,@PathVariable("id") Long Id) {
 		
		creditsService.affectUser(Id, x);
		String str = "request accepted waiting for confirmation";
		try {
			/*if( creditsService.fraudCheck(x, Id))
			{
				str= "request denied : Fraud";
				x.setState(CreditState.REJECTED);
			}*/
				
		 
			 
				int score = creditsService.scooring(x);
				  
			      Offer o = offerService.searchOfferScore(score);
				if(o!=null)
				{
					offerService.assignOfferToCredit(o, x);
					
					x.setState(CreditState.WAITING);
					
				}
				else {
					str = "request denied : Score not enough";
					x.setState(CreditState.REJECTED);
				}
				
				
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		creditsService.addCredits(x);
		return str;

	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeCredits(@PathVariable("id") Long Id) {
		creditsService.deleteCredits(Id);
	}

	@PutMapping("/update")
	@ResponseBody
	public Credits modifyCredits(@RequestBody Credits f) {
		return creditsService.updateCredits(f);
	}

	@PutMapping("/accept/{id}")
	@ResponseBody
	public Credits acceptCredit(@PathVariable("id") Long Id) {
		Credits c = creditsService.acceptCredit(Id);
		repaymentService.addCredit(c);
		return c ;
 	}
	@PutMapping("/reject/{id}")
	@ResponseBody
	public Credits rejectCredit(@PathVariable("id") Long Id) {
 
		Credits c= creditsService.rejectCredit(Id);
		 return c ;
		 
		 
 	}

	/*@GetMapping("/simulation/{i}/{a}/{n}")
	@ResponseBody
	public double getSimulation(@PathVariable("i") double annualInterestRate, @PathVariable("a") double amount,
			@PathVariable("n") int numberOfYears) {
		double x = creditsService.simulation(annualInterestRate, amount, numberOfYears);
		return x;

	}*/


}
