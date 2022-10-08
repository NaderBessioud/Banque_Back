package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Obligation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idO")
	private long idO;
	@Column(name = "prixemission")
	private float prixemission;
	@Column(name = "vn")
	private float vn;
	@Column(name = "maturite")
	private float maturite;
	@Column(name = "coupon")
	private float coupon;
	@Column(name = "prixrembourssement")
	private float prixrembourssement;
	@Column(name = "cours")
	private float cours;
	
	@OneToOne(mappedBy = "comptebancairet")
	private Comptetitre comptetitreo;

}
