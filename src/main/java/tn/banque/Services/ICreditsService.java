package tn.banque.Services;

import java.util.List;
import java.util.Map;

import tn.banque.Entities.Credits;
import tn.banque.Entities.User;

public interface ICreditsService {
	
	
	List<Credits> retrieveAllCredits();
	Credits addCredits(Credits cr);
	Credits affectUser(Long Id, Credits c);
	void deleteCredits(Long id);
	Credits updateCredits(Credits cr);
	Credits retrieveCredits(Long id);
	String simulation(double annualInterestRate, double amount, int numberOfYears);
	int scooring(Credits c);
	boolean fraudCheck(Credits c, Long id) throws Exception;
	Credits  acceptCredit(Long id);
	Map<Integer, List<String>> excelImport(String FILE_NAME) throws Exception;
	public User test (Long id) ;
	Credits rejectCredit(Long id);
	  

}
