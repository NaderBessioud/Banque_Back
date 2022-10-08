package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Suivipatrimoine {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSP")
	private long idSP;
	
	@OneToOne
	private Objectif objectif;
	
	@OneToOne
	private Diagnostic diagnostic;
	
	@OneToOne
	private Strategie strategie;
	
	@ManyToOne
	private Patrimoine patrimoine;

}
