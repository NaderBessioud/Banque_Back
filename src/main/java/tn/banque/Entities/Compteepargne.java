package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compteepargne {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCE")
	private long idCE;
	@Column(name = "typeepargne")
	private TypeEpargne typeEpargne;
	@Column(name = "tauxint")
	private float tauxint;
	@Column(name = "depotmin")
	private float depotmin;
	@Column(name = "solde")
	private float solde;
	@Column(name = "imposition")
	private String imposition;
	@Column(name = "typecb")
	private TypeCB typecb;
	
	@ManyToOne
	private Comptebancaire comptebancairee;

}
