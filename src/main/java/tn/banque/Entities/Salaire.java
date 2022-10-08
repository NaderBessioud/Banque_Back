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
public class Salaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalaire")
	private long idSalaire;
	@Column(name="salairebase")
	private int salairebase;
	@Temporal(TemporalType.DATE)
    @Column(name = "dataperception")
	private Date dataperception;
	@Column(name = "heuresup")
	private int heuresup;
	@Column(name = "prodheuresup")
	private float prodheuresup;
	@Column(name = "impotrevenu")
	private float impotrevenu;
	
	@ManyToOne
	private User employeesal;
	
	
	

}
