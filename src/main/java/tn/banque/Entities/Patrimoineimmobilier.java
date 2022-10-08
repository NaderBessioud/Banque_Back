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
public class Patrimoineimmobilier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPATI")
	private long idPATI;
	@Column(name = "valeur")
	private float valeur;
	
	@OneToMany(mappedBy = "patrimoineimmobilier")
	private Set<Document> pidocs;
	
	@ManyToOne
	private Patrimoine patrimoine;

}
