package tn.banque.Services;

import java.util.List;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Compteepargne;
import tn.banque.Entities.TypeEpargne;
import tn.banque.Repositories.CompteEpargneRepository;

@Service
public class CompteEpargneService implements CompteEpargneServiceInter{
	@Autowired
	private CompteEpargneRepository compteEpargneRepository;

	@Override
	public List<Compteepargne> retrieveAllCompteepargnes() {
		return (List<Compteepargne>) compteEpargneRepository.findAll();
	}

	@Override
	public Compteepargne addCompteepargne(Compteepargne c) {
		return compteEpargneRepository.save(c);
	}

	@Override
	public void deleteCompteepargne(Long id) {
		compteEpargneRepository.deleteById(id);
		
	}

	@Override
	public Compteepargne updateCompteepargne(Compteepargne c) {
		return compteEpargneRepository.save(c);
	}

	@Override
	public Compteepargne retrieveCompteepargne(Long id) {
		return compteEpargneRepository.findById(id).get();
	}

	@Override
	public double simulate(TypeEpargne type, float mens, float init,int periode) {
		double res=0;
		double taux=0;
		double tauxm=0;
		int periodem=periode*12;
		if(type == TypeEpargne.LIVRET_A)
			taux=0.02;
		else if(type ==TypeEpargne.LEP)
			taux=0.046;
		else if(type ==TypeEpargne.LDDS)
			res=0;
		else if(type ==TypeEpargne.LIVRET_JEUNE)
			res=0;
		tauxm=Math.pow((1+taux), 1.0/12.0);
		res=init*Math.pow(tauxm, periode*12);
		
		for(int i=0;i<periodem;i++) {
			res=res+(mens*Math.pow(tauxm, periodem-i));
		}
			
		return Precision.round(res, 3);
	}

	@Override
	public double simulatePM(TypeEpargne type, float mens, float init, int periode) {
		double res=0;
		double taux=0;
		double tauxm=0;
		
		if(type == TypeEpargne.LIVRET_A)
			taux=0.02;
		else if(type ==TypeEpargne.LEP)
			taux=0.046;
		else if(type ==TypeEpargne.LDDS)
			res=0;
		else if(type ==TypeEpargne.LIVRET_JEUNE)
			res=0;
		tauxm=Math.pow((1+taux), 1.0/12.0);
		res=init*Math.pow(tauxm, periode);
		
		
		
		for(int i=0;i<periode;i++) {
			res=res+(mens*Math.pow(tauxm, periode-i));
			
		}
			
		return Precision.round(res, 3);
	}
	@Override
	public double simulatePerSemesterPerA(TypeEpargne type, float mens, float init, int periode) {
		double res=0;
		double taux=0;
		double tauxm=0;
		int periodeS=periode*4;
		if(type == TypeEpargne.LIVRET_A)
			taux=0.02;
		else if(type ==TypeEpargne.LEP)
			taux=0.046;
		else if(type ==TypeEpargne.LDDS)
			res=0;
		else if(type ==TypeEpargne.LIVRET_JEUNE)
			res=0;
		tauxm=Math.pow((1+taux), 1.0/4.0);
		res=init*Math.pow(tauxm, periode*4);
		
		for(int i=0;i<periodeS;i++) {
			res=res+(mens*Math.pow(tauxm, periodeS-i));
		}
			
		return Precision.round(res, 3);
	}
	
	@Override
	public double simulatePerSemesterPerM(TypeEpargne type, float mens, float init, int periode) {
		double res=0;
		double taux=0;
		double tauxm=0;
		int periodeS=Math.round(periode/3);
		if(type == TypeEpargne.LIVRET_A)
			taux=0.02;
		else if(type ==TypeEpargne.LEP)
			taux=0.046;
		else if(type ==TypeEpargne.LDDS)
			res=0;
		else if(type ==TypeEpargne.LIVRET_JEUNE)
			res=0;
		tauxm=Math.pow((1+taux), 1.0/4.0);
		res=init*Math.pow(tauxm, periodeS);
		
		for(int i=0;i<periodeS;i++) {
			res=res+(mens*Math.pow(tauxm, periodeS-i));
		}
			
		return Precision.round(res, 3);
	}
	
	
	@Override
	public double simulatePerYearPerA(TypeEpargne type, float mens, float init, int periode) {
		double res=0;
		double taux=0;
		
		
		if(type == TypeEpargne.LIVRET_A)
			taux=0.02;
		else if(type ==TypeEpargne.LEP)
			taux=0.046;
		else if(type ==TypeEpargne.LDDS)
			res=0;
		else if(type ==TypeEpargne.LIVRET_JEUNE)
			res=0;
		
		res=init*Math.pow(taux, periode);
		
		for(int i=1;i<periode;i++) {
			res=res+(mens*Math.pow(taux, periode-i));
		}
			
		return Precision.round(res, 3);
	}
	
	@Override
	public double simulatePerYearPerM(TypeEpargne type, float mens, float init, int periode) {
		double res=0;
		double taux=0;
		int periodem=Math.round(periode/12);
		
		if(type == TypeEpargne.LIVRET_A)
			taux=0.02;
		else if(type ==TypeEpargne.LEP)
			taux=0.046;
		else if(type ==TypeEpargne.LDDS)
			res=0;
		else if(type ==TypeEpargne.LIVRET_JEUNE)
			res=0;
		
		res=init*Math.pow(taux, periodem);
		
		for(int i=1;i<periodem;i++) {
			res=res+(mens*Math.pow(taux, periodem-i));
		}
			
		return Precision.round(res, 3);
	}
	@Override
	public double ContributionTotale(double vers,String type,String typeP,int p) {
		double result=0;
		if(type.equals("mensuel")) {
			if(typeP.equals("mois")) {
				result=vers*p;
			}
			else
				result=vers*(Math.round(p/12));
		}
		
		else if(type.equals("semestriel")) {
			if(typeP.equals("mois")) {
				result=vers*(Math.round(p/3));
			}
			else
				result=vers*p*4;
		}
		
		else {
			if(typeP.equals("mois")) {
				result=vers*(Math.round(p/12));
			}
			else
				result=vers*p;
		}
		
		
		return result;
	}
	

}
