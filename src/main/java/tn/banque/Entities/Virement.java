package tn.banque.Entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Virement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idV")
	private long idV;
	@Column(name = "ribe")
	private String ribe;
	@Column(name = "ribr")
	private String ribr;
	@Column(name = "somme")
	private float somme;
    @Column(name = "date")
	private Timestamp date;
    
    @JsonIgnore
	@ManyToOne
	Comptecourrant virementcompte;

	public long getIdV() {
		return idV;
	}

	public void setIdV(long idV) {
		this.idV = idV;
	}

	public String getRibe() {
		return ribe;
	}

	public void setRibe(String ribe) {
		this.ribe = ribe;
	}

	public String getRibr() {
		return ribr;
	}

	public void setRibr(String ribr) {
		this.ribr = ribr;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Comptecourrant getVirementcompte() {
		return virementcompte;
	}

	public void setVirementcompte(Comptecourrant virementcompte) {
		this.virementcompte = virementcompte;
	}
    
    
    
	

}
