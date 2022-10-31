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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "conge")
	private boolean conge;
	
	@OneToOne
	private Patrimoine patrimoine;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private Set<RDV> employeerdv;
	
	@JsonIgnore
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

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long idEmployee) {
		super();
		this.idEmployee = idEmployee;
	}

	public long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public TypeEmployee getRole() {
		return role;
	}

	public void setRole(TypeEmployee role) {
		this.role = role;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public Date getDatanaissance() {
		return datanaissance;
	}

	public void setDatanaissance(Date datanaissance) {
		this.datanaissance = datanaissance;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public boolean isConge() {
		return conge;
	}

	public void setConge(boolean conge) {
		this.conge = conge;
	}

	public Patrimoine getPatrimoine() {
		return patrimoine;
	}

	public void setPatrimoine(Patrimoine patrimoine) {
		this.patrimoine = patrimoine;
	}

	@JsonIgnore
	public Set<RDV> getEmployeerdv() {
		return employeerdv;
	}

	public void setEmployeerdv(Set<RDV> employeerdv) {
		this.employeerdv = employeerdv;
	}

	@JsonIgnore
	public Set<RDV> getClientrdv() {
		return clientrdv;
	}

	public void setClientrdv(Set<RDV> clientrdv) {
		this.clientrdv = clientrdv;
	}

	public Set<Salaire> getSalaires() {
		return salaires;
	}

	public void setSalaires(Set<Salaire> salaires) {
		this.salaires = salaires;
	}

	public Set<Conge> getConges() {
		return conges;
	}

	public void setConges(Set<Conge> conges) {
		this.conges = conges;
	}

	public Set<Credit> getCredits() {
		return credits;
	}

	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}

	public Set<Comptebancaire> getComptebancaires() {
		return comptebancaires;
	}

	public void setComptebancaires(Set<Comptebancaire> comptebancaires) {
		this.comptebancaires = comptebancaires;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
