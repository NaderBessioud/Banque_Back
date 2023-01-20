package tn.banque.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptetitre;
import tn.banque.Entities.DemandeCreationCtit;
import tn.banque.Repositories.CBRepo;
import tn.banque.Repositories.CTitRepo;
import tn.banque.Repositories.DemandeRepo;

@Service
public class DemandeService implements IServiceDemande{
	@Autowired
	DemandeRepo repo;
	@Autowired
	CBRepo repcb;
	@Autowired 
	CTitRepo repoct;
	@Override
	public DemandeCreationCtit retrieveDemande(Long id) {
		DemandeCreationCtit demande=repo.findById(id).get();
		return demande;
	}

	@Override
	public List<DemandeCreationCtit> retrieveAllDemande() {
		List<DemandeCreationCtit> listdemande=(List<DemandeCreationCtit>)repo.findAll();
		return listdemande;
	}
	@Override
	public List<Comptebancaire> afficheliste(Long iduser) {
		List<Comptebancaire> lscb= repcb.getcomptebc(iduser);
		return lscb;
	}

	
	
	@Override
	public Boolean addct(DemandeCreationCtit demande, Long idct) {
		Boolean x=false;
		if (repoct.getcompte(idct)==null) {
			Comptebancaire cb= repcb.findById(idct).get();
			demande.setComptebancaire(cb);
			demande.setStatut(false);
			repo.save(demande);
			x=true;}
		
		return x;
		
	}

	@Override
	public void changerstatut(Long id) {
		DemandeCreationCtit dem=repo.findById(id).get();
		dem.setStatut(true);
		repo.save(dem);
	}
	@Scheduled(cron = "*/10 * * * * *") 
	public void updatedemandes() {
		List<DemandeCreationCtit> listdem= (List<DemandeCreationCtit>) repo.findAll();
		for(DemandeCreationCtit d :listdem) {
			if (d.getStatut()==true) 
				
				repo.delete(d);
				}
	}



	

}
