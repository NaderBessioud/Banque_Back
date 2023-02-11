package tn.banque.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comptetitre {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "idCT", length = 50)
private String idCT;
@Column(name = "libelle")
private String libelle;
@Column(name = "fraiscourtage")
private float fraiscourtage;
@Column(name = "fraistenu")
private float fraistenu;
@Column(name = "fraisOPCVM")
private float fraisOPCVM;
@Column(name = "solde")
private float solde;

@JsonIgnore
@OneToOne
private Comptebancaire comptebancairet;
@JsonIgnore
@ManyToMany(cascade = CascadeType.ALL)
private Set<Obligation> obligations;
@Transactional
public Set<Obligation> getObligations() {
return obligations;
}

public void setObligations(Set<Obligation> obligations) {
this.obligations = obligations;
}



public String getIdCT() {
return idCT;
}

public void setIdCT(String idCT) {
this.idCT = idCT;
}

public String getLibelle() {
return libelle;
}

public void setLibelle(String libelle) {
this.libelle = libelle;
}

public float getFraiscourtage() {
return fraiscourtage;
}

public void setFraiscourtage(float fraiscourtage) {
this.fraiscourtage = fraiscourtage;
}

public float getFraistenu() {
return fraistenu;
}

public void setFraistenu(float fraistenu) {
this.fraistenu = fraistenu;
}

public float getFraisOPCVM() {
return fraisOPCVM;
}

public void setFraisOPCVM(float fraisOPCVM) {
this.fraisOPCVM = fraisOPCVM;
}

public float getSolde() {
return solde;
}

public void setSolde(float solde) {
this.solde = solde;
}

public Comptebancaire getComptebancairet() {
return comptebancairet;
}

public void setComptebancairet(Comptebancaire comptebancairet) {
this.comptebancairet = comptebancairet;
}






public Comptetitre(String idCT, String libelle, float fraiscourtage, float fraistenu, float fraisOPCVM, float solde,
Comptebancaire comptebancairet) {
super();
this.idCT = idCT;
this.libelle = libelle;
this.fraiscourtage = fraiscourtage;
this.fraistenu = fraistenu;
this.fraisOPCVM = fraisOPCVM;
this.solde = solde;
this.comptebancairet = comptebancairet;

}

public Comptetitre() {
super();
}






}