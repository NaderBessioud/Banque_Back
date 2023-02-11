package tn.banque.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMe")
	private long idMe;
	@Column(name = "content")
	private String content;
	@Column(name = "date")
	private Date date;
	@Column(name = "hour")
	private String hour; 
	
	@ManyToOne
	@JoinColumn(name="sender")
	private User sender;
	
	@ManyToOne
	@JoinColumn(name="receiver")
	private User receiver;
	
	@Transient
	private String dateForTaday;
	
	@Transient
	private String dateFormat;

	public long getIdMe() {
		return idMe;
	}

	public void setIdMe(long idMe) {
		this.idMe = idMe;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getDateForTaday() {
		return dateForTaday;
	}

	public void setDateForTaday(String dateForTaday) {
		this.dateForTaday = dateForTaday;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	
	
}
