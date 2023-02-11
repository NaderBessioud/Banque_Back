package tn.banque.Entities;

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
public class Conge {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConge")
	private long idConge;
	@Temporal(TemporalType.DATE)
    @Column(name = "datedebut")
	private Date datedebut;
	@Temporal(TemporalType.DATE)
    @Column(name = "datefin")
	private Date datefin;
	private Boolean statut=false;
	private String description;
	
	
	@ManyToOne
	private User employeecon;

	public long getIdConge() {
		return idConge;
	}

	public void setIdConge(long idConge) {
		this.idConge = idConge;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getEmployeecon() {
		return employeecon;
	}

	public void setEmployeecon(User employeecon) {
		this.employeecon = employeecon;
	}

	public Conge(long idConge, Date datedebut, Date datefin, Boolean statut, String description, User employeecon) {
		super();
		this.idConge = idConge;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.statut = statut;
		this.description = description;
		this.employeecon = employeecon;
	}

	public Conge() {
		super();
	}

	@Override
	public String toString() {
		return "Conge [idConge=" + idConge + ", datedebut=" + datedebut + ", datefin=" + datefin + ", statut=" + statut
				+ ", description=" + description +  "]";
	}

	

	

}
