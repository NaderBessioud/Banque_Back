package tn.banque.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import tn.banque.Entities.Obligation;
import tn.banque.Repositories.ObRepo;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ObligationWritter implements ItemWriter<Obligation> {

	  @Autowired
	  ObRepo shareTranRepo;

	  @Override
	  public void write(List<? extends Obligation> list) throws Exception {

	    shareTranRepo.saveAll(list);
	    System.out.println("Size of Record stored:"+list.size());
	  }
}