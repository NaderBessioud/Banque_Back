package tn.banque.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer,Long>{


	@Query("SELECT o FROM Offer o WHERE :score BETWEEN (minScore+1) AND maxScore")
	Offer  matchingOffer(@Param("score") int score);
}
