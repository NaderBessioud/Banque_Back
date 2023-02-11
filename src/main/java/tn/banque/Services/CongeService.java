package tn.banque.Services;

import java.util.List;

import javax.mail.MessagingException;

import tn.banque.Entities.Conge;


public interface CongeService {
	 List<Conge> retrieveAllCangeNonAccepter();
	 List<Conge> retrieveAllSliceAccepter();
	Conge  ajouter_Conge(Conge c,Long idU);
	Conge modifier_Conge(Conge c , Long idc);
	List<Conge> all_Conge();
	Conge afficher_Conge(Long idc);
	void SupprimerConge(Long idc); 
	void accepter_conge(Long idc, String body , String email) throws MessagingException;
	int calcul_conge(Long idU);
}
