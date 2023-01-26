package tn.banque.Entities;





import java.time.LocalDateTime;
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
public class RDV {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRDV")
	private long idRDV;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "daterdv")
	private Date daterdv;
    @Column(name = "heure")
	private String heure;

	@Column(name = "frais")
	private float frais;
	
	@ManyToOne
	private User employee;
	
	@ManyToOne
	private User client;

	public long getIdRDV() {
		return idRDV;
	}

	public void setIdRDV(long idRDV) {
		this.idRDV = idRDV;
	}

	
	public Date getDaterdv() {
		return daterdv;
	}

	public void setDaterdv(Date daterdv) {
		this.daterdv = daterdv;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}



	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public float getFrais() {
		return frais;
	}

	public void setFrais(float frais) {
		this.frais = frais;
	}
	
	
	
	

}
