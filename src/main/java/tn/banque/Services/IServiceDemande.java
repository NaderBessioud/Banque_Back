package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Comptebancaire;

import tn.banque.Entities.DemandeCreationCtit;

public interface IServiceDemande {
	DemandeCreationCtit retrieveDemande(Long id);
	List<DemandeCreationCtit> retrieveAllDemande();
	Boolean addct(DemandeCreationCtit demande,Long idcb);
	void changerstatut(Long id);
	List<Comptebancaire> afficheliste(Long iduser);

}
