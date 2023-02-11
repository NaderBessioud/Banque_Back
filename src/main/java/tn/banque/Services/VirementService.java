package tn.banque.Services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.Virement;
import tn.banque.Repositories.CompteCourrantRepository;
import tn.banque.Repositories.VirementRepository;

@Service
public class VirementService implements IVirementService {

	@Autowired
	VirementRepository virementRepo;
	@Autowired
	CompteCourrantRepository compteRepo;
	
	@Override
	public boolean addVirement(Virement virement, Long idCC) {
		Comptecourrant compte = compteRepo.findById(idCC).orElse(null);
		virement.setVirementcompte(compte);
		virement.setRibe(compte.getRib());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		virement.setDate(timestamp);
		virementRepo.save(virement);
		
		float resulat = compte.getSolde()-virement.getSomme();
		if(resulat >= 0) {
		compte.setSolde(compte.getSolde()-virement.getSomme());
		compteRepo.save(compte);
       Comptecourrant compteRecepteur = compteRepo.retrieveCompteByRib(virement.getRibr());
       if(compteRecepteur != null) {
    	   compteRecepteur.setSolde(compteRecepteur.getSolde()+virement.getSomme());
    	   compteRepo.save(compteRecepteur);	
       }
       return true;
		}else {
			virementRepo.delete(virement);
			return false;
		}
		
		
	}
	

	@Override
	public List<Object[]> retrieveAllVirement(){
		List<Object[]> list = virementRepo.virementRef();
		return list;
	}
	
	
	
	
	@Override
	public List<Virement> retrieveVirementEmetteur(Long idCC){
		Comptecourrant compte = compteRepo.findById(idCC).orElse(null);
		return virementRepo.retrieveVirementRibEmetteur(compte.getRib());
	}
	
	@Override
	public List<Virement> retrieveVirementRecepteur(Long idCC){
		Comptecourrant compte = compteRepo.findById(idCC).orElse(null);
		return virementRepo.retrieveVirementRibRecepteur(compte.getRib());
	}
	
}
