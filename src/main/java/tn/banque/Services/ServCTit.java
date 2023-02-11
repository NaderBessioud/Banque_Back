package tn.banque.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptetitre;
import tn.banque.Entities.Obligation;
import tn.banque.Repositories.CBRepo;
import tn.banque.Repositories.CTitRepo;
import tn.banque.Repositories.ObRepo;


@Transactional
@Service
public class ServCTit implements ISCTit {
	@Autowired
	CTitRepo repo;
	@Autowired
	CBRepo repcb;
	@Autowired
	ObRepo repob;

	@Override
	public Comptetitre addct(Comptetitre ct,Long idcb) {
		Comptebancaire cb= repcb.findById(idcb).get();
		ct.setComptebancairet(cb);
		return repo.save(ct);
	}

	@Override
	public void deletectit(String id) {
		repo.deleteById(id);
		
	}

	@Override
	public Comptetitre updateCt(Comptetitre ct) {
		
		return repo.save(ct);
	}

	@Override
	public Comptetitre retrieveCt(String id) {
		Comptetitre ct=repo.findById(id).get();
		return ct;
	}

	@Override
	public List<Comptetitre> retrieveAllCt() {
		List<Comptetitre> lct=(List<Comptetitre>)repo.findAll();
		return lct;
	}
	@Override
	public List<Comptetitre> retrieveAllCtbyuser(Long idu) {
		List<Comptetitre> lctu=repo.getcomptetitre((idu));
		return lctu;
	}
	
	@Override
	public Comptetitre acheterobligation(String idct, Long idob) {
		Comptetitre ct= repo.findById(idct).get();
		Obligation ob= repob.findById(idob).get();
		
			if (ob.getPrixemission()<ct.getSolde()){
				ct.getObligations().add(ob);
				ct.setSolde(ct.getSolde()-ob.getPrixemission());
				repo.save(ct);
				}
			
		
		return ct;
		
	}

