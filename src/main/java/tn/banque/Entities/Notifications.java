package tn.banque.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notifications {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotif")
	private long idNotif;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="date")
	private Date date;
	@Column(name="vu")
	private boolean vu;
	@ManyToOne
	
	private User user;
	
	
	 
	 
	 public long getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(long idNotif) {
		this.idNotif = idNotif;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notifications(String title,String content,boolean vu,Date d) {
	        
	        this.content=content;
	        this.title=title;
	        this.vu=vu;
	        this.date=d;
	    }
	  
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isVu() {
			return vu;
		}

		public void setVu(boolean vu) {
			this.vu = vu;
		}

		public Notifications() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		
		
	    
	    

}
