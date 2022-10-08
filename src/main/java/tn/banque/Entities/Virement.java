package tn.banque.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Virement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idV")
	private long idV;
	@Column(name = "RIB")
	private String RIB;
	@Column(name = "RIBR")
	private String RIBR;
	@Column(name = "somme")
	private float somme;
	@Column(name = "heure")
	private String heure;
	@Temporal(TemporalType.DATE)
    @Column(name = "date")
	private Date date;
	@Column(name = "typev")
	private TypeV typev;
	
	@ManyToOne
	private Comptebancaire comptebancairev;
	

}
