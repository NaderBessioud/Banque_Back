package tn.banque.Services;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Credits;
import tn.banque.Entities.Repayment;
import tn.banque.Repositories.RepayementRepository;
@Service
public class RepayementServiceImpl implements IRepaymentService{

	@Autowired
	RepayementRepository repaymentrepository ;
	
	@Autowired
	private EmailSenderService service;
	
	@Override
	public List<Repayment> retrieveAllRepayments() {
		
		return (List<Repayment>) repaymentrepository.findAll();
	}
	
	@Override
	public List<Repayment> retrieveUnpaidRepayments() {
		
		return (List<Repayment>) repaymentrepository.unpaidRepayments(new Date());
	}

	@Override
	public Repayment addRepayment(Repayment o) {
		 
		 repaymentrepository.save(o);
		 return o;
	}

	@Override
	public void deleteRepayment(Long id) {
		 repaymentrepository.deleteById(id);
		
		
	}

	@Override
	public Repayment updateRepayment(Repayment o) {
		 repaymentrepository.save(o);
		 return o;
	}

	@Override
	public Repayment retrieveRepayment(Long id) {
		 return repaymentrepository.findById(id).orElse(null);
	}
	
	@Scheduled(fixedDelay = 60*60*1000*10, initialDelay = 5000)
	@Override
	public void notification() {
		
		
		service.sendSimpleEmail("mohammedamine.kridiss@esprit.tn","veuiller proceder au paiement de votre facture","retard de paiement creditS");
		
	}

	@Override
	public List<Repayment> addCredit(Credits c) {
		
		
		double monthlyInterestRate = c.getOffer().getInterestRate()/ 1200;
 		double monthlyPayment = c.getAmount() * monthlyInterestRate
				/ (1 - 1 / Math.pow(1 + monthlyInterestRate, c.getDuration_months()));
		 
 
		monthlyPayment= Precision.round(monthlyPayment, 2);
		System.out.println(monthlyPayment);
		Date d = new Date();
	       System.out.println("ggggggggggggg");

        for (int i = 0; i < c.getDuration_months(); i++) {
        	d=DateUtils.addMonths(d, 1);
        	Repayment r = new Repayment(d,  monthlyPayment, false, c);
    		addRepayment(r); 
    	       System.out.println("dffffffffffffff");

		}
		return null;
	}

	@Override
	public List<Repayment> getbycredits(long id) {
		return  		repaymentrepository.findByCredit_ID(id);
 
	}

}
