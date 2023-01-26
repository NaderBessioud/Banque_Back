package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produitassurance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPA")
	private long idPa;
	@Column(name = "nomassurance")
	private String nomassurance;
	@Column(name = "typeassurance")
	private TypeAssurance typeassurance;
	@Column(name = "prime")
	private float prime;

	@Column(name = "retrocomission")
	private float retrocomission;
	@Temporal(TemporalType.DATE)
    @Column(name = "createdat")
	private Date createdat;
	
	@ManyToMany (mappedBy = "produitassurances")
	private Set <User> listusers;

	public long getIdPa() {
		return idPa;
	}

	public void setIdPa(long idPa) {
		this.idPa = idPa;
	}

	public String getNomassurance() {
		return nomassurance;
	}

	public void setNomassurance(String nomassurance) {
		this.nomassurance = nomassurance;
	}

	public TypeAssurance getTypeassurance() {
		return typeassurance;
	}

	public void setTypeassurance(TypeAssurance typeassurance) {
		this.typeassurance = typeassurance;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public float getRetrocomission() {
		return retrocomission;
	}

	public void setRetrocomission(float retrocomission) {
		this.retrocomission = retrocomission;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public Set<User> getListusers() {
		return listusers;
	}

	public void setListusers(Set<User> listusers) {
		this.listusers = listusers;
	}
	
	
	
}
