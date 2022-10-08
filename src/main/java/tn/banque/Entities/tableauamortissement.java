package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class tableauamortissement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAM")
	private long idAM;
	@Column(name = "refam")
	private String refam;
	@Column(name = "interet")
	private float interet;
	@Column(name = "capitalamorti")
	private float capitalamorti;
	@Column(name = "reste")
	private float reste;
	
	@OneToOne(mappedBy = "tableauamortissement")
	private Credit creditamm;

}
