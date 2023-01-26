package tn.banque.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Action {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAC")
	private long idAC;
	@Column(name = "titre")
	private String titre;
	@Column(name = "prix")
	private float prix;
	@Column(name = "nombre")
	private int nombre;
	@Column(name = "type")
	private String type;
	@Column(name = "total")
	private float total;
	public long getIdAC() {
		return idAC;
	}
	public void setIdAC(long idAC) {
		this.idAC = idAC;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	

}
