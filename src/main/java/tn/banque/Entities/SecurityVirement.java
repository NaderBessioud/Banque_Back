package tn.banque.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SecurityVirement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSV")
	private long idSV;
	@Column(name = "pass")
	private String pass;
	
	@OneToOne
	private Comptecourrant compte;
}
