package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Obligation;

public interface ISOb {
	Obligation addOb(Obligation ob);
	void deleteOb(Long id);
	Obligation updateOb(Obligation ob);
	Obligation retrieveOb(Long id);
	List<Obligation> retrieveAllOb();
	float yieldtomaturity(float tc,String x,float fv, float pv,int n);
	int simuler2obs(Long obl1,Long obl2);
	List<Float> simulateur(float tc,String x,float fv, float pv,int n);
	
	
}
