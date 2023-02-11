package tn.banque.Entities;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Operationbancaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOB")
	private long idOB;
	@Column(name="typeoperation")
	private TypeOperation typeoperation;
	@Column(name = "somme")
	private long somme;
	@Column(name = "createdAt")
	private Timestamp createdAt;
	@Column(name = "immediat")
	private boolean immediat;
	@Column(name = "differe")
	private boolean differe;
	
	@ManyToOne
	Comptecourrant comptecourrantO;
	
	
	
}
