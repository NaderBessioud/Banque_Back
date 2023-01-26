package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Credits;
import tn.banque.Entities.Repayment;

public interface IRepaymentService {

	List<Repayment> retrieveAllRepayments();
	List<Repayment> getbycredits(long id);

	Repayment addRepayment(Repayment o);

	void deleteRepayment(Long id);

	Repayment updateRepayment(Repayment o);

	Repayment retrieveRepayment(Long id);
	
	void notification();
	
	List<Repayment> addCredit(Credits c);
	public List<Repayment> retrieveUnpaidRepayments();
	
}