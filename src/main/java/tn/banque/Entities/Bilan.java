package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bilan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBI")
	private long idBI;
	@Column(name = "totalactif")
	private float totalactif;
	@Column(name = "totalpassif")
	private float totalpassif;
	@Temporal(TemporalType.DATE)
    @Column(name = "date")
	private Date date;
	
	@OneToMany(mappedBy = "bilans")
	private Set<Bilansemestrial> bilansemestrials;
	
	@OneToMany(mappedBy = "bilana")
	private Set<Bilanannuel> bilanannuels;
	
	
	
	@ManyToMany
	private Set<Passif> passifs;
	

}
