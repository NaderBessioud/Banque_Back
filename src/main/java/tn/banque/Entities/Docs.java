package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Docs {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDOC")
	private long idDOC;
	@Column(name = "titre")
	private String titre;
	@Column(name = "image")
	private String image;
	
	@ManyToOne
	private Credit creditdoc;
	

}
