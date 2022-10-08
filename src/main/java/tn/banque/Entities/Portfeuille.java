package tn.banque.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Portfeuille {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idP")
	private long idP;
	@Column(name = "rendement")
	private float rendement;
	@Column(name = "risque")
	private float risque;
	@Column(name = "dureeinv")
	private float dureeinv;
	@Column(name = "capital")
	private float capital;
	@Column(name = "produitderive")
	private produitDerive produitderive;
	@Column(name = "strategies")
	private Strategies strategies;
	@Column(name = "titrefinancier")
	private titreFinancier titreFinancier;
	@Column(name = "typegestion")
	private typeGestion typegestion;
	
	@ManyToOne
	private Comptetitre comptetitrep;
	
	@OneToMany(mappedBy = "portfeuilleo")
	private Set<Operation> operations;
	

}
