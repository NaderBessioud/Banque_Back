package tn.banque.Services;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Cartebancaire;
import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.SecurityVirement;
import tn.banque.Repositories.CarteBancaireRepository;
import tn.banque.Repositories.CompteCourrantRepository;
import tn.banque.Repositories.ComptebancaireRepository;
import tn.banque.Repositories.SecurityVirementRepository;
import tn.banque.Repositories.UserRepo;


@Service
public class ComptecourrantService implements IComptecourrantService{

	@Autowired
	CompteCourrantRepository comptecourrantRepo;
	@Autowired
	CarteBancaireRepository carteRepo;
	@Autowired
	SecurityVirementRepository securityVirementRepo;
	  @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	  @Autowired
	  private JavaMailSender javaMailSender;
	  @Autowired
	  ComptebancaireRepository comptebancaireRepo;
	  @Autowired
	  UserRepo userRepo;

	  public void sendEmail(String to, String subject, String body) {
	      MimeMessage message = javaMailSender.createMimeMessage();

	      try {
	          MimeMessageHelper helper = new MimeMessageHelper(message, true);
	          helper.setTo(to);
	          helper.setSubject(subject);
	          helper.setText(body, true);
	          javaMailSender.send(message);
	      } catch (MessagingException e) {
	          e.printStackTrace();
	      }
	  }
	public String getRandomStr(int n) 
    {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "0123456789"; 
  
        StringBuilder s = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
            int index = (int)(str.length() * Math.random()); 
            s.append(str.charAt(index)); 
        } 
        return s.toString(); 
    } 
	
	
	
	public String getRandomStrVirement(int n) 
    {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz"+"0123456789"; 
  
        StringBuilder s = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
            int index = (int)(str.length() * Math.random()); 
            s.append(str.charAt(index)); 
        } 
        return s.toString(); 
    } 
	
	
	
	@Override
	public
	Comptecourrant addCompteCourrant(Comptecourrant comptecourrant, Long idCB, Long idCBA) {
		
		
		
		// recherche carte bancaire 
		Cartebancaire carte = carteRepo.findById(idCB).orElse(null);
		//set carte bancaire
		comptecourrant.setCarteB(carte);
		// mise a jour du solde
		if(carte.getPrix()>0) {
			comptecourrant.setSolde(-carte.getPrix());
		}
		// save entity
		comptecourrantRepo.save(comptecourrant);
		// set reference et rib d'un compte courrant
		
		//set rib
		 int len = 11; 
		comptecourrant.setRib(getRandomStr(len));

		
		Date date1 = new Date();
	    ZoneId timeZone = ZoneId.systemDefault();
	    LocalDate getLocalDate = date1.toInstant().atZone(timeZone).toLocalDate();
	    comptecourrant.setRef("C-"+getLocalDate.getYear()+"-"+comptecourrant.getIdCC());
	    //save entity
	    comptecourrantRepo.save(comptecourrant);
	    Comptebancaire comptebancaire = comptebancaireRepo.findById(idCBA).orElse(null);
		comptebancaire.setComptecourrantbancaire(comptecourrant);
		comptecourrant.setComptebancairecourrant(comptebancaire);
		comptebancaireRepo.save(comptebancaire);
		comptecourrantRepo.save(comptecourrant);
	    // Security virement 
	    SecurityVirement securityVirement = new SecurityVirement();
	    int len1=7;
	    String pass = getRandomStrVirement(len1);
	    do {
	    	pass = getRandomStrVirement(len1);
	    }while(securityVirementRepo.findPass(pass) != null);
	    String emailUser = comptecourrantRepo.EmailByComptecourrant(comptecourrant.getIdCC());
	    sendEmail(emailUser, "Votre banque", "Cher client, voici votre code de sécurité pour les virements :"+pass+"\n Veuillez ne pas perdre de code");
	    
	    System.out.println(pass);
	  String encryptedPassword = bCryptPasswordEncoder.encode(pass);
	   
	    securityVirement.setPass(encryptedPassword);
	    securityVirement.setCompte(comptecourrant);
	    securityVirementRepo.save(securityVirement);
	    
	   
	    
	    
	    return comptecourrant;
	}


	@Override
	public
	List<Comptecourrant> retrieveAllCompteCourrant(){
		return comptecourrantRepo.findAll();
		
	}
	
	
	@Override
	public
	Comptecourrant retrieveCompteCourrant(Long idCC) {
		Comptecourrant compte = comptecourrantRepo.findById(idCC).orElse(null);
		return compte;
	}

}
