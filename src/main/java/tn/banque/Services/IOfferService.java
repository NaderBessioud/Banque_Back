package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Credits;
import tn.banque.Entities.Offer;

public interface IOfferService {
	
	List<Offer> retrieveAllOffers();

	Offer addOffer(Offer o);

	void deleteOffer(Long id);

	Offer updateOffer(Offer o);

	Offer retrieveOffer(Long id);
	
	Offer searchOfferScore(int score);
	
	void assignOfferToCredit(Offer o , Credits  c);
	
	
}
