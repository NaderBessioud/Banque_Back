package tn.banque.batch;

import java.text.ParseException;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.banque.Entities.Obligation;

@Component
@Scope("step")
public class ObligationReader implements ItemReader<Obligation> {

	  @Override
	  public Obligation read()
	      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	    return null;
	  }
	}