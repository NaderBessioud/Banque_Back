package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Diagnostic {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDI")
	private long idDI;
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "diagnostic")
	private Suivipatrimoine suivipatrimoine;

}
