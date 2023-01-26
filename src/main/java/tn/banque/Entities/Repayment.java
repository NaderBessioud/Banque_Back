package tn.banque.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Repayment")
@Getter
@Setter
public class Repayment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	@Temporal(TemporalType.DATE)
	private Date Term ;
	private double amount ;
	private boolean state;
	
	public Repayment() {
		super();
	}
	@ManyToOne
  	private Credits credit;
	
	
	 
	
	public Repayment(Date term, double amount, boolean state, Credits credit) {
		super();
		Term = term;
		this.amount = amount;
		this.state = state;
		this.credit = credit;
	}
	
	
}

