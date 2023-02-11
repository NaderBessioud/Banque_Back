package tn.banque.Services;

import java.io.UnsupportedEncodingException;
import java.util.List;

import tn.banque.Entities.Compteepargne;
import tn.banque.Entities.TypeEpargne;



public interface CompteEpargneServiceInter {
	List<Compteepargne> retrieveAllCompteepargnes();

	Compteepargne addCompteepargne(Compteepargne c) ;

	void deleteCompteepargne(Long id);

	Compteepargne updateCompteepargne(Compteepargne c);

	Compteepargne retrieveCompteepargne(Long id);
	
	double simulate(TypeEpargne type,float mens,float init,int periode);

	double simulatePM(TypeEpargne type, float mens, float init, int periode);
	public double simulatePerSemesterPerA(TypeEpargne type, float mens, float init, int periode);
	public double simulatePerSemesterPerM(TypeEpargne type, float mens, float init, int periode);
	public double simulatePerYearPerA(TypeEpargne type, float mens, float init, int periode);
	public double simulatePerYearPerM(TypeEpargne type, float mens, float init, int periode);
	public double ContributionTotale(double vers,String type,String typeP,int p);

}
