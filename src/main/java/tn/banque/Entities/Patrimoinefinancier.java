package tn.banque.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patrimoinefinancier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPATF")
	private long idPATF;
	@Column(name = "valeur")
	private float valeur;
	
	@OneToMany(mappedBy = "patrimoinefinancier")
	private Set<Document> pfdocs;
	
	@ManyToOne
	private Patrimoine patrimoine;

}
