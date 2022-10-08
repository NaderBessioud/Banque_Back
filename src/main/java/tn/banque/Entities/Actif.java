package tn.banque.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actif {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAC")
	private long idAC;
	@Column(name = "titre")
	private String titre;
	@Column(name = "valeur")
	private float valeur;
	
	@ManyToMany(mappedBy = "actifs")
	private Set<Bilan> bilans;
	
	
	

}
