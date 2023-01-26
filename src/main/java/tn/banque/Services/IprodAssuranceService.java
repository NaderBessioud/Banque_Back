package tn.banque.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.banque.Entities.Produitassurance;


@Service
public interface IprodAssuranceService {
	public  Produitassurance Ajouteruser(Produitassurance u);
	public  Produitassurance Updateeruser(Produitassurance u);
	public void DeleteUser(Long u);
	public List<Produitassurance>  DisplayAssurance();
	public Double getMontantCreditAssuranceapayer(Long c);



}
