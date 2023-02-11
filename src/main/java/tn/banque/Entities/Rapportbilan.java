package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rapportbilan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRB")
	private long idRB;
	@Column(name = "contenu")
	private String contenu;
	
	@OneToOne(mappedBy = "rapportbilan")
	private Bilanannuel bilanannuel;

}
