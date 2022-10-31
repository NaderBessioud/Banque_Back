package tn.banque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.RDV;
import tn.banque.Entities.User;
import tn.banque.Repositories.ConseillerRepository;
import tn.banque.Repositories.RDVRepository;

@Service
public class RDVService {
	@Autowired
	private RDVRepository rdvRepository;
	@Autowired
	private ConseillerRepository conseillerRepository;
	
	public RDV addRDV(RDV r,long id,long idc) {
		User conseiller=conseillerRepository.findById(id).get();
		User client=conseillerRepository.findById(idc).get();
		r.setEmployee(conseiller);
		r.setClient(client);
		return rdvRepository.save(r);
	}
	
	public List<RDV> getClientRDV(long idc){
		User client=conseillerRepository.findById(idc).get();
		return rdvRepository.findByClient(client);
	}

}
