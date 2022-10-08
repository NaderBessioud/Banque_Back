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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOP")
	private long idOP;
	@Column(name = "type")
	private String type;
	@Column(name = "montant")
	private float montant;
	@Temporal(TemporalType.DATE)
    @Column(name = "date")
	private Date date;
	
	@ManyToOne
	private Portfeuille portfeuilleo;
	
	@OneToMany(mappedBy = "operationa")
	private Set<Action> actions;

}
