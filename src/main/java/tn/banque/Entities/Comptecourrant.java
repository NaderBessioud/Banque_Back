package tn.banque.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comptecourrant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCC")
	private long idCC;
	@Column(name="ref")
	private String ref;
	@Column(name="rib")
	private String rib;
	@Column(name="solde")
	private float solde;
	
	
	
	@ManyToOne
	Cartebancaire carteB;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="comptecourrantO")
	private Set<Operationbancaire> operationbancaire;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="virementcompte")
	private Set<Virement> virements;
	
    @JsonIgnore
	@OneToOne(mappedBy="compte")
	private SecurityVirement secVir;
	
@JsonIgnore
	@OneToOne(mappedBy="comptecourrantbancaire")
	private Comptebancaire comptebancairecourrant;

public long getIdCC() {
	return idCC;
}

public void setIdCC(long idCC) {
	this.idCC = idCC;
}

public String getRef() {
	return ref;
}

public void setRef(String ref) {
	this.ref = ref;
}

public String getRib() {
	return rib;
}

public void setRib(String rib) {
	this.rib = rib;
}

public float getSolde() {
	return solde;
}

public void setSolde(float solde) {
	this.solde = solde;
}

public Cartebancaire getCarteB() {
	return carteB;
}

public void setCarteB(Cartebancaire carteB) {
	this.carteB = carteB;
}

public Set<Operationbancaire> getOperationbancaire() {
	return operationbancaire;
}

public void setOperationbancaire(Set<Operationbancaire> operationbancaire) {
	this.operationbancaire = operationbancaire;
}

public Set<Virement> getVirements() {
	return virements;
}

public void setVirements(Set<Virement> virements) {
	this.virements = virements;
}

public SecurityVirement getSecVir() {
	return secVir;
}

public void setSecVir(SecurityVirement secVir) {
	this.secVir = secVir;
}

public Comptebancaire getComptebancairecourrant() {
	return comptebancairecourrant;
}

public void setComptebancairecourrant(Comptebancaire comptebancairecourrant) {
	this.comptebancairecourrant = comptebancairecourrant;
}
	


	

}
