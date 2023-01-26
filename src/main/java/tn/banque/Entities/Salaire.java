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

@Entity
public class Salaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalaire")
	private long idSalaire;
	@Column(name="salairebase")
	private int salairebase;
	@Column(name="salairenet")
	private float salairenet;
	@Temporal(TemporalType.DATE)
    @Column(name = "dataperception")
	private Date dataperception;
	@Column(name = "heuresup")
	private int heuresup;
	@Column(name = "prodheuresup")
	private float prodheuresup;
	@Column(name = "impotrevenu")
	private float impotrevenu;
	
	@ManyToOne
	private User employeesal;

	public long getIdSalaire() {
		return idSalaire;
	}

	public void setIdSalaire(long idSalaire) {
		this.idSalaire = idSalaire;
	}

	public int getSalairebase() {
		return salairebase;
	}

	public void setSalairebase(int salairebase) {
		this.salairebase = salairebase;
	}

	public float getSalairenet() {
		return salairenet;
	}

	public void setSalairenet(float salairenet) {
		this.salairenet = salairenet;
	}

	public Date getDataperception() {
		return dataperception;
	}

	public void setDataperception(Date dataperception) {
		this.dataperception = dataperception;
	}

	public int getHeuresup() {
		return heuresup;
	}

	public void setHeuresup(int heuresup) {
		this.heuresup = heuresup;
	}

	public float getProdheuresup() {
		return prodheuresup;
	}

	public void setProdheuresup(float prodheuresup) {
		this.prodheuresup = prodheuresup;
	}

	public float getImpotrevenu() {
		return impotrevenu;
	}

	public void setImpotrevenu(float impotrevenu) {
		this.impotrevenu = impotrevenu;
	}

	public User getEmployeesal() {
		return employeesal;
	}

	public void setEmployeesal(User employeesal) {
		this.employeesal = employeesal;
	}
	
	
	
	
	
	

}
