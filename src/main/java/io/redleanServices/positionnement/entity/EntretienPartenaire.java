package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntretienPartenaire implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEntretien;
	
	private Date dateEntretien;
	private String TypeEntretien;
	private String remarque;
	private  float TJM ;
	private String Statut;
	
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;
	
	public EntretienPartenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EntretienPartenaire(Long idEntretien, Date dateEntretien, String typeEntretien, String remarque, float tJM,
			String statut, Consultant consultant) {
		super();
		this.idEntretien = idEntretien;
		this.dateEntretien = dateEntretien;
		TypeEntretien = typeEntretien;
		this.remarque = remarque;
		TJM = tJM;
		Statut = statut;
		this.consultant = consultant;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public Long getIdEntretien() {
		return idEntretien;
	}
	public void setIdEntretien(Long idEntretien) {
		this.idEntretien = idEntretien;
	}
	public Date getDateEntretien() {
		return dateEntretien;
	}
	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}
	public String getTypeEntretien() {
		return TypeEntretien;
	}
	public void setTypeEntretien(String typeEntretien) {
		TypeEntretien = typeEntretien;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public float getTJM() {
		return TJM;
	}
	public void setTJM(float tJM) {
		TJM = tJM;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
     
	
     
}
