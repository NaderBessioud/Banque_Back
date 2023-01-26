package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Formation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormation")
	private long idFormation;
	@Column(name="titre")
	private String titre;
	@Column(name="description")
	private String description;
	@Column(name="heure")
	private String heure;
	
	@Column(name="nbrparticipant")
	private String nbrparticipant;
	@Temporal(TemporalType.DATE)
    @Column(name = "date")
	private Date date;
	//@JsonIgnore
	@ManyToMany()
	private Set<User> users;
	
	
	public long getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(long idFormation) {
		this.idFormation = idFormation;
	}
	public String getTitre() {
		return titre;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	public String getNbrparticipant() {
		return nbrparticipant;
	}
	public void setNbrparticipant(String nbrparticipant) {
		this.nbrparticipant = nbrparticipant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Formation(long idFormation, String titre, String description, String heure, 
			String nbrparticipant, Date date) {
		super();
		this.idFormation = idFormation;
		this.titre = titre;
		this.description = description;
		this.heure = heure;
		
		this.nbrparticipant = nbrparticipant;
		this.date = date;
	}
	public Formation() {
		super();
	}
	
	

	
}
