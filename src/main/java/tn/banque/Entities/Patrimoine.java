package tn.banque.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patrimoine {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPAT")
	private long idPAT;
	@Column(name = "ref")
	private String ref;
	
	@OneToMany(mappedBy = "patrimoine")
	private Set<Patrimoinefinancier> patrimoinefinanciers;
	
	@OneToMany(mappedBy = "patrimoine")
	private Set<Patrimoineimmobilier> patrimoineimmobiliers ;
	
	@OneToMany(mappedBy = "patrimoine")
	private Set<Suivipatrimoine> suivipatrimoines;
	
	@OneToOne(mappedBy = "patrimoine")
	private User user;
	
	

}
