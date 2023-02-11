package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Comptecourrant;

public interface IComptecourrantService {


	List<Comptecourrant> retrieveAllCompteCourrant();

	Comptecourrant retrieveCompteCourrant(Long idCC);

	Comptecourrant addCompteCourrant(Comptecourrant comptecourrant, Long idCB, Long idCBA);

}
