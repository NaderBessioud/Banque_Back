package tn.banque.Services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Cartebancaire;
import tn.banque.Entities.Comptebancaire;
import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.User;
import tn.banque.Repositories.CompteCourrantRepository;
import tn.banque.Repositories.ComptebancaireRepository;
import tn.banque.Repositories.UserRepo;


@Service
public class ComptebancaireService implements IComptebancaireService {
@Autowired
ComptebancaireRepository comptebancaireRepo;
@Autowired
UserRepo userRepo;
@Autowired
CompteCourrantRepository comptecourrantRepo;
@Autowired
IComptecourrantService iComptecourrantService;



@Override
public
Comptebancaire addCompteBancaire(Comptebancaire comptebancaire, Long idU ) {
	User user = userRepo.findById(idU).orElse(null);
	comptebancaire.setUsercomptebancaire(user);
	comptebancaire.setClcomptes(user);
	comptebancaireRepo.save(comptebancaire);
	Date date1 = new Date();
    ZoneId timeZone = ZoneId.systemDefault();
    LocalDate getLocalDate = date1.toInstant().atZone(timeZone).toLocalDate();
    
    
    LocalDate localDate = LocalDate.now();
    ZonedDateTime zdt = localDate.atStartOfDay(ZoneId.systemDefault());
    Date date = Date.from(zdt.toInstant());
    
 
    comptebancaire.setDateouverture(date);
    comptebancaire.setRef("B-"+getLocalDate.getYear()+"-"+comptebancaire.getIdCBA());
    comptebancaireRepo.save(comptebancaire);
    return comptebancaire;
}



@Override
public
List<User> retrieveAllUser(){
	return (List<User>) userRepo.findAll();
}

@Override
public Comptebancaire addCompteCourrantBancaire(Long idCBA , Comptecourrant comptecourrant, Long idCB) {
	Comptebancaire comptebancaire = comptebancaireRepo.findById(idCBA).orElse(null);
	//iComptecourrantService.addCompteCourrant(comptecourrant, idCB);
	comptebancaire.setComptecourrantbancaire(comptecourrant);
	comptecourrant.setComptebancairecourrant(comptebancaire);
	comptebancaireRepo.save(comptebancaire);
	comptecourrantRepo.save(comptecourrant);
	return comptebancaire;
}

@Override
public List<Comptebancaire> retrieveAllComptebancaire(){
	List<Comptebancaire> list = comptebancaireRepo.findAll();
	return list;
}



}
