package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Document {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDOC")
	private long idDOC;
	@Column(name = "image")
	private String image;
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	private Patrimoineimmobilier patrimoineimmobilier;
	
	@ManyToOne
	private Patrimoinefinancier patrimoinefinancier;
	

}
