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
public class EntretienClient implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEntretienClient;
	private String TypeEntretien;
	private Date dateEntretien;
	private float TJM;
	private String remarque;
	private String nomDuClient;
	private String lieu;
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;
	
	public Long getIdEntretienClient() {
		return idEntretienClient;
	}

	public void setIdEntretienClient(Long idEntretienClient) {
		this.idEntretienClient = idEntretienClient;
	}

	public String getTypeEntretienClient() {
		return TypeEntretien;
	}

	public void setTypeEntretienClient(String typeEntretienClient) {
		TypeEntretien = typeEntretienClient;
	}

	public Date getDateEntretienClient() {
		return dateEntretien;
	}

	public void setDateEntretienClient(Date dateEntretienClient) {
		this.dateEntretien= dateEntretienClient;
	}

	public float getTJM() {
		return TJM;
	}

	public void setTJM(float tJM) {
		TJM = tJM;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public EntretienClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public String getNomDuClient() {
		return nomDuClient;
	}

	public void setNomDuClient(String nomDuClient) {
		this.nomDuClient = nomDuClient;
	}

	public EntretienClient(Long idEntretienClient, String typeEntretienClient, Date dateEntretienClient, float tJM,
			String remarque, String nomDuClient, String lieu, Consultant consultant) {
		super();
		this.idEntretienClient = idEntretienClient;
		TypeEntretien= typeEntretienClient;
		this.dateEntretien= dateEntretienClient;
		TJM = tJM;
		this.remarque = remarque;
		this.nomDuClient = nomDuClient;
		this.lieu = lieu;
		this.consultant = consultant;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	

	
}
