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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public long getIdCBA() {
		return idCBA;
	}

	public void setIdCBA(long idCBA) {
		this.idCBA = idCBA;
	}

	public boolean isBloquee() {
		return bloquee;
	}

	public void setBloquee(boolean bloquee) {
		this.bloquee = bloquee;
	}

	public Date getDateouverture() {
		return dateouverture;
	}

	public void setDateouverture(Date dateouverture) {
		this.dateouverture = dateouverture;
	}

	public User getClcomptes() {
		return clcomptes;
	}

	public void setClcomptes(User clcomptes) {
		this.clcomptes = clcomptes;
	}

	public Set<Comptecourrant> getComptecourrants() {
		return comptecourrants;
	}

	public void setComptecourrants(Set<Comptecourrant> comptecourrants) {
		this.comptecourrants = comptecourrants;
	}

	public Set<Compteepargne> getCompteepargnes() {
		return compteepargnes;
	}

	public void setCompteepargnes(Set<Compteepargne> compteepargnes) {
		this.compteepargnes = compteepargnes;
	}

	public Set<Virement> getVirements() {
		return virements;
	}

	public void setVirements(Set<Virement> virements) {
		this.virements = virements;
	}

	

	public Comptetitre getComptetitres() {
		return comptetitres;
	}

	public void setComptetitres(Comptetitre comptetitres) {
		this.comptetitres = comptetitres;
	}

	public DemandeCreationCtit getDemandee() {
		return demandee;
	}

	public void setDemandee(DemandeCreationCtit demandee) {
		this.demandee = demandee;
	}



	@ManyToOne
	private User clcomptes;
	
	@OneToMany(mappedBy = "comptebancairec")
	private Set<Comptecourrant> comptecourrants;
	
	@OneToMany(mappedBy = "comptebancairee")
	private Set<Compteepargne> compteepargnes;
	
	@OneToMany(mappedBy = "comptebancairev")
	private Set<Virement> virements;
	@JsonIgnore
	@OneToOne(mappedBy = "comptebancairet")
	private Comptetitre comptetitres;
	@JsonIgnore
	@OneToOne(mappedBy = "comptebancaire")
	private DemandeCreationCtit demandee;
	

}
