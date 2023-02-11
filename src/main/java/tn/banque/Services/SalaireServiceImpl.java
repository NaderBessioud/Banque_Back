package tn.banque.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Salaire;
import tn.banque.Entities.User;
import tn.banque.Repositories.SalaireRepository;
import tn.banque.Repositories.UserRepo;

@Service
public class SalaireServiceImpl implements SalaireService {

	@Autowired
	SalaireRepository salaireRepository;
	
	@Autowired
	UserRepo ur;
	@Override
	public Salaire ajouter_Salaire(Salaire s, Long id) {
		User u = ur.findById(id).orElse(null);
		s.setEmployeesal(u);
		return salaireRepository.save(s);
	}

	@Override
	public Salaire modifier_Salaire(Salaire s, Long ids) {
		s.setIdSalaire(ids);
		return salaireRepository.save(s);
	}

	@Override
	public List<Salaire> all_Salaire() {
		List<Salaire> list=salaireRepository.findAll();
		return list;
	}

	@Override
	public Salaire afficher_Salaire(Long ids) {
		Salaire salaire=salaireRepository.findById(ids).orElse(null);
		return salaire;
	}
	
	
	@Override
	public List<Salaire> afficher_Salaire_month(int month, int anne) {
		List<Salaire> ll = new ArrayList<>();
		for (Salaire s : salaireRepository.findAll()) {
			if(s.getDataperception().getMonth() == month && s.getDataperception().getYear() == anne)
				ll.add(s);
		}
		return ll;
	}

	@Override
	public void SupprimerSalaire(Long ids) {
		salaireRepository.deleteById(ids);
		
	}
	@Scheduled(cron =  "*/10 * * * * *" )
	@Override
	public void Calculer_Salaire_net() {
	for (Salaire sal : salaireRepository.findAll()) {
		
	sal.setSalairenet(	(sal.getSalairebase() + sal.getHeuresup() * sal.getProdheuresup())-((sal.getSalairebase()*sal.getImpotrevenu())/100) );
		
	salaireRepository.save(sal);
	System.out.println("test scudler");
	}
		
	}

}
