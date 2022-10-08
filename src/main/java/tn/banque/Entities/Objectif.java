package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Objectif {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOB")
	private long idOB;
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "objectif")
	private Suivipatrimoine suivipatrimoine;

}
