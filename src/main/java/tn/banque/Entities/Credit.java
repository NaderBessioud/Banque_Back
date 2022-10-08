package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Credit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idC")
	private long idC;
	@Column(name = "refc")
	private String refc;
	@Column(name = "tauxinteret")
	private float tauxinteret;
	@Column(name = "typecredit")
	private TypeCredit typecredit;
	@Column(name = "revenuannuel")
	private float revenuannuel;
	@Column(name = "montantdem")
	private float montantdem;
	@Column(name = "dureect")
	private float dureect;
	@Column(name = "statutdemande")
	private boolean statutdemande;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "datedemande")
	private Date datedemande;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "dateapprove")
	private Date dateapprove;
	
	@ManyToOne
	private User clientcr;
	
	@OneToMany(mappedBy = "creditassu")
	private Set<Produitassurance> passur;
	
	@OneToOne
	private tableauamortissement tableauamortissement;
	
	@OneToMany(mappedBy = "creditdoc")
	private Set<Docs> docs;
	

}
