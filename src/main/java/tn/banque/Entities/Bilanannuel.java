package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Bilanannuel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBA")
	private long idBA;
	
	@ManyToOne
	private Bilan bilana;
	
	@OneToOne
	private Rapportbilan rapportbilan;

}
