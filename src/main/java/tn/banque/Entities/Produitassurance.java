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
public class Produitassurance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPA")
	private long idPa;
	@Column(name = "nomassurance")
	private String nomassurance;
	@Column(name = "typeassurance")
	private String typeassurance;
	@Column(name = "prime")
	private float prime;
	@Column(name = "retrocomission")
	private float retrocomission;
	@Temporal(TemporalType.DATE)
    @Column(name = "createdat")
	private Date createdat;
	
	@ManyToOne
	private Credit creditassu;
}
