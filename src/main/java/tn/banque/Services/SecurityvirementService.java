package tn.banque.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.banque.Repositories.SecurityVirementRepository;





@Service
public class SecurityvirementService implements ISecurityvirementService{

	@Autowired
	SecurityVirementRepository securityvirementRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public boolean findComptePass(String pass, Long idCC) {
		String hashedPassword = securityvirementRepo.findPassCompte(idCC);
		if (bCryptPasswordEncoder.matches(pass, hashedPassword)) {
		   return true;
		} else {
		    return false;
		}
	}
	
	
	
	
	
	    
	


	
	
	
	
}
