package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Strategie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idST")
	private long idST;
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "strategie")
	private Suivipatrimoine suivipatrimoine;

}
