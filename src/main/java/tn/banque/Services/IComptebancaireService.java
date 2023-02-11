package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.User;

public interface IComptebancaireService {

	Comptebancaire addCompteBancaire(Comptebancaire comptebancaire, Long idU);

	Comptebancaire addCompteCourrantBancaire(Long idCBA, Comptecourrant comptecourrant, Long idCB);

	List<User> retrieveAllUser();

	List<Comptebancaire> retrieveAllComptebancaire();


}
