package tn.banque.Entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Credits")

public class Credits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	private float amount;
	private float returnedAmount;	 
	@Enumerated(EnumType.STRING)
	private JobActivity jobActivity;
	@Enumerated(EnumType.STRING)
	private CreditState state ;
	@Temporal(TemporalType.DATE)
	private Date startDate ;
	@Temporal(TemporalType.DATE)
	private Date birthday ;
	
	@Column(name = "dureect")
	private float dureect;
	
	@Column(name = "montatassurance")
	private float montantassurance;

	@Enumerated(EnumType.STRING)
	private Gender gender ; 
	
	private int Duration_months; 
	private boolean recoveryState;
	private float interestRate;

	private Long agent_credit;
	

 	@ManyToOne
 	private Offer offer;
	
	@ManyToOne
	private User clientcr;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "credit")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
 	private Set<Repayment> repayment;
	




	public Long getID() {
		return ID;
	}




	public void setID(Long iD) {
		ID = iD;
	}




	public float getAmount() {
		return amount;
	}




	public void setAmount(float amount) {
		this.amount = amount;
	}




	public float getReturnedAmount() {
		return returnedAmount;
	}




	public void setReturnedAmount(float returnedAmount) {
		this.returnedAmount = returnedAmount;
	}




	public JobActivity getJobActivity() {
		return jobActivity;
	}




	public void setJobActivity(JobActivity jobActivity) {
		this.jobActivity = jobActivity;
	}




	public CreditState getState() {
		return state;
	}




	public void setState(CreditState state) {
		this.state = state;
	}




	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getBirthday() {
		return birthday;
	}




	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}




	public Gender getGender() {
		return gender;
	}




	public void setGender(Gender gender) {
		this.gender = gender;
	}




	public int getDuration_months() {
		return Duration_months;
	}




	public void setDuration_months(int duration_months) {
		Duration_months = duration_months;
	}




	public boolean isRecoveryState() {
		return recoveryState;
	}




	public void setRecoveryState(boolean recoveryState) {
		this.recoveryState = recoveryState;
	}




	public float getInterestRate() {
		return interestRate;
	}




	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}




	public Long getAgent_credit() {
		return agent_credit;
	}




	public void setAgent_credit(Long agent_credit) {
		this.agent_credit = agent_credit;
	}




	public Offer getOffer() {
		return offer;
	}




	public void setOffer(Offer offer) {
		this.offer = offer;
	}




	public User getClientcr() {
		return clientcr;
	}




	public void setClientcr(User clientcr) {
		this.clientcr = clientcr;
	}




	public Set<Repayment> getRepayment() {
		return repayment;
	}




	public void setRepayment(Set<Repayment> repayment) {
		this.repayment = repayment;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public float getMontantassurance() {
		return montantassurance;
	}




	public void setMontantassurance(float montantassurance) {
		this.montantassurance = montantassurance;
	}




	public float getDureect() {
		return dureect;
	}




	public void setDureect(float dureect) {
		this.dureect = dureect;
	}
	
	
	
 
	
	
	
	
}
