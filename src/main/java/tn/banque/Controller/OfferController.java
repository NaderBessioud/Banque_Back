package tn.banque.Controller;

import java.util.List;

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

  import tn.banque.Entities.Offer;
  import tn.banque.Services.IOfferService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("offer")
public class OfferController {
	
	@Autowired
	IOfferService offerService;
	
	@GetMapping("/select")
	@ResponseBody
	public List<Offer>getOffer(){
		List<Offer>listOffers = offerService.retrieveAllOffers();
		return listOffers;
	}
	@GetMapping("/testscore/{i}")
	@ResponseBody
	public Offer getOffermatch(@PathVariable("i") int i){
		Offer listOffers = offerService.searchOfferScore(i);
		return listOffers;
	}
	@GetMapping("/select/{id}")
	@ResponseBody
	public Offer getOffer(@PathVariable("id") Long Id){
		 Offer f = offerService.retrieveOffer(Id);
		return f;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Offer addOffer(@RequestBody Offer x  )
	{
	Offer f = offerService.addOffer(x);
	return f;

	}
	 
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeOffer(@PathVariable("id") Long Id) {
	offerService.deleteOffer(Id);
	}

 	@PutMapping("/update")
	@ResponseBody
	public Offer modifyOffer(@RequestBody Offer f  ) {
	return offerService.updateOffer(f);
	}

}
