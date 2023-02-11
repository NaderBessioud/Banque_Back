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
	@Column(name="ref")
	private String ref;
	@Column(name = "bloquee")
	private boolean bloquee;
	@Temporal(TemporalType.DATE)
    @Column(name = "dateouverture")
	private Date dateouverture;

	@ManyToOne
	private User clcomptes;
	

	
	@OneToMany(mappedBy = "comptebancairee")
	private Set<Compteepargne> compteepargnes;
	

	@JsonIgnore
	@OneToMany(mappedBy = "comptebancairet")
	private Set<Comptetitre> comptetitres;
	
	@JsonIgnore
	@ManyToOne
	User usercomptebancaire;
	
	
	@OneToOne
	private Comptecourrant comptecourrantbancaire;


	public long getIdCBA() {
		return idCBA;
	}


	public void setIdCBA(long idCBA) {
		this.idCBA = idCBA;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
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


	public Set<Compteepargne> getCompteepargnes() {
		return compteepargnes;
	}


	public void setCompteepargnes(Set<Compteepargne> compteepargnes) {
		this.compteepargnes = compteepargnes;
	}


	public Set<Comptetitre> getComptetitres() {
		return comptetitres;
	}


	public void setComptetitres(Set<Comptetitre> comptetitres) {
		this.comptetitres = comptetitres;
	}


	public User getUsercomptebancaire() {
		return usercomptebancaire;
	}


	public void setUsercomptebancaire(User usercomptebancaire) {
		this.usercomptebancaire = usercomptebancaire;
	}


	public Comptecourrant getComptecourrantbancaire() {
		return comptecourrantbancaire;
	}


	public void setComptecourrantbancaire(Comptecourrant comptecourrantbancaire) {
		this.comptecourrantbancaire = comptecourrantbancaire;
	}


	public Comptebancaire(long idCBA, String ref, boolean bloquee, Date dateouverture, User clcomptes,
			Set<Compteepargne> compteepargnes, Set<Comptetitre> comptetitres, User usercomptebancaire,
			Comptecourrant comptecourrantbancaire) {
		super();
		this.idCBA = idCBA;
		this.ref = ref;
		this.bloquee = bloquee;
		this.dateouverture = dateouverture;
		this.clcomptes = clcomptes;
		this.compteepargnes = compteepargnes;
		this.comptetitres = comptetitres;
		this.usercomptebancaire = usercomptebancaire;
		this.comptecourrantbancaire = comptecourrantbancaire;
	}


	public Comptebancaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
