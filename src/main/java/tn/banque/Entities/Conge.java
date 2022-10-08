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
public class Conge {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConge")
	private long idConge;
	@Temporal(TemporalType.DATE)
    @Column(name = "datedebut")
	private Date datedebut;
	@Temporal(TemporalType.DATE)
    @Column(name = "datefin")
	private Date datefin;
	
	@ManyToOne
	private User employeecon;
	

}
