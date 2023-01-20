package tn.banque.Services;

import java.util.List;


import tn.banque.Entities.Comptetitre;
import tn.banque.Entities.Obligation;



public interface ISCTit {
	Comptetitre addct(Comptetitre ct,Long idcb);
	void deletectit(String id);
	Comptetitre updateCt(Comptetitre ct);
	Comptetitre retrieveCt(String id);
	List<Comptetitre> retrieveAllCt();
	List<Comptetitre> retrieveAllCtbyuser(Long idu);
	
	Comptetitre acheterobligation(String idct, Long idob );
	//Comptetitre liquiderobligation(Long idU, Long idO ,Long idCt );
	List<Object> stats();
	List<String> names();
}
