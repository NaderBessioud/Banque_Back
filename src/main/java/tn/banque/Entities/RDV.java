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
public class RDV {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRDV")
	private long idRDV;
	@Column(name = "heure")
	private long heure;
	@Temporal(TemporalType.DATE)
    @Column(name = "daterdv")
	private Date daterdv;
	@Column(name = "typerdv")
	private TypeRDV typerdv;
	
	@ManyToOne
	private User employee;
	
	@ManyToOne
	private User client;
	
	

}
