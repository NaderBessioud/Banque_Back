package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bilansemestrial {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBS")
	private long idBS;
	
	@ManyToOne
	private Bilan bilans;
}
