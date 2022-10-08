package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comptecourrant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCC")
	private long idCC;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "fraistenu")
	private float fraistenu;
	@Column(name = "maxdecouvert")
	private float maxdecouvert;
	@Column(name = "dureedecouvert")
	private float dureedecouvert;
	@Column(name = "plafond")
	private float plafond;
	@Column(name = "solde")
	private float solde;
	@Column(name = "typecb")
	private TypeCB typecb;
	
	@ManyToOne
	private Comptebancaire comptebancairec;
	
	@OneToOne(mappedBy = "compte")
	private Cartebancaire cartebancaire;
	
	
	
	

}
