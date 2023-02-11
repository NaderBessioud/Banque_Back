package tn.banque.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

@Entity

public class Obligation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idO")
	private long idO;
	@Column(name = "prixemission")
	private float prixemission;
	@Column(name = "vn")
	private float vn;
	@Column(name = "maturite")
	private float maturite;
	@Column(name = "coupon")
	private float coupon;
	@Column(name = "prixrembourssement")
	private float prixrembourssement;
	@Column(name = "cours")
	private float cours;
	@Column(name="emetteur")
	private String emetteur;
	@Column(name="description")
	private String description;
	@Column(name="imageob")
	private String imageob;
	@Column(name="frequencecoupon")
	private String frequencecoupon;
	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal (TemporalType.DATE)
	@Column(name = "dateemission")
	private Date dateemission;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="obligations", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Comptetitre> comptetitres;

	public Set<Comptetitre> getComptetitres() {
		return comptetitres;
	}

	public void setComptetitres(Set<Comptetitre> comptetitres) {
		this.comptetitres = comptetitres;
	}

	public long getIdO() {
		return idO;
	}

	public void setIdO(long idO) {
		this.idO = idO;
	}

	public float getPrixemission() {
		return prixemission;
	}

	public void setPrixemission(float prixemission) {
		this.prixemission = prixemission;
	}

	public float getVn() {
		return vn;
	}

	public void setVn(float vn) {
		this.vn = vn;
	}

	public float getMaturite() {
		return maturite;
	}

	public Date getDateemission() {
		return dateemission;
	}

	public void setDateemission(Date dateemission) {
		this.dateemission = dateemission;
	}

	public void setMaturite(float maturite) {
		this.maturite = maturite;
	}

	public float getCoupon() {
		return coupon;
	}

	public void setCoupon(float coupon) {
		this.coupon = coupon;
	}

	public float getPrixrembourssement() {
		return prixrembourssement;
	}

	public void setPrixrembourssement(float prixrembourssement) {
		this.prixrembourssement = prixrembourssement;
	}

	public float getCours() {
		return cours;
	}

	public void setCours(float cours) {
		this.cours = cours;
	}


	
	public String getImageob() {
		return imageob;
	}

	public void setImageob(String imageob) {
		this.imageob = imageob;
	}

	

	public String getFrequencecoupon() {
		return frequencecoupon;
	}

	public void setFrequencecoupon(String frequencecoupon) {
		this.frequencecoupon = frequencecoupon;
	}

	public Obligation() {
		super();
	}

	public Obligation(long idO, float prixemission, float vn, float maturite, float coupon, float prixrembourssement,
			float cours, String emetteur, String description, String imageob, String frequencecoupon,
			Date dateemission) {
		super();
		this.idO = idO;
		this.prixemission = prixemission;
		this.vn = vn;
		this.maturite = maturite;
		this.coupon = coupon;
		this.prixrembourssement = prixrembourssement;
		this.cours = cours;
		this.emetteur = emetteur;
		this.description = description;
		this.imageob = imageob;
		this.frequencecoupon = frequencecoupon;
		this.dateemission = dateemission;
	}


}
