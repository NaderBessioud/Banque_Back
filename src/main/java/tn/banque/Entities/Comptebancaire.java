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
public class Comptebancaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCBA")
	private long idCBA;
	@Column(name = "bloquee")
	private boolean bloquee;
	@Temporal(TemporalType.DATE)
    @Column(name = "dateouverture")
	private Date dateouverture;
	
	@ManyToOne
	private User clcomptes;
	
	@OneToMany(mappedBy = "comptebancairec")
	private Set<Comptecourrant> comptecourrants;
	
	@OneToMany(mappedBy = "comptebancairee")
	private Set<Compteepargne> compteepargnes;
	
	@OneToMany(mappedBy = "comptebancairev")
	private Set<Virement> virements;
	
	@OneToMany(mappedBy = "comptebancairet")
	private Set<Comptetitre> comptetitres;
	
	

}
