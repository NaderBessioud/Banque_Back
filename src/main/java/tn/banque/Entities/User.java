package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@Column(name="approved")
	private boolean approved;
	
	@Column(name="fumer")
	private boolean fumer;
	@Column(name="salaire")
	private float salaire;
	
	@Transient
	private String token;
	
	
	@JsonIgnore
	@OneToOne
	private Patrimoine patrimoine;
	
	@JsonIgnore
	@ManyToMany 
	private Set<Produitassurance> produitassurances;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private Set<RDV> employeerdv;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sender")
	private Set<Message> sendermessages;
	
	@JsonIgnore
	@OneToMany(mappedBy ="receiver")
	private Set<Message> receivermessages;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private Set<RDV> clientrdv;
	@JsonIgnore
	@OneToMany(mappedBy = "employeesal")
	private Set<Salaire> salaires;
	@JsonIgnore
	@OneToMany(mappedBy = "employeecon")
	private Set<Conge> conges;
	
	
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="usercomptebancaire")
	private Set<Comptebancaire> comptebancaireuser;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Notifications> notifications;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	private Set<Formation> formations;
	
	@Transient
	private boolean online;
	
	

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
	
	@OneToMany(mappedBy = "clientcr")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Credits> credits;
	

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



	public Set<Credits> getCredits() {
		return credits;
	}

	public void setCredits(Set<Credits> credits) {
		this.credits = credits;
	}

	

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isFumer() {
		return fumer;
	}

	public void setFumer(boolean fumer) {
		this.fumer = fumer;
	}

	public Set<Notifications> getNotifications() {
		return notifications;
	}

	@JsonIgnore
	public void setNotifications(Set<Notifications> notifications) {
		this.notifications = notifications;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "User [idEmployee=" + idEmployee + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", addresse=" + addresse + ", telephone=" + telephone + ", email=" + email + ", ville=" + ville
				+ ", quartier=" + quartier + ", codepostal=" + codepostal + ", role=" + role + ", pays=" + pays
				+ ", CIN=" + CIN + ", datanaissance=" + datanaissance + ", createdat=" + createdat + ", conge=" + conge
				+ ", approved=" + approved + ", fumer=" + fumer + ", salaire=" + salaire + ", online=" + online + "]";
	}

	public Set<Produitassurance> getProduitassurances() {
		return produitassurances;
	}

	public void setProduitassurances(Set<Produitassurance> produitassurances) {
		this.produitassurances = produitassurances;
	}

	public Set<Message> getSendermessages() {
		return sendermessages;
	}

	public void setSendermessages(Set<Message> sendermessages) {
		this.sendermessages = sendermessages;
	}

	public Set<Message> getReceivermessages() {
		return receivermessages;
	}

	public void setReceivermessages(Set<Message> receivermessages) {
		this.receivermessages = receivermessages;
	}

	public Set<Comptebancaire> getComptebancaireuser() {
		return comptebancaireuser;
	}

	public void setComptebancaireuser(Set<Comptebancaire> comptebancaireuser) {
		this.comptebancaireuser = comptebancaireuser;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
