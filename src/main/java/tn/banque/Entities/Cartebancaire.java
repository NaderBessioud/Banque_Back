package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cartebancaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCB")
	private long idCB;
@Column(name = "plafondmois")
private float plafondmois;
@Column(name = "plafondsemaine")
private float plafondsemaine;
@Column(name = "typec")
private String typec;
@Column(name = "fraiscb")
private float fraiscb;
@Column(name = "prixcb")
private float prixcb;
@Column(name = "debitcb")
private float debitcb;

@OneToOne
private Comptecourrant compte;
	

}
