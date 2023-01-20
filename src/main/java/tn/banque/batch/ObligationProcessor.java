package tn.banque.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.banque.Entities.Obligation;
import tn.banque.Repositories.ObRepo;

@Component
public class ObligationProcessor implements ItemProcessor<Obligation, Obligation> {
	@Autowired
	 ObRepo rep;

	  @Override
	  public Obligation process(Obligation Obligation) throws Exception {
	    Optional<Obligation> opt=rep.findById(Obligation.getIdO());
	    if(opt.isPresent()) {
	      Float vn=Obligation.getVn();
	      Obligation ob=opt.get();
	      float prix=ob.getPrixemission();
	    }
	    return Obligation; 

}}

