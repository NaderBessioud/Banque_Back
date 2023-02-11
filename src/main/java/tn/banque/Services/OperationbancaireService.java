package tn.banque.Services;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.Operationbancaire;
import tn.banque.Entities.TypeOperation;
import tn.banque.Repositories.CompteCourrantRepository;
import tn.banque.Repositories.OperationBancaireRepository;

@Service
public class OperationbancaireService implements IOperationbancaireService {

	@Autowired
	OperationBancaireRepository operationRepo;
	@Autowired
	CompteCourrantRepository compteRepo;
	
	
	
	@Override
	public List<Operationbancaire> retrieveAllOperation(){
		return operationRepo.findAll();
	}
	
	@Override
	
	public List<Operationbancaire> retrieveByCompte(Long idCC){
		List<Operationbancaire> list = operationRepo.OperationByCompte(idCC);
		return list;
	}
	
	
	@Override
	
public 
boolean addDepot(Operationbancaire operation, Long idCC) {
	Comptecourrant compte = compteRepo.findById(idCC).orElse(null);
	operation.setDiffere(false);
	operation.setImmediat(false);
	operation.setTypeoperation(TypeOperation.DEPOT);
	operation.setComptecourrantO(compte);
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	operation.setCreatedAt(timestamp);
	operationRepo.save(operation);
	compte.setSolde(compte.getSolde()+operation.getSomme());
	compteRepo.save(compte);
	return true;
}




	public List<LocalDate> dayscurrentweek() {
	      LocalDate listDays = LocalDate.now();
	        List<LocalDate> list = Arrays.asList(DayOfWeek.values()).stream().map(listDays::with).collect(toList());
	        //System.out.println(list.get(0));
	        //System.out.println(list.get(6));
	        List<LocalDate> dates = new ArrayList();
	        dates.add(list.get(0));
	        dates.add(list.get(6).plusDays(1));
	        return dates;
	}
	
	
	
	
	@Override
	public boolean addRetrait(Operationbancaire operation, Long idCC) {
		Comptecourrant compte = compteRepo.findById(idCC).orElse(null);
		operation.setDiffere(false);
		operation.setImmediat(false);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		operation.setCreatedAt(timestamp);
		operation.setTypeoperation(TypeOperation.RETRAIT);
		operation.setComptecourrantO(compte);
		operationRepo.save(operation);
		List<LocalDate> date = dayscurrentweek();
		float sommeRetrait = operationRepo.SommeRetrait(idCC, date.get(0), date.get(1));
		if( (sommeRetrait>(compte.getCarteB().getPlafondsemaine_retrait())) || (compte.getSolde()<0) || ((compte.getSolde()-operation.getSomme())<0) ) {
			operationRepo.delete(operation);
			return false;
		}else {
			compte.setSolde(compte.getSolde()-operation.getSomme());
			compteRepo.save(compte);
			return true;
		}
	}
	
	

	
	@Override
	public
boolean addAchat(Operationbancaire operation, Long idCC) {
	Comptecourrant compte = compteRepo.findById(idCC).orElse(null);
	boolean differe = compte.getCarteB().isDebit_differe();
	boolean immediat = compte.getCarteB().isDebit_immediat();
	operation.setImmediat(immediat);
	operation.setDiffere(differe);
	operation.setComptecourrantO(compte);
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	operation.setCreatedAt(timestamp);
	operation.setTypeoperation(TypeOperation.ACHAT);
	operationRepo.save(operation);
	
	float sommepaiement = operationRepo.SommeAchatMois(idCC);
	if((sommepaiement > compte.getCarteB().getPlafondmois_paiement())) {
		operationRepo.delete(operation);
		return false;
	}else {
		compte.setSolde(compte.getSolde()-operation.getSomme());
		compteRepo.save(compte);
		return true;
	}
	
}	
	
	@Override
	public float currentPaiement(Long idCC) {
		float sommepaiement = operationRepo.SommeAchatMois(idCC);
		return sommepaiement;
	}
	
	
	@Override
	public float currentRetrait(Long idCC) {
		List<LocalDate> date = dayscurrentweek();
		float sommeRetrait = operationRepo.SommeRetrait(idCC, date.get(0), date.get(1));
		return sommeRetrait;
	}
	
	
	@Override
	public List<Operationbancaire> OperationAVenir(Long idCC){
		return operationRepo.OperationAVenir(idCC);
	}

	
	@Override
	public float[] statOperation(Long idCC){
		float[] operation = new float[3];
		float statAchat = operationRepo.statAchat(idCC);
		
		operation[0]= statAchat;
		
		float statDepot = operationRepo.statDepot(idCC);
		
		
		operation[1]= statDepot;
		float statRetrait = operationRepo.statRetrait(idCC);
		
		operation[2]= statRetrait;
		return operation ;
	}
	
	
	
	@Override
	public List<Object[]> StatOperationMois(){
		List<Object[]> resultList =operationRepo.findSommeByTypeOperationGroupByMonthAndYear();
		return resultList;
	}
	 
	
	
	@Override
	public List<Object[]> AllOperationCompte(){
		List<Object[]> resultList = operationRepo.findOperationBancaireWithCompteCourantAndCompteBancaire();
		return resultList;
	}
	
	
	
	
@Scheduled(cron = "0 0 0 28-31 * ?" )
public void MAJSoldeDiffere() {
	List<Comptecourrant> listCompte = compteRepo.findAll();
	for (Comptecourrant list : listCompte) {
		float TotalDiffere = operationRepo.SommeDiffereMois(list.getIdCC());
		list.setSolde(list.getSolde()- TotalDiffere);
		compteRepo.save(list);
	}		
}

@Scheduled(cron = "0 0 0 * * *")
	public void MAJSoldeImmediat() {
	List<Comptecourrant> listCompte = compteRepo.findAll();
	for (Comptecourrant list : listCompte) {
		float TotalImmediat = operationRepo.SommeImmediat(list.getIdCC());
		list.setSolde(list.getSolde() - TotalImmediat);
		compteRepo.save(list);
	}
}




}





