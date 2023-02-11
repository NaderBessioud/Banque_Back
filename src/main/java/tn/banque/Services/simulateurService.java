package tn.banque.Services;

public interface simulateurService {

	 double calculMensualiteTauxFixe(double capital, int mois,double interest);
	 double calculMensualiteTauxVariable(double capital, int mois,double interest);
	 
	 
	 String simulationInterestImmobilierAtauxFixe(double capital, int mois,double revenu_mensuel);
	 String simulationInterestveheculeAtauxFixe(double capital, int mois,double revenu_mensuel);
	 String simulationInterestPersonnelAtauxFixe(double capital, int mois,double revenu_mensuel);
	 
	 
	 String simulationInterestImmobilierAtauxVariable(double capital, int mois,double revenu_mensuel);
	 String simulationInterestveheculeAtauxVariable(double capital, int mois,double revenu_mensuel);
	 String simulationInterestPersonnelAtauxVariable(double capital, int mois,double revenu_mensuel);
	 
	 
	 double calculMantantInterest(double capital, double montantTotal);
}
