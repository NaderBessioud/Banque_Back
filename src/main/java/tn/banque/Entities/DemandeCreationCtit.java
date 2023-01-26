package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DemandeCreationCtit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddemande")
	private long iddemande;
	@Column(name = "statut")
	private boolean statut;
	@OneToOne
	private Comptebancaire comptebancaire;
	
	public long getIddemande() {
		return iddemande;
	}
	public Boolean getStatut() {
		return statut;
	}
	public void setIddemande(long iddemande) {
		this.iddemande = iddemande;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Comptebancaire getComptebancaire() {
		return comptebancaire;
	}
	public void setComptebancaire(Comptebancaire comptebancaire) {
		this.comptebancaire = comptebancaire;
	}
	public DemandeCreationCtit(long idDemande, boolean statut, Comptebancaire comptebancaire) {
		super();
		this.iddemande = idDemande;
		this.statut = statut;
		this.comptebancaire = comptebancaire;
	}
	public DemandeCreationCtit() {
		super();
	}
	
	
	
	
	

}

