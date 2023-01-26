package tn.banque.Services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import tn.banque.Entities.Conge;
import tn.banque.Entities.User;
import tn.banque.Repositories.CongeRespository;
import tn.banque.Repositories.UserRepo;


@Service
public class CongeServiceImpl implements CongeService {
	
	
	@Autowired
	CongeRespository congeRespository;
	@Autowired
	UserRepo userRespository;
	
	@Autowired
	ServiceAllEmail emailService;
	@Override
	public Conge ajouter_Conge(Conge c,Long idU) {
		
		User u=userRespository.findById(idU).get();
if (calcul_conge(idU)<30) {
	c.setEmployeecon(u);
	return congeRespository.save(c);
		}
else 
	return null;
	}

	@Override
	public Conge modifier_Conge(Conge c, Long idc) {
		
		c.setIdConge(idc);
		
		return congeRespository.save(c);
	}

	@Override
	public List<Conge> all_Conge() {
		List<Conge> list=congeRespository.findAll();
		return list;
	}

	@Override
	public Conge afficher_Conge(Long idc) {
		Conge conge=congeRespository.findById(idc).orElse(null);
		return conge;
	}

	@Override
	public void SupprimerConge(Long idc) {
		congeRespository.deleteById(idc);
		
	}

	
	@Override
	public void accepter_conge(Long idc , String body , String email) throws MessagingException {
		Conge c=congeRespository.findById(idc).get();
		
			c.setStatut(true);
		
		
		congeRespository.save(c);
		emailService.sendAllertReport(body, email);

		
	}

	@Override
	public int calcul_conge(Long idU) {
		User u=userRespository.findById(idU).get();
		int n=0;

		for (Conge conge : u.getConges()) {
			if (conge.getStatut()==true) {
				
			
			 LocalDate local1=((Date) conge.getDatedebut()).toLocalDate();
			 LocalDate local2=((Date) conge.getDatefin()).toLocalDate();

			int days = (int) ChronoUnit.DAYS.between(local1, local2);
			n=n+days;
			}					
		}
	
		return n;
	}
	@Override
	public List<Conge> retrieveAllCangeNonAccepter() {
		List<Conge> list=(List<Conge>) congeRespository.findAll();
  		 Stream<Conge> lo_s = list.stream().filter(
  					 Conge -> Conge.getStatut().equals(false)
  					);
  		List<Conge> lo_list = lo_s.collect(Collectors.toList());
  			
  			return lo_list ;
  	}

	@Override
	public List<Conge> retrieveAllSliceAccepter() {
		List<Conge> list=(List<Conge>) congeRespository.findAll();
 		 Stream<Conge> lo_s = list.stream().filter(
 					 Conge -> Conge.getStatut().equals(true)
 					);
 		List<Conge> lo_list = lo_s.collect(Collectors.toList());
 			
 			return lo_list ;
	}

}
