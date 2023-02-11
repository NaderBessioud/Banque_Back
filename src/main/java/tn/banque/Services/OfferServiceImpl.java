package tn.banque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Credits;
import tn.banque.Entities.Offer;
import tn.banque.Repositories.OfferRepository;

@Service
public class OfferServiceImpl implements IOfferService {

	@Autowired
	OfferRepository offrerepository ;

	@Override
	public List<Offer> retrieveAllOffers() {
		
		return (List<Offer>) offrerepository.findAll();
	}

	@Override
	public Offer addOffer(Offer o) {
		 
		 offrerepository.save(o);
		 return o;
	}

	@Override
	public void deleteOffer(Long id) {
		 offrerepository.deleteById(id);
		
		
	}

	@Override
	public Offer updateOffer(Offer o) {
		 offrerepository.save(o);
		 return o;
	}

	@Override
	public Offer retrieveOffer(Long id) {
		 return offrerepository.findById(id).orElse(null);
	}

	@Override
	public Offer searchOfferScore(int score) {
		 
		return offrerepository.matchingOffer(score);
	}

	@Override
	public void assignOfferToCredit(Offer o, Credits c) {
		c.setOffer(o);
		
	}
	
}
