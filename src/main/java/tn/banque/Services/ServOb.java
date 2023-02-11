package tn.banque.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Comptetitre;
import tn.banque.Entities.Obligation;
import tn.banque.Repositories.CTitRepo;
import tn.banque.Repositories.ObRepo;


@Service
public class ServOb implements ISOb {
@Autowired
ObRepo repo;

@Override
public Obligation addOb(Obligation ob) {
	Date todaysDate = new Date();
	
	ob.setDateemission(todaysDate);
	return repo.save(ob);
}

@Override
public void deleteOb(Long id) {
	repo.deleteById(id);
	
}

@Override
public Obligation updateOb(Obligation ob) {
	return repo.save(ob);
}

@Override
public Obligation retrieveOb(Long id) {
	Obligation ob = repo.findById(id).orElse(null);
	System.out.println("Obligation :" + ob);
	return ob;
}

@Override
public List<Obligation> retrieveAllOb() {
    List<Obligation> Obs= (List<Obligation>) repo.findAll();
	for (Obligation ob: Obs) {
		System.out.println("Obligation :" + ob);
	
	}
	return Obs;
}

@Override
public float yieldtomaturity(float tc,String x, float fv, float pv, int n) {
	int y=0;
	if (x.contentEquals("Annuel") )
	    y=1;
	    
	else if (x.contentEquals("Mensuel"))
	    y=12;
	   
	else if(x.contentEquals("Semi-annuel"))
	    y=2;
	   
	else if(x.contentEquals("Trimestriel"))
	    y=4;
	 
	
	return (((tc/100)*fv)+(fv-pv)/(n*y))/((fv+pv)/2)*100;
}

@Override
public int simuler2obs(Long obl1,Long obl2) {
	Obligation ob1=repo.findById(obl1).get();
	Obligation ob2=repo.findById(obl2).get();
	float ym1;
	float ym2;
	int y=0;
	if (ob1.getFrequencecoupon().contentEquals("Annuel") |ob1.getFrequencecoupon().contentEquals("annuel")  )
	    y=1;
	    
	else if (ob1.getFrequencecoupon().contentEquals("Mensuel") |ob1.getFrequencecoupon().contentEquals("mensuel"))
	    y=12;
	   
	else if(ob1.getFrequencecoupon().contentEquals("Semi-annuel") |ob1.getFrequencecoupon().contentEquals("semi-annuel"))
	    y=2;
	   
	else if(ob1.getFrequencecoupon().contentEquals("Trimestriel") |ob1.getFrequencecoupon().contentEquals("trimestriel"))
	    y=4;
	
	ym1=(ob1.getCoupon()+(ob1.getVn()-ob1.getPrixemission()/(ob1.getMaturite()*y))/((ob1.getVn()+ob1.getPrixemission())/2))*100;
	int x=0;
	if (ob1.getFrequencecoupon().contentEquals("Annuel") |ob1.getFrequencecoupon().contentEquals("annuel")  )
	    x=1;
	    
	else if (ob1.getFrequencecoupon().contentEquals("Mensuel") |ob1.getFrequencecoupon().contentEquals("mensuel"))
	    x=12;
	   
	else if(ob1.getFrequencecoupon().contentEquals("Semi-annuel") |ob1.getFrequencecoupon().contentEquals("semi-annuel"))
	    x=2;
	   
	else if(ob1.getFrequencecoupon().contentEquals("Trimestriel") |ob1.getFrequencecoupon().contentEquals("trimestriel"))
	    x=4;
	
	ym2=(ob2.getCoupon()+(ob2.getVn()-ob2.getPrixemission()/(ob2.getMaturite()*x))/((ob2.getVn()+ob2.getPrixemission())/2))*100;
	int w=0;
	if(ym1>ym2)
		w=1;
	else if(ym1<ym2)
		w=-1;
	else if(ym1==ym2)
		w=0;
	return w;
		
}

@Override
public List<Float> simulateur(float tc, String x, float fv, float pv, int n) {
	int y=0;
	List<Float> ls=new ArrayList<Float>();
	float tca=tc+2;
	float tcd=tc-2;
	float recette=0;
	float recettea=0;
	float recetted=0;
	if (x.contentEquals("Annuel") )
	    y=1;
	    
	else if (x.contentEquals("Mensuel"))
	    y=12;
	   
	else if(x.contentEquals("Semi-annuel"))
	    y=2;
	   
	else if(x.contentEquals("Trimestriel"))
	    y=4;
	recette=((tc/100)*fv*n*y)+fv;
	recettea=((tca/100)*fv*n*y)+fv;
	recetted=((tcd/100)*fv*n*y)+fv;
	ls.add(tc);
	ls.add(fv);
	ls.add(tcd);
	ls.add(recette-recetted+fv);
	ls.add(recette-recetted);
	ls.add(tca);
	ls.add(recette-recettea+fv);
	ls.add(recette-recettea);
	
	return ls;
}



}
