package tn.banque.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Formation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormation")
	private long idFormation;
	@Column(name="titre")
	private String titre;
	@Column(name="description")
	private String description;
	@Column(name="heure")
	private String heure;
	@Column(name="nbrparticipant")
	private String nbrparticipant;
	@Temporal(TemporalType.DATE)
    @Column(name = "date")
	private Date date;
}
