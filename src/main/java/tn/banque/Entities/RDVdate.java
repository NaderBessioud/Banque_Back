package tn.banque.Entities;

import java.util.Date;
import java.util.List;

public class RDVdate {
	private String date;
	private List<String> heure;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public List<String> getHeure() {
		return heure;
	}
	public void setHeure(List<String> heure) {
		this.heure = heure;
	}
	public RDVdate(String date, List<String> heure) {
		super();
		this.date = date;
		this.heure = heure;
	}
	public RDVdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
