package tn.banque.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Comptetitre {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCT")
	private long idCT;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "fraiscourtage")
	private float fraiscourtage;
	@Column(name = "fraistenu")
	private float fraistenu;
	@Column(name = "fraisOPCVM")
	private float fraisOPCVM;
	@Column(name = "solde")
	private float solde;
	
	@ManyToOne
	private Comptebancaire comptebancairet;
	
	@OneToOne
	private Obligation obligation;
	
	@OneToMany(mappedBy = "comptetitrep")
	private Set<Portfeuille> portfeuilles;

}
