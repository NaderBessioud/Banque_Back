package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Salaire;


public interface SalaireService {

	Salaire ajouter_Salaire(Salaire s, Long id);
	Salaire modifier_Salaire(Salaire s , Long ids);
	List<Salaire> all_Salaire();
	Salaire afficher_Salaire(Long ids);
	void SupprimerSalaire(Long ids); 
	void Calculer_Salaire_net();
	List<Salaire> afficher_Salaire_month(int month, int anne);
}
