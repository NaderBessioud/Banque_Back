package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployee")
	private long idEmployee;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="password")
	private String password;
	@Column(name="addresse")
	private String addresse;
	@Column(name="telephone")
	private String telephone;
	@Column(name="email")
	private String email;
	@Column(name="ville")
	private String ville;
	@Column(name="quartier")
	private String quartier;
	@Column(name="codepostal")
	private String codepostal;
	@Column(name="role")
	private TypeEmployee role;
	@Column(name="pays")
	private String pays;
	@Column(name="CIN")
	private String CIN;
	@Temporal(TemporalType.DATE)
    @Column(name = "datanaissance")
	private Date datanaissance;
	@Temporal(TemporalType.DATE)
    @Column(name = "createdat")
	private Date createdat;
	
	@OneToOne
	private Patrimoine patrimoine;
	
	@OneToMany(mappedBy = "employee")
	private Set<RDV> employeerdv;
	
	@OneToMany(mappedBy = "client")
	private Set<RDV> clientrdv;
	
	@OneToMany(mappedBy = "employeesal")
	private Set<Salaire> salaires;
	
	@OneToMany(mappedBy = "employeecon")
	private Set<Conge> conges;
	
	@OneToMany(mappedBy = "clientcr")
	private Set<Credit> credits;
	
	@OneToMany(mappedBy = "clcomptes")
	private Set<Comptebancaire> comptebancaires;
	
	
	
	
	
	
	
	
	
	

}
