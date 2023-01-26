package tn.banque.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cartebancaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCB")
	private long idCB;
	@Column(name="nom")
	private String nom;
	@Column(name="prix")
	private float prix;
	@Column(name="plafondmois_paiement")
	private float plafondmois_paiement;
	@Column(name="plafondsemaine_retrait")
	private float plafondsemaine_retrait;
	@Column(name="debit_immediat")
	private boolean debit_immediat;
	@Column(name="debit_differe")
	private boolean debit_differe;
	@Column(name="description")
	private String description;
	
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="carteB")
	private Set<Comptecourrant> comptecourrantB;


	public long getIdCB() {
		return idCB;
	}


	public void setIdCB(long idCB) {
		this.idCB = idCB;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public float getPlafondmois_paiement() {
		return plafondmois_paiement;
	}


	public void setPlafondmois_paiement(float plafondmois_paiement) {
		this.plafondmois_paiement = plafondmois_paiement;
	}


	public float getPlafondsemaine_retrait() {
		return plafondsemaine_retrait;
	}


	public void setPlafondsemaine_retrait(float plafondsemaine_retrait) {
		this.plafondsemaine_retrait = plafondsemaine_retrait;
	}


	public boolean isDebit_immediat() {
		return debit_immediat;
	}


	public void setDebit_immediat(boolean debit_immediat) {
		this.debit_immediat = debit_immediat;
	}


	public boolean isDebit_differe() {
		return debit_differe;
	}


	public void setDebit_differe(boolean debit_differe) {
		this.debit_differe = debit_differe;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Comptecourrant> getComptecourrantB() {
		return comptecourrantB;
	}


	public void setComptecourrantB(Set<Comptecourrant> comptecourrantB) {
		this.comptecourrantB = comptecourrantB;
	}
	
	
	
	
	

}
