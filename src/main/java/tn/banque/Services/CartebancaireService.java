package tn.banque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Cartebancaire;
import tn.banque.Repositories.CarteBancaireRepository;

@Service
public class CartebancaireService implements ICartebancaireService {

	@Autowired
	CarteBancaireRepository carteRepo;
	
	@Override
	public
	Cartebancaire addCarteBancaire(Cartebancaire cartebancaire) {
		carteRepo.save(cartebancaire);
		return cartebancaire;
	}
	
	@Override
	public
	List<Cartebancaire> retrieveAllCartebancaire(){
		List<Cartebancaire> list = carteRepo.findAll();
		return list;
	}
	
	
	@Override
	public 
	Cartebancaire retrieveCartebancaire(Long idCB) {
		Cartebancaire carte = carteRepo.findById(idCB).orElse(null);
		return carte;
		
	}
	
	
	@Override
	
	public
	Cartebancaire CarteByCompteId(Long idCC) {
		Cartebancaire carte = carteRepo.CarteByCompteId(idCC);
		return carte;
	}

	
	@Override
	public 
	int [] nbrCarte() {
		return carteRepo.nbrCarte();
	}
	
	
	@Override
	public
	String [] nomCarte() {
		return carteRepo.nomCarte();
	}
	
	@Override
	public 
	String[][] nbrCarteUtil(){
		return carteRepo.nbrCarteUtil();
	}
	
	
}