	/*@Override
	public Comptetitre liquiderobligation(Long idU, Long idO, Long idCt) {
	
		Obligation ob= repob.findById(idO).get();
		Comptetitre acheteur=repo.findById(idCt).get();
		Comptetitre vendeur=repo.getcomptetitre(idU);
		if(repo.getcomptetitre(idU).getObligations().contains(ob)) {
			
			if (ob.getPrixemission()<acheteur.getSolde()){
				acheteur.getObligations().add(ob);
				acheteur.setSolde(acheteur.getSolde()-ob.getPrixemission());
					vendeur.setSolde(vendeur.getSolde()+ob.getPrixemission());
					vendeur.getObligations().remove(ob);
					repo.save(vendeur);
					repo.save(acheteur);
					}
			
		}
		return vendeur;
		
	}*/
	
		
	
	
	@Scheduled(cron = "*/10 * * * * *") 
	public void versement() {
		List<Comptetitre> listct= (List<Comptetitre>) repo.findAll();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		for(Comptetitre ct:  listct) {
			System.out.println(ct);
			if(ct.getObligations()!=null) {
				for(Obligation ob:ct.getObligations()) {
					
					String datect= ob.getDateemission().toString();
				    String annee=datect.substring(0, 4);
				    String mois=datect.substring(5, 7);
				    String day=datect.substring(8, 10);
				   
				    if (ob.getFrequencecoupon()=="Annuel") {
					    if (Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
					    		Integer.parseInt(mois)==localDateTime.getMonthValue() &&
					    		Integer.parseInt(annee) +ob.getMaturite()==localDateTime.getYear()) {
					    	ct.setSolde(ct.getSolde()+ob.getPrixrembourssement());
					    	ct.getObligations().remove(ob);
					    	repo.save(ct);}
					    else if (Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
								Integer.parseInt(mois)==localDateTime.getMonthValue()) {
					    	ct.setSolde(ct.getSolde()+ob.getCoupon());
							repo.save(ct);}
				    }
				    else if(ob.getFrequencecoupon().equals("Semi-annuel")) {
				    	System.out.println("okkkkkkkkkkkk");
						if (Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
							    		Integer.parseInt(mois)==localDateTime.getMonthValue() &&
							    		Integer.parseInt(annee) +ob.getMaturite()==localDateTime.getYear()){
							
							ct.setSolde(ct.getSolde()+ob.getPrixrembourssement());
							ct.getObligations().remove(ob);
							repo.save(ct);}
						else if (Integer.parseInt(mois)+6>12) {
							int y=Integer.parseInt(mois)+6-12;
							if(Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
										y==localDateTime.getMonthValue()) {
								ct.setSolde(ct.getSolde()+ob.getCoupon());
								repo.save(ct);
								}
							 
						 }}
				    else if(ob.getFrequencecoupon().equals("Trimestriel")) {
				    	
						if (Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
							    		Integer.parseInt(mois)==localDateTime.getMonthValue() &&
							    		Integer.parseInt(annee) +ob.getMaturite()==localDateTime.getYear()){
							
							ct.setSolde(ct.getSolde()+ob.getPrixrembourssement());
							ct.getObligations().remove(ob);
							repo.save(ct);}
						else if (Integer.parseInt(mois)+3>12) {
							int y=Integer.parseInt(mois)+3-12;
							if(Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
										y==localDateTime.getMonthValue()) {
								ct.setSolde(ct.getSolde()+ob.getCoupon());
								repo.save(ct);
								}
							 
						 }}
				    else if(ob.getFrequencecoupon().equals("Mensuel")) {
				    	
						if (Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
							    		Integer.parseInt(mois)==localDateTime.getMonthValue() &&
							    		Integer.parseInt(annee) +ob.getMaturite()==localDateTime.getYear()){
							
							ct.setSolde(ct.getSolde()+ob.getPrixrembourssement());
							ct.getObligations().remove(ob);
							repo.save(ct);}
						else if (Integer.parseInt(mois)+1>12) {
							int y=Integer.parseInt(mois)+1-12;
							if(Integer.parseInt(day)==localDateTime.getDayOfMonth() &&
										y==localDateTime.getMonthValue()) {
								ct.setSolde(ct.getSolde()+ob.getCoupon());
								repo.save(ct);
								}
							 
						 }}
	
				  
				}
		}
		}
	}
	@Override
	public List<Object> stats() {
		List<Comptetitre> ls= (List<Comptetitre>) repo.findAll();
		List<Obligation> lob =new ArrayList<Obligation>();
		List<Object> list= new ArrayList<Object>();
		for(Comptetitre ct:ls) 
			lob.addAll(ct.getObligations());
		
		
		for (int i = 0; i < lob.size(); i++) {
			
		
			list.add(Collections.frequency(lob, lob.get(i)));
			if(Collections.frequency(lob, lob.get(i))>1)
				for(int j=0;j<lob.size();j++) 
					if(lob.get(i)==lob.get(j)) 
						lob.remove(j)	;	
			
		
				
		}	
		
			
			
		return list;
	}

	@Override
	public List<String> names() {
		List<Comptetitre> ls= (List<Comptetitre>) repo.findAll();
		List<Obligation> lob =new ArrayList<Obligation>();
		List<String> list= new ArrayList<String>();
		for(Comptetitre ct:ls) 
			lob.addAll(ct.getObligations());
		
		
		for (int i = 0; i < lob.size(); i++) {
			list.add(lob.get(i).getEmetteur());
			if(Collections.frequency(lob, lob.get(i))>1)
				for(int j=0;j<lob.size();j++) 
					if(lob.get(i).getIdO()==lob.get(j).getIdO()) 
						lob.remove(j)	;	
			
		}	
		
			
			
		return list;
	}
	
	
	
	@Override
	public float alimenter(float x,String idct,long idcb) {
	Comptebancaire cb= repcb.findById(idcb).get();
	Comptetitre ct=repo.findById(idct).get();
	if(cb.getComptecourrantbancaire().getSolde()>x) {
	ct.setSolde(ct.getSolde()+x);
	cb.getComptecourrantbancaire().setSolde(cb.getComptecourrantbancaire().getSolde()-x);
	repo.save(ct);
	repcb.save(cb);
	}

	return x;
	}
	
	
	@Override
	public List<Comptebancaire> afficheliste(Long iduser) {
	List<Comptebancaire> lscb= repcb.getcomptebc(iduser);
	return lscb;
	}

	

}
