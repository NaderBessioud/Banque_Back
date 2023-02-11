package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Cartebancaire;

public interface ICartebancaireService {

	Cartebancaire addCarteBancaire(Cartebancaire cartebancaire);

	List<Cartebancaire> retrieveAllCartebancaire();

	Cartebancaire retrieveCartebancaire(Long idCB);

	Cartebancaire CarteByCompteId(Long idCC);

	int[] nbrCarte();

	String[] nomCarte();

	String[][] nbrCarteUtil();

}
